package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		if (str.equals("'\r'")) {
			return '\r';
		} else if (str.equals("'\t'")) {
			return '\t';
		} else if (str.equals("'\b'")) {
			return '\b';
		} else if (str.equals("'\n'")) {
			return '\n';
		} else if (str.equals("'\f'")) {
			return '\f';
		} else if (str.charAt(1) == '\\' && Character.isDigit(str.charAt(2))) {
			return (char)Integer.parseInt(str.substring(2));
		}
		else return str.charAt(1);
	}



	
}
