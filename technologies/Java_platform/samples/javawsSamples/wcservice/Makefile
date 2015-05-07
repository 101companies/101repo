jboss-home = /Users/laemmel/software/jboss-5.1.0.GA

files = \
	jbossws-native-saaj.jar \
	jbossws-native-jaxrpc.jar \
	jbossws-native-jaxws.jar \
	jbossws-native-jaxws-ext.jar

none:

#
# Copy JBoss files as described here:
# http://www.jboss.org/file-access/default/members/jbossas/freezone/docs/Installation_And_Getting_Started_Guide/5/html/source_installation.html#Java6_Notes
#
copy:
	cd ${jboss-home}/client; cp ${files} ${jboss-home}/lib/endorsed
