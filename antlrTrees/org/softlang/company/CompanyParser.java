// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2011-05-02 04:29:58

package org.softlang.company;

import java.io.IOException;
import java.io.FileInputStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class CompanyParser extends Parser {
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


        public CompanyParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CompanyParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CompanyParser.tokenNames; }
    public String getGrammarFileName() { return "Company.g"; }



    // Throw if any error was emitted
    public boolean error = false;

    @Override
    public void emitErrorMessage(String msg) 
    {
      error = true;
      super.emitErrorMessage(msg);
    }

    public static company_return parse(String s) throws IOException, RecognitionException {
        FileInputStream stream = new FileInputStream(s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        company_return r = parser.company();
        if (parser.error) throw new RecognitionException();
        return r;
    }


    public static class company_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "company"
    // Company.g:45:1: company : 'company' STRING '{' ( dept )* '}' -> ^( COMPANY STRING ( dept )* ) ;
    public final CompanyParser.company_return company() throws RecognitionException {
        CompanyParser.company_return retval = new CompanyParser.company_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        Token STRING2=null;
        Token char_literal3=null;
        Token char_literal5=null;
        CompanyParser.dept_return dept4 = null;


        Object string_literal1_tree=null;
        Object STRING2_tree=null;
        Object char_literal3_tree=null;
        Object char_literal5_tree=null;
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_11=new RewriteRuleTokenStream(adaptor,"token 11");
        RewriteRuleTokenStream stream_12=new RewriteRuleTokenStream(adaptor,"token 12");
        RewriteRuleSubtreeStream stream_dept=new RewriteRuleSubtreeStream(adaptor,"rule dept");
        try {
            // Company.g:45:9: ( 'company' STRING '{' ( dept )* '}' -> ^( COMPANY STRING ( dept )* ) )
            // Company.g:46:3: 'company' STRING '{' ( dept )* '}'
            {
            string_literal1=(Token)match(input,11,FOLLOW_11_in_company74);  
            stream_11.add(string_literal1);

            STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_company76);  
            stream_STRING.add(STRING2);

            char_literal3=(Token)match(input,12,FOLLOW_12_in_company78);  
            stream_12.add(char_literal3);

            // Company.g:46:24: ( dept )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Company.g:46:24: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_company80);
            	    dept4=dept();

            	    state._fsp--;

            	    stream_dept.add(dept4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal5=(Token)match(input,13,FOLLOW_13_in_company83);  
            stream_13.add(char_literal5);



            // AST REWRITE
            // elements: dept, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 47:3: -> ^( COMPANY STRING ( dept )* )
            {
                // Company.g:47:6: ^( COMPANY STRING ( dept )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPANY, "COMPANY"), root_1);

                adaptor.addChild(root_1, stream_STRING.nextNode());
                // Company.g:47:23: ( dept )*
                while ( stream_dept.hasNext() ) {
                    adaptor.addChild(root_1, stream_dept.nextTree());

                }
                stream_dept.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "company"

    public static class dept_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dept"
    // Company.g:50:1: dept : 'department' name= STRING '{' manager ( 'employee' employee )* ( dept )* '}' -> ^( DEPT $name manager ( employee )* ( dept )* ) ;
    public final CompanyParser.dept_return dept() throws RecognitionException {
        CompanyParser.dept_return retval = new CompanyParser.dept_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token string_literal6=null;
        Token char_literal7=null;
        Token string_literal9=null;
        Token char_literal12=null;
        CompanyParser.manager_return manager8 = null;

        CompanyParser.employee_return employee10 = null;

        CompanyParser.dept_return dept11 = null;


        Object name_tree=null;
        Object string_literal6_tree=null;
        Object char_literal7_tree=null;
        Object string_literal9_tree=null;
        Object char_literal12_tree=null;
        RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_12=new RewriteRuleTokenStream(adaptor,"token 12");
        RewriteRuleSubtreeStream stream_manager=new RewriteRuleSubtreeStream(adaptor,"rule manager");
        RewriteRuleSubtreeStream stream_dept=new RewriteRuleSubtreeStream(adaptor,"rule dept");
        RewriteRuleSubtreeStream stream_employee=new RewriteRuleSubtreeStream(adaptor,"rule employee");
        try {
            // Company.g:50:6: ( 'department' name= STRING '{' manager ( 'employee' employee )* ( dept )* '}' -> ^( DEPT $name manager ( employee )* ( dept )* ) )
            // Company.g:51:3: 'department' name= STRING '{' manager ( 'employee' employee )* ( dept )* '}'
            {
            string_literal6=(Token)match(input,14,FOLLOW_14_in_dept111);  
            stream_14.add(string_literal6);

            name=(Token)match(input,STRING,FOLLOW_STRING_in_dept115);  
            stream_STRING.add(name);

            char_literal7=(Token)match(input,12,FOLLOW_12_in_dept117);  
            stream_12.add(char_literal7);

            pushFollow(FOLLOW_manager_in_dept124);
            manager8=manager();

            state._fsp--;

            stream_manager.add(manager8.getTree());
            // Company.g:53:5: ( 'employee' employee )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Company.g:53:6: 'employee' employee
            	    {
            	    string_literal9=(Token)match(input,15,FOLLOW_15_in_dept131);  
            	    stream_15.add(string_literal9);

            	    pushFollow(FOLLOW_employee_in_dept133);
            	    employee10=employee();

            	    state._fsp--;

            	    stream_employee.add(employee10.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Company.g:54:5: ( dept )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:54:5: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_dept141);
            	    dept11=dept();

            	    state._fsp--;

            	    stream_dept.add(dept11.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            char_literal12=(Token)match(input,13,FOLLOW_13_in_dept146);  
            stream_13.add(char_literal12);



            // AST REWRITE
            // elements: manager, dept, employee, name
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 56:3: -> ^( DEPT $name manager ( employee )* ( dept )* )
            {
                // Company.g:56:6: ^( DEPT $name manager ( employee )* ( dept )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEPT, "DEPT"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_manager.nextTree());
                // Company.g:56:27: ( employee )*
                while ( stream_employee.hasNext() ) {
                    adaptor.addChild(root_1, stream_employee.nextTree());

                }
                stream_employee.reset();
                // Company.g:56:37: ( dept )*
                while ( stream_dept.hasNext() ) {
                    adaptor.addChild(root_1, stream_dept.nextTree());

                }
                stream_dept.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dept"

    public static class manager_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manager"
    // Company.g:59:1: manager : 'manager' employee -> ^( MANAGER employee ) ;
    public final CompanyParser.manager_return manager() throws RecognitionException {
        CompanyParser.manager_return retval = new CompanyParser.manager_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal13=null;
        CompanyParser.employee_return employee14 = null;


        Object string_literal13_tree=null;
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleSubtreeStream stream_employee=new RewriteRuleSubtreeStream(adaptor,"rule employee");
        try {
            // Company.g:59:9: ( 'manager' employee -> ^( MANAGER employee ) )
            // Company.g:60:3: 'manager' employee
            {
            string_literal13=(Token)match(input,16,FOLLOW_16_in_manager183);  
            stream_16.add(string_literal13);

            pushFollow(FOLLOW_employee_in_manager185);
            employee14=employee();

            state._fsp--;

            stream_employee.add(employee14.getTree());


            // AST REWRITE
            // elements: employee
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 61:3: -> ^( MANAGER employee )
            {
                // Company.g:61:6: ^( MANAGER employee )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MANAGER, "MANAGER"), root_1);

                adaptor.addChild(root_1, stream_employee.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manager"

    public static class employee_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "employee"
    // Company.g:64:1: employee : n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' -> ^( EMPLOYEE $n $a $s) ;
    public final CompanyParser.employee_return employee() throws RecognitionException {
        CompanyParser.employee_return retval = new CompanyParser.employee_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token a=null;
        Token s=null;
        Token char_literal15=null;
        Token string_literal16=null;
        Token string_literal17=null;
        Token char_literal18=null;

        Object n_tree=null;
        Object a_tree=null;
        Object s_tree=null;
        Object char_literal15_tree=null;
        Object string_literal16_tree=null;
        Object string_literal17_tree=null;
        Object char_literal18_tree=null;
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
        RewriteRuleTokenStream stream_18=new RewriteRuleTokenStream(adaptor,"token 18");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_12=new RewriteRuleTokenStream(adaptor,"token 12");

        try {
            // Company.g:64:10: (n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' -> ^( EMPLOYEE $n $a $s) )
            // Company.g:65:3: n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}'
            {
            n=(Token)match(input,STRING,FOLLOW_STRING_in_employee218);  
            stream_STRING.add(n);

            char_literal15=(Token)match(input,12,FOLLOW_12_in_employee220);  
            stream_12.add(char_literal15);

            string_literal16=(Token)match(input,17,FOLLOW_17_in_employee226);  
            stream_17.add(string_literal16);

            a=(Token)match(input,STRING,FOLLOW_STRING_in_employee230);  
            stream_STRING.add(a);

            string_literal17=(Token)match(input,18,FOLLOW_18_in_employee236);  
            stream_18.add(string_literal17);

            s=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_employee240);  
            stream_FLOAT.add(s);

            char_literal18=(Token)match(input,13,FOLLOW_13_in_employee244);  
            stream_13.add(char_literal18);



            // AST REWRITE
            // elements: a, s, n
            // token labels: s, a, n
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 69:3: -> ^( EMPLOYEE $n $a $s)
            {
                // Company.g:69:6: ^( EMPLOYEE $n $a $s)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EMPLOYEE, "EMPLOYEE"), root_1);

                adaptor.addChild(root_1, stream_n.nextNode());
                adaptor.addChild(root_1, stream_a.nextNode());
                adaptor.addChild(root_1, stream_s.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "employee"

    // Delegated rules


 

    public static final BitSet FOLLOW_11_in_company74 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_company76 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_company78 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_dept_in_company80 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_company83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_dept111 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_dept115 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_dept117 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_manager_in_dept124 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_15_in_dept131 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_employee_in_dept133 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_dept_in_dept141 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_dept146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_manager183 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_employee_in_manager185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_employee218 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_employee220 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_employee226 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_employee230 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_employee236 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_FLOAT_in_employee240 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_employee244 = new BitSet(new long[]{0x0000000000000002L});

}