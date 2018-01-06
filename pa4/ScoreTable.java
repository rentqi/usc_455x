//Name: Tianqi Ren
//USC NetID: tianqire
//CS 455 PA4
//Fall 2017

public class ScoreTable {
	private int[] map;
	private final int CAPACITY = 26;
	
	public ScoreTable() {
		map = new int[CAPACITY];
		//construct the map of scores
		constructMap();
	}
	
	/**
	 * calculate score for a single Character
	 * @param c the Character to be calculated
	 * @return score of c
	 */
	public int chPoints(Character c) {
		c = Character.toLowerCase(c);
		return map[c-'a'];
	}
	
	/**
	 * calculate score for a String
	 * @param s the String to be calculated
	 * @return score of s
	 */
	public int Strpoints(String s) {
		int sum = 0;
		for(int i=0;i<s.length();i++) {
			sum += chPoints(s.charAt(i));
		}
		return sum;
	}
	
	// a hard-coded values in ScoreTable
	private void constructMap() {
		map['a'-'a'] = 1;
		map['e'-'a'] = 1;
		map['i'-'a'] = 1;
		map['o'-'a'] = 1;
		map['u'-'a'] = 1;
		map['l'-'a'] = 1;
		map['n'-'a'] = 1;
		map['s'-'a'] = 1;
		map['t'-'a'] = 1;
		map['r'-'a'] = 1;
		map['d'-'a'] = 2;
		map['g'-'a'] = 2;
		map['b'-'a'] = 3;
		map['c'-'a'] = 3;
		map['m'-'a'] = 3;
		map['p'-'a'] = 3;
		map['f'-'a'] = 4;
		map['h'-'a'] = 4;
		map['v'-'a'] = 4;
		map['w'-'a'] = 4;
		map['y'-'a'] = 4;
		map['k'-'a'] = 5;
		map['j'-'a'] = 8;
		map['x'-'a'] = 8;
		map['q'-'a'] = 10;
		map['z'-'a'] = 10;
	}
}
