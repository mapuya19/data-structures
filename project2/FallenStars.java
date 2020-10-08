package project2;
import project1_1.Color;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FallenStars {
    public static void main(String[] args) {
        if (args.length == 0 ) {
            System.err.println("Usage Error: the program expects file name as an argument.\n");
            System.exit(1);
        }

        File csv = new File(args[0]);

        if (!csv.exists()){
            System.err.println("Error: the file " + csv.getAbsolutePath()+ " does not exist.\n");
            System.exit(1);
        }
        if (!csv.canRead()){
            System.err.println("Error: the file " + csv.getAbsolutePath()+
                    " cannot be opened for reading.\n");
            System.exit(1);
        }

        Scanner inCsv = null;

        try {
            inCsv = new Scanner(csv);
        } catch (FileNotFoundException e) {
            System.err.println("Error: the file " + csv.getAbsolutePath() +
                    " cannot be opened for reading.\n");
            System.exit(1);
        }

        MeteoriteList meteorites = new MeteoriteList();
        ArrayList<String> tempList = new ArrayList<String>();

        String line = null;

        // Skip First Line
        inCsv.nextLine();

        while (inCsv.hasNextLine()) {
            try {
                line = inCsv.nextLine();
                tempList = splitCSVLine(line);
            } catch (NoSuchElementException ex ) {
                //caused by an incomplete or miss-formatted line in the input file
                System.err.println(line);
                continue;
            }


            try {
                String tempName = tempList.get(0);
                int tempId = Integer.parseInt(tempList.get(1));

                Meteorite tempMeteorite = new Meteorite(tempName, tempId);

                try {
                    tempMeteorite.setMass(Integer.parseInt(tempList.get(4)));
                } catch (Exception e) {
                    //ignore this exception and skip to the next line
                }

                try {
                    tempMeteorite.setYear(Integer.parseInt(tempList.get(6).substring(6,10)));
                } catch (Exception e){
                    //ignore this exception and skip to the next line
                }

                try {
                    Location tempLocation = new Location(Double.parseDouble(tempList.get(7)), Double.parseDouble(tempList.get(8)));
                    tempMeteorite.setLocation(tempLocation);
                } catch (Exception e) {
                    //ignore this exception and skip to the next line
                }

                meteorites.add(tempMeteorite);
            } catch (IllegalArgumentException ex) {
                //ignore this exception and skip to the next line
            }
        }

        inCsv.close();

        System.out.print(
                "Search the database by using one of the following queries.\n" +
                "\t  To search for meteorite nearest to a given geo-location, enter\n" +
                "\t        location LATITUDE LONGITUDE\n" +
                "\t  To search for meteorites that fell in a given year, enter\n" +
                "\t        year YEAR\n" +
                "\t  To search for meteorites with weights MASS +/- 10 grams, enter\n" +
                "\t        mass MASS\n" +
                "\t  To finish the program, enter\n" +
                "\t        quit\n");

        Scanner userInput = new Scanner(System.in);
        String command;

        do {
            System.out.println("Enter your search query:");
            command = userInput.nextLine();

            if (!command.equalsIgnoreCase("quit")) {
                if (command.matches("\\b(location)\\b.*")) {
                    System.out.println("Location command!");
                } else if (command.matches("\\b(year)\\b.*")) {
                    String[] inputStrings = command.split(" ");
                    MeteoriteLinkedList yearOutput = meteorites.getByYear(Integer.parseInt(inputStrings[1]));

                    System.out.println(yearOutput.toString());
                } else if (command.matches("\\b(mass)\\b.*")) {
                    System.out.println("Mass command!");
                } else if (command.matches("\\b(quit)\\b.*")){
                    System.exit(0);
                } else {
                    System.out.println("This is not valid query. Please try again.");
                }
            }

        } while (!command.equalsIgnoreCase("quit"));
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
