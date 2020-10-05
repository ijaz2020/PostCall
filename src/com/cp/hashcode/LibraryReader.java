package com.hotel.hashcode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryReader {
    public static void main(String[] args) throws IOException {
        List<Library> librariesList = new ArrayList<>();
        LibraryReader l = new LibraryReader();
        Scanner scanner =
                new Scanner(new File("/Users/ijaza/code-base/PostCall/src/com/hotel/hashcode/new.txt"));
        int days = 0, booksCount, libraryCount;
        int[] booksScore, libraries;
        String[] curr = scanner.nextLine().split(" ");
        booksCount = Integer.parseInt(curr[0]);
        booksScore = new int[booksCount];
        libraryCount = Integer.parseInt(curr[1]);
        libraries = new int[libraryCount];
        days = Integer.parseInt(curr[2]);

        String[] score = scanner.nextLine().split(" ");
        for(int i=0; i< score.length; i++)
            booksScore[i] = Integer.parseInt(score[i]);

        for (int i=0; i<libraryCount;i++){
            String[] s = scanner.nextLine().split(" ");
            Library library = new Library();
            library.setId(i);
            library.setSize(Integer.parseInt(s[0]));
            library.setSignupDays(Integer.parseInt(s[1]));
            library.setParallelDays(Integer.parseInt(s[2]));

            s = " ".split(scanner.nextLine());
            List<Integer> bookList = new ArrayList<>();
            int ss = 0;
            for(int j=0; j<library.getSize();j++){
                ss += booksScore[Integer.parseInt(s[j])];
                bookList.add(Integer.parseInt(s[j]));
            }
            library.setScore(ss);
            library.setBookList(bookList);
            librariesList.add(library);
        }
        l.processList(librariesList);
        l.printOut(librariesList);
        System.out.println(librariesList);
    }

    void processList(List<Library> libraryList){
        System.out.println(libraryList);
    }

    void printOut(List<Library> libraries) throws IOException {
        BufferedWriter out = new BufferedWriter(
                new FileWriter("/Users/ijaza/code-base/PostCall/src/com/hotel/hashcode/newout.txt"));
        out.write(libraries.size()+"");
        out.newLine();
        for(Library library : libraries){
            out.write(library.id +" " + library.size);
            out.newLine();

            StringBuffer sb = new StringBuffer();
            for(Integer i: library.getBookList()){
                sb.append(i.toString() + " ");
            }
            sb.trimToSize();
            out.write(sb.toString());
            out.newLine();
        }

        out.flush();
        out.close();
    }

}
