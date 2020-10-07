package project2;
import java.util.Scanner;
import java.util.ArrayList;

public class FallenStars {
    public static void main(String[] args) {
//        Location loc = new Location(10, 30);
//
//        Meteorite test = new Meteorite("Test", 30);
//        test.setMass(45);
//        test.setLocation(loc);
//        test.setYear(2020);
//
//        System.out.println(test);
//        System.out.println("Test complete!");
//
//        MeteoriteLinkedList theList = new MeteoriteLinkedList();
//        theList.add(test);
//
//        System.out.println(theList);
    }

    /**
     * Splits the given line of a CSV file according to commas and double quotes
     * (double quotes are used to surround multi-word entries so that they may contain commas)
     * @author Joanna Klukowska
     * @param textLine  a line of text from a CSV file to be parsed
     * @return an ArrayList object containing all individual entries found on that line;
     *  any missing entries are indicated as empty strings; null is returned if the textline
     *  passed to this function is null itself.
     */
    public static ArrayList<String> splitCSVLine(String textLine){

        if (textLine == null ) return null;

        ArrayList<String> entries = new ArrayList<String>();
        int lineLength = textLine.length();
        StringBuffer nextWord = new StringBuffer();
        char nextChar;
        boolean insideQuotes = false;
        boolean insideEntry= false;

        // iterate over all characters in the textLine
        for (int i = 0; i < lineLength; i++) {
            nextChar = textLine.charAt(i);

            // handle smart quotes as well as regular quotes
            if (nextChar == '"' || nextChar == '\u201C' || nextChar =='\u201D') {

                // change insideQuotes flag when nextChar is a quote
                if (insideQuotes) {
                    insideQuotes = false;
                    insideEntry = false;
                }
                else {
                    insideQuotes = true;
                    insideEntry = true;
                }
            }
            else if (Character.isWhitespace(nextChar)) {
                if ( insideQuotes || insideEntry ) {
                    // add it to the current entry
                    nextWord.append( nextChar );
                }
                else { // skip all spaces between entries
                    continue;
                }
            }
            else if ( nextChar == ',') {
                if (insideQuotes){ // comma inside an entry
                    nextWord.append(nextChar);
                }
                else { // end of entry found
                    insideEntry = false;
                    entries.add(nextWord.toString());
                    nextWord = new StringBuffer();
                }
            }
            else {
                // add all other characters to the nextWord
                nextWord.append(nextChar);
                insideEntry = true;
            }

        }
        // add the last word ( assuming not empty )
        // trim the white space before adding to the list
        if (!nextWord.toString().equals("")) {
            entries.add(nextWord.toString().trim());
        }

        return entries;
    }
}
