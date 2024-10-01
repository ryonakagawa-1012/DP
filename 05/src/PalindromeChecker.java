public class PalindromeChecker {
    void run(String[] args){
        for (String str: args){
            System.out.printf("%s: ", str);
            System.out.println(isPalindrome(str));
        }
    }

    Boolean isPalindrome(String str){
        if (str.length() <= 1){
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length()-1)) {
            return false;
        }


        return isPalindrome(str.substring(1, str.length()-1));
    }

    public static void main(String[] args){
        PalindromeChecker app = new PalindromeChecker();
        app.run(args);
    }
}
