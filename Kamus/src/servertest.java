
import controllers.historyimplementation;
import controllers.userimplementation;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import models.History;
import models.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JESSI
 */
public class servertest {

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(292);
        userimplementation userservice = new userimplementation();
        historyimplementation historyservice = new historyimplementation();

        reg.rebind("user", userservice);
        reg.rebind("nistory", userservice);

        System.out.println("Server Telah Berjalan");

        String name = userservice.getUserByUsername("jessifebria").getNama();

        boolean isexist = userservice.isUserExist("iqbal");
        boolean isexist2 = userservice.isUserExist("jessi");

        System.out.println(name);
        System.out.println(isexist);
        System.out.println(isexist2);

//        User user = new User("jessi", "adsf", "abf", "adfas", "12kwh");
        User user = new User("jessi", "bbbbbbbbbbbb", "abf", "adfas", "12kwh");

        System.out.println(userservice.updateUser(user));
        System.out.println(userservice.isUserValid("jessifebria", "12345"));
        System.out.println(userservice.isUserValid("jessifebria", "123456"));

        List<User> users = userservice.getAllUser();

        String[][] data = new String[users.size()][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = String.valueOf(users.get(i).getNama());
            data[i][1] = users.get(i).getUsername();
            System.out.println(data[i][0] + "    " + data[i][1]);
        }

        System.out.println(userservice.getAllUser());

        System.out.println("HISTORY TESTING");

        History history = historyservice.getHistoryById("1");

        System.out.println(history.getDatetime());

//        History history2 = new History("ID", "EN", "Tangan", "Hand", "iqbal");
//        System.out.println(historyservice.insertHistory(history2));
        List<History> histories = historyservice.getHistoryByUsername("jessifebria");

        String[][] dataa = new String[histories.size()][3];
        for (int i = 0; i < dataa.length; i++) {
            dataa[i][0] = String.valueOf(histories.get(i).getLanguage_id_from());
            dataa[i][1] = histories.get(i).getUser();
            dataa[i][2] = histories.get(i).getDatetime();
            System.out.println(dataa[i][0] + "    " + dataa[i][1] + "        "+ dataa[i][2]);
        }
    }
}
