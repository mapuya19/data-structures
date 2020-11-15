package project4;

/**
 * This class contains various methods for converting numbers written using different number systems:
 * binary, decimal, hexadecimal. The decimal numbers are represented using int type.
 * The binary and hexadecimal numbers are represented using binary and hexadecimal strings.
 * @author Matthew Apuya
 * @version 11/16/20
 */
public class Converter {
    // Finished (Class Tests)
    public static int binaryToDecimal(String binary) throws IllegalArgumentException, NumberFormatException {
        if (binary == null) {
            throw new IllegalArgumentException("Binary parameter is null");
        }

        if (binary.startsWith("0b") || binary.startsWith("0x")) {
            binary = binary.substring(2);
        }

        if (binary.length() > 31) {
            throw new NumberFormatException("Binary parameter is invalid (too large)");
        }

        if (!binary.matches("^[0-9]*$")) {
            throw new NumberFormatException("Binary parameter is invalid (not a numeric)");
        }

        return realBinToDec(binary,0);
    }

    private static int realBinToDec(String binary, int current) {
        int n = binary.length();

        if (current == n - 1) {
            return binary.charAt(current) - '0';
        }

        return ((binary.charAt(current) - '0') << (n - current - 1)) + realBinToDec(binary, current + 1);
    }

    // Finished (Class Tests)
    public static String binaryToHex(String binary) throws IllegalArgumentException, NumberFormatException {
        if (binary == null) {
            throw new IllegalArgumentException("Binary parameter is null");
        }

        // If empty string, return empty string
        if (binary.length() == 0) {
            return "";
        }

        // Ignore prefix
        if (binary.startsWith("0b") || binary.startsWith("0x")) {
            binary = binary.substring(2);
        }

        int counter = binary.length();

        if (binary.length() > 31) {
            throw new NumberFormatException("Parameter must be valid binary");
        }

        // Ensure that substring is valid
        if (!binary.matches("^[0-9]*$")) {
            throw new NumberFormatException("Parameter must be number");
        }

        // Ensure binary is at least length of 4
        if (binary.length() == 1) {
            binary = "000" + binary;
        } else if (binary.length() == 2) {
            binary = "00" + binary;
        } else if (binary.length() == 3) {
            binary = "0" + binary;
        }

        // Convert substring to decimal
        String bits = binary.substring(binary.length() - 4);
        int decimal = (8 * (bits.charAt(0) - '0')) + (4 * (bits.charAt(1) - '0')) + (2 * (bits.charAt(2) - '0')) + (bits.charAt(3) - '0');

        // Convert decimal to digit of hex
        char hexDigit;
        if (decimal < 10) {
            hexDigit = (char)(decimal + '0');
        } else {
            hexDigit = (char)(decimal - 10 + 'A');
        }

        String substring = binary.substring(0, binary.length() - 4);

        if (counter < 6) {
            return "0x" + binaryToHex(substring) + hexDigit;
        } else {
//            return binaryToHex(binary.substring(0,binary.length() - 4)) + "" + hexDigit;
            return binaryToHex(substring) + hexDigit;
        }
    }

    // Finished (Class Tests)
    public static String decimalToBinary(int decimal) {

        if (decimal == 0) {
            return "0b0";
        }

        if (decimal < 0) {
            return null;
        }

        else {
            return realDecToBin(decimal);
        }
    }

    public static String realDecToBin(int decimal) {
        if (decimal == 0) {
            return "0b";
        } else {
            return realDecToBin(decimal / 2) + "" + (decimal % 2);
        }
    }

    // Finished (Class Tests)
    public static String decimalToHex(int decimal) {
        StringBuilder hex = new StringBuilder();

        if (decimal < 0) {
            return null;
        }

        if (decimal == 0) {
            return "0x0";
        }

        return realDecToHex(decimal);
    }

    public static String realDecToHex(int decimal) {
        StringBuilder hex = new StringBuilder();

        if (decimal == 0) {
            return "0x";
        }

        String hexNumber = realDecToHex(decimal / 16);
        String hexCode = "0123456789ABCDEF";
        int hexInt = decimal % 16;
        char hexToAdd = hexCode.charAt(hexInt);

        hex.append(hexNumber).append(hexToAdd);

//        if (hex.length() == 3) {
//            return hex.toString() + 0;
//        }

        return hex.toString();
    }

    // Unfinished (Base Case)
    public static String hexToBinary(String hex) throws IllegalArgumentException, NumberFormatException {
        if (hex == null) {
            throw new IllegalArgumentException("hex is null");
        }

        if (hex.length() > 10) {
            throw new NumberFormatException("Hex is too large");
        }

        if (hex.startsWith("0b") || hex.startsWith("0x")) {
            hex = hex.substring(2);
        }

        if (!hex.matches("(^[0-9A-F]*$)")) {
            throw new NumberFormatException("Hex is invalid");
        }

        if (hex.length() == 0) {
            return "";
        }

        String[] hexValues = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};

        char ch = hex.charAt(0);

        int index;

        if (ch >= '0' && ch <= '9') {
            index = ch - '0';
        }

        else {
            index = ch - 'A' + 10;
        }

        return hexValues[index] + hexToBinary(hex.substring(1));
    }

    // Unfinished (ArithmeticException)
    public static int hexToDecimal(String hex) throws IllegalArgumentException, NumberFormatException, ArithmeticException {
        if (hex == null) {
            throw new IllegalArgumentException("hex is null");
        }

        if (hex.length() > 10) {
            throw new NumberFormatException("Hex is too large");
        }

        if (hex.startsWith("0b") || hex.startsWith("0x")) {
            hex = hex.substring(2);
        }

        if (!hex.matches("(^[0-9A-F]*$)")) {
            throw new NumberFormatException("Hex is invalid");
        }

        int hexLength = hex.length() - 1;

        return realHexToDec(hex, hexLength);
    }

    // Arithmetic Exception goes here?
    public static int realHexToDec(String hex, int hexLength) {
        String key = "0123456789ABCDEF";
        hex = hex.toUpperCase();

        if (hexLength < 0) {
            return 0;
        }

        char c = hex.charAt(hexLength);
        int d = key.indexOf(c);

        return realHexToDec(hex, hexLength - 1) * 16 + d;
    }
}
