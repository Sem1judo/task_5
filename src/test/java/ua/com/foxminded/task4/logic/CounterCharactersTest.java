package ua.com.foxminded.task4.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CounterCharactersTest {
    private CounterCharacters counter;

    @BeforeEach
    void init() {
        counter = new CounterCharacters();
    }

    @Test
    void getCountedCharactersShouldThrowExceptionWhenInputIsNull() {
        assertThrows(NullPointerException.class, () -> counter.getCountedCharacters(null));
    }

    @Test
    void getCountedCharactersShouldReturnEmptyStringWhenInputIsEmptyString() {
        String expected = "";
        String actual = counter.getCountedCharacters("");
        assertEquals(expected, actual);
    }

    @Test
    void getCountedCharactersShouldReturnQuantitySpaceWhenInputSeveralSpaces() {
        String expected = "' ' - 3";
        String actual = counter.getCountedCharacters("   ");
        assertEquals(expected, actual);
    }

    @Test
    void getCountedCharactersShouldCountWhenInputOnlyNonLetters() {
        String expected = "'1' - 3\n" +
                "'&' - 1\n" +
                "'0' - 2\n" +
                "'4' - 1\n" +
                "'@' - 1\n" +
                "'$' - 1\n" +
                "'_' - 1\n" +
                "'-' - 1\n" +
                "'*' - 1\n" +
                "'2' - 2\n" +
                "'5' - 1";
        String actual = counter.getCountedCharacters("1&04@$_0-*12512");
        assertEquals(expected, actual);
    }

    @Test
    void getCountedCharactersShouldCountWhenInputOnlyNonLettersAndSpaces() {
        String expected = "'1' - 3\n" +
                "' ' - 5\n" +
                "'&' - 1\n" +
                "'0' - 2\n" +
                "'4' - 1\n" +
                "'@' - 1\n" +
                "'$' - 1\n" +
                "'_' - 1\n" +
                "'-' - 1\n" +
                "'*' - 1\n" +
                "'2' - 2\n" +
                "'5' - 1";
        String actual = counter.getCountedCharacters("1 &04 @$_0-*125 1 2 ");
        assertEquals(expected, actual);
    }

    @Test
    void getCountedCharactersShouldCountWhenInputOneLetter() {
        String expected = "'q' - 1";
        String actual = counter.getCountedCharacters("q");
        assertEquals(expected, actual);
    }

    @Test
    void getCountedCharactersShouldCountWhenInputOneLetterManyTimes() {
        String expected = "'q' - 31";
        String actual = counter.getCountedCharacters("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        assertEquals(expected, actual);
    }

    @Test
    void getCountedCharactersShouldCountWhenInputDifferentCases() {
        String expected = "'B' - 4\n" +
                "'a' - 6\n" +
                "'A' - 3\n" +
                "'b' - 5";
        String actual = counter.getCountedCharacters("BaAaAaAaBbBbBbbaba");
        assertEquals(expected, actual);
    }

    @Test
    void getCountedCharactersShouldCountWhenInputSeveralWordsAndSymbols() {
        String expected = "'L' - 1\n" +
                "'o' - 1\n" +
                "'r' - 1\n" +
                "'e' - 1\n" +
                "'m' - 3\n" +
                "' ' - 12\n" +
                "'i' - 1\n" +
                "'n' - 3\n" +
                "'s' - 13\n" +
                "'p' - 1\n" +
                "'u' - 1\n" +
                "'f' - 8\n" +
                "'k' - 12\n" +
                "'j' - 7\n" +
                "'d' - 11\n" +
                "'1' - 2\n" +
                "'2' - 2\n" +
                "'3' - 1\n" +
                "'4' - 1\n" +
                "'a' - 4\n" +
                "'h' - 1\n" +
                "'g' - 1\n" +
                "'w' - 1\n" +
                "';' - 1\n" +
                "'b' - 1\n" +
                "'&' - 1";
        String actual =
                counter.getCountedCharacters("Lorem inspum fk jsdf sd1kf2jds kfsdk fsdkjk3sdjfks 4askjh gjf 1ws2dfd;sdm kn kdbaks &ksajnda");
        assertEquals(expected, actual);
    }
}

