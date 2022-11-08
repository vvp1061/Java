//Дана строка, содержащая зашифрованный текст. Каждая буква
//        заменяется на следующую за ней (буква я заменяется на а). Получить
//                в новой строке расшифровку данного текста.
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream user_input = System.in;
            Reader inputStreamReader = new InputStreamReader(user_input);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = bufferedReader.readLine();
            int j;
            for (int i = 0; i < str.length(); i++) {
                j = str.codePointAt(i);
                if (!Character.isWhitespace(j)) {
                    if (Character.isAlphabetic(j)) {

                        String Lang = String.valueOf(Character.UnicodeBlock.of(j));
                        String lower_upper = String.valueOf(Character.isLowerCase(j));

                        if (lower_upper == "true") {
                            if (Lang == "CYRILLIC") {
                                --j;
                                if (j == 1072) j = 1103;
                            }
                        }
                    }
                char c = (char) j;
                System.out.print(c);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}


