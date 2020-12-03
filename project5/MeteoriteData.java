package project5;

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
        Iterator<Meteorite> iterate = storage.iterator();

        return null;
    }

    public Meteorite getByLocation(Location loc) {

        return null;
    }

    public MeteoriteData getByYear(int year) {

        return null;
    }

    public Iterator<Meteorite> iterator() {

        return null;
    }

    public boolean remove(Meteorite m) {
        if (storage.contains(m)) {
            storage.remove(m);
            return true;
        }

        return false;
    }
}
