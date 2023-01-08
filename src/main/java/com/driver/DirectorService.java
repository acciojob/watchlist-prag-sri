package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
