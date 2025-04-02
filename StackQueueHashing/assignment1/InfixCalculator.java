package StackQueueHashing.assignment1;

import java.util.HashMap;

import StackQueueHashing.Helper.Stack;
import StackQueueHashing.Helper.StackImplementation;

public class InfixCalculator {
    static HashMap<String, Integer> precedence = new HashMap<>();

    static {
        precedence.put("(", 1);
        precedence.put("||", 2);
        precedence.put("&&", 3);
        precedence.put("==", 4);
        precedence.put("!=", 4);
        precedence.put("<", 5);
        precedence.put(">", 5);
        precedence.put("<=", 5);
        precedence.put(">=", 5);
        precedence.put("+", 6);
        precedence.put("-", 6);
        precedence.put("*", 7);
        precedence.put("/", 7);
        precedence.put("!", 8);
    }

    private void processOperation(Stack<Integer> values, String op) {
        if (op == "!") {
            int x = values.pop();
            values.push(~x);
        } else {
            int b = values.pop();
            int a = values.pop();
            switch (op) {
                case "+":
                    values.push(a + b);
                    break;
                case "-":
                    values.push(a - b);
                    break;
                case "*":
                    values.push(a * b);
                    break;
                case "/":
                    values.push(a / b);
                    break;
                case "==":
                    if (a == b)
                        values.push(1);
                    else
                        values.push(0);
                    break;
                case "!=":
                    if (a != b)
                        values.push(1);
                    else
                        values.push(0);
                    break;
                case "<":
                    if (a < b)
                        values.push(1);
                    else
                        values.push(0);
                    break;
                case ">":
                    if (a > b)
                        values.push(1);
                    else
                        values.push(0);
                    break;
                case "<=":
                    if (a <= b)
                        values.push(1);
                    else
                        values.push(0);
                    break;
                case ">=":
                    if (a >= b)
                        values.push(1);
                    else
                        values.push(0);
                    break;
                case "&&":
                    values.push(a & b);
                    break;
                case "||":
                    values.push(a | b);
                    break;
            }
        }
    }

    public int evaluate(String expr) {
        String[] tokens = expr.split(" ");
        StackImplementation<Integer> values = new StackImplementation<>(30);
        StackImplementation<String> ops = new StackImplementation<>(30);
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                values.push(Integer.parseInt(token));
            } else if (token.equals("(")) {
                ops.push(token);
            } else if (token.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    processOperation(values, ops.pop());
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && precedence.getOrDefault(ops.peek(), 0) >= precedence.getOrDefault(token, 0)) {
                    processOperation(values, ops.pop());
                }
                ops.push(token);
            }
        }
        while (!ops.isEmpty()) {
            processOperation(values, ops.pop());
        }
        return values.pop();
    }

}
