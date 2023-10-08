package Assignment;

import java.rmi.*;
import java.util.Arrays;
import java.util.HashMap;


public interface Reservation extends Remote
{
    public String list() throws RemoteException;
    public String reserve(String classT, String name, int seatNum) throws RemoteException;
    public HashMap<Integer, String> passengerlist() throws RemoteException;
}