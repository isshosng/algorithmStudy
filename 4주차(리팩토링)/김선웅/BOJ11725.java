// https://www.acmicpc.net/problem/11725


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int n;
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		answer = new int[n+1];
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}

		dfs(1);
		for(int i=2; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	public static void dfs(int c) {
		visited[c] = true;
		for (Integer i : list.get(c)) {
			if(!visited[i]) {
				answer[i]=c;
				dfs(i);
			}
		}
	}
}