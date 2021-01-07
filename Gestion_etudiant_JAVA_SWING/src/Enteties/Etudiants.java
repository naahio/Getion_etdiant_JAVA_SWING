package Enteties;


public class Etudiants {

		
		
		private int Id;
		private String Nom;
		private String Prenom;
		private String CIN;
		private String CNE;
		private float Moy;
		private Filieres filiere;
		
		
		
		
		public Etudiants() {
			
		}




		public int getId() {
			return Id;
		}




		public void setId(int id) {
			Id = id;
		}




		public String getNom() {
			return Nom;
		}




		public void setNom(String nom) {
			Nom = nom;
		}




		public String getPrenom() {
			return Prenom;
		}




		public void setPrenom(String prenom) {
			Prenom = prenom;
		}




		public String getCIN() {
			return CIN;
		}




		public void setCIN(String cIN) {
			CIN = cIN;
		}




		public String getCNE() {
			return CNE;
		}




		public void setCNE(String cNE) {
			CNE = cNE;
		}




		public float getMoy() {
			return Moy;
		}




		public void setMoy(float n1, float n2, float n3, float n4) {
			Moy = ( n1+ n2+ n3+ n4 )/4;
		}




		public Filieres getFiliere() {
			return filiere;
		}




		public void setFiliere(Filieres filiere) {
			this.filiere = filiere;
		}
		
		
		
	
	
}
