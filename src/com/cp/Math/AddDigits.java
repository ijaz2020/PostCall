package com.cp.Math;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AddDigits {

    public static void main(String arg[]){
        AddDigits a = new AddDigits();
        int mod = 1_000_000_007;
        System.out.println(a.addDigits(38));
    }

    public int addDigits(int num) {
        while(num > 9){
            Stream<Integer> s = String.valueOf(num).chars().mapToObj(c -> c);
            num = s.reduce(0, (a, b) -> {
                  return a - '0' + b - '0';
              }
            );
        }
        return num;
    }

    public int addDigits1(int num) {
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
