import java.util.*;

public class Database {

    //All the movies
    Movie m1 = new Movie("PK","U/A","Rajkumar Hirani",2016, 12);
    Movie m2 = new Movie("Race3","U/A","Driver",2012, 12);
    Movie m3 = new Movie("War","A","Ramesh",2016, 6);
    Movie m4 = new Movie("2012","U","Suresh",2011, 10);
    Movie m5 = new Movie("BABY","U/A","K Sharma", 2016, 20);
    Movie m6 = new Movie("Munnabhai M.B.B.S","U","Rajkumar Hirani", 2003, 7);
    Movie m7 = new Movie("Hera Pheri","U","Baburao Apte", 2000, 5);
    Movie m8 = new Movie("Gol Maal","U","Rajkumar Hirani", 2003, 7);
    Movie m9 = new Movie("Externals","U/A","Chloé Zhao", 2021, 100);
    Movie m10 = new Movie("Tubelight","U","Selman Khan", 2017, 70);
    Movie m11 = new Movie("Spider-Man: No Way Home","A","Jon Whatts", 2022, 70);
    Movie m12 = new Movie("Stranger Things","U","David", 2016, 47);
    Movie m13 = new Movie("Dune","U","Finn Brown", 1984, 2);
    Movie m14 = new Movie("Free Guy","A","Shawn Lee", 2021, 45);


    // TVSHOWS MOVIES
    // F.R.I.E.N.D.S
    Movie e11 = new Movie("The One Where It All Began","U/A","James Burrows",1994, 1);
    Movie e12 = new Movie("The One with the Sonogram at the End","A","James Burrows",1994, 1);
    Movie e13 = new Movie("The One with the Thumb","A","James Burrows",1994, 1);
    Movie e14 = new Movie("The One with George Stephanopoulos","A","James Burrows",1994, 1);
    Movie e15 = new Movie("The One with the East German Laundry Detergent","A","Pamela Fryman",1994, 1);
    Movie e16 = new Movie("The One with the Butt","U/A","Arlene Sanford",1994, 1);
    // Game of Thrones
    Movie e21 = new Movie("Winter Is Coming","U/A","Tim Van Patten",2011, 15);
    Movie e22 = new Movie("The Kingsroad","A","Tim Van Patten",2011, 15);
    Movie e23 = new Movie("Lord Snow","U/A","Brian Kirk",2011, 14);

    //All the TVShows
    TVShow friends;
    TVShow got;

    //Genre list action, comedy, romance, drama
    public Genre action;
    public Genre comedy;
    public Genre scifi;

    // creating a user
    User u1 = new User("adwait", "ad", 23, "9833512267", "Mumbai", 'M');

    public static List<Movie> allMovies;
    public static List<TVShow> allTVShows;
    public static List<Genre> allGenres;
    public static List<User> allUsers;

    Database(){
        //initialising all the arralists
        allMovies = new ArrayList<Movie>();
        allTVShows = new ArrayList<TVShow>();
        allGenres = new ArrayList<Genre>();
        allUsers = new ArrayList<User>();

        // adding movies
        this.allMovies.add(m1);
        this.allMovies.add(m2);
        this.allMovies.add(m3);
        this.allMovies.add(m4);
        this.allMovies.add(m5);
        this.allMovies.add(m6);
        this.allMovies.add(m7);
        this.allMovies.add(m8);
        this.allMovies.add(m9);
        this.allMovies.add(m10);
        this.allMovies.add(m11);
        this.allMovies.add(m12);
        this.allMovies.add(m13);
        this.allMovies.add(m14);
        this.allMovies.add(e11);
        this.allMovies.add(e12);
        this.allMovies.add(e13);
        this.allMovies.add(e14);
        this.allMovies.add(e15);
        this.allMovies.add(e16);
        this.allMovies.add(e21);
        this.allMovies.add(e22);
        this.allMovies.add(e23);

        // creating genres
        List<Movie> gaction = new ArrayList<Movie>();
        gaction.add(m2);
        gaction.add(m3);
        gaction.add(m4);
        gaction.add(m5);
        action = new Genre("Action",gaction);
        
        List<Movie> gcomedy = new ArrayList<Movie>();
        gcomedy.add(m1);
        gcomedy.add(m6);
        gcomedy.add(m7);
        gcomedy.add(m8);
        comedy = new Genre("Comedy",gcomedy);
        
        List<Movie> gscifi = new ArrayList<Movie>();
        gscifi.add(m9);
        gscifi.add(m10);
        gscifi.add(m11);
        gscifi.add(m12);
        gscifi.add(m13);
        gscifi.add(m14);
        scifi = new Genre("Sci-Fi",gscifi);


        // creating TV-Shows
        friends = new TVShow("F.R.I.E.N.D.S","U/A","James & Team",1994);
        friends.addEpisode(e11);
        friends.addEpisode(e12);
        friends.addEpisode(e13);
        friends.addEpisode(e14);
        friends.addEpisode(e15);
        friends.addEpisode(e16);

        got = new TVShow("Game of Thrones","A","Tim & Team",2011);
        got.addEpisode(e11);
        got.addEpisode(e12);
        got.addEpisode(e13);

        // adding TV-Shows to Arraylist
        allTVShows.add(friends);
        allTVShows.add(got);

        // adding Genres to Arraylist
        allGenres.add(action);
        allGenres.add(comedy);
        allGenres.add(scifi);

        // adding a user
        this.allUsers.add(u1);
    }

    //register feature
    boolean addUser(User newuser){
        for (User user: allUsers){
            if (user.getUsername() == newuser.getUsername()){
                return false;
            }
        }
        this.allUsers.add(newuser);
        return true;
    }

    //login feature
    User authenticate(String username, String password){
        for (User user: allUsers){
            if (user.login(username, password)){
                return user;
            }
        }
        return null;
    }

    //getter for all search feature
    public List<Movie> getMovies(String name)
    {
        List<Movie> matches = new ArrayList<Movie>();
        for (Movie movie: allMovies){
            if (movie.name.contains(name))
                matches.add(movie);
        }
        return matches;
    }

    
}
