package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String result= movieService.addMovie(movie);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String result= movieService.addDirector(director);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("moviename")String mname, @RequestParam("directorname")String dname){
        String result= movieService.addMovieDirectorPair(mname,dname);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie result= movieService.getMovieByName(name);
        if(result==null)
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director= movieService.getDirectorByName(name);
        if(director==null)
            return new ResponseEntity<>(director,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name){
        List<String> result= movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> result= movieService.findAllMovies();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        String result= movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String result= movieService.deleteAllDirectors();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
