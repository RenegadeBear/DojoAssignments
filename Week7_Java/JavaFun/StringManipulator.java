
public class StringManipulator {

	public String trimAndConcat(String a, String b) {
		String c = a.replaceAll("\\s+", "") + b.replaceAll("\\s+", "");
		return c;
	}

	public Integer getIndexOrNull(String z, char letter) {
//		System.out.println(letter);
		for (int i=0; i<z.length(); i++) {
//			System.out.println(z.charAt(i));
			if (z.charAt(i) == letter) {
				return i;
			}
		}
		return null;
	}
	public Integer getIndexOrNull(String word, String subString) {
		boolean isPresent = word.indexOf(subString) != -1 ? true:false;
		if (isPresent) {
			return word.indexOf(subString);
		}
		return null;
	}
	public String concatSubstring(String a2, int start, int end, String b2) {
		String new_word = a2.substring(start,end)+b2;
		return new_word;
	}
}
