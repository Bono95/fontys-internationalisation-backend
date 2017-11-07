package model.location;

import model.Crudable;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class Location implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String latitude;
    private String longtitude;

    //TODO: add Picture

    public Location() {

    }

    Location(String latitude, String longtitude) {
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public boolean isIncomplete() {
        return latitude == null ||
                longtitude == null;
    }


    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (longtitude == null) list.add("firstName");
        if (latitude == null) list.add("lastName");

        return list;
    }

    //region Getters & Setters

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    //endregion

}
