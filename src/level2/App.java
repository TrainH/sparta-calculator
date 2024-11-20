package level2;
import java.util.Objects;
import java.util.Scanner;

// level2: 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기

// 요구사항 2. Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
public class App {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("1. 계산하기");
            System.out.println("[순서대로 양의 정수 2개(0포함)와 사칙연산 기호를 입력하세요]");

            System.out.print("  첫번째 양의 정수: ");
            int integer1 = sc.nextInt();

            System.out.print("  두번째 양의 정수: ");
            int integer2 = sc.nextInt();

            sc.nextLine();

            System.out.print("  사칙연산 기호(+, -, ×, ÷): ");
            char operator = sc.next().charAt(0);

            System.out.println("----------------------------------------------------------------------");
            System.out.println("2. 계산결과");
            if (!calculator.calculate(operator, integer1, integer2)) { // 잘못된 연산처리일때 while문 탈출 해서 다시 시도
                continue;
            }

            System.out.println("----------------------------------------------------------------------");
            System.out.println("3. 계산 결과 조회");

            System.out.println("    컬랙션에 저장된 계산결과(최근): " + calculator.getResult());
            System.out.println("    컬랙션에 저장된 계산결과들: " + calculator.getResults());

            System.out.println("----------------------------------------------------------------------");

            System.out.println("4. 계산 결과 삭제");

            System.out.println("    저장된 연산결과를 제거하려면 True 를 입력하고 아니면 아무값을 입력하세요 \n    (가장 처음에 저장된 결과 값부터 제거됩니다.)");
            String delCheck = sc.next();
            if (Objects.equals(delCheck, "True")) {
                calculator.removeResult();
                System.out.println("    컬랙션에 저장된 계산결과들: " + calculator.getResults());
            }

            System.out.println("----------------------------------------------------------------------");
            System.out.println("* 계산기 계속 여부");
            System.out.println("    더 계산하시려면 아무 값을 입력하세요. (단, exit 입력 시 종료)");
            String exit = sc.next();
            if (Objects.equals(exit, "exit")) {
                break;
            } else {
                System.out.println("    다시 계산합니다. (입력 문자열: " + exit + ")");
                System.out.println("----------------------------------------------------------------------");
            }
        }


        System.out.println("계산기가 종료되었습니다.");
        sc.close();
    }
}