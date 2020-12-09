package day09;

import utils.FileTo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Long> list = FileTo.fileToLongList("src/day09/input.txt");

        LinkedList<Long> toCheck = new LinkedList<>();

        int it = 0;

        for (int i = 0; i < 25; i++) {
            toCheck.add(list.get(it));
            it++;
        }

        for (int i = it; i < list.size(); i++) {
            long x = list.get(i);
            if (!checkPrevious(x, toCheck)) {
                System.out.println(x);
                System.out.println(getWeakness(x, list));
                return;
            } else {
                toCheck.add(x);
                toCheck.removeFirst();
            }
        }
    }

    public static boolean checkPrevious(long x, LinkedList<Long> toCheck) {
        for (long a: toCheck) {
            for (long b:toCheck) {
                if (a != b) {
                    if (a + b == x) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static long getWeakness(long x, ArrayList<Long> list) {
        ArrayList<Long> contiguous = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            contiguous = new ArrayList<>();
            int it = i;
            long sum = 0;

            do {
                contiguous.add(list.get(it));
                sum += list.get(it);
                it++;
            } while (sum < x && it < list.size());
            if (sum == x) break;
        }

        long min = contiguous.get(0);
        for (long a: contiguous) {
            if (a < min) min = a;
        }

        long max = contiguous.get(0);
        for (long a: contiguous) {
            if (a > max) max = a;
        }

        return min + max;
    }
}
