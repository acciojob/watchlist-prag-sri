package com.driver;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb= new HashMap<>();

    String addMovie(Movie movie){
        String key= movie.getName();
        movieDb.put(key,movie);
        return "Movie added successfully!";
    }

    Movie getMovieByName(String name){
        for(Movie m: movieDb.values())
        {
            if(m.getName().equals(name))
                return m;
        }
        return null;
    }

    List<Movie> findAllMovies(){
        List<Movie> result= new ArrayList<>();
        for(Movie m: movieDb.values())
        {
            result.add(m);
        }
        return result;
    }
}
