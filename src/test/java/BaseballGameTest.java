import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    public static String answer = "";

    @BeforeEach
    public void setUp() {
        answer = "713";
    }

    @Test
    public void solution() {
//        Scanner scanner = new Scanner(System.in);
//        String num = scanner.nextLine();
        System.out.println(check("123"));
        System.out.println(check("145"));
        System.out.println(check("671"));
        System.out.println(check("216"));
        System.out.println(check("713"));

    }

    private String check(String num) {
        String[] split = num.split("");
        int ballCnt = countBall(split);
        int strikeCnt = countStrike(split);

        String result = "";
        if (ballCnt > 0) {
            result += (ballCnt + "볼 ");
        }
        if (strikeCnt > 0) {
            result += (strikeCnt + "스트라이크");
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            result += "nothing";
        }
        return result.trim();
    }

    private int countBall(String[] split) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            String s = split[i];
            cnt += answer.contains(s) && !String.valueOf(answer.charAt(i)).equals(s) ? 1 : 0;
        }
        return cnt;
    }

    private int countStrike(String[] split) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            String s = split[i];
            cnt += String.valueOf(answer.charAt(i)).equals(s) ? 1 : 0;
        }
        return cnt;
    }
}