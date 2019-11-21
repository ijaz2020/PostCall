package com.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradeStudents {

    public static void main(String arg[]){
        List<Integer> grades = new ArrayList<>();
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        System.out.println(Arrays.toString(gradingStudents(grades).toArray()));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        int i=0;
        for(Integer grade : grades){
            if(grade < 38){
                i++;
                continue;
            }

            int remainder = 5 - grade % 5;
            if(remainder < 3){
                grades.set(i, grade + remainder);
            }
            i++;
        }

        return grades;
    }
}
