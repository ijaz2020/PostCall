package com.cp;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
        public List<String> fizzBuzz(int n) {
            List<String> l = new ArrayList<>();
            String Fizz = "Fizz", Buzz = "Buzz";
            for( int i =1 ; i<=n;i++){
                if(i%3 == 0 && i%5 ==0) l.add(Fizz+Buzz);
                else if(i%3 ==0) l.add(Fizz);
                else if(i%5 ==0) l.add(Buzz);
                else l.add(String.valueOf(i));
            }

            return l;

        }
    }
