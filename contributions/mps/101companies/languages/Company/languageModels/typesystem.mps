<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:1518ca55-b189-49c7-9602-0762c7161743(Company.typesystem)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="7a5dda62-9140-4668-ab76-d5ed1746f2b2(jetbrains.mps.lang.typesystem)" />
  <language namespace="83433634-bd5c-4053-ab6b-3beadd575cbb(Company)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <languageAspect modelUID="r:1518ca55-b189-49c7-9602-0762c7161743(Company.typesystem)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902b4(jetbrains.mps.lang.typesystem.structure)" version="3" />
  <devkit namespace="e073aac8-8c71-4c23-be71-86bf7a6df0a2(jetbrains.mps.devkit.bootstrap-languages)" />
  <maxImportIndex value="1" />
  <import index="1" modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="2" />
  <visible index="2" modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" />
  <node type="jetbrains.mps.lang.typesystem.structure.NonTypesystemRule:3" id="5360236052283077850">
    <property name="name:3" value="DecreasingSalaries" />
    <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283077851">
      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="5360236052283077854">
        <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="5360236052283088340">
          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088349">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088344">
              <node role="operand:3" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference:3" id="5360236052283088343">
                <link role="applicableNode:3" targetNodeId="5360236052283077853" resolveInfo="employee" />
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall:16" id="5360236052283088348">
                <link role="baseMethodDeclaration:16" targetNodeId="2v.5360236052283078742" resolveInfo="getManager" />
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_IsNotNullOperation:16" id="5360236052283088353" />
          </node>
          <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="5360236052283078805">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283078806">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283078807">
                <node role="operand:3" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference:3" id="5360236052283078808">
                  <link role="applicableNode:3" targetNodeId="5360236052283077853" resolveInfo="employee" />
                </node>
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall:16" id="5360236052283078809">
                  <link role="baseMethodDeclaration:16" targetNodeId="2v.5360236052283078742" resolveInfo="getManager" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="5360236052283078810">
                <link role="property:16" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
              </node>
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283078811">
              <node role="operand:3" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference:3" id="5360236052283078812">
                <link role="applicableNode:3" targetNodeId="5360236052283077853" resolveInfo="employee" />
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="5360236052283078813">
                <link role="property:16" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
              </node>
            </node>
          </node>
        </node>
        <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283077856">
          <node role="statement:3" type="jetbrains.mps.lang.typesystem.structure.ReportErrorStatement:3" id="5360236052283078797">
            <node role="errorString:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="5360236052283078814">
              <property name="value:3" value="Employee's salary larger than its manager's" />
            </node>
            <node role="nodeToReport:3" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference:3" id="5360236052283078815">
              <link role="applicableNode:3" targetNodeId="5360236052283077853" resolveInfo="employee" />
            </node>
            <node role="helginsIntention:3" type="jetbrains.mps.lang.typesystem.structure.TypesystemIntention:3" id="5360236052283088787">
              <link role="quickFix:3" targetNodeId="5360236052283088759" resolveInfo="LowerEmployeeSalary" />
              <node role="actualArgument:3" type="jetbrains.mps.lang.typesystem.structure.TypesystemIntentionArgument:3" id="5360236052283088788">
                <link role="quickFixArgument:3" targetNodeId="5360236052283088762" resolveInfo="employee" />
                <node role="value:3" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference:3" id="5360236052283088790">
                  <link role="applicableNode:3" targetNodeId="5360236052283077853" resolveInfo="employee" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode:3" type="jetbrains.mps.lang.typesystem.structure.ConceptReference:3" id="5360236052283077853">
      <property name="name:3" value="employee" />
      <link role="concept:3" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.TypesystemQuickFix:3" id="5360236052283088759">
    <property name="name:3" value="LowerEmployeeSalary" />
    <node role="quickFixArgument:3" type="jetbrains.mps.lang.typesystem.structure.QuickFixArgument:3" id="5360236052283088762">
      <property name="name:3" value="employee" />
      <node role="argumentType:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="5360236052283088764">
        <link role="concept:16" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
      </node>
    </node>
    <node role="executeBlock:3" type="jetbrains.mps.lang.typesystem.structure.QuickFixExecuteBlock:3" id="5360236052283088760">
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283088761">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283088769">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088776">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088771">
              <node role="operand:3" type="jetbrains.mps.lang.typesystem.structure.QuickFixArgumentReference:3" id="5360236052283088770">
                <link role="quickFixArgument:3" targetNodeId="5360236052283088762" resolveInfo="employee" />
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="5360236052283088775">
                <link role="property:16" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Property_SetOperation:16" id="5360236052283088780">
              <node role="value:16" type="jetbrains.mps.baseLanguage.structure.MinusExpression:3" id="5360236052283088819">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5360236052283088822">
                  <property name="value:3" value="1" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088814">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283088809">
                    <node role="operand:3" type="jetbrains.mps.lang.typesystem.structure.QuickFixArgumentReference:3" id="5360236052283088808">
                      <link role="quickFixArgument:3" targetNodeId="5360236052283088762" resolveInfo="employee" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall:16" id="5360236052283088813">
                      <link role="baseMethodDeclaration:16" targetNodeId="2v.5360236052283078742" resolveInfo="getManager" />
                    </node>
                  </node>
                  <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="5360236052283088818">
                    <link role="property:16" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="descriptionBlock:3" type="jetbrains.mps.lang.typesystem.structure.QuickFixDescriptionBlock:3" id="5360236052283088783">
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283088784">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283088785">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="5360236052283088786">
            <property name="value:3" value="Lower Employee's Salary" />
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

