package com.devskiller.tasks.blog;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestIA {

	public static void main(String[] args) {
		 String s = " #$%^&*1234$%^^&   Inter….   view%^&^ ";

		Predicate<Integer> isAlphabeticOrDigit = p -> Character.isAlphabetic(p) || Character.isDigit(p);

		System.out.println(
			s.codePoints()
			 .filter(isAlphabeticOrDigit::test)
			 .mapToObj(c-> (char)c)
			 .map(Object::toString)
			 .collect(Collectors.joining())
		);

	}

}
