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
}
