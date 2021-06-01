package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_≥Ïªˆø ¿‘¿∫æ÷∞°¡©¥Ÿ¡ˆ {

	private static int N, map[][], dijk[][];

	public static class Node implements Comparable<Node> {
		int i, j, w;

		public Node(int i, int j, int w) {
			super();
			this.i = i;
			this.j = j;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 1;
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			dijk = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijk[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra();
			sb.append("Problem ").append(T).append(": ").append(dijk[N-1][N-1]).append("\n");
			T++;
		}
		System.out.print(sb);

	}

	private static void dijkstra() {

		int dy[] = { -1, 0, 1, 0 };
		int dx[] = { 0, 1, 0, -1 };

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		boolean check[][] = new boolean[N][N];
		check[0][0] = true;
		dijk[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (int k = 0; k < 4; k++) {
				int di = cur.i + dy[k];
				int dj = cur.j + dx[k];
				if (di < 0 || di >= N || dj < 0 || dj >= N || check[di][dj])
					continue;
				check[di][dj] = true;

				if (dijk[di][dj] > cur.w + map[di][dj]) {
					dijk[di][dj] = cur.w + map[di][dj];
					pq.offer(new Node(di, dj, cur.w + map[di][dj]));
				}

			}
		}

	}

}
