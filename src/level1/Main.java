package level1;
import java.util.Scanner;

// level1 : 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------------------------------------------------");
            // 요구사항1. 양의 정수(0 포함)를 입력받기
            System.out.println("[양의 정수 2개(0포함)를 입력하세요.]");

            System.out.println("첫번째 양의 정수 : ");
            int integer1 = sc.nextInt();
            System.out.println("두번째 양의 정수 : ");
            int integer2 = sc.nextInt();

            sc.nextLine();

            // 요구사항2. 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
            System.out.println("사칙연산 기호를 정확하게 입력하세요. (+, -, ×, ÷)");

            char operator = sc.nextLine().charAt(0);

            // 요구사항3. 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
            // 요구사항4. 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기

            System.out.println("--------------------------------------------------------------");
            switch (operator) {
                case '+':
                    System.out.println("결과: " + integer1 + " + " + integer2 + " = " + ((double)integer1 + (double)integer2));
                    break;
                case '-':
                    System.out.println("결과: " + integer1 + " - " + integer2 + " = " + ((double)integer1 - (double)integer2));
                    break;
                case '×':
                    System.out.println("결과: " + integer1 + " × " + integer2 + " = " + ((double)integer1 * (double)integer2));
                    break;
                case '÷':
                    if (integer2 == 0){
                        System.out.println("나눗셈에서 두번째 정수로 0이 올 수 없습니다. 다시 처음부터 입력해주세요. (분모가 0이 오면 무한대 입니다.)");
                        break;
                    }
                    System.out.println("결과: " + integer1 + " ÷ " + integer2 + " = " + ((double)integer1 / (double)integer2));
                    break;
                default:
                    System.out.println("입력된 기호는 " + operator + " 입니다. 사칙연산 기호를 다시 입력해주세요.");
                    break;
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("더 계산하시려면 아무키를 입력하세요. (단, exit 입력 시 종료)");

            String exit = sc.nextLine();

            if (exit.equals("exit")) {
                break;
            } else {
                System.out.println("다시계산합니다" + "(입력 문자열: "+ exit + ")");
                System.out.println("--------------------------------------------------------------");
            }
        }
        sc.close();
        System.out.println("계산기가 종료되었습니다.");
    }

}