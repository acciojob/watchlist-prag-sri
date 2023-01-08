package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String result= directorService.addDirector(director);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        Director director= directorService.getDirectorByName(name);
        if(director==null)
            return new ResponseEntity<>(director,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }
}