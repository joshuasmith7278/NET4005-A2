package Assignment;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Arrays;
import java.util.HashMap;


public class RsvServer extends UnicastRemoteObject implements Reservation 
{
    int businessClass[] = new int[5];
    int economyClass[] = new int[25];
    HashMap<Integer, String> passengers = new HashMap<Integer, String>();
    int totalSeats = 30;

    RsvServer() throws RemoteException {
        System.out.println("New Reservation Server");
        for(int i = 0; i < 5; i++){
            businessClass[i] = i+1;
        }
        for(int i = 0; i < 25; i++){
            economyClass[i] = i+6;
        }
      
    }

    public String list() throws RemoteException{
        String results= "";

        int businessPlus = 0;
        int businessReg = 0;
        int economyPlus = 0;
        int economyReg = 0;
        int economyBasic = 0;

        for(int i = 0; i < businessClass.length; i++){
            if(businessClass[i] <= 3 && businessClass[i] != 0){
                businessReg++;
            }else if(businessClass[i] != 0){
                businessPlus++;
            }
        }

        for(int i = 0; i < economyClass.length; i++){
            if(economyClass[i] <= 15 && economyClass[i] != 0){
                economyBasic++;
            }else if(economyClass[i] <= 25 && economyClass[i] != 0){
                economyReg++;
            }else if(economyClass[i] != 0){
                economyPlus++;
            }
        }


        results += Arrays.toString(businessClass) + Arrays.toString(economyClass) + "\n";
        results += String.valueOf(businessReg) + " business class regular seats available for $500/e.\n";
        results += String.valueOf(businessPlus) + " business class plus seats available for $800/e.\n";
        results += String.valueOf(economyBasic) + " economy class basic seats available for $200/e.\n";
        results += String.valueOf(economyReg) + " economy class regular seats available for $300/e.\n";
        results += String.valueOf(economyPlus) + " economy class plus seats available for $450/e.\n";

        return results;
    }


    public String reserve(String classT, String name, int seatNum) throws RemoteException{
        String results = "";
        boolean seatTaken = false;
        if(classT.equals("business") && seatNum < 6){
            for(int i = 0; i < businessClass.length; i++){
                if(businessClass[i] == seatNum){
                    passengers.put(seatNum, name);
                    businessClass[i] = 0;
                    seatTaken = true;
                    results += "Successfully reserved seat " + String.valueOf(seatNum) + " for passenger " + name + "\n";
                }
            }

            if(seatTaken == false){
                results += "Failed to reserve: seat not available. \n";
            }


        }
        else if(classT.equals("economy") && seatNum > 5 && seatNum < 31){
            for(int i = 0; i < economyClass.length; i++){
                if(economyClass[i] == seatNum){
                    passengers.put(seatNum, name);
                    economyClass[i] = 0;
                    seatTaken = true;
                    results += "Successfully reserved seat " + String.valueOf(seatNum) + " for passenger " + name + ". \n";
                }
            }

            if(seatTaken == false){
                results += "Failed to reserve: seat not available. \n";
            }
        }
        else{
            results += "Failed to reserve: invalid seat number. \n";
        }


        


        return results;
    }


    public HashMap<Integer, String> passengerlist() throws RemoteException{
        return passengers;

    }

    public static void main(String[] args){
        try{
            RsvServer server = new RsvServer();
            Naming.rebind("rmi://localhost/rsv", server);

        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    
    
}