// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2010-10-09 05:21:50

package org.softlang.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CompanyLexer extends Lexer {
    public static final int MANAGER=6;
    public static final int FLOAT=10;
    public static final int EOF=-1;
    public static final int COMPANY=4;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int WS=11;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int DEPT=5;
    public static final int PU=7;
    public static final int EMPLOYEE=8;
    public static final int STRING=9;

    // delegates
    // delegators

    public CompanyLexer() {;} 
    public CompanyLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CompanyLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Company.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:7:7: ( 'company' )
            // Company.g:7:9: 'company'
            {
            match("company"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:8:7: ( '{' )
            // Company.g:8:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:9:7: ( '}' )
            // Company.g:9:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:10:7: ( 'department' )
            // Company.g:10:9: 'department'
            {
            match("department"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:11:7: ( 'manager' )
            // Company.g:11:9: 'manager'
            {
            match("manager"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:12:7: ( 'employee' )
            // Company.g:12:9: 'employee'
            {
            match("employee"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:13:7: ( 'address' )
            // Company.g:13:9: 'address'
            {
            match("address"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:14:7: ( 'salary' )
            // Company.g:14:9: 'salary'
            {
            match("salary"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:46:9: ( ( ' ' | ( '\\r' )? '\\n' | '\\t' )+ )
            // Company.g:46:13: ( ' ' | ( '\\r' )? '\\n' | '\\t' )+
            {
            // Company.g:46:13: ( ' ' | ( '\\r' )? '\\n' | '\\t' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt2=1;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt2=2;
                    }
                    break;
                case '\t':
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // Company.g:46:14: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // Company.g:46:18: ( '\\r' )? '\\n'
            	    {
            	    // Company.g:46:18: ( '\\r' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='\r') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // Company.g:46:18: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // Company.g:46:29: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:47:9: ( '\"' (~ '\"' )* '\"' )
            // Company.g:47:13: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // Company.g:47:17: (~ '\"' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:47:18: ~ '\"'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:48:9: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // Company.g:48:13: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // Company.g:48:13: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Company.g:48:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // Company.g:48:25: ( '.' ( '0' .. '9' )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Company.g:48:26: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // Company.g:48:30: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Company.g:48:31: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    public void mTokens() throws RecognitionException {
        // Company.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | WS | STRING | FLOAT )
        int alt7=11;
        switch ( input.LA(1) ) {
        case 'c':
            {
            alt7=1;
            }
            break;
        case '{':
            {
            alt7=2;
            }
            break;
        case '}':
            {
            alt7=3;
            }
            break;
        case 'd':
            {
            alt7=4;
            }
            break;
        case 'm':
            {
            alt7=5;
            }
            break;
        case 'e':
            {
            alt7=6;
            }
            break;
        case 'a':
            {
            alt7=7;
            }
            break;
        case 's':
            {
            alt7=8;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt7=9;
            }
            break;
        case '\"':
            {
            alt7=10;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt7=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 7, 0, input);

            throw nvae;
        }

        switch (alt7) {
            case 1 :
                // Company.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // Company.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // Company.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // Company.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // Company.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // Company.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // Company.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // Company.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // Company.g:1:58: WS
                {
                mWS(); 

                }
                break;
            case 10 :
                // Company.g:1:61: STRING
                {
                mSTRING(); 

                }
                break;
            case 11 :
                // Company.g:1:68: FLOAT
                {
                mFLOAT(); 

                }
                break;

        }

    }


 

}