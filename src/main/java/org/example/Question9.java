package org.example;

import java.util.*;

/**
 *  Name: Christopher Healy
 *  Class Group: SD2A
 */
public class Question9 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();
        Deque<Double> numberStack = new ArrayDeque<>();
        Deque<Character> operatorStack = new ArrayDeque<>();


        //hash map of operator priority
        Map<Character, Integer> operatorPriorityMap = new HashMap<>();
        operatorPriorityMap.put('+', 1);
        operatorPriorityMap.put('-', 1);
        operatorPriorityMap.put('*', 2);
        operatorPriorityMap.put('/', 2);
        operatorPriorityMap.put('(', 3);



        for (int i=0;i<equation.length();i++){
            char currentChar = equation.charAt(i);
            // digit character?
            if (Character.isDigit(currentChar)){
                numberStack.push(Double.parseDouble(String.valueOf(currentChar)));
            }
            // '(' ?
            else if (currentChar == '('){
                operatorStack.push('(');
            }

            //operator ?
            else if ("+-*/".contains(Character.toString(currentChar))) {
                operatorStack.push(currentChar);
                while (operatorPriorityMap.get(operatorStack.peek()) > operatorPriorityMap.get(currentChar)){
                    evaluateTop(numberStack, operatorStack);
                }

            }

            // ')' ?
            else if (currentChar == ')'){
                while (operatorStack.peek() != '('){
                    evaluateTop(numberStack, operatorStack);
                }
                operatorStack.pop();
            }
        }

        //evaluateTop until operatorStack is empty
        while (!operatorStack.isEmpty()){
            evaluateTop(numberStack, operatorStack);
        }

        System.out.println("Result: "+ numberStack.pop());
    }

    public static void evaluateTop(Deque<Double> numberStack, Deque<Character> operatorStack){
        double term1 = numberStack.pop();
        double term2 = numberStack.pop();
        char operator = operatorStack.pop();

        numberStack.push(
                switch(operator){
                    case '+' -> term1 + term2;
                    case '-' -> term2 - term1;
                    case '*' -> term1 * term2;
                    case '/' -> term2 / term1;
                    default -> 0.0; //assume only valid operands received
                }
        );
    }
}
