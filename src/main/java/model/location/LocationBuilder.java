package model.location;

public class LocationBuilder {

    private double latitude = 0;

    private double longtitude = 0;

    public LocationBuilder latitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public LocationBuilder longtitude(double longtitude) {
        this.longtitude = longtitude;
        return this;
    }

    public Location build() { return new Location(latitude, longtitude); }

}
