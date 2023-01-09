package com.driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieDb;
    private HashMap<String,Director> directorDb;
    private HashMap<String,List<String>> directorMovieDb;       //we are not creating HashMap<Director,Movie> because it will take lots of space- here key will be director name and its value will be movies name

    public MovieRepository(HashMap<String, Movie> movieDb, HashMap<String, Director> directorDb, HashMap<String, List<String>> directorMovieDb) {
        this.movieDb = movieDb;
        this.directorDb = directorDb;
        this.directorMovieDb = directorMovieDb;
    }

    String addMovie(Movie movie){
        String key= movie.getName();
        movieDb.put(key,movie);
        return "Movie added successfully!";
    }

    String addDirector(Director director){
        String key= director.getName();
        directorDb.put(key,director);
        return "Director added successfully!";
    }

    String addMovieDirectorPair(String mname, String dname){
        if(movieDb.containsKey(mname) && directorDb.containsKey(dname))
        {
            List<String> result= new ArrayList<>();
            if(directorMovieDb.containsKey(dname)) {
                result = directorMovieDb.get(dname);
            }
                result.add(mname);
                directorMovieDb.put(dname,result);
        }
        return "Movie Director Pair added successfully!";
    }

    Movie getMovieByName(String name){
        return movieDb.get(name);
    }

    Director getDirectorByName(String name){
        return directorDb.get(name);
    }

    List<String> getMoviesByDirectorName(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieDb.containsKey(director))
            moviesList = directorMovieDb.get(director);
        return moviesList;
    }

    List<String> findAllMovies(){
        return new ArrayList<>(movieDb.keySet());
    }

    String deleteDirectorByName(String name){
        List<String> movies= new ArrayList<>();
        if(directorMovieDb.containsKey(name))
        {
            movies= directorMovieDb.get(name);
        }
        for(int i=0; i<movies.size(); i++)
        {
            if(movieDb.containsKey(movies.get(i)))
                movieDb.remove(movies.get(i));
        }
        directorMovieDb.remove(name);
        directorDb.remove(name);
        return "Director and his movies deleted successfully!";
    }

    String deleteAllDirectors(){
        for(String key: directorMovieDb.keySet())
        {
            List<String> list= directorMovieDb.get(key);
            for(int i=0; i<list.size(); i++)
            {
                movieDb.remove(list.get(i));
            }
            directorDb.remove(key);
        }
        directorMovieDb.clear();
        return "All directors and all their movies deleted from the records";
    }
}
