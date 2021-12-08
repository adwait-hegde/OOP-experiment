import java.util.*;

public class User extends AbsUser {

    //nested membership class
    private class Membership{
        private String expdate;
        private String type;
        private int points;
        Membership(String expdate, String type, int points){
            this.expdate = expdate;
            this.type=type;
            this.points=points;
        }
        public void membershipDetails(){
            System.out.println("Expdate: "+expdate);
            System.out.println("Type: "+ type);
            System.out.println("Points: "+points);
        }
    }

    private Membership membership;
    private Favourites <MovieObject> fav;
    private ArrayList watchLater;


    //parameterised constructors
    public User(String username, String password){
        super(username,password);
        fav = new Favourites<>();
        watchLater = new ArrayList();
    }

    public User(String username, String password, int age, String phone, String location){
        super(username, password, age, phone, location);
        watchLater = new ArrayList();
        fav = new Favourites<>();
    }

    public User(String username, String password, int age, String phone, String location, char gender){
        super(username, password, age, phone, location,gender);
        watchLater = new ArrayList();
        fav = new Favourites<>();
    }

    public void newMembership(String expdate, String type, int points){
        membership = new Membership(expdate, type, points);
        watchLater = new ArrayList();
        fav = new Favourites<>();
    }

    //print user details inherited from parent class
    public void print(){
        super.print();
        if (membership != null){
            membership.membershipDetails();
        }
    }

    //returns if user has membership 
    public boolean hasMembership(){
        return membership !=null;
    } 

    //adds new favourite movie or TVShow
    public void addFav(MovieObject movie){
        this.fav.add(movie);
    }

    //returns a list of favourite movie or TVShow
    public List<MovieObject> getFav(){
        return this.fav.get();
    }

    //getter for collecction
    public ArrayList getWatchLater(){
        return this.watchLater;
    }

    //setter for collection
    public void addWatchLater(Object item){
        this.watchLater.add(item);
    }
}
