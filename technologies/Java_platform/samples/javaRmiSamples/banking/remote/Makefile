server = linux.uni-koblenz.de

all:
	cd ../..; \
	javac 	banking/local/Demo.java \
			banking/remote/server/Server.java \
			banking/remote/client/Client.java

demo:
	cd ../..; java banking.local.Client

start-server:
	@cd ../..; java -Djava.security.policy=banking/remote/server/security.policy banking.remote.server.Server

start-local-client:
	@cd ../..; java banking.remote.client.Client

start-remote-client:
	@cd ../..; java banking.remote.client.Client ${server}

clean:
	@cd ../../banking/local; rm -f *.class
	@cd ../../banking/remote/shared; rm -f *.class
	@cd ../../banking/remote/server; rm -f *.class
	@cd ../../banking/remote/client; rm -f *.class
