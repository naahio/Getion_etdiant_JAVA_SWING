package Enteties;

import java.io.Serializable;

public class Filieres implements Serializable{

	
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String code;
		private String Nom;
		private String departement;
		
		
		
		public Filieres() {
			
		}



		public String getCode() {
			return code;
		}



		public void setCode(String code) {
			this.code = code;
		}



		public String getNom() {
			return Nom;
		}



		public void setNom(String nom) {
			Nom = nom;
		}



		public String getDepartement() {
			return departement;
		}



		public void setDepartement(String departement) {
			this.departement = departement;
		}
		
		
		
	
	
}
