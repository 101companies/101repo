// $ANTLR 3.2 Sep 23, 2009 12:02:23 Total.g 2011-05-02 04:29:59

package org.softlang.company;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Total extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPANY", "DEPT", "MANAGER", "EMPLOYEE", "STRING", "FLOAT", "WS", "'company'", "'{'", "'}'", "'department'", "'employee'", "'manager'", "'address'", "'salary'"
    };
    public static final int COMPANY=4;
    public static final int WS=10;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int DEPT=5;
    public static final int EMPLOYEE=7;
    public static final int MANAGER=6;
    public static final int FLOAT=9;
    public static final int EOF=-1;
    public static final int STRING=8;

    // delegates
    // delegators


        public Total(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public Total(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return Total.tokenNames; }
    public String getGrammarFileName() { return "Total.g"; }



    public double total = 0;




    // $ANTLR start "company"
    // Total.g:18:1: company : ^( COMPANY STRING ( dept )* ) ;
    public final void company() throws RecognitionException {
        try {
            // Total.g:18:9: ( ^( COMPANY STRING ( dept )* ) )
            // Total.g:19:3: ^( COMPANY STRING ( dept )* )
            {
            match(input,COMPANY,FOLLOW_COMPANY_in_company47); 

            match(input, Token.DOWN, null); 
            match(input,STRING,FOLLOW_STRING_in_company49); 
            // Total.g:19:20: ( dept )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEPT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Total.g:19:20: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_company51);
            	    dept();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "company"


    // $ANTLR start "dept"
    // Total.g:22:1: dept : ^( DEPT STRING manager ( employee )* ( dept )* ) ;
    public final void dept() throws RecognitionException {
        try {
            // Total.g:22:6: ( ^( DEPT STRING manager ( employee )* ( dept )* ) )
            // Total.g:23:3: ^( DEPT STRING manager ( employee )* ( dept )* )
            {
            match(input,DEPT,FOLLOW_DEPT_in_dept69); 

            match(input, Token.DOWN, null); 
            match(input,STRING,FOLLOW_STRING_in_dept71); 
            pushFollow(FOLLOW_manager_in_dept73);
            manager();

            state._fsp--;

            // Total.g:23:25: ( employee )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==EMPLOYEE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Total.g:23:25: employee
            	    {
            	    pushFollow(FOLLOW_employee_in_dept75);
            	    employee();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Total.g:23:35: ( dept )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==DEPT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Total.g:23:35: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_dept78);
            	    dept();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "dept"


    // $ANTLR start "manager"
    // Total.g:26:1: manager : ^( MANAGER employee ) ;
    public final void manager() throws RecognitionException {
        try {
            // Total.g:26:9: ( ^( MANAGER employee ) )
            // Total.g:27:3: ^( MANAGER employee )
            {
            match(input,MANAGER,FOLLOW_MANAGER_in_manager99); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_employee_in_manager101);
            employee();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "manager"


    // $ANTLR start "employee"
    // Total.g:30:1: employee : ^( EMPLOYEE STRING STRING FLOAT ) ;
    public final void employee() throws RecognitionException {
        CommonTree FLOAT1=null;

        try {
            // Total.g:30:10: ( ^( EMPLOYEE STRING STRING FLOAT ) )
            // Total.g:31:3: ^( EMPLOYEE STRING STRING FLOAT )
            {
            match(input,EMPLOYEE,FOLLOW_EMPLOYEE_in_employee123); 

            match(input, Token.DOWN, null); 
            match(input,STRING,FOLLOW_STRING_in_employee125); 
            match(input,STRING,FOLLOW_STRING_in_employee127); 
            FLOAT1=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_employee129); 

            match(input, Token.UP, null); 
             total += Double.parseDouble((FLOAT1!=null?FLOAT1.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "employee"

    // Delegated rules


 

    public static final BitSet FOLLOW_COMPANY_in_company47 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_company49 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_dept_in_company51 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_DEPT_in_dept69 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_dept71 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_manager_in_dept73 = new BitSet(new long[]{0x00000000000000A8L});
    public static final BitSet FOLLOW_employee_in_dept75 = new BitSet(new long[]{0x00000000000000A8L});
    public static final BitSet FOLLOW_dept_in_dept78 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_MANAGER_in_manager99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_employee_in_manager101 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EMPLOYEE_in_employee123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_employee125 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_employee127 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_FLOAT_in_employee129 = new BitSet(new long[]{0x0000000000000008L});

}