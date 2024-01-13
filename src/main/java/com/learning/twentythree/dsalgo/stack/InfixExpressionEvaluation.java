package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixExpressionEvaluation {
    public static void main(String[] args) {
        InfixExpressionEvaluation main = new InfixExpressionEvaluation();
        System.out.println(main.evaluate(new String[]{"2", "+", "(", "5", "-", "3", "*", "6", "/", "2", ")"}));
    }

    public int evaluate(String[] arr) {
        Deque<Integer> operandsStack = new ArrayDeque<>();

        Deque<String> operatorsStack = new ArrayDeque<>();
        String topOperator;
        int num1, num2;
        for (int i = 0; i < arr.length; i++) {
            String elem = arr[i];
            switch (elem) {
                case "+":
                case "-":
                    if (!operatorsStack.isEmpty()) {
                        topOperator = operatorsStack.peek();
                        while (!operatorsStack.isEmpty() && !topOperator.equals("(")) {
                            num2 = operandsStack.pop();
                            num1 = operandsStack.pop();
                            operandsStack.push(calculate(num1, num2, topOperator));
                            operatorsStack.pop();
                            topOperator = operatorsStack.peek();
                        }
                    }
                    operatorsStack.push(elem);
                    break;
                case "*":
                case "/":
                    if (!operatorsStack.isEmpty()) {
                        topOperator = operatorsStack.peek();
                        while (!operatorsStack.isEmpty() && (topOperator.equals("*") || topOperator.equals("/"))) {
                            num2 = operandsStack.pop();
                            num1 = operandsStack.pop();
                            operandsStack.push(calculate(num1, num2, topOperator));
                            operatorsStack.pop();
                            topOperator = operatorsStack.peek();
                        }
                    }
                    operatorsStack.push(elem);
                    break;
                case "(":
                    operatorsStack.push(elem);
                    break;
                case ")":
                    if (!operatorsStack.isEmpty()) {
                        topOperator = operatorsStack.peek();
                        while (!operatorsStack.isEmpty() && !topOperator.equals("(")) {
                            num2 = operandsStack.pop();
                            num1 = operandsStack.pop();
                            operandsStack.push(calculate(num1, num2, topOperator));
                            operatorsStack.pop();
                            if (!operatorsStack.isEmpty()) {
                                topOperator = operatorsStack.peek();
                            }
                        }
                        if (!operatorsStack.isEmpty()) {
                            operatorsStack.pop();
                        }
                    }
                    break;
                default:
                    operandsStack.push(Integer.parseInt(elem));
            }
        }

        while (!operatorsStack.isEmpty()) {
            topOperator = operatorsStack.pop();
            num2 = operandsStack.pop();
            num1 = operandsStack.pop();
            operandsStack.push(calculate(num2, num1, topOperator));
        }

        return operandsStack.pop();
    }

    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return Integer.MIN_VALUE;
    }
}
