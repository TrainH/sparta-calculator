package level1;
import java.util.Scanner;

// level1 : 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[양의 정수 2개(0포함)를 입력하세요.]");

            System.out.println("첫번째 양의 정수 : ");
            int integer1 = sc.nextInt();
            System.out.println("두번째 양의 정수 : ");
            int integer2 = sc.nextInt();

            sc.nextLine();

            System.out.println("사칙연산 기호를 정확하게 입력하세요. (+, -, ×, ÷)");

//    char letter = sc.nextLine().charAt(0); //  어려웠던점: sc을 사용해서 그런지 계속오류가 발생함 -> sc2를 선언함
            char letter = sc.nextLine().charAt(0);
            System.out.println("-------------------------------");
            switch (letter) {
                case '+':
                    System.out.println("결과: " + integer1 + " + " + integer2 + " = " + (integer1 + integer2));
                    break;
                case '-':
                    System.out.println("결과: " + integer1 + " - " + integer2 + " = " + (integer1 - integer2));
                    break;
                case '×':
                    System.out.println("결과: " + integer1 + " × " + integer2 + " = " + (integer1 * integer2));
                    break;
                case '÷':
                    if (integer2 == 0){
                        System.out.println("나눗셈에서 두번째 정수로 0이 올 수 없습니다. 다시 처음부터 입력해주세요. (분모가 0이 오면 무한대 입니다.)");
                        break;
                    }
                    System.out.println("결과: " + integer1 + " ÷ " + integer2 + " = " + (integer1 / integer2));
                    break;
                default:
                    System.out.println("입력된 기호는 " + letter + " 입니다. 사칙연산 기호를 다시 입력해주세요.");
                    break;
            }
            System.out.println("-------------------------------");
            System.out.println("더 계산하시려면 아무키를 입력하세요. (단, exit 입력 시 종료)");

            String exit = sc.nextLine();
            // 어려운점2: exit == "exit" -> Objects.equals(exit, "exit")
            if (exit.equals("exit")) {
                break;
            } else {
                System.out.println();
                System.out.println("다시계산합니다" + "(입력 문자열: "+ exit + ")");
                System.out.println();
            }
        }
        sc.close();
        System.out.println("계산기가 종료되었습니다.");
    }

}