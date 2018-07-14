package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Rectangle rect1 = new Rectangle(2,3);
//        rect1.getPerimeter();
//        rect1.getArea();
//        System.out.println(rect1.toString());
//
//        Square square = new Square(2);
//        square.getPerimeter();
//        square.getArea();
//        square.toString();

//        System.out.println(sumDigits(126));
//        countX("xxhixx");
        System.out.println(findMax3(6, "3 4 5 1 3 # 1"));
        System.out.println(findMax3(5, "3 21 # # 13"));
    }

    static public int sumDigits(int n) {
        if (n == 0) return 0;
        System.out.println(n/10);
        return n % 10 + sumDigits(n / 10);
    }

    static public int countX(String str) {
        if (str.length() == 1) {
            if (str.charAt(0) == 'x'){
                return 1;
            } else {
                return 0;
            }
        }
        int count = -1;
        if (str.charAt(0) == 'x'){
            count = 1;
        } else {
            count = 0;
        }

        str = str.substring(1, str.length());
        System.out.println(str);
        return count + countX(str);
    }

    static long findMax(int n, String tree) {
        String[] tokens = tree.split(" ");
//        for (String string : tokens)
//            System.out.print(string);
//        System.out.println();
        int max = 0;
        int maxLevel = (int)(Math.log(tokens.length+1) / Math.log(2));
//        System.out.println("tokens: " + tokens.length + ", log: " + Math.log(tokens.length+1)/Math.log(2));
        int[] totals = new int[maxLevel];
//        System.out.println("level from 0 to " + maxLevel);
        for (int level = 0; level < maxLevel; level++) {
//            System.out.println("level " + level + ": ");
            for (int i = (int)Math.pow(2, level)-1; i < Math.pow(2, level+1)-1; i++) {
//                System.out.println("i: " + i + ", token: " + tokens[i]);
                if (!tokens[i].equals("#")) {
                    totals[level] += Integer.parseInt(tokens[i]);
                }
            }
//            System.out.println("total " + totals[level]);
        }
//        int odd = 0;
//        for (int i = 0; i < totals.length; i += 2)
//            odd += totals[i];
//        int even = 0;
//        for (int i = 1; i < totals.length; i += 2)
//            even += totals[i];
        int totals_max = -1;
        for(int j = 0; j < totals.length; j++){
            if (totals[j] > totals_max){
                totals_max  = totals[j];
            }
        }
        System.out.println(totals_max);
        return totals_max;
    }


    static long findMax2(int n, String tree) {
        String[] tokens = tree.split(" ");
        int max = 0;
        int maxLevel = (int)(Math.log(tokens.length+1) / Math.log(2));
        int[] totals = new int[maxLevel];

        for (int level = 0; level < maxLevel; level++) {
            for (int i = (int)Math.pow(2, level)-1; i < Math.pow(2, level+1)-1; i++) {
                if (!tokens[i].equals("#")) {
                    totals[level] += Integer.parseInt(tokens[i]);
                }
            }
        }
        int totals_max = -1;
        for(int j = 0; j < totals.length; j++){
            if (totals[j] > totals_max){
                totals_max  = totals[j];
            }
        }
        System.out.println(totals_max);
        return totals_max;
    }

    static long findMax3(int n, String tree) {
        String[] tokens = tree.split(" ");
        long max = 0;
        int maxLevel = (int)(Math.log(tokens.length+1) / Math.log(2));
        long[] totals = new long[maxLevel];
        for (int level = 0; level < maxLevel; level++) {
            for (int i = (int)Math.pow(2, level)-1; i < Math.pow(2, level+1)-1; i++) {
                if (!tokens[i].equals("#")) {
                    totals[level] += Float.parseFloat(tokens[i]);
                }
            }
        }
        int odd = 0;
        for (int i = 0; i < totals.length; i += 2)
            odd += totals[i];
        int even = 0;
        for (int i = 1; i < totals.length; i += 2)
            even += totals[i];
//        System.out.println(Math.max(odd, even));
        return Math.max(odd, even);
//        long totals_max = -1;
//        for(int j = 0; j < totals.length; j++){
//            if (totals[j] > totals_max){
//                totals_max  = totals[j];
//            }
//        }
//        System.out.println(totals_max);
//        return totals_max;
    }

    static int[] arbitrage(String[] quotes) {
        /*
         * Write your code here.
         */
        if(quotes == null) return null;
        if(quotes.length == 0) return new int []{0};
        int profit = 0;
        int [] output = new int[quotes.length];
        for(int i=0; i < quotes.length; i++){
            float start = 100000;
            float curr = 1;
            String[] split = quotes[i].split("\\s+");
            for(int j = 0; j < 3; j++){
                start = start/ Float.parseFloat(split[j]);
            }
            if (start > 100000){
                output[i] = (int)(start - (float)100000);
            } else {
                output[i] = 0;
            }
        }
        return output;
    }

    static String electionWinner(String[] votes) {
        Map<String, Integer> vals = new HashMap();
        for(String vote: votes){
            if (vals.containsKey(vote)){
                int value = vals.get(vote);
                value += 1;
                vals.put(vote, value);
            } else {
                vals.put(vote, 1);
            }
        }
        int maxValueInMap=(Collections.max(vals.values()));
        List <String> possible = new ArrayList();
        for (Map.Entry<String, Integer> entry : vals.entrySet()) {
            System.out.println(entry);
            if (entry.getValue()==maxValueInMap) {
                possible.add(entry.getKey());
            }
        }
        Collections.sort(possible.subList(1, possible.size()));
        return possible.get(0);
    }

}
