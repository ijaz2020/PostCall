package com.cp.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisplayTable {
  public static void main(String[] args) {
    List<List<String>> lists =  List.of(List.of("David","3","Ceviche"),
      List.of("Corina","10","Beef Burrito"),List.of("David","3","Fried Chicken"),List.of("Carla","5","Water"),List.of("Carla","5","Ceviche"),
      List.of("Rous","3","Ceviche"));
    System.out.println(new DisplayTable().displayTable(lists));
  }

  public List<List<String>> displayTable(List<List<String>> orders) {
    final Map<Integer, Map<String, Integer>> map = new HashMap<>();
    final Set<String> dishes = new HashSet<>();
    for (List<String> o : orders) {
      map.computeIfAbsent(Integer.parseInt(o.get(1)), v -> new HashMap<>())
        .merge(o.get(2), 1, Integer::sum);
      dishes.add(o.get(2));
    }
    final List<String> sortedDish = new ArrayList<>(dishes);
    final List<Integer> tables = new ArrayList<>(map.keySet());
    Collections.sort(sortedDish);
    Collections.sort(tables);
    final List<List<String>> res = new ArrayList<>();
    for (Integer table : tables) {
      final List<String> append = new ArrayList<>(Collections.singleton(String.valueOf(table)));
      final Map<String, Integer> currTable = map.get(table);
      for (String s : sortedDish) {
        append.add(String.valueOf(currTable.getOrDefault(s, 0)));
      }
      res.add(append);
    }
    sortedDish.add(0, "Table");
    res.add(0, sortedDish);
    return res;
  }
}
