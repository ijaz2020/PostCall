package com.cp.Math;

public class DayOfWeek {
    public static void main(String[] args){
        System.out.println(new DayOfWeek().dayOfTheWeek(2,3, 2020));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        int count =0;
        for(int i=1971; i<year;i++){
            if(i % 400 == 0 || i %100 !=0 && i % 4 ==0 )
                count+=366;
            else
                count+=365;
        }
        for(int i=1; i<month;i++){
            if(i==1 || i==3 || i==5|| i==7 || i==8 || i==10 || i ==12 )
                count+= 31;
            else if(i==2){
                count +=28;
                count += (year % 400 == 0 || year %100 !=0 && year % 4 ==0) ? 1 : 0;
            }
            else
                count+=30;
        }
        count+=day;
        String[] s = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        return s[(count)%7];
    }
}
