package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] computerNumber = generateNumbers(); // 조건 1: 중복 없는 3개 난수 생성
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("=== 숫자 야구 게임 시작 ===");
        System.out.println("중복되지 않는 1~9 사이 숫자 3개를 맞춰보세요."); // 조건 2: 난수는 비공개

        while (true) {
            System.out.print("숫자 3개를 입력하세요 (예: 123): ");
            String input = scanner.next();

            if (!isValidInput(input)) {
                System.out.println("잘못된 입력입니다. 중복되지 않는 1~9 숫자 3개를 입력하세요.");
                continue;
            }

            int[] userNumber = new int[3];
            for (int i = 0; i < 3; i++) {
                userNumber[i] = input.charAt(i) - '0';
            }

            attempts++;
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (userNumber[i] == computerNumber[j]) {
                        if (i == j) {
                            strike++; // 조건 3: 위치까지 같으면 Strike
                        } else {
                            ball++;   // 조건 4: 숫자는 같지만 위치가 다르면 Ball
                        }
                    }
                }
            }

            System.out.println(strike + " Strike, " + ball + " Ball");

            if (strike == 3) { // 조건 5: 3 Strike면 게임 종료
                System.out.println("3 Strike! 정답을 맞추셨습니다. (시도 횟수: " + attempts + ")");
                break;
            }
        }

        scanner.close();
    }

    // 중복 없는 1~9 사이 숫자 3개 생성
    private static int[] generateNumbers() {
        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            numbers.add(random.nextInt(9) + 1);
        }

        int[] result = new int[3];
        int index = 0;
        for (int n : numbers) {
            result[index++] = n;
        }

        return result;
    }

    // 입력값이 1~9 사이, 중복 없는 3자리 숫자인지 검증
    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        HashSet<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
            if (!seen.add(c)) {
                return false;
            }
        }

        return true;
    }
}