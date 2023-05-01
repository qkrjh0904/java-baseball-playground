package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String s = "1,2";
        String[] split = s.split(",");
        assertThat(split).contains("1", "2");
        assertThat(split).containsExactly("1", "2");

        s = "1";
        split = s.split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");
    }

    @Test
    void replaceAndSplit() {
        String s = "(1,2)";
        s = s.replace("(", "");
        s = s.replace(")", "");
        assertThat(s).isEqualTo("1,2");

        String[] split = s.split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            String s = "abc";
            s.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void calculator() {
//        Scanner scanner = new Scanner(System.in);
//        String value = scanner.nextLine();
        String value = "2 + 3 * 4 / 2";
        assertThat(calculate(value)).isEqualTo(10);

    }

    private int calculate(String value) {
        String[] values = value.split(" ");
        int num = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            String operation = values[i];
            int tmp = Integer.parseInt(values[i + 1]);
            if (operation.equals("+")) {
                num += tmp;
            }
            if (operation.equals("-")) {
                num -= tmp;
            }
            if (operation.equals("*")) {
                num *= tmp;
            }
            if (operation.equals("/")) {
                num /= tmp;
            }
        }
        return num;
    }
}
