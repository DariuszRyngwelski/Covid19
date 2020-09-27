package api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

@Entity
public class Covid19_CountryApiEntity extends AbstractEntity {
    @JsonProperty("Country")
    private String name;
    @JsonProperty("Slug")
    private String slug;
    @JsonProperty("ISO2")
    private String codeName;

}
