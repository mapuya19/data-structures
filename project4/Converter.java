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
        int start = 0;

        if (binary == null) {
            throw new IllegalArgumentException("binary is null");
        }

        if (binary.substring(0, 2).equals("0b") || binary.substring(0, 2).equals("0x")) {
            binary = binary.substring(2);
        }

        return realBinToDec(binary,0);
    }

    private static int realBinToDec(String binary, int current) {
        int n = binary.length();

        if (current == n-1) {
            return binary.charAt(current) - '0';
        }

        return ((binary.charAt(current) - '0') << (n - current - 1)) + realBinToDec(binary, current + 1);
    }

    public static String binaryToHex(String binary) {
        if (binary == null) {
            throw new IllegalArgumentException("binary is null");
        }

        String result = "";
        int remainder = n % 16;

        if (binary.length() == 0) {
            return "";
        } else {
            switch (remainder) {
                case 10:
                    result = "A";
                    break;
                case 11:
                    result = "B";
                    break;
                case 12:
                    result = "C";
                    break;
                case 13:
                    result = "D";
                    break;
                case 14:
                    result = "E";
                    break;
                case 15:
                    result = "F";
                    break;
                default:
                    result = remainder + result;
                    break;
            }
            return Hexa(Integer.toString(n / 16)) + result;
        }

        return "";
    }

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        } else {
            return (decimal % 2 + 10 * decimalToBinary(decimal / 2));
        }
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
