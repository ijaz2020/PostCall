package com.cp.hashcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Library implements Comparator<Library> {
    int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public List<Integer> getBookList() {
        return bookList;
    }

    public void setBookList(List<Integer> bookList) {
        this.bookList = bookList;
    }

    List<Integer> bookList = new ArrayList<>();
    int signupDays;
    int parallelDays;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    int score;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public int getSignupDays() {
        return signupDays;
    }

    public void setSignupDays(int signupDays) {
        this.signupDays = signupDays;
    }

    public int getParallelDays() {
        return parallelDays;
    }

    public void setParallelDays(int parallelDays) {
        this.parallelDays = parallelDays;
    }

    @Override
    public int compare(final Library record1, final Library record2) {
        int c;
        c = record2.getScore() - (record1.getScore());
        if (c == 0)
            c = record1.getSignupDays() - (record2.getSignupDays());
        if (c == 0)
            c = record2.getParallelDays() - (record1.getParallelDays());
        if (c == 0)
            c = record2.getBookList().size() -(record1.getBookList().size());
        return c;
    }
}
