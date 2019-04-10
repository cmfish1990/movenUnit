

package wk.cityhome.dowork.excel;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownTest {
    public static void main(String[] args) {
        try {
            String urlStr = "http://p.hantinghotels.com/f/f/xvwfjo.jpg";
            URL url;
            url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream inputStream = urlConnection.getInputStream();
            System.out.print(inputStream.available());
        }catch (Exception e){

        }
    }
}
