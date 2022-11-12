//Дана строка, содержащая зашифрованный текст. Каждая буква
//        заменяется на следующую за ней (буква я заменяется на а). Получить
//                в новой строке расшифровку данного текста.
import java.io.*;
import java.util.Objects;

public class lb_1_n_1 {
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

                        if (lower_upper.equals("true")) {
                            if (Objects.equals(Lang, "CYRILLIC")) {
                                if (j == 1072) j = 1103 + 1;
                                j--;
                            }
                            if (Objects.equals(Lang, "BASIC_LATIN")) {
                                if (j == 97) j = 122 + 1;
                                j--;
                            }
                        }
                        if (lower_upper.equals("false")) {
                           if (Objects.equals(Lang, "CYRILLIC")) {
                               if (j == 1040) j = 1071 + 1;
                               j--;
                           }

                           if (Objects.equals(Lang, "BASIC_LATIN")) {
                               if (j == 65) j = 90 + 1;
                               j--;
                           }

                        }
                    }
                }
                char c = (char) j;
                System.out.print(c);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
