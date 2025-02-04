package stringbuilder.reverserstring;

import java.util.Scanner;
public class StringReverseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to reverse: ");
        String input = sc.nextLine();
        String reversedString = StringReverser.reverseString(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversedString);
    }
}