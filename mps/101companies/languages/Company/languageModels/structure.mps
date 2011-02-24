<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)">
  <persistence version="4" />
  <refactoringHistory>
    <refactoringContext modelVersion="0">
      <dependencies>
        <model modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="-1" />
      </dependencies>
      <refactoring refactoringClass="jetbrains.mps.lang.structure.refactorings.RenameLink" />
      <moveMap />
      <sourceMap />
      <conceptFeatureMap>
        <entry>
          <key featureName="department" conceptFQName="Company.structure.Company" featureKind="CHILD" />
          <value featureName="dept" conceptFQName="Company.structure.Company" featureKind="CHILD" />
        </entry>
      </conceptFeatureMap>
    </refactoringContext>
    <refactoringContext modelVersion="1">
      <dependencies>
        <model modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="0" />
      </dependencies>
      <refactoring refactoringClass="jetbrains.mps.lang.structure.refactorings.RenameConcept" />
      <moveMap />
      <sourceMap />
      <conceptFeatureMap>
        <entry>
          <key featureName="Manager" conceptFQName="Company.structure.Manager" featureKind="CONCEPT" />
          <value featureName="Employed" conceptFQName="Company.structure.Employed" featureKind="CONCEPT" />
        </entry>
      </conceptFeatureMap>
    </refactoringContext>
    <refactoringContext modelVersion="2">
      <dependencies>
        <model modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="1" />
      </dependencies>
      <refactoring refactoringClass="jetbrains.mps.lang.structure.refactorings.RenameLink" />
      <moveMap />
      <sourceMap />
      <conceptFeatureMap>
        <entry>
          <key featureName="backup" conceptFQName="Company.structure.Employee" featureKind="REFERENCE" />
          <value featureName="mentor" conceptFQName="Company.structure.Employee" featureKind="REFERENCE" />
        </entry>
      </conceptFeatureMap>
    </refactoringContext>
  </refactoringHistory>
  <language namespace="c72da2b9-7cce-4447-8389-f407dc1158b7(jetbrains.mps.lang.structure)" />
  <language namespace="83433634-bd5c-4053-ab6b-3beadd575cbb(Company)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <devkit namespace="e073aac8-8c71-4c23-be71-86bf7a6df0a2(jetbrains.mps.devkit.bootstrap-languages)" />
  <maxImportIndex value="2" />
  <import index="1" modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="2" />
  <import index="2" modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <visible index="2" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" />
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="2701402188270084784">
    <property name="name:0" value="Company" />
    <property name="rootable:0" value="true" />
    <link role="extends:0" targetNodeId="2v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="2701402188270084786">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="dept" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="2701402188270084785:2" resolveInfo="Dept" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="8884642869327941468">
      <link role="intfc:0" targetNodeId="2v.1169194658468:0" resolveInfo="INamedConcept" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="2701402188270084785">
    <property name="name:0" value="Dept" />
    <link role="extends:0" targetNodeId="2v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="2701402188270085995">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="manager" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2701402188270085751:2" resolveInfo="Employee" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="2701402188270085997">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="subUnit" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="2701402188270085996:2" resolveInfo="SubUnit" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="2701402188270085998">
      <link role="intfc:0" targetNodeId="2v.1169194658468:0" resolveInfo="INamedConcept" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="2701402188270085751">
    <property name="name:0" value="Employee" />
    <link role="extends:0" targetNodeId="2v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="7996090147274700416">
      <property name="metaClass:0" value="reference" />
      <property name="role:0" value="mentor" />
      <link role="target:0" targetNodeId="2701402188270085751:2" resolveInfo="Employee" />
    </node>
    <node role="propertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.PropertyDeclaration:0" id="8884642869327841662">
      <property name="name:0" value="address" />
      <link role="dataType:0" targetNodeId="2v.1082983041843:0" resolveInfo="string" />
    </node>
    <node role="propertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.PropertyDeclaration:0" id="8884642869327841663">
      <property name="name:0" value="salary" />
      <link role="dataType:0" targetNodeId="2v.1082983657062:0" resolveInfo="integer" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="2701402188270085999">
      <link role="intfc:0" targetNodeId="2v.1169194658468:0" resolveInfo="INamedConcept" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="2701402188270085996">
    <property name="name:0" value="SubUnit" />
    <link role="extends:0" targetNodeId="2v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.BooleanConceptProperty:0" id="8884642869327990713">
      <link role="conceptPropertyDeclaration:0" targetNodeId="2v.1137473854053:0" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="8884642869327841664">
    <property name="name:0" value="PU" />
    <link role="extends:0" targetNodeId="2701402188270085996:2" resolveInfo="SubUnit" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="8884642869327841667">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="employee" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2701402188270085751:2" resolveInfo="Employee" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="8884642869327841665">
    <property name="name:0" value="DU" />
    <link role="extends:0" targetNodeId="2701402188270085996:2" resolveInfo="SubUnit" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="8884642869327841668">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="dept" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2701402188270084785:2" resolveInfo="Dept" />
    </node>
  </node>
</model>

