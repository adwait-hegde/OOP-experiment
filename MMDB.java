import java.io.*;
import java.util.*;

public class MMDB {

    //Custom EXCEPTIONS 
    static void display(User user, MovieObject movie) throws UnderAgeException{
        if (user.getAge()<18 & movie.category=="A"){
            throw new UnderAgeException("A category movie and Age below 18.");
        }
        else
            movie.print();
    }

    // print the given movie and handle the exception
    static void printMovie(User user, Movie movie){
        try{
            display(user, movie);
        }
        catch( Exception exception){
            System.out.println("Exception: " + exception+ "\n");
        }
    }

    //print movies from Movie
    static void showMovies(User user) {
        Database db = new Database();
        List<Movie> movies = db.allMovies;
        for (Movie movie: movies){
            printMovie(user, movie);
        }
    }

    //print movies from Genre
    static void showGenres(User user) {
        Database db = new Database();
        System.out.println("  Available Genres:");
        System.out.println("   1. Sci-Fi");
        List<Movie> gMovies = db.scifi.getMovies();
        for (Movie movie: gMovies)
            printMovie(user, movie);

        System.out.println("   2. Comedy");
        gMovies = db.comedy.getMovies();
        for (Movie movie: gMovies)
            printMovie(user, movie);
    
        System.out.println("   3. Action");
        gMovies = db.action.getMovies();
        for (Movie movie: gMovies)
            printMovie(user, movie);       
    }

    //print movies from TVShow
    static void showTVShows(User user) {
        Database db = new Database();
        System.out.println("  Available TVShows:");
        System.out.println("   1. F.R.I.E.N.D.S");
        db.friends.print();
        List<Movie> gMovies = db.friends.getMovies();
        for (Movie movie: gMovies)
            printMovie(user, movie);

        System.out.println("   2. Game of Thrones");
        db.got.print();
        gMovies = db.got.getMovies();
        for (Movie movie: gMovies)
            printMovie(user, movie);   
    }

    // Exception: No Membership Exception
    static void exportdb(User user) throws NoMembershipException{
        if (! user.hasMembership()){
            throw new NoMembershipException(" Get a membership to export db!");
        }
    }

