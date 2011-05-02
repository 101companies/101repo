// $ANTLR 3.2 Sep 23, 2009 12:02:23 Cut.g 2011-05-02 04:30:00

package org.softlang.company;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Cut extends TreeRewriter {
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


        public Cut(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public Cut(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return Cut.tokenNames; }
    public String getGrammarFileName() { return "Cut.g"; }


    public static class topdown_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "topdown"
    // Cut.g:16:1: topdown : employee ;
    public final Cut.topdown_return topdown() throws RecognitionException {
        Cut.topdown_return retval = new Cut.topdown_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        Cut.employee_return employee1 = null;



        try {
            // Cut.g:16:9: ( employee )
            // Cut.g:16:11: employee
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_employee_in_topdown66);
            employee1=employee();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==1 ) 
             
            if ( _first_0==null ) _first_0 = employee1.tree;

            if ( state.backtracking==1 ) {
            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);}
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "topdown"

    public static class employee_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "employee"
    // Cut.g:19:1: employee : ^( EMPLOYEE STRING STRING s= FLOAT ) -> ^( EMPLOYEE STRING STRING FLOAT[Double.toString(Double.parseDouble($s.text) / 2.0d)] ) ;
    public final Cut.employee_return employee() throws RecognitionException {
        Cut.employee_return retval = new Cut.employee_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree s=null;
        CommonTree EMPLOYEE2=null;
        CommonTree STRING3=null;
        CommonTree STRING4=null;

        CommonTree s_tree=null;
        CommonTree EMPLOYEE2_tree=null;
        CommonTree STRING3_tree=null;
        CommonTree STRING4_tree=null;
        RewriteRuleNodeStream stream_EMPLOYEE=new RewriteRuleNodeStream(adaptor,"token EMPLOYEE");
        RewriteRuleNodeStream stream_FLOAT=new RewriteRuleNodeStream(adaptor,"token FLOAT");
        RewriteRuleNodeStream stream_STRING=new RewriteRuleNodeStream(adaptor,"token STRING");

        try {
            // Cut.g:19:10: ( ^( EMPLOYEE STRING STRING s= FLOAT ) -> ^( EMPLOYEE STRING STRING FLOAT[Double.toString(Double.parseDouble($s.text) / 2.0d)] ) )
            // Cut.g:20:3: ^( EMPLOYEE STRING STRING s= FLOAT )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            EMPLOYEE2=(CommonTree)match(input,EMPLOYEE,FOLLOW_EMPLOYEE_in_employee86); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_EMPLOYEE.add(EMPLOYEE2);


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = EMPLOYEE2;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            STRING3=(CommonTree)match(input,STRING,FOLLOW_STRING_in_employee88); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_STRING.add(STRING3);

            _last = (CommonTree)input.LT(1);
            STRING4=(CommonTree)match(input,STRING,FOLLOW_STRING_in_employee90); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_STRING.add(STRING4);

            _last = (CommonTree)input.LT(1);
            s=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_employee94); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_FLOAT.add(s);


            match(input, Token.UP, null); if (state.failed) return retval;_last = _save_last_1;
            }



            // AST REWRITE
            // elements: STRING, FLOAT, STRING, EMPLOYEE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==1 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 21:3: -> ^( EMPLOYEE STRING STRING FLOAT[Double.toString(Double.parseDouble($s.text) / 2.0d)] )
            {
                // Cut.g:21:6: ^( EMPLOYEE STRING STRING FLOAT[Double.toString(Double.parseDouble($s.text) / 2.0d)] )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_EMPLOYEE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_STRING.nextNode());
                adaptor.addChild(root_1, stream_STRING.nextNode());
                adaptor.addChild(root_1, (CommonTree)adaptor.create(FLOAT, Double.toString(Double.parseDouble((s!=null?s.getText():null)) / 2.0d)));

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            input.replaceChildren(adaptor.getParent(retval.start),
                                  adaptor.getChildIndex(retval.start),
                                  adaptor.getChildIndex(_last),
                                  retval.tree);}
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "employee"

    // Delegated rules


 

    public static final BitSet FOLLOW_employee_in_topdown66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EMPLOYEE_in_employee86 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_employee88 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_employee90 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_FLOAT_in_employee94 = new BitSet(new long[]{0x0000000000000008L});

}