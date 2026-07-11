package practice;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class StringToBinary {
    public String[] converToBytes(String input) {
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        String[] binaryArray = new String[bytes.length];
        // if contains only digits 0 to 9
        if (input.matches("\\d+")) {
            BigInteger number = new BigInteger(input);
            /*
             * Formatting the bits to 8 length string and replacing ' ' space with 0
             * example for 5 the binary os 101 in sring '<5 spaces>101'
             * after replacing ' ' with '0' chars it will be '00000101'
             */
            String binary = String.format("%8s", number.toString(2)).replace(' ', '0');
            return new String[] { binary };
        } else {
            for (int i = 0; i < bytes.length; i++) {
                binaryArray[i] = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');
            }
            return binaryArray;
        }
    }

    public static void main(String[] args) {
        StringToBinary stringToBinary = new StringToBinary();
        String[] result = stringToBinary.converToBytes("Hello World");
        for (String stringByte : result) {
            System.out.println(stringByte);
        }
    }
}
