import java.math.BigDecimal;
import java.util.*;
class SortBigDecimal{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, 0, n, Collections.reverseOrder( (s1, s2) ->{
                    BigDecimal a=  new BigDecimal(-100);
                    BigDecimal b = new BigDecimal(-100);
                    if(s1!=null)
                        a=  new BigDecimal(s1);
                    if(s2!=null)
                        b=  new BigDecimal(s2);
                    return a.compareTo(b);
                }
        ));
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}