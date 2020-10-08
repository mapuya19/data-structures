package project2;

public class Meteorite implements Comparable<Meteorite> {
    private String name;
    private int id;
    private int mass;
    private int year;
    private Location location;

    public Meteorite(String name, int id) throws IllegalArgumentException {
        if (name == null || name.equals("") || id <= 0) {
            throw new IllegalArgumentException("Meteorite must have name and id must be an integer greater than zero.");
        } else {
            this.name = name;
            this.id = id;
        }
    }

    public void setMass(int mass) throws IllegalArgumentException {
        if (mass <= 0) {
            throw new IllegalArgumentException("Mass must be positive integer.");
        } else {
            this.mass = mass;
        }
    }

    public void setYear(int year) throws IllegalArgumentException {
        if (year <= 0 || year >= 2020) {
            throw new IllegalArgumentException("Year must be a positive integer less than the current year.");
        } else {
            this.year = year;
        }
    }

    public void setLocation(Location loc) throws IllegalArgumentException {
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

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Meteorite o) {
        if (o.name.equalsIgnoreCase(this.name) && (o.id == this.id)) {
            return 0;
        }

        if (this.name.equalsIgnoreCase(o.name)) {
            if (this.id < o.id) {
                return -1;
            } else {
                return 1;
            }
        }

        if (this.name.compareToIgnoreCase(o.name) < 0) {
            return -1;
        } else if (this.name.compareToIgnoreCase(o.name) > 0) {
            return 1;
        }

        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public boolean equals(Object o) {
        Meteorite meteorite = (Meteorite) o;

        String name1 = meteorite.name;
        String name2 = this.name;

        if (o == this) {
            return true; 
        }

        if (!(o instanceof Meteorite)) {
            return false;
        }

        if (name1.equalsIgnoreCase(name2) && meteorite.id == this.id) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        String year = Integer.toString(this.year);
        String id;
        int mass = this.mass;
        Double lat;
        Double lng;

        if (this.year == 0) {
            year = "";
        }

        id = Integer.toString(this.id);

        if (this.location == null) {
            String latEmpty = "";
            String lngEmpty = "";

            return String.format("%-20s %4s %4s %6s %10.5s %10.5s", this.name, id, year, mass, latEmpty, lngEmpty);
        } else {
            lat = this.location.getLatitude();
            lng = this.location.getLongitude();
        }

        if (this.mass == 0) {
            String massEmpty = "";

            return String.format("%-20s %4s %4s %6s %10.5f %10.5f", this.name, id, year, massEmpty, lat, lng);
        }

        return String.format("%-20s %4s %4s %6d %10.5f %10.5f", this.name, id, year, mass, lat, lng);
    }
}
