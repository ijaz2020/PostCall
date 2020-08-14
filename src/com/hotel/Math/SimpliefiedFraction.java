package com.hotel.Math;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpliefiedFraction {
  public static void main(String[] args) {
    System.out.println(new SimpliefiedFraction().simplifiedFractions(13));
  }
/*["1/2","1/3","1/4","1/5","1/6","1/7","1/8","1/9","1/10","1/11","1/12","1/13","2/3","2/5","2/7","2/9","2/11","2/13","3/4","3/5","3/7","3/8","3/10","3/11","3/13","4/5","4/7","4/9","4/11","4/13","5/6","5/7","5/8","5/9","5/11","5/12","5/13","6/7","6/11","6/13","7/8","7/9","7/10","7/11","7/12","7/13","8/9","8/11","8/13","9/10","9/11","9/13","10/11","10/13","11/12","11/13","12/13"]*/
//["1/2","1/3","2/3","1/4","3/4","1/5","2/5","3/5","4/5","1/6","5/6","1/7","2/7","3/7","4/7","5/7","6/7","1/8","3/8","5/8","7/8","1/9","2/9","4/9","5/9","7/9","8/9","1/10","3/10","7/10","9/10","1/11","2/11","3/11","4/11","5/11","6/11","7/11","8/11","9/11","10/11","1/12","5/12","7/12","11/12","2/13","3/13","4/13","6/13","7/13","9/13","10/13","11/13"]
  public List<String> simplifiedFractions(int n) {
    List<String> res = new ArrayList<>();
    if(n == 1) return res;
    DecimalFormat df = new DecimalFormat("#.#####################");
    Set<String> nos = new HashSet<>();
    for(int i=2; i<=n; i++){
      for(int j=1; j<i; j++){
        float ans = (float)j/ (float)i;
        if(nos.add(df.format(ans))){
          res.add(j+"/"+i);
        }
      }
    }
    return res;
  }
}
