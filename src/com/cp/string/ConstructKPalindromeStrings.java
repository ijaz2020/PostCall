package com.cp.string;

public class ConstructKPalindromeStrings {
  public static void main(String[] args) {
    System.out.println(new ConstructKPalindromeStrings().canConstruct("yzyzyzyzyzyzyzy", 2));
  }

  public boolean canConstruct2(String s, int k) {
    int n = s.length();
    int[] charMap = new int[26];
    for(char c: s.toCharArray())
      charMap[c - 'a']++;

    int oddCount = 0, evenCount = 0;
    for(int i=0; i< 26; i++){
      if(charMap[i] % 2 == 1) oddCount++;
      else if(charMap[i] != 0 && charMap[i] % 2 == 0) evenCount++;
    }
    if(oddCount > k) return false;
    n -= oddCount;
    return n== 0 || evenCount >= k;
  }

  public boolean canConstruct(String s, int k) {
    int odd = 0, n = s.length(), count[] = new int[26];
    for (char c: s.toCharArray()) {
      count[c - 'a'] ^= 1;
      odd += count[c - 'a'] > 0 ? 1 : -1;
    }
    return odd <= k && k <= n;
  }
}
