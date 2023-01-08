package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String result= movieService.addMovie(movie);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        Movie movie= movieService.getMovieByName(name);
        if(movie==null)
            return new ResponseEntity<>(movie,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> result= movieService.findAllMovies();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
