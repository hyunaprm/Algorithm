package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {


	static List<Integer> list[];
	static int check[], V, E;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			check = new int[V + 1];
			
			for(int i=1;i<=V;i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			boolean answer = true;
			for (int i = 1; i <= V; i++) {
				if (check[i] == 0)
					if(!BFS(i)) {
						answer = false;
						break;
					}
			}
			
			if(answer) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static boolean BFS(int start) {

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		check[start] = 1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int now = check[cur];
			for (int b : list[cur]) {
				if (check[b] == 0) {
					if (now == 1)
						check[b] = -1;
					else if (now == -1)
						check[b] = 1;
					queue.add(b);
				} else {
					if (now != -check[b]) {
						return false;
					}
				}
//				System.out.println(Arrays.toString(check));
			}
		}
		
		return true;
	}

}
