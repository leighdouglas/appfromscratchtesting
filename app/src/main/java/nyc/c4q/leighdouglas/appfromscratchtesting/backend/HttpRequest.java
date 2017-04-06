package nyc.c4q.leighdouglas.appfromscratchtesting.backend;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by leighdouglas on 4/5/17.
 */

public class HttpRequest {

    public HttpRequest(){

    }

    public String requestJSONString(String stringUrl) {
        String jsonString = "";
        try {
            URL url = new URL(stringUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream is = new BufferedInputStream(httpURLConnection.getInputStream());
            jsonString = convertToJsonString(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    private String convertToJsonString(InputStream is) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = "";
        try {
            while ((line = bf.readLine()) != null) {
                sb.append(line).append('\n');
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}



