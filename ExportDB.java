import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// ExportDB thread
public class ExportDB implements Runnable  {
    public void run(){
        Database db = new Database();
        System.out.println("---------- WRITING DATA TO movies.txt ----------\n");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("movies.txt"))) {
            String fileContent="";
            for(Movie movie : db.allMovies )
            {
                fileContent += movie.toString();
            }
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            System.out.println("IO Exception..!\n");
        }
    }
}
