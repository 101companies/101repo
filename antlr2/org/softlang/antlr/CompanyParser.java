// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2010-10-09 05:21:50

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


    public static class company_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "company"
    // Company.g:14:1: company : 'company' '{' ( dept )* '}' -> ^( COMPANY ( dept )* ) ;
    public final CompanyParser.company_return company() throws RecognitionException {
        CompanyParser.company_return retval = new CompanyParser.company_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        Token char_literal2=null;
        Token char_literal4=null;
        CompanyParser.dept_return dept3 = null;


        Object string_literal1_tree=null;
        Object char_literal2_tree=null;
        Object char_literal4_tree=null;
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_12=new RewriteRuleTokenStream(adaptor,"token 12");
        RewriteRuleSubtreeStream stream_dept=new RewriteRuleSubtreeStream(adaptor,"rule dept");
        try {
            // Company.g:14:9: ( 'company' '{' ( dept )* '}' -> ^( COMPANY ( dept )* ) )
            // Company.g:15:3: 'company' '{' ( dept )* '}'
            {
            string_literal1=(Token)match(input,12,FOLLOW_12_in_company56);  
            stream_12.add(string_literal1);

            char_literal2=(Token)match(input,13,FOLLOW_13_in_company58);  
            stream_13.add(char_literal2);

            // Company.g:15:17: ( dept )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Company.g:15:17: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_company60);
            	    dept3=dept();

            	    state._fsp--;

            	    stream_dept.add(dept3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal4=(Token)match(input,14,FOLLOW_14_in_company63);  
            stream_14.add(char_literal4);



            // AST REWRITE
            // elements: dept
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 16:3: -> ^( COMPANY ( dept )* )
            {
                // Company.g:16:6: ^( COMPANY ( dept )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPANY, "COMPANY"), root_1);

                // Company.g:16:16: ( dept )*
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
    // Company.g:19:1: dept : 'department' name= STRING '{' manager ( personunit )* ( dept )* '}' -> ^( DEPT $name manager ( personunit )* ( dept )* ) ;
    public final CompanyParser.dept_return dept() throws RecognitionException {
        CompanyParser.dept_return retval = new CompanyParser.dept_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token string_literal5=null;
        Token char_literal6=null;
        Token char_literal10=null;
        CompanyParser.manager_return manager7 = null;

        CompanyParser.personunit_return personunit8 = null;

        CompanyParser.dept_return dept9 = null;


        Object name_tree=null;
        Object string_literal5_tree=null;
        Object char_literal6_tree=null;
        Object char_literal10_tree=null;
        RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_manager=new RewriteRuleSubtreeStream(adaptor,"rule manager");
        RewriteRuleSubtreeStream stream_personunit=new RewriteRuleSubtreeStream(adaptor,"rule personunit");
        RewriteRuleSubtreeStream stream_dept=new RewriteRuleSubtreeStream(adaptor,"rule dept");
        try {
            // Company.g:19:6: ( 'department' name= STRING '{' manager ( personunit )* ( dept )* '}' -> ^( DEPT $name manager ( personunit )* ( dept )* ) )
            // Company.g:20:3: 'department' name= STRING '{' manager ( personunit )* ( dept )* '}'
            {
            string_literal5=(Token)match(input,15,FOLLOW_15_in_dept89);  
            stream_15.add(string_literal5);

            name=(Token)match(input,STRING,FOLLOW_STRING_in_dept93);  
            stream_STRING.add(name);

            char_literal6=(Token)match(input,13,FOLLOW_13_in_dept95);  
            stream_13.add(char_literal6);

            pushFollow(FOLLOW_manager_in_dept102);
            manager7=manager();

            state._fsp--;

            stream_manager.add(manager7.getTree());
            // Company.g:22:5: ( personunit )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Company.g:22:5: personunit
            	    {
            	    pushFollow(FOLLOW_personunit_in_dept108);
            	    personunit8=personunit();

            	    state._fsp--;

            	    stream_personunit.add(personunit8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // Company.g:23:5: ( dept )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:23:5: dept
            	    {
            	    pushFollow(FOLLOW_dept_in_dept115);
            	    dept9=dept();

            	    state._fsp--;

            	    stream_dept.add(dept9.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            char_literal10=(Token)match(input,14,FOLLOW_14_in_dept120);  
            stream_14.add(char_literal10);



            // AST REWRITE
            // elements: dept, name, personunit, manager
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 25:3: -> ^( DEPT $name manager ( personunit )* ( dept )* )
            {
                // Company.g:25:6: ^( DEPT $name manager ( personunit )* ( dept )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEPT, "DEPT"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_manager.nextTree());
                // Company.g:25:27: ( personunit )*
                while ( stream_personunit.hasNext() ) {
                    adaptor.addChild(root_1, stream_personunit.nextTree());

                }
                stream_personunit.reset();
                // Company.g:25:39: ( dept )*
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
    // Company.g:28:1: manager : 'manager' employee -> ^( MANAGER employee ) ;
    public final CompanyParser.manager_return manager() throws RecognitionException {
        CompanyParser.manager_return retval = new CompanyParser.manager_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal11=null;
        CompanyParser.employee_return employee12 = null;


        Object string_literal11_tree=null;
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleSubtreeStream stream_employee=new RewriteRuleSubtreeStream(adaptor,"rule employee");
        try {
            // Company.g:28:9: ( 'manager' employee -> ^( MANAGER employee ) )
            // Company.g:29:3: 'manager' employee
            {
            string_literal11=(Token)match(input,16,FOLLOW_16_in_manager154);  
            stream_16.add(string_literal11);

            pushFollow(FOLLOW_employee_in_manager156);
            employee12=employee();

            state._fsp--;

            stream_employee.add(employee12.getTree());


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
            // 30:3: -> ^( MANAGER employee )
            {
                // Company.g:30:6: ^( MANAGER employee )
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
    // Company.g:33:1: personunit : 'employee' employee -> ^( PU employee ) ;
    public final CompanyParser.personunit_return personunit() throws RecognitionException {
        CompanyParser.personunit_return retval = new CompanyParser.personunit_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal13=null;
        CompanyParser.employee_return employee14 = null;


        Object string_literal13_tree=null;
        RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
        RewriteRuleSubtreeStream stream_employee=new RewriteRuleSubtreeStream(adaptor,"rule employee");
        try {
            // Company.g:33:12: ( 'employee' employee -> ^( PU employee ) )
            // Company.g:34:3: 'employee' employee
            {
            string_literal13=(Token)match(input,17,FOLLOW_17_in_personunit181);  
            stream_17.add(string_literal13);

            pushFollow(FOLLOW_employee_in_personunit183);
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
            // 35:3: -> ^( PU employee )
            {
                // Company.g:35:6: ^( PU employee )
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
    // Company.g:38:1: employee : n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' -> ^( EMPLOYEE $n $a $s) ;
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
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleTokenStream stream_18=new RewriteRuleTokenStream(adaptor,"token 18");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // Company.g:38:10: (n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}' -> ^( EMPLOYEE $n $a $s) )
            // Company.g:39:3: n= STRING '{' 'address' a= STRING 'salary' s= FLOAT '}'
            {
            n=(Token)match(input,STRING,FOLLOW_STRING_in_employee211);  
            stream_STRING.add(n);

            char_literal15=(Token)match(input,13,FOLLOW_13_in_employee213);  
            stream_13.add(char_literal15);

            string_literal16=(Token)match(input,18,FOLLOW_18_in_employee219);  
            stream_18.add(string_literal16);

            a=(Token)match(input,STRING,FOLLOW_STRING_in_employee223);  
            stream_STRING.add(a);

            string_literal17=(Token)match(input,19,FOLLOW_19_in_employee229);  
            stream_19.add(string_literal17);

            s=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_employee233);  
            stream_FLOAT.add(s);

            char_literal18=(Token)match(input,14,FOLLOW_14_in_employee237);  
            stream_14.add(char_literal18);



            // AST REWRITE
            // elements: s, n, a
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
            // 43:3: -> ^( EMPLOYEE $n $a $s)
            {
                // Company.g:43:6: ^( EMPLOYEE $n $a $s)
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


 

    public static final BitSet FOLLOW_12_in_company56 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_company58 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_dept_in_company60 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_company63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_dept89 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_dept93 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_dept95 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_manager_in_dept102 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_personunit_in_dept108 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_dept_in_dept115 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_dept120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_manager154 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_employee_in_manager156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_personunit181 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_employee_in_personunit183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_employee211 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_employee213 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_employee219 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_employee223 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_employee229 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FLOAT_in_employee233 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_employee237 = new BitSet(new long[]{0x0000000000000002L});

}