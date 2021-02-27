/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import com.google.api.translate.TranslatorFrame;
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
    
    public static userinterface uice;
    public static historyinterface hice;
    Translate transl;
    Language lang;
    
    
    public AppLogin() throws NotBoundException, MalformedURLException, RemoteException {
        uice = (userinterface) Naming.lookup("rmi://127.0.0.1:2929/user");
        hice = (historyinterface) Naming.lookup("rmi://127.0.0.1:2929/history");
    }
    
    
    
    
}
