package day4;

import utils.FileTo;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> allPassport = FileTo.fileToEchantillons("src/day4/input.txt");

        int c = 0;

        for (ArrayList<String> data : allPassport) {
            HashMap<String, String> passport = new HashMap<>();

            for (String line : data) {
                for (String field: line.split(" ")) {
                    String[] infos = field.split(":");
                    passport.put(infos[0], infos[1]);
                }
            }

            if (checkPassport(passport)) c++;
        }

        System.out.println(c);
    }

    public static boolean checkPassport(HashMap<String, String> fields) {
        // close your eyes on this part
        if (!fields.containsKey("byr")) {
            return false;
        } else {
            String value = fields.get("byr");

            if (value.length() != 4) return false;

            for (char c : value.toCharArray()) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }

            int intValue = Integer.parseInt(value);

            if (intValue < 1920 || intValue > 2002) return false;
        }

        if (!fields.containsKey("iyr")) {
            return false;
        } else {
            String value = fields.get("iyr");

            if (value.length() != 4) return false;

            for (char c : value.toCharArray()) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }

            int intValue = Integer.parseInt(value);

            if (intValue < 2010 || intValue > 2020) return false;
        }

        if (!fields.containsKey("eyr")) {
            return false;
        } else {
            String value = fields.get("eyr");

            if (value.length() != 4) return false;

            for (char c : value.toCharArray()) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }

            int intValue = Integer.parseInt(value);

            if (intValue < 2020 || intValue > 2030) return false;
        }

        if (!fields.containsKey("hgt")) {
            return false;
        } else {
            String value = fields.get("hgt");

            if (value.length() < 2) return false;

            String unit = value.substring(value.length() - 2);

            int nb = Integer.parseInt(value.substring(0, value.length() - 2));

            switch (unit) {
                case "cm":
                    if (nb < 150 || nb > 193) return false;
                    break;
                case "in":
                    if (nb < 59 || nb > 76) return false;
                    break;
                default:
                    return false;
            }
        }

        if (!fields.containsKey("hcl")) {
            return false;
        } else {
            String value = fields.get("hcl");

            if (value.length() != 7) return false;

            if (value.toCharArray()[0] != '#') return false;

            for (int i = 1; i < value.length(); i++) {
                char c = value.toCharArray()[i];
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f')) return false;
            }
        }

        if (!fields.containsKey("ecl")) {
            return false;
        } else {
            String value = fields.get("ecl");

            switch (value) {
                case "amb" :
                case "blu" :
                case "brn" :
                case "gry" :
                case "grn" :
                case "hzl" :
                case "oth":
                    break;
                default:
                    return false;
            }
        }

        if (!fields.containsKey("pid")) {
            return false;
        } else {
            String value = fields.get("pid");

            if (value.length() != 9) return false;

            for (char c : value.toCharArray()) {
                if (c < '0' || c > '9') return false;
            }
        }

        return true;
    }
}