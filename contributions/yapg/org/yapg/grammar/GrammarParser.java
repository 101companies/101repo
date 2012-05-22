// $ANTLR 3.2 Sep 23, 2009 12:02:23 Grammar.g 2012-05-22 23:16:30

package org.yapg.grammar;
import java.util.List;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "QSTRING", "QQSTRING", "NUMBER", "WS", "':'", "';'", "'='", "'|'", "'*'"
    };
    public static final int WS=8;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int NUMBER=7;
    public static final int QSTRING=5;
    public static final int ID=4;
    public static final int EOF=-1;
    public static final int QQSTRING=6;
    public static final int T__9=9;

    // delegates
    // delegators


        public GrammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GrammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return GrammarParser.tokenNames; }
    public String getGrammarFileName() { return "Grammar.g"; }



    	// Throw if any error was emitted
    	public boolean error = false;

    	@Override
    	public void emitErrorMessage(String msg)
    	{
    	  error = true;
    	  super.emitErrorMessage(msg);
    	}



    // $ANTLR start "parseGrammar"
    // Grammar.g:25:1: parseGrammar returns [Grammar result] : (prods= parseProduction )* ;
    public final Grammar parseGrammar() throws RecognitionException {
        Grammar result = null;

        Production prods = null;


        try {
            // Grammar.g:25:39: ( (prods= parseProduction )* )
            // Grammar.g:26:2: (prods= parseProduction )*
            {
             List<Production> prodsList = new LinkedList<Production>(); 
            // Grammar.g:27:2: (prods= parseProduction )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Grammar.g:27:4: prods= parseProduction
            	    {
            	    pushFollow(FOLLOW_parseProduction_in_parseGrammar53);
            	    prods=parseProduction();

            	    state._fsp--;

            	     prodsList.add(prods); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             result = new Grammar(); result.prods = prodsList; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseGrammar"


    // $ANTLR start "parseProduction"
    // Grammar.g:30:1: parseProduction returns [Production result] : lhs= parseId ':' rhs= parseExpression ';' ;
    public final Production parseProduction() throws RecognitionException {
        Production result = null;

        String lhs = null;

        Expression rhs = null;


        try {
            // Grammar.g:30:45: (lhs= parseId ':' rhs= parseExpression ';' )
            // Grammar.g:31:2: lhs= parseId ':' rhs= parseExpression ';'
            {
            pushFollow(FOLLOW_parseId_in_parseProduction77);
            lhs=parseId();

            state._fsp--;

            match(input,9,FOLLOW_9_in_parseProduction80); 
            pushFollow(FOLLOW_parseExpression_in_parseProduction85);
            rhs=parseExpression();

            state._fsp--;

            match(input,10,FOLLOW_10_in_parseProduction88); 
             result = new Production(); result.lhs = lhs; result.rhs = rhs; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseProduction"


    // $ANTLR start "parseExpression"
    // Grammar.g:37:1: parseExpression returns [Expression result] : ( parseSequence | parseChoice );
    public final Expression parseExpression() throws RecognitionException {
        Expression result = null;

        Sequence parseSequence1 = null;

        Choice parseChoice2 = null;


        try {
            // Grammar.g:37:45: ( parseSequence | parseChoice )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==QSTRING||LA2_0==10) ) {
                alt2=1;
            }
            else if ( (LA2_0==ID) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==10||LA2_2==12) ) {
                    alt2=2;
                }
                else if ( (LA2_2==11) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // Grammar.g:38:3: parseSequence
                    {
                    pushFollow(FOLLOW_parseSequence_in_parseExpression106);
                    parseSequence1=parseSequence();

                    state._fsp--;

                     result = parseSequence1; 

                    }
                    break;
                case 2 :
                    // Grammar.g:39:4: parseChoice
                    {
                    pushFollow(FOLLOW_parseChoice_in_parseExpression113);
                    parseChoice2=parseChoice();

                    state._fsp--;

                     result = parseChoice2; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseExpression"


    // $ANTLR start "parseSequence"
    // Grammar.g:41:1: parseSequence returns [Sequence result] : (list= parseAtom )* ;
    public final Sequence parseSequence() throws RecognitionException {
        Sequence result = null;

        Atom list = null;


        try {
            // Grammar.g:41:41: ( (list= parseAtom )* )
            // Grammar.g:42:2: (list= parseAtom )*
            {
             List<Atom> listList = new LinkedList<Atom>(); 
            // Grammar.g:43:2: (list= parseAtom )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=ID && LA3_0<=QSTRING)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Grammar.g:43:4: list= parseAtom
            	    {
            	    pushFollow(FOLLOW_parseAtom_in_parseSequence136);
            	    list=parseAtom();

            	    state._fsp--;

            	     listList.add(list); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             result = new Sequence(); result.list = listList; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseSequence"


    // $ANTLR start "parseChoice"
    // Grammar.g:46:1: parseChoice returns [Choice result] : first= parseId (rest= parseOption )* ;
    public final Choice parseChoice() throws RecognitionException {
        Choice result = null;

        String first = null;

        Option rest = null;


        try {
            // Grammar.g:46:37: (first= parseId (rest= parseOption )* )
            // Grammar.g:47:2: first= parseId (rest= parseOption )*
            {
            pushFollow(FOLLOW_parseId_in_parseChoice160);
            first=parseId();

            state._fsp--;

             List<Option> restList = new LinkedList<Option>(); 
            // Grammar.g:49:2: (rest= parseOption )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Grammar.g:49:4: rest= parseOption
            	    {
            	    pushFollow(FOLLOW_parseOption_in_parseChoice170);
            	    rest=parseOption();

            	    state._fsp--;

            	     restList.add(rest); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             result = new Choice(); result.first = first; result.rest = restList; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseChoice"


    // $ANTLR start "parseAtom"
    // Grammar.g:52:1: parseAtom returns [Atom result] : ( parseTerminal | parseNonterminal | parseMany );
    public final Atom parseAtom() throws RecognitionException {
        Atom result = null;

        Terminal parseTerminal3 = null;

        Nonterminal parseNonterminal4 = null;

        Many parseMany5 = null;


        try {
            // Grammar.g:52:33: ( parseTerminal | parseNonterminal | parseMany )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==QSTRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==ID) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==11) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==ID) ) {
                        int LA5_4 = input.LA(4);

                        if ( ((LA5_4>=ID && LA5_4<=QSTRING)||LA5_4==10) ) {
                            alt5=2;
                        }
                        else if ( (LA5_4==13) ) {
                            alt5=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Grammar.g:53:3: parseTerminal
                    {
                    pushFollow(FOLLOW_parseTerminal_in_parseAtom193);
                    parseTerminal3=parseTerminal();

                    state._fsp--;

                     result = parseTerminal3; 

                    }
                    break;
                case 2 :
                    // Grammar.g:54:4: parseNonterminal
                    {
                    pushFollow(FOLLOW_parseNonterminal_in_parseAtom200);
                    parseNonterminal4=parseNonterminal();

                    state._fsp--;

                     result = parseNonterminal4; 

                    }
                    break;
                case 3 :
                    // Grammar.g:55:4: parseMany
                    {
                    pushFollow(FOLLOW_parseMany_in_parseAtom207);
                    parseMany5=parseMany();

                    state._fsp--;

                     result = parseMany5; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseAtom"


    // $ANTLR start "parseTerminal"
    // Grammar.g:57:1: parseTerminal returns [Terminal result] : symbol= parseQString ;
    public final Terminal parseTerminal() throws RecognitionException {
        Terminal result = null;

        String symbol = null;


        try {
            // Grammar.g:57:41: (symbol= parseQString )
            // Grammar.g:58:2: symbol= parseQString
            {
            pushFollow(FOLLOW_parseQString_in_parseTerminal225);
            symbol=parseQString();

            state._fsp--;

             result = new Terminal(); result.symbol = symbol; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseTerminal"


    // $ANTLR start "parseNonterminal"
    // Grammar.g:61:1: parseNonterminal returns [Nonterminal result] : label= parseId '=' symbol= parseId ;
    public final Nonterminal parseNonterminal() throws RecognitionException {
        Nonterminal result = null;

        String label = null;

        String symbol = null;


        try {
            // Grammar.g:61:47: (label= parseId '=' symbol= parseId )
            // Grammar.g:62:2: label= parseId '=' symbol= parseId
            {
            pushFollow(FOLLOW_parseId_in_parseNonterminal244);
            label=parseId();

            state._fsp--;

            match(input,11,FOLLOW_11_in_parseNonterminal247); 
            pushFollow(FOLLOW_parseId_in_parseNonterminal252);
            symbol=parseId();

            state._fsp--;

             result = new Nonterminal(); result.label = label; result.symbol = symbol; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseNonterminal"


    // $ANTLR start "parseOption"
    // Grammar.g:67:1: parseOption returns [Option result] : '|' symbol= parseId ;
    public final Option parseOption() throws RecognitionException {
        Option result = null;

        String symbol = null;


        try {
            // Grammar.g:67:37: ( '|' symbol= parseId )
            // Grammar.g:68:2: '|' symbol= parseId
            {
            match(input,12,FOLLOW_12_in_parseOption269); 
            pushFollow(FOLLOW_parseId_in_parseOption274);
            symbol=parseId();

            state._fsp--;

             result = new Option(); result.symbol = symbol; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseOption"


    // $ANTLR start "parseMany"
    // Grammar.g:72:1: parseMany returns [Many result] : elem= parseNonterminal '*' ;
    public final Many parseMany() throws RecognitionException {
        Many result = null;

        Nonterminal elem = null;


        try {
            // Grammar.g:72:33: (elem= parseNonterminal '*' )
            // Grammar.g:73:2: elem= parseNonterminal '*'
            {
            pushFollow(FOLLOW_parseNonterminal_in_parseMany293);
            elem=parseNonterminal();

            state._fsp--;

            match(input,13,FOLLOW_13_in_parseMany296); 
             result = new Many(); result.elem = elem; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseMany"


    // $ANTLR start "parseId"
    // Grammar.g:77:1: parseId returns [String result] : ID ;
    public final String parseId() throws RecognitionException {
        String result = null;

        Token ID6=null;

        try {
            // Grammar.g:77:33: ( ID )
            // Grammar.g:78:2: ID
            {
            ID6=(Token)match(input,ID,FOLLOW_ID_in_parseId312); 
             result = (ID6!=null?ID6.getText():null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseId"


    // $ANTLR start "parseQString"
    // Grammar.g:82:1: parseQString returns [String result] : QSTRING ;
    public final String parseQString() throws RecognitionException {
        String result = null;

        Token QSTRING7=null;

        try {
            // Grammar.g:82:38: ( QSTRING )
            // Grammar.g:83:2: QSTRING
            {
            QSTRING7=(Token)match(input,QSTRING,FOLLOW_QSTRING_in_parseQString330); 
             result = (QSTRING7!=null?QSTRING7.getText():null).substring(1,(QSTRING7!=null?QSTRING7.getText():null).length()-1); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseQString"


    // $ANTLR start "parseQqString"
    // Grammar.g:87:1: parseQqString returns [String result] : QQSTRING ;
    public final String parseQqString() throws RecognitionException {
        String result = null;

        Token QQSTRING8=null;

        try {
            // Grammar.g:87:39: ( QQSTRING )
            // Grammar.g:88:2: QQSTRING
            {
            QQSTRING8=(Token)match(input,QQSTRING,FOLLOW_QQSTRING_in_parseQqString348); 
             result = (QQSTRING8!=null?QQSTRING8.getText():null).substring(1,(QQSTRING8!=null?QQSTRING8.getText():null).length()-1); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseQqString"


    // $ANTLR start "parseNumber"
    // Grammar.g:92:1: parseNumber returns [Number result] : NUMBER ;
    public final Number parseNumber() throws RecognitionException {
        Number result = null;

        Token NUMBER9=null;

        try {
            // Grammar.g:92:37: ( NUMBER )
            // Grammar.g:93:2: NUMBER
            {
            NUMBER9=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parseNumber366); 
             result = Double.parseDouble((NUMBER9!=null?NUMBER9.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "parseNumber"

    // Delegated rules


 

    public static final BitSet FOLLOW_parseProduction_in_parseGrammar53 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_parseId_in_parseProduction77 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parseProduction80 = new BitSet(new long[]{0x0000000000001830L});
    public static final BitSet FOLLOW_parseExpression_in_parseProduction85 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parseProduction88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseSequence_in_parseExpression106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseChoice_in_parseExpression113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseAtom_in_parseSequence136 = new BitSet(new long[]{0x0000000000000832L});
    public static final BitSet FOLLOW_parseId_in_parseChoice160 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_parseOption_in_parseChoice170 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_parseTerminal_in_parseAtom193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseNonterminal_in_parseAtom200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseMany_in_parseAtom207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseQString_in_parseTerminal225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseId_in_parseNonterminal244 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parseNonterminal247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parseId_in_parseNonterminal252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parseOption269 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parseId_in_parseOption274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseNonterminal_in_parseMany293 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parseMany296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_parseId312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QSTRING_in_parseQString330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QQSTRING_in_parseQqString348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_parseNumber366 = new BitSet(new long[]{0x0000000000000002L});

}