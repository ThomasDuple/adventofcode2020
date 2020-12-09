package day06;

import utils.FileTo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> echantillons = FileTo.fileToEchantillons("src/day06/input.txt");

        int sum = 0;

        for (ArrayList<String> ech : echantillons) {
            ArrayList<Character> all = new ArrayList<>();
            for (char c = 'a'; c <= 'z'; c++) {
                all.add(c);
            }

            for (String chars : ech) {
                ArrayList<Character> dupl = new ArrayList<>();
                for (char c : chars.toCharArray()) {
                    if (all.contains(c)) dupl.add(c);
                }
                all = dupl;
            }

            sum += all.size();
        }

        System.out.println(sum);
    }
}
