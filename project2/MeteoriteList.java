package project2;
import java.util.ArrayList;

/**
 * This class represents a list of Meteorites, inheriting from ArrayList.
 * @author Matthew Apuya
 * @version 10/08/2020
 */
public class MeteoriteList extends ArrayList<Meteorite>{
    ArrayList<Meteorite> storage;

    public MeteoriteList() {
        this.storage = new ArrayList<Meteorite>();
    }

    /**
     * Retrieves all Meteorites that have a mass within +/-10 of the given mass.
     * @param mass Mass to use as reference when searching.
     * @param delta Difference away from actual value to match;
     * @return List of all matches if any are found, null otherwise
     * @throws IllegalArgumentException if Mass or Delta is not a positive integer.
     */
    public MeteoriteLinkedList getByMass(int mass, int delta) throws IllegalArgumentException {
        MeteoriteLinkedList massMatches = new MeteoriteLinkedList();

        if (mass < 0 || delta < 0) {
            throw new IllegalArgumentException("Mass must be a positive integer.");
        } else {
            for (Meteorite meteorite : this) {
                if (meteorite.getMass() >= mass - delta && meteorite.getMass() <= mass + delta && meteorite.getMass() != 0) {
                    massMatches.add(meteorite);
                }
            }

            if (massMatches.head == null) {
                return null;
            }
        }

        return massMatches;
    }

    /**
     * Retrieves the Meteorite closest to the given location
     * @param loc Reference location to search for nearest.
     * @return The meteorite nearest to the location specified; return null if no location found.
     * @throws IllegalArgumentException if location passed in is null or there are currently no elements
     * in the MeteoriteList.
     */
    public Meteorite getByLocation(Location loc) throws IllegalArgumentException {
        if (loc == null) {
            throw new IllegalArgumentException("Location must not be null.");
        }

        if (this.size() == 0) {
            return null;
        }

        double smallestDistance = 0;

        for (Meteorite meteorite : this) {
            if (meteorite.getLocation() != null) {
                smallestDistance = loc.getDistance(meteorite.getLocation());
                break;
            }
        }

        Meteorite nearest = new Meteorite("nearest", 1337);

        for (Meteorite meteorite : this) {
            if (meteorite.getLocation().equals(loc)) {
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

    /**
     * Retrieves all Meteorites observed on a given year.
     * @param year The year to search for.
     * @return List of all matches by year if any are found, null otherwise
     * @throws IllegalArgumentException if no meteorites are found on a given year or if the year is not
     * a positive integer less than the current year.
     */
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
