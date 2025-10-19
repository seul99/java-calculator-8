package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {

        // 공백일경우 0 반환
        if (input == null || input.isEmpty()){
            return 0;
        }

        input = input.replace("\\n", "\n");

        // 기본 구분자
        String[] numbers = input.split(",|:");

//        int sum = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
             numbers= m.group(2).split(customDelimiter);
        }

        int sum = 0;
        for (String number : numbers){
            int num = Integer.parseInt(number);
            sum += num;
        }

        return sum;



    }
}
