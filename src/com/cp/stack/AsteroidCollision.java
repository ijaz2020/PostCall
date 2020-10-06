package com.cp.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] nums ={-2,1,-2,-2};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(nums)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty() && asteroid < 0)
                resList.add(asteroid);
            else if (asteroid > 0)
                stack.push(asteroid);
            else{
                int current = Math.abs(asteroid);
                while (!stack.isEmpty()) {
                    if(stack.peek() < current)
                        stack.pop();
                    else if(stack.peek() > current){
                        current =0;
                        break;
                    }
                    else{
                        stack.pop();
                        current =0;
                    }
                }
                if(current !=0) {
                    resList.add(asteroid);
                }
            }
        }
        resList.addAll(new ArrayList<>(stack));

        int[] result = new int[resList.size()];
        for(int i=0; i < resList.size();i++){
            result[i] = resList.get(i);
        }
        return result;
    }
}
