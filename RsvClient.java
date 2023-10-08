package Assignment;

import java.rmi.*;

public class RsvClient {
    public static void main(String[] args){
        if(args.length < 2){
            System.out.println("Wrong number of arguments input");
        }
        else{
            try{

                

                if(args[0].equals("list")){
                    //Call the List seats method
                    Reservation client = (Reservation) Naming.lookup(args[1]);
                    System.out.println("All Available Seats (All Classes and Prices):");
                    System.out.println(client.list());
                } else if(args[0].equals("reserve")){
                    //Call the reserve seat method
                    Reservation client = (Reservation) Naming.lookup(args[1]);
                    System.out.println(client.reserve(args[2], args[3], Integer.parseInt(args[4])));
                } else if(args[0].equals("passengerlist")){
                    //Call the passengers who reserved seats method
                    Reservation client = (Reservation) Naming.lookup(args[1]);
                    System.out.println("List of all booked passengers:");
                    System.out.println(client.passengerlist());
                }


                
              
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    
}
