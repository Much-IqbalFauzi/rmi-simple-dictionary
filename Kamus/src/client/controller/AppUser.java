/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import interfaces.historyinterface;
import interfaces.translateinterface;
import interfaces.userinterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import models.History;
import models.Translata;
import models.User;

/**
 *
 * @author iqbalfauzi
 */
public class AppUser {

    private static userinterface uice = null;
    private static historyinterface hice = null;
    private static translateinterface tice = null;

    private static AppUser appuser = null;

    private AppUser() {
    }

    public static AppUser getappuser() throws NotBoundException, MalformedURLException, RemoteException {
        if (appuser == null) {
            appuser = new AppUser();
            uice = (userinterface) Naming.lookup("rmi://127.0.0.1:2929/user");
            hice = (historyinterface) Naming.lookup("rmi://127.0.0.1:2929/history");
            tice = (translateinterface)  Naming.lookup("rmi://127.0.0.1:2929/translate");
            
        }
        return appuser;
    }

    public int LoginCheck(String username, String password) throws RemoteException {
        int res = 0;
        System.out.println("IN LOGIN CHECK");
        if (uice.isUserExist(username)) {
            if (uice.isUserValid(username, password)) {
                res = 200;
                System.out.println("VALIDD WOEY");
            } else {
                res = 500;
            }
        } else {
            res = 404;
        }
        return res;
    }

    public User UserInfo(String name) throws RemoteException {
        return uice.getUserByUsername(name);
    }

    public boolean UserUpdate(User user) throws RemoteException {
        if (uice.updateUser(user)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean UserRegister(User user) throws RemoteException {
        boolean res = uice.insertUser(user);
        return res;
    }

    public List<History> AllHistory(String username) throws RemoteException {
        
        System.out.println("in app user");
        return hice.getHistoryByUsername(username);
    }

    public boolean AddHistory(History history) throws RemoteException {
        boolean res = false;
        if (hice.insertHistory(history)) {
            res = true;
        }
        return res;
    }

    public List<Translata> TextTranslate(String text) throws RemoteException {
        return tice.DataByKey(text);
    }
    
    public List<Translata> TextTranslateReverse(String text) throws RemoteException {
        return tice.DataByKeyReverse(text);
    }

}
