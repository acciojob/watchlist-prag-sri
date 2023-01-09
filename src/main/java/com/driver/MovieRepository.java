package com.driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb;
    HashMap<String,Director> directorDb;
    HashMap<String,List<String>> directorMovieDb;       //we are not creating HashMap<Director,Movie> because it will take lots of space- here key will be director name and its value will be movies name

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
        if(directorMovieDb.containsKey(dname))
        {
            List<String> curr= directorMovieDb.get(dname);
            curr.add(mname);
            directorMovieDb.put(dname,curr);
        }
        else
        {
            List<String> curr= new ArrayList<>();
            curr.add(mname);
            directorMovieDb.put(dname,curr);
        }

//        for(String key: directorMovieDb.keySet())
//        {
//            System.out.println(key+" "+directorMovieDb.get(key));
//        }
        return "Movie Director Pair added successfully!";
    }

    Movie getMovieByName(String name){
        for(Movie m: movieDb.values())
        {
            if(m.getName().equals(name))
                return m;
        }
        return null;
    }

    Director getDirectorByName(String name){
        for(Director d: directorDb.values())
        {
            if(d.getName().equals(name))
                return d;
        }
        return null;
    }

    List<String> getMoviesByDirectorName(String name){
        return directorMovieDb.get(name);
    }

    List<String> findAllMovies(){
        List<String> result= new ArrayList<>();
        for(Movie m: movieDb.values())
        {
            result.add(m.getName());
        }
        return result;
    }

    String deleteDirectorByName(String name){
        List<String> movies= directorMovieDb.get(name);
        directorMovieDb.remove(name);
        directorDb.remove(name);
        for(int i=0; i<movies.size(); i++)
        {
            movieDb.remove(movies.get(i));
        }
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
