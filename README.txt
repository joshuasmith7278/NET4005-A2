Java Flight Reservation Application

This application uses Java Remote Method Invocation (RMI). RMI allows distributed (non-local) applications to
invoke methods on objects running in another application. The client can be on a remote device and still access
the server object.

Create a remote interface for class "Reservation".
This class is binded to the RMI registry through rebind() on the "RsvServer"
The class is fetched from the RMI registry through lookup() on the "RsvClient"
The RMI registry allows a name service to reference a remote object, we set out RMI class to "rmi://localhost/rsv"


