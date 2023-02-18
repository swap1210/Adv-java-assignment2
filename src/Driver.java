import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        // String test = "Amore, Roma";
        // BufferedReader b = new BufferedReader(new FileReader("./f.txt"));
        // System.out.println(b.readLine());
        // String test2 = "A man, a plan, a canal: Panama";
        // System.out.println(Palindrone.perform(test2));
        Scanner scan = new Scanner(System.in);
        while (true) {
            String temp = "Welcome to Adv Java Assignment2:\n";
            temp += "Press 1 for Q1[isPalindrome]\n";
            temp += "Press 2 for Q2[goCaesar]\n";
            temp += "Press 3 for Q3[match-a-pattern]\n";
            temp += "Enter your choice:";
            System.out.print(temp);
            // String input = scan.nextLine();
            String input = "3";
            if (input.equalsIgnoreCase("1")) {
                System.out.print("Enter string to text if it's Palindrome: ");
                input = scan.nextLine();
                String res = Palindrome.perform(input) ? "Yes it's Palindrome" : "No it's not Palindrome";
                System.out.println(res);
            } else if (input.equalsIgnoreCase("2")) {
                System.out.print("Enter string/filename to ciphered: ");
                input = scan.nextLine();
                if (Palindrome.perform(input)) {
                    System.out.println("Yes it's Palindrome");
                } else {
                    System.out.println("No it's not Palindrome");
                }
            } else if (input.equalsIgnoreCase("3")) {

                System.out.print("Enter the name of the file: ");
                String fileName = System.console().readLine();

                // Prompt user for pattern to match
                System.out.print("Enter the pattern to match: ");
                String pattern = System.console().readLine(); // ignore case
                List<List<Integer>> res = MatchAPattern.perform(fileName, pattern);

                if (res.size() > 0) {
                    Iterator<List<Integer>> row = res.iterator();
                    while (row.hasNext()) {
                        List<Integer> item = row.next();
                        Iterator<Integer> itemItr = item.iterator();
                        String temp2 = "Match found at position $ on line $";
                        while (itemItr.hasNext()) {
                            String pos = itemItr.next().toString();
                            temp2.replace("$", pos);
                        }
                        System.out.println("\n");
                    }
                } else {
                    System.out.println("No matches found");
                }
            }
        }
    }
}