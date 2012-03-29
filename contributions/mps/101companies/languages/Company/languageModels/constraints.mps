<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:05f9c9cf-a993-4529-b478-cd2e43507039(Company.constraints)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="3f4bc5f5-c6c1-4a28-8b10-c83066ffa4a1(jetbrains.mps.lang.constraints)" />
  <language namespace="83433634-bd5c-4053-ab6b-3beadd575cbb(Company)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <languageAspect modelUID="r:05f9c9cf-a993-4529-b478-cd2e43507039(Company.constraints)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902bc(jetbrains.mps.lang.sharedConcepts.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959030d(jetbrains.mps.lang.constraints.structure)" version="8" />
  <languageAspect modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" version="-1" />
  <devkit namespace="e073aac8-8c71-4c23-be71-86bf7a6df0a2(jetbrains.mps.devkit.bootstrap-languages)" />
  <maxImportIndex value="2" />
  <import index="1" modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="2" />
  <import index="2" modelUID="f:java_stub#java.io(java.io@java_stub)" version="-1" />
  <visible index="2" modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" />
  <node type="jetbrains.mps.lang.constraints.structure.ConceptConstraints:8" id="5360236052283111692">
    <link role="concept:8" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
    <node role="referent:8" type="jetbrains.mps.lang.constraints.structure.NodeReferentConstraint:8" id="5360236052283111693">
      <link role="applicableLink:8" targetNodeId="1.7996090147274700416:2" />
      <node role="searchScopeFactory:8" type="jetbrains.mps.lang.constraints.structure.ConstraintFunction_ReferentSearchScope_Factory:8" id="5360236052283111694">
        <node role="body:8" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283111695">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7996090147274758118">
            <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7996090147274758119">
              <property name="name:3" value="mentees" />
              <node role="type:3" type="jetbrains.mps.lang.smodel.structure.SNodeListType:16" id="7996090147274758120">
                <link role="elementConcept:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
              </node>
              <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7996090147274758123">
                <node role="operand:3" type="jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_referenceNode:8" id="7996090147274758122" />
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall:16" id="7996090147274758127">
                  <link role="baseMethodDeclaration:16" targetNodeId="2v.7996090147274758020" resolveInfo="mentees" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283111696">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7996090147274758099">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283112775">
                <node role="operand:3" type="jetbrains.mps.lang.sharedConcepts.structure.ConceptFunctionParameter_model:0" id="5360236052283112774" />
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Model_NodesOperation:16" id="5360236052283112779">
                  <link role="concept:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.RemoveWhereOperation:7" id="7996090147274758103">
                <node role="closure:7" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="7996090147274758104">
                  <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7996090147274758105">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7996090147274758108">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.OrExpression:3" id="7996090147274758114">
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7996090147274758129">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7996090147274758128">
                            <link role="variableDeclaration:3" targetNodeId="7996090147274758119" resolveInfo="mentees" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ContainsOperation:7" id="7996090147274758133">
                            <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7996090147274758135">
                              <link role="variableDeclaration:3" targetNodeId="7996090147274758106" resolveInfo="it" />
                            </node>
                          </node>
                        </node>
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="7996090147274758110">
                          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7996090147274758109">
                            <link role="variableDeclaration:3" targetNodeId="7996090147274758106" resolveInfo="it" />
                          </node>
                          <node role="rightExpression:3" type="jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_referenceNode:8" id="7996090147274758113" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration:7" id="7996090147274758106">
                    <property name="name:7" value="it" />
                    <node role="type:7" type="jetbrains.mps.baseLanguage.structure.WildCardType:3" id="7996090147274758107" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

