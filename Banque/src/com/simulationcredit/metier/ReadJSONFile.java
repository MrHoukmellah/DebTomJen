package com.simulationcredit.metier;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

import com.simulationcredit.model.Simulateurs;


public abstract class ReadJSONFile {
	
    public static Simulateurs readJSONFile (File file) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader(file)) {

            // Convert JSON File to Java Object
            Simulateurs simulateursJSON = gson.fromJson(reader, Simulateurs.class);

            return simulateursJSON;
            
        } catch (IOException e) {
        	
        	System.out.println("erreur de lecture du fichier JSON");
        	
        	return null;

        }
        
        

    }


 
}
