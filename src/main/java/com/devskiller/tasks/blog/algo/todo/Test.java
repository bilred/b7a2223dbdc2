package com.devskiller.tasks.blog.algo.todo;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		 String s = " #$%^&*1234$%^^&   Inter….   view%^&^ ";

		Predicate<Integer> isAlphabeticOrDigit = p -> Character.isAlphabetic(p) || Character.isDigit(p);

		System.out.println(s.codePoints()
			 .filter(isAlphabeticOrDigit::test)
			 .mapToObj(c-> (char)c)
			 .map(Object::toString)
			 .collect(Collectors.joining()));

	}





//	public static String rearrangeString(String s) {
//		Map<Character, Long> frequencyMap = s.chars()
//			.mapToObj(c -> (char) c)
//			.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//
//		StringBuilder result = new StringBuilder();
//		while (!frequencyMap.isEmpty()) {
//			Character next = frequencyMap.entrySet().stream()
//				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//				.filter(e -> result.length() < 2 || e.getKey() != result.charAt(result.length() - 1))
//				.map(Map.Entry::getKey)
//				.findFirst().orElse(null);
//
//			if (next == null) {
//				return "";
//			}
//
//			result.append(next);
//			frequencyMap.put(next, frequencyMap.get(next) - 1);
//			frequencyMap.entrySet().removeIf(e -> e.getValue() == 0);
//		}
//
//		return result.toString();
//	}
//
//	public Boolean isAnagrams(String s1, String s2) {
//		char[] charsS1 = s1.toCharArray();
//		char[] charsS2 = s2.toCharArray();
//
//		Arrays.sort(charsS1);
//		Arrays.sort(charsS2);
//
//		return Arrays.equals(charsS1, charsS2);
//	}

//Given a string s, rearrange the characters of s so that any
// two adjacent characters are not the same.Return any possible
// rearrangement of s or return "" if not possible.
//
//Example 1:
//Input: s = "aab"
//Output: "aba"
//
//Example 2:
//Input: s = "aaab"
//Output: "


}
