//Даны две произвольные последовательности чисел. Рассматривая их
//как множества получить третью последовательность, которая
//является их пересечением.

import java.io.*;


public class lb_1_n_2 {
    public static void main(String[] args) {
        try {
            InputStream user_input = System.in;
            Reader inputStreamReader = new InputStreamReader(user_input);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String first_string = bufferedReader.readLine();
            String second_string = bufferedReader.readLine();
            StringBuilder third_string = new StringBuilder();



            for(int i = 0; i<first_string.length(); i++) {
                for(int j = 0; j < second_string.length(); j++) {
                    if(first_string.charAt(i) == second_string.charAt(j)) {
                        if (!third_string.toString().contains(first_string.charAt(i) + ""))
                            third_string.append(first_string.charAt(i)).append(" ");
                        break;
                    }
                }
            }
            System.out.println("Пересечение:" + third_string);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
