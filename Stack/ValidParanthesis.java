import java.util.Stack;

class Solution {
    
    /* Algorithm:
        1. Define a new stack 
        2. Scan the string and parse the brackets
        3. If we encounter an opening bracket, it means another bracket suppose to complete it. keep pushing into the stack
        4. If we encounter a closing bracket, check if the top item in the stack matches its reverse Bracket
        5. If it is not equal or if stack is empty , it means they are not balanced
        6. After parsing, if the stack is empty, the brackets are balanced

    */
    
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {

            char reverseBracket = getReverseBracket(ch);

            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if(stack.isEmpty() || stack.pop() != reverseBracket) {
                return false;
            }

        }

        return stack.isEmpty();        
    }

    public char getReverseBracket(char c) {
        switch(c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return '{';
        }
    }
}