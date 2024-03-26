package com.devskiller.tasks.blog.algo.todo;

import java.util.Arrays;
import java.util.Objects;

public class MoveZero {
	public static void main(String[] args) {
		int[] array = {0, 1, 0, 2, 1, 0, 3};
		System.out.println("Array before sorting: " + Arrays.toString(array));
		moveZero(array);
		System.out.println("Array after sorting: " + Arrays.toString(array));

		String string = "0102103";
		System.out.println("String before sorting: " + string);
		System.out.println("String after sorting: " + moveZero(string));
	}

	private static String moveZero(String array) {
		char[] chars = array.toCharArray();
		int n = chars.length;

		int j = 0;
		for (int i =0; i<n; i++) {
			System.out.println("ahead "+i+"chars[i]="+chars[i]);
			System.out.println("ahead "+j+"chars[j]="+chars[j]);
			if(!Objects.equals(chars[i],'0') && Objects.equals(chars[j], '0')) {
				char temp = chars[i];
				chars[i] = chars[j];
				chars[j] = temp;
			}

			if(!Objects.equals(chars[j], '0')) {
				j++;
			}
		}

		return String.valueOf(chars);
	}


	private static void moveZero(int[] array) {
		int n = array.length;

		int j=0;
		for(int i=0; i<n; i++) {
			if(array[i] !=0 && array[j] == 0) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}

			if(array[j] !=0) {
				j++;
			}
		}
	}

}
