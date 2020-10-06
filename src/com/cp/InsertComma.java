package com.cp;

public class InsertComma {

    public static void main(String[] args) {
        int noOfCommas = 3;
        String number = "456809";
        int max = 0;
        int j;

        for(int i=0;i<=number.length()-noOfCommas;i++){
            int index = i;
            if(index >0 && max < Integer.parseInt(number.substring(0,index))){
                max = Integer.parseInt(number.substring(0,index));
            }
            for(j=0;j<noOfCommas;j++){
                if(max < Integer.parseInt(number.substring(index,index+1))){
                    max = Integer.parseInt(number.substring(index,index+1));
                }
                index+=1;
            }
            if( index < number.length()-1 && max < Integer.parseInt(number.substring(index,number.length()))){
                max = Integer.parseInt(number.substring(index,number.length()));
            }
        }

        System.out.println(max);

    }

}