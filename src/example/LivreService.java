package example;


import com.sun.jersey.api.json.JSONConfiguration;
import model.Livre;
import singleton.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aladinne on 22/02/2016.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/livre")
public class LivreService{

        @GET
        @Path("/test")

        public String test() {
            return "test";
        }

    // The Java method will process HTTP GET requests
    @GET
    @Path("/getAll")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    //@Produces({MediaType."application/json",MediaType."application/xml"})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Livre> getAll() {
        // Return some cliched textual content


        ResultSet res = null ;
        Connection cn = Singleton.getInstance() ;
        List<Livre> le =new ArrayList<Livre>() ;
        try {
            Statement st= cn.createStatement();
            String req="select * from livre"  ;
            System.out.println(req) ;
            res =st.executeQuery(req);
            while(res.next())
            {
                Livre e = new Livre();
                e.setIsbn(res.getString("isbn"));
                e.setTitre(res.getString(2));
                e.setAuteur(res.getString(3));
                le.add(e) ;

            }
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();


        }

        return  le ;
    }




    @POST
    @Path("/AddLivre/isbn-{isbn}-titre-{titre}-auteur-{auteur}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    //@Produces({MediaType."application/json",MediaType."application/xml"})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void addLivre(@PathParam("isbn") String isbn, @PathParam("titre") String titre, @PathParam("auteur") String auteur) {


        Connection cn = Singleton.getInstance() ;

        try {
            Statement st= cn.createStatement();
            String req="INSERT INTO `livre`(`isbn`, `titre`, `auteur`) VALUES ('"+isbn+"','"+titre+"','"+auteur+"')"  ;
            System.out.println(req) ;
           st.executeUpdate(req);


        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();


        }


    }
    @GET
    @Path("/search/isbn-{isbn}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Livre> getByIsbn(@PathParam("isbn") String isbn)
    {


        ResultSet res = null ;
        Connection cn = Singleton.getInstance() ;
        List<Livre> le =new ArrayList<Livre>() ;
        try {
            Statement st= cn.createStatement();
            String req="select * from livre where isbn LIKE '%"+isbn+"%'"  ;
            System.out.println(req) ;
            res =st.executeQuery(req);
            while(res.next())
            {
                Livre e = new Livre();
                e.setIsbn(res.getString(1));
                e.setTitre(res.getString(2));
                e.setAuteur(res.getString(3));
                le.add(e) ;

            }
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();


        }

        return  le ;

    }
}
