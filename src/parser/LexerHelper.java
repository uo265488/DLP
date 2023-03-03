package parser;

import ast.expression.Arithmetic;
import ast.expression.Expression;
import ast.expression.Modulus;

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

	public static Expression getArithmeticOrModulus
			(int line, int col, Expression leftOp, String operator, Expression rightOp) {

		return operator.equals("%")
				? new Modulus(line, col, leftOp, rightOp)
				: new Arithmetic(line, col, leftOp, operator, rightOp);

	}



	
}
