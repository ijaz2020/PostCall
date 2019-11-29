package com.hotel;

import java.io.*;
import java.util.*;

public class RankCalculation implements Serializable {
    private static final long serialVersionUID = 1L;
    String id; String category; String gender; Double totalMark; Double interviewMark; Double theoryMark;
    public static void main(String[] ags) throws FileNotFoundException {
        File file =
                new File("/home/ijaz/code-base/PostCall/src/com/hotel/tes.txt");
        Scanner sc = new Scanner(file);
        List<RankCalculation> ranks = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] splitString =s.split(" ");
            if( (splitString.length ==7 || splitString.length == 8) && splitString[2].equals("BCM")  ){
                RankCalculation rankCalculation = new RankCalculation();
                rankCalculation.id = splitString[1];
                rankCalculation.category = splitString[2];
                rankCalculation.gender = splitString[3];
                rankCalculation.theoryMark = Double.parseDouble(splitString[4]);
                rankCalculation.interviewMark = Double.parseDouble(splitString[5]);
                rankCalculation.totalMark = Double.parseDouble(splitString[6]);
                ranks.add(rankCalculation);
            }
        }
        ranks.sort(COMPARATOR);
        writeFile(ranks);
    }
    private static final Comparator<RankCalculation> COMPARATOR = (c1, c2) -> c2.totalMark.compareTo(c1.totalMark);

    private static void writeFile(List<RankCalculation> rankCalculations){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("rankCalculation.txt"));
            for (RankCalculation club : rankCalculations)
                pw.println(club.id + " " + club.category + " " + club.gender + " " + club.totalMark + " " + club.theoryMark +
                        " " + club.interviewMark);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public String toString(){
        return this.id + " " + this.category + " " + this.gender + " " + this.totalMark + " " + this.theoryMark +
                " " + this.interviewMark;
    }
}
