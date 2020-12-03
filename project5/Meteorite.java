package project5;

import project2.Location;

/**
 * This class represents a meteorite that consists of at least a name and a unique id,
 * @author Matthew Apuya
 * @version 10/08/2020
 */
public class Meteorite implements Comparable<Meteorite> {
    private final String name;
    private final int id;
    private int mass;
    private int year;
    private project2.Location location;

    /**
     * Instantiates the Meteorite object.
     * @param name Name of the meteorite.
     * @param id Unique ID of the meteorite.
     * @throws IllegalArgumentException if name is empty or id is an integer less than or equal zero.
     */
    public Meteorite(String name, int id) throws IllegalArgumentException {
        if (name == null || name.equals("") || id <= 0) {
            throw new IllegalArgumentException("Meteorite must have name and id must be an integer greater than zero.");
        } else {
            this.name = name;
            this.id = id;
        }
    }

    /**
     * Sets the mass of the Meteorite.
     * @param mass The mass of the Meteorite to be set.
     * @throws IllegalArgumentException if mass is less than or equal to zero.
     */
    public void setMass(int mass) throws IllegalArgumentException {
        if (mass <= 0) {
            throw new IllegalArgumentException("Mass must be positive integer.");
        } else {
            this.mass = mass;
        }
    }

    /**
     * Sets the year of the Meteorite.
     * @param year The year of the Meteorite to be set.
     * @throws IllegalArgumentException if year is less than or equal to zero or year is greater than or equal to the current year.
     */
    public void setYear(int year) throws IllegalArgumentException {
        if (year <= 0 || year >= 2020) {
            throw new IllegalArgumentException("Year must be a positive integer less than the current year.");
        } else {
            this.year = year;
        }
    }

    /**
     * Sets the location of the Meteorite.
     * @param loc The location of the Meteorite to be set.
     * @throws IllegalArgumentException if location is not valid.
     */
    public void setLocation(project2.Location loc) throws IllegalArgumentException {
        this.location = loc;
    }

    public int getMass() {
        return this.mass;
    }

    public int getYear() {
        return this.year;
    }

    public Location getLocation() {
        return this.location;
    }

    /**
     * Compares meteorites based on alphanumeric value of name and ID. If the names are the same, unique ID determines
     * output.
     * @param o Meteorite object that is being compared.
     * @return -1 if less than, 0 if equal, 1 if greater than the object being compared to.
     */
    @Override
    public int compareTo(Meteorite o) {
        // Check if Meteorites are same
        if (o.name.equalsIgnoreCase(this.name) && (o.id == this.id)) {
            return 0;
        }

        // Check unique ID if names are the same
        if (this.name.equalsIgnoreCase(o.name)) {
            if (this.id < o.id) {
                return -1;
            } else {
                return 1;
            }
        }

        // Compare based on alphanumeric value of name
        if (this.name.compareToIgnoreCase(o.name) < 0) {
            return -1;
        } else if (this.name.compareToIgnoreCase(o.name) > 0) {
            return 1;
        }

        return this.name.compareToIgnoreCase(o.name);
    }

    /**
     * Checks if Meteorite object is equal to another Meteorite object based on name and id.
     * @param o Meteorite object that is being compared; typecast to Meteorite;
     * @return true if Meteorite shares same name and id, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        Meteorite meteorite = (Meteorite) o;

        if (o == this) {
            return true; 
        }

        if (o == null) {
            return false;
        }

        return meteorite.name.equalsIgnoreCase(this.name) && meteorite.id == this.id;
    }

    /**
     * Converts Meteorite into formatted String.
     * @return A formatted string displaying each of the Meteorite's data fields. If a data field is empty, the string
     * displays blank.
     */
    @Override
    public String toString(){
        String year = Integer.toString(this.year);
        String id = Integer.toString(this.id);;
        int mass = this.mass;
        Double lat;
        Double lng;

        // If year is 0, display blank.
        if (this.year == 0) {
            year = "";
        }

        // If location is null, display blank and return formatted String. Otherwise, set latitude and longitude.
        if (this.location == null) {
            String latEmpty = "";
            String lngEmpty = "";

            return String.format("%-20s %4s %4s %6s %10.5s %10.5s", this.name, id, year, mass, latEmpty, lngEmpty);
        } else {
            lat = this.location.getLatitude();
            lng = this.location.getLongitude();
        }

        // If mass is 0, display blank and return formatted String.
        if (this.mass == 0) {
            String massEmpty = "";

            return String.format("%-20s %4s %4s %6s %10.5f %10.5f", this.name, id, year, massEmpty, lat, lng);
        }

        return String.format("%-20s %4s %4s %6d %10.5f %10.5f", this.name, id, year, mass, lat, lng);
    }
}
