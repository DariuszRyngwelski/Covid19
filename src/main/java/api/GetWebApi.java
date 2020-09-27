package api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class GetWebApi<T> {
    private final List<List<T>> list;

    public GetWebApi(String uri) {
        list = Collections.singletonList(getApiToList(uri, getBuildMapper()));
    }

    private JsonMapper getBuildMapper() {
        return JsonMapper.builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build();
    }

    private List<T> getApiToList(String uri, ObjectMapper mapper) {
        try {
            return mapper.readValue(
                    new URL(uri),
                    new TypeReference<>() {
                    }
            );
        } catch (IOException ignore) {
        }
        return null;
    }

    public List<T> getListCoin() {
        return list.get(0);
    }
}
