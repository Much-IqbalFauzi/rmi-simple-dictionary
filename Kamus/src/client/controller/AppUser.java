/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import interfaces.historyinterface;
import interfaces.userinterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import models.History;
import models.User;

/**
 *
 * @author iqbalfauzi
 */
public class AppUser {
    
    private userinterface uice = null;
    private historyinterface hice = null;
    
    public void SetRemoteUser() throws NotBoundException, MalformedURLException, RemoteException {
        this.uice = (userinterface) Naming.lookup("rmi://127.0.0.1:2929/user");
    }
    
    public void SetRemoteHistory() throws NotBoundException, MalformedURLException, RemoteException {
        this.hice = (historyinterface) Naming.lookup("rmi://127.0.0.1:2929/history");
    }
    
    public int LoginCheck(String username, String password) throws RemoteException {
        int res = 0;
        if(uice.isUserExist(username)) {
            if(uice.isUserValid(username, password)){
                res = 200;
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
    
    public boolean UserRegister(User user) throws RemoteException {
        boolean res = uice.insertUser(user);
        return res;
    }
    
    public List<History> AllHistory(String username) throws RemoteException {
        return hice.getHistoryByUsername(username);
    }
    
    public void CheckUserRemote() throws NotBoundException, MalformedURLException, RemoteException {
        if(uice == null) {
            SetRemoteUser();
        }
    }
    
    public void CheckHistoryRemote() throws NotBoundException, MalformedURLException, RemoteException {
        if(hice == null) {
            SetRemoteHistory();
        }
    }
    
}
