package api.entity.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class BuilderMapperApi {
    public JsonMapper getCountryList() {
        return JsonMapper.builder()
                .configure(getFailOnUnknownProperties(), false)
                .build();
    }

    private DeserializationFeature getFailOnUnknownProperties() {
        return DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
    }
}
