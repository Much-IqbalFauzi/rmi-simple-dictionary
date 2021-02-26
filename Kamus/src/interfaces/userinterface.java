/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.User;

/**
 *
 * @author JESSI
 */
public interface userinterface extends Remote {
    public boolean isUserExist(String username) throws RemoteException;
    public boolean isUserValid(String username, String password) throws RemoteException;
    public User getUserByUsername(String username) throws RemoteException;
    public boolean updateUser(User user) throws RemoteException;
    public boolean insertUser(User user) throws RemoteException;
    public List<User> getAllUser() throws RemoteException;
}
