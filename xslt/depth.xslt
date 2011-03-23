<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:com="http://www.softlang.org/company.xsd" version="1.0">
	<xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes"/>
	<xsl:template match="*">
		<xsl:choose>
			<xsl:when test="//com:department">
				<xsl:for-each select="//com:department">
					<xsl:sort select="count(ancestor::com:department)"/>
					<xsl:if test="position()=last()">
						<xsl:copy-of select="1+count(ancestor::com:department)"/>
					</xsl:if>
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<xsl:text>0</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>
