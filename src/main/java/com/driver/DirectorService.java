package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    String addDirector(Director director){
        String result= directorRepository.addDirector(director);
        return result;
    }

    Director getDirectorByName(String name){
        Director director= directorRepository.getDirectorByName(name);
        return director;
    }

    String deleteDirectorByName(String name) {
        String result = directorRepository.deleteDirectorByName(name);
        return result;
    }

    public String deleteAllDirectors(){
        String result= directorRepository.deleteAllDirectors();
        return result;
    }
}
