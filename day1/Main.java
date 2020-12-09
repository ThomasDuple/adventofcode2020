package day1;

import utils.FileTo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = FileTo.fileToIntList("src/day1/input.txt");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    if (i != j && j != k) {
                        int x = list.get(i);
                        int y = list.get(j);
                        int z = list.get(k);

                        if (x + y + z == 2020) {
                            System.out.println(x * y * z);
                            return;
                        }
                    }
                }
            }
        }
    }
}
