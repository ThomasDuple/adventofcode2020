package day7;

import utils.FileTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = FileTo.fileToStringList("src/day7/input.txt");

        HashMap<String, HashMap<String, Integer>> bags = new HashMap<>();

        for (String elem : list) {
            String[] infos = elem.split(" ");

            bags.put(String.format("%s_%s", infos[0], infos[1]), new HashMap<>());

            if (!infos[4].equals("no")) {
                for (int i = 4; i < infos.length; i += 4) {
                    bags.get(String.format("%s_%s", infos[0], infos[1])).put(String.format("%s_%s", infos[i+1], infos[i+2]), Integer.parseInt(infos[i]));
                }
            }
        }

        System.out.println(bags);

        TreeSet<String> ans = new TreeSet<>();

        ans.add("shiny_gold");

        boolean end = false;

        while (!end) {
            TreeSet<String> old = new TreeSet<>(ans);

            for (String bag : bags.keySet()) {
                for (String good : old) {
                    if (bags.get(bag).containsKey(good)) {
                        ans.add(bag);
                    }
                }
            }

            if (old.equals(ans)) {
                end = true;
            }
        }

        System.out.println(ans.size() - 1);

        System.out.println(getSubBagCount("shiny_gold", bags));
    }

    static int getSubBagCount(String name, HashMap<String, HashMap<String, Integer>> bags) {
        int sum = 0;

        for (String bag : bags.get(name).keySet()) {
            int x = bags.get(name).get(bag);
            sum += x * getSubBagCount(bag, bags) + x;
        }

        return sum;
    }
}

