package project2;
import java.util.ArrayList;

public class MeteoriteList extends ArrayList<Meteorite>{
    ArrayList<Meteorite> storage;

    public MeteoriteList() {
        this.storage = new ArrayList<Meteorite>();
    }

    public MeteoriteLinkedList getByMass(int mass, int delta) {
        MeteoriteLinkedList massMatches = new MeteoriteLinkedList();

        if (mass < 0 || delta < 0) {
            throw new IllegalArgumentException("Invalid parameter.");
        } else {
            for (Meteorite meteorite : this.storage) {
                if (meteorite.getMass() >= mass - delta || meteorite.getMass() <= mass + delta) {
                    massMatches.add(meteorite);
                }
            }
        }

        return massMatches;
    }

    public Meteorite getByLocation(Location loc) throws IllegalArgumentException {
        Meteorite nearest = new Meteorite("nearest", 1337);

        if (loc == null) {
            throw new IllegalArgumentException("Invalid parameter.");
        } else {
            for (Meteorite meteorite : storage) {
                if (meteorite.getLocation() == loc) {
                    nearest = meteorite;
                }
            }
        }

        return nearest;
    }

    public MeteoriteLinkedList getByYear(int year) {
        MeteoriteLinkedList yearMatches = new MeteoriteLinkedList();

        if (year < 0) {
            throw new IllegalArgumentException("Invalid parameter.");
        } else {
            for (Meteorite meteorite : this) {
                if (meteorite.getYear() == year) {
                    yearMatches.add(meteorite);
                }
            }
        }

        return yearMatches;
    }
}
