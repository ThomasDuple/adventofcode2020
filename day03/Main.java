package day03;

import utils.FileTo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<String> map = FileTo.fileToStringList("src/day03/input.txt");

        list.add(traverse(1,1, map));
        list.add(traverse(3,1, map));
        list.add(traverse(5,1, map));
        list.add(traverse(7,1, map));
        list.add(traverse(1,2, map));

        long mult = 1;
        for (Integer x : list) {
            mult *= x;
        }
        System.out.println(mult);
    }

    public static int traverse(int right, int down, ArrayList<String> map) {
        int c = 0;
        int x = 0;
        int i = 0;

        while (i < map.size()) {
            String line = map.get(i);

            if (x >= line.length()) x -= line.length();

            if (line.charAt(x) == '#') {
                c++;
            }

            x += right;

            i += down;

        }
        return c;
    }
}