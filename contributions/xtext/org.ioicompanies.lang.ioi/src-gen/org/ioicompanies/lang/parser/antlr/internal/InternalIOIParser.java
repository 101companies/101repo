package org.ioicompanies.lang.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.ioicompanies.lang.services.IOIGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIOIParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'IOICompaniesModel'", "'Company'", "'{'", "'Positions:'", "'('", "','", "')'", "'}'", "'Department'", "'subdepartment'", "'Manager'", "'salary'", "'works on'", "'Employee'", "'-'"
    };
    public static final int RULE_ID=4;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalIOIParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIOIParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIOIParser.tokenNames; }
    public String getGrammarFileName() { return "../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g"; }



     	private IOIGrammarAccess grammarAccess;
     	
        public InternalIOIParser(TokenStream input, IOIGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected IOIGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:76:1: ruleModel returns [EObject current=null] : (otherlv_0= 'IOICompaniesModel' ( (lv_name_1_0= RULE_ID ) ) ( (lv_companies_2_0= ruleCompany ) ) ( (lv_companies_3_0= ruleCompany ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_companies_2_0 = null;

        EObject lv_companies_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:79:28: ( (otherlv_0= 'IOICompaniesModel' ( (lv_name_1_0= RULE_ID ) ) ( (lv_companies_2_0= ruleCompany ) ) ( (lv_companies_3_0= ruleCompany ) )* ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:80:1: (otherlv_0= 'IOICompaniesModel' ( (lv_name_1_0= RULE_ID ) ) ( (lv_companies_2_0= ruleCompany ) ) ( (lv_companies_3_0= ruleCompany ) )* )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:80:1: (otherlv_0= 'IOICompaniesModel' ( (lv_name_1_0= RULE_ID ) ) ( (lv_companies_2_0= ruleCompany ) ) ( (lv_companies_3_0= ruleCompany ) )* )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:80:3: otherlv_0= 'IOICompaniesModel' ( (lv_name_1_0= RULE_ID ) ) ( (lv_companies_2_0= ruleCompany ) ) ( (lv_companies_3_0= ruleCompany ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getIOICompaniesModelKeyword_0());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:102:2: ( (lv_companies_2_0= ruleCompany ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:103:1: (lv_companies_2_0= ruleCompany )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:103:1: (lv_companies_2_0= ruleCompany )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:104:3: lv_companies_2_0= ruleCompany
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getCompaniesCompanyParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleCompany_in_ruleModel165);
            lv_companies_2_0=ruleCompany();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"companies",
                    		lv_companies_2_0, 
                    		"Company");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:120:2: ( (lv_companies_3_0= ruleCompany ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:121:1: (lv_companies_3_0= ruleCompany )
            	    {
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:121:1: (lv_companies_3_0= ruleCompany )
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:122:3: lv_companies_3_0= ruleCompany
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getCompaniesCompanyParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCompany_in_ruleModel186);
            	    lv_companies_3_0=ruleCompany();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"companies",
            	            		lv_companies_3_0, 
            	            		"Company");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleEmployee"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:146:1: entryRuleEmployee returns [EObject current=null] : iv_ruleEmployee= ruleEmployee EOF ;
    public final EObject entryRuleEmployee() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmployee = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:147:2: (iv_ruleEmployee= ruleEmployee EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:148:2: iv_ruleEmployee= ruleEmployee EOF
            {
             newCompositeNode(grammarAccess.getEmployeeRule()); 
            pushFollow(FOLLOW_ruleEmployee_in_entryRuleEmployee223);
            iv_ruleEmployee=ruleEmployee();

            state._fsp--;

             current =iv_ruleEmployee; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmployee233); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEmployee"


    // $ANTLR start "ruleEmployee"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:155:1: ruleEmployee returns [EObject current=null] : (this_Employee_Impl_0= ruleEmployee_Impl | this_Manager_1= ruleManager ) ;
    public final EObject ruleEmployee() throws RecognitionException {
        EObject current = null;

        EObject this_Employee_Impl_0 = null;

        EObject this_Manager_1 = null;


         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:158:28: ( (this_Employee_Impl_0= ruleEmployee_Impl | this_Manager_1= ruleManager ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:159:1: (this_Employee_Impl_0= ruleEmployee_Impl | this_Manager_1= ruleManager )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:159:1: (this_Employee_Impl_0= ruleEmployee_Impl | this_Manager_1= ruleManager )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( (LA2_0==21) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:160:5: this_Employee_Impl_0= ruleEmployee_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getEmployeeAccess().getEmployee_ImplParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEmployee_Impl_in_ruleEmployee280);
                    this_Employee_Impl_0=ruleEmployee_Impl();

                    state._fsp--;

                     
                            current = this_Employee_Impl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:170:5: this_Manager_1= ruleManager
                    {
                     
                            newCompositeNode(grammarAccess.getEmployeeAccess().getManagerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleManager_in_ruleEmployee307);
                    this_Manager_1=ruleManager();

                    state._fsp--;

                     
                            current = this_Manager_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEmployee"


    // $ANTLR start "entryRuleCompany"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:186:1: entryRuleCompany returns [EObject current=null] : iv_ruleCompany= ruleCompany EOF ;
    public final EObject entryRuleCompany() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompany = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:187:2: (iv_ruleCompany= ruleCompany EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:188:2: iv_ruleCompany= ruleCompany EOF
            {
             newCompositeNode(grammarAccess.getCompanyRule()); 
            pushFollow(FOLLOW_ruleCompany_in_entryRuleCompany342);
            iv_ruleCompany=ruleCompany();

            state._fsp--;

             current =iv_ruleCompany; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompany352); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompany"


    // $ANTLR start "ruleCompany"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:195:1: ruleCompany returns [EObject current=null] : (otherlv_0= 'Company' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'Positions:' otherlv_4= '(' ( (lv_positions_5_0= rulePosition ) ) (otherlv_6= ',' ( (lv_positions_7_0= rulePosition ) ) )* otherlv_8= ')' ( (lv_departments_9_0= ruleDepartment ) ) ( (lv_departments_10_0= ruleDepartment ) )* otherlv_11= '}' ) ;
    public final EObject ruleCompany() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject lv_positions_5_0 = null;

        EObject lv_positions_7_0 = null;

        EObject lv_departments_9_0 = null;

        EObject lv_departments_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:198:28: ( (otherlv_0= 'Company' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'Positions:' otherlv_4= '(' ( (lv_positions_5_0= rulePosition ) ) (otherlv_6= ',' ( (lv_positions_7_0= rulePosition ) ) )* otherlv_8= ')' ( (lv_departments_9_0= ruleDepartment ) ) ( (lv_departments_10_0= ruleDepartment ) )* otherlv_11= '}' ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:199:1: (otherlv_0= 'Company' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'Positions:' otherlv_4= '(' ( (lv_positions_5_0= rulePosition ) ) (otherlv_6= ',' ( (lv_positions_7_0= rulePosition ) ) )* otherlv_8= ')' ( (lv_departments_9_0= ruleDepartment ) ) ( (lv_departments_10_0= ruleDepartment ) )* otherlv_11= '}' )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:199:1: (otherlv_0= 'Company' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'Positions:' otherlv_4= '(' ( (lv_positions_5_0= rulePosition ) ) (otherlv_6= ',' ( (lv_positions_7_0= rulePosition ) ) )* otherlv_8= ')' ( (lv_departments_9_0= ruleDepartment ) ) ( (lv_departments_10_0= ruleDepartment ) )* otherlv_11= '}' )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:199:3: otherlv_0= 'Company' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'Positions:' otherlv_4= '(' ( (lv_positions_5_0= rulePosition ) ) (otherlv_6= ',' ( (lv_positions_7_0= rulePosition ) ) )* otherlv_8= ')' ( (lv_departments_9_0= ruleDepartment ) ) ( (lv_departments_10_0= ruleDepartment ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleCompany389); 

                	newLeafNode(otherlv_0, grammarAccess.getCompanyAccess().getCompanyKeyword_0());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:203:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:204:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:204:1: (lv_name_1_0= RULE_ID )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:205:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCompany406); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCompanyAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCompanyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleCompany423); 

                	newLeafNode(otherlv_2, grammarAccess.getCompanyAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleCompany435); 

                	newLeafNode(otherlv_3, grammarAccess.getCompanyAccess().getPositionsKeyword_3());
                
            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCompany447); 

                	newLeafNode(otherlv_4, grammarAccess.getCompanyAccess().getLeftParenthesisKeyword_4());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:233:1: ( (lv_positions_5_0= rulePosition ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:234:1: (lv_positions_5_0= rulePosition )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:234:1: (lv_positions_5_0= rulePosition )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:235:3: lv_positions_5_0= rulePosition
            {
             
            	        newCompositeNode(grammarAccess.getCompanyAccess().getPositionsPositionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_rulePosition_in_ruleCompany468);
            lv_positions_5_0=rulePosition();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompanyRule());
            	        }
                   		add(
                   			current, 
                   			"positions",
                    		lv_positions_5_0, 
                    		"Position");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:251:2: (otherlv_6= ',' ( (lv_positions_7_0= rulePosition ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:251:4: otherlv_6= ',' ( (lv_positions_7_0= rulePosition ) )
            	    {
            	    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleCompany481); 

            	        	newLeafNode(otherlv_6, grammarAccess.getCompanyAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:255:1: ( (lv_positions_7_0= rulePosition ) )
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:256:1: (lv_positions_7_0= rulePosition )
            	    {
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:256:1: (lv_positions_7_0= rulePosition )
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:257:3: lv_positions_7_0= rulePosition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompanyAccess().getPositionsPositionParserRuleCall_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePosition_in_ruleCompany502);
            	    lv_positions_7_0=rulePosition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompanyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"positions",
            	            		lv_positions_7_0, 
            	            		"Position");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleCompany516); 

                	newLeafNode(otherlv_8, grammarAccess.getCompanyAccess().getRightParenthesisKeyword_7());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:277:1: ( (lv_departments_9_0= ruleDepartment ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:278:1: (lv_departments_9_0= ruleDepartment )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:278:1: (lv_departments_9_0= ruleDepartment )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:279:3: lv_departments_9_0= ruleDepartment
            {
             
            	        newCompositeNode(grammarAccess.getCompanyAccess().getDepartmentsDepartmentParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleDepartment_in_ruleCompany537);
            lv_departments_9_0=ruleDepartment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompanyRule());
            	        }
                   		add(
                   			current, 
                   			"departments",
                    		lv_departments_9_0, 
                    		"Department");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:295:2: ( (lv_departments_10_0= ruleDepartment ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:296:1: (lv_departments_10_0= ruleDepartment )
            	    {
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:296:1: (lv_departments_10_0= ruleDepartment )
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:297:3: lv_departments_10_0= ruleDepartment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompanyAccess().getDepartmentsDepartmentParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDepartment_in_ruleCompany558);
            	    lv_departments_10_0=ruleDepartment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompanyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"departments",
            	            		lv_departments_10_0, 
            	            		"Department");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_11=(Token)match(input,18,FOLLOW_18_in_ruleCompany571); 

                	newLeafNode(otherlv_11, grammarAccess.getCompanyAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompany"


    // $ANTLR start "entryRuleDepartment"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:325:1: entryRuleDepartment returns [EObject current=null] : iv_ruleDepartment= ruleDepartment EOF ;
    public final EObject entryRuleDepartment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDepartment = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:326:2: (iv_ruleDepartment= ruleDepartment EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:327:2: iv_ruleDepartment= ruleDepartment EOF
            {
             newCompositeNode(grammarAccess.getDepartmentRule()); 
            pushFollow(FOLLOW_ruleDepartment_in_entryRuleDepartment607);
            iv_ruleDepartment=ruleDepartment();

            state._fsp--;

             current =iv_ruleDepartment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDepartment617); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDepartment"


    // $ANTLR start "ruleDepartment"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:334:1: ruleDepartment returns [EObject current=null] : (otherlv_0= 'Department' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_manager_3_0= ruleManager ) ) ( (lv_employees_4_0= ruleEmployee ) ) ( (lv_employees_5_0= ruleEmployee ) )* (otherlv_6= 'subdepartment' ( (lv_sub_department_7_0= ruleDepartment ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleDepartment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_manager_3_0 = null;

        EObject lv_employees_4_0 = null;

        EObject lv_employees_5_0 = null;

        EObject lv_sub_department_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:337:28: ( (otherlv_0= 'Department' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_manager_3_0= ruleManager ) ) ( (lv_employees_4_0= ruleEmployee ) ) ( (lv_employees_5_0= ruleEmployee ) )* (otherlv_6= 'subdepartment' ( (lv_sub_department_7_0= ruleDepartment ) ) )? otherlv_8= '}' ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:338:1: (otherlv_0= 'Department' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_manager_3_0= ruleManager ) ) ( (lv_employees_4_0= ruleEmployee ) ) ( (lv_employees_5_0= ruleEmployee ) )* (otherlv_6= 'subdepartment' ( (lv_sub_department_7_0= ruleDepartment ) ) )? otherlv_8= '}' )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:338:1: (otherlv_0= 'Department' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_manager_3_0= ruleManager ) ) ( (lv_employees_4_0= ruleEmployee ) ) ( (lv_employees_5_0= ruleEmployee ) )* (otherlv_6= 'subdepartment' ( (lv_sub_department_7_0= ruleDepartment ) ) )? otherlv_8= '}' )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:338:3: otherlv_0= 'Department' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_manager_3_0= ruleManager ) ) ( (lv_employees_4_0= ruleEmployee ) ) ( (lv_employees_5_0= ruleEmployee ) )* (otherlv_6= 'subdepartment' ( (lv_sub_department_7_0= ruleDepartment ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleDepartment654); 

                	newLeafNode(otherlv_0, grammarAccess.getDepartmentAccess().getDepartmentKeyword_0());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:342:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:343:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:343:1: (lv_name_1_0= RULE_ID )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:344:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDepartment671); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDepartmentAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDepartmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleDepartment688); 

                	newLeafNode(otherlv_2, grammarAccess.getDepartmentAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:364:1: ( (lv_manager_3_0= ruleManager ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:365:1: (lv_manager_3_0= ruleManager )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:365:1: (lv_manager_3_0= ruleManager )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:366:3: lv_manager_3_0= ruleManager
            {
             
            	        newCompositeNode(grammarAccess.getDepartmentAccess().getManagerManagerParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleManager_in_ruleDepartment709);
            lv_manager_3_0=ruleManager();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDepartmentRule());
            	        }
                   		set(
                   			current, 
                   			"manager",
                    		lv_manager_3_0, 
                    		"Manager");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:382:2: ( (lv_employees_4_0= ruleEmployee ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:383:1: (lv_employees_4_0= ruleEmployee )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:383:1: (lv_employees_4_0= ruleEmployee )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:384:3: lv_employees_4_0= ruleEmployee
            {
             
            	        newCompositeNode(grammarAccess.getDepartmentAccess().getEmployeesEmployeeParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleEmployee_in_ruleDepartment730);
            lv_employees_4_0=ruleEmployee();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDepartmentRule());
            	        }
                   		add(
                   			current, 
                   			"employees",
                    		lv_employees_4_0, 
                    		"Employee");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:400:2: ( (lv_employees_5_0= ruleEmployee ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==21||LA5_0==24) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:401:1: (lv_employees_5_0= ruleEmployee )
            	    {
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:401:1: (lv_employees_5_0= ruleEmployee )
            	    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:402:3: lv_employees_5_0= ruleEmployee
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDepartmentAccess().getEmployeesEmployeeParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEmployee_in_ruleDepartment751);
            	    lv_employees_5_0=ruleEmployee();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDepartmentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"employees",
            	            		lv_employees_5_0, 
            	            		"Employee");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:418:3: (otherlv_6= 'subdepartment' ( (lv_sub_department_7_0= ruleDepartment ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:418:5: otherlv_6= 'subdepartment' ( (lv_sub_department_7_0= ruleDepartment ) )
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleDepartment765); 

                        	newLeafNode(otherlv_6, grammarAccess.getDepartmentAccess().getSubdepartmentKeyword_6_0());
                        
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:422:1: ( (lv_sub_department_7_0= ruleDepartment ) )
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:423:1: (lv_sub_department_7_0= ruleDepartment )
                    {
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:423:1: (lv_sub_department_7_0= ruleDepartment )
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:424:3: lv_sub_department_7_0= ruleDepartment
                    {
                     
                    	        newCompositeNode(grammarAccess.getDepartmentAccess().getSub_departmentDepartmentParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDepartment_in_ruleDepartment786);
                    lv_sub_department_7_0=ruleDepartment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDepartmentRule());
                    	        }
                           		set(
                           			current, 
                           			"sub_department",
                            		lv_sub_department_7_0, 
                            		"Department");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleDepartment800); 

                	newLeafNode(otherlv_8, grammarAccess.getDepartmentAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDepartment"


    // $ANTLR start "entryRulePosition"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:452:1: entryRulePosition returns [EObject current=null] : iv_rulePosition= rulePosition EOF ;
    public final EObject entryRulePosition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePosition = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:453:2: (iv_rulePosition= rulePosition EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:454:2: iv_rulePosition= rulePosition EOF
            {
             newCompositeNode(grammarAccess.getPositionRule()); 
            pushFollow(FOLLOW_rulePosition_in_entryRulePosition836);
            iv_rulePosition=rulePosition();

            state._fsp--;

             current =iv_rulePosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePosition846); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePosition"


    // $ANTLR start "rulePosition"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:461:1: rulePosition returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePosition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:464:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:465:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:465:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:465:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:465:2: ()
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:466:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPositionAccess().getPositionAction_0(),
                        current);
                

            }

            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:471:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:472:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:472:1: (lv_name_1_0= RULE_ID )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:473:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePosition897); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPositionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPositionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePosition"


    // $ANTLR start "entryRuleManager"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:497:1: entryRuleManager returns [EObject current=null] : iv_ruleManager= ruleManager EOF ;
    public final EObject entryRuleManager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManager = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:498:2: (iv_ruleManager= ruleManager EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:499:2: iv_ruleManager= ruleManager EOF
            {
             newCompositeNode(grammarAccess.getManagerRule()); 
            pushFollow(FOLLOW_ruleManager_in_entryRuleManager938);
            iv_ruleManager=ruleManager();

            state._fsp--;

             current =iv_ruleManager; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleManager948); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleManager"


    // $ANTLR start "ruleManager"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:506:1: ruleManager returns [EObject current=null] : (otherlv_0= 'Manager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' ) ;
    public final EObject ruleManager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_salary_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:509:28: ( (otherlv_0= 'Manager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:510:1: (otherlv_0= 'Manager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:510:1: (otherlv_0= 'Manager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:510:3: otherlv_0= 'Manager' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleManager985); 

                	newLeafNode(otherlv_0, grammarAccess.getManagerAccess().getManagerKeyword_0());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:514:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:515:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:515:1: (lv_name_1_0= RULE_ID )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:516:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleManager1002); 

            			newLeafNode(lv_name_1_0, grammarAccess.getManagerAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getManagerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleManager1019); 

                	newLeafNode(otherlv_2, grammarAccess.getManagerAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:536:1: (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:536:3: otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleManager1032); 

                        	newLeafNode(otherlv_3, grammarAccess.getManagerAccess().getSalaryKeyword_3_0());
                        
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:540:1: ( (lv_salary_4_0= ruleEInt ) )
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:541:1: (lv_salary_4_0= ruleEInt )
                    {
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:541:1: (lv_salary_4_0= ruleEInt )
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:542:3: lv_salary_4_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getManagerAccess().getSalaryEIntParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEInt_in_ruleManager1053);
                    lv_salary_4_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getManagerRule());
                    	        }
                           		set(
                           			current, 
                           			"salary",
                            		lv_salary_4_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleManager1067); 

                	newLeafNode(otherlv_5, grammarAccess.getManagerAccess().getWorksOnKeyword_4());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:562:1: ( ( ruleEString ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:563:1: ( ruleEString )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:563:1: ( ruleEString )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:564:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getManagerRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getManagerAccess().getWorks_onPositionCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleManager1090);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleManager1102); 

                	newLeafNode(otherlv_7, grammarAccess.getManagerAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleManager"


    // $ANTLR start "entryRuleEmployee_Impl"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:589:1: entryRuleEmployee_Impl returns [EObject current=null] : iv_ruleEmployee_Impl= ruleEmployee_Impl EOF ;
    public final EObject entryRuleEmployee_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmployee_Impl = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:590:2: (iv_ruleEmployee_Impl= ruleEmployee_Impl EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:591:2: iv_ruleEmployee_Impl= ruleEmployee_Impl EOF
            {
             newCompositeNode(grammarAccess.getEmployee_ImplRule()); 
            pushFollow(FOLLOW_ruleEmployee_Impl_in_entryRuleEmployee_Impl1138);
            iv_ruleEmployee_Impl=ruleEmployee_Impl();

            state._fsp--;

             current =iv_ruleEmployee_Impl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmployee_Impl1148); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEmployee_Impl"


    // $ANTLR start "ruleEmployee_Impl"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:598:1: ruleEmployee_Impl returns [EObject current=null] : (otherlv_0= 'Employee' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' ) ;
    public final EObject ruleEmployee_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_salary_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:601:28: ( (otherlv_0= 'Employee' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:602:1: (otherlv_0= 'Employee' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:602:1: (otherlv_0= 'Employee' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}' )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:602:3: otherlv_0= 'Employee' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )? otherlv_5= 'works on' ( ( ruleEString ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleEmployee_Impl1185); 

                	newLeafNode(otherlv_0, grammarAccess.getEmployee_ImplAccess().getEmployeeKeyword_0());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:606:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:607:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:607:1: (lv_name_1_0= RULE_ID )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:608:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEmployee_Impl1202); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEmployee_ImplAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEmployee_ImplRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleEmployee_Impl1219); 

                	newLeafNode(otherlv_2, grammarAccess.getEmployee_ImplAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:628:1: (otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:628:3: otherlv_3= 'salary' ( (lv_salary_4_0= ruleEInt ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleEmployee_Impl1232); 

                        	newLeafNode(otherlv_3, grammarAccess.getEmployee_ImplAccess().getSalaryKeyword_3_0());
                        
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:632:1: ( (lv_salary_4_0= ruleEInt ) )
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:633:1: (lv_salary_4_0= ruleEInt )
                    {
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:633:1: (lv_salary_4_0= ruleEInt )
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:634:3: lv_salary_4_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmployee_ImplAccess().getSalaryEIntParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEInt_in_ruleEmployee_Impl1253);
                    lv_salary_4_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmployee_ImplRule());
                    	        }
                           		set(
                           			current, 
                           			"salary",
                            		lv_salary_4_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleEmployee_Impl1267); 

                	newLeafNode(otherlv_5, grammarAccess.getEmployee_ImplAccess().getWorksOnKeyword_4());
                
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:654:1: ( ( ruleEString ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:655:1: ( ruleEString )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:655:1: ( ruleEString )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:656:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEmployee_ImplRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEmployee_ImplAccess().getWorks_onPositionCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleEmployee_Impl1290);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleEmployee_Impl1302); 

                	newLeafNode(otherlv_7, grammarAccess.getEmployee_ImplAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEmployee_Impl"


    // $ANTLR start "entryRuleEInt"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:681:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:682:2: (iv_ruleEInt= ruleEInt EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:683:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt1339);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt1350); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:690:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:693:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:694:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:694:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:694:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:694:2: (kw= '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:695:2: kw= '-'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleEInt1389); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEInt1406); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEString"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:715:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:716:2: (iv_ruleEString= ruleEString EOF )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:717:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString1452);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString1463); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:724:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:727:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:728:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:728:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:728:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEString1503); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.ioicompanies.lang.ioi/src-gen/org/ioicompanies/lang/parser/antlr/internal/InternalIOI.g:736:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEString1529); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleCompany_in_ruleModel165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleCompany_in_ruleModel186 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleEmployee_in_entryRuleEmployee223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmployee233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmployee_Impl_in_ruleEmployee280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManager_in_ruleEmployee307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompany_in_entryRuleCompany342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompany352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleCompany389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCompany406 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCompany423 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCompany435 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCompany447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePosition_in_ruleCompany468 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleCompany481 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePosition_in_ruleCompany502 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleCompany516 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleDepartment_in_ruleCompany537 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_ruleDepartment_in_ruleCompany558 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleCompany571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepartment_in_entryRuleDepartment607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDepartment617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDepartment654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDepartment671 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDepartment688 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleManager_in_ruleDepartment709 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_ruleEmployee_in_ruleDepartment730 = new BitSet(new long[]{0x0000000001340000L});
    public static final BitSet FOLLOW_ruleEmployee_in_ruleDepartment751 = new BitSet(new long[]{0x0000000001340000L});
    public static final BitSet FOLLOW_20_in_ruleDepartment765 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleDepartment_in_ruleDepartment786 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDepartment800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_entryRulePosition836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePosition846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePosition897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManager_in_entryRuleManager938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleManager948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleManager985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleManager1002 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleManager1019 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleManager1032 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_ruleEInt_in_ruleManager1053 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleManager1067 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleEString_in_ruleManager1090 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleManager1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmployee_Impl_in_entryRuleEmployee_Impl1138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmployee_Impl1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleEmployee_Impl1185 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEmployee_Impl1202 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEmployee_Impl1219 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleEmployee_Impl1232 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_ruleEInt_in_ruleEmployee_Impl1253 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEmployee_Impl1267 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleEString_in_ruleEmployee_Impl1290 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEmployee_Impl1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt1339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleEInt1389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEInt1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString1452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEString1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEString1529 = new BitSet(new long[]{0x0000000000000002L});

}