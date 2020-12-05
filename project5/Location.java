package project5;

/**
 * This class represents a location that consists of a latitude and longitude.
 * @author Matthew Apuya
 * @version 10/08/2020
 */
public class Location {
    private final double lat;
    private final double lng;

    /**
     * Initializes location object.
     * @param latitude Latitude of the location.
     * @param longitude Longitude of the location.
     * @throws IllegalArgumentException if latitude is not [-90,90] inclusive or if longitude is not [-180,180] inclusive.
     */
    public Location(double latitude, double longitude) throws IllegalArgumentException {
        if (latitude < -90 || latitude > 90 || longitude < -180  || longitude > 180) {
            throw new IllegalArgumentException("Latitude must be [-90,90] inclusive and longitude must be [-180,180] inclusive");
        } else {
            this.lat = latitude;
            this.lng = longitude;
        }
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lng;
    }

    /**
     * Retrieve distance between two Location objects.
     * @author Wikipedia
     * @param loc Location to be compared to.
     * @return double representing the distance between two Locations.
     * @throws IllegalArgumentException if location is null.
     */
    public double getDistance(Location loc) throws IllegalArgumentException {
        if (loc == null) {
            throw new IllegalArgumentException("Location value null.");
        } else {
            double lat1 = this.lat;
            double lat2 = loc.lat;

            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(loc.lng - this.lng);

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

    /**
     * Checks if Location object is equal to another Location object based on the absolute value of the difference between
     * the two.
     * @param o Object to be compared to; typecast to Location
     * @return true if object shares pointer or is within abs() bounds, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        Location loc = (Location) o;

        if (o == null) {
            return false;
        }

        if (o == this || (loc.lat == this.lat && loc.lng == this.lng)) {
            return true; 
        }

        return Math.abs(loc.lat - this.lat) < 0.00001 && Math.abs(loc.lng - this.lng) < 0.0001;
    }
}