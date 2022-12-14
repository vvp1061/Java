import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class string_calcultator {
        private String[] tokens;
        private int curIndx;

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Scanner in = new Scanner(bufferedReader);
            String expression = in.nextLine();


//        String expression = "   1+2.5*(3-4 +6/7+6";
            expression = expression.replaceAll("[\\s]+", "");
            String[] spitedExpression = expression.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])|(?=[()])|(?<=[()])");
            StringBuilder expressionBuilder = new StringBuilder();
            for (int i = 0; i < spitedExpression.length; i++) {
                expressionBuilder.append(spitedExpression[i] + " ");
            }
            String finalExpression = expressionBuilder.toString();
            System.out.println(finalExpression);

            string_calcultator calcultator = new string_calcultator(finalExpression);
            System.out.println(finalExpression + " = " + calcultator.calculate());
        }

    }
    public string_calcultator(String expression){
        this.tokens =  expression.split(" ");
        this.curIndx = 0;
    }

    public double calculate(){
        double first = multiplication_and_division();

        while (curIndx < tokens.length) {
            String oper = tokens[curIndx];
            if (!oper.equals("+") && !oper.equals("-")){
                break;
            } else {
                curIndx++;
            }

            double second = multiplication_and_division();
            if (oper.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    public double multiplication_and_division(){
        double first = mathBrakets();

        while (curIndx < tokens.length) {
            String oper = tokens[curIndx];
            if (!oper.equals("*") && !oper.equals("/")){
                break;
            } else {
                curIndx++;
            }

            double second = mathBrakets();
            if (oper.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    public double mathBrakets() {
        String next = tokens[curIndx];
        double result;
        if (next.equals("(")) {
            curIndx++;
            result = calculate();
            String closingBraket;
            if (curIndx < tokens.length) {
                closingBraket = tokens[curIndx];
            } else {
                throw new IllegalArgumentException("Неожиданный конец выражения");
//                System.out.print("Неожиданный конец выражения для: ");
//                return result;
            }
            if (closingBraket.equals(")")) {
                curIndx++;
                return result;
            }
//            System.out.print("Ожидалась )");
//             return result;
            throw new IllegalArgumentException("Ожидалось ')' , но встречено " + closingBraket);
        }
        curIndx++;
        return  Double.parseDouble(next);
    }

}
