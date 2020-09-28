package api.entity.api;

import api.entity.api.matrix.CountryListApi;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetListCountry implements GetApi<CountryListApi> {
    private final String uri = "https://api.covid19api.com/countries";
    private CountryListApi[] list;
    private LocalDateTime time;

    public GetListCountry() {
        JsonMapper jsonMapper = new BuilderMapperApi().getCountryList();
        StreamReaderApi sr = new StreamReaderApi();
        try {
            list = jsonMapper
                    .readValue(sr.get(uri), CountryListApi[].class);
            time = LocalDateTime.now();
        } catch (IOException e) {
            e.printStackTrace();
            time = null;
        }
    }

    @Override
    public List<CountryListApi> getList() {
        return new ArrayList<>(Arrays.asList(list));
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }
}
