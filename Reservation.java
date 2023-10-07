package Assignment;

import java.rmi.*;

public interface Reservation extends Remote
{
    public String list() throws RemoteException;
    public String reserve(String classT, String name, int seatNum) throws RemoteException;
}