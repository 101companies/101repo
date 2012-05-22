// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2012-05-22 22:56:43

package org.yapg.company;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CompanyLexer extends Lexer {
    public static final int WS=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int NUMBER=7;
    public static final int QSTRING=5;
    public static final int ID=4;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int QQSTRING=6;

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

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:82:4: ( ( ' ' | ( '\\r' )? '\\n' | '\\t' )+ )
            // Company.g:82:6: ( ' ' | ( '\\r' )? '\\n' | '\\t' )+
            {
            // Company.g:82:6: ( ' ' | ( '\\r' )? '\\n' | '\\t' )+
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
            	    // Company.g:82:7: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // Company.g:82:11: ( '\\r' )? '\\n'
            	    {
            	    // Company.g:82:11: ( '\\r' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='\r') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // Company.g:82:11: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // Company.g:82:22: '\\t'
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:83:4: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Company.g:83:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // Company.g:83:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "QSTRING"
    public final void mQSTRING() throws RecognitionException {
        try {
            int _type = QSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:84:9: ( '\\'' (~ '\\'' )* '\\'' )
            // Company.g:84:11: '\\'' (~ '\\'' )* '\\''
            {
            match('\''); 
            // Company.g:84:16: (~ '\\'' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Company.g:84:17: ~ '\\''
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QSTRING"

    // $ANTLR start "QQSTRING"
    public final void mQQSTRING() throws RecognitionException {
        try {
            int _type = QQSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:85:10: ( '\"' (~ '\"' )* '\"' )
            // Company.g:85:12: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // Company.g:85:16: (~ '\"' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Company.g:85:17: ~ '\"'
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
            	    break loop5;
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
    // $ANTLR end "QQSTRING"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Company.g:86:8: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // Company.g:86:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // Company.g:86:10: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Company.g:86:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // Company.g:86:22: ( '.' ( '0' .. '9' )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='.') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Company.g:86:23: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // Company.g:86:27: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Company.g:86:28: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
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
    // $ANTLR end "NUMBER"

    public void mTokens() throws RecognitionException {
        // Company.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | WS | ID | QSTRING | QQSTRING | NUMBER )
        int alt9=13;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // Company.g:1:10: T__9
                {
                mT__9(); 

                }
                break;
            case 2 :
                // Company.g:1:15: T__10
                {
                mT__10(); 

                }
                break;
            case 3 :
                // Company.g:1:21: T__11
                {
                mT__11(); 

                }
                break;
            case 4 :
                // Company.g:1:27: T__12
                {
                mT__12(); 

                }
                break;
            case 5 :
                // Company.g:1:33: T__13
                {
                mT__13(); 

                }
                break;
            case 6 :
                // Company.g:1:39: T__14
                {
                mT__14(); 

                }
                break;
            case 7 :
                // Company.g:1:45: T__15
                {
                mT__15(); 

                }
                break;
            case 8 :
                // Company.g:1:51: T__16
                {
                mT__16(); 

                }
                break;
            case 9 :
                // Company.g:1:57: WS
                {
                mWS(); 

                }
                break;
            case 10 :
                // Company.g:1:60: ID
                {
                mID(); 

                }
                break;
            case 11 :
                // Company.g:1:63: QSTRING
                {
                mQSTRING(); 

                }
                break;
            case 12 :
                // Company.g:1:71: QQSTRING
                {
                mQQSTRING(); 

                }
                break;
            case 13 :
                // Company.g:1:80: NUMBER
                {
                mNUMBER(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\12\2\uffff\5\12\5\uffff\35\12\1\61\1\62\1\12\1\64\1\12"+
        "\1\66\2\uffff\1\12\1\uffff\1\70\1\uffff\1\12\1\uffff\1\72\1\uffff";
    static final String DFA9_eofS =
        "\73\uffff";
    static final String DFA9_minS =
        "\1\11\1\157\2\uffff\1\145\1\141\1\155\1\144\1\141\5\uffff\1\155"+
        "\1\160\1\156\1\160\1\144\1\154\1\160\2\141\1\154\1\162\2\141\1\162"+
        "\1\147\1\157\1\145\1\162\1\156\1\164\1\145\1\171\1\163\2\171\1\155"+
        "\1\162\1\145\1\163\2\60\1\145\1\60\1\145\1\60\2\uffff\1\156\1\uffff"+
        "\1\60\1\uffff\1\164\1\uffff\1\60\1\uffff";
    static final String DFA9_maxS =
        "\1\175\1\157\2\uffff\1\145\1\141\1\155\1\144\1\141\5\uffff\1\155"+
        "\1\160\1\156\1\160\1\144\1\154\1\160\2\141\1\154\1\162\2\141\1\162"+
        "\1\147\1\157\1\145\1\162\1\156\1\164\1\145\1\171\1\163\2\171\1\155"+
        "\1\162\1\145\1\163\2\172\1\145\1\172\1\145\1\172\2\uffff\1\156\1"+
        "\uffff\1\172\1\uffff\1\164\1\uffff\1\172\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\3\5\uffff\1\11\1\12\1\13\1\14\1\15\43\uffff\1\10"+
        "\1\1\1\uffff\1\5\1\uffff\1\7\1\uffff\1\6\1\uffff\1\4";
    static final String DFA9_specialS =
        "\73\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\11\2\uffff\1\11\22\uffff\1\11\1\uffff\1\14\4\uffff\1\13\10"+
            "\uffff\12\15\7\uffff\32\12\6\uffff\1\7\1\12\1\1\1\4\1\6\7\12"+
            "\1\5\5\12\1\10\7\12\1\2\1\uffff\1\3",
            "\1\16",
            "",
            "",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "",
            "",
            "",
            "",
            "",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "\1\63",
            "\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "\1\65",
            "\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "",
            "",
            "\1\67",
            "",
            "\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "",
            "\1\71",
            "",
            "\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | WS | ID | QSTRING | QQSTRING | NUMBER );";
        }
    }
 

}