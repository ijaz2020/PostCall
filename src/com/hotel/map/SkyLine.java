package com.hotel.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SkyLine {
    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new SkyLine().getSkyline(buildings));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        Integer max = 0;
        List<Line> lines = new ArrayList<>();
        computeLines(lines, buildings);
        lines.sort((line1, line2) -> line1.point != line2.point ? line1.point - line2.point :
                (line1.start ? line2.height - line1.height : line1.height-line2.height) );

        for (Line line : lines) {
            if (line.start) {
                map.put(line.height, line.point);
                Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
                if (lastEntry.getKey() > max) {
                    max = lastEntry.getKey();
                    result.add(List.of(lastEntry.getValue(), lastEntry.getKey()));
                }
            }else {
                map.remove(line.height);
                Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
                if (lastEntry.getKey() < max) {
                    max = lastEntry.getKey();
                    result.add(List.of(line.point, lastEntry.getKey()));
                }
            }
        }

        return result;
    }

    private void computeLines(List<Line> lines, int[][] buildings) {
        Arrays.stream(buildings)
                .forEach(building -> {
                    lines.add(new Line(building[0], building[2], true));
                    lines.add(new Line(building[1], building[2], false));
                });
    }
}

class Line {
    int point;
    int height;
    boolean start;

    public Line(int point, int height, boolean start) {
        this.point = point;
        this.height = height;
        this.start = start;
    }
}
