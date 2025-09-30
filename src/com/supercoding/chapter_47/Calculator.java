package com.supercoding.chapter_47;

public class Calculator {
    public static void main(String[] args) {
        // 변수 선언 및 초기화
        int number1 = 0;
        int number2 = 0;
        char operator;

        try {
            // 숫자1 입력
            number1 = Integer.parseInt(args[0]);

            // 숫자2 입력
            number2 = Integer.parseInt(args[1]);

            // 연산자 입력
            operator = args[2].charAt(0);

            // calculate 메소드 호출
            int result = calculate(number1, number2, operator);

            // 결과 출력
            System.out.println("계산 결과: " + result);

        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
        } catch (InvalidOperatorException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예상치 못한 오류가 발생했습니다.");
        }
    }

    public static int calculate(int num1, int num2, char operator) throws DivideByZeroException, InvalidOperatorException {
        // 사칙연산 수행 및 예외 처리
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new DivideByZeroException("분모는 0이 될 수 없습니다.");
                }
                return num1 / num2;
            default:
                throw new InvalidOperatorException("사용할 수 없는 연산자입니다.");
        }
    }
}
