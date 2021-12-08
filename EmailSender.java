import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EmailSender extends Thread{
    @Override
    public void run() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://email-sender1.p.rapidapi.com/?txt_msg=You%20are%20officially%20a%20lifetime%20MMDb%20member!%20Hope%20you%20find%20%20your%20movie%20from%20our%20Database.%20NEW%20FEATURE%3A%20Export%20our%20database%20as%20a%20txt%20file!&to=adwaitahegde%40gmail.com&from=MMDb&subject=Welcome%20to%20MMDb%20membership!"))
                .header("content-type", "application/json")
                .header("x-rapidapi-host", "email-sender1.p.rapidapi.com")
                .header("x-rapidapi-key", "KEY")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\r\n    \"key1\": \"value\",\r\n    \"key2\": \"value\"\r\n}"))
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}

}