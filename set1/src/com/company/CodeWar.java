package com.company;

import java.util.Arrays;

public class CodeWar {
    public static String[] removeRotten(String[] fruitBasket) {

        if(fruitBasket == null || fruitBasket.length == 0) return new String[0];
        String [] output = new String[fruitBasket.length];
        for(int i = 0; i < fruitBasket.length; i++){
            if(fruitBasket[i].substring(0,6).equals("rotten")){
                String replace = fruitBasket[i].replace("rotten","");
                replace = replace.toLowerCase();
                output[i] = replace;
            } else {
                output[i] = fruitBasket[i];
            }
        }
        return fruitBasket;
    }

    public static void main(String[] args) {
        removeRotten(new String []{"rottenApple","rottenBanana","rottenApple","rottenPineapple","rottenKiwi"});
    }

}
