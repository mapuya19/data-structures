package project5;

import project2.MeteoriteLinkedList;

import java.util.Iterator;

public class MeteoriteData {
    BST<Meteorite> storage;

    public MeteoriteData() {
        storage = new BST<Meteorite>();
    }

    public boolean add(Meteorite m) {
        if (!storage.contains(m)) {
            storage.add(m);
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

    public MeteoriteData getByMass(int mass, int delta) {
        MeteoriteData massMatches = new MeteoriteData();
        Iterator<Meteorite> iterate = storage.iterator();

        if (mass < 0 || delta < 0) {
            throw new IllegalArgumentException("Mass must be a positive integer.");
        } else {
            while (iterate.hasNext()) {
                Meteorite temp = iterate.next();
                if (temp.getMass() >= mass - delta && temp.getMass() <= mass + delta && temp.getMass() != 0) {
                    massMatches.add(temp);
                }
            }

            if (massMatches.storage.isEmpty()) {
                return null;
            }
        }

        return massMatches;
    }

    // One Test Case
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

    // One Test Case
    public MeteoriteData getByYear(int year) {
        MeteoriteData yearMatches = new MeteoriteData();
        Iterator<Meteorite> iterate = storage.iterator();

        if (year <= 0 || year >= 2020) {
            throw new IllegalArgumentException("Year must be a positive integer less than the current year.");
        } else {
            while(iterate.hasNext()) {
                Meteorite temp = iterate.next();

                if (temp.getYear() == year) {
                    yearMatches.add(temp);
                }
            }

            if (yearMatches.storage.isEmpty()) {
                return null;
            }
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
}
