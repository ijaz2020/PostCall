package com.cp.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AwfulDiet {

    public static void main(String[] args) throws FileNotFoundException {
        AwfulDiet aw = new AwfulDiet();
        Scanner scan = new Scanner(new File("/Users/ijaza/code-base/PostCall/src/com/hotel/graph/AwfulDietTest.txt"));
        int mealCount = scan.nextInt();
        String[] mealOrderArray = new String[mealCount];
        int i=0;
        while (scan.hasNextLine())
            mealOrderArray[i++] = scan.next();

        System.out.println(aw.getDietOrder(mealOrderArray));
    }
    // 2
    // abd
    // bcd
    private String getDietOrder(String[] mealOrderArray){
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> mealInDegree = new HashMap<>();
        Set<Character> foodItems = new HashSet<>();
        Set<String> uniqueEdge = new HashSet<>();
        for(String s: mealOrderArray)
            for(char c: s.toCharArray())
                foodItems.add(c);
        int size = foodItems.size() * foodItems.size();
        Character[][] foodDependencies = new Character[size][size];
        int index = 0;
        for(String s : mealOrderArray)
            for(int i=0; i<s.length() -1; i++)
                for(int j=i+1; j <s.length(); j++) {
                    if(uniqueEdge.add(String.valueOf(s.charAt(i)) + s.charAt(j)))
                        foodDependencies[index++] = new Character[]{s.charAt(i), s.charAt(j)};
                }

        for(Character food: foodItems) mealInDegree.put(food, 0);
        for (Character[] foodDependency : foodDependencies)
            mealInDegree.put(foodDependency[1], mealInDegree.getOrDefault(foodDependency[1], 0) +1);

        Queue<Character> processedVertex = new LinkedList<>();
        for(Character food : mealInDegree.keySet())
            if(mealInDegree.get(food) == 0)
                processedVertex.offer(food);

        while (!processedVertex.isEmpty()){
            Character food = processedVertex.poll();
            sb.append(food);
            for(Character[] foodDependency : foodDependencies){
                if(food == foodDependency[0]){
                    mealInDegree.put(foodDependency[1], mealInDegree.get(foodDependency[1]) -1);
                    if(mealInDegree.get(foodDependency[1]) == 0){
                        processedVertex.offer(foodDependency[1]);
                    }
                }
            }
        }

        return sb.toString();
    }

}
