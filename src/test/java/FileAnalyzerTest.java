import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileAnalyzerTest {

    FileAnalyzer fileAnalyzer = new FileAnalyzer();

    @Test
    @DisplayName("TEST: EXTRACTING TEXT FROM FILE")
    void testTextFromFileToString() throws IOException {
        String expected = "An Array is an essential and most used data structure in Java.";
        String actual = fileAnalyzer.textFromFileToString("text.txt");
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TEST: SEPARATING TEXT TO WORDS")
    void testSeparateTextToWords() throws IOException {
        String text = fileAnalyzer.textFromFileToString("text.txt");
        String[] expected = {"an", "array", "is", "an", "essential", "and", "most", "used", "data", "structure", "in", "java"};
        String[] actual = fileAnalyzer.separateTextToWords(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("TEST: SEPARATING TEXT TO SENTENCES")
    void testSeparateTextToSentences() throws IOException {
        String text = fileAnalyzer.textFromFileToString("text1.txt");
        String[] expected = {
                "An Array is an essential and most used data structure in Java.",
                "It is one of the most used data structure by programmers due to its efficient and productive nature!",
                "The Array is a collection of similar data type elements?",
                "It uses a contiguous memory location to store the elements."
        };
        String[] actual = fileAnalyzer.separateTextToSentences(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("TEST: COUNT WORDS IN TEXT")
    void testCountWordsInText() throws IOException {
        String text = fileAnalyzer.textFromFileToString("text.txt");
        int expected = 12;
        int actual = fileAnalyzer.countWordsInText(text);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TEST: COUNT SENTENCES IN TEXT")
    void testCountSentencesInText() throws IOException {
        String text = fileAnalyzer.textFromFileToString("text1.txt");
        int expected = 4;
        int actual = fileAnalyzer.countSentencesInText(text);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TEST: IS PARTICULAR WORD IN THIS TEXT RETURNS TRUE")
    void testIsWorldInTextReturnsTrue() throws IOException {
        String text = fileAnalyzer.textFromFileToString("text1.txt");
        String word = "Java";
        assertTrue(fileAnalyzer.isWordInText(word, text));
    }

    @Test
    @DisplayName("TEST: SEARCH SENTENCE WITH PARTICULAR WORD")
    void tetsSearchSentenceWithWord() throws IOException {
        String text = fileAnalyzer.textFromFileToString("text1.txt");
        String word = "Java";
        List <String> expected = new ArrayList<>();
        expected.add("An Array is an essential and most used data structure in Java.");
        List<String> actual = fileAnalyzer.searchSentenceWithWord(word,text);
    }

}
