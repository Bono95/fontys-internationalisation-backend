package model.location;

public class LocationBuilder {

    private int latitude = 0;

    private int longtitude = 0;

    public LocationBuilder latitude(int latitude) {
        this.latitude = latitude;
        return this;
    }

    public LocationBuilder longtitude(int longtitude) {
        this.longtitude = longtitude;
        return this;
    }

    public Location build() { return new Location(latitude, longtitude); }

}
