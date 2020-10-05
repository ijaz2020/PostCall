package com.hotel.Math;

public class GCD {
    public static void main(String args[]){
        int[] a ={30,11,100,400,1000};
        System.out.println(new GCD().generalizedGCD(5, a));
    }

    public int generalizedGCD(int num, int[] arr)
    {
        int max = arr[0];
        for(int i=0; i<arr.length;i++)
            max= Math.max(max, arr[i]);
        boolean success= false;
        while(max-- > 0){
            for(int i: arr){
                if(i% max != 0) {
                    success = true;
                    break;
                }
            }
            if(!success) return max;
            else success=false;
        }
        return 1;
    }
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String result[] = new String[n];
        StringBuilder integerIndex= new StringBuilder();
        int index = 0;
        for(int i =0; i< logs.length;i++){
            int j = logs[i].indexOf(" ");
            if(Character.isDigit(logs[i].charAt(j+1))){
                integerIndex.append(i);
            }
            else result[index++] = logs[i];
        }

        for(char c: integerIndex.toString().toCharArray()){
            result[index++] = logs[Integer.parseInt(String.valueOf(c))];
        }
        return result;
    }

}
