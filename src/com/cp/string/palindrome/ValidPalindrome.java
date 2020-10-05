package com.hotel.string.palindrome;

public class ValidPalindrome {
  public static void main(String[] args) {
    System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
  }

  public boolean isPalindrome(String s) {
    int l=0, r = s.length()-1;
    char[] chars = s.toCharArray();
    while(l < r){
      if(!Character.isLetterOrDigit(chars[l])) l++;
      else if(!Character.isLetterOrDigit(chars[r])) r--;
      else if(Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r]))
        return false;
      else{
        l++;
        r--;
      }
    }
    return true;
  }
  public boolean isPalindromeNOTWORKING(String s) {
    int l=0, r = s.length()-1;
    char[] chars = s.toCharArray();
    while(l < r){
      char i = getCharCode(chars[l]);
      char j = getCharCode(chars[r]);
      if( !(i >= 'a' && i<='z') && !(i >= '0' && i <='9') ) l++;
      else if( !(j >= 'a' && j<='z') && !(j >= '0' && j <='9')) r--;
      else if(i != j) return false;
      else {
        l++;
        r--;
      }
    }
    return true;
  }

  char getCharCode(char c){
    if(c >= 'A' && c <='Z' ){
      c = (char) (c - 'A' + 'a');
    }
    return c;
  }
}
