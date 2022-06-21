import java.io.*;
import java.util.*;

public class FileAnalyzer {

    public static final String NO_SIGN = "";
    public static final String REGEX_SENTENCE_ENDING = "(?<=[.!?])\\s*";
    public static final String REGEX_WORDS_SPACES = "[-.?!)(,:]";

    public String textFromFileToString(String path) throws IOException {
        File pathToFile = new File(path);
        InputStream inputStream = new FileInputStream(path);
        int fileLength = (int) pathToFile.length();
        byte[] contentArray = new byte[fileLength];
        inputStream.read(contentArray);
        return new String(contentArray);
    }

    public String[] separateTextToWords(String text) {
        return text.toLowerCase().replaceAll(REGEX_WORDS_SPACES, NO_SIGN).split("\\s");
    }

    public String[] separateTextToSentences(String text) {
        return text.split(REGEX_SENTENCE_ENDING);
    }

    public int countWordsInText(String text) {
        return separateTextToWords(text).length;
    }

    public int countSentencesInText(String text) {
        return separateTextToSentences(text).length;
    }

    public boolean isWordInText(String word, String text) {
        boolean result = false;
        String[] words = separateTextToWords(text);
        for (String s : words) {
            if (s.equals(word.toLowerCase())) {
                result = true;
            }
        }
        return result;
    }

    public List<String> searchSentenceWithWord(String word, String text) {
        List<String> result = new ArrayList<>();
        String[] sentences = separateTextToSentences(text);
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                result.add(sentence);
            }else{
                throw new NoSuchElementException("There is no word " + word + " in this text!");
            }
            break;
        }
        return result;
    }
}
