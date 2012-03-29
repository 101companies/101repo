input = sampleCompany.xml
saxon = ../../technologies/saxon/saxon9he.jar

test:
	make test-xsltproc
	make test-saxon
	rm *.result

test-xsltproc:
	xsltproc total.xslt ${input} > total.result
	diff total.result total.baseline
	xsltproc cut.xslt ${input} > cut.result.xml
	xsltproc total.xslt cut.result.xml > cut.result
	diff cut.result cut.baseline
	xsltproc depth.xslt ${input} > depth.result
	diff depth.result depth.baseline

test-saxon:
	java -jar ${saxon} -s:${input} -xsl:total.xslt -versionmsg:off >total.result
	diff total.result total.baseline
	java -jar ${saxon} -s:${input} -xsl:cut.xslt -versionmsg:off >cut.result.xml
	java -jar ${saxon} -s:cut.result.xml -xsl:total.xslt -versionmsg:off >cut.result
	diff cut.result cut.baseline
	java -jar ${saxon} -s:${input} -xsl:depth.xslt -versionmsg:off >depth.result
	diff depth.result depth.baseline

clean:
	rm -f *~ *.result *.result.xml
