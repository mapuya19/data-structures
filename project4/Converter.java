package project4;

import java.text.NumberFormat;

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
