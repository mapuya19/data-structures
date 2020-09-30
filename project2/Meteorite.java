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

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLocation(Location loc) {
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
        if (o.name.equals(this.name)) {
            if (o.id == o.id) {
                return 0;
            } else {
                return -1;
            }
        }
        
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        Meteorite meteorite = (Meteorite) o;

        String name1 = meteorite.name.toLowerCase();
        String name2 = this.name.toLowerCase();

        if (o == this) { 
            return true; 
        }
        
        if (!(o instanceof Meteorite)) { 
            return false; 
        } 
        
        if (name1.equals(name2) && meteorite.id == this.id) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        String info = String.format("%s %d %d %d %f %f", this.name, this.id, this.year, this.mass, this.location.getLatitude(), this.location.getLongitude());  

        return info;
    }
}
