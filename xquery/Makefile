input = sampleCompany.xml
saxon = saxon/saxon9he.jar
basex = basex/BaseX61.jar

test-all:
	make test-basex
	make test-saxon
	rm -f *.result.xml *.result

test-basex:
	java -classpath ${basex} org.basex.BaseX total.xq -i${input} > total.result.xml
	xpath total.result.xml "/result/text()" 2> /dev/null > total.result
	diff total.result total.baseline
	java -classpath ${basex} org.basex.BaseX cut.uf.xq -i${input} > cut.result.xml
	java -classpath ${basex} org.basex.BaseX total.xq -icut.result.xml | xpath "/result/text()" 2> /dev/null > cut.result
	diff cut.result cut.baseline
	java -classpath ${basex} org.basex.BaseX depth.xq -i${input} > depth.result.xml
	xpath depth.result.xml "/result/text()" 2> /dev/null > depth.result
	diff depth.result depth.baseline

test-basex-unix:
	java -classpath ${basex} org.basex.BaseX total.xq -i${input} > total.result.xml
	xpath -e "/result/text()" total.result.xml 2> /dev/null | tr -d '\n' > total.result
	diff total.result total.baseline
	java -classpath ${basex} org.basex.BaseX cut.uf.xq -i${input} > cut.result.xml
	java -classpath ${basex} org.basex.BaseX total.xq -icut.result.xml | xpath -e "/result/text()" 2> /dev/null | tr -d '\n' > cut.result
	diff cut.result cut.baseline
	java -classpath ${basex} org.basex.BaseX depth.xq -i${input} > depth.result.xml
	xpath -e "/result/text()" depth.result.xml 2> /dev/null | tr -d '\n' > depth.result
	diff depth.result depth.baseline

test-saxon:
	java -classpath ${saxon} net.sf.saxon.Query -s:${input} -q:total.xq >total.result.xml
	xpath total.result.xml "/result/text()" 2> /dev/null > total.result
	diff total.result total.baseline
	java -classpath ${saxon} net.sf.saxon.Query -s:${input} -q:cut.xq >cut.result.xml
	java -classpath ${saxon} net.sf.saxon.Query -s:cut.result.xml -q:total.xq | xpath "/result/text()" 2> /dev/null > cut.result
	diff cut.result cut.baseline
	java -classpath ${saxon} net.sf.saxon.Query -s:${input} -q:depth.xq >depth.result.xml
	xpath depth.result.xml "/result/text()" 2> /dev/null > depth.result
	diff depth.result depth.baseline

gui:
	java -classpath ${basex} org.basex.BaseXWin

clean:
	rm -f *~ *.result *.result.xml
