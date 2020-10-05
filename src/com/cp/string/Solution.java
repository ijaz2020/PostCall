package com.cp.string;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution {

  public static String rmQm(String str)
  {
    str=str.replace("?","");
    str=str.replace("What", "");
    str=str.replace("Which","");
    str=str.replace("Why","");
    str=str.replace("How","");
    str=str.replace("When","");
    str=str.replace("In which","");
    str=str.replace("are","");
    str=str.replace("is","");
    str=str.replace("are","");
    str=str.replace("of","");
    str=str.replace("the","");
    str=str.replace("in","");
    str=str.replace("do","");
    str=str.replace("did","");

    return str;
  }
  //public static
  public static void main(String[] args) {


    String initialString = "Ecuador , officially the Republic of Ecuador, is a representative democratic republic in northwestern South America, bordered by Colombia on the north, Peru on the east and south, and the Pacific Ocean to the west. Ecuador also includes the GalÃ¡pagos Islands in the Pacific, about 1,000 kilometres (620 mi) west of the mainland. The main spoken language in Ecuador is Spanish (94% of the population). Languages of official use in native communities include Quichua, Shuar, and eleven other languages. Ecuador has a land area of 283,520 km2. Its capital city is Quito, which was declared a World Heritage Site by UNESCO in the 1970s for having the best preserved and least altered historic center in Latin America. The country's largest city is Guayaquil. The historic center of Cuenca, the third-largest city in the country in size and economically, was also declared a World Heritage Site in 1999 as an outstanding example of a planned, inland Spanish-style colonial city in the Americas. Ecuador is home to a great variety of species, many of them endemic, such as those of the GalÃ¡pagos Islands. This species diversity makes Ecuador one of the seventeen megadiverse countries in the world, it is considered the most biodiverse country in the world per unit area. The new constitution of 2008 is the first in the world to recognize legally enforceable Rights of Nature, or ecosystem rights.\n" +
      "Which country borders Ecuador on the north?\n" +
      "Which country borders Ecuador on the east and south?\n" +
      "What borders Ecuador to the west?\n" +
      "What is the main spoken language in Ecuador?\n" +
      "What is the capital city of Ecuador?\n" +
      "Pacific Ocean;Spanish;Quito;Colombia;Peru";
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner input = new Scanner(new ByteArrayInputStream(initialString.getBytes()));
    String para = input.nextLine();
    para=para.replaceAll("[.]", "+");
    para=para.replaceAll("[+][\\s]", ". ");
    String[] ques = new String[5];
    for(int j=0;j<5;j++)
    {
      ques[j] = input.nextLine();
      ques[j]=rmQm(ques[j]);
    }
    String[] ans = new String[5];
    int i=0;
    String answers = input.nextLine();
    StringTokenizer st = new StringTokenizer(answers,";");
    while(st.hasMoreTokens())
    {
      ans[i]=st.nextToken();
      i++;
    }
    StringTokenizer st1 = new StringTokenizer(para,".");
    ArrayList <String> ar = new ArrayList <String>();
    while(st1.hasMoreTokens())
    {
      ar.add(st1.nextToken());
    }
    int len_of_lines=ar.size();

    int[][] aseq= new int[5][len_of_lines];
    int[][] qseq= new int[5][len_of_lines];
    for(int j=0;j<5;j++)
    {
      for(int k=0;k<len_of_lines;k++)
      {
        if(ar.get(k).toLowerCase().contains(ques[j].toLowerCase()))
        {
          aseq[j][k]=999;
        }
        else
        {


          ArrayList <String> q_word = new ArrayList <String>();
          StringTokenizer st2= new StringTokenizer(ques[j]);
          while(st2.hasMoreTokens())
          {
            q_word.add(st2.nextToken());
          }

          int count_word=q_word.size();
          for(int a=0;a<count_word;a++)
          {
            if(ar.get(k).toLowerCase().contains(q_word.get(a).toLowerCase()))
            {
              aseq[j][k]+=1;
            }
            if(a<count_word-1)
            {
              String word_2=q_word.get(a)+" "+q_word.get(a+1);

              if(ar.get(k).toLowerCase().contains(word_2.toLowerCase()))
              {
                aseq[j][k]+=3;
              }
            }
            if(a<count_word-2)
            {
              String word_3=q_word.get(a)+" "+q_word.get(a+1)+" "+q_word.get(a+2);
              if(ar.get(k).toLowerCase().contains(word_3.toLowerCase()))
              {
                aseq[j][k]+=5;
              }
            }

          }
        }
      }
    }
    for(int j=0;j<5;j++)
    {
      for(int k=0;k<len_of_lines;k++)
      {
        if(ar.get(k).toLowerCase().contains(ans[j].toLowerCase()))
        {
          qseq[j][k]=999;
        }
        else
        {


          ArrayList <String> a_word = new ArrayList <String>();
          StringTokenizer st2= new StringTokenizer(ans[j]);
          while(st2.hasMoreTokens())
          {
            a_word.add(st2.nextToken());
          }

          int count_word=a_word.size();
          for(int a=0;a<count_word;a++)
          {
            if(ar.get(k).toLowerCase().contains(a_word.get(a).toLowerCase()))
            {
              qseq[j][k]+=1;
            }
            if(a<count_word-1)
            {


              String word_2=a_word.get(a)+" "+a_word.get(a+1);
              if(ar.get(k).toLowerCase().contains(word_2.toLowerCase()))
              {
                qseq[j][k]+=3;
              }
            }
            if(a<count_word-2)
            {
              String word_3=a_word.get(a)+" "+a_word.get(a+1)+" "+a_word.get(a+2);
              if(ar.get(k).toLowerCase().contains(word_3.toLowerCase()))
              {
                qseq[j][k]+=5;
              }
            }

          }
        }
      }
    }

    int[] q_line = new int[5];
    int[] a_line = new int[5];
    int[] line  = new int[len_of_lines];
    for(int j=0;j<5;j++)
    {
      for(int k=0;k<len_of_lines;k++)
      {
        line[k]=aseq[j][k];
      }

      int largest = line[0], index = 0;
      for (int o = 1; o < line.length; o++) {
        if ( line[o] > largest ) {
          largest = line[o];
          index = o;
        }
        q_line[j]=index;
      }
    }
    for(int j=0;j<5;j++)
    {
      for(int k=0;k<len_of_lines;k++)
      {
        line[k]=qseq[j][k];
      }

      int largest = line[0], index = 0;
      for (int o = 1; o < line.length; o++) {
        if ( line[o] > largest ) {
          largest = line[o];
          index = o;
        }
        a_line[j]=index;
      }
    }
    String[] final_ans= new String[5];


    for(int j=0;j<5;j++)
    {
      for(int k=0;k<5;k++)
      {
        if(q_line[j]==a_line[k])
        {
          final_ans[j]=ans[k];

        }



      }
    }
    int vacant_ans=0;

    for(int j=0;j<5;j++)
    {

      if(final_ans[j]==null)
      {

        vacant_ans=j;

      }
    }
    int[] flag={0,0,0,0,0};

    for(int j=0;j<5;j++)
    {
      for(int k=0;k<5;k++)
      {
        if(ans[j].equalsIgnoreCase(final_ans[k]))
        {
          flag[j]=1;
        }
      }
      if(flag[j]==0)
      {
        final_ans[vacant_ans]=ans[j];

      }
    }

    for(int j=0;j<5;j++)
      System.out.println(final_ans[j]);

  }

}
