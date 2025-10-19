package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {

        // 공백일경우 0 반환
        if (input == null || input.isEmpty()){
            return 0;
        }

        // 문자 입력 시 줄바꿈
        input = input.replace("\\n", "\n");

        // 기본 구분자
        String[] numbers = input.split(",|:");


        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
             numbers= m.group(2).split(Pattern.quote(customDelimiter));
        }

        //덧셈기능 구현
        int sum = 0;
        for (String n : numbers){
            n = n.trim();

            //숫자인지 검사
            if (!n.matches("-?\\d+")){
                throw new IllegalArgumentException("입력된 값은 숫자가 아닙니다." + n);
            }


            int num = Integer.parseInt(n);

            if (num < 0){
                throw new IllegalArgumentException("음수는 입력이 불가합니다." + n);
            }
            sum += num;
        }

        return sum;



    }
}
