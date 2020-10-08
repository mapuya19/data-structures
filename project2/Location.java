package project2;

import java.lang.Math;

public class Location {
    private double lat;
    private double lng;

    public Location(double latitude, double longitude) throws IllegalArgumentException {
        if (latitude < -90 || latitude > 90 || longitude < -180  || longitude > 180) {
            throw new IllegalArgumentException("Latitude must be [-90,90] inclusive and longitude must be [-180,180] inclusive");
        } else {
            this.lat = latitude;
            this.lng = longitude;
        }
    }

    public double getDistance(Location loc) throws IllegalArgumentException {
        if (loc == null) {
            throw new IllegalArgumentException("Location value null.");
        } else {
            double lat1 = this.lat;
            double lng1 = this.lng;
            double lat2 = loc.lat;
            double lng2 = loc.lng;

            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lng2 - lng1);

            // convert to radians
            lat1 = Math.toRadians(lat1);
            lat2 = Math.toRadians(lat2);

            // apply formulae
            double a = Math.pow(Math.sin(dLat / 2), 2) +
                    Math.pow(Math.sin(dLon / 2), 2) *
                    Math.cos(lat1) *
                    Math.cos(lat2);

            double rad = 6371;
            double c = 2 * Math.asin(Math.sqrt(a));
    
            return rad * c;
        }
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lng;
    }

    @Override
    public boolean equals(Object o) {
        Location loc = (Location) o;

        if (o == this) { 
            return true; 
        }
        
        if (o == null) {
            return false; 
        }

        return Math.abs(loc.lat - this.lat) < 0.00001 && Math.abs(loc.lng - this.lng) < 0.0001;
    }
}