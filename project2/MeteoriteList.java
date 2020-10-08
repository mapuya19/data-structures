package project2;
import java.util.ArrayList;

public class MeteoriteList extends ArrayList<Meteorite>{
    ArrayList<Meteorite> storage;

    public MeteoriteList() {
        this.storage = new ArrayList<Meteorite>();
    }

    public MeteoriteLinkedList getByMass(int mass, int delta) throws IllegalArgumentException {
        MeteoriteLinkedList massMatches = new MeteoriteLinkedList();

        if (mass < 0 || delta < 0) {
            throw new IllegalArgumentException("Mass must be a positive integer.");
        } else {
            for (Meteorite meteorite : this) {
                if (meteorite.getMass() >= mass - delta && meteorite.getMass() <= mass + delta) {
                    massMatches.add(meteorite);
                }
            }

            if (massMatches.head == null) {
                return null;
            }
        }

        return massMatches;
    }

    public Meteorite getByLocation(Location loc) throws IllegalArgumentException {
        if (loc == null) {
            throw new IllegalArgumentException("Location is null.");
        }

        if (this.size() == 0) {
            return null;
        }

        Meteorite nearest = new Meteorite("nearest", 1337);
        double smallestDistance = loc.getDistance(this.get(0).getLocation());

        for (Meteorite meteorite : this) {
            if (meteorite.getLocation() == loc) {
                nearest = meteorite;
            } else {
                if (meteorite.getLocation() != null) {
                    double tempDistance = Math.abs(loc.getDistance(meteorite.getLocation()));

                    if (tempDistance < smallestDistance) {
                        nearest = meteorite;
                        smallestDistance = tempDistance;
                    }
                }
            }
        }

        return nearest;
    }

    public MeteoriteLinkedList getByYear(int year) throws IllegalArgumentException {
        MeteoriteLinkedList yearMatches = new MeteoriteLinkedList();

        if (year <= 0 || year >= 2020) {
            throw new IllegalArgumentException("Year must be a positive integer less than the current year.");
        } else {
            for (Meteorite meteorite : this) {
                if (meteorite.getYear() == year) {
                    yearMatches.add(meteorite);
                }
            }

            if (yearMatches.head == null) {
                return null;
            }
        }

        return yearMatches;
    }
}
