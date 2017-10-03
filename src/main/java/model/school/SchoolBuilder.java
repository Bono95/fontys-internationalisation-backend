package model.school;

import model.location.Location;

public class SchoolBuilder {

    private String name = "";
    private String street = "";
    private String houseNumber = "";
    private String city = "";
    private String country = "";
    private String email = "";
    private String phoneNumber = "";
    private String url = "";
    private Location location;

    public SchoolBuilder name(String name){
        this.name = name;
        return this;
    }

    public SchoolBuilder street(String street){
        this.street = street;
        return this;
    }

    public SchoolBuilder houseNumber(String houseNumber){
        this.houseNumber = houseNumber;
        return this;
    }

    public SchoolBuilder city(String city){
        this.city = city;
        return this;
    }

    public SchoolBuilder country(String country){
        this.country = country;
        return this;
    }

    public SchoolBuilder email (String email){
        this.email = email;
        return this;
    }

    public SchoolBuilder phoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SchoolBuilder url(String url){
        this.url = url;
        return this;
    }

    public SchoolBuilder location(Location location){
        this.location = location;
        return this;
    }

    public School build(){
        return new School(name,street,houseNumber,city,country,email,phoneNumber,url,location);
    }
}
