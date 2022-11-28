public class string_calcultator {
        private String[] tokens;
        private int curIndx;

    public static void main(String[] args) {
        String expression = "1 + 2 * ( 3 - 4 ) + 6 / 7 +";
        string_calcultator calcultator = new string_calcultator(expression);
        System.out.println(expression + " = " + calcultator.calculate());

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
            }
            if (closingBraket.equals(")")) {
                curIndx++;
                return result;
            }
            throw new IllegalArgumentException("Ожидалось ')' , но встречено " + closingBraket);
        }
        curIndx++;
        return  Double.parseDouble(next);
    }

}
