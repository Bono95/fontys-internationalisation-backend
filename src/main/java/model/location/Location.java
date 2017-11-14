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
    private int latitude;
    private int longitude;

    //TODO: add Picture

    public Location() {

    }

    Location(int latitude, int longtitude) {
        this.latitude = latitude;
        this.longitude = longtitude;
    }

    public boolean isIncomplete() {
        return latitude == 0 ||
                longitude == 0;
    }


    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (longitude == 0) list.add("firstName");
        if (latitude == 0) list.add("lastName");

        return list;
    }

    //region Getters & Setters

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    //endregion

}
