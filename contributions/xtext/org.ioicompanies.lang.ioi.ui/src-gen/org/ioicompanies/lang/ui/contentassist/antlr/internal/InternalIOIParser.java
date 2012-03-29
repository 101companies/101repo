package org.ioicompanies.lang.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.ioicompanies.lang.services.IOIGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIOIParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'IOICompaniesModel'", "'Company'", "'{'", "'Positions:'", "'('", "')'", "'}'", "','", "'Department'", "'subdepartment'", "'Manager'", "'works on'", "'salary'", "'Employee'", "'-'"
    };
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
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
    public String getGrammarFileName() { return "../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g"; }


     
     	private IOIGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(IOIGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:62:1: ( ruleModel EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:63:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:74:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:75:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:75:1: ( ( rule__Model__Group__0 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:76:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:77:1: ( rule__Model__Group__0 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:77:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleEmployee"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:89:1: entryRuleEmployee : ruleEmployee EOF ;
    public final void entryRuleEmployee() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:90:1: ( ruleEmployee EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:91:1: ruleEmployee EOF
            {
             before(grammarAccess.getEmployeeRule()); 
            pushFollow(FOLLOW_ruleEmployee_in_entryRuleEmployee121);
            ruleEmployee();

            state._fsp--;

             after(grammarAccess.getEmployeeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmployee128); 

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
    // $ANTLR end "entryRuleEmployee"


    // $ANTLR start "ruleEmployee"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:98:1: ruleEmployee : ( ( rule__Employee__Alternatives ) ) ;
    public final void ruleEmployee() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:102:2: ( ( ( rule__Employee__Alternatives ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:103:1: ( ( rule__Employee__Alternatives ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:103:1: ( ( rule__Employee__Alternatives ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:104:1: ( rule__Employee__Alternatives )
            {
             before(grammarAccess.getEmployeeAccess().getAlternatives()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:105:1: ( rule__Employee__Alternatives )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:105:2: rule__Employee__Alternatives
            {
            pushFollow(FOLLOW_rule__Employee__Alternatives_in_ruleEmployee154);
            rule__Employee__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEmployeeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEmployee"


    // $ANTLR start "entryRuleCompany"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:117:1: entryRuleCompany : ruleCompany EOF ;
    public final void entryRuleCompany() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:118:1: ( ruleCompany EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:119:1: ruleCompany EOF
            {
             before(grammarAccess.getCompanyRule()); 
            pushFollow(FOLLOW_ruleCompany_in_entryRuleCompany181);
            ruleCompany();

            state._fsp--;

             after(grammarAccess.getCompanyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompany188); 

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
    // $ANTLR end "entryRuleCompany"


    // $ANTLR start "ruleCompany"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:126:1: ruleCompany : ( ( rule__Company__Group__0 ) ) ;
    public final void ruleCompany() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:130:2: ( ( ( rule__Company__Group__0 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:131:1: ( ( rule__Company__Group__0 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:131:1: ( ( rule__Company__Group__0 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:132:1: ( rule__Company__Group__0 )
            {
             before(grammarAccess.getCompanyAccess().getGroup()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:133:1: ( rule__Company__Group__0 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:133:2: rule__Company__Group__0
            {
            pushFollow(FOLLOW_rule__Company__Group__0_in_ruleCompany214);
            rule__Company__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompanyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCompany"


    // $ANTLR start "entryRuleDepartment"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:145:1: entryRuleDepartment : ruleDepartment EOF ;
    public final void entryRuleDepartment() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:146:1: ( ruleDepartment EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:147:1: ruleDepartment EOF
            {
             before(grammarAccess.getDepartmentRule()); 
            pushFollow(FOLLOW_ruleDepartment_in_entryRuleDepartment241);
            ruleDepartment();

            state._fsp--;

             after(grammarAccess.getDepartmentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDepartment248); 

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
    // $ANTLR end "entryRuleDepartment"


    // $ANTLR start "ruleDepartment"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:154:1: ruleDepartment : ( ( rule__Department__Group__0 ) ) ;
    public final void ruleDepartment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:158:2: ( ( ( rule__Department__Group__0 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:159:1: ( ( rule__Department__Group__0 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:159:1: ( ( rule__Department__Group__0 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:160:1: ( rule__Department__Group__0 )
            {
             before(grammarAccess.getDepartmentAccess().getGroup()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:161:1: ( rule__Department__Group__0 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:161:2: rule__Department__Group__0
            {
            pushFollow(FOLLOW_rule__Department__Group__0_in_ruleDepartment274);
            rule__Department__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDepartmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDepartment"


    // $ANTLR start "entryRulePosition"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:173:1: entryRulePosition : rulePosition EOF ;
    public final void entryRulePosition() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:174:1: ( rulePosition EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:175:1: rulePosition EOF
            {
             before(grammarAccess.getPositionRule()); 
            pushFollow(FOLLOW_rulePosition_in_entryRulePosition301);
            rulePosition();

            state._fsp--;

             after(grammarAccess.getPositionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePosition308); 

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
    // $ANTLR end "entryRulePosition"


    // $ANTLR start "rulePosition"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:182:1: rulePosition : ( ( rule__Position__Group__0 ) ) ;
    public final void rulePosition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:186:2: ( ( ( rule__Position__Group__0 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:187:1: ( ( rule__Position__Group__0 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:187:1: ( ( rule__Position__Group__0 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:188:1: ( rule__Position__Group__0 )
            {
             before(grammarAccess.getPositionAccess().getGroup()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:189:1: ( rule__Position__Group__0 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:189:2: rule__Position__Group__0
            {
            pushFollow(FOLLOW_rule__Position__Group__0_in_rulePosition334);
            rule__Position__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPositionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePosition"


    // $ANTLR start "entryRuleManager"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:201:1: entryRuleManager : ruleManager EOF ;
    public final void entryRuleManager() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:202:1: ( ruleManager EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:203:1: ruleManager EOF
            {
             before(grammarAccess.getManagerRule()); 
            pushFollow(FOLLOW_ruleManager_in_entryRuleManager361);
            ruleManager();

            state._fsp--;

             after(grammarAccess.getManagerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleManager368); 

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
    // $ANTLR end "entryRuleManager"


    // $ANTLR start "ruleManager"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:210:1: ruleManager : ( ( rule__Manager__Group__0 ) ) ;
    public final void ruleManager() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:214:2: ( ( ( rule__Manager__Group__0 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:215:1: ( ( rule__Manager__Group__0 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:215:1: ( ( rule__Manager__Group__0 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:216:1: ( rule__Manager__Group__0 )
            {
             before(grammarAccess.getManagerAccess().getGroup()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:217:1: ( rule__Manager__Group__0 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:217:2: rule__Manager__Group__0
            {
            pushFollow(FOLLOW_rule__Manager__Group__0_in_ruleManager394);
            rule__Manager__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getManagerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleManager"


    // $ANTLR start "entryRuleEmployee_Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:229:1: entryRuleEmployee_Impl : ruleEmployee_Impl EOF ;
    public final void entryRuleEmployee_Impl() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:230:1: ( ruleEmployee_Impl EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:231:1: ruleEmployee_Impl EOF
            {
             before(grammarAccess.getEmployee_ImplRule()); 
            pushFollow(FOLLOW_ruleEmployee_Impl_in_entryRuleEmployee_Impl421);
            ruleEmployee_Impl();

            state._fsp--;

             after(grammarAccess.getEmployee_ImplRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmployee_Impl428); 

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
    // $ANTLR end "entryRuleEmployee_Impl"


    // $ANTLR start "ruleEmployee_Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:238:1: ruleEmployee_Impl : ( ( rule__Employee_Impl__Group__0 ) ) ;
    public final void ruleEmployee_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:242:2: ( ( ( rule__Employee_Impl__Group__0 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:243:1: ( ( rule__Employee_Impl__Group__0 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:243:1: ( ( rule__Employee_Impl__Group__0 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:244:1: ( rule__Employee_Impl__Group__0 )
            {
             before(grammarAccess.getEmployee_ImplAccess().getGroup()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:245:1: ( rule__Employee_Impl__Group__0 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:245:2: rule__Employee_Impl__Group__0
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__0_in_ruleEmployee_Impl454);
            rule__Employee_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEmployee_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEmployee_Impl"


    // $ANTLR start "entryRuleEInt"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:257:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:258:1: ( ruleEInt EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:259:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt481);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt488); 

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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:266:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:270:2: ( ( ( rule__EInt__Group__0 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:271:1: ( ( rule__EInt__Group__0 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:271:1: ( ( rule__EInt__Group__0 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:272:1: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:273:1: ( rule__EInt__Group__0 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:273:2: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_rule__EInt__Group__0_in_ruleEInt514);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEString"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:285:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:286:1: ( ruleEString EOF )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:287:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString541);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString548); 

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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:294:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:298:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:299:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:299:1: ( ( rule__EString__Alternatives ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:300:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:301:1: ( rule__EString__Alternatives )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:301:2: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_rule__EString__Alternatives_in_ruleEString574);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "rule__Employee__Alternatives"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:313:1: rule__Employee__Alternatives : ( ( ruleEmployee_Impl ) | ( ruleManager ) );
    public final void rule__Employee__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:317:1: ( ( ruleEmployee_Impl ) | ( ruleManager ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==24) ) {
                alt1=1;
            }
            else if ( (LA1_0==21) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:318:1: ( ruleEmployee_Impl )
                    {
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:318:1: ( ruleEmployee_Impl )
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:319:1: ruleEmployee_Impl
                    {
                     before(grammarAccess.getEmployeeAccess().getEmployee_ImplParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleEmployee_Impl_in_rule__Employee__Alternatives610);
                    ruleEmployee_Impl();

                    state._fsp--;

                     after(grammarAccess.getEmployeeAccess().getEmployee_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:324:6: ( ruleManager )
                    {
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:324:6: ( ruleManager )
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:325:1: ruleManager
                    {
                     before(grammarAccess.getEmployeeAccess().getManagerParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleManager_in_rule__Employee__Alternatives627);
                    ruleManager();

                    state._fsp--;

                     after(grammarAccess.getEmployeeAccess().getManagerParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:335:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:339:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:340:1: ( RULE_STRING )
                    {
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:340:1: ( RULE_STRING )
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:341:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EString__Alternatives659); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:346:6: ( RULE_ID )
                    {
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:346:6: ( RULE_ID )
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:347:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EString__Alternatives676); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:359:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:363:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:364:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0706);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0709);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:371:1: rule__Model__Group__0__Impl : ( 'IOICompaniesModel' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:375:1: ( ( 'IOICompaniesModel' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:376:1: ( 'IOICompaniesModel' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:376:1: ( 'IOICompaniesModel' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:377:1: 'IOICompaniesModel'
            {
             before(grammarAccess.getModelAccess().getIOICompaniesModelKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Model__Group__0__Impl737); 
             after(grammarAccess.getModelAccess().getIOICompaniesModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:390:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:394:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:395:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1768);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1771);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:402:1: rule__Model__Group__1__Impl : ( ( rule__Model__NameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:406:1: ( ( ( rule__Model__NameAssignment_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:407:1: ( ( rule__Model__NameAssignment_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:407:1: ( ( rule__Model__NameAssignment_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:408:1: ( rule__Model__NameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:409:1: ( rule__Model__NameAssignment_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:409:2: rule__Model__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_1_in_rule__Model__Group__1__Impl798);
            rule__Model__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:419:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:423:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:424:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__2828);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__2831);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:431:1: rule__Model__Group__2__Impl : ( ( rule__Model__CompaniesAssignment_2 ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:435:1: ( ( ( rule__Model__CompaniesAssignment_2 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:436:1: ( ( rule__Model__CompaniesAssignment_2 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:436:1: ( ( rule__Model__CompaniesAssignment_2 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:437:1: ( rule__Model__CompaniesAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getCompaniesAssignment_2()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:438:1: ( rule__Model__CompaniesAssignment_2 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:438:2: rule__Model__CompaniesAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__CompaniesAssignment_2_in_rule__Model__Group__2__Impl858);
            rule__Model__CompaniesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getCompaniesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:448:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:452:1: ( rule__Model__Group__3__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:453:2: rule__Model__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__3888);
            rule__Model__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:459:1: rule__Model__Group__3__Impl : ( ( rule__Model__CompaniesAssignment_3 )* ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:463:1: ( ( ( rule__Model__CompaniesAssignment_3 )* ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:464:1: ( ( rule__Model__CompaniesAssignment_3 )* )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:464:1: ( ( rule__Model__CompaniesAssignment_3 )* )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:465:1: ( rule__Model__CompaniesAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getCompaniesAssignment_3()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:466:1: ( rule__Model__CompaniesAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:466:2: rule__Model__CompaniesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Model__CompaniesAssignment_3_in_rule__Model__Group__3__Impl915);
            	    rule__Model__CompaniesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getCompaniesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Company__Group__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:484:1: rule__Company__Group__0 : rule__Company__Group__0__Impl rule__Company__Group__1 ;
    public final void rule__Company__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:488:1: ( rule__Company__Group__0__Impl rule__Company__Group__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:489:2: rule__Company__Group__0__Impl rule__Company__Group__1
            {
            pushFollow(FOLLOW_rule__Company__Group__0__Impl_in_rule__Company__Group__0954);
            rule__Company__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__1_in_rule__Company__Group__0957);
            rule__Company__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__0"


    // $ANTLR start "rule__Company__Group__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:496:1: rule__Company__Group__0__Impl : ( 'Company' ) ;
    public final void rule__Company__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:500:1: ( ( 'Company' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:501:1: ( 'Company' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:501:1: ( 'Company' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:502:1: 'Company'
            {
             before(grammarAccess.getCompanyAccess().getCompanyKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__Company__Group__0__Impl985); 
             after(grammarAccess.getCompanyAccess().getCompanyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__0__Impl"


    // $ANTLR start "rule__Company__Group__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:515:1: rule__Company__Group__1 : rule__Company__Group__1__Impl rule__Company__Group__2 ;
    public final void rule__Company__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:519:1: ( rule__Company__Group__1__Impl rule__Company__Group__2 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:520:2: rule__Company__Group__1__Impl rule__Company__Group__2
            {
            pushFollow(FOLLOW_rule__Company__Group__1__Impl_in_rule__Company__Group__11016);
            rule__Company__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__2_in_rule__Company__Group__11019);
            rule__Company__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__1"


    // $ANTLR start "rule__Company__Group__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:527:1: rule__Company__Group__1__Impl : ( ( rule__Company__NameAssignment_1 ) ) ;
    public final void rule__Company__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:531:1: ( ( ( rule__Company__NameAssignment_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:532:1: ( ( rule__Company__NameAssignment_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:532:1: ( ( rule__Company__NameAssignment_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:533:1: ( rule__Company__NameAssignment_1 )
            {
             before(grammarAccess.getCompanyAccess().getNameAssignment_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:534:1: ( rule__Company__NameAssignment_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:534:2: rule__Company__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Company__NameAssignment_1_in_rule__Company__Group__1__Impl1046);
            rule__Company__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCompanyAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__1__Impl"


    // $ANTLR start "rule__Company__Group__2"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:544:1: rule__Company__Group__2 : rule__Company__Group__2__Impl rule__Company__Group__3 ;
    public final void rule__Company__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:548:1: ( rule__Company__Group__2__Impl rule__Company__Group__3 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:549:2: rule__Company__Group__2__Impl rule__Company__Group__3
            {
            pushFollow(FOLLOW_rule__Company__Group__2__Impl_in_rule__Company__Group__21076);
            rule__Company__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__3_in_rule__Company__Group__21079);
            rule__Company__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__2"


    // $ANTLR start "rule__Company__Group__2__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:556:1: rule__Company__Group__2__Impl : ( '{' ) ;
    public final void rule__Company__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:560:1: ( ( '{' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:561:1: ( '{' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:561:1: ( '{' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:562:1: '{'
            {
             before(grammarAccess.getCompanyAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Company__Group__2__Impl1107); 
             after(grammarAccess.getCompanyAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__2__Impl"


    // $ANTLR start "rule__Company__Group__3"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:575:1: rule__Company__Group__3 : rule__Company__Group__3__Impl rule__Company__Group__4 ;
    public final void rule__Company__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:579:1: ( rule__Company__Group__3__Impl rule__Company__Group__4 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:580:2: rule__Company__Group__3__Impl rule__Company__Group__4
            {
            pushFollow(FOLLOW_rule__Company__Group__3__Impl_in_rule__Company__Group__31138);
            rule__Company__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__4_in_rule__Company__Group__31141);
            rule__Company__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__3"


    // $ANTLR start "rule__Company__Group__3__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:587:1: rule__Company__Group__3__Impl : ( 'Positions:' ) ;
    public final void rule__Company__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:591:1: ( ( 'Positions:' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:592:1: ( 'Positions:' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:592:1: ( 'Positions:' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:593:1: 'Positions:'
            {
             before(grammarAccess.getCompanyAccess().getPositionsKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__Company__Group__3__Impl1169); 
             after(grammarAccess.getCompanyAccess().getPositionsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__3__Impl"


    // $ANTLR start "rule__Company__Group__4"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:606:1: rule__Company__Group__4 : rule__Company__Group__4__Impl rule__Company__Group__5 ;
    public final void rule__Company__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:610:1: ( rule__Company__Group__4__Impl rule__Company__Group__5 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:611:2: rule__Company__Group__4__Impl rule__Company__Group__5
            {
            pushFollow(FOLLOW_rule__Company__Group__4__Impl_in_rule__Company__Group__41200);
            rule__Company__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__5_in_rule__Company__Group__41203);
            rule__Company__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__4"


    // $ANTLR start "rule__Company__Group__4__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:618:1: rule__Company__Group__4__Impl : ( '(' ) ;
    public final void rule__Company__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:622:1: ( ( '(' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:623:1: ( '(' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:623:1: ( '(' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:624:1: '('
            {
             before(grammarAccess.getCompanyAccess().getLeftParenthesisKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__Company__Group__4__Impl1231); 
             after(grammarAccess.getCompanyAccess().getLeftParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__4__Impl"


    // $ANTLR start "rule__Company__Group__5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:637:1: rule__Company__Group__5 : rule__Company__Group__5__Impl rule__Company__Group__6 ;
    public final void rule__Company__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:641:1: ( rule__Company__Group__5__Impl rule__Company__Group__6 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:642:2: rule__Company__Group__5__Impl rule__Company__Group__6
            {
            pushFollow(FOLLOW_rule__Company__Group__5__Impl_in_rule__Company__Group__51262);
            rule__Company__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__6_in_rule__Company__Group__51265);
            rule__Company__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__5"


    // $ANTLR start "rule__Company__Group__5__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:649:1: rule__Company__Group__5__Impl : ( ( rule__Company__PositionsAssignment_5 ) ) ;
    public final void rule__Company__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:653:1: ( ( ( rule__Company__PositionsAssignment_5 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:654:1: ( ( rule__Company__PositionsAssignment_5 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:654:1: ( ( rule__Company__PositionsAssignment_5 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:655:1: ( rule__Company__PositionsAssignment_5 )
            {
             before(grammarAccess.getCompanyAccess().getPositionsAssignment_5()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:656:1: ( rule__Company__PositionsAssignment_5 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:656:2: rule__Company__PositionsAssignment_5
            {
            pushFollow(FOLLOW_rule__Company__PositionsAssignment_5_in_rule__Company__Group__5__Impl1292);
            rule__Company__PositionsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCompanyAccess().getPositionsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__5__Impl"


    // $ANTLR start "rule__Company__Group__6"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:666:1: rule__Company__Group__6 : rule__Company__Group__6__Impl rule__Company__Group__7 ;
    public final void rule__Company__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:670:1: ( rule__Company__Group__6__Impl rule__Company__Group__7 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:671:2: rule__Company__Group__6__Impl rule__Company__Group__7
            {
            pushFollow(FOLLOW_rule__Company__Group__6__Impl_in_rule__Company__Group__61322);
            rule__Company__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__7_in_rule__Company__Group__61325);
            rule__Company__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__6"


    // $ANTLR start "rule__Company__Group__6__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:678:1: rule__Company__Group__6__Impl : ( ( rule__Company__Group_6__0 )* ) ;
    public final void rule__Company__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:682:1: ( ( ( rule__Company__Group_6__0 )* ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:683:1: ( ( rule__Company__Group_6__0 )* )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:683:1: ( ( rule__Company__Group_6__0 )* )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:684:1: ( rule__Company__Group_6__0 )*
            {
             before(grammarAccess.getCompanyAccess().getGroup_6()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:685:1: ( rule__Company__Group_6__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:685:2: rule__Company__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__Company__Group_6__0_in_rule__Company__Group__6__Impl1352);
            	    rule__Company__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getCompanyAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__6__Impl"


    // $ANTLR start "rule__Company__Group__7"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:695:1: rule__Company__Group__7 : rule__Company__Group__7__Impl rule__Company__Group__8 ;
    public final void rule__Company__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:699:1: ( rule__Company__Group__7__Impl rule__Company__Group__8 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:700:2: rule__Company__Group__7__Impl rule__Company__Group__8
            {
            pushFollow(FOLLOW_rule__Company__Group__7__Impl_in_rule__Company__Group__71383);
            rule__Company__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__8_in_rule__Company__Group__71386);
            rule__Company__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__7"


    // $ANTLR start "rule__Company__Group__7__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:707:1: rule__Company__Group__7__Impl : ( ')' ) ;
    public final void rule__Company__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:711:1: ( ( ')' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:712:1: ( ')' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:712:1: ( ')' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:713:1: ')'
            {
             before(grammarAccess.getCompanyAccess().getRightParenthesisKeyword_7()); 
            match(input,16,FOLLOW_16_in_rule__Company__Group__7__Impl1414); 
             after(grammarAccess.getCompanyAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__7__Impl"


    // $ANTLR start "rule__Company__Group__8"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:726:1: rule__Company__Group__8 : rule__Company__Group__8__Impl rule__Company__Group__9 ;
    public final void rule__Company__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:730:1: ( rule__Company__Group__8__Impl rule__Company__Group__9 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:731:2: rule__Company__Group__8__Impl rule__Company__Group__9
            {
            pushFollow(FOLLOW_rule__Company__Group__8__Impl_in_rule__Company__Group__81445);
            rule__Company__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__9_in_rule__Company__Group__81448);
            rule__Company__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__8"


    // $ANTLR start "rule__Company__Group__8__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:738:1: rule__Company__Group__8__Impl : ( ( rule__Company__DepartmentsAssignment_8 ) ) ;
    public final void rule__Company__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:742:1: ( ( ( rule__Company__DepartmentsAssignment_8 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:743:1: ( ( rule__Company__DepartmentsAssignment_8 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:743:1: ( ( rule__Company__DepartmentsAssignment_8 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:744:1: ( rule__Company__DepartmentsAssignment_8 )
            {
             before(grammarAccess.getCompanyAccess().getDepartmentsAssignment_8()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:745:1: ( rule__Company__DepartmentsAssignment_8 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:745:2: rule__Company__DepartmentsAssignment_8
            {
            pushFollow(FOLLOW_rule__Company__DepartmentsAssignment_8_in_rule__Company__Group__8__Impl1475);
            rule__Company__DepartmentsAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getCompanyAccess().getDepartmentsAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__8__Impl"


    // $ANTLR start "rule__Company__Group__9"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:755:1: rule__Company__Group__9 : rule__Company__Group__9__Impl rule__Company__Group__10 ;
    public final void rule__Company__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:759:1: ( rule__Company__Group__9__Impl rule__Company__Group__10 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:760:2: rule__Company__Group__9__Impl rule__Company__Group__10
            {
            pushFollow(FOLLOW_rule__Company__Group__9__Impl_in_rule__Company__Group__91505);
            rule__Company__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group__10_in_rule__Company__Group__91508);
            rule__Company__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__9"


    // $ANTLR start "rule__Company__Group__9__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:767:1: rule__Company__Group__9__Impl : ( ( rule__Company__DepartmentsAssignment_9 )* ) ;
    public final void rule__Company__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:771:1: ( ( ( rule__Company__DepartmentsAssignment_9 )* ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:772:1: ( ( rule__Company__DepartmentsAssignment_9 )* )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:772:1: ( ( rule__Company__DepartmentsAssignment_9 )* )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:773:1: ( rule__Company__DepartmentsAssignment_9 )*
            {
             before(grammarAccess.getCompanyAccess().getDepartmentsAssignment_9()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:774:1: ( rule__Company__DepartmentsAssignment_9 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:774:2: rule__Company__DepartmentsAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__Company__DepartmentsAssignment_9_in_rule__Company__Group__9__Impl1535);
            	    rule__Company__DepartmentsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getCompanyAccess().getDepartmentsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__9__Impl"


    // $ANTLR start "rule__Company__Group__10"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:784:1: rule__Company__Group__10 : rule__Company__Group__10__Impl ;
    public final void rule__Company__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:788:1: ( rule__Company__Group__10__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:789:2: rule__Company__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__Company__Group__10__Impl_in_rule__Company__Group__101566);
            rule__Company__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__10"


    // $ANTLR start "rule__Company__Group__10__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:795:1: rule__Company__Group__10__Impl : ( '}' ) ;
    public final void rule__Company__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:799:1: ( ( '}' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:800:1: ( '}' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:800:1: ( '}' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:801:1: '}'
            {
             before(grammarAccess.getCompanyAccess().getRightCurlyBracketKeyword_10()); 
            match(input,17,FOLLOW_17_in_rule__Company__Group__10__Impl1594); 
             after(grammarAccess.getCompanyAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group__10__Impl"


    // $ANTLR start "rule__Company__Group_6__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:836:1: rule__Company__Group_6__0 : rule__Company__Group_6__0__Impl rule__Company__Group_6__1 ;
    public final void rule__Company__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:840:1: ( rule__Company__Group_6__0__Impl rule__Company__Group_6__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:841:2: rule__Company__Group_6__0__Impl rule__Company__Group_6__1
            {
            pushFollow(FOLLOW_rule__Company__Group_6__0__Impl_in_rule__Company__Group_6__01647);
            rule__Company__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Company__Group_6__1_in_rule__Company__Group_6__01650);
            rule__Company__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group_6__0"


    // $ANTLR start "rule__Company__Group_6__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:848:1: rule__Company__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Company__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:852:1: ( ( ',' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:853:1: ( ',' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:853:1: ( ',' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:854:1: ','
            {
             before(grammarAccess.getCompanyAccess().getCommaKeyword_6_0()); 
            match(input,18,FOLLOW_18_in_rule__Company__Group_6__0__Impl1678); 
             after(grammarAccess.getCompanyAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group_6__0__Impl"


    // $ANTLR start "rule__Company__Group_6__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:867:1: rule__Company__Group_6__1 : rule__Company__Group_6__1__Impl ;
    public final void rule__Company__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:871:1: ( rule__Company__Group_6__1__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:872:2: rule__Company__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__Company__Group_6__1__Impl_in_rule__Company__Group_6__11709);
            rule__Company__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group_6__1"


    // $ANTLR start "rule__Company__Group_6__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:878:1: rule__Company__Group_6__1__Impl : ( ( rule__Company__PositionsAssignment_6_1 ) ) ;
    public final void rule__Company__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:882:1: ( ( ( rule__Company__PositionsAssignment_6_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:883:1: ( ( rule__Company__PositionsAssignment_6_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:883:1: ( ( rule__Company__PositionsAssignment_6_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:884:1: ( rule__Company__PositionsAssignment_6_1 )
            {
             before(grammarAccess.getCompanyAccess().getPositionsAssignment_6_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:885:1: ( rule__Company__PositionsAssignment_6_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:885:2: rule__Company__PositionsAssignment_6_1
            {
            pushFollow(FOLLOW_rule__Company__PositionsAssignment_6_1_in_rule__Company__Group_6__1__Impl1736);
            rule__Company__PositionsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getCompanyAccess().getPositionsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__Group_6__1__Impl"


    // $ANTLR start "rule__Department__Group__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:899:1: rule__Department__Group__0 : rule__Department__Group__0__Impl rule__Department__Group__1 ;
    public final void rule__Department__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:903:1: ( rule__Department__Group__0__Impl rule__Department__Group__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:904:2: rule__Department__Group__0__Impl rule__Department__Group__1
            {
            pushFollow(FOLLOW_rule__Department__Group__0__Impl_in_rule__Department__Group__01770);
            rule__Department__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group__1_in_rule__Department__Group__01773);
            rule__Department__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__0"


    // $ANTLR start "rule__Department__Group__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:911:1: rule__Department__Group__0__Impl : ( 'Department' ) ;
    public final void rule__Department__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:915:1: ( ( 'Department' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:916:1: ( 'Department' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:916:1: ( 'Department' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:917:1: 'Department'
            {
             before(grammarAccess.getDepartmentAccess().getDepartmentKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Department__Group__0__Impl1801); 
             after(grammarAccess.getDepartmentAccess().getDepartmentKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__0__Impl"


    // $ANTLR start "rule__Department__Group__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:930:1: rule__Department__Group__1 : rule__Department__Group__1__Impl rule__Department__Group__2 ;
    public final void rule__Department__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:934:1: ( rule__Department__Group__1__Impl rule__Department__Group__2 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:935:2: rule__Department__Group__1__Impl rule__Department__Group__2
            {
            pushFollow(FOLLOW_rule__Department__Group__1__Impl_in_rule__Department__Group__11832);
            rule__Department__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group__2_in_rule__Department__Group__11835);
            rule__Department__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__1"


    // $ANTLR start "rule__Department__Group__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:942:1: rule__Department__Group__1__Impl : ( ( rule__Department__NameAssignment_1 ) ) ;
    public final void rule__Department__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:946:1: ( ( ( rule__Department__NameAssignment_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:947:1: ( ( rule__Department__NameAssignment_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:947:1: ( ( rule__Department__NameAssignment_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:948:1: ( rule__Department__NameAssignment_1 )
            {
             before(grammarAccess.getDepartmentAccess().getNameAssignment_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:949:1: ( rule__Department__NameAssignment_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:949:2: rule__Department__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Department__NameAssignment_1_in_rule__Department__Group__1__Impl1862);
            rule__Department__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDepartmentAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__1__Impl"


    // $ANTLR start "rule__Department__Group__2"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:959:1: rule__Department__Group__2 : rule__Department__Group__2__Impl rule__Department__Group__3 ;
    public final void rule__Department__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:963:1: ( rule__Department__Group__2__Impl rule__Department__Group__3 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:964:2: rule__Department__Group__2__Impl rule__Department__Group__3
            {
            pushFollow(FOLLOW_rule__Department__Group__2__Impl_in_rule__Department__Group__21892);
            rule__Department__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group__3_in_rule__Department__Group__21895);
            rule__Department__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__2"


    // $ANTLR start "rule__Department__Group__2__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:971:1: rule__Department__Group__2__Impl : ( '{' ) ;
    public final void rule__Department__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:975:1: ( ( '{' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:976:1: ( '{' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:976:1: ( '{' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:977:1: '{'
            {
             before(grammarAccess.getDepartmentAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Department__Group__2__Impl1923); 
             after(grammarAccess.getDepartmentAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__2__Impl"


    // $ANTLR start "rule__Department__Group__3"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:990:1: rule__Department__Group__3 : rule__Department__Group__3__Impl rule__Department__Group__4 ;
    public final void rule__Department__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:994:1: ( rule__Department__Group__3__Impl rule__Department__Group__4 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:995:2: rule__Department__Group__3__Impl rule__Department__Group__4
            {
            pushFollow(FOLLOW_rule__Department__Group__3__Impl_in_rule__Department__Group__31954);
            rule__Department__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group__4_in_rule__Department__Group__31957);
            rule__Department__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__3"


    // $ANTLR start "rule__Department__Group__3__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1002:1: rule__Department__Group__3__Impl : ( ( rule__Department__ManagerAssignment_3 ) ) ;
    public final void rule__Department__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1006:1: ( ( ( rule__Department__ManagerAssignment_3 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1007:1: ( ( rule__Department__ManagerAssignment_3 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1007:1: ( ( rule__Department__ManagerAssignment_3 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1008:1: ( rule__Department__ManagerAssignment_3 )
            {
             before(grammarAccess.getDepartmentAccess().getManagerAssignment_3()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1009:1: ( rule__Department__ManagerAssignment_3 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1009:2: rule__Department__ManagerAssignment_3
            {
            pushFollow(FOLLOW_rule__Department__ManagerAssignment_3_in_rule__Department__Group__3__Impl1984);
            rule__Department__ManagerAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDepartmentAccess().getManagerAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__3__Impl"


    // $ANTLR start "rule__Department__Group__4"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1019:1: rule__Department__Group__4 : rule__Department__Group__4__Impl rule__Department__Group__5 ;
    public final void rule__Department__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1023:1: ( rule__Department__Group__4__Impl rule__Department__Group__5 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1024:2: rule__Department__Group__4__Impl rule__Department__Group__5
            {
            pushFollow(FOLLOW_rule__Department__Group__4__Impl_in_rule__Department__Group__42014);
            rule__Department__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group__5_in_rule__Department__Group__42017);
            rule__Department__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__4"


    // $ANTLR start "rule__Department__Group__4__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1031:1: rule__Department__Group__4__Impl : ( ( rule__Department__EmployeesAssignment_4 ) ) ;
    public final void rule__Department__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1035:1: ( ( ( rule__Department__EmployeesAssignment_4 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1036:1: ( ( rule__Department__EmployeesAssignment_4 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1036:1: ( ( rule__Department__EmployeesAssignment_4 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1037:1: ( rule__Department__EmployeesAssignment_4 )
            {
             before(grammarAccess.getDepartmentAccess().getEmployeesAssignment_4()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1038:1: ( rule__Department__EmployeesAssignment_4 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1038:2: rule__Department__EmployeesAssignment_4
            {
            pushFollow(FOLLOW_rule__Department__EmployeesAssignment_4_in_rule__Department__Group__4__Impl2044);
            rule__Department__EmployeesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDepartmentAccess().getEmployeesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__4__Impl"


    // $ANTLR start "rule__Department__Group__5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1048:1: rule__Department__Group__5 : rule__Department__Group__5__Impl rule__Department__Group__6 ;
    public final void rule__Department__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1052:1: ( rule__Department__Group__5__Impl rule__Department__Group__6 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1053:2: rule__Department__Group__5__Impl rule__Department__Group__6
            {
            pushFollow(FOLLOW_rule__Department__Group__5__Impl_in_rule__Department__Group__52074);
            rule__Department__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group__6_in_rule__Department__Group__52077);
            rule__Department__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__5"


    // $ANTLR start "rule__Department__Group__5__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1060:1: rule__Department__Group__5__Impl : ( ( rule__Department__EmployeesAssignment_5 )* ) ;
    public final void rule__Department__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1064:1: ( ( ( rule__Department__EmployeesAssignment_5 )* ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1065:1: ( ( rule__Department__EmployeesAssignment_5 )* )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1065:1: ( ( rule__Department__EmployeesAssignment_5 )* )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1066:1: ( rule__Department__EmployeesAssignment_5 )*
            {
             before(grammarAccess.getDepartmentAccess().getEmployeesAssignment_5()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1067:1: ( rule__Department__EmployeesAssignment_5 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==21||LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1067:2: rule__Department__EmployeesAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Department__EmployeesAssignment_5_in_rule__Department__Group__5__Impl2104);
            	    rule__Department__EmployeesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getDepartmentAccess().getEmployeesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__5__Impl"


    // $ANTLR start "rule__Department__Group__6"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1077:1: rule__Department__Group__6 : rule__Department__Group__6__Impl rule__Department__Group__7 ;
    public final void rule__Department__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1081:1: ( rule__Department__Group__6__Impl rule__Department__Group__7 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1082:2: rule__Department__Group__6__Impl rule__Department__Group__7
            {
            pushFollow(FOLLOW_rule__Department__Group__6__Impl_in_rule__Department__Group__62135);
            rule__Department__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group__7_in_rule__Department__Group__62138);
            rule__Department__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__6"


    // $ANTLR start "rule__Department__Group__6__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1089:1: rule__Department__Group__6__Impl : ( ( rule__Department__Group_6__0 )? ) ;
    public final void rule__Department__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1093:1: ( ( ( rule__Department__Group_6__0 )? ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1094:1: ( ( rule__Department__Group_6__0 )? )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1094:1: ( ( rule__Department__Group_6__0 )? )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1095:1: ( rule__Department__Group_6__0 )?
            {
             before(grammarAccess.getDepartmentAccess().getGroup_6()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1096:1: ( rule__Department__Group_6__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1096:2: rule__Department__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Department__Group_6__0_in_rule__Department__Group__6__Impl2165);
                    rule__Department__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDepartmentAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__6__Impl"


    // $ANTLR start "rule__Department__Group__7"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1106:1: rule__Department__Group__7 : rule__Department__Group__7__Impl ;
    public final void rule__Department__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1110:1: ( rule__Department__Group__7__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1111:2: rule__Department__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Department__Group__7__Impl_in_rule__Department__Group__72196);
            rule__Department__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__7"


    // $ANTLR start "rule__Department__Group__7__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1117:1: rule__Department__Group__7__Impl : ( '}' ) ;
    public final void rule__Department__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1121:1: ( ( '}' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1122:1: ( '}' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1122:1: ( '}' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1123:1: '}'
            {
             before(grammarAccess.getDepartmentAccess().getRightCurlyBracketKeyword_7()); 
            match(input,17,FOLLOW_17_in_rule__Department__Group__7__Impl2224); 
             after(grammarAccess.getDepartmentAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group__7__Impl"


    // $ANTLR start "rule__Department__Group_6__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1152:1: rule__Department__Group_6__0 : rule__Department__Group_6__0__Impl rule__Department__Group_6__1 ;
    public final void rule__Department__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1156:1: ( rule__Department__Group_6__0__Impl rule__Department__Group_6__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1157:2: rule__Department__Group_6__0__Impl rule__Department__Group_6__1
            {
            pushFollow(FOLLOW_rule__Department__Group_6__0__Impl_in_rule__Department__Group_6__02271);
            rule__Department__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Department__Group_6__1_in_rule__Department__Group_6__02274);
            rule__Department__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group_6__0"


    // $ANTLR start "rule__Department__Group_6__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1164:1: rule__Department__Group_6__0__Impl : ( 'subdepartment' ) ;
    public final void rule__Department__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1168:1: ( ( 'subdepartment' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1169:1: ( 'subdepartment' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1169:1: ( 'subdepartment' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1170:1: 'subdepartment'
            {
             before(grammarAccess.getDepartmentAccess().getSubdepartmentKeyword_6_0()); 
            match(input,20,FOLLOW_20_in_rule__Department__Group_6__0__Impl2302); 
             after(grammarAccess.getDepartmentAccess().getSubdepartmentKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group_6__0__Impl"


    // $ANTLR start "rule__Department__Group_6__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1183:1: rule__Department__Group_6__1 : rule__Department__Group_6__1__Impl ;
    public final void rule__Department__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1187:1: ( rule__Department__Group_6__1__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1188:2: rule__Department__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__Department__Group_6__1__Impl_in_rule__Department__Group_6__12333);
            rule__Department__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group_6__1"


    // $ANTLR start "rule__Department__Group_6__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1194:1: rule__Department__Group_6__1__Impl : ( ( rule__Department__Sub_departmentAssignment_6_1 ) ) ;
    public final void rule__Department__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1198:1: ( ( ( rule__Department__Sub_departmentAssignment_6_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1199:1: ( ( rule__Department__Sub_departmentAssignment_6_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1199:1: ( ( rule__Department__Sub_departmentAssignment_6_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1200:1: ( rule__Department__Sub_departmentAssignment_6_1 )
            {
             before(grammarAccess.getDepartmentAccess().getSub_departmentAssignment_6_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1201:1: ( rule__Department__Sub_departmentAssignment_6_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1201:2: rule__Department__Sub_departmentAssignment_6_1
            {
            pushFollow(FOLLOW_rule__Department__Sub_departmentAssignment_6_1_in_rule__Department__Group_6__1__Impl2360);
            rule__Department__Sub_departmentAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getDepartmentAccess().getSub_departmentAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Group_6__1__Impl"


    // $ANTLR start "rule__Position__Group__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1215:1: rule__Position__Group__0 : rule__Position__Group__0__Impl rule__Position__Group__1 ;
    public final void rule__Position__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1219:1: ( rule__Position__Group__0__Impl rule__Position__Group__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1220:2: rule__Position__Group__0__Impl rule__Position__Group__1
            {
            pushFollow(FOLLOW_rule__Position__Group__0__Impl_in_rule__Position__Group__02394);
            rule__Position__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Position__Group__1_in_rule__Position__Group__02397);
            rule__Position__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Position__Group__0"


    // $ANTLR start "rule__Position__Group__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1227:1: rule__Position__Group__0__Impl : ( () ) ;
    public final void rule__Position__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1231:1: ( ( () ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1232:1: ( () )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1232:1: ( () )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1233:1: ()
            {
             before(grammarAccess.getPositionAccess().getPositionAction_0()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1234:1: ()
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1236:1: 
            {
            }

             after(grammarAccess.getPositionAccess().getPositionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Position__Group__0__Impl"


    // $ANTLR start "rule__Position__Group__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1246:1: rule__Position__Group__1 : rule__Position__Group__1__Impl ;
    public final void rule__Position__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1250:1: ( rule__Position__Group__1__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1251:2: rule__Position__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Position__Group__1__Impl_in_rule__Position__Group__12455);
            rule__Position__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Position__Group__1"


    // $ANTLR start "rule__Position__Group__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1257:1: rule__Position__Group__1__Impl : ( ( rule__Position__NameAssignment_1 ) ) ;
    public final void rule__Position__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1261:1: ( ( ( rule__Position__NameAssignment_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1262:1: ( ( rule__Position__NameAssignment_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1262:1: ( ( rule__Position__NameAssignment_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1263:1: ( rule__Position__NameAssignment_1 )
            {
             before(grammarAccess.getPositionAccess().getNameAssignment_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1264:1: ( rule__Position__NameAssignment_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1264:2: rule__Position__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Position__NameAssignment_1_in_rule__Position__Group__1__Impl2482);
            rule__Position__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPositionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Position__Group__1__Impl"


    // $ANTLR start "rule__Manager__Group__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1278:1: rule__Manager__Group__0 : rule__Manager__Group__0__Impl rule__Manager__Group__1 ;
    public final void rule__Manager__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1282:1: ( rule__Manager__Group__0__Impl rule__Manager__Group__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1283:2: rule__Manager__Group__0__Impl rule__Manager__Group__1
            {
            pushFollow(FOLLOW_rule__Manager__Group__0__Impl_in_rule__Manager__Group__02516);
            rule__Manager__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Manager__Group__1_in_rule__Manager__Group__02519);
            rule__Manager__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__0"


    // $ANTLR start "rule__Manager__Group__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1290:1: rule__Manager__Group__0__Impl : ( 'Manager' ) ;
    public final void rule__Manager__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1294:1: ( ( 'Manager' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1295:1: ( 'Manager' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1295:1: ( 'Manager' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1296:1: 'Manager'
            {
             before(grammarAccess.getManagerAccess().getManagerKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__Manager__Group__0__Impl2547); 
             after(grammarAccess.getManagerAccess().getManagerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__0__Impl"


    // $ANTLR start "rule__Manager__Group__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1309:1: rule__Manager__Group__1 : rule__Manager__Group__1__Impl rule__Manager__Group__2 ;
    public final void rule__Manager__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1313:1: ( rule__Manager__Group__1__Impl rule__Manager__Group__2 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1314:2: rule__Manager__Group__1__Impl rule__Manager__Group__2
            {
            pushFollow(FOLLOW_rule__Manager__Group__1__Impl_in_rule__Manager__Group__12578);
            rule__Manager__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Manager__Group__2_in_rule__Manager__Group__12581);
            rule__Manager__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__1"


    // $ANTLR start "rule__Manager__Group__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1321:1: rule__Manager__Group__1__Impl : ( ( rule__Manager__NameAssignment_1 ) ) ;
    public final void rule__Manager__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1325:1: ( ( ( rule__Manager__NameAssignment_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1326:1: ( ( rule__Manager__NameAssignment_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1326:1: ( ( rule__Manager__NameAssignment_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1327:1: ( rule__Manager__NameAssignment_1 )
            {
             before(grammarAccess.getManagerAccess().getNameAssignment_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1328:1: ( rule__Manager__NameAssignment_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1328:2: rule__Manager__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Manager__NameAssignment_1_in_rule__Manager__Group__1__Impl2608);
            rule__Manager__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getManagerAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__1__Impl"


    // $ANTLR start "rule__Manager__Group__2"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1338:1: rule__Manager__Group__2 : rule__Manager__Group__2__Impl rule__Manager__Group__3 ;
    public final void rule__Manager__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1342:1: ( rule__Manager__Group__2__Impl rule__Manager__Group__3 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1343:2: rule__Manager__Group__2__Impl rule__Manager__Group__3
            {
            pushFollow(FOLLOW_rule__Manager__Group__2__Impl_in_rule__Manager__Group__22638);
            rule__Manager__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Manager__Group__3_in_rule__Manager__Group__22641);
            rule__Manager__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__2"


    // $ANTLR start "rule__Manager__Group__2__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1350:1: rule__Manager__Group__2__Impl : ( '{' ) ;
    public final void rule__Manager__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1354:1: ( ( '{' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1355:1: ( '{' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1355:1: ( '{' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1356:1: '{'
            {
             before(grammarAccess.getManagerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Manager__Group__2__Impl2669); 
             after(grammarAccess.getManagerAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__2__Impl"


    // $ANTLR start "rule__Manager__Group__3"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1369:1: rule__Manager__Group__3 : rule__Manager__Group__3__Impl rule__Manager__Group__4 ;
    public final void rule__Manager__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1373:1: ( rule__Manager__Group__3__Impl rule__Manager__Group__4 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1374:2: rule__Manager__Group__3__Impl rule__Manager__Group__4
            {
            pushFollow(FOLLOW_rule__Manager__Group__3__Impl_in_rule__Manager__Group__32700);
            rule__Manager__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Manager__Group__4_in_rule__Manager__Group__32703);
            rule__Manager__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__3"


    // $ANTLR start "rule__Manager__Group__3__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1381:1: rule__Manager__Group__3__Impl : ( ( rule__Manager__Group_3__0 )? ) ;
    public final void rule__Manager__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1385:1: ( ( ( rule__Manager__Group_3__0 )? ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1386:1: ( ( rule__Manager__Group_3__0 )? )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1386:1: ( ( rule__Manager__Group_3__0 )? )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1387:1: ( rule__Manager__Group_3__0 )?
            {
             before(grammarAccess.getManagerAccess().getGroup_3()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1388:1: ( rule__Manager__Group_3__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1388:2: rule__Manager__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Manager__Group_3__0_in_rule__Manager__Group__3__Impl2730);
                    rule__Manager__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getManagerAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__3__Impl"


    // $ANTLR start "rule__Manager__Group__4"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1398:1: rule__Manager__Group__4 : rule__Manager__Group__4__Impl rule__Manager__Group__5 ;
    public final void rule__Manager__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1402:1: ( rule__Manager__Group__4__Impl rule__Manager__Group__5 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1403:2: rule__Manager__Group__4__Impl rule__Manager__Group__5
            {
            pushFollow(FOLLOW_rule__Manager__Group__4__Impl_in_rule__Manager__Group__42761);
            rule__Manager__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Manager__Group__5_in_rule__Manager__Group__42764);
            rule__Manager__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__4"


    // $ANTLR start "rule__Manager__Group__4__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1410:1: rule__Manager__Group__4__Impl : ( 'works on' ) ;
    public final void rule__Manager__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1414:1: ( ( 'works on' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1415:1: ( 'works on' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1415:1: ( 'works on' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1416:1: 'works on'
            {
             before(grammarAccess.getManagerAccess().getWorksOnKeyword_4()); 
            match(input,22,FOLLOW_22_in_rule__Manager__Group__4__Impl2792); 
             after(grammarAccess.getManagerAccess().getWorksOnKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__4__Impl"


    // $ANTLR start "rule__Manager__Group__5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1429:1: rule__Manager__Group__5 : rule__Manager__Group__5__Impl rule__Manager__Group__6 ;
    public final void rule__Manager__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1433:1: ( rule__Manager__Group__5__Impl rule__Manager__Group__6 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1434:2: rule__Manager__Group__5__Impl rule__Manager__Group__6
            {
            pushFollow(FOLLOW_rule__Manager__Group__5__Impl_in_rule__Manager__Group__52823);
            rule__Manager__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Manager__Group__6_in_rule__Manager__Group__52826);
            rule__Manager__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__5"


    // $ANTLR start "rule__Manager__Group__5__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1441:1: rule__Manager__Group__5__Impl : ( ( rule__Manager__Works_onAssignment_5 ) ) ;
    public final void rule__Manager__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1445:1: ( ( ( rule__Manager__Works_onAssignment_5 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1446:1: ( ( rule__Manager__Works_onAssignment_5 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1446:1: ( ( rule__Manager__Works_onAssignment_5 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1447:1: ( rule__Manager__Works_onAssignment_5 )
            {
             before(grammarAccess.getManagerAccess().getWorks_onAssignment_5()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1448:1: ( rule__Manager__Works_onAssignment_5 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1448:2: rule__Manager__Works_onAssignment_5
            {
            pushFollow(FOLLOW_rule__Manager__Works_onAssignment_5_in_rule__Manager__Group__5__Impl2853);
            rule__Manager__Works_onAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getManagerAccess().getWorks_onAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__5__Impl"


    // $ANTLR start "rule__Manager__Group__6"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1458:1: rule__Manager__Group__6 : rule__Manager__Group__6__Impl ;
    public final void rule__Manager__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1462:1: ( rule__Manager__Group__6__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1463:2: rule__Manager__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Manager__Group__6__Impl_in_rule__Manager__Group__62883);
            rule__Manager__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__6"


    // $ANTLR start "rule__Manager__Group__6__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1469:1: rule__Manager__Group__6__Impl : ( '}' ) ;
    public final void rule__Manager__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1473:1: ( ( '}' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1474:1: ( '}' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1474:1: ( '}' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1475:1: '}'
            {
             before(grammarAccess.getManagerAccess().getRightCurlyBracketKeyword_6()); 
            match(input,17,FOLLOW_17_in_rule__Manager__Group__6__Impl2911); 
             after(grammarAccess.getManagerAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group__6__Impl"


    // $ANTLR start "rule__Manager__Group_3__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1502:1: rule__Manager__Group_3__0 : rule__Manager__Group_3__0__Impl rule__Manager__Group_3__1 ;
    public final void rule__Manager__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1506:1: ( rule__Manager__Group_3__0__Impl rule__Manager__Group_3__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1507:2: rule__Manager__Group_3__0__Impl rule__Manager__Group_3__1
            {
            pushFollow(FOLLOW_rule__Manager__Group_3__0__Impl_in_rule__Manager__Group_3__02956);
            rule__Manager__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Manager__Group_3__1_in_rule__Manager__Group_3__02959);
            rule__Manager__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group_3__0"


    // $ANTLR start "rule__Manager__Group_3__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1514:1: rule__Manager__Group_3__0__Impl : ( 'salary' ) ;
    public final void rule__Manager__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1518:1: ( ( 'salary' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1519:1: ( 'salary' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1519:1: ( 'salary' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1520:1: 'salary'
            {
             before(grammarAccess.getManagerAccess().getSalaryKeyword_3_0()); 
            match(input,23,FOLLOW_23_in_rule__Manager__Group_3__0__Impl2987); 
             after(grammarAccess.getManagerAccess().getSalaryKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group_3__0__Impl"


    // $ANTLR start "rule__Manager__Group_3__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1533:1: rule__Manager__Group_3__1 : rule__Manager__Group_3__1__Impl ;
    public final void rule__Manager__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1537:1: ( rule__Manager__Group_3__1__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1538:2: rule__Manager__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Manager__Group_3__1__Impl_in_rule__Manager__Group_3__13018);
            rule__Manager__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group_3__1"


    // $ANTLR start "rule__Manager__Group_3__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1544:1: rule__Manager__Group_3__1__Impl : ( ( rule__Manager__SalaryAssignment_3_1 ) ) ;
    public final void rule__Manager__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1548:1: ( ( ( rule__Manager__SalaryAssignment_3_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1549:1: ( ( rule__Manager__SalaryAssignment_3_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1549:1: ( ( rule__Manager__SalaryAssignment_3_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1550:1: ( rule__Manager__SalaryAssignment_3_1 )
            {
             before(grammarAccess.getManagerAccess().getSalaryAssignment_3_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1551:1: ( rule__Manager__SalaryAssignment_3_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1551:2: rule__Manager__SalaryAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Manager__SalaryAssignment_3_1_in_rule__Manager__Group_3__1__Impl3045);
            rule__Manager__SalaryAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getManagerAccess().getSalaryAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Group_3__1__Impl"


    // $ANTLR start "rule__Employee_Impl__Group__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1565:1: rule__Employee_Impl__Group__0 : rule__Employee_Impl__Group__0__Impl rule__Employee_Impl__Group__1 ;
    public final void rule__Employee_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1569:1: ( rule__Employee_Impl__Group__0__Impl rule__Employee_Impl__Group__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1570:2: rule__Employee_Impl__Group__0__Impl rule__Employee_Impl__Group__1
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__0__Impl_in_rule__Employee_Impl__Group__03079);
            rule__Employee_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Employee_Impl__Group__1_in_rule__Employee_Impl__Group__03082);
            rule__Employee_Impl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__0"


    // $ANTLR start "rule__Employee_Impl__Group__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1577:1: rule__Employee_Impl__Group__0__Impl : ( 'Employee' ) ;
    public final void rule__Employee_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1581:1: ( ( 'Employee' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1582:1: ( 'Employee' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1582:1: ( 'Employee' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1583:1: 'Employee'
            {
             before(grammarAccess.getEmployee_ImplAccess().getEmployeeKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__Employee_Impl__Group__0__Impl3110); 
             after(grammarAccess.getEmployee_ImplAccess().getEmployeeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__0__Impl"


    // $ANTLR start "rule__Employee_Impl__Group__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1596:1: rule__Employee_Impl__Group__1 : rule__Employee_Impl__Group__1__Impl rule__Employee_Impl__Group__2 ;
    public final void rule__Employee_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1600:1: ( rule__Employee_Impl__Group__1__Impl rule__Employee_Impl__Group__2 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1601:2: rule__Employee_Impl__Group__1__Impl rule__Employee_Impl__Group__2
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__1__Impl_in_rule__Employee_Impl__Group__13141);
            rule__Employee_Impl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Employee_Impl__Group__2_in_rule__Employee_Impl__Group__13144);
            rule__Employee_Impl__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__1"


    // $ANTLR start "rule__Employee_Impl__Group__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1608:1: rule__Employee_Impl__Group__1__Impl : ( ( rule__Employee_Impl__NameAssignment_1 ) ) ;
    public final void rule__Employee_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1612:1: ( ( ( rule__Employee_Impl__NameAssignment_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1613:1: ( ( rule__Employee_Impl__NameAssignment_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1613:1: ( ( rule__Employee_Impl__NameAssignment_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1614:1: ( rule__Employee_Impl__NameAssignment_1 )
            {
             before(grammarAccess.getEmployee_ImplAccess().getNameAssignment_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1615:1: ( rule__Employee_Impl__NameAssignment_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1615:2: rule__Employee_Impl__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Employee_Impl__NameAssignment_1_in_rule__Employee_Impl__Group__1__Impl3171);
            rule__Employee_Impl__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEmployee_ImplAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__1__Impl"


    // $ANTLR start "rule__Employee_Impl__Group__2"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1625:1: rule__Employee_Impl__Group__2 : rule__Employee_Impl__Group__2__Impl rule__Employee_Impl__Group__3 ;
    public final void rule__Employee_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1629:1: ( rule__Employee_Impl__Group__2__Impl rule__Employee_Impl__Group__3 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1630:2: rule__Employee_Impl__Group__2__Impl rule__Employee_Impl__Group__3
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__2__Impl_in_rule__Employee_Impl__Group__23201);
            rule__Employee_Impl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Employee_Impl__Group__3_in_rule__Employee_Impl__Group__23204);
            rule__Employee_Impl__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__2"


    // $ANTLR start "rule__Employee_Impl__Group__2__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1637:1: rule__Employee_Impl__Group__2__Impl : ( '{' ) ;
    public final void rule__Employee_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1641:1: ( ( '{' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1642:1: ( '{' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1642:1: ( '{' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1643:1: '{'
            {
             before(grammarAccess.getEmployee_ImplAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Employee_Impl__Group__2__Impl3232); 
             after(grammarAccess.getEmployee_ImplAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__2__Impl"


    // $ANTLR start "rule__Employee_Impl__Group__3"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1656:1: rule__Employee_Impl__Group__3 : rule__Employee_Impl__Group__3__Impl rule__Employee_Impl__Group__4 ;
    public final void rule__Employee_Impl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1660:1: ( rule__Employee_Impl__Group__3__Impl rule__Employee_Impl__Group__4 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1661:2: rule__Employee_Impl__Group__3__Impl rule__Employee_Impl__Group__4
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__3__Impl_in_rule__Employee_Impl__Group__33263);
            rule__Employee_Impl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Employee_Impl__Group__4_in_rule__Employee_Impl__Group__33266);
            rule__Employee_Impl__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__3"


    // $ANTLR start "rule__Employee_Impl__Group__3__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1668:1: rule__Employee_Impl__Group__3__Impl : ( ( rule__Employee_Impl__Group_3__0 )? ) ;
    public final void rule__Employee_Impl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1672:1: ( ( ( rule__Employee_Impl__Group_3__0 )? ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1673:1: ( ( rule__Employee_Impl__Group_3__0 )? )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1673:1: ( ( rule__Employee_Impl__Group_3__0 )? )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1674:1: ( rule__Employee_Impl__Group_3__0 )?
            {
             before(grammarAccess.getEmployee_ImplAccess().getGroup_3()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1675:1: ( rule__Employee_Impl__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1675:2: rule__Employee_Impl__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Employee_Impl__Group_3__0_in_rule__Employee_Impl__Group__3__Impl3293);
                    rule__Employee_Impl__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEmployee_ImplAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__3__Impl"


    // $ANTLR start "rule__Employee_Impl__Group__4"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1685:1: rule__Employee_Impl__Group__4 : rule__Employee_Impl__Group__4__Impl rule__Employee_Impl__Group__5 ;
    public final void rule__Employee_Impl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1689:1: ( rule__Employee_Impl__Group__4__Impl rule__Employee_Impl__Group__5 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1690:2: rule__Employee_Impl__Group__4__Impl rule__Employee_Impl__Group__5
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__4__Impl_in_rule__Employee_Impl__Group__43324);
            rule__Employee_Impl__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Employee_Impl__Group__5_in_rule__Employee_Impl__Group__43327);
            rule__Employee_Impl__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__4"


    // $ANTLR start "rule__Employee_Impl__Group__4__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1697:1: rule__Employee_Impl__Group__4__Impl : ( 'works on' ) ;
    public final void rule__Employee_Impl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1701:1: ( ( 'works on' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1702:1: ( 'works on' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1702:1: ( 'works on' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1703:1: 'works on'
            {
             before(grammarAccess.getEmployee_ImplAccess().getWorksOnKeyword_4()); 
            match(input,22,FOLLOW_22_in_rule__Employee_Impl__Group__4__Impl3355); 
             after(grammarAccess.getEmployee_ImplAccess().getWorksOnKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__4__Impl"


    // $ANTLR start "rule__Employee_Impl__Group__5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1716:1: rule__Employee_Impl__Group__5 : rule__Employee_Impl__Group__5__Impl rule__Employee_Impl__Group__6 ;
    public final void rule__Employee_Impl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1720:1: ( rule__Employee_Impl__Group__5__Impl rule__Employee_Impl__Group__6 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1721:2: rule__Employee_Impl__Group__5__Impl rule__Employee_Impl__Group__6
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__5__Impl_in_rule__Employee_Impl__Group__53386);
            rule__Employee_Impl__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Employee_Impl__Group__6_in_rule__Employee_Impl__Group__53389);
            rule__Employee_Impl__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__5"


    // $ANTLR start "rule__Employee_Impl__Group__5__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1728:1: rule__Employee_Impl__Group__5__Impl : ( ( rule__Employee_Impl__Works_onAssignment_5 ) ) ;
    public final void rule__Employee_Impl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1732:1: ( ( ( rule__Employee_Impl__Works_onAssignment_5 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1733:1: ( ( rule__Employee_Impl__Works_onAssignment_5 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1733:1: ( ( rule__Employee_Impl__Works_onAssignment_5 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1734:1: ( rule__Employee_Impl__Works_onAssignment_5 )
            {
             before(grammarAccess.getEmployee_ImplAccess().getWorks_onAssignment_5()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1735:1: ( rule__Employee_Impl__Works_onAssignment_5 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1735:2: rule__Employee_Impl__Works_onAssignment_5
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Works_onAssignment_5_in_rule__Employee_Impl__Group__5__Impl3416);
            rule__Employee_Impl__Works_onAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEmployee_ImplAccess().getWorks_onAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__5__Impl"


    // $ANTLR start "rule__Employee_Impl__Group__6"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1745:1: rule__Employee_Impl__Group__6 : rule__Employee_Impl__Group__6__Impl ;
    public final void rule__Employee_Impl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1749:1: ( rule__Employee_Impl__Group__6__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1750:2: rule__Employee_Impl__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group__6__Impl_in_rule__Employee_Impl__Group__63446);
            rule__Employee_Impl__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__6"


    // $ANTLR start "rule__Employee_Impl__Group__6__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1756:1: rule__Employee_Impl__Group__6__Impl : ( '}' ) ;
    public final void rule__Employee_Impl__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1760:1: ( ( '}' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1761:1: ( '}' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1761:1: ( '}' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1762:1: '}'
            {
             before(grammarAccess.getEmployee_ImplAccess().getRightCurlyBracketKeyword_6()); 
            match(input,17,FOLLOW_17_in_rule__Employee_Impl__Group__6__Impl3474); 
             after(grammarAccess.getEmployee_ImplAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group__6__Impl"


    // $ANTLR start "rule__Employee_Impl__Group_3__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1789:1: rule__Employee_Impl__Group_3__0 : rule__Employee_Impl__Group_3__0__Impl rule__Employee_Impl__Group_3__1 ;
    public final void rule__Employee_Impl__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1793:1: ( rule__Employee_Impl__Group_3__0__Impl rule__Employee_Impl__Group_3__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1794:2: rule__Employee_Impl__Group_3__0__Impl rule__Employee_Impl__Group_3__1
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group_3__0__Impl_in_rule__Employee_Impl__Group_3__03519);
            rule__Employee_Impl__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Employee_Impl__Group_3__1_in_rule__Employee_Impl__Group_3__03522);
            rule__Employee_Impl__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group_3__0"


    // $ANTLR start "rule__Employee_Impl__Group_3__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1801:1: rule__Employee_Impl__Group_3__0__Impl : ( 'salary' ) ;
    public final void rule__Employee_Impl__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1805:1: ( ( 'salary' ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1806:1: ( 'salary' )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1806:1: ( 'salary' )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1807:1: 'salary'
            {
             before(grammarAccess.getEmployee_ImplAccess().getSalaryKeyword_3_0()); 
            match(input,23,FOLLOW_23_in_rule__Employee_Impl__Group_3__0__Impl3550); 
             after(grammarAccess.getEmployee_ImplAccess().getSalaryKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group_3__0__Impl"


    // $ANTLR start "rule__Employee_Impl__Group_3__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1820:1: rule__Employee_Impl__Group_3__1 : rule__Employee_Impl__Group_3__1__Impl ;
    public final void rule__Employee_Impl__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1824:1: ( rule__Employee_Impl__Group_3__1__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1825:2: rule__Employee_Impl__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Employee_Impl__Group_3__1__Impl_in_rule__Employee_Impl__Group_3__13581);
            rule__Employee_Impl__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group_3__1"


    // $ANTLR start "rule__Employee_Impl__Group_3__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1831:1: rule__Employee_Impl__Group_3__1__Impl : ( ( rule__Employee_Impl__SalaryAssignment_3_1 ) ) ;
    public final void rule__Employee_Impl__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1835:1: ( ( ( rule__Employee_Impl__SalaryAssignment_3_1 ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1836:1: ( ( rule__Employee_Impl__SalaryAssignment_3_1 ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1836:1: ( ( rule__Employee_Impl__SalaryAssignment_3_1 ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1837:1: ( rule__Employee_Impl__SalaryAssignment_3_1 )
            {
             before(grammarAccess.getEmployee_ImplAccess().getSalaryAssignment_3_1()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1838:1: ( rule__Employee_Impl__SalaryAssignment_3_1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1838:2: rule__Employee_Impl__SalaryAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Employee_Impl__SalaryAssignment_3_1_in_rule__Employee_Impl__Group_3__1__Impl3608);
            rule__Employee_Impl__SalaryAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getEmployee_ImplAccess().getSalaryAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Group_3__1__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1852:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1856:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1857:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__03642);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__03645);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1864:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1868:1: ( ( ( '-' )? ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1869:1: ( ( '-' )? )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1869:1: ( ( '-' )? )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1870:1: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1871:1: ( '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1872:2: '-'
                    {
                    match(input,25,FOLLOW_25_in_rule__EInt__Group__0__Impl3674); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1883:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1887:1: ( rule__EInt__Group__1__Impl )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1888:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__13707);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1894:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1898:1: ( ( RULE_INT ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1899:1: ( RULE_INT )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1899:1: ( RULE_INT )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1900:1: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl3734); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__Model__NameAssignment_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1916:1: rule__Model__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1920:1: ( ( RULE_ID ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1921:1: ( RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1921:1: ( RULE_ID )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1922:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_13772); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1"


    // $ANTLR start "rule__Model__CompaniesAssignment_2"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1931:1: rule__Model__CompaniesAssignment_2 : ( ruleCompany ) ;
    public final void rule__Model__CompaniesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1935:1: ( ( ruleCompany ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1936:1: ( ruleCompany )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1936:1: ( ruleCompany )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1937:1: ruleCompany
            {
             before(grammarAccess.getModelAccess().getCompaniesCompanyParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleCompany_in_rule__Model__CompaniesAssignment_23803);
            ruleCompany();

            state._fsp--;

             after(grammarAccess.getModelAccess().getCompaniesCompanyParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__CompaniesAssignment_2"


    // $ANTLR start "rule__Model__CompaniesAssignment_3"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1946:1: rule__Model__CompaniesAssignment_3 : ( ruleCompany ) ;
    public final void rule__Model__CompaniesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1950:1: ( ( ruleCompany ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1951:1: ( ruleCompany )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1951:1: ( ruleCompany )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1952:1: ruleCompany
            {
             before(grammarAccess.getModelAccess().getCompaniesCompanyParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCompany_in_rule__Model__CompaniesAssignment_33834);
            ruleCompany();

            state._fsp--;

             after(grammarAccess.getModelAccess().getCompaniesCompanyParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__CompaniesAssignment_3"


    // $ANTLR start "rule__Company__NameAssignment_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1961:1: rule__Company__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Company__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1965:1: ( ( RULE_ID ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1966:1: ( RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1966:1: ( RULE_ID )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1967:1: RULE_ID
            {
             before(grammarAccess.getCompanyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Company__NameAssignment_13865); 
             after(grammarAccess.getCompanyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__NameAssignment_1"


    // $ANTLR start "rule__Company__PositionsAssignment_5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1976:1: rule__Company__PositionsAssignment_5 : ( rulePosition ) ;
    public final void rule__Company__PositionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1980:1: ( ( rulePosition ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1981:1: ( rulePosition )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1981:1: ( rulePosition )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1982:1: rulePosition
            {
             before(grammarAccess.getCompanyAccess().getPositionsPositionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_rulePosition_in_rule__Company__PositionsAssignment_53896);
            rulePosition();

            state._fsp--;

             after(grammarAccess.getCompanyAccess().getPositionsPositionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__PositionsAssignment_5"


    // $ANTLR start "rule__Company__PositionsAssignment_6_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1991:1: rule__Company__PositionsAssignment_6_1 : ( rulePosition ) ;
    public final void rule__Company__PositionsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1995:1: ( ( rulePosition ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1996:1: ( rulePosition )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1996:1: ( rulePosition )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:1997:1: rulePosition
            {
             before(grammarAccess.getCompanyAccess().getPositionsPositionParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_rulePosition_in_rule__Company__PositionsAssignment_6_13927);
            rulePosition();

            state._fsp--;

             after(grammarAccess.getCompanyAccess().getPositionsPositionParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__PositionsAssignment_6_1"


    // $ANTLR start "rule__Company__DepartmentsAssignment_8"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2006:1: rule__Company__DepartmentsAssignment_8 : ( ruleDepartment ) ;
    public final void rule__Company__DepartmentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2010:1: ( ( ruleDepartment ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2011:1: ( ruleDepartment )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2011:1: ( ruleDepartment )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2012:1: ruleDepartment
            {
             before(grammarAccess.getCompanyAccess().getDepartmentsDepartmentParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleDepartment_in_rule__Company__DepartmentsAssignment_83958);
            ruleDepartment();

            state._fsp--;

             after(grammarAccess.getCompanyAccess().getDepartmentsDepartmentParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__DepartmentsAssignment_8"


    // $ANTLR start "rule__Company__DepartmentsAssignment_9"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2021:1: rule__Company__DepartmentsAssignment_9 : ( ruleDepartment ) ;
    public final void rule__Company__DepartmentsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2025:1: ( ( ruleDepartment ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2026:1: ( ruleDepartment )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2026:1: ( ruleDepartment )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2027:1: ruleDepartment
            {
             before(grammarAccess.getCompanyAccess().getDepartmentsDepartmentParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleDepartment_in_rule__Company__DepartmentsAssignment_93989);
            ruleDepartment();

            state._fsp--;

             after(grammarAccess.getCompanyAccess().getDepartmentsDepartmentParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Company__DepartmentsAssignment_9"


    // $ANTLR start "rule__Department__NameAssignment_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2036:1: rule__Department__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Department__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2040:1: ( ( RULE_ID ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2041:1: ( RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2041:1: ( RULE_ID )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2042:1: RULE_ID
            {
             before(grammarAccess.getDepartmentAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Department__NameAssignment_14020); 
             after(grammarAccess.getDepartmentAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__NameAssignment_1"


    // $ANTLR start "rule__Department__ManagerAssignment_3"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2051:1: rule__Department__ManagerAssignment_3 : ( ruleManager ) ;
    public final void rule__Department__ManagerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2055:1: ( ( ruleManager ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2056:1: ( ruleManager )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2056:1: ( ruleManager )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2057:1: ruleManager
            {
             before(grammarAccess.getDepartmentAccess().getManagerManagerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleManager_in_rule__Department__ManagerAssignment_34051);
            ruleManager();

            state._fsp--;

             after(grammarAccess.getDepartmentAccess().getManagerManagerParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__ManagerAssignment_3"


    // $ANTLR start "rule__Department__EmployeesAssignment_4"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2066:1: rule__Department__EmployeesAssignment_4 : ( ruleEmployee ) ;
    public final void rule__Department__EmployeesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2070:1: ( ( ruleEmployee ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2071:1: ( ruleEmployee )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2071:1: ( ruleEmployee )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2072:1: ruleEmployee
            {
             before(grammarAccess.getDepartmentAccess().getEmployeesEmployeeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleEmployee_in_rule__Department__EmployeesAssignment_44082);
            ruleEmployee();

            state._fsp--;

             after(grammarAccess.getDepartmentAccess().getEmployeesEmployeeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__EmployeesAssignment_4"


    // $ANTLR start "rule__Department__EmployeesAssignment_5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2081:1: rule__Department__EmployeesAssignment_5 : ( ruleEmployee ) ;
    public final void rule__Department__EmployeesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2085:1: ( ( ruleEmployee ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2086:1: ( ruleEmployee )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2086:1: ( ruleEmployee )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2087:1: ruleEmployee
            {
             before(grammarAccess.getDepartmentAccess().getEmployeesEmployeeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleEmployee_in_rule__Department__EmployeesAssignment_54113);
            ruleEmployee();

            state._fsp--;

             after(grammarAccess.getDepartmentAccess().getEmployeesEmployeeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__EmployeesAssignment_5"


    // $ANTLR start "rule__Department__Sub_departmentAssignment_6_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2096:1: rule__Department__Sub_departmentAssignment_6_1 : ( ruleDepartment ) ;
    public final void rule__Department__Sub_departmentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2100:1: ( ( ruleDepartment ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2101:1: ( ruleDepartment )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2101:1: ( ruleDepartment )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2102:1: ruleDepartment
            {
             before(grammarAccess.getDepartmentAccess().getSub_departmentDepartmentParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleDepartment_in_rule__Department__Sub_departmentAssignment_6_14144);
            ruleDepartment();

            state._fsp--;

             after(grammarAccess.getDepartmentAccess().getSub_departmentDepartmentParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Department__Sub_departmentAssignment_6_1"


    // $ANTLR start "rule__Position__NameAssignment_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2111:1: rule__Position__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Position__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2115:1: ( ( RULE_ID ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2116:1: ( RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2116:1: ( RULE_ID )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2117:1: RULE_ID
            {
             before(grammarAccess.getPositionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Position__NameAssignment_14175); 
             after(grammarAccess.getPositionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Position__NameAssignment_1"


    // $ANTLR start "rule__Manager__NameAssignment_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2126:1: rule__Manager__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Manager__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2130:1: ( ( RULE_ID ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2131:1: ( RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2131:1: ( RULE_ID )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2132:1: RULE_ID
            {
             before(grammarAccess.getManagerAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Manager__NameAssignment_14206); 
             after(grammarAccess.getManagerAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__NameAssignment_1"


    // $ANTLR start "rule__Manager__SalaryAssignment_3_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2141:1: rule__Manager__SalaryAssignment_3_1 : ( ruleEInt ) ;
    public final void rule__Manager__SalaryAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2145:1: ( ( ruleEInt ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2146:1: ( ruleEInt )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2146:1: ( ruleEInt )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2147:1: ruleEInt
            {
             before(grammarAccess.getManagerAccess().getSalaryEIntParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleEInt_in_rule__Manager__SalaryAssignment_3_14237);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getManagerAccess().getSalaryEIntParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__SalaryAssignment_3_1"


    // $ANTLR start "rule__Manager__Works_onAssignment_5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2156:1: rule__Manager__Works_onAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Manager__Works_onAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2160:1: ( ( ( ruleEString ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2161:1: ( ( ruleEString ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2161:1: ( ( ruleEString ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2162:1: ( ruleEString )
            {
             before(grammarAccess.getManagerAccess().getWorks_onPositionCrossReference_5_0()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2163:1: ( ruleEString )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2164:1: ruleEString
            {
             before(grammarAccess.getManagerAccess().getWorks_onPositionEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Manager__Works_onAssignment_54272);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getManagerAccess().getWorks_onPositionEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getManagerAccess().getWorks_onPositionCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Manager__Works_onAssignment_5"


    // $ANTLR start "rule__Employee_Impl__NameAssignment_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2175:1: rule__Employee_Impl__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Employee_Impl__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2179:1: ( ( RULE_ID ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2180:1: ( RULE_ID )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2180:1: ( RULE_ID )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2181:1: RULE_ID
            {
             before(grammarAccess.getEmployee_ImplAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Employee_Impl__NameAssignment_14307); 
             after(grammarAccess.getEmployee_ImplAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__NameAssignment_1"


    // $ANTLR start "rule__Employee_Impl__SalaryAssignment_3_1"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2190:1: rule__Employee_Impl__SalaryAssignment_3_1 : ( ruleEInt ) ;
    public final void rule__Employee_Impl__SalaryAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2194:1: ( ( ruleEInt ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2195:1: ( ruleEInt )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2195:1: ( ruleEInt )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2196:1: ruleEInt
            {
             before(grammarAccess.getEmployee_ImplAccess().getSalaryEIntParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleEInt_in_rule__Employee_Impl__SalaryAssignment_3_14338);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEmployee_ImplAccess().getSalaryEIntParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__SalaryAssignment_3_1"


    // $ANTLR start "rule__Employee_Impl__Works_onAssignment_5"
    // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2205:1: rule__Employee_Impl__Works_onAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Employee_Impl__Works_onAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2209:1: ( ( ( ruleEString ) ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2210:1: ( ( ruleEString ) )
            {
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2210:1: ( ( ruleEString ) )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2211:1: ( ruleEString )
            {
             before(grammarAccess.getEmployee_ImplAccess().getWorks_onPositionCrossReference_5_0()); 
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2212:1: ( ruleEString )
            // ../org.ioicompanies.lang.ioi.ui/src-gen/org/ioicompanies/lang/ui/contentassist/antlr/internal/InternalIOI.g:2213:1: ruleEString
            {
             before(grammarAccess.getEmployee_ImplAccess().getWorks_onPositionEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Employee_Impl__Works_onAssignment_54373);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEmployee_ImplAccess().getWorks_onPositionEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getEmployee_ImplAccess().getWorks_onPositionCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Employee_Impl__Works_onAssignment_5"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmployee_in_entryRuleEmployee121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmployee128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee__Alternatives_in_ruleEmployee154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompany_in_entryRuleCompany181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompany188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__0_in_ruleCompany214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepartment_in_entryRuleDepartment241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDepartment248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__0_in_ruleDepartment274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_entryRulePosition301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePosition308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Position__Group__0_in_rulePosition334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManager_in_entryRuleManager361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleManager368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__0_in_ruleManager394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmployee_Impl_in_entryRuleEmployee_Impl421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmployee_Impl428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__0_in_ruleEmployee_Impl454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0_in_ruleEInt514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmployee_Impl_in_rule__Employee__Alternatives610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManager_in_rule__Employee__Alternatives627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Model__Group__0__Impl737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1768 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_1_in_rule__Model__Group__1__Impl798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__2828 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__CompaniesAssignment_2_in_rule__Model__Group__2__Impl858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__3888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__CompaniesAssignment_3_in_rule__Model__Group__3__Impl915 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__Company__Group__0__Impl_in_rule__Company__Group__0954 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Company__Group__1_in_rule__Company__Group__0957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Company__Group__0__Impl985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__1__Impl_in_rule__Company__Group__11016 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Company__Group__2_in_rule__Company__Group__11019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__NameAssignment_1_in_rule__Company__Group__1__Impl1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__2__Impl_in_rule__Company__Group__21076 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Company__Group__3_in_rule__Company__Group__21079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Company__Group__2__Impl1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__3__Impl_in_rule__Company__Group__31138 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Company__Group__4_in_rule__Company__Group__31141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Company__Group__3__Impl1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__4__Impl_in_rule__Company__Group__41200 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Company__Group__5_in_rule__Company__Group__41203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Company__Group__4__Impl1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__5__Impl_in_rule__Company__Group__51262 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_rule__Company__Group__6_in_rule__Company__Group__51265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__PositionsAssignment_5_in_rule__Company__Group__5__Impl1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__6__Impl_in_rule__Company__Group__61322 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_rule__Company__Group__7_in_rule__Company__Group__61325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group_6__0_in_rule__Company__Group__6__Impl1352 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Company__Group__7__Impl_in_rule__Company__Group__71383 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Company__Group__8_in_rule__Company__Group__71386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Company__Group__7__Impl1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__8__Impl_in_rule__Company__Group__81445 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_rule__Company__Group__9_in_rule__Company__Group__81448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__DepartmentsAssignment_8_in_rule__Company__Group__8__Impl1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group__9__Impl_in_rule__Company__Group__91505 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_rule__Company__Group__10_in_rule__Company__Group__91508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__DepartmentsAssignment_9_in_rule__Company__Group__9__Impl1535 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Company__Group__10__Impl_in_rule__Company__Group__101566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Company__Group__10__Impl1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group_6__0__Impl_in_rule__Company__Group_6__01647 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Company__Group_6__1_in_rule__Company__Group_6__01650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Company__Group_6__0__Impl1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__Group_6__1__Impl_in_rule__Company__Group_6__11709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Company__PositionsAssignment_6_1_in_rule__Company__Group_6__1__Impl1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__0__Impl_in_rule__Department__Group__01770 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Department__Group__1_in_rule__Department__Group__01773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Department__Group__0__Impl1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__1__Impl_in_rule__Department__Group__11832 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Department__Group__2_in_rule__Department__Group__11835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__NameAssignment_1_in_rule__Department__Group__1__Impl1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__2__Impl_in_rule__Department__Group__21892 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Department__Group__3_in_rule__Department__Group__21895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Department__Group__2__Impl1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__3__Impl_in_rule__Department__Group__31954 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_rule__Department__Group__4_in_rule__Department__Group__31957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__ManagerAssignment_3_in_rule__Department__Group__3__Impl1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__4__Impl_in_rule__Department__Group__42014 = new BitSet(new long[]{0x0000000001320000L});
    public static final BitSet FOLLOW_rule__Department__Group__5_in_rule__Department__Group__42017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__EmployeesAssignment_4_in_rule__Department__Group__4__Impl2044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__5__Impl_in_rule__Department__Group__52074 = new BitSet(new long[]{0x0000000001320000L});
    public static final BitSet FOLLOW_rule__Department__Group__6_in_rule__Department__Group__52077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__EmployeesAssignment_5_in_rule__Department__Group__5__Impl2104 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_rule__Department__Group__6__Impl_in_rule__Department__Group__62135 = new BitSet(new long[]{0x0000000001320000L});
    public static final BitSet FOLLOW_rule__Department__Group__7_in_rule__Department__Group__62138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group_6__0_in_rule__Department__Group__6__Impl2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group__7__Impl_in_rule__Department__Group__72196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Department__Group__7__Impl2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group_6__0__Impl_in_rule__Department__Group_6__02271 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Department__Group_6__1_in_rule__Department__Group_6__02274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Department__Group_6__0__Impl2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Group_6__1__Impl_in_rule__Department__Group_6__12333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Department__Sub_departmentAssignment_6_1_in_rule__Department__Group_6__1__Impl2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Position__Group__0__Impl_in_rule__Position__Group__02394 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Position__Group__1_in_rule__Position__Group__02397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Position__Group__1__Impl_in_rule__Position__Group__12455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Position__NameAssignment_1_in_rule__Position__Group__1__Impl2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__0__Impl_in_rule__Manager__Group__02516 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Manager__Group__1_in_rule__Manager__Group__02519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Manager__Group__0__Impl2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__1__Impl_in_rule__Manager__Group__12578 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Manager__Group__2_in_rule__Manager__Group__12581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__NameAssignment_1_in_rule__Manager__Group__1__Impl2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__2__Impl_in_rule__Manager__Group__22638 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__Manager__Group__3_in_rule__Manager__Group__22641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Manager__Group__2__Impl2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__3__Impl_in_rule__Manager__Group__32700 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__Manager__Group__4_in_rule__Manager__Group__32703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group_3__0_in_rule__Manager__Group__3__Impl2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__4__Impl_in_rule__Manager__Group__42761 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Manager__Group__5_in_rule__Manager__Group__42764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Manager__Group__4__Impl2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__5__Impl_in_rule__Manager__Group__52823 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Manager__Group__6_in_rule__Manager__Group__52826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Works_onAssignment_5_in_rule__Manager__Group__5__Impl2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group__6__Impl_in_rule__Manager__Group__62883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Manager__Group__6__Impl2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group_3__0__Impl_in_rule__Manager__Group_3__02956 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_rule__Manager__Group_3__1_in_rule__Manager__Group_3__02959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Manager__Group_3__0__Impl2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__Group_3__1__Impl_in_rule__Manager__Group_3__13018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Manager__SalaryAssignment_3_1_in_rule__Manager__Group_3__1__Impl3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__0__Impl_in_rule__Employee_Impl__Group__03079 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__1_in_rule__Employee_Impl__Group__03082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Employee_Impl__Group__0__Impl3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__1__Impl_in_rule__Employee_Impl__Group__13141 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__2_in_rule__Employee_Impl__Group__13144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__NameAssignment_1_in_rule__Employee_Impl__Group__1__Impl3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__2__Impl_in_rule__Employee_Impl__Group__23201 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__3_in_rule__Employee_Impl__Group__23204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Employee_Impl__Group__2__Impl3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__3__Impl_in_rule__Employee_Impl__Group__33263 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__4_in_rule__Employee_Impl__Group__33266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group_3__0_in_rule__Employee_Impl__Group__3__Impl3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__4__Impl_in_rule__Employee_Impl__Group__43324 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__5_in_rule__Employee_Impl__Group__43327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Employee_Impl__Group__4__Impl3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__5__Impl_in_rule__Employee_Impl__Group__53386 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__6_in_rule__Employee_Impl__Group__53389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Works_onAssignment_5_in_rule__Employee_Impl__Group__5__Impl3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group__6__Impl_in_rule__Employee_Impl__Group__63446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Employee_Impl__Group__6__Impl3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group_3__0__Impl_in_rule__Employee_Impl__Group_3__03519 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group_3__1_in_rule__Employee_Impl__Group_3__03522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Employee_Impl__Group_3__0__Impl3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__Group_3__1__Impl_in_rule__Employee_Impl__Group_3__13581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Employee_Impl__SalaryAssignment_3_1_in_rule__Employee_Impl__Group_3__1__Impl3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__03642 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__03645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__EInt__Group__0__Impl3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__13707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_13772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompany_in_rule__Model__CompaniesAssignment_23803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompany_in_rule__Model__CompaniesAssignment_33834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Company__NameAssignment_13865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_rule__Company__PositionsAssignment_53896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_rule__Company__PositionsAssignment_6_13927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepartment_in_rule__Company__DepartmentsAssignment_83958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepartment_in_rule__Company__DepartmentsAssignment_93989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Department__NameAssignment_14020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManager_in_rule__Department__ManagerAssignment_34051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmployee_in_rule__Department__EmployeesAssignment_44082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmployee_in_rule__Department__EmployeesAssignment_54113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepartment_in_rule__Department__Sub_departmentAssignment_6_14144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Position__NameAssignment_14175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Manager__NameAssignment_14206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_rule__Manager__SalaryAssignment_3_14237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Manager__Works_onAssignment_54272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Employee_Impl__NameAssignment_14307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_rule__Employee_Impl__SalaryAssignment_3_14338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Employee_Impl__Works_onAssignment_54373 = new BitSet(new long[]{0x0000000000000002L});

}