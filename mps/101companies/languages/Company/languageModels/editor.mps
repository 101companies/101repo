<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:bd0fc34f-48ef-4fb6-9132-808a526777d9(Company.editor)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="18bc6592-03a6-4e29-a83a-7ff23bde13ba(jetbrains.mps.lang.editor)" />
  <language namespace="83433634-bd5c-4053-ab6b-3beadd575cbb(Company)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959029e(jetbrains.mps.lang.editor.structure)" version="32" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" version="-1" />
  <devkit namespace="e073aac8-8c71-4c23-be71-86bf7a6df0a2(jetbrains.mps.devkit.bootstrap-languages)" />
  <maxImportIndex value="2" />
  <import index="1" modelUID="r:45ac1c49-376b-4291-9b47-335e49e7f562(Company.structure)" version="2" />
  <import index="2" modelUID="f:java_stub#java.io(java.io@java_stub)" version="-1" />
  <visible index="2" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" />
  <visible index="3" modelUID="r:45a89640-10cf-41a6-bd72-32389ba6bec3(Company.behavior)" />
  <visible index="4" modelUID="f:java_stub#java.lang(java.lang@java_stub)" />
  <node type="jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration:32" id="8884642869327941466">
    <link role="conceptDeclaration:32" targetNodeId="1.2701402188270084784:2" resolveInfo="Company" />
    <node role="cellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327984738">
      <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Vertical:32" id="8884642869327984739" />
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327984743">
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869327984747">
          <property name="text:32" value="company" />
        </node>
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Property:32" id="8884642869327984749">
          <link role="relationDeclaration:32" targetNodeId="2v.1169194664001:0" resolveInfo="name" />
        </node>
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Horizontal:32" id="8884642869327984744" />
        <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.SelectableStyleSheetItem:32" id="8884642869327984745">
          <property name="flag:32" value="false" />
        </node>
      </node>
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327987290">
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Indent:32" id="8884642869327987291" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Indent:32" id="8884642869327987914" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_RefNodeList:32" id="8884642869327986136">
          <link role="relationDeclaration:32" targetNodeId="1.2701402188270084786:2" />
          <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Vertical:32" id="8884642869327986137" />
          <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.IndentLayoutIndentStyleClassItem:32" id="8884642869327986699">
            <property name="flag:32" value="true" />
          </node>
          <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.IndentLayoutNewLineStyleClassItem:32" id="8884642869327986701">
            <property name="flag:32" value="true" />
          </node>
          <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.IndentLayoutNewLineChildrenStyleClassItem:32" id="8884642869327986703">
            <property name="flag:32" value="true" />
          </node>
        </node>
      </node>
    </node>
    <node role="inspectedCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869328057172">
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869328057175">
        <property name="text:32" value="Total:" />
      </node>
      <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Horizontal:32" id="8884642869328057173" />
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_ReadOnlyModelAccessor:32" id="8884642869328057177">
        <node role="modelAccessor:32" type="jetbrains.mps.lang.editor.structure.ReadOnlyModelAccessor:32" id="8884642869328057178">
          <node role="getter:32" type="jetbrains.mps.lang.editor.structure.QueryFunction_ModelAccess_Getter:32" id="8884642869328057179">
            <node role="body:32" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="8884642869328057180">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283074714">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074718">
                  <node role="operand:3" type="jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall:16" id="5360236052283074716">
                    <link role="concept:16" targetNodeId="1.2701402188270084784:2" resolveInfo="Company" />
                    <link role="baseMethodDeclaration:16" targetNodeId="3v.5360236052283074551" resolveInfo="total" />
                    <node role="actualArgument:16" type="jetbrains.mps.lang.editor.structure.ConceptFunctionParameter_node:32" id="5360236052283074717" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5360236052283074722">
                    <link role="baseMethodDeclaration:3" targetNodeId="4v.~Double.toString():java.lang.String" resolveInfo="toString" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration:32" id="8884642869327941484">
    <link role="conceptDeclaration:32" targetNodeId="1.2701402188270084785:2" resolveInfo="Dept" />
    <node role="cellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988565">
      <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Vertical:32" id="8884642869327988566" />
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="5360236052283095399" />
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988567">
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869327988568">
          <property name="text:32" value="department" />
        </node>
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Property:32" id="8884642869327988569">
          <link role="relationDeclaration:32" targetNodeId="2v.1169194664001:0" resolveInfo="name" />
        </node>
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Horizontal:32" id="8884642869327988570" />
        <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.SelectableStyleSheetItem:32" id="8884642869327988571">
          <property name="flag:32" value="false" />
        </node>
      </node>
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988582">
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Indent:32" id="8884642869327988583" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Indent:32" id="8884642869327988584" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869327988593">
          <property name="text:32" value="manager" />
        </node>
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_RefNode:32" id="8884642869327988591">
          <link role="relationDeclaration:32" targetNodeId="1.2701402188270085995:2" />
        </node>
      </node>
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988572">
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Indent:32" id="8884642869327988573" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Indent:32" id="8884642869327988574" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_RefNodeList:32" id="8884642869327988575">
          <link role="relationDeclaration:32" targetNodeId="1.2701402188270085997:2" />
          <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Vertical:32" id="8884642869327988576" />
          <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.IndentLayoutIndentStyleClassItem:32" id="8884642869327988577">
            <property name="flag:32" value="true" />
          </node>
          <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.IndentLayoutNewLineStyleClassItem:32" id="8884642869327988578">
            <property name="flag:32" value="true" />
          </node>
          <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.IndentLayoutNewLineChildrenStyleClassItem:32" id="8884642869327988579">
            <property name="flag:32" value="true" />
          </node>
        </node>
      </node>
    </node>
    <node role="inspectedCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869328061798">
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869328061799">
        <property name="text:32" value="Total:" />
      </node>
      <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Horizontal:32" id="8884642869328061800" />
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_ReadOnlyModelAccessor:32" id="8884642869328061801">
        <node role="modelAccessor:32" type="jetbrains.mps.lang.editor.structure.ReadOnlyModelAccessor:32" id="8884642869328061802">
          <node role="getter:32" type="jetbrains.mps.lang.editor.structure.QueryFunction_ModelAccess_Getter:32" id="8884642869328061803">
            <node role="body:32" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="8884642869328061804">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5360236052283074723">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5360236052283074724">
                  <node role="operand:3" type="jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall:16" id="5360236052283074725">
                    <link role="baseMethodDeclaration:16" targetNodeId="3v.5360236052283074551" resolveInfo="total" />
                    <link role="concept:16" targetNodeId="1.2701402188270084784:2" resolveInfo="Company" />
                    <node role="actualArgument:16" type="jetbrains.mps.lang.editor.structure.ConceptFunctionParameter_node:32" id="5360236052283074726" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5360236052283074727">
                    <link role="baseMethodDeclaration:3" targetNodeId="4v.~Double.toString():java.lang.String" resolveInfo="toString" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration:32" id="8884642869327988594">
    <link role="conceptDeclaration:32" targetNodeId="1.2701402188270085751:2" resolveInfo="Employee" />
    <node role="cellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988596">
      <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Vertical:32" id="8884642869327988597" />
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988598">
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Property:32" id="8884642869327988600">
          <link role="relationDeclaration:32" targetNodeId="2v.1169194664001:0" resolveInfo="name" />
        </node>
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Horizontal:32" id="8884642869327988601" />
        <node role="styleItem:32" type="jetbrains.mps.lang.editor.structure.SelectableStyleSheetItem:32" id="8884642869327988602">
          <property name="flag:32" value="false" />
        </node>
      </node>
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988603">
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Indent:32" id="8884642869327988604" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Indent:32" id="8884642869327988605" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869327988606">
          <property name="text:32" value="address" />
        </node>
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Property:32" id="8884642869327988617">
          <link role="relationDeclaration:32" targetNodeId="1.8884642869327841662:2" resolveInfo="address" />
        </node>
      </node>
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988619">
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Indent:32" id="8884642869327988620" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Indent:32" id="8884642869327988621" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869327988622">
          <property name="text:32" value="salary" />
        </node>
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Property:32" id="8884642869327988623">
          <link role="relationDeclaration:32" targetNodeId="1.8884642869327841663:2" resolveInfo="salary" />
        </node>
      </node>
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="5360236052283104520">
        <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Indent:32" id="5360236052283104521" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Indent:32" id="5360236052283104522" />
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="5360236052283104523">
          <property name="text:32" value="mentor" />
        </node>
        <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_RefCell:32" id="7996090147274753576">
          <link role="relationDeclaration:32" targetNodeId="1.7996090147274700416:2" />
          <node role="editorComponent:32" type="jetbrains.mps.lang.editor.structure.InlineEditorComponent:32" id="7996090147274753577">
            <node role="cellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Property:32" id="7996090147274753579">
              <property name="readOnly:32" value="true" />
              <link role="relationDeclaration:32" targetNodeId="2v.1169194664001:0" resolveInfo="name" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration:32" id="8884642869327988626">
    <link role="conceptDeclaration:32" targetNodeId="1.8884642869327841664:2" resolveInfo="PU" />
    <node role="cellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Collection:32" id="8884642869327988628">
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_Constant:32" id="8884642869327988632">
        <property name="text:32" value="employee" />
      </node>
      <node role="childCellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_RefNode:32" id="8884642869327988633">
        <link role="relationDeclaration:32" targetNodeId="1.8884642869327841667:2" />
      </node>
      <node role="cellLayout:32" type="jetbrains.mps.lang.editor.structure.CellLayout_Horizontal:32" id="8884642869327988630" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration:32" id="8884642869327991603">
    <link role="conceptDeclaration:32" targetNodeId="1.8884642869327841665:2" resolveInfo="DU" />
    <node role="cellModel:32" type="jetbrains.mps.lang.editor.structure.CellModel_RefNode:32" id="8884642869327991605">
      <link role="relationDeclaration:32" targetNodeId="1.8884642869327841668:2" />
    </node>
  </node>
</model>

