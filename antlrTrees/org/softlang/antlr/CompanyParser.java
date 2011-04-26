// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2011-04-26 14:42:28

package org.softlang.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class CompanyParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMPANY", "DEPT", "MANAGER", "PU", "EMPLOYEE", "STRING", "FLOAT", "WS", "'company'", "'{'", "'}'", "'department'", "'manager'", "'employee'", "'address'", "'salary'"
    };
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


    public static class company_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "company"
    // Company.g:31:1: company : 'company' STRING '{' ( dept )* '}' -> ^( COMPANY STRING ( dept )* ) ;
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
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_12=new RewriteRuleTokenStream(adaptor,"token 12");
        RewriteRuleSubtreeStream stream_dept=new RewriteRuleSubtreeStream(adaptor,"rule dept");
        try {
            // Company.g:31:9: ( 'company' STRING '{' ( dept )* '}' -> ^( COMPANY STRING ( dept )* ) )
            // Company.g:32:3: 'company' STRING '{' ( dept )* '}'
            {
            string_literal1=(Token)match(input,12,FOLLOW_12_in_company77);  
            stream_12.add(string_literal1);

            STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_company79);  
            stream_STRING.add(STRING2);

            char_literal3=(Token)match(input,13,FOLLOW_13_in_company81);  
            stream_13.add(char_literal3);

            // Company.g:32:24: ( dept )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Company.g:32:24: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_company83);
            	    dept4=dept();

            	    state._fsp--;

            	    stream_dept.add(dept4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal5=(Token)match(input,14,FOLLOW_14_in_company86);  
            stream_14.add(char_literal5);



            // AST REWRITE
            // elements: STRING, dept
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 33:3: -> ^( COMPANY STRING ( dept )* )
            {
                // Company.g:33:6: ^( COMPANY STRING ( dept )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPANY, "COMPANY"), root_1);

                adaptor.addChild(root_1, stream_STRING.nextNode());
                // Company.g:33:23: ( dept )*
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
    // Company.g:36:1: dept : 'department' name= STRING '{' manager ( personunit )* ( dept )* '}' -> ^( DEPT $name manager ( personunit )* ( dept )* ) ;
    public final CompanyParser.dept_return dept() throws RecognitionException {
        CompanyParser.dept_return retval = new CompanyParser.dept_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token string_literal6=null;
        Token char_literal7=null;
        Token char_literal11=null;
        CompanyParser.manager_return manager8 = null;

        CompanyParser.personunit_return personunit9 = null;

        CompanyParser.dept_return dept10 = null;


        Object name_tree=null;
        Object string_literal6_tree=null;
        Object char_literal7_tree=null;
        Object char_literal11_tree=null;
        RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_manager=new RewriteRuleSubtreeStream(adaptor,"rule manager");
        RewriteRuleSubtreeStream stream_personunit=new RewriteRuleSubtreeStream(adaptor,"rule personunit");
        RewriteRuleSubtreeStream stream_dept=new RewriteRuleSubtreeStream(adaptor,"rule dept");
        try {
            // Company.g:36:6: ( 'department' name= STRING '{' manager ( personunit )* ( dept )* '}' -> ^( DEPT $name manager ( personunit )* ( dept )* ) )
            // Company.g:37:3: 'department' name= STRING '{' manager ( personunit )* ( dept )* '}'
            {
            string_literal6=(Token)match(input,15,FOLLOW_15_in_dept114);  
            stream_15.add(string_literal6);

            name=(Token)match(input,STRING,FOLLOW_STRING_in_dept118);  
            stream_STRING.add(name);

            char_literal7=(Token)match(input,13,FOLLOW_13_in_dept120);  
            stream_13.add(char_literal7);

            pushFollow(FOLLOW_manager_in_dept127);
            manager8=manager();

            state._fsp--;

            stream_manager.add(manager8.getTree());
            // Company.g:39:5: ( personunit )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Company.g:39:5: personunit
            	    {
            	    pushFollow(FOLLOW_personunit_in_dept133);
            	    personunit9=personunit();

            	    state._fsp--;

            	    stream_personunit.add(personunit9.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Company.g:40:5: ( dept )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:40:5: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_dept140);
            	    dept10=dept();

            	    state._fsp--;

            	    stream_dept.add(dept10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            char_literal11=(Token)match(input,14,FOLLOW_14_in_dept145);  
            stream_14.add(char_literal11);



            // AST REWRITE
            // elements: manager, name, dept, personunit
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 42:3: -> ^( DEPT $name manager ( personunit )* ( dept )* )
            {
                // Company.g:42:6: ^( DEPT $name manager ( personunit )* ( dept )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEPT, "DEPT"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_manager.nextTree());
                // Company.g:42:27: ( personunit )*
                while ( stream_personunit.hasNext() ) {
                    adaptor.addChild(root_1, stream_personunit.nextTree());

                }
                stream_personunit.reset();
                // Company.g:42:39: ( dept )*
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
    // Company.g:45:1: manager : 'manager' employee -> ^( MANAGER employee ) ;
    public final CompanyParser.manager_return manager() throws RecognitionException {
        CompanyParser.manager_return retval = new CompanyParser.manager_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal12=null;
        CompanyParser.employee_return employee13 = null;


        Object string_literal12_tree=null;
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleSubtreeStream stream_employee=new RewriteRuleSubtreeStream(adaptor,"rule employee");
        try {
            // Company.g:45:9: ( 'manager' employee -> ^( MANAGER employee ) )
            // Company.g:46:3: 'manager' employee
            {
            string_literal12=(Token)match(input,16,FOLLOW_16_in_manager179);  
            stream_16.add(string_literal12);

            pushFollow(FOLLOW_employee_in_manager181);
            employee13=employee();

            state._fsp--;

            stream_employee.add(employee13.getTree());


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
            // 47:3: -> ^( MANAGER employee )
            {
                // Company.g:47:6: ^( MANAGER employee )
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

    public static class personunit_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "personunit"
    // Company.g:50:1: personunit : 'employee' employee -> ^( PU employee ) ;
    public final CompanyParser.personunit_return personunit() throws RecognitionException {
        CompanyParser.personunit_return retval = new CompanyParser.personunit_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal14=null;
        CompanyParser.employee_return employee15 = null;


        Object string_literal14_tree=null;
        RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
        RewriteRuleSubtreeStream stream_employee=new RewriteRuleSubtreeStream(adaptor,"rule employee");
        try {
            // Company.g:50:12: ( 'employee' employee -> ^( PU employee ) )
            // Company.g:51:3: 'employee' employee
            {
            string_literal14=(Token)match(input,17,FOLLOW_17_in_personunit206);  
            stream_17.add(string_literal14);

            pushFollow(FOLLOW_employee_in_personunit208);
            employee15=employee();

            state._fsp--;

            stream_employee.add(employee15.getTree());


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
            // 52:3: -> ^( PU employee )
            {
                // Company.g:52:6: ^( PU employee )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PU, "PU"), root_1);

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
    // $ANTLR end "personunit"

    public static class employee_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "employee"
    // Company.g:55:1: employee : n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' -> ^( EMPLOYEE $n $a $s) ;
    public final CompanyParser.employee_return employee() throws RecognitionException {
        CompanyParser.employee_return retval = new CompanyParser.employee_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token a=null;
        Token s=null;
        Token char_literal16=null;
        Token string_literal17=null;
        Token string_literal18=null;
        Token char_literal19=null;

        Object n_tree=null;
        Object a_tree=null;
        Object s_tree=null;
        Object char_literal16_tree=null;
        Object string_literal17_tree=null;
        Object string_literal18_tree=null;
        Object char_literal19_tree=null;
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleTokenStream stream_18=new RewriteRuleTokenStream(adaptor,"token 18");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // Company.g:55:10: (n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' -> ^( EMPLOYEE $n $a $s) )
            // Company.g:56:3: n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}'
            {
            n=(Token)match(input,STRING,FOLLOW_STRING_in_employee236);  
            stream_STRING.add(n);

            char_literal16=(Token)match(input,13,FOLLOW_13_in_employee238);  
            stream_13.add(char_literal16);

            string_literal17=(Token)match(input,18,FOLLOW_18_in_employee244);  
            stream_18.add(string_literal17);

            a=(Token)match(input,STRING,FOLLOW_STRING_in_employee248);  
            stream_STRING.add(a);

            string_literal18=(Token)match(input,19,FOLLOW_19_in_employee254);  
            stream_19.add(string_literal18);

            s=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_employee258);  
            stream_FLOAT.add(s);

            char_literal19=(Token)match(input,14,FOLLOW_14_in_employee262);  
            stream_14.add(char_literal19);



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
            // 60:3: -> ^( EMPLOYEE $n $a $s)
            {
                // Company.g:60:6: ^( EMPLOYEE $n $a $s)
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


 

    public static final BitSet FOLLOW_12_in_company77 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_company79 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_company81 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_dept_in_company83 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_company86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_dept114 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_dept118 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_dept120 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_manager_in_dept127 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_personunit_in_dept133 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_dept_in_dept140 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_dept145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_manager179 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_employee_in_manager181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_personunit206 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_employee_in_personunit208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_employee236 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_employee238 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_employee244 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_employee248 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_employee254 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FLOAT_in_employee258 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_employee262 = new BitSet(new long[]{0x0000000000000002L});

}