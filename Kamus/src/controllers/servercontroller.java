/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author JESSI
 */
public class servercontroller {

    private Registry reg;
    private userimplementation userservice;
    private historyimplementation historyservice ;
    private boolean status; 

    private static servercontroller server = null;
    
    public static servercontroller getserver(){
        System.out.println("AAAAAAAAAAA");
        if (server == null) {
            server = new servercontroller(false);
        }
        return server;
    }
    
    private servercontroller(boolean status) {
        this.status = status;
    }
   
    public void turnOn() throws RemoteException {
        setReg(LocateRegistry.createRegistry(292));

        setUserservice( new userimplementation());
        setHistoryservice(new historyimplementation() );
        
        getReg().rebind("user", getUserservice());
        getReg().rebind("nistory", getHistoryservice());
    }

    public void turnOff() throws RemoteException {
        UnicastRemoteObject.unexportObject(getReg(), true);
    }
    
     public Registry getReg() {
        return reg;
    }

    public void setReg(Registry reg) {
        this.reg = reg;
    }
    
     public userimplementation getUserservice() {
        return userservice;
    }

    public void setUserservice(userimplementation userservice) throws RemoteException {
        this.userservice = userservice;
    }

    public historyimplementation getHistoryservice() {
        return historyservice;
    }

    public void setHistoryservice(historyimplementation historyservice) throws RemoteException {
        this.historyservice = historyservice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
