package com.hotel.dfs;

import java.util.*;

class ThroneInheritance {
    public static void main(String[] args) {
        ThroneInheritance t= new ThroneInheritance("king"); // order: king
        t.birth("king", "andy"); // order: king > andy
        t.birth("king", "bob"); // order: king > andy > bob
        t.birth("king", "catherine"); // order: king > andy > bob > catherine
        t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "alex", "asha", "catherine"]neInheritance();
    }

    private Map<String, List<String>> family = new HashMap<>();
    private Set<String> dead = new HashSet<>();
    private String root;

    public ThroneInheritance(String kingName) {
        root = kingName;
        family.put(root, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        family.get(parentName).add(childName);
        family.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(order, root);
        return order;
    }

    private void dfs(List<String> order, String root) {
        if (!dead.contains(root)) {
            order.add(root);
        }
        for (String child : family.get(root)) {
            dfs(order, child);
        }
    }
}
