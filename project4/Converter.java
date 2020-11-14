package project4;

/**
 * This class contains various methods for converting numbers written using different number systems:
 * binary, decimal, hexadecimal. The decimal numbers are represented using int type.
 * The binary and hexadecimal numbers are represented using binary and hexadecimal strings.
 * @author Matthew Apuya
 * @version 11/16/20
 */
public class Converter {
    public static int binaryToDecimal(String binary) throws NumberFormatException {
        if (binary == null) {
            throw new IllegalArgumentException("binary is null");
        }

        if (binary.startsWith("0b") || binary.startsWith("0x")) {
            binary = binary.substring(2);
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

    public static String binaryToHex(String binary) {
        if (binary == null) {
            throw new IllegalArgumentException("Binary passed is null");
        }

        // If empty string, return empty string
        if (binary.length() == 0) {
            return "";
        }

        // Ignore prefix
        if (binary.startsWith("0b") || binary.startsWith("0x")) {
            binary = binary.substring(2);
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

//        return binaryToHex(binary.substring(0,binary.length() - 4)) + "" + hexDigit;
        return binaryToHex(binary.substring(0,binary.length() - 4)) + hexDigit;
    }

    public static String decimalToBinary(int decimal) {
        StringBuilder test = new StringBuilder();
        if (decimal == 0){
            return "";
        } else {
            return decimalToBinary(decimal / 2) + "" + (decimal % 2);
        }
    }

    public static String decimalToHex(int decimal) {
        StringBuilder hex = new StringBuilder();

        if (decimal > 0) {
            String hexNumber = decimalToHex(decimal / 16);
            String hexCode = "0123456789ABCDEF";
            int hexInt = decimal % 16;
            char hexToAdd = hexCode.charAt(hexInt);

            hex.append(hexNumber).append(hexToAdd);
        }

        return hex.toString();
    }

    public static String hexToBinary(String hex) throws NumberFormatException {
        if (hex == null) {
            throw new IllegalArgumentException("hex is null");
        }

        return "";
    }

    public static int hexToDecimal(String hex) throws NumberFormatException {

        return 0;
    }
}
