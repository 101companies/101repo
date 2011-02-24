<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:fae4fe17-c370-42fd-8bc8-e79b8f8653a7(Company.intentions)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="83433634-bd5c-4053-ab6b-3beadd575cbb(Company)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590353(jetbrains.mps.lang.intentions.structure)" version="8" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" version="-1" />
  <devkit namespace="e073aac8-8c71-4c23-be71-86bf7a6df0a2(jetbrains.mps.devkit.bootstrap-languages)" />
  <maxImportIndex value="1" />
  <import index="1" modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="2" />
  <visible index="2" modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" />
  <node type="jetbrains.mps.lang.intentions.structure.IntentionDeclaration:8" id="5360236052283072046">
    <property name="name:8" value="Cut" />
    <link role="forConcept:8" targetNodeId="1.2701402188270084784:2" resolveInfo="Company" />
    <node role="descriptionFunction:8" type="jetbrains.mps.lang.intentions.structure.DescriptionBlock:8" id="5360236052283072047">
      <node role="body:8" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283072048">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283072051">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="5360236052283072052">
            <property name="value:3" value="Cut" />
          </node>
        </node>
      </node>
    </node>
    <node role="executeFunction:8" type="jetbrains.mps.lang.intentions.structure.ExecuteBlock:8" id="5360236052283072049">
      <node role="body:8" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5360236052283072050">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283074710">
          <node role="expression:3" type="jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall:16" id="5360236052283074712">
            <link role="concept:16" targetNodeId="1.2701402188270084784:2" resolveInfo="Company" />
            <link role="baseMethodDeclaration:16" targetNodeId="2v.5360236052283074683" resolveInfo="cut" />
            <node role="actualArgument:16" type="jetbrains.mps.lang.intentions.structure.ConceptFunctionParameter_node:8" id="5360236052283074713" />
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

