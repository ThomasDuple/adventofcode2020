package day2;

import utils.FileTo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = FileTo.fileToStringList("src/day2/input.txt");

        int nb = 0;

        for (String line : list) {
            String[] infos = line.split(" ");
            String[] values = infos[0].split("-");
            int min = Integer.parseInt(values[0]);
            int max = Integer.parseInt(values[1]);
            char letter = infos[1].charAt(0);
            char[] chars = infos[2].toCharArray();

/*
            int i = 0;

            for (char c : chars) {
                if (c == letter) {
                    i++;
                }
            }

            if (min <= i && i <= max) nb++;
*/
            if (chars[min-1] == letter ^ chars[max-1] == letter) nb++;

        }

        System.out.println(nb);
    }
}
