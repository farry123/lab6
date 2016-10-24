import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import who.FileWordCounter;

public class FileWordCounter {
	
	
	public static final int END_OF_FILE = -1;
	
	/**
	 * Matches:
	 * - 1 or more unicode letters or digits
	 */
	private static final Pattern COUNTABLE_WORD_PATTERN = Pattern.compile("[\\p{L}0-9]+");
	
	/**
	 * Matches:
	 * - 1 or more unicode letters
	 */
	private static final Pattern NON_DIGIT_COUNTABLE_WORD_PATTERN = Pattern.compile("[\\p{L}]+");
	
	/**
	 * Counts characters strings which includes letter strings.
	 * Does not accept e.g. "???" as word, but "??Ice>>" will be counted.
	 * Additionally strings like: "ddd%ff#222" or "ice-cream" will be counted as 3 and 2 words.
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static int count(String path, Pattern pattern) throws IOException {
		int buffer = -1;
		int wordsCount = 0;
		InputStreamReader inputStream = new InputStreamReader(new FileInputStream(new File(path)), Charset.forName("UTF-8"));
		StringBuilder stringBuilder = new StringBuilder();
		Matcher matcher;
		while (true) {
			buffer = inputStream.read();
			if (!Character.isWhitespace(buffer) && buffer != END_OF_FILE) {
				stringBuilder.append((char) buffer);
			} else {
				matcher = pattern.matcher(stringBuilder.toString());
				while (matcher.find()) {
					System.out.println(matcher.group(0));
					++wordsCount;
				}
				stringBuilder.setLength(0);
			}
			if (buffer == END_OF_FILE) {
				break;
			}
		}
		inputStream.close();
		return wordsCount;
	}
	
	/**
	 * Ignores the fact that strings of punctuation marks arent words.
	 * Counts only strings between white characters.
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static int simpleCount(String path) throws IOException {
		int prevBuffer = 'A'; //non white space
		int buffer = -1; //EOF
		int wordsCount = 0;
		
		InputStreamReader inputStream = new InputStreamReader(new FileInputStream(new File(path)), Charset.forName("UTF-8"));
		while (true) {
			buffer = inputStream.read();
			if (Character.isWhitespace(buffer) && !Character.isWhitespace(prevBuffer)) {
				++wordsCount;
			}
			if (buffer == END_OF_FILE) {
				if (!Character.isWhitespace(prevBuffer)) {
					++wordsCount;
				}
				break;
			}
			prevBuffer = buffer;
		}
		inputStream.close();
		return wordsCount;
	}
	
	public static void main(String[] args) throws IOException {
		String filePath = "<PATH_HERE>";
		long before = System.currentTimeMillis();
		System.out.println("Digit/Word Count: " + count(filePath, FileWordCounter.COUNTABLE_WORD_PATTERN));
		System.out.println("Time Count: " + (System.currentTimeMillis() - before));
		System.out.println("--------------------------------------------");
		before = System.currentTimeMillis();
		System.out.println("Word Count: " + count(filePath, FileWordCounter.NON_DIGIT_COUNTABLE_WORD_PATTERN));
		System.out.println("Time Count: " + (System.currentTimeMillis() - before));
		System.out.println("--------------------------------------------");
		before = System.currentTimeMillis();
		System.out.println("SimpleCount: " + simpleCount(filePath));
		System.out.println("Time SimpleCount: " + (System.currentTimeMillis() - before));
	}

}
