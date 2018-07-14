import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class ProblemSet1 {

    public static void main(String[] args) {
       
       // for sortByString
       String s = "weather";
       String t = "therapyw";
       sortByString(s,t);

       // for sortByString
       String s2 = "good";
       String t2 = "odg";
       sortByString(s2,t2);
        
        // for decode
        String decodeInput = "2[b3[a]]";
        String decodeInput2 = "2[aaa2[b3[cc]]]";
        decode(decodeInput);
        decode(decodeInput2);

    }

    public static void sortByString(String s, String t){

        // Edge case Null
        if(s == null || t == null){
            System.out.println("invalid string");
        }

        //
        if((s == "" || t == "") || (s == " " || t == " ")){
            System.out.println("empty string");
        }

        char [] inputCharArr = t.toCharArray();
        char [] stringToBeSortedArr = s.toCharArray();
        HashMap<Character, Integer> stringCharCounts = new HashMap<Character, Integer>();

        for(char elem: stringToBeSortedArr){
            if(!stringCharCounts.containsKey(elem)){
                stringCharCounts.put(elem, 1);
            } else {
                stringCharCounts.put(elem, stringCharCounts.get(elem) + 1);
            }
        }

        StringBuilder finalStr = new StringBuilder("");

        for(char elem: inputCharArr){
            if(stringCharCounts.containsKey(elem)){
                for(int i=0; i < stringCharCounts.get(elem); i++){
                    finalStr.append(elem);
                }
            }
        }

        System.out.println(finalStr);
    }

    public static void decode(String input){
        char [] inputCharArr = input.toCharArray();

        Stack<Integer> openBrackets = new Stack<Integer>();

        for(int i=0; i < inputCharArr.length; i++){
            if(inputCharArr[i] == '['){
                openBrackets.push(i);
            }
        }

        int lastPart = -1;
        String lastPattern = "";
        StringBuilder output = new StringBuilder("");

        for(int i=0; i < inputCharArr.length; i++){
            if(inputCharArr[i] == ']'){
                int indexOfOpen = openBrackets.pop();
                if (lastPart == -1){
                    int count = Character.getNumericValue(inputCharArr[indexOfOpen - 1]);
                    StringBuilder pattern = new StringBuilder("");
                    for(int j = 0; j < count; j++){
                        pattern.append(input.substring(indexOfOpen + 1, i));
                    }
                    lastPattern = pattern.toString();
                } else {
                    int count = Character.getNumericValue(inputCharArr[indexOfOpen - 1]);
                    for(int j = 0; j < count; j++){
                        StringBuilder tempPattern = new StringBuilder(input.substring(indexOfOpen + 1, lastPart));
                        tempPattern.append(lastPattern);
                        output.append(tempPattern.toString());
                    }
                }
                lastPart = indexOfOpen - 1;
            }
        }
        System.out.println(output.toString());
    }
}
