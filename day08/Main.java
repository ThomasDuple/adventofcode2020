package day08;

import utils.FileTo;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = FileTo.fileToStringList("src/day08/input.txt");


        for (int i = 0; i < data.size(); i++) {
            String act = data.get(i).split(" ")[0];

            if (act.equals("jmp") || act.equals("nop")) {
                String oldLine = data.get(i);

                switch (act) {
                    case "jmp":
                        data.set(i, "nop" + data.get(i).substring(3));
                        break;
                    case "nop":
                        data.set(i, "jmp" + data.get(i).substring(3));
                        break;
                    default:
                        System.out.println("bug");
                }

                ArrayList<String> newData = new ArrayList<>(data);

                data.set(i, oldLine);

                TreeSet<Integer> executed = new TreeSet<>();

                boolean working = false;
                int it = 0;
                boolean ok = true;
                int acc = 0;

                while (ok && !working) {
                    executed.add(it);
                    String[] infos = newData.get(it).split(" ");

                    String action = infos[0];
                    int value = Integer.parseInt(infos[1]);

                    switch (action) {
                        case "jmp" :
                            it += value;
                            break;
                        case "acc" :
                            acc += value;
                        case "nop" :
                            it++;
                            break;
                        default:
                            System.out.println("Action not found");
                    }

                    if (it == data.size()) {
                        System.out.println(acc);
                        working = true;
                    }

                    if (executed.contains(it)) {
                        ok = false;
                    }
                }
            }
        }
    }

}
