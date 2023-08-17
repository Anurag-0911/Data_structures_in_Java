package Stack;

import java.util.Stack;

public class Infix_eval {
    static int solve(String str){
        Stack<Integer> val = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii <=57) val.push(ascii-48);
            else if (op.size()==0 || ch == '(' || op.peek()=='(') op.push(ch);
            else if(ch==')'){
                while(op.peek()!='('){
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '+') val.push(v1 + v2);
                    if (op.peek() == '-') val.push(v1 - v2);
                    if (op.peek() == '*') val.push(v1 * v2);
                    if (op.peek() == '/') val.push(v1 / v2);
                    op.pop();
                }
                op.pop();
            }
            else {
                if (ch == '+' || ch == '-') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '+') val.push(v1 + v2);
                    if (op.peek() == '-') val.push(v1 - v2);
                    if (op.peek() == '*') val.push(v1 * v2);
                    if (op.peek() == '/') val.push(v1 / v2);
                    op.pop();
                    op.push(ch);
                } else if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '*') val.push(v1 * v2);
                        if (op.peek() == '/') val.push(v1 / v2);
                        op.pop();
                        op.push(ch);
                    } else op.push(ch);
                }
            }
        }
        if(op.size()==0) return 0;
        while(val.size()>1){
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek() == '+') val.push(v1 + v2);
            if (op.peek() == '-') val.push(v1 - v2);
            if (op.peek() == '*') val.push(v1 * v2);
            if (op.peek() == '/') val.push(v1 / v2);
            op.pop();
        }
        return val.peek();
    }
    public static void main(String[] args) {
        String str = "1-(-2)";
        int res = solve(str);
        System.out.println(res);
    }
}
