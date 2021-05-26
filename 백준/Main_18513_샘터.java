package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18513_價攪 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); //價攪 熱
		int K = Integer.parseInt(st.nextToken()); //餵 熱
		visited = new boolean[201000001];
		queue = new LinkedList<>();

		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			int idx = Integer.parseInt(st.nextToken())+100200000;
			visited[idx] = true;
			queue.offer(new int[] {idx, 0});
		}
		
		BFS(N,K);
		
		System.out.println(min);
		
		
	}

	static boolean visited[];
	static Queue<int[]> queue;
	static int cnt = 0;
	static long min= 0;
	private static void BFS(int N, int K) {
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(cur[0]+1<=201000000 && !visited[cur[0]+1]) {
				cnt++;
				min+=cur[1]+1;
				if(cnt<K) {
					visited[cur[0]+1] = true;
					queue.offer(new int[] {cur[0]+1, cur[1]+1});
					
				}
				else break;
			}
			if(cur[0]-1>=0 && !visited[cur[0]-1]) {
				cnt++;
				min +=cur[1]+1;
				if(cnt<K) {
					visited[cur[0]-1] = true;
					queue.offer(new int[] {cur[0]-1, cur[1]+1});
				}
				else break;
			}
			
		}
	}

}
