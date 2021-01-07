package DAO_impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DAO.FiliereDAO;
import Enteties.Filieres;
 


public class FiliereDAOimpl implements FiliereDAO{

	@Override
	public void creer(Filieres F) {		
		
		list_fil.put(F.getCode(), F);		
		stocker(F);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Filieres> List_filiere() {
		
		
		ArrayList<Filieres> fl = new ArrayList<Filieres>();
		
		try{
		    FileInputStream readData = new FileInputStream("fil_list.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    
		    fl = (ArrayList<Filieres>) readStream.readObject();
		    
		    readStream.close();
		    
		    System.out.println(" chargement terminer ! ");
		    
		}catch (Exception e) {
		    e.printStackTrace();
		}
 
		
		 for (int i = 0; i<fl.size(); i++)
		 {
		
			Filieres f = new Filieres();
		f = fl.get(i);
			
		list_fil.put(f.getCode(), f);
		
		 } 
		 return list_fil;
			}

	@Override
	public Filieres find_filiere(String code) {
		
			
		
		return null;
	}

	@Override
	public void stocker( Filieres F ) {
		try{
		    FileOutputStream writeData = new FileOutputStream("fil_list.txt");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(F);
		    writeStream.flush();
		    writeStream.close();
		    System.out.println(" Stockage terminer ! ");
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}

	
}
