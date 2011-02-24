// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2010-10-09 05:21:55

package org.softlang.antlr;
import org.softlang.company.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CompanyParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "FLOAT", "WS", "'company'", "'{'", "'}'", "'department'", "'manager'", "'employee'", "'address'", "'salary'"
    };
    public static final int WS=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int FLOAT=5;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int STRING=4;

    // delegates
    // delegators


        public CompanyParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CompanyParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CompanyParser.tokenNames; }
    public String getGrammarFileName() { return "Company.g"; }



    // $ANTLR start "company"
    // Company.g:11:1: company returns [Company c] : 'company' '{' (topdept= dept )* '}' ;
    public final Company company() throws RecognitionException {
        Company c = null;

        Dept topdept = null;


        try {
            // Company.g:11:28: ( 'company' '{' (topdept= dept )* '}' )
            // Company.g:12:3: 'company' '{' (topdept= dept )* '}'
            {
             c = new Company(); 
            match(input,7,FOLLOW_7_in_company33); 
            match(input,8,FOLLOW_8_in_company35); 
            // Company.g:14:3: (topdept= dept )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Company.g:14:5: topdept= dept
            	    {
            	    pushFollow(FOLLOW_dept_in_company44);
            	    topdept=dept();

            	    state._fsp--;

            	     c.getDepts().add(topdept); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,9,FOLLOW_9_in_company60); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return c;
    }
    // $ANTLR end "company"


    // $ANTLR start "dept"
    // Company.g:20:1: dept returns [Dept d] : 'department' name= STRING '{' manager ( personunit )* (subdept= dept )* '}' ;
    public final Dept dept() throws RecognitionException {
        Dept d = null;

        Token name=null;
        Dept subdept = null;

        Employee manager1 = null;

        Employee personunit2 = null;


        try {
            // Company.g:20:22: ( 'department' name= STRING '{' manager ( personunit )* (subdept= dept )* '}' )
            // Company.g:21:3: 'department' name= STRING '{' manager ( personunit )* (subdept= dept )* '}'
            {
             d = new Dept(); 
            match(input,10,FOLLOW_10_in_dept82); 
            name=(Token)match(input,STRING,FOLLOW_STRING_in_dept86); 
            match(input,8,FOLLOW_8_in_dept88); 
             d.setName((name!=null?name.getText():null)); 
            pushFollow(FOLLOW_manager_in_dept101);
            manager1=manager();

            state._fsp--;

             d.setManager(manager1); 
            // Company.g:26:5: ( personunit )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Company.g:26:7: personunit
            	    {
            	    pushFollow(FOLLOW_personunit_in_dept115);
            	    personunit2=personunit();

            	    state._fsp--;


            	            Subunit pu = new Subunit();
            	            pu.setPu(personunit2);
            	            d.getSubunits().add(pu); 
            	          

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Company.g:33:5: (subdept= dept )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:33:7: subdept= dept
            	    {
            	    pushFollow(FOLLOW_dept_in_dept140);
            	    subdept=dept();

            	    state._fsp--;


            	            Subunit du = new Subunit();
            	            du.setDu(subdept);
            	            d.getSubunits().add(du); 
            	          

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,9,FOLLOW_9_in_dept159); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end "dept"


    // $ANTLR start "manager"
    // Company.g:43:1: manager returns [Employee e] : 'manager' employee ;
    public final Employee manager() throws RecognitionException {
        Employee e = null;

        Employee employee3 = null;


        try {
            // Company.g:43:29: ( 'manager' employee )
            // Company.g:44:3: 'manager' employee
            {
            match(input,11,FOLLOW_11_in_manager177); 
            pushFollow(FOLLOW_employee_in_manager179);
            employee3=employee();

            state._fsp--;

             e = employee3; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "manager"


    // $ANTLR start "personunit"
    // Company.g:48:1: personunit returns [Employee e] : 'employee' employee ;
    public final Employee personunit() throws RecognitionException {
        Employee e = null;

        Employee employee4 = null;


        try {
            // Company.g:48:32: ( 'employee' employee )
            // Company.g:49:3: 'employee' employee
            {
            match(input,12,FOLLOW_12_in_personunit201); 
            pushFollow(FOLLOW_employee_in_personunit203);
            employee4=employee();

            state._fsp--;

             e = employee4; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "personunit"


    // $ANTLR start "employee"
    // Company.g:53:1: employee returns [Employee e] : n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' ;
    public final Employee employee() throws RecognitionException {
        Employee e = null;

        Token n=null;
        Token a=null;
        Token s=null;

        try {
            // Company.g:53:30: (n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' )
            // Company.g:54:3: n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}'
            {
            n=(Token)match(input,STRING,FOLLOW_STRING_in_employee228); 
            match(input,8,FOLLOW_8_in_employee230); 
            match(input,13,FOLLOW_13_in_employee236); 
            a=(Token)match(input,STRING,FOLLOW_STRING_in_employee240); 
            match(input,14,FOLLOW_14_in_employee246); 
            s=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_employee250); 
            match(input,9,FOLLOW_9_in_employee254); 

                e = new Employee();
                Person p = new Person();
                p.setName((n!=null?n.getText():null));
                p.setAddress((a!=null?a.getText():null));
                e.setPerson(p);
                e.setSalary(Double.parseDouble((s!=null?s.getText():null)));
              

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "employee"

    // Delegated rules


 

    public static final BitSet FOLLOW_7_in_company33 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_company35 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_dept_in_company44 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_9_in_company60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_dept82 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_dept86 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_dept88 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_manager_in_dept101 = new BitSet(new long[]{0x0000000000001600L});
    public static final BitSet FOLLOW_personunit_in_dept115 = new BitSet(new long[]{0x0000000000001600L});
    public static final BitSet FOLLOW_dept_in_dept140 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_9_in_dept159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_manager177 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_employee_in_manager179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_personunit201 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_employee_in_personunit203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_employee228 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_employee230 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_employee236 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_employee240 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_employee246 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FLOAT_in_employee250 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_employee254 = new BitSet(new long[]{0x0000000000000002L});

}