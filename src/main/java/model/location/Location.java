package model.location;

public class Location {

    private String latitude;
    private String longtitude;

    public Location() {

    }

    Location(String latitude, String longtitude) {
        this.latitude = latitude;
        this.longtitude = longtitude;
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
