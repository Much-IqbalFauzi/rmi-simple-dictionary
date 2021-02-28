/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;


import com.sun.java.accessibility.util.Translator;
import interfaces.historyinterface;
import interfaces.userinterface;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author iqbalfauzi
 */
public class AppLogin {
    //LUPAKAN CLASS INI
    public static userinterface uice;
    public static historyinterface hice;
    
    
    public AppLogin() throws NotBoundException, MalformedURLException, RemoteException {
        uice = (userinterface) Naming.lookup("rmi://127.0.0.1:2929/user");
        hice = (historyinterface) Naming.lookup("rmi://127.0.0.1:2929/history");
    }
    
    
    
    
}
