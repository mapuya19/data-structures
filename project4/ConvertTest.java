package project4;

public class ConvertTest {
    public static void main(String[] args) {
        String binary =  "0b11000111011";
        int decimal = Converter.binaryToDecimal(binary);
        System.out.println(decimal);

        String hex = Converter.decimalToHex(decimal);
        System.out.println(hex);

        String directBinary = Converter.decimalToBinary(1595);
        System.out.println(directBinary);

        String otherBinary = Converter.binaryToHex("0b11000111011");
        System.out.println(otherBinary);
    }
}
