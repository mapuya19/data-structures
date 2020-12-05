package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is where the package is run from, parsing a CSV file input and allowing for user interaction. The user
 * is able to: find the nearest Meteorite object given a pair Lat / Lng coordinates; find all Meteorites that
 * share a given mass within a 10 grams; as well as find all Meteorites observed within a given year.
 * @author Matthew Apuya
 * @version 10/082020
 */
public class FallenStars {
    public static void main(String[] args) {
        // Check that file is being passed in on runtime
        if (args.length == 0) {
            System.err.println("Usage Error: the program expects file name as an argument.\n");
            System.exit(1);
        }

        File csv = new File(args[0]);

        // Make sure that file is at specified file path.
        if (!csv.exists()) {
            System.err.println("Error: the file " + csv.getAbsolutePath() + " does not exist.\n");
            System.exit(1);
        }

        // Ensure that file is not corrupted or unreadable.
        if (!csv.canRead()) {
            System.err.println("Error: the file " + csv.getAbsolutePath() +
                    " cannot be opened for reading.\n");
            System.exit(1);
        }

        Scanner inCsv = null;

        // Attempt parsing; if fails, exception thrown.
        try {
            inCsv = new Scanner(csv);
        } catch (FileNotFoundException e) {
            System.err.println("Error: the file " + csv.getAbsolutePath() +
                    " cannot be opened for reading.\n");
            System.exit(1);
        }

        MeteoriteData meteorites = new MeteoriteData();
        ArrayList<String> tempList;

        String line = null;

        // Skip First Line
        inCsv.nextLine();

        // Iterate through all csv entries
        while (inCsv.hasNextLine()) {
            try {
                line = inCsv.nextLine();
                tempList = splitCSVLine(line);
            } catch (NoSuchElementException ex) {
                //caused by an incomplete or miss-formatted line in the input file
                System.err.println(line);
                continue;
            }

            // Attempt to set each data field for Meteorite; field is left blank is value is invalid
            try {
                String tempName = tempList.get(0);
                int tempId = Integer.parseInt(tempList.get(1));

                Meteorite tempMeteorite = new Meteorite(tempName, tempId);

                try {
                    tempMeteorite.setMass(Integer.parseInt(tempList.get(4)));
                } catch (IllegalArgumentException ex) {
                    //ignore this exception and skip to the next line
                }

                try {
                    if (!tempList.get(6).isEmpty()) {
                        tempMeteorite.setYear(Integer.parseInt(tempList.get(6).substring(6, 10)));
                    }
                } catch (IllegalArgumentException ex) {
                    //ignore this exception and skip to the next line
                }

                Location tempLocation = new Location(Double.parseDouble(tempList.get(7)), Double.parseDouble(tempList.get(8)));

                if (tempLocation == null) {
                    //skip
                } else {
                    tempMeteorite.setLocation(tempLocation);
                }

                meteorites.add(tempMeteorite);
            } catch (IllegalArgumentException ex) {
                //ignore this exception and skip to the next line
            }
        }

        // Close file scanner
        inCsv.close();

        // Begin user interface
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

        // Create scanner for user input
        Scanner userInput = new Scanner(System.in);
        String command;

        // Run until user enters "quit"
        do {
            System.out.println("Enter your search query:");
            command = userInput.nextLine();

            // Check that "quit" is not called
            if (!command.equalsIgnoreCase("quit")) {
                //Split userInput into Array using whitespace as the separation point
                String[] inputStrings = command.split("\\s+");

                // If user selects "year" and has valid parameters, String listing all Meteorites is printed
                if (inputStrings[0].equals("year") && inputStrings.length == 2) {
                    try {
                        MeteoriteData yearOutput = meteorites.getByYear(Integer.parseInt(inputStrings[1]));

                        if (yearOutput == null) {
                            System.out.println("Meteorite with matching year not found.");
                        } else {
                            System.out.println(yearOutput.toString());
                        }
                        System.out.println();
                    } catch (IllegalArgumentException ex) {
                        System.err.println("That is not a valid query. Please try again.");
                        System.out.println();
                    }
                }

                // If user selects "location" and has valid parameters, nearest meteorite is printed
                else if (inputStrings[0].equals("location") && inputStrings.length == 3) {
                    Location inputLoc = new Location(Double.parseDouble(inputStrings[1]), Double.parseDouble(inputStrings[2]));
                    Meteorite locationOutput = meteorites.getByLocation(inputLoc);

                    if (locationOutput == null) {
                        System.out.println("Meteorite not found.");
                    } else {
                        System.out.println(locationOutput.toString());
                    }
                    System.out.println();
                }

                // If user selects "mass" and has valid parameters, String listing all Meteorites with matching mass within 10 grams is printed
                else if (inputStrings[0].equals("mass") && inputStrings.length == 2) {
                    try {
                        MeteoriteData massOutput = meteorites.getByMass(Integer.parseInt(inputStrings[1]), 10);

                        if (massOutput == null) {
                            System.out.println("Meteorite with matching mass not found.");
                        } else {
                            System.out.println(massOutput.toString());
                        }
                        System.out.println();
                    } catch (IllegalArgumentException ex) {
                        System.err.println("That is not a valid query. Please try again.");
                        System.out.println();
                    }
                }

                // If user selects "quit", end the program
                else if (inputStrings[0].equals("quit")) {
                    System.exit(0);
                }

                // Any other user input displays this message and loop continues
                else {
                    System.err.println("That is not a valid query. Please try again.");
                    System.out.println();
                }
            }
        }
        while (!command.equalsIgnoreCase("quit"));
    }

    /**
     * Splits the given line of a CSV file according to commas and double quotes
     * (double quotes are used to surround multi-word entries so that they may contain commas)
     *
     * @param textLine a line of text from a CSV file to be parsed
     * @return an ArrayList object containing all individual entries found on that line;
     * any missing entries are indicated as empty strings; null is returned if the textline
     * passed to this function is null itself.
     * @author Joanna Klukowska
     */
    public static ArrayList<String> splitCSVLine(String textLine) {

        if (textLine == null) return null;

        ArrayList<String> entries = new ArrayList<String>();
        int lineLength = textLine.length();
        StringBuffer nextWord = new StringBuffer();
        char nextChar;
        boolean insideQuotes = false;
        boolean insideEntry = false;

        // iterate over all characters in the textLine
        for (int i = 0; i < lineLength; i++) {
            nextChar = textLine.charAt(i);

            // handle smart quotes as well as regular quotes
            if (nextChar == '"' || nextChar == '\u201C' || nextChar == '\u201D') {

                // change insideQuotes flag when nextChar is a quote
                if (insideQuotes) {
                    insideQuotes = false;
                    insideEntry = false;
                } else {
                    insideQuotes = true;
                    insideEntry = true;
                }
            } else if (Character.isWhitespace(nextChar)) {
                if (insideQuotes || insideEntry) {
                    // add it to the current entry
                    nextWord.append(nextChar);
                } else { // skip all spaces between entries
                    continue;
                }
            } else if (nextChar == ',') {
                if (insideQuotes) { // comma inside an entry
                    nextWord.append(nextChar);
                } else { // end of entry found
                    insideEntry = false;
                    entries.add(nextWord.toString());
                    nextWord = new StringBuffer();
                }
            } else {
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
