// Package 
package GUI;

// Main class
public class MathBox {
	private int pos = -1;
	private int ch;

	public MathBox() {
		// Empty
	}
	
	private void nextChar(String str) {
		ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	}
	
	private boolean eat(String str, int charToEat)
	{
		while(ch == ' ') nextChar(str);
		if(ch == charToEat)
		{
			nextChar(str);
			return true;	
		}
		return false;
	}
	
	public double parse(String str) {
		nextChar(str);
		double x = parseExpression(str);
		if(pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
		return x;
	}
	
	private double parseExpression(String str)
	{
		double x = parseTerm(str);
		for(;;)
		{
			if (eat(str, '+')) x += parseTerm(str);
			else if (eat(str, '-')) x -= parseTerm(str);
			else return x;
		}
	}
	
	private double parseTerm(String str)
	{
		double x = parseFactor(str);
		for(;;)
		{
			if (eat(str, '*')) x *= parseTerm(str);
			else if (eat(str, '/')) x /= parseTerm(str);
			else return x;
		}
	}
	
	private double parseFactor(String str)
	{
		if(eat(str, '+')) return parseFactor(str);
		if(eat(str, '-')) return -parseFactor(str);
		
		double x;
		int startpos = this.pos;
		if(eat(str, '('))
		{
			x = parseExpression(str);
			eat(str, ')');
		} else if ((ch >= '0' && ch <= '9') || ch == '.') {
			while ((ch >= '0' && ch <= '9') || ch == '.') nextChar(str);
			x = Double.parseDouble(str.substring(startpos, this.pos));
		} else {
			throw new RuntimeException("Unexpected : " + (char) ch);
		}
		
		return x;
	}
}
