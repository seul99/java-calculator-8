package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()){
            return 0;
        }

        String[] numbers = input.split(",|:");

        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);

            sum += num;
        }
        return sum;
    }
}
