import java.util.*;
public class TVShow extends MovieObject {
    private int episodes;
    public List<Movie> episodeList;

    public TVShow(String name, String category, String director, int year){
        super(name,category,director,year);
        this.episodes = 0;
        this.episodeList = new ArrayList<Movie>();
        // System.out.println("----------- Data stored by TVShow Constructor ------------\n");
    }

    public void addEpisode(Movie movie){
        this.episodeList.add(movie);
        this.episodes +=1;
    }


    public void print(){
        // System.out.println("TVShow:");
        System.out.println("  "+this.name + " | " + this.category + " | " + this.director + " | " + this.year+ " | " + this.episodes+ "\n\n");
    }

    public List<Movie> getMovies()
    {
        return episodeList;
    }
}
