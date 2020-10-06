package com.cp.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Person {
    public String name;
    public List<Person> children;
    public Boolean isDead;

    public Person (String aName) {
        name = aName;
        isDead = false;
        children = new ArrayList<>();
    }
}

public class Monarchy {
    HashMap<String, Person> personMap;
    String king;

    public Monarchy (String aKing) {
        personMap = new HashMap<>();
        king = aKing;
        personMap.put(king, new Person(king));
    }

    public void birth (String child, String parent) {
        Person parentObj = personMap.get(parent);
        Person childObj = new Person(child);
        parentObj.children.add(childObj);
        personMap.put(child, childObj);
    }

    public void death (String name) {
        personMap.get(name).isDead = true;
    }

    public List<String> getOrderOfSuccession() {
        List<String> succession = new ArrayList<>();
        Stack<Person> stack = new Stack<>();
        stack.push(personMap.get(king));

        while ( !stack.empty() ) {
            Person current = stack.pop();
            if (!current.isDead) succession.add(current.name);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }

        return succession;
    }

    public static void main(String[] args) {
        Monarchy m = new Monarchy("king");
        m.birth("andy", "king");
        m.birth("bob", "king");
        m.birth("cath", "king");
        m.birth("matt", "andy");
        m.birth("alex", "bob");
        m.birth("asha", "bob");
        List<String> list = m.getOrderOfSuccession();
        System.out.println(list.toString());
    }
}
