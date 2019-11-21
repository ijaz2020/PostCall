package com.hotel;

import java.io.*;
import java.util.*;
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int codeFromDB = scan.nextInt();
        try {
            System.out.println(EmpCode.getEnum(codeFromDB));
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        scan.close();
    }




    // complete the enum definition
    public enum EmpCode {

        ASSOCIATE(10001), SENIOR_ASSOCIATE(10002), MANAGER(10003), SENIOR_MANAGER(10004);

        private int code;
        private static Map<Integer, EmpCode> map = new HashMap<>();

        static {
            for (EmpCode empCode : EmpCode.values()) {
                map.put(empCode.code, empCode);
            }
        }

        EmpCode(int code) {
            this.code = code;
        }

        // also implement this method properly
        public static EmpCode getEnum(int code) {
            return map.get(code);
        }

    } // end of public enum EmpCode
}// end of public class Solution
