// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2010-10-09 23:06:26

package org.softlang.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CompanyLexer extends Lexer {
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

    public CompanyLexer() {;} 
    public CompanyLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CompanyLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Company.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:7:6: ( 'company' )
            // Company.g:7:8: 'company'
            {
            match("company"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:8:6: ( '{' )
            // Company.g:8:8: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:9:6: ( '}' )
            // Company.g:9:8: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:26:9: ( ( ' ' | ( '\\r' )? '\\n' | '\\t' )+ )
            // Company.g:26:13: ( ' ' | ( '\\r' )? '\\n' | '\\t' )+
            {
            // Company.g:26:13: ( ' ' | ( '\\r' )? '\\n' | '\\t' )+
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
            	    // Company.g:26:14: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // Company.g:26:18: ( '\\r' )? '\\n'
            	    {
            	    // Company.g:26:18: ( '\\r' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='\r') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // Company.g:26:18: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // Company.g:26:29: '\\t'
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
            // Company.g:27:9: ( '\"' (~ '\"' )* '\"' )
            // Company.g:27:13: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // Company.g:27:17: (~ '\"' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:27:18: ~ '\"'
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
            // Company.g:28:9: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // Company.g:28:13: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // Company.g:28:13: ( '0' .. '9' )+
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
            	    // Company.g:28:14: '0' .. '9'
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

            // Company.g:28:25: ( '.' ( '0' .. '9' )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Company.g:28:26: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // Company.g:28:30: ( '0' .. '9' )+
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
                    	    // Company.g:28:31: '0' .. '9'
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
        // Company.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | WS | STRING | FLOAT )
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
                // Company.g:1:10: T__7
                {
                mT__7(); 

                }
                break;
            case 2 :
                // Company.g:1:15: T__8
                {
                mT__8(); 

                }
                break;
            case 3 :
                // Company.g:1:20: T__9
                {
                mT__9(); 

                }
                break;
            case 4 :
                // Company.g:1:25: T__10
                {
                mT__10(); 

                }
                break;
            case 5 :
                // Company.g:1:31: T__11
                {
                mT__11(); 

                }
                break;
            case 6 :
                // Company.g:1:37: T__12
                {
                mT__12(); 

                }
                break;
            case 7 :
                // Company.g:1:43: T__13
                {
                mT__13(); 

                }
                break;
            case 8 :
                // Company.g:1:49: T__14
                {
                mT__14(); 

                }
                break;
            case 9 :
                // Company.g:1:55: WS
                {
                mWS(); 

                }
                break;
            case 10 :
                // Company.g:1:58: STRING
                {
                mSTRING(); 

                }
                break;
            case 11 :
                // Company.g:1:65: FLOAT
                {
                mFLOAT(); 

                }
                break;

        }

    }


 

}