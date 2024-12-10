package com.leetcode.top.interview.easy;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;

/*
 * https://leetcode.com/problems/valid-parentheses
 * 
 * */
public class ValidParentheses {

    public static void main(String[] args) {

        Assertions.assertEquals(true, approach2("()"));
        Assertions.assertEquals(true, approach2("()[]{}"));
        Assertions.assertEquals(false, approach2("(]"));
        Assertions.assertEquals(true, approach2("([])"));
    }

    private static boolean approach1(String s) {
    	
    	if (s.length() % 2 != 0) return false;

    	Stack<Character> inputChars = new Stack<>();
    	
    	for (Character ch : s.toCharArray()) {
    		
    		if (ch == '(' || ch == '[' || ch == '{')
    			inputChars.push(ch);
    		else if (inputChars.isEmpty()) return false;
    		else {
    			Character top = inputChars.peek();
    			
    			if ((top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}')) {
    				inputChars.pop();
    			} else return false;
    		}
		}

        return inputChars.isEmpty();
    }
    
    private static boolean approach2(String s) {
    	
    	if (s.length() % 2 != 0) return false;

    	Stack<Character> inputChars = new Stack<>();
    	
    	for (Character ch : s.toCharArray()) {
    		if (ch == '(') inputChars.push(')');
    		else if(ch == '[') inputChars.push(']');
    		else if (ch == '{') inputChars.push('}');
    		else if (inputChars.isEmpty() || inputChars.pop() != ch) return false;
		}

        return inputChars.isEmpty();
    }

}
