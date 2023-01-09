package com.driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DirectorRepository {
    HashMap<String,Director> directorDb= new HashMap<>();

    String addDirector(Director director){
        String key= director.getName();
        directorDb.put(key,director);
        return "Director added successfully!";
    }

    Director getDirectorByName(String name){
        for(Director d: directorDb.values())
        {
            if(d.getName().equals(name))
                return d;
        }
        return null;
    }

    String deleteDirectorByName(String name) {
        directorDb.remove(name);
        return "Director deleted successfully!";
    }

    public String deleteAllDirectors(){
        directorDb.clear();
        return "All directors deleted successfully!";
    }
}
