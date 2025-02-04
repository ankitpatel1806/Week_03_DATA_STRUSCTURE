package linearsearch.findspecificword;
import java.util.*;
public class FindSpecificWordTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        System.out.print("Enter the word to search for: ");
        String wordToSearch = sc.nextLine();

        String result = FindSpecificWord.findSpecificWord(sentences, wordToSearch);
        System.out.println("Result: " + result);
        sc.close();
    }
}
