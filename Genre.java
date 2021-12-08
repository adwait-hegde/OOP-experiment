import java.util.*;

public class Genre {
    String name;
    public List<Movie> movies;

    public Genre(String name, List<Movie> movies)
    {
        this.name = name;
        this.movies = movies;
    }

    // returns a list of movies of a given genre
    public List<Movie> getMovies()
    {
        return movies;
    }

    // used to convert Genre Object to string
    public String toString(){
        return (this.name + " | " + this.movies.size() + " items present in this.. \n\n");
    }
}
