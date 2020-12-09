package day05;

import utils.FileTo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = FileTo.fileToStringList("src/day05/input.txt");

        TreeSet<Integer> ts = new TreeSet<>();

        //int maxSeat = 0;

        for (String line : data) {
            char[] chars = line.toCharArray();

            int minY = 0;
            int maxY = 127;

            int minX = 0;
            int maxX = 7;

            for (char C: chars) {
                switch (C) {
                    case 'F' -> maxY = (minY + 1 + maxY + 1) / 2 - 1;
                    case 'B' -> minY = (minY + 1 + maxY + 1) / 2;
                    case 'R' -> minX = (minX + 1 + maxX + 1) / 2;
                    case 'L' -> maxX = (minX + 1 + maxX + 1) / 2 - 1;
                    default -> System.out.println("Lettre non reconnue");
                }

            }

            //if (maxSeat < minY * 8 + minX) maxSeat = minY * 8 + minX;

            ts.add(minY * 8 + minX);
        }

        //System.out.println(maxSeat);

        Iterator<Integer> it = ts.iterator();

        int old = it.next();

        while (it.hasNext()) {
            int curr = it.next();

            if (curr != old+1) {
                System.out.println(old+1);
            }

            old = curr;
        }

    }
}
