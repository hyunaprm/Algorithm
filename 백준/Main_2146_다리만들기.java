package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
	private static int map[][], N;
	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 별 번호 부여하기
		int cnt = 2;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					visited[i][j] = true;
					findIslandCnt(i, j, cnt);
					cnt++;
				}
			}
		}

//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		// 다리 만들기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 1) {
					BFS(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(min-1);
	}

	static int min = Integer.MAX_VALUE;
	private static void BFS(int i, int j, int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j, 0 });
		boolean check[][] = new boolean[N][N];
		check[i][j] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(map[cur[0]][cur[1]]>1 && map[cur[0]][cur[1]]!=num) {
				min = Math.min(min, cur[2]);
			}
			
			for (int k = 0; k < 4; k++) {
				int di = cur[0] + dy[k];
				int dj = cur[1] + dx[k];
				if (di < 0 || di >= N || dj < 0 || dj >= N || check[di][dj] || map[di][dj]==num)continue;
				check[di][dj] = true;
				queue.offer(new int[] {di,dj,cur[2]+1});
			}
		}
	}

	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	private static void findIslandCnt(int i, int j, int cnt) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int k = 0; k < 4; k++) {
				int di = cur[0] + dy[k];
				int dj = cur[1] + dx[k];
				if (di < 0 || di >= N || dj < 0 || dj >= N || map[di][dj] == 0) {
					if (map[cur[0]][cur[1]] == 1)
						map[cur[0]][cur[1]] = cnt;
					continue;
				}
				if (!visited[di][dj]) {
					visited[di][dj] = true;
					queue.offer(new int[] { di, dj });
				}
			}
		}
	}

}
