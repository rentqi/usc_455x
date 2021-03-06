//Name: Tianqi Ren
//USC NetID: tianqire
//CS 455 PA4
//Fall 2017

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;


public class WordFinder {
	
	private static String filename = "";
	private static AnagramDictionary agmDic;
	private static Scanner in;
	private static String word;
	private static int[] mult;
	private static StringBuilder uniqueHelper;
	private static String unique;
	private static boolean exit = false;
	private static Rack rack;
	private static ArrayList<String> subsets;
	private static ScoreTable table;
	private static Map<String, Integer> scrabble;
	
	public static void main(String args[]) {
		//read file
		if(args == null || args.length == 0) {
			filename = "sowpods.txt";
		}else {
			filename = args[0];
		}
		
		//create AnagramDictionary and dictionary inside it
		try {
			agmDic = new AnagramDictionary(filename);
		}catch(FileNotFoundException e) {
			System.out.println(filename + " not found!");	//if the file does not exits, print error message and exit.
			return;		
		}
		
		//create rack and get all possible subsets
		System.out.println("Type . to quit.");
		while(!exit) {
			System.out.print("Rack?");
			in = new Scanner(System.in);
			word = in.next();
			if(word.equals(".")) {
				exit = true;
			}else {
				// using rack() to get all possible subsets
				createSubSets();
				
				// calculate the scores of words in dictionary
				calculateScore();
				
				// store the result and sort
				ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
				for(Map.Entry<String, Integer> ent:scrabble.entrySet()) {
					list.add(ent);
				}
				Collections.sort(list, new cmp());
				
				// show the result
				System.out.println("We can make "+list.size()+" words from "+"\""+word+"\"");
				if(list.size() > 0) {
					System.out.println("All of the words with their scores (sorted by score):");
				}
				for(Map.Entry<String, Integer> entry:list) {
					System.out.print(entry.getValue()+": ");
					System.out.println(entry.getKey());
				}
			}
		}
	}
	
	private static String sortStr(String str) {
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		return String.copyValueOf(ch);
	}
	
	/**
	 * a help function to create subsets
	 * word: sorted original input string
	 * mult: multiplicity of the char unique.charAt(i)
	 * uni: count the number of speicific character
	 * uniqueHelper: help to create the unique
	 * rack: Rack object using unique, mult to get subsets
	 * subsets: all possible subsets returned by Rack
	 */
	private static void createSubSets() {
		word = sortStr(word);
		mult = new int[word.length()];
		Map<Character, Integer> uni = new TreeMap<Character, Integer>();
		for(int i=0;i<word.length();i++) {
			if(uni.containsKey(word.charAt(i))) {
				uni.put(word.charAt(i), uni.get(word.charAt(i)) + 1);
			}else {
				uni.put(word.charAt(i), 1);
			}
		}
		uniqueHelper = new StringBuilder();
		int count=0;
		for(Character ch:uni.keySet()) {
			uniqueHelper.append(ch);
			mult[count] = uni.get(ch);
			count++;
		}
		unique = uniqueHelper.toString();
		rack = new Rack(unique, mult, 0);
		subsets = rack.getSubsets();
	}
	
	/**
	 * a help function to calculate scores
	 * table: contains the way to get scores
	 * scrabble: a map contains the word and corresponding scores
	 */
	private static void calculateScore() {
		table = new ScoreTable();
		scrabble = new TreeMap<String, Integer>();
		for(String words : subsets) {
			words = sortStr(words);
			ArrayList<String> agm = agmDic.getAnagramsOf(words);
			for(String s : agm) {
				scrabble.put(s, table.Strpoints(s));
			}
		}
	}
		
	/**
	 * achieve the order:
	 * decreasing order by score
	 * for words with same scrabble score, in alphabetical order
	 */
	public static class cmp implements Comparator<Map.Entry<String, Integer>>{
		//override compare
		public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
			if(m1.getValue() != m2.getValue()) {
				return m2.getValue() - m1.getValue();
			}
			return m1.getKey().compareTo(m2.getKey());
		}
	}
	
}