    public static void main(String[] args)  throws IOException{

        //Defining the database
        Database db = new Database();
        //logged in user
        User me = null;
        //IO classes
        Scanner scn = new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        System.out.println("  Welcome to Mast Movie Database! (MMDb) ");

        //Sign up | Log in to the system
        while(me == null){
            System.out.println("  You'll have to either Login or Sign Up.");
            System.out.println("    1. Login\n    2. Sign Up");
            System.out.print("   [+] Your choice: ");
            int resp = 1;
            resp = scn.nextInt();
            scn.nextLine();

            if(resp == 1){ // login
                System.out.print("  [+] Enter username: ");
                String username = br.readLine(); 
                
                System.out.print("  [+] Enter password: ");
                String password = br.readLine(); 

                me = db.authenticate(username, password);
                if (me != null){
                    System.out.println("  Login Succcessful!");
                    me.print();
                }
                else
                    System.out.println("  Invalid details.. Try again..");
            }
            else if(resp==2){ //signup
                //get all the required details for the CONSTRUCTOR
                System.out.print("  [+] Enter username: ");
                String username = br.readLine();
                System.out.print("  [+] Enter password: ");
                String password = br.readLine();
                System.out.print("  [+] Enter age: ");
                int age = scn.nextInt();
                scn.nextLine();
                System.out.print("  [+] Enter phone: ");
                String phone = br.readLine();
                System.out.print("  [+] Enter location: ");
                String location = br.readLine();
                System.out.print("  [+] Enter gender: ");
                char gender = scn.next().charAt(0);

                User temp = new User(username, password, age, phone, location, gender);
                
                //adds user if the details provided are as per the rules
                if (db.addUser(temp))
                    System.out.println("  User Added Successfully! ");
                else
                    System.out.println("  Username already exists.. Try something new! ");

            }
            else{
                System.out.println("  Invalid Option...");
            }
        }



        System.out.println("  Welcome, " + me.getUsername());

        int resp=5;

        System.out.println("  You can do the following in Mast Movie Database! (MMDb) ");
        System.out.println("  1. List all the movies in the db ");
        System.out.println("  2. Add a Classic or Premium membership "); 
        System.out.println("  3. List all the Genre in the db "); 
        System.out.println("  4. List all the TVShows in the db "); 
        System.out.println("  5. Create a .txt file of the database [* membership required] ");
        System.out.println("  6. Search movie in the db ");
        System.out.println("  7. Add Movie/TV-show to the Favourites ");
        System.out.println("  8. Show my favourites Movies/TV-shows");
        System.out.println("  9. Add Movie/TV-show/Genre to the Watch Later ");
        System.out.println("  10. Show my Watch Later Movies/TV-shows/Genres ");
        System.out.println("  0. Log Out and Exit ");


        while(resp != 0){

            System.out.print("\n   [+] Your choice: ");

            resp = scn.nextInt();
            scn.nextLine();

            
            switch(resp) {

                // INHERITANCE CONCEPT
                // Displaying all the Movies in database
                case 1:
                    try{
                        showMovies(me);
                    }
                    catch( Exception exception){
                        System.out.println("Exception: " + exception);
                    }
                break;

                // NESTED CLASS + COMPOSITION CONCEPT
                // Adding a new membership to the User class
                case 2:
                    me.newMembership("Jan2022","Premium",1000);
                    Thread emailsender = new EmailSender();
                    emailsender.start();
                    // emailsender.run();

                    me.print();
                break;
                
                // AGGREGATION CONCEPT
                // Displaying all the Genere in database
                case 3:
                    showGenres(me); 
                break;

                // COMPOSITION CONCEPT
                // Displaying all the TV Shows in database
                case 4:
                    showTVShows(me);
                break;
                

                // FILE HANDLING CONCEPT
                // Exporting the moovies from database
                case 5:
                try{
                    exportdb(me);
                    //Thread to export the database
                    Thread t1= new Thread(new ExportDB());
                    t1.start();
                    Thread.sleep(1000); // to avoid confusing statements at CLI
                    //Thread to display the database
                    Thread t2 = new DisplayThread();
                    t2.start();
                    Thread.sleep(1000); // to avoid confusing statements at CLI
                }
                catch(Exception e) {
                    System.out.println(e);
                }
                break;


                //Searching for a  Movie in the database
                case 6:
                    System.out.print("  Enter the name of the movie: ");
                    String name = br.readLine();
                    List<Movie> matches = db.getMovies(name);
                    for(Movie movie: matches){
                        try{
                            display(me, movie);
                        }
                        catch( Exception exception){
                            System.out.println(exception);
                        }
                    }
                break;

                // GENERIC CONCEPT
                // Adding Movies or TV-Shows to the Favourite list
                case 7:
                    System.out.print("   [+] Do u want to add 1. Movie 2.TV-Show: ");
                    int decision = scn.nextInt();
                    scn.nextLine();
                    System.out.print("   [+] Enter the id of your Movie/TV-Show: ");
                    int moid = scn.nextInt();
                    scn.nextLine();
                    try{
                        if(decision==1){
                            me.addFav(db.allMovies.get(moid));
                            System.out.println("    -> Movie added to your favourites..!");
                        }
                        else if(decision==2){
                            me.addFav(db.allTVShows.get(moid));
                            System.out.println("    -> TV-Show added to your favourites..!");
                        }
                        else{
                            System.out.println("   * INVALID INPUT..!  *");
                        }
                    }
                    catch( Exception exception){
                        System.out.println("   Exception: " + exception);
                    }
                break;

                // Displaying all the Movies or TV-Shows from the Favourite list
                case 8:
                for(MovieObject movie: me.getFav()){
                    try{
                        display(me, movie);
                    }
                    catch( Exception exception){
                        System.out.println(exception);
                    }
                }                
                break;

                // COLLECTIONS CONCEPT
                // Adding Movie or TV-Show or Genere to the Watch Later list
                case 9:
                    System.out.print("   [+] Do u want to add 1. Movie 2.TV-Show 3.Genre: ");
                    int wl_decision = scn.nextInt();
                    scn.nextLine();
                    System.out.print("   [+] Enter the id of your Movie/TV-Show: ");
                    int wlid = scn.nextInt();
                    scn.nextLine();
                    try{
                        if(wl_decision==1){
                            me.addWatchLater(db.allMovies.get(wlid));
                            System.out.println("    -> Movie added to your Watch Later..!");
                        }
                        else if(wl_decision==2){
                            me.addWatchLater(db.allTVShows.get(wlid));
                            System.out.println("    -> TV-Show added to your Watch Later..!");
                        }
                        else if(wl_decision==3){
                            me.addWatchLater(db.allGenres.get(wlid));
                            System.out.println("    -> Genre added to your Watch Later..!");
                        }
                        else{
                            System.out.println("   * INVALID INPUT..!  *");
                        }
                    }
                    catch( Exception exception){
                        System.out.println("   Exception: " + exception);
                    }

                break;
                
                // Displaying all the Movies and TV-Shows and Genres from the Watch Later list
                case 10:
                for(Object item: me.getWatchLater()){
                    try{
                        System.out.print("    - ("+ item.getClass() +") ->  "+item);
                    }
                    catch( Exception exception){
                        System.out.println(exception);
                    }
                }
                break;
                    
                case 0:
                    System.out.println("----------------------- BYE BYE ------------------\n");
                break;

                default:
                    System.out.println("  Invalid Response..!");
            }

        }

    }
}