package org.ioicompanies.lang.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.ioicompanies.lang.iOI.Company;
import org.ioicompanies.lang.iOI.Department;
import org.ioicompanies.lang.iOI.Employee;
import org.ioicompanies.lang.iOI.IOIPackage;
import org.ioicompanies.lang.iOI.Manager;
import org.ioicompanies.lang.iOI.Model;
import org.ioicompanies.lang.iOI.Position;
import org.ioicompanies.lang.services.IOIGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractIOISemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IOIGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == IOIPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case IOIPackage.COMPANY:
				if(context == grammarAccess.getCompanyRule()) {
					sequence_Company(context, (Company) semanticObject); 
					return; 
				}
				else break;
			case IOIPackage.DEPARTMENT:
				if(context == grammarAccess.getDepartmentRule()) {
					sequence_Department(context, (Department) semanticObject); 
					return; 
				}
				else break;
			case IOIPackage.EMPLOYEE:
				if(context == grammarAccess.getEmployeeRule() ||
				   context == grammarAccess.getEmployee_ImplRule()) {
					sequence_Employee_Impl(context, (Employee) semanticObject); 
					return; 
				}
				else break;
			case IOIPackage.MANAGER:
				if(context == grammarAccess.getEmployeeRule() ||
				   context == grammarAccess.getManagerRule()) {
					sequence_Manager(context, (Manager) semanticObject); 
					return; 
				}
				else break;
			case IOIPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case IOIPackage.POSITION:
				if(context == grammarAccess.getPositionRule()) {
					sequence_Position(context, (Position) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID positions+=Position positions+=Position* departments+=Department departments+=Department*)
	 */
	protected void sequence_Company(EObject context, Company semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID manager=Manager employees+=Employee employees+=Employee* sub_department=Department?)
	 */
	protected void sequence_Department(EObject context, Department semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID salary=EInt? works_on=[Position|EString])
	 */
	protected void sequence_Employee_Impl(EObject context, Employee semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID salary=EInt? works_on=[Position|EString])
	 */
	protected void sequence_Manager(EObject context, Manager semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID companies+=Company companies+=Company*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Position(EObject context, Position semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IOIPackage.Literals.POSITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IOIPackage.Literals.POSITION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPositionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
