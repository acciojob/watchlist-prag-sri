package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    String addMovie(Movie movie){
        String result= movieRepository.addMovie(movie);
        return result;
    }

    String addDirector(Director director){
        String result= movieRepository.addDirector(director);
        return result;
    }

    String addMovieDirectorPair(String mname, String dname){
        String result= movieRepository.addMovieDirectorPair(mname,dname);
        return result;
    }

    Movie getMovieByName(String name){
        Movie result= movieRepository.getMovieByName(name);
        return result;
    }

    Director getDirectorByName(String name){
        Director director= movieRepository.getDirectorByName(name);
        return director;
    }

    List<String> getMoviesByDirectorName(String name){
        List<String> result= movieRepository.getMoviesByDirectorName(name);
        return result;
    }

    List<String> findAllMovies(){
        List<String> result= movieRepository.findAllMovies();
        return result;
    }

    String deleteDirectorByName(String name){
        String result= movieRepository.deleteDirectorByName(name);
        return result;
    }

    String deleteAllDirectors(){
        String result= movieRepository.deleteAllDirectors();
        return result;
    }
}
