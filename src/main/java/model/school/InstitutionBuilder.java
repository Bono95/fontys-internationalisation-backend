package model.school;

import model.location.Location;

public class InstitutionBuilder {

    private String name = "";
    private String street = "";
    private String houseNumber = "";
    private String city = "";
    private String country = "";
    private String email = "";
    private String phoneNumber = "";
    private String url = "";
    private Location location;

    public InstitutionBuilder name(String name){
        this.name = name;
        return this;
    }

    public InstitutionBuilder street(String street){
        this.street = street;
        return this;
    }

    public InstitutionBuilder houseNumber(String houseNumber){
        this.houseNumber = houseNumber;
        return this;
    }

    public InstitutionBuilder city(String city){
        this.city = city;
        return this;
    }

    public InstitutionBuilder country(String country){
        this.country = country;
        return this;
    }

    public InstitutionBuilder email (String email){
        this.email = email;
        return this;
    }

    public InstitutionBuilder phoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public InstitutionBuilder url(String url){
        this.url = url;
        return this;
    }

    public InstitutionBuilder location(Location location){
        this.location = location;
        return this;
    }

    public Institution build(){
        return new Institution(name,street,houseNumber,city,country,email,phoneNumber,url,location);
    }
}
