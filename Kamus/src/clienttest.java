/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import interfaces.userinterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class clienttest  {

    public static void main(String[] args) throws RemoteException, NotBoundException,
            MalformedURLException, IOException {
        String respons = "";
        BufferedReader masuk = new BufferedReader(new InputStreamReader(System.in));
        
        userinterface lif = (userinterface) Naming.lookup("rmi://127.0.0.1:292/user");
        System.out.println("tersambung...");
        
    
        respons = lif.getUserByUsername("jessifebria").getEmail();
        System.out.println(respons);
    }
}
