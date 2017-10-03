package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public interface Crudable {

    @JsonIgnore
    boolean isIncomplete();

    @JsonIgnore
    List<String> getIncompleteProperties();
}
