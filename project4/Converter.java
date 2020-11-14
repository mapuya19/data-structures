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

        return 0;
    }

    public static String binaryToHex(String binary) {
        if (binary == null) {
            throw new IllegalArgumentException("binary is null");
        }

        return "";
    }

    public static String decimalToBinary(int decimal) {

        return "";
    }

    public static String decimalToHex(int decimal) {

        return "";
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
