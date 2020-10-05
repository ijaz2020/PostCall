package com.hotel.array;

public class MaxScore {
  public static void main(String[] args) {
    System.out.println(new MaxScore().maxScore("1100111111"));
  }

  public int maxScore(String s) {
    int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
    for(int i=0;i<s.length();i++) {
      if(s.charAt(i) == '0')
        zeros++;
      else
        ones++;
      if(i != s.length()-1)
        max = Math.max(zeros - ones, max);
    }
    return max + ones;
  }
  /*ArrayDeque<Character> aq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
    char c = s.charAt(i);
    if(aq.isEmpty()){
      aq.offer(c);
    }
    else{
      if(Character.isUpperCase(c) && Character.isLowerCase(aq.peek())){
        char tmp = aq.poll();
        aq.offer(c);
        aq.offer(tmp);
        aq.offer('*');
      }
      else if(Character.isDigit(c)){
        aq.offerFirst(c);
        aq.offerFirst('0');
      }
      else{
        aq.offer(c);
      }
    }
  }
  Iterator it = aq.iterator();
  StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
    sb.append(it.next());
  }
        return sb.toString();*/

  public int maxScore1(String s) {
    int n = s.length();
    if(n==2){
      if("00".equals(s)){
        return 1;
      }
      if("10".equals(s)){
        return 0;
      }
      if("01".equals(s)){
        return 2;
      }
      if("11".equals(s)){
        return 1;
      }
    }
    int[] dpl = new int[n], dpr = new int[n];
    int zero = 0, one = 0, res=0;
    for(int i=0; i<n; i++){
      dpl[i] = s.charAt(i) == '0' ? ++zero : zero;
    }
    for(int i=n-1; i >=0; i--){
      dpr[i] = s.charAt(i) == '1' ? ++one : one;
    }
    for(int i=1; i<n-1; i++){
      res = Math.max(res, Math.max(dpl[i-1] +dpr[i], dpl[i]+dpr[i+1]));
    }
    return res;
  }
}
