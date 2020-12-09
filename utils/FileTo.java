package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTo {

    public static ArrayList<String> fileToStringList(String path) {
        ArrayList<String> list = new ArrayList<>();

        try {
            File f = new File(path);
            Scanner scann = new Scanner(f);

            while (scann.hasNextLine()) {
                list.add(scann.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return list;
    }

    public static ArrayList<Integer> fileToIntList(String path) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String s : fileToStringList(path)) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public static ArrayList<ArrayList<String>> fileToEchantillons(String path) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        try {
            File f = new File(path);
            Scanner scann = new Scanner(f);

            ArrayList<String> subList = new ArrayList<>();

            while (scann.hasNextLine()) {
                String line = scann.nextLine();

                if (line.equals("")) {
                    list.add(subList);
                    subList = new ArrayList<>();
                } else {
                    subList.add(line);
                }
            }
            list.add(subList);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return list;
    }
}
