package com.cp.Math;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class Max69 {
    public static void main(String[] args){
        System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
//        System.out.println(new Max69().maximum69Number(9669));
        Graph graph = new SingleGraph("I can see dead pixels");
        graph.display();
    }

    public int maximum69Number (int num) {
        char[] chars= String.valueOf(num).toCharArray();
        for(int i=0; i<chars.length;i++){
            if(chars[i] == '6'){
                chars[i] ='9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
