package stringbuffer.concanatestring;
import java.util.Scanner;
public class StringConcatenatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of strings you want to concatenate: ");
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string for element " + (i + 1) + ": ");
            str[i] = sc.nextLine();
        }
        StringConcatenator scc = new StringConcatenator();
        System.out.println("The concatenated string is: "+scc.concatenateStrings(str));

    }

}
