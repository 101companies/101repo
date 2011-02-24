<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:com="http://www.softlang.org/company.xsd" version="1.0">
	<xsl:output method="xml" encoding="UTF-8"/>
	<xsl:template match="com:salary">
		<xsl:copy>
			<xsl:value-of select=". div 2"/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>
</xsl:stylesheet>
