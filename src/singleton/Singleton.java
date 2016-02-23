package singleton;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Aladinne on 22/02/2016.
 */

public class Singleton {
    private static Connection cn=null;

    private Singleton(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn= DriverManager.getConnection("jdbc:mysql://localhost/servicedb","root","");
        }catch(Exception e){
            System.err.println("****************** Erreur Singleton");
            e.printStackTrace();
            System.err.println("******************  FIN Erreur Singleton");
        }
    }

    public static Connection getInstance(){
        if(cn==null){
            new Singleton();
        }
        return cn;
    }

}
