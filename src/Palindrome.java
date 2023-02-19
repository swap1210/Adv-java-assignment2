public class Palindrome {
    static boolean perform(String p_text) {
        int left = 0;
        int right = p_text.length() - 1;

        while (left < right || left != right) {
            // System.out.println(p_text.charAt(left) + "=" + p_text.charAt(right));
            // System.out.println((left) + "=" + (right));
            if (!isChar(p_text.charAt(left))) {
                left++;
                continue;
            }

            if (!isChar(p_text.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(p_text.charAt(left)) == Character.toLowerCase(p_text.charAt(right))) {
                left++;
                right--;
            } else {
                break;
            }
        }

        return left == right || Math.abs((left - right)) == 1;
    }

    static boolean isChar(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }
}
