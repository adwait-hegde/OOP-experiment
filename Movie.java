public class Movie extends MovieObject {
    private int duration;

    public Movie(String name, String category, String director, int year, int duration){
        super(name,category,director,year);
        this.duration = duration;
    }

    // Method overloading
    public String getData(int d){
        String res = super.getData(d);
        if (d==5)
            return String.valueOf(this.duration);
        return res;
    }

    public String getData(char d){
        String res = super.getData(d);
        if (d=='t')
            return String.valueOf(this.duration);
        return res;
    }

    //Method overloading
    public void print(){
        System.out.println("  "+this.name + " | " + this.category + " | " + this.director + " | " + this.year+ " | " + this.duration+ "\n");
    }

    public void print(int a){
        System.out.println("TVShow episoes: " + this.duration);
    }
}
