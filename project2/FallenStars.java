package project2;

public class FallenStars {
    public static void main(String[] args) {
        Location loc = new Location(10, 30);

        Meteorite test = new Meteorite("Test", 30);
        test.setMass(45);
        test.setLocation(loc);
        test.setYear(2020);

        System.out.println(test);
        System.out.println("Test complete!");

        MeteoriteList theList = new MeteoriteList();
//        theList.add(test);

//        System.out.println(theList.getByYear(2020));
    }
}
