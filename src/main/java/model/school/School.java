package model.school;

import model.location.Location;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String street;
    private String houseNumber;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private String url;
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

    //region Getters & Setters

    //endregion
}
