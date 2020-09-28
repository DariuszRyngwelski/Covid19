package api.entity.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class StreamReaderApi {
    public InputStreamReader get(String uri) {
        URL url;
        try {
            url = new URL(uri);
            return new InputStreamReader(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
