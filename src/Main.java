import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by merri on 20/12/2016.
 */
public class Main {

    private final String api_url = "http://api.open-notify.org/astros.json";
    String data;

    public Main() {
        getData();
    }

    private void getData() {
        try {
            URL url = new URL(api_url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            data = reader.readLine();
            reader.close();
        } catch (MalformedURLException e) {
            System.out.println("URL Error.");
        } catch (IOException e) {
            System.out.println("Read error.");
        }
    }

    private void parseData(){
        JSONParser pasrser = JSONParser
    }

    public static void main(String[] args){
        Main m = new Main();
    }
}
