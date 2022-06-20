package com.palak;

public class StringPalindrome {

    /**
     * Using iterative approach. can't take capitalization. Bob is NOT palindrome.
     * @param input
     * @return
     */
    private boolean isPalindrome(String input) {
        boolean isPalindrome = true;
        int len = input.length();
        for(int i = 0; i<len/2 ; i++){
            if(input.charAt(i) != input.charAt(len - (i+1))){
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    /**
     * In this way, we can ignore capitalize. means Bob is palindrome.
     * @param input
     * @return
     */
    private boolean checkPalindromeUsingReversal(String input){
        String reversed = doReverse(input, "", input.length() - 1);
        return input.equalsIgnoreCase(reversed);
    }

    private String doReverse(String input, String reversed, int lastIndex) {
        if(lastIndex < 0){
            return reversed;
        }
        reversed = reversed + input.charAt(lastIndex);
        lastIndex--;
        return doReverse(input, reversed, lastIndex);
    }

    /*
     * By far, simplest reversal.
     */
    private boolean checkPalindromeUsingReversedSubString(String input) {
        String reversed = doReverseUsingSubString(input);
        return input.equalsIgnoreCase(reversed);
    }

    private String doReverseUsingSubString(String input) {
        if(input == null || input.isEmpty()) {
            return input;
        }

        return input.charAt(input.length()-1) + doReverseUsingSubString(input.substring(0,input.length()-1));
    }

    public static void main(String[] args) {
        StringPalindrome sp = new StringPalindrome();
        System.out.println("Palak palindrome? : " + sp.isPalindrome("palak"));
        System.out.println("ThissihT palindrome? : " + sp.isPalindrome("ThissihT"));
        System.out.println("Bob palindrome? : " + sp.isPalindrome("Bob"));

        System.out.println();
        System.out.println("Palak palindrome? : " + sp.checkPalindromeUsingReversal("palak"));
        System.out.println("ThissihT palindrome? : " + sp.checkPalindromeUsingReversal("ThissihT"));
        System.out.println("Bob palindrome? : " + sp.checkPalindromeUsingReversal("Bob"));

        System.out.println();
        System.out.println("Palak palindrome? : " + sp.checkPalindromeUsingReversedSubString("palak"));
        System.out.println("ThissihT palindrome? : " + sp.checkPalindromeUsingReversedSubString("ThissihT"));
        System.out.println("Bob palindrome? : " + sp.checkPalindromeUsingReversedSubString("Bob"));
    }
}
