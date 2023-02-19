import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // String test = "Amore, Roma";
        // BufferedReader b = new BufferedReader(new FileReader("./f.txt"));
        // System.out.println(b.readLine());
        // String test2 = "A man, a plan, a canal: Panama";
        // System.out.println(Palindrone.perform(test2));
        String[] applications = { "isPalindrome", "goCaesar", "match-a-pattern" };
        System.out.println("Welcome to Adv Java Assignment2:");
        String temp = "";
        for (int i = 0; i < applications.length; i++) {
            temp += "Press " + (i + 1) + " for Q" + (i + 1) + "[" + applications[i] + "]\n";
        }
        temp += "Enter your choice:";
        Scanner scan = new Scanner(System.in);
        while (!temp.isEmpty()) {
            System.out.print(temp);
            String input = scan.nextLine();
            // String input = "3";
            if (input.equalsIgnoreCase("1")) {
                System.out.print("Enter string to text if it's Palindrome: ");
                input = scan.nextLine();
                String res = Palindrome.perform(input) ? "Yes it's Palindrome" : "No it's not Palindrome";
                System.out.println(res);
            } else if (input.equalsIgnoreCase("2")) {
                System.out.print("Enter string/filename to ciphered: ");
                input = scan.nextLine();
                String messageText = "";
                BufferedReader bReader;
                try {
                    bReader = new BufferedReader(new FileReader(input));
                    String line = "";
                    while ((line = bReader.readLine()) != null) {
                        messageText += line + "\n";
                    }
                } catch (IOException e) {
                    System.out.println("Not a file but a text.");
                    messageText = input;
                }
                System.out.print("Enter Shift key to cipher: ");
                int userShiftKey = scan.nextInt();

                String encryptedStr = GoCaesar.encrypt(messageText, userShiftKey);
                System.out.println("Encrypted text: " + encryptedStr);
                System.out.println("Decrypted text: " + GoCaesar.decrypt(encryptedStr, userShiftKey));
            } else if (input.equalsIgnoreCase("3")) {

                System.out.print("Enter the name of the file: ");
                String fileName = scan.nextLine();

                // Prompt user for pattern to match
                System.out.print("Enter the pattern to match: ");
                String pattern = scan.nextLine(); // ignore case
                List<List<Integer>> res = MatchAPattern.perform(fileName, pattern);

                if (res.size() > 0) {
                    Iterator<List<Integer>> row = res.iterator();
                    while (row.hasNext()) {
                        List<Integer> item = row.next();
                        Iterator<Integer> itemItr = item.iterator();
                        String temp2 = "Match found at position x on line x";
                        while (itemItr.hasNext()) {
                            String pos = itemItr.next().toString();
                            // System.out.println("pos" + pos);
                            temp2 = temp2.replaceFirst("x", pos);
                        }
                        System.out.println(temp2);
                        temp2 += "Match found at position x on line x";
                    }
                    System.out.println();
                } else {
                    System.out.println("No matches found");
                }
            }
        }
        scan.close();
    }
}