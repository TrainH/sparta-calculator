package level2;
import java.util.LinkedList;
import java.util.Queue;


// 요구사항1. 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성

public class Calculator {
    private final Queue<Double> results = new LinkedList<>(); // collection 타입 필드
    private double result;


    public Calculator() {} // 기본 생성자


    // (1-1) 사칙연산을 수행하고 결과를 반환하는 메서드 구현
    public boolean calculate(char operator, int integer1, int integer2) {
        this.result = 0;

        switch (operator) {
            case '+':
                result = integer1 + integer2;
                break;
            case '-':
                result = integer1 - integer2;
                break;
            case '×':
                result = integer1 * integer2;
                break;
            case '÷':
                if (integer2 == 0) {
                    System.out.println("* 0으로 나눌 수 없습니다. 다시 시도해주세요.");
                    return false; // 잘못된 연산자 처리 일때 false로 반환
                }
                result = (double) integer1 / integer2;
                break;
            default:
                System.out.println("* 잘못된 연산자를 입력하셨습니다. 다시 시도해주세요.");
                return false; // 잘못된 연산자 처리 일때 알려줌
        }

        System.out.println("    (계산식) " + integer1 + " " + operator + " " + integer2 + " = " + result);

        // (1-2) 컬렉션 타입에 연산 결과를 저장
        this.setResult(result);
        return true;
    }


    // 요구사항 3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
    // (3-1) 연산 결과를 저장하는 메서드
    private void setResult(double result) {
        this.results.offer(result);
    }

    // (3-2) 최근 연산 결과를 조회하는 메서드
    public double getResult() {
        return this.result;
    }

    // (3-3) 연산 결과들을 조회하는 메서드
    public Queue<Double> getResults() {
        return this.results;
    }

    // (3-4) 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 메서드
    public void removeResult() {
        if (!this.results.isEmpty()) {
            System.out.println("    삭제된 결과: " + this.results.poll());
        } else {
            System.out.println("저장된 결과가 없습니다.");
        }
    }
}