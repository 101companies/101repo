<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:com="http://www.softlang.org/company.xsd" version="1.0">
	<xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes"/>
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="com:dept//com:du">
				<xsl:for-each select="com:dept//com:du">
					<xsl:sort select="count(ancestor::com:du)"/>
					<xsl:if test="position()=last()">
<!-- +1 for the root dept; +1 for the found node itself -->
						<xsl:copy-of select="2+count(ancestor::com:du)"/>
					</xsl:if>
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<xsl:text>1</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>
