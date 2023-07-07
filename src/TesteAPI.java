import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.Scanner;

public class TesteAPI {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);

            String usuario = s.next();
            String senha = s.next();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", usuario);
            jsonObject.put("password", senha);

            String login = "https://livraria-app.herokuapp.com/api/token/";
            HttpResponse<JsonNode> responselogin = Unirest.post(login)
                    .header("Content-Type", "application/json")
                    .body(jsonObject.toString())
                    .asJson();

            int status = responselogin.getStatus();
            JsonNode json = responselogin.getBody();

            System.out.println(status);
            System.out.println(json);


            /*String url = "https://livraria-app.herokuapp.com/api/livros/";

            HttpResponse<JsonNode> response = Unirest.get(url).header("Content-Type", "application/json").asJson();

            int status = response.getStatus();
            JsonNode json = response.getBody();

            System.out.println(status);
            System.out.println(json);*/

        }
        catch (UnirestException e) {

        }



    }
}
