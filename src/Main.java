import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by NotJamesM on 20/12/2016.
 */
public class Main {

    private final String api_url = "http://api.open-notify.org/astros.json";

    public Main() {
        parseData(getData());
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

    private String getData() {
        try {
            URL url = new URL(api_url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String data = reader.readLine();
            reader.close();
            return data;
        } catch (MalformedURLException e) {
            System.out.println("URL Error.");
        } catch (IOException e) {
            System.out.println("Read error.");
        }
        return null;
    }

    private JSONObject parseData(String data) {
        System.out.println(data);
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(data);
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (ParseException e) {
            System.out.println("Parse Error.");
        }
        return null;
    }
}
