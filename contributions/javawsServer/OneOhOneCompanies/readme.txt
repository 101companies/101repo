How to install JBoss in Eclipse : 
1. 
Click right mouse on Project and select 
New->Server->JBoss v5.0 and provide path to JBoss directory. 
Don't forget to select JDK 1.6

2a. 
You should follow these instructions :
http://www.jboss.org/file-access/default/members/jbossas/freezone/docs/Installation_And_Getting_Started_Guide/5/html/source_installation.html#Java6_Notes

2b.
Open "Run configurations", select Generic servers -> JBoss server, open tab "Arguments".
Add to field "VM arguments"
-Djava.endorsed.dirs=/JBOSS_HOME/lib/endorsed/ 

3. 
It's advisable to change timeout for server's startup. 
Double click on a server in "Servers" tab and increase timeout time in "Timeouts" section.
