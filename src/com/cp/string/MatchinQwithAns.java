package com.cp.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatchinQwithAns {

  public static void main(String[] args) {
    String initialString = "Ecuador , officially the Republic of Ecuador, is a representative democratic republic in northwestern South America, bordered by Colombia on the north, Peru on the east and south, and the Pacific Ocean to the west. Ecuador also includes the GalÃ¡pagos Islands in the Pacific, about 1,000 kilometres (620 mi) west of the mainland. The main spoken language in Ecuador is Spanish (94% of the population). Languages of official use in native communities include Quichua, Shuar, and eleven other languages. Ecuador has a land area of 283,520 km2. Its capital city is Quito, which was declared a World Heritage Site by UNESCO in the 1970s for having the best preserved and least altered historic center in Latin America. The country's largest city is Guayaquil. The historic center of Cuenca, the third-largest city in the country in size and economically, was also declared a World Heritage Site in 1999 as an outstanding example of a planned, inland Spanish-style colonial city in the Americas. Ecuador is home to a great variety of species, many of them endemic, such as those of the GalÃ¡pagos Islands. This species diversity makes Ecuador one of the seventeen megadiverse countries in the world, it is considered the most biodiverse country in the world per unit area. The new constitution of 2008 is the first in the world to recognize legally enforceable Rights of Nature, or ecosystem rights.\n" +
      "Which country borders Ecuador on the north?\n" +
      "Which country borders Ecuador on the east and south?\n" +
      "What borders Ecuador to the west?\n" +
      "What is the main spoken language in Ecuador?\n" +
      "What is the capital city of Ecuador?\n" +
      "Pacific Ocean;Spanish;Quito;Colombia;Peru";
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner inp = new Scanner(new ByteArrayInputStream(initialString.getBytes()));

    String paragraph = inp.nextLine();
    ArrayList<String> questions = new ArrayList<String>();

    for(int i = 0; i < 5; i++)
      questions.add(inp.nextLine());

    String answersLine = inp.nextLine();
    String[] ans = answersLine.split(";");
    //   System.out.println(answersLine);
    ArrayList<String> answers = new ArrayList<String>();
    for(int i = 0; i < ans.length; i++)
      answers.add(ans[i]);

    String[] result = byQuestions(paragraph, questions, answers);
    for(String r : result)
      System.out.println(r);
  }

  static String[] byQuestions(String paragraph, ArrayList<String> questions, ArrayList<String> answers){
    String[] result = new String[questions.size()];
    String[] sentences = paragraph.split("[.]");
    ArrayList<String> doubts = new ArrayList<>();
    for (String sentence : sentences) {
      for (String answer : answers)
        if (sentence.toLowerCase().contains(answer.toLowerCase())) {
          doubts.add(sentence.toLowerCase());
          break;
        }
    }
    //   System.out.println(doubts.size());
    String[] keywords;
    String temp;
    for(int i = 0; i < questions.size(); i++){
      keywords = findKeywords(questions.get(i));
      int t = findBestMatch(doubts, keywords);

      temp = " ";
      //      System.out.println(doubts.get(t));
      for(String answer : answers){
        if(doubts.get(t).contains(answer.toLowerCase()) && answer.length() > temp.length())
          temp = answer;
      }

      result[i] = temp;
    }

    return result;
  }

  static int findBestMatch(ArrayList<String> doubts, String[] keywords){
    int max = 0, index = 0, temp;
    //      System.out.println(questions.size() + " " + keywords.length);
    for(int i = 0; i < doubts.size(); i++){
      temp = 0;
      for(int j = 0; j < keywords.length; j++ ){
        if(doubts.get(i).contains(keywords[j])){
          if(keywords[j].contains("\""))
            temp+=2;
          temp++;
        }
      }

      if(temp > max){
        max = temp;
        index = i;
      }
    }

    return index;
  }

  static String[] findKeywords(String text){
    if(text == null )
      return null;
    boolean tempB;

    String[] keywords = text.split(" ");
    ArrayList<String> k = new ArrayList<String>();
    String[] commonWords = {"which", "what", "where", "who", "when", "is", "are", "was", "were", "have", "had", "do", "did", "how", "why", "will", "shall", "the", ".", "?", "a"};

    for(String keyword : keywords){
      keyword = keyword.replace("?", "");
      tempB = false;
      for(String commonWord : commonWords)
        if(commonWord.equalsIgnoreCase(keyword)){
          tempB = true;
          break;
        }
      if(tempB)
        continue;

      if(keyword.endsWith("ed"))
        keyword = keyword.substring(0, keyword.length() - 2);

      if(keyword.endsWith("s"))
        keyword = keyword.substring(0, keyword.length() - 1);

      k.add(keyword.toLowerCase());
      //        System.out.println(keyword);
    }

    return k.toArray(new String[k.size()]);
  }

  static String findSentenceByPiece(String text, String piece){
    int pieceIndex = text.indexOf(piece);
    if(pieceIndex == -1)
      return null;

    int begin = pieceIndex, end;

    while(text.charAt(begin) != '.' && begin > 0)
      begin--;

    end = text.indexOf(".", pieceIndex + piece.length());
    if(end == -1)
      end = text.length() - 1;

    return text.substring(begin, end);
  }


}
