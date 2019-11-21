package com.hotel;

public class AddDigits {

    public static void main(String arg[]){
        AddDigits a = new AddDigits();
        System.out.println(a.addDigits(38));
    }

    public int addDigits(int num) {
        int result = num;
        while (result > 9) {
            result = add(result);
        }
        return result;
    }

    private int add(int num) {
        int result = 0;
        while (num > 9) {
            result += num % 10;
            num = num / 10;
        }
        return result + num;
    }
}
