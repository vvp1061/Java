import java.io.*;
import java.util.Stack;

public class lab_2_task_1 {
    public static void main(String[] args) throws IOException {

            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            StreamTokenizer sTok = new StreamTokenizer(bReader);
            Stack<Integer> stack = new Stack<Integer>();
            int currentToken = sTok.nextToken();

            sTok.ordinaryChar('/');
            sTok.ordinaryChar('.');

            while (sTok.ttype != StreamTokenizer.TT_EOF) {
                if (sTok.ttype == StreamTokenizer.TT_NUMBER) {
                   stack.push((int) sTok.nval);
                }
                if (stack.size() > 1) {

                    int signa;
                    int last;
                    switch (sTok.ttype){
                        case 42:
                            signa = stack.pop() * stack.pop();
                            stack.push(signa);
                            System.out.println(stack.peek());
                            break;
                        case 43:
                            signa = stack.pop() + stack.pop();
                            stack.push(signa);
                            System.out.println(stack.peek());
                            break;
                        case 45:
                            last = stack.pop();
                            signa = stack.pop() - last;
                            stack.push(signa);
                            System.out.println(stack.peek());
                            break;
                        case 46:
                            System.out.println(stack.peek());
                            break;
                        case 47:
                            try {
                                last = stack.pop();
                                signa = stack.pop() / last;
                                stack.push(signa);
                                System.out.println(stack.peek());
                            } catch (ArithmeticException e) {
                                System.out.println(
                                        "Деление на 0 невозможно");
                            }
                    }
                }
                currentToken = sTok.nextToken();
            }
            stack.removeAllElements();
    }
}
