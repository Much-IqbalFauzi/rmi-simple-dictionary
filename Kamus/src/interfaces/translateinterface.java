/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import models.Translata;

/**
 *
 * @author iqbalfauzi
 */
public interface translateinterface extends Remote {
    public List<String> DataByKey(String from) throws RemoteException;
    
}
