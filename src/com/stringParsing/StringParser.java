package com.stringParsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StringParser {
    /*
        String Parser
        Given input string has format as following
        ex: [1, 2, [A, B, C, [5^&, )()6, , 7], D, E] 3, 4]
    */
    public void ParsingString(String input){
        if(detectionError(input)){
            System.out.println("Invalid!");
            return;
        }
        displayResult(input);
    }
    /**
     * @param s
     * @return 
     * 
     * check balance of input string
     * Here , bracket balance is checked, if balanced then return true otherwise return false
     * 
     */
    public boolean checkBalance(String s) {
        Map<Character, Character> openClosePair = new HashMap<Character, Character>();
        openClosePair.put('[', ']'); 
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (openClosePair.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));

            } else if ( openClosePair.containsValue(s.charAt(i))) {
                if (stack.isEmpty())
                    return false;
                if (openClosePair.get(stack.pop()) != s.charAt(i))
                    return false;
            }

        }
        return stack.isEmpty();
    }
    /**
     * 
     * @param s
     * @return 
     * Output result string as tree.
     * 
     */
    public String format(String s) {
        String format_str = new String();
        Map<Character, Character> openClosePair = new HashMap<Character, Character>();
        openClosePair.put('[', ']'); 
        Stack<Character> stack = new Stack<Character>();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> space_list = new ArrayList<Integer>();
        String temp_str = new String();
        int counter_space = 0;
        /**
         * Make tree list for output
         * 
         * */
        for (int i = 0; i < s.length(); i++) {            
            if (openClosePair.containsKey(s.charAt(i))) {
                list.add(temp_str); temp_str = "";
                space_list.add(counter_space);
                counter_space++;
                continue;
            } else if ( openClosePair.containsValue(s.charAt(i))) {
                list.add(temp_str); temp_str = "";
                space_list.add(counter_space);
                counter_space--;
                continue;
            }
            temp_str += s.charAt(i);
        }
        /**
         * output result string as tree
         * 
         * */
        for(int len = 0; len < list.size(); len++){
            if(list.get(len).isEmpty()) continue;
            String[] array = list.get(len).split(",");
            String space = new String();
            for( int i = 0; i < space_list.get(len); i++){
                space += "  ";
            }
            for(String element : array){
                if(element.isEmpty()) continue;
                if(element.equalsIgnoreCase(" ") && element.equals(array[array.length - 1])) continue;
                if(!element.equalsIgnoreCase(" ")){
                    element = element.trim();
                }
                format_str += space + element + "\n";
            }
        }
        return format_str;
    }
    /**
     * 
     * @param input_str
     * @return 
     * Detect invalid input
     */
    public boolean detectionError(String input_str){
        String input = input_str.trim();
        if(input.startsWith(",")) return true;
        if(input.endsWith(",")) return true;
        if(input.startsWith("]")) return true;
        if(input.endsWith("[")) return true;
        if(!checkBalance(input)) return true;
        String temp = input;
        temp = temp.replaceAll("\\s+","");
        if(temp.contains("[,")) return true;
        if(temp.contains(",]")) return true;
        return false;
    }
    /**
     * 
     * @param input
     * Display result on console window
     */
    public void displayResult(String input){
        String resut_str = input;
        resut_str = format(resut_str);
        System.out.println(resut_str);
    }
    /**
     * @param args 
     * Pass the command line arguments
     */
    public static void main(String[] args) {
        int counter = 1;
        while(true){
            StringParser parser = new StringParser();
            System.out.print("EXAMPLE " + String.valueOf(counter) + " (Input): ");
            Scanner scanner = new Scanner(System.in);
            String input_str = scanner.nextLine();
            System.out.println("EXAMPLE " + String.valueOf(counter) + " (Output): ");
            parser.ParsingString(input_str);
            Scanner continue_str = new Scanner(System.in);
            System.out.print("Continue(Y/N): ");
            if(!continue_str.nextLine().trim().equalsIgnoreCase("y")) break; // to continue, input "y", else any character or string
            counter++;
        }
    }
    
}
