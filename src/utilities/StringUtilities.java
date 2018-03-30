package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

public class StringUtilities {

	public static String decodeFromUnicode(final String title) {
		
		System.out.println(title);
		
		Pattern pattern = Pattern.compile("u[0-9A-F]{4}");
		Matcher matcher = pattern.matcher(title);

		StringBuilder str = new StringBuilder(title);

		int startIndex = -1;
		int cnt = 0;
		while (matcher.find()) {
			startIndex = matcher.start();
			str.insert(startIndex + cnt, "\\");
			cnt++;
		}

		return StringEscapeUtils.unescapeHtml((StringEscapeUtils.unescapeJava(str.toString())));
	}

	public static String[] divideStringIntoNEqualPartsParts(final String str, final int parts) {
		String[] reviewParts = str.split("(?s)(?<=\\G.{" + parts + "})");
		return reviewParts;
	}

}
