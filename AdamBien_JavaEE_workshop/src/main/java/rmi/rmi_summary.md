We had an interface called hello and the interface was implemented by HelloServant.
We had 2 JVM (!), Client, Server, 2 main methods
On the server: registered the HelloServant with the name Hello to a Registry (to RMI Registry), 1st parameter String, 2nd Instance
On the client: used Naming.lookup (rmi://localhost:1099/hello) (lookup == factory / decorator, creates on the fly implementation of the Hello Interface because the real implemenation is on server side. The implementation is "$Proxy0", what happens is RMI Invocation Handler was registered and it intercepts all calls to the server.
