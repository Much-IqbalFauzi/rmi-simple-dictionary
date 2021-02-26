/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.History;

/**
 *
 * @author JESSI
 */
public interface historyinterface extends Remote{
    
    public boolean insertHistory(History history) throws RemoteException;
    public List<History> getHistoryByUsername(String username) throws RemoteException;
    public List<History> getAllHistory() throws RemoteException;
    public History getHistoryById(String id) throws RemoteException;
    
    
}
