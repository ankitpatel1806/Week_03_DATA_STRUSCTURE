package stringbuilder.removingduplicate;
import java.util.Scanner;
public class DuplicateRemoverTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = sc.nextLine();
        String result = DuplicateRemover.removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("String without Duplicates: " + result);
    }
}
