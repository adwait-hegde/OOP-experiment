import java.util.List;

public class DisplayThread extends Thread {

    public void run() {
    Database db = new Database();
    List<Movie> movies = db.allMovies;
        for (Movie movie: movies){
            movie.print();
        }
    }
}
