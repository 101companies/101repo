<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:bc46e871-93e2-4a9b-9e0c-252f7841d7e2(Company.sandbox.sandbox)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="83433634-bd5c-4053-ab6b-3beadd575cbb(Company)" />
  <languageAspect modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:bc46e871-93e2-4a9b-9e0c-252f7841d7e2(Company.sandbox.sandbox)" version="-1" />
  <maxImportIndex value="0" />
  <node type="Company.structure.Company:2" id="8884642869327981664">
    <property name="name:2" value="megaanalysis" />
    <node role="dept:2" type="Company.structure.Dept:2" id="8884642869327981665">
      <property name="name:2" value="Research" />
      <node role="subUnit:2" type="Company.structure.PU:2" id="8884642869327990710">
        <node role="employee:2" type="Company.structure.Employee:2" id="8884642869327990711">
          <property name="name:2" value="Erik" />
          <property name="address:2" value="Utrecht" />
          <property name="salary:2" value="12345" />
        </node>
      </node>
      <node role="subUnit:2" type="Company.structure.PU:2" id="8884642869327991601">
        <node role="employee:2" type="Company.structure.Employee:2" id="8884642869327991602">
          <property name="name:2" value="Ralf" />
          <property name="address:2" value="Koblenz" />
          <property name="salary:2" value="1234" />
          <link role="mentor:2" targetNodeId="8884642869327990711" resolveInfo="Erik" />
        </node>
      </node>
      <node role="manager:2" type="Company.structure.Employee:2" id="8884642869327981666">
        <property name="name:2" value="Craig" />
        <property name="address:2" value="Redmond" />
        <property name="salary:2" value="123456" />
      </node>
    </node>
    <node role="dept:2" type="Company.structure.Dept:2" id="8884642869327981671">
      <property name="name:2" value="Development" />
      <node role="manager:2" type="Company.structure.Employee:2" id="8884642869327981672">
        <property name="name:2" value="Ray" />
        <property name="address:2" value="Redmond" />
        <property name="salary:2" value="234567" />
      </node>
      <node role="subUnit:2" type="Company.structure.DU:2" id="8884642869327993822">
        <node role="dept:2" type="Company.structure.Dept:2" id="8884642869327993823">
          <property name="name:2" value="Dev1" />
          <node role="manager:2" type="Company.structure.Employee:2" id="8884642869327993824">
            <property name="name:2" value="Klaus" />
            <property name="address:2" value="Boston" />
            <property name="salary:2" value="23456" />
          </node>
          <node role="subUnit:2" type="Company.structure.DU:2" id="8884642869327993827">
            <node role="dept:2" type="Company.structure.Dept:2" id="8884642869327993828">
              <property name="name:2" value="Dev1.1" />
              <node role="manager:2" type="Company.structure.Employee:2" id="8884642869327993829">
                <property name="name:2" value="Karl" />
                <property name="address:2" value="Riga" />
                <property name="salary:2" value="2345" />
              </node>
              <node role="subUnit:2" type="Company.structure.PU:2" id="8884642869327993830">
                <node role="employee:2" type="Company.structure.Employee:2" id="8884642869327993831">
                  <property name="name:2" value="Joe" />
                  <property name="address:2" value="Wifi City" />
                  <property name="salary:2" value="2344" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

