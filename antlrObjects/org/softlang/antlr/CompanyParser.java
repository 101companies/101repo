// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2011-04-26 14:41:38

package org.softlang.antlr;
import org.softlang.company.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


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


    public static Company parse(String s) throws IOException, RecognitionException {
        FileInputStream stream = new FileInputStream("inputs" + File.separatorChar + s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        Company c = parser.company();
        if (parser.error) throw new RecognitionException();
        return c;
    }

    // Throw if any error was emitted
    public boolean error = false;

    @Override
    public void emitErrorMessage(String msg) 
    {
      error = true;
      super.emitErrorMessage(msg);
    }



    // $ANTLR start "company"
    // Company.g:42:1: company returns [Company c] : 'company' STRING '{' (topdept= dept )* '}' ;
    public final Company company() throws RecognitionException {
        Company c = null;

        Token STRING1=null;
        Department topdept = null;


        try {
            // Company.g:42:28: ( 'company' STRING '{' (topdept= dept )* '}' )
            // Company.g:43:3: 'company' STRING '{' (topdept= dept )* '}'
            {
             c = new Company(); 
            match(input,7,FOLLOW_7_in_company54); 
            STRING1=(Token)match(input,STRING,FOLLOW_STRING_in_company56); 
             c.setName((STRING1!=null?STRING1.getText():null)); 
            match(input,8,FOLLOW_8_in_company64); 
            // Company.g:47:3: (topdept= dept )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Company.g:47:5: topdept= dept
            	    {
            	    pushFollow(FOLLOW_dept_in_company73);
            	    topdept=dept();

            	    state._fsp--;

            	     c.getDepts().add(topdept); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,9,FOLLOW_9_in_company89); 

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
    // Company.g:53:1: dept returns [Department d] : 'department' name= STRING '{' 'manager' m= employee ( 'employee' e= employee )* (sub= dept )* '}' ;
    public final Department dept() throws RecognitionException {
        Department d = null;

        Token name=null;
        Employee m = null;

        Employee e = null;

        Department sub = null;


        try {
            // Company.g:53:28: ( 'department' name= STRING '{' 'manager' m= employee ( 'employee' e= employee )* (sub= dept )* '}' )
            // Company.g:54:3: 'department' name= STRING '{' 'manager' m= employee ( 'employee' e= employee )* (sub= dept )* '}'
            {
             d = new Department(); 
            match(input,10,FOLLOW_10_in_dept111); 
            name=(Token)match(input,STRING,FOLLOW_STRING_in_dept115); 
             d.setName((name!=null?name.getText():null)); 
            match(input,8,FOLLOW_8_in_dept124); 
            match(input,11,FOLLOW_11_in_dept130); 
            pushFollow(FOLLOW_employee_in_dept134);
            m=employee();

            state._fsp--;

             d.setManager(m); 
            // Company.g:60:5: ( 'employee' e= employee )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Company.g:60:7: 'employee' e= employee
            	    {
            	    match(input,12,FOLLOW_12_in_dept148); 
            	    pushFollow(FOLLOW_employee_in_dept152);
            	    e=employee();

            	    state._fsp--;

            	     d.getEmployees().add(e); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Company.g:63:5: (sub= dept )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:63:7: sub= dept
            	    {
            	    pushFollow(FOLLOW_dept_in_dept177);
            	    sub=dept();

            	    state._fsp--;

            	     d.getSubdepts().add(sub); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,9,FOLLOW_9_in_dept196); 

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


    // $ANTLR start "employee"
    // Company.g:69:1: employee returns [Employee e] : n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' ;
    public final Employee employee() throws RecognitionException {
        Employee e = null;

        Token n=null;
        Token a=null;
        Token s=null;

        try {
            // Company.g:69:30: (n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' )
            // Company.g:70:3: n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}'
            {
            n=(Token)match(input,STRING,FOLLOW_STRING_in_employee218); 
            match(input,8,FOLLOW_8_in_employee220); 
            match(input,13,FOLLOW_13_in_employee226); 
            a=(Token)match(input,STRING,FOLLOW_STRING_in_employee230); 
            match(input,14,FOLLOW_14_in_employee236); 
            s=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_employee240); 
            match(input,9,FOLLOW_9_in_employee244); 

                e = new Employee();
                e.setName((n!=null?n.getText():null));
                e.setAddress((a!=null?a.getText():null));
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


 

    public static final BitSet FOLLOW_7_in_company54 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_company56 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_company64 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_dept_in_company73 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_9_in_company89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_dept111 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_dept115 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_dept124 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_dept130 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_employee_in_dept134 = new BitSet(new long[]{0x0000000000001600L});
    public static final BitSet FOLLOW_12_in_dept148 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_employee_in_dept152 = new BitSet(new long[]{0x0000000000001600L});
    public static final BitSet FOLLOW_dept_in_dept177 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_9_in_dept196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_employee218 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_employee220 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_employee226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_employee230 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_employee236 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FLOAT_in_employee240 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_employee244 = new BitSet(new long[]{0x0000000000000002L});

}