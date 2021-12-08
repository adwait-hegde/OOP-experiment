import java.util.*;

public class MovieObject {
    public String name;
    public String category;
    public String director;
    public int year;

    public MovieObject(){
        // System.out.println("--------- FROM MovieObject Class (Default Constructor) ---------\n");

        this.name = "Untitled movie";
        this.category = "A";
        this.director = "John Doe";
        this.year = Calendar.getInstance().get(Calendar.YEAR);
        // System.out.println("-------------- Data stored by Default Constructor --------------\n");        
    }

    private MovieObject(String name, String category){
        System.out.println("  Private Constructor called...!");
        this.name = name;
        this.category = category;
        this.director = "John Doe";
        this.year = Calendar.getInstance().get(Calendar.YEAR);
    }

    public MovieObject(String name, String category, int year){
        this(name, category);
        this.year = year;
        System.out.println("  Director name not provided. Setting it to John Doe...");
        // System.out.println("----------- Data stored by Parameterised Constructor ------------\n");
    }

    public MovieObject(String name, String category, String director){
        this(name, category);
        this.director = director;
        System.out.println("  Year not provided. Setting it to current year...");
        // System.out.println("----------- Data stored by Parameterised Constructor ------------\n");
    }

    public MovieObject(String name, String category, String director, int year){
        this.name = name;
        this.category = category;
        this.director = director;
        this.year = year;
    }

    public String getData(int d){
        if(d==1)
            return this.name;
        if(d==2)
            return this.category;
        if(d==3)
            return this.director;
        if(d==4)
            return String.valueOf(this.year);
        return "Invalid input";
    }

    public String getData(char d){
        if(d=='n')
            return this.name;
        if(d=='c')
            return this.category;
        if(d=='d')
            return this.director;
        if(d=='y')
            return String.valueOf(this.year);
        return "Invalid input";
    }

    public void print(){
        System.out.println("MovieObject:");
        System.out.println(this.name + " | " + this.category + " | " + this.director + " | " + this.year+ "\n\n");
    }

    // used to convert MovieObject to string
    public String toString(){
        return (this.name + " | " + this.category + " | " + this.director + " | " + this.year+ "\n\n");
    }
}
