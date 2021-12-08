import java.util.*;

public class Favourites<T> {
    // List of objects of (T) MovieObject type 
    List<T> myfav;

    // Constructor to initialize the arraylist
    public Favourites(){
        this.myfav = new ArrayList<>();
    }

    // Add to the arraylist
    public void add(T obj1){
        this.myfav.add(obj1);
    }

    // returns the list
    public List get(){
        return this.myfav;
    }
}