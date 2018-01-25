// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

public class Solution {
    public int evalRPN(ArrayList<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        } if (arr.size() == 1) {
            return Integer.parseInt(arr.get(0));
        }
        
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.size(); i++) {
            String temp = arr.get(i);
            if (!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"))) {
                stack.push(temp);
            } else { 
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (temp.equals("+")) {
                    stack.push(Integer.toString(a + b));
                } else if (temp.equals("-")) {
                    stack.push(Integer.toString(a - b));
                } else if (temp.equals("*")) {
                    stack.push(Integer.toString(a * b));
                } else if (temp.equals("/")) {
                    stack.push(Integer.toString(a / b));
                }
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}
