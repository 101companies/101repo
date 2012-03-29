<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:com="http://www.softlang.org/company.xsd" version="1.0">
	<xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes"/>
	<xsl:template match="/*">
		<xsl:value-of select="sum(//com:salary)"/>
	</xsl:template>
</xsl:stylesheet>
