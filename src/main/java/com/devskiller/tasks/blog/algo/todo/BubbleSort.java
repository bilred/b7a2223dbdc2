package com.devskiller.tasks.blog.algo.todo;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {5, 2, 8, 12, 1, 6};



		System.out.println("Array before sorting: " + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("Array after sorting: " + Arrays.toString(array));
	}

	public static void bubbleSort(int[] array) {
		int n = array.length;

		for(int i = 0; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

//		for (int i = 0; i < n - 1; i++) {
//			for (int j = 0; j < n - i - 1; j++) {
//				if (array[j] > array[j + 1]) {
//					// Swap array[j] and array[j + 1]
//					int temp = array[j];
//					array[j] = array[j + 1];
//					array[j + 1] = temp;
//				}
//			}
//		}
	}
}
