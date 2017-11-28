package model.school;

import model.Crudable;
import model.location.Location;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class School implements Crudable {
    //TODO: change school to institution.


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String street;
    private String houseNumber;
    private String city;
    private String country;
    //TODO: add ZipCode
    //TODO: add Picture
    private boolean isActive = true;
    private String email;
    private String phoneNumber;
    private String url;
    @OneToOne(targetEntity = Location.class, fetch = FetchType.EAGER, cascade ={CascadeType.ALL})
    private Location location;

    public School() {
    }

    School(String name, String street, String houseNumber, String city, String country, String email, String phoneNumber, String url, Location location) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.url = url;
        this.location = location;
    }

    public boolean isIncomplete() {
        return name == null ||
                street == null ||
                houseNumber == null ||
                city == null ||
                country == null ||
                email == null ||
                phoneNumber == null ||
                url == null ||
                location == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (name == null) list.add("firstName");
        if (street == null) list.add("lastName");
        if (houseNumber == null) list.add("houseNumber");
        if (city == null) list.add("city");
        if (country == null) list.add("country");
        if (email == null) list.add("email");
        if (phoneNumber == null) list.add("password");
        if (url == null) list.add("url");
        if (location == null) list.add("location");


        return list;
    }

    //region Getters & Setters


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    //endregion
}
