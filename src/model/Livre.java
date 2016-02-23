package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Aladinne on 22/02/2016.
 */
@XmlRootElement
public class Livre {
   private String isbn;
   private String titre;
   private String auteur;



   public Livre() {
      super();
   }

   public Livre(String isbn, String titre, String auteur, String medition, String dateedition) {
      this.isbn = isbn;
      this.titre = titre;
      this.auteur = auteur;

   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public void setTitre(String titre) {
      this.titre = titre;
   }

   public void setAuteur(String auteur) {
      this.auteur = auteur;
   }





   public String getIsbn() {
      return isbn;
   }

   public String getTitre() {
      return titre;
   }

   public String getAuteur() {
      return auteur;
   }


}
