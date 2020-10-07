package project2;

public class Meteorite implements Comparable<Meteorite> {
    private String name;
    private int id;
    private int mass;
    private int year;
    private Location location;

    public Meteorite(String name, int id) throws IllegalArgumentException {
        if (name == null || id <= 0) {
            throw new IllegalArgumentException("Invalid parameter!");
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
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be a positive integer.");
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
        if (o.name.equalsIgnoreCase(this.name)) {
            if (o.id == this.id) {
                return 0;
            }
        }

        return o.name.toLowerCase().compareTo(this.name);
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
        String year;
        String mass;
        String lat;
        String lng;

        try {
            year = Integer.toString(this.year);
        } catch (Exception e) {
            year = "";
        }

        try {
            mass = Double.toString(this.mass);
        } catch (Exception e) {
            mass = "";
        }

        if (this.location == null) {
            lat = "";
            lng = "";
        } else {
            lat = Double.toString(this.location.getLatitude());
            lng = Double.toString(this.location.getLongitude());
        }

        return String.format("%s %d %s %s %s %s", this.name, this.id, year, mass, lat, lng);
    }
}
