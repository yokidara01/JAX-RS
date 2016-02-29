package singleton;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Aladinne on 22/02/2016.
 */

public class Singleton {
    private static Connection cn=null;

    private Singleton(){
        try{
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            cn= DriverManager.getConnection(dbUrl, username, password);
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
