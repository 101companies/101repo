<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="83433634-bd5c-4053-ab6b-3beadd575cbb(Company)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:3270011d-8b2d-4938-8dff-d256a759e017(jetbrains.mps.lang.behavior.structure)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <devkit namespace="e073aac8-8c71-4c23-be71-86bf7a6df0a2(jetbrains.mps.devkit.bootstrap-languages)" />
  <maxImportIndex value="1" />
  <import index="1" modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="2" />
  <visible index="2" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" />
  <visible index="3" modelUID="f:java_stub#java.lang(java.lang@java_stub)" />
  <node type="jetbrains.mps.lang.behavior.structure.ConceptBehavior" id="8884642869328057136">
    <link role="concept" targetNodeId="1.2701402188270084784:2" resolveInfo="Company" />
    <node role="staticMethod" type="jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration" id="5360236052283074551">
      <property name="name" value="total" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5360236052283074556">
        <property name="name:3" value="root" />
        <node role="type:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="5360236052283074644">
          <link role="concept:16" targetNodeId="2v.1133920641626:0" resolveInfo="BaseConcept" />
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5360236052283074552" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5360236052283074555">
        <link role="classifier:3" targetNodeId="3v.~Double" resolveInfo="Double" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283074554">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283074645">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074656">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074647">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5360236052283074646">
                <link role="variableDeclaration:3" targetNodeId="5360236052283074556" resolveInfo="root" />
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetDescendantsOperation:16" id="5360236052283074651">
                <node role="parameter:16" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept:16" id="5360236052283074652">
                  <node role="conceptArgument:16" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference:16" id="5360236052283074655">
                    <link role="conceptDeclaration:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
                  </node>
                </node>
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.FoldLeftOperation:7" id="5360236052283074662">
              <node role="closure:7" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="5360236052283074663">
                <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283074664">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283074665">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="5360236052283074666">
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5360236052283074667">
                        <link role="variableDeclaration:3" targetNodeId="5360236052283074671" resolveInfo="s" />
                      </node>
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074678">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5360236052283074669">
                          <link role="variableDeclaration:3" targetNodeId="5360236052283074673" resolveInfo="it" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="5360236052283074682">
                          <link role="property:16" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5360236052283074671">
                  <property name="name:3" value="s" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5360236052283074672">
                    <link role="classifier:3" targetNodeId="3v.~Double" resolveInfo="Double" />
                  </node>
                </node>
                <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration:7" id="5360236052283074673">
                  <property name="name:7" value="it" />
                  <node role="type:7" type="jetbrains.mps.baseLanguage.structure.WildCardType:3" id="5360236052283074674" />
                </node>
              </node>
              <node role="seed:7" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5360236052283074675">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="5360236052283074676">
                  <link role="baseMethodDeclaration:3" targetNodeId="3v.~Double.&lt;init&gt;(double)" resolveInfo="Double" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5360236052283074677">
                    <property name="value:3" value="0" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod" type="jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration" id="5360236052283074683">
      <property name="name" value="cut" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5360236052283074688">
        <property name="name:3" value="root" />
        <node role="type:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="5360236052283074690">
          <link role="concept:16" targetNodeId="2v.1133920641626:0" resolveInfo="BaseConcept" />
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5360236052283074684" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5360236052283074687" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283074686">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283074692">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074693">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074694">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5360236052283074708">
                <link role="variableDeclaration:3" targetNodeId="5360236052283074688" resolveInfo="root" />
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetDescendantsOperation:16" id="5360236052283074696">
                <node role="parameter:16" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept:16" id="5360236052283074697">
                  <node role="conceptArgument:16" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference:16" id="5360236052283074698">
                    <link role="conceptDeclaration:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
                  </node>
                </node>
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.VisitAllOperation:7" id="5360236052283074699">
              <node role="closure:7" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="5360236052283074700">
                <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283074701">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283074702">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074703">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5360236052283074704">
                        <link role="variableDeclaration:3" targetNodeId="5360236052283074706" resolveInfo="it" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall:16" id="5360236052283074705">
                        <link role="baseMethodDeclaration:16" targetNodeId="5360236052283072965" resolveInfo="cut" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration:7" id="5360236052283074706">
                  <property name="name:7" value="it" />
                  <node role="type:7" type="jetbrains.mps.baseLanguage.structure.WildCardType:3" id="5360236052283074707" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.lang.behavior.structure.ConceptConstructorDeclaration" id="8884642869328057137">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="8884642869328057138" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.behavior.structure.ConceptBehavior" id="5360236052283072962">
    <link role="concept" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
    <node role="method" type="jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration" id="5360236052283072965">
      <property name="name" value="cut" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5360236052283072966" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5360236052283072969" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283072968">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283073009">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283073016">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283073011">
              <node role="operand:3" type="jetbrains.mps.lang.behavior.structure.ThisNodeExpression" id="5360236052283073010" />
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="5360236052283073015">
                <link role="property:16" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Property_SetOperation:16" id="5360236052283073020">
              <node role="value:16" type="jetbrains.mps.baseLanguage.structure.DivExpression:3" id="5360236052283073028">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5360236052283073031">
                  <property name="value:3" value="2" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283073023">
                  <node role="operand:3" type="jetbrains.mps.lang.behavior.structure.ThisNodeExpression" id="5360236052283073022" />
                  <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="5360236052283073027">
                    <link role="property:16" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration" id="5360236052283078742">
      <property name="name" value="getManager" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5360236052283078743" />
      <node role="returnType" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="5360236052283078774">
        <link role="concept:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283078745">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7996090147274758018">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088613">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088614">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088615">
                <node role="operand:3" type="jetbrains.mps.lang.behavior.structure.ThisNodeExpression" id="5360236052283088616" />
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetParentOperation:16" id="5360236052283088617" />
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation:16" id="5360236052283088618">
                <node role="parameter:16" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept:16" id="5360236052283088619">
                  <node role="conceptArgument:16" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference:16" id="5360236052283088620">
                    <link role="conceptDeclaration:16" targetNodeId="1.2701402188270084785:2" resolveInfo="Dept" />
                  </node>
                </node>
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="5360236052283088621">
              <link role="link:16" targetNodeId="1.2701402188270085995:2" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration" id="7996090147274758020">
      <property name="name" value="mentees" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7996090147274758021" />
      <node role="returnType" type="jetbrains.mps.lang.smodel.structure.SNodeListType:16" id="7996090147274758024">
        <link role="elementConcept:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7996090147274758023">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7996090147274758025">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7996090147274758070">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7996090147274758036">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7996090147274758027">
                <node role="operand:3" type="jetbrains.mps.lang.behavior.structure.ThisNodeExpression" id="7996090147274758026" />
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation:16" id="7996090147274758031">
                  <node role="parameter:16" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept:16" id="7996090147274758032">
                    <node role="conceptArgument:16" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference:16" id="7996090147274758035">
                      <link role="conceptDeclaration:16" targetNodeId="1.2701402188270084784:2" resolveInfo="Company" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetDescendantsOperation:16" id="7996090147274758040">
                <node role="parameter:16" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept:16" id="7996090147274758041">
                  <node role="conceptArgument:16" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference:16" id="7996090147274758044">
                    <link role="conceptDeclaration:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
                  </node>
                </node>
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.RemoveWhereOperation:7" id="7996090147274758074">
              <node role="closure:7" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="7996090147274758075">
                <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7996090147274758076">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7996090147274758079">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="7996090147274758086">
                      <node role="rightExpression:3" type="jetbrains.mps.lang.behavior.structure.ThisNodeExpression" id="7996090147274758089" />
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7996090147274758081">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7996090147274758080">
                          <link role="variableDeclaration:3" targetNodeId="7996090147274758077" resolveInfo="it" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="7996090147274758085">
                          <link role="link:16" targetNodeId="1.7996090147274700416:2" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration:7" id="7996090147274758077">
                  <property name="name:7" value="it" />
                  <node role="type:7" type="jetbrains.mps.baseLanguage.structure.WildCardType:3" id="7996090147274758078" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.lang.behavior.structure.ConceptConstructorDeclaration" id="5360236052283072963">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283072964" />
    </node>
  </node>
</model>

