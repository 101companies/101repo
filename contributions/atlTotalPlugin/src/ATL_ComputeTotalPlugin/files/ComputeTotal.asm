<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="ComputeTotal"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchCompany2Total():V"/>
		<constant value="__exec__"/>
		<constant value="Company2Total"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyCompany2Total(NTransientLink;):V"/>
		<constant value="__matchCompany2Total"/>
		<constant value="Company"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="company"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="t"/>
		<constant value="TotalWrapper"/>
		<constant value="Total"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="13:3-15:4"/>
		<constant value="__applyCompany2Total"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="Employee"/>
		<constant value="J.allInstances():J"/>
		<constant value="4"/>
		<constant value="salary"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.sum():J"/>
		<constant value="total"/>
		<constant value="14:15-14:31"/>
		<constant value="14:15-14:46"/>
		<constant value="14:62-14:63"/>
		<constant value="14:62-14:70"/>
		<constant value="14:15-14:71"/>
		<constant value="14:15-14:80"/>
		<constant value="14:6-14:80"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="46"/>
			<findme/>
			<push arg="47"/>
			<call arg="48"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="50"/>
			<dup/>
			<push arg="51"/>
			<load arg="19"/>
			<pcall arg="52"/>
			<dup/>
			<push arg="53"/>
			<push arg="54"/>
			<push arg="55"/>
			<new/>
			<pcall arg="56"/>
			<pusht/>
			<pcall arg="57"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="58" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="51" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="59">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="60"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="51"/>
			<call arg="61"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="53"/>
			<call arg="62"/>
			<store arg="63"/>
			<load arg="63"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="64"/>
			<push arg="46"/>
			<findme/>
			<call arg="65"/>
			<iterate/>
			<store arg="66"/>
			<load arg="66"/>
			<get arg="67"/>
			<call arg="68"/>
			<enditerate/>
			<call arg="69"/>
			<call arg="30"/>
			<set arg="70"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="71" begin="14" end="16"/>
			<lne id="72" begin="14" end="17"/>
			<lne id="73" begin="20" end="20"/>
			<lne id="74" begin="20" end="21"/>
			<lne id="75" begin="11" end="23"/>
			<lne id="76" begin="11" end="24"/>
			<lne id="77" begin="9" end="26"/>
			<lne id="58" begin="8" end="27"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="33" begin="19" end="22"/>
			<lve slot="3" name="53" begin="7" end="27"/>
			<lve slot="2" name="51" begin="3" end="27"/>
			<lve slot="0" name="17" begin="0" end="27"/>
			<lve slot="1" name="78" begin="0" end="27"/>
		</localvariabletable>
	</operation>
</asm>
