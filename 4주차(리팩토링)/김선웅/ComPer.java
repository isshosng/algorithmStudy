package com.solution.baekjoon.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description    : Permutation, Combination Java
 */
public class ComPer {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		int r = 2;

		permutation(arr, new int[r], new boolean[arr.length], 0, r);
		System.out.println();
		duPermutation(arr, new int[r], 0, r);
		System.out.println();
		combination(arr, new boolean[arr.length], 0, 0, r);
		System.out.println();
		duCombination(arr, new int[r], 0, 0, r);
	}

	public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(out));
			return;
		}

		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visited, depth+1, r);
				visited[i] = false;
			}
		}
	}

	public static void duPermutation(int[] arr, int[] out, int depth, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(out));
			return;
		}

		for(int i=0; i<arr.length; i++) {
			out[depth] = arr[i];
			duPermutation(arr, out, depth+1, r);
		}
	}

	public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<arr.length; i++) {
				if(visited[i]) {
					list.add(arr[i]);
				}
			}
			System.out.println(list.stream().toList());
		}

		for(int i=start; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(arr, visited, i, depth+1, r);
				visited[i] = false;
			}
		}
	}

	public static void duCombination(int[] arr, int[] out, int start, int depth, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(out));
			return;
		}

		for(int i=start; i<arr.length; i++) {
			out[depth] = arr[i];
			duCombination(arr, out, i, depth+1, r);
		}
	}

}
