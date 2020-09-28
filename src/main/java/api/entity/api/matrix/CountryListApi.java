package api.entity.api.matrix;

import api.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@ToString
@Entity
public class CountryListApi extends AbstractEntity {

    @JsonProperty("Country")
    @Getter
    @Setter
    private String name;

    @JsonProperty("Slug")
    @Getter
    @Setter
    private String slug;

    @JsonProperty("ISO2")
    @Getter
    @Setter
    private String is02;
}
