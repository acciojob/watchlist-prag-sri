package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    String addMovie(Movie movie){
        String result= movieRepository.addMovie(movie);
        return result;
    }

    Movie getMovieByName(String name){
        Movie movie= movieRepository.getMovieByName(name);
        return movie;
    }

    List<Movie> findAllMovies(){
        List<Movie> result= movieRepository.findAllMovies();
        return result;
    }
}
