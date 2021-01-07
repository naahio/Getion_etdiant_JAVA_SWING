package DAO;

import java.io.IOException;
import java.util.HashMap;

import Enteties.Filieres;

public interface FiliereDAO {

		public  HashMap< String, Filieres> list_fil =  new HashMap<>();
	 

		public void creer(Filieres F);
		public HashMap<String , Filieres> List_filiere() throws IOException; 
		public Filieres find_filiere( String code );
		public void stocker( Filieres F);
		
}
