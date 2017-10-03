package model.location;

public class LocationBuilder {

    private String latitude = "";

    private String longtitude = "";

    public LocationBuilder latitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public LocationBuilder longtitude(String longtitude) {
        this.longtitude = longtitude;
        return this;
    }

    public Location build() { return new Location(latitude, longtitude); }

}
