package project5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * This class represents a collection of Meteorites, implemented using a Binary Search Tree.
 * @author Matthew Apuya
 * @version 12/6/2020
 */
public class MeteoriteData {
    BST<Meteorite> storage;
    BST<Meteorite> storageMassCompare;
    BST<Meteorite> storageYearCompare;

    /**
     * Constructor to initialize BSTs with comparators as needed
     */
    public MeteoriteData() {
        storage = new BST<>();
        storageMassCompare = new BST<>(new compareByMass());
        storageYearCompare = new BST<>(new compareByYear());
    }

    /**
     * Method for adding Meteorites to BST(s)
     * @param m Meteorite being added
     * @return true if Meteorite not already in BST
     * @throws NullPointerException if Meteorite passed is null
     */
    public boolean add(Meteorite m) throws NullPointerException{
        // Check if Meteorite being added is null
        if (m == null) {
            throw new NullPointerException("Meteorite passed is null");
        }

        // Check if BST already contains Meteorite
        if (!storage.contains(m)) {
            storage.add(m);
            storageMassCompare.add(m);
            storageYearCompare.add(m);
            return true;
        }

        return false;
    }

    /**
     * Method for comparing collections of Meteorites
     * @param obj MeteoriteData collection being compared
     * @return true if collection contain same elements, false otherwise
     */
    public boolean equals(Object obj) {
        // Make sure object being passed is an instance of MeteoriteData
        if (!(obj instanceof MeteoriteData)) {
            return false;
        }

        MeteoriteData compare = (MeteoriteData) obj;

        return this.storage.equals(compare.storage);
    }

    /**
     * Retrieves all Meteorites that have a mass within +/-10 of the given mass.
     * @param mass Mass to use as reference when searching.
     * @param delta Difference away from actual value to match;
     * @return List of all matches if any are found, null otherwise
     * @throws IllegalArgumentException if Mass or Delta is not a positive integer.
     */
    public MeteoriteData getByMass(int mass, int delta) throws IllegalArgumentException {
        // Check for valid mass and delta
        if (mass < 0 || delta < 0) {
            throw new IllegalArgumentException("Mass must be a positive integer.");
        }

        // Check if collection is empty
        if (storage.isEmpty()) {
            return null;
        }

        MeteoriteData massMatches = new MeteoriteData();

        // Dummy meteorites with lowest and highest mass
        Meteorite lowMeteorite = new Meteorite("a", 1);
        Meteorite highMeteorite = new Meteorite("Z", 999999);

        lowMeteorite.setMass(mass - delta);
        highMeteorite.setMass(mass + delta);

        // Retrieve meteorites with matches
        ArrayList<Meteorite> massList = storageMassCompare.getRange(lowMeteorite, highMeteorite);

        // Check if no matches found
        if (massList.size() == 0) {
            return null;
        }

        // Add matches to ArrayList
        for (Meteorite meteorite : massList) {
            massMatches.add(meteorite);
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
    public Meteorite getByLocation(Location loc) {
        // Check if location passed is null
        if (loc == null) {
            throw new IllegalArgumentException("Location must not be null.");
        }

        // Check if collection is empty
        if (storage.size() == 0) {
            return null;
        }

        double smallestDistance = 9999999;
        Meteorite nearest = new Meteorite("a", 999999);
        Iterator<Meteorite> iterate = storage.iterator();

        // Iterate through all Meteorites until nearest found
        while (iterate.hasNext()) {
            Meteorite temp = iterate.next();

            if (temp.getLocation().equals(loc)) {
                nearest = temp;
            } else {
                if (temp.getLocation() != null) {
                    double tempDistance = Math.abs(loc.getDistance(temp.getLocation()));

                    if (tempDistance < smallestDistance) {
                        nearest = temp;
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
    public MeteoriteData getByYear(int year) {
        // Check for valid year
        if (year <= 0 || year >= 2020) {
            throw new IllegalArgumentException("Year must be a positive integer less than the current year.");
        }

        // Check if collection is empty
        if (storage.isEmpty()) {
            return null;
        }

        // Dummy meteorites with lowest and highest natural ordering
        MeteoriteData yearMatches = new MeteoriteData();
        Meteorite lowYear = new Meteorite("a", 1);
        Meteorite highYear = new Meteorite("Z", 999999);

        lowYear.setYear(year);
        highYear.setYear(year);

        // Retrieve meteorites with matches
        ArrayList<Meteorite> yearList = storageYearCompare.getRange(lowYear, highYear);

        // Add matches to ArrayList
        for (Meteorite meteorite : yearList) {
            yearMatches.add(meteorite);
        }

        return yearMatches;
    }

    /**
     * Access iterator for BST object
     * @return iterator object of collection
     */
    public Iterator<Meteorite> iterator() {
        return storage.iterator();
    }

    /**
     * Method for removing Meteorite from collections
     * @param m Meteorite to be removed
     * @return true if Meteorite successfully removed, false otherwise
     * @throws NullPointerException if Meteorite passed is null
     */
    public boolean remove(Meteorite m) throws NullPointerException {
        // Check if Meteorite passed is null
        if (m == null) {
            throw new NullPointerException("Meteorite is null");
        }

        // Remove from all BSTs if Meteorite found in collection
        if (storage.contains(m)) {
            storage.remove(m);
            storageMassCompare.remove(m);
            storageYearCompare.remove(m);
            return true;
        }

        return false;
    }

    /**
     * Comparator for comparing Meteorites by Mass
     */
    private static class compareByMass implements Comparator<Meteorite> {
        @Override
        public int compare(Meteorite o1, Meteorite o2) {
            // Check if mass values are equal and use natural ordering if so
            if (o1.getMass() == o2.getMass()) {
                return o1.compareTo(o2);
            }

            // Check if o1 mass is less than o2 mass
            if (o1.getMass() < o2.getMass()) {
                return -1;
            }

            // Check if o1 mass is greater than o2 mass
            if (o1.getMass() > o2.getMass()) {
                return 1;
            }

            return 0;
        }
    }

    /**
     * Comparator for comparing Meteorites by year
     */
    private static class compareByYear implements Comparator<Meteorite> {
        @Override
        public int compare(Meteorite o1, Meteorite o2) {
            // Check if year values are equal and use natural ordering if so
            if (o1.getYear() == o2.getYear()) {
                return o1.compareTo(o2);
            }

            // Check if o1 year is less than o2 year
            if (o1.getYear() < o2.getYear()) {
                return -1;
            }

            // Check if o1 year is greater than o2 year
            if (o1.getYear() > o2.getYear()) {
                return 1;
            }

            return 0;
        }
    }

    /**
     * Method to Stringify collection
     * @return String representation of MeteoriteData
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        Iterator<Meteorite> iterate = iterator();

        // Iterate through Meteorites and attach their formatted String representations
        while(iterate.hasNext()){
            Meteorite temp = iterate.next();

            output.append(temp.toString()).append("\n");
        }

        return output.toString().trim();
    }
}
