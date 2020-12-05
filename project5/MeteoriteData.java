package project5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MeteoriteData {
    BST<Meteorite> storage;
    BST<Meteorite> storageMassCompare;
    BST<Meteorite> storageYearCompare;

    public MeteoriteData() {
        storage = new BST<>();
        storageMassCompare = new BST<>(new compareByMass());
        storageYearCompare = new BST<>(new compareByYear());
    }

    public boolean add(Meteorite m) {
        if (!storage.contains(m)) {
            storage.add(m);
            storageMassCompare.add(m);
            storageYearCompare.add(m);
            return true;
        }

        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MeteoriteData)) {
            return false;
        }

        MeteoriteData compare = (MeteoriteData) obj;

        return this.storage.equals(compare.storage);
    }

    // Two Test Cases Failed(?) --> print correct, iterator test wrong
    public MeteoriteData getByMass(int mass, int delta) {
        if (mass < 0 || delta < 0) {
            throw new IllegalArgumentException("Mass must be a positive integer.");
        }

        if (storage.isEmpty()) {
            return null;
        }

        MeteoriteData massMatches = new MeteoriteData();

        Meteorite lowMeteorite = new Meteorite("LowerTest", 1337);
        Meteorite highMeteorite = new Meteorite("HigherTest", 1337);

        lowMeteorite.setMass(mass - delta);
        highMeteorite.setMass(mass + delta);

        ArrayList<Meteorite> massList = storageMassCompare.getRange(lowMeteorite, highMeteorite);
//        System.out.println(massList.toString());

        if (massList.size() == 0) {
            return null;
        }

        for (Meteorite meteorite : massList) {
            massMatches.add(meteorite);
        }

        return massMatches;
    }

    // One Test Case Failed
    public Meteorite getByLocation(Location loc) {
        if (loc == null) {
            throw new IllegalArgumentException("Location must not be null.");
        }

        if (storage.size() == 0) {
            return null;
        }

        Iterator<Meteorite> iterate = storage.iterator();
        double smallestDistance = 0;

        while (iterate.hasNext()) {
            if (iterate.next().getLocation() != null) {
                smallestDistance = loc.getDistance(iterate.next().getLocation());
                break;
            }
        }

        Meteorite nearest = new Meteorite("nearest", 1337);

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

    // No Test Cases Passed
    public MeteoriteData getByYear(int year) {
        if (year <= 0 || year >= 2020) {
            throw new IllegalArgumentException("Year must be a positive integer less than the current year.");
        }

        if (storage.isEmpty()) {
            return null;
        }

        MeteoriteData yearMatches = new MeteoriteData();
        Meteorite lowYear = new Meteorite("a", 1);
        Meteorite highYear = new Meteorite("Z", 999999);

        lowYear.setYear(year);
        highYear.setYear(year);

        ArrayList<Meteorite> yearList = storageYearCompare.getRange(lowYear, highYear);
        System.out.println(yearList.toString());

//        if (yearList.size() == 0) {
//            return null;
//        }

        for (Meteorite meteorite : yearList) {
            yearMatches.add(meteorite);
        }

        return yearMatches;
    }

    public Iterator<Meteorite> iterator() {
        return storage.iterator();
    }

    public boolean remove(Meteorite m) {
        if (storage.contains(m)) {
            storage.remove(m);
            return true;
        }

        return false;
    }

    private static class compareByMass implements Comparator<Meteorite> {
        @Override
        public int compare(Meteorite o1, Meteorite o2) {
            if (o1.getMass() == o2.getMass()) {
                return o1.compareTo(o2);
            }

            if (o1.getMass() < o2.getMass()) {
                return -1;
            }

            if (o1.getMass() > o2.getMass()) {
                return 1;
            }

            return 0;
        }
    }

    private static class compareByYear implements Comparator<Meteorite> {
        @Override
        public int compare(Meteorite o1, Meteorite o2) {
            if (o1.getYear() == o2.getYear()) {
                return o1.compareTo(o2);
            }

            if (o1.getYear() < o2.getYear()) {
                return -1;
            }

            if (o1.getYear() > o2.getYear()) {
                return 1;
            }

            return 0;
        }
    }
}
