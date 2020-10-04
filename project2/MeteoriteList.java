package project2;

import java.util.ArrayList;

public class MeteoriteList extends ArrayList<Meteorite>{

    public MeteoriteList() {
        MeteoriteList mainList = new MeteoriteList();
    }

    public Meteorite getByLocation (Location loc) throws IllegalArgumentException {
        if (loc == null) {
            throw new IllegalArgumentException("Invalid parameter.");
        }

        return null;
    }

    public MeteoriteLinkedList getByMass (int mass, int delta) {
        if (mass < 0 || delta < 0) {
            throw new IllegalArgumentException("Invalid parameter.");
        } else {

        }

        return null;
    }

    public MeteoriteLinkedList getByYear (int year) {

        return null;
    }
}
