import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        Stack<Double> operandsStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();
        String expression;
        int index = 0;
        char character;
        String digit;
        double operandA;
        double operandB;
        char operator;
        double result = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an arithmetic expression: ");
        expression = scanner.nextLine();

        while (index < expression.length())
        {
            character = expression.charAt(index);

            if (character == '+' || character == '-' || character == '*' || character == '/')
            {
                operatorsStack.push(character);
            }

            else if (Character.isDigit(character))
            {
                digit = String.valueOf(character);

                while (index+1 < expression.length() && (Character.isDigit(expression.charAt(index+1)) || expression.charAt(index+1) == '.'))
                {
                    index++;
                    digit = digit + expression.charAt(index);
                }

                operandsStack.push(Double.parseDouble(digit));
            }

            else if (character == ')')
            {
                operandB = operandsStack.pop();
                operandA = operandsStack.pop();
                operator = operatorsStack.pop();

                switch (operator)
                {
                    case '+':
                        result = operandA + operandB;
                        break;

                    case '-':
                        result = operandA - operandB;
                        break;

                    case '*':
                        result = operandA * operandB;
                        break;

                    case '/':
                        result = operandA / operandB;
                        break;
                }
                operandsStack.push(result);
            }
            index++;
        }
        System.out.println(operandsStack.pop());
    }
}