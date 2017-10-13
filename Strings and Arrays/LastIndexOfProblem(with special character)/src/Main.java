
public class Main {
	
	/* Program takes in two strings, string x and string y. 
	 * String x must always be longer than string y, and can
	 * be up to 10,000,000 characters long. 
	 * 
	 * String y must not be null, and must be no longer than 20,000 characters.
	 * 
	 * Program finds and returns the last index of the FIRST CHARACTER of string y inside of string x if
	 * string y is in string x. 
	 * 
	 * There is also a possibility of a wildcard character '*' inside of string x, which can count for any
	 * letter, and will be counted as a match for any character in string y.
	 * 
	 * */
	
	public static void main(String[] args) {
		// answer is 6
		String x = "poopoopachoo";
		String y = "pachoo";
		System.out.println(LastIndexOfWithWildCard(x, y));
		
		// answer is 6
		x = "poopoopa*h*o";
		y = "pachoo";
		System.out.println(LastIndexOfWithWildCard(x, y));
		
		// answer is 10
		x = "poopoopapa******";
		y = "pachoo";
		System.out.println(LastIndexOfWithWildCard(x, y));
		
		// answer is -1
		x = "sdf*fffffff";
		y = "aaa";
		System.out.println(LastIndexOfWithWildCard(x, y));
		
		// answer is 2
		x = "sd*fffffff";
		y = "efff";
		System.out.println(LastIndexOfWithWildCard(x, y));
		
		// answer is 2
		x = "sd*fffffff";
		y = "ef";
		System.out.println(LastIndexOfWithWildCard(x, y));
		
		// answer is 6
		x = "11111154321";
		y = "54321";
		System.out.println(LastIndexOfWithWildCard(x, y));
	}
	
	public static int LastIndexOfWithWildCard(String x, String y) {
		if (   y != null
			&& x != null
			&& y.length() >= 1
			&& y.length() <= 20000
			&& x.length() > y.length()
			&& x.length() <= 10000000 ) 
		{
			if (x.contains(y) || x.contains("*")) {
				return FindLastIndex(x, y);
			}
			
			else if (x.contains(y) && !x.contains("*")) {
				return x.lastIndexOf(y);
			}
			
			else { return -1; }
		}
		return -1;
	}
	
	public static int FindLastIndex(String x, String y) {
		x = x.toLowerCase();
		y = y.toLowerCase();
		int characterMatches;
		int i;
		int j;
		boolean isMatched;
		// x = sd*fffffff
		// y = ef
		for (i = x.length() - 1; i >= 0; i--) {
			characterMatches = 0;
			j = y.length() - 1;
			
			while (j >= 0) {
				isMatched = (x.charAt(i) == y.charAt(j) || x.charAt(i) == '*'); 
				if (isMatched) {
					characterMatches++;
				}
				if (characterMatches == y.length()) {
					return i;
				}
				if (!isMatched && (i + (characterMatches)) >= y.length()) {
					i = i + characterMatches;
					characterMatches = 0;
					j = -1;
				}
				if (!isMatched && (i + (characterMatches)) < y.length()) {
					return -1;
				}
				j--;
				i--;
			}
		}
		return -1;
	}
}
