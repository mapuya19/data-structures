package project4;

/**
 * This class contains various methods for converting numbers written using different number systems:
 * binary, decimal, hexadecimal. The decimal numbers are represented using int type.
 * The binary and hexadecimal numbers are represented using binary and hexadecimal strings.
 * @author Matthew Apuya
 * @version 11/15/20
 */
public class Converter {
    // Wrapper Method for Binary to Decimal
    public static int binaryToDecimal(String binary) throws IllegalArgumentException, NumberFormatException {
        // Null check
        if (binary == null) {
            throw new IllegalArgumentException("Binary parameter is null");
        }

        // Prefix check
        if (binary.startsWith("0b")) {
            binary = binary.substring(2);
        } else {
            throw new NumberFormatException("Binary missing / has wrong prefix");
        }

        // Bit check
        if (binary.length() > 31) {
            throw new NumberFormatException("Binary parameter is invalid (too large)");
        }

        // Digits check
        if (!binary.matches("^[0-1]*$")) {
            throw new NumberFormatException("Binary parameter is invalid");
        }

        // Default Call
        return realBinToDec(binary,0);
    }

    // Recursive Method for Binary to Decimal
    private static int realBinToDec(String binary, int current) {
        // Base Case
        if (current == binary.length() - 1) {
            return binary.charAt(current) - '0';
        }

        // Recursive Call
        return ((binary.charAt(current) - '0') << (binary.length() - current - 1)) + realBinToDec(binary, current + 1);
    }

    // Wrapper Method for Binary to Hex
    public static String binaryToHex(String binary) throws IllegalArgumentException, NumberFormatException {
        // Null Check
        if (binary == null) {
            throw new IllegalArgumentException("Binary parameter is null");
        }

        // Prefix Check
        if (binary.startsWith("0b")) {
            binary = binary.substring(2);
        } else {
            throw new NumberFormatException("Binary missing / has wrong prefix");
        }

        // Bit Check
        if (binary.length() > 31) {
            throw new NumberFormatException("Parameter is too large");
        }

        // Digits Check
        if (!binary.matches("^[0-1]*$")) {
            throw new NumberFormatException("Parameter is invalid");
        }

        // Default Call
       return realBinToHex(binary);
    }

    // Recursive Method for Binary to Hex
    public static String realBinToHex(String binary) {
        // Base Case
        if (binary.length() == 0) {
            return "";
        }

        // Save length
        int counter = binary.length();

        // Pad zeroes to ensure valid binary for conversion
        if (binary.length() == 1) {
            binary = "000" + binary;
        } else if (binary.length() == 2) {
            binary = "00" + binary;
        } else if (binary.length() == 3) {
            binary = "0" + binary;
        }

        // Convert smaller to decimal
        String bits = binary.substring(binary.length() - 4);
        int decimal = (8 * (bits.charAt(0) - '0')) + (4 * (bits.charAt(1) - '0')) + (2 * (bits.charAt(2) - '0')) + (bits.charAt(3) - '0');

        // Convert to hex digit
        char hexDigit;
        if (decimal < 10) {
            hexDigit = (char)(decimal + '0');
        } else {
            hexDigit = (char)(decimal - 10 + 'A');
        }

        // Recursive conversion
        String substring = binary.substring(0, binary.length() - 4);
        if (counter < 6) {
            return "0x" + realBinToHex(substring) + hexDigit;
        } else {
            return realBinToHex(substring) + hexDigit;
        }
    }

    // Wrapper Method for Decimal to Binary
    public static String decimalToBinary(int decimal) {
        // Invalid decimal
        if (decimal < 0) {
            return null;
        }

        // Zero Case
        if (decimal == 0) {
            return "0b0";
        }

        // Default Call
        return realDecToBin(decimal);
    }

    // Recursive Method for Decimal to Binary
    public static String realDecToBin(int decimal) {
        // Base Case, append to front
        if (decimal == 0) {
            return "0b";
        }

        // Recursive conversion
        else {
            return realDecToBin(decimal / 2) + "" + (decimal % 2);
        }
    }

    // Wrapper Method for Decimal to Hex
    public static String decimalToHex(int decimal) {
        // Invalid decimal
        if (decimal < 0) {
            return null;
        }

        // Zero Case
        if (decimal == 0) {
            return "0x0";
        }

        // Default Call
        return realDecToHex(decimal);
    }

    // Recursive Method for Decimal to Hex
    public static String realDecToHex(int decimal) {
        StringBuilder hex = new StringBuilder();

        // Base Case
        if (decimal == 0) {
            return "0x";
        }

        // Recursive conversion
        String hexNumber = realDecToHex(decimal / 16);
        String key = "0123456789ABCDEF";
        int hexInt = decimal % 16;
        char hexToAdd = key.charAt(hexInt);

        hex.append(hexNumber).append(hexToAdd);

        return hex.toString();
    }

    // Wrapper Method for Hex to Bin
    public static String hexToBinary(String hex) throws IllegalArgumentException, NumberFormatException {
        // Null Check
        if (hex == null) {
            throw new IllegalArgumentException("hex is null");
        }

        // Length Check
        if (hex.length() > 10) {
            throw new NumberFormatException("Hex is too large");
        }

        // Prefix Check
        if (hex.startsWith("0x")) {
            hex = hex.substring(2);
        } else {
            throw new NumberFormatException("Hex missing / has wrong prefix");
        }

        // Character check
        if (!hex.matches("(^[0-9A-F]*$)")) {
            throw new NumberFormatException("Hex is invalid");
        }

        String finalHex = realHexToBin(hex);
        return "0b" + finalHex.replaceAll("^0+(?!$)", "");
    }

    // Recursive Method for Hex to Bin
    public static String realHexToBin(String hex) {
        // Base Case
        if (hex.length() == 0) {
            return "";
        }

        String[] key = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        int index;

        // Select binary value from key
        if (hex.charAt(0) >= '0' && hex.charAt(0) <= '9') {
            index = hex.charAt(0) - '0';
        } else {
            index = hex.charAt(0) - 'A' + 10;
        }

        // Recursive Call
        return key[index] + realHexToBin(hex.substring(1));
    }

    // Wrapper Method for Hex to Decimal
    public static int hexToDecimal(String hex) throws IllegalArgumentException, NumberFormatException, ArithmeticException {
        // Null check
        if (hex == null) {
            throw new IllegalArgumentException("hex is null");
        }

        // Length check
        if (hex.length() > 10) {
            throw new NumberFormatException("Hex is too large");
        }

        // Prefix check
        if (hex.startsWith("0x")) {
            hex = hex.substring(2);
        } else {
            throw new NumberFormatException("Hex missing / has wrong prefix");
        }

        // Character check
        if (!hex.matches("(^[0-9A-F]*$)")) {
            throw new NumberFormatException("Hex is invalid");
        }

        int hexLength = hex.length() - 1;
        int finalDec = realHexToDec(hex, hexLength);

        // Ensure valid hex
        if (finalDec < 0) {
            throw new ArithmeticException("Hex is too large");
        } else {
            return finalDec;
        }
    }

    // Recursive Method for Hex to Decimal
    public static int realHexToDec(String hex, int hexLength) {
        String key = "0123456789ABCDEF";
        hex = hex.toUpperCase();

        // Base Case
        if (hexLength < 0) {
            return 0;
        }

        int decAdd = key.indexOf(hex.charAt(hexLength));

        // Recursive Conversion
        return realHexToDec(hex, hexLength - 1) * 16 + decAdd;
    }
}
