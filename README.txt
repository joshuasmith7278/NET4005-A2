Java Flight Reservation Application

This application uses Java Remote Method Invocation (RMI). RMI allows distributed (non-local) applications to
invoke methods on objects running in another application. The client can be on a remote device and still access
the server object.

Create a remote interface for class "Reservation".
This class is binded to the RMI registry through rebind() on the "RsvServer"
The class is fetched from the RMI registry through lookup() on the "RsvClient"
The RMI registry allows a name service to reference a remote object, we set out RMI class to "rmi://localhost/rsv"


Step 1: Implement Remote Interface ---------------------------------------

Reservation.Java
- Create a Java Interface that extends Remote Method Invocation (RMI).
- Include the base structure (return type, function name, parameters) for the methods the client/server are going to invoke. These methods
 must throw exceptions because we are extracting these methods from a remote computer. This is 
 considered "risky"



 Step 2: Make Server Implementations of RMI Interface -----------------------------

 RsvServer.Java
 - The server must implement the RMI Interface (Reservation) and extend "UnicastRemoteObject", which allows the server to be seen 
 as a "remote object" from the super class
 - Then the server must have the real methods for the remote interface implementations. This holds the actual logical code that runs the methods.
 - The remote serice is set up, we have to register our object with the RMI Registry (rebind()). This allows the client to 
 connect to the RMI Registry and lookup our service object (server).



Step 3: Set up Client to look for Server RMI ----------------------------------------

RsvClient.Java
- The client looks up the RMI interface in the RMI Registry (lookup())
- The client creates a service object with the result of the lookup, and if successful, can call the RMI Interfaces methods from the client.





