// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2010-10-09 23:06:26

package org.softlang.antlr;


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
    // Company.g:10:1: company : 'company' STRING '{' ( dept )* '}' ;
    public final void company() throws RecognitionException {
        try {
            // Company.g:10:9: ( 'company' STRING '{' ( dept )* '}' )
            // Company.g:11:3: 'company' STRING '{' ( dept )* '}'
            {
            match(input,7,FOLLOW_7_in_company26); 
            match(input,STRING,FOLLOW_STRING_in_company28); 
            match(input,8,FOLLOW_8_in_company30); 
            // Company.g:11:24: ( dept )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Company.g:11:24: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_company32);
            	    dept();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,9,FOLLOW_9_in_company35); 

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
    // Company.g:13:1: dept : 'department' STRING '{' ( 'manager' employee ) ( 'employee' employee )* ( dept )* '}' ;
    public final void dept() throws RecognitionException {
        try {
            // Company.g:13:6: ( 'department' STRING '{' ( 'manager' employee ) ( 'employee' employee )* ( dept )* '}' )
            // Company.g:14:3: 'department' STRING '{' ( 'manager' employee ) ( 'employee' employee )* ( dept )* '}'
            {
            match(input,10,FOLLOW_10_in_dept47); 
            match(input,STRING,FOLLOW_STRING_in_dept49); 
            match(input,8,FOLLOW_8_in_dept51); 
            // Company.g:15:5: ( 'manager' employee )
            // Company.g:15:6: 'manager' employee
            {
            match(input,11,FOLLOW_11_in_dept59); 
            pushFollow(FOLLOW_employee_in_dept61);
            employee();

            state._fsp--;


            }

            // Company.g:16:5: ( 'employee' employee )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Company.g:16:6: 'employee' employee
            	    {
            	    match(input,12,FOLLOW_12_in_dept69); 
            	    pushFollow(FOLLOW_employee_in_dept71);
            	    employee();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Company.g:17:5: ( dept )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:17:5: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_dept80);
            	    dept();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,9,FOLLOW_9_in_dept85); 

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


    // $ANTLR start "employee"
    // Company.g:20:1: employee : STRING '{' 'address' STRING 'salary' FLOAT '}' ;
    public final void employee() throws RecognitionException {
        try {
            // Company.g:20:10: ( STRING '{' 'address' STRING 'salary' FLOAT '}' )
            // Company.g:21:3: STRING '{' 'address' STRING 'salary' FLOAT '}'
            {
            match(input,STRING,FOLLOW_STRING_in_employee95); 
            match(input,8,FOLLOW_8_in_employee97); 
            match(input,13,FOLLOW_13_in_employee103); 
            match(input,STRING,FOLLOW_STRING_in_employee105); 
            match(input,14,FOLLOW_14_in_employee111); 
            match(input,FLOAT,FOLLOW_FLOAT_in_employee113); 
            match(input,9,FOLLOW_9_in_employee117); 

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


 

    public static final BitSet FOLLOW_7_in_company26 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_company28 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_company30 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_dept_in_company32 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_9_in_company35 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_dept47 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_dept49 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_dept51 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_dept59 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_employee_in_dept61 = new BitSet(new long[]{0x0000000000001600L});
    public static final BitSet FOLLOW_12_in_dept69 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_employee_in_dept71 = new BitSet(new long[]{0x0000000000001600L});
    public static final BitSet FOLLOW_dept_in_dept80 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_9_in_dept85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_employee95 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_employee97 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_employee103 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_employee105 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_employee111 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FLOAT_in_employee113 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_employee117 = new BitSet(new long[]{0x0000000000000002L});

}