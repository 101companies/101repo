// $ANTLR 3.2 Sep 23, 2009 12:02:23 Company.g 2012-05-22 23:46:19

package org.yapg.company;
import java.util.List;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CompanyParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "QSTRING", "QQSTRING", "NUMBER", "WS", "'company'", "'{'", "'}'", "'department'", "'manager'", "'employee'", "'address'", "'salary'"
    };
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
    public static final int QQSTRING=6;
    public static final int T__9=9;

    // delegates
    // delegators


        public CompanyParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CompanyParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
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



    // $ANTLR start "parseCompany"
    // Company.g:25:1: parseCompany returns [Company result] : 'company' cname= parseQqString '{' (departments= parseDepartment )* '}' ;
    public final Company parseCompany() throws RecognitionException {
        Company result = null;

        String cname = null;

        Department departments = null;


        try {
            // Company.g:25:39: ( 'company' cname= parseQqString '{' (departments= parseDepartment )* '}' )
            // Company.g:26:2: 'company' cname= parseQqString '{' (departments= parseDepartment )* '}'
            {
            match(input,9,FOLLOW_9_in_parseCompany46); 
            pushFollow(FOLLOW_parseQqString_in_parseCompany51);
            cname=parseQqString();

            state._fsp--;

            match(input,10,FOLLOW_10_in_parseCompany54); 
             List<Department> departmentsList = new LinkedList<Department>(); 
            // Company.g:30:2: (departments= parseDepartment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Company.g:30:4: departments= parseDepartment
            	    {
            	    pushFollow(FOLLOW_parseDepartment_in_parseCompany64);
            	    departments=parseDepartment();

            	    state._fsp--;

            	     departmentsList.add(departments); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,11,FOLLOW_11_in_parseCompany72); 
             result = new Company(); result.cname = cname; result.departments = departmentsList; 

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
    // $ANTLR end "parseCompany"


    // $ANTLR start "parseDepartment"
    // Company.g:34:1: parseDepartment returns [Department result] : 'department' dname= parseQqString '{' 'manager' manager= parseEmployee (subdepartments= parseDepartment )* (employees= parseNonManager )* '}' ;
    public final Department parseDepartment() throws RecognitionException {
        Department result = null;

        String dname = null;

        Employee manager = null;

        Department subdepartments = null;

        NonManager employees = null;


        try {
            // Company.g:34:45: ( 'department' dname= parseQqString '{' 'manager' manager= parseEmployee (subdepartments= parseDepartment )* (employees= parseNonManager )* '}' )
            // Company.g:35:2: 'department' dname= parseQqString '{' 'manager' manager= parseEmployee (subdepartments= parseDepartment )* (employees= parseNonManager )* '}'
            {
            match(input,12,FOLLOW_12_in_parseDepartment89); 
            pushFollow(FOLLOW_parseQqString_in_parseDepartment94);
            dname=parseQqString();

            state._fsp--;

            match(input,10,FOLLOW_10_in_parseDepartment97); 
            match(input,13,FOLLOW_13_in_parseDepartment100); 
            pushFollow(FOLLOW_parseEmployee_in_parseDepartment105);
            manager=parseEmployee();

            state._fsp--;

             List<Department> subdepartmentsList = new LinkedList<Department>(); 
            // Company.g:41:2: (subdepartments= parseDepartment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Company.g:41:4: subdepartments= parseDepartment
            	    {
            	    pushFollow(FOLLOW_parseDepartment_in_parseDepartment115);
            	    subdepartments=parseDepartment();

            	    state._fsp--;

            	     subdepartmentsList.add(subdepartments); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             List<NonManager> employeesList = new LinkedList<NonManager>(); 
            // Company.g:43:2: (employees= parseNonManager )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Company.g:43:4: employees= parseNonManager
            	    {
            	    pushFollow(FOLLOW_parseNonManager_in_parseDepartment130);
            	    employees=parseNonManager();

            	    state._fsp--;

            	     employeesList.add(employees); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,11,FOLLOW_11_in_parseDepartment138); 
             result = new Department(); result.dname = dname; result.manager = manager; result.subdepartments = subdepartmentsList; result.employees = employeesList; 

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
    // $ANTLR end "parseDepartment"


    // $ANTLR start "parseNonManager"
    // Company.g:47:1: parseNonManager returns [NonManager result] : 'employee' employee= parseEmployee ;
    public final NonManager parseNonManager() throws RecognitionException {
        NonManager result = null;

        Employee employee = null;


        try {
            // Company.g:47:45: ( 'employee' employee= parseEmployee )
            // Company.g:48:2: 'employee' employee= parseEmployee
            {
            match(input,14,FOLLOW_14_in_parseNonManager155); 
            pushFollow(FOLLOW_parseEmployee_in_parseNonManager160);
            employee=parseEmployee();

            state._fsp--;

             result = new NonManager(); result.employee = employee; 

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
    // $ANTLR end "parseNonManager"


    // $ANTLR start "parseEmployee"
    // Company.g:52:1: parseEmployee returns [Employee result] : name= parseQqString '{' 'address' address= parseQqString 'salary' salary= parseNumber '}' ;
    public final Employee parseEmployee() throws RecognitionException {
        Employee result = null;

        String name = null;

        String address = null;

        Number salary = null;


        try {
            // Company.g:52:41: (name= parseQqString '{' 'address' address= parseQqString 'salary' salary= parseNumber '}' )
            // Company.g:53:2: name= parseQqString '{' 'address' address= parseQqString 'salary' salary= parseNumber '}'
            {
            pushFollow(FOLLOW_parseQqString_in_parseEmployee179);
            name=parseQqString();

            state._fsp--;

            match(input,10,FOLLOW_10_in_parseEmployee182); 
            match(input,15,FOLLOW_15_in_parseEmployee185); 
            pushFollow(FOLLOW_parseQqString_in_parseEmployee190);
            address=parseQqString();

            state._fsp--;

            match(input,16,FOLLOW_16_in_parseEmployee193); 
            pushFollow(FOLLOW_parseNumber_in_parseEmployee198);
            salary=parseNumber();

            state._fsp--;

            match(input,11,FOLLOW_11_in_parseEmployee201); 
             result = new Employee(); result.name = name; result.address = address; result.salary = salary; 

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
    // $ANTLR end "parseEmployee"


    // $ANTLR start "parseId"
    // Company.g:62:1: parseId returns [String result] : ID ;
    public final String parseId() throws RecognitionException {
        String result = null;

        Token ID1=null;

        try {
            // Company.g:62:33: ( ID )
            // Company.g:63:2: ID
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_parseId217); 
             result = (ID1!=null?ID1.getText():null); 

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
    // Company.g:67:1: parseQString returns [String result] : QSTRING ;
    public final String parseQString() throws RecognitionException {
        String result = null;

        Token QSTRING2=null;

        try {
            // Company.g:67:38: ( QSTRING )
            // Company.g:68:2: QSTRING
            {
            QSTRING2=(Token)match(input,QSTRING,FOLLOW_QSTRING_in_parseQString235); 
             result = (QSTRING2!=null?QSTRING2.getText():null).substring(1,(QSTRING2!=null?QSTRING2.getText():null).length()-1); 

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
    // Company.g:72:1: parseQqString returns [String result] : QQSTRING ;
    public final String parseQqString() throws RecognitionException {
        String result = null;

        Token QQSTRING3=null;

        try {
            // Company.g:72:39: ( QQSTRING )
            // Company.g:73:2: QQSTRING
            {
            QQSTRING3=(Token)match(input,QQSTRING,FOLLOW_QQSTRING_in_parseQqString253); 
             result = (QQSTRING3!=null?QQSTRING3.getText():null).substring(1,(QQSTRING3!=null?QQSTRING3.getText():null).length()-1); 

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
    // Company.g:77:1: parseNumber returns [Number result] : NUMBER ;
    public final Number parseNumber() throws RecognitionException {
        Number result = null;

        Token NUMBER4=null;

        try {
            // Company.g:77:37: ( NUMBER )
            // Company.g:78:2: NUMBER
            {
            NUMBER4=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parseNumber271); 
             result = Double.parseDouble((NUMBER4!=null?NUMBER4.getText():null)); 

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


 

    public static final BitSet FOLLOW_9_in_parseCompany46 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parseQqString_in_parseCompany51 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parseCompany54 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_parseDepartment_in_parseCompany64 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_11_in_parseCompany72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parseDepartment89 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parseQqString_in_parseDepartment94 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parseDepartment97 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parseDepartment100 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parseEmployee_in_parseDepartment105 = new BitSet(new long[]{0x0000000000005800L});
    public static final BitSet FOLLOW_parseDepartment_in_parseDepartment115 = new BitSet(new long[]{0x0000000000005800L});
    public static final BitSet FOLLOW_parseNonManager_in_parseDepartment130 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_11_in_parseDepartment138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parseNonManager155 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parseEmployee_in_parseNonManager160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseQqString_in_parseEmployee179 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parseEmployee182 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parseEmployee185 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parseQqString_in_parseEmployee190 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parseEmployee193 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parseNumber_in_parseEmployee198 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parseEmployee201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_parseId217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QSTRING_in_parseQString235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QQSTRING_in_parseQqString253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_parseNumber271 = new BitSet(new long[]{0x0000000000000002L});

}