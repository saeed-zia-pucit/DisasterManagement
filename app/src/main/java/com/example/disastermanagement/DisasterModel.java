package com.example.disastermanagement;

public class DisasterModel {
    double lat,lon,mag;

    public DisasterModel(double lat, double lon, double mag, int los) {
        this.lat = lat;
        this.lon = lon;
        this.mag = mag;
        this.los = los;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public int getLos() {
        return los;
    }

    public void setLos(int los) {
        this.los = los;
    }

    int los;
}
