package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_2665_미로만들기 {
	
	private static int dijk[][];
	
	public static class Node implements Comparable<Node>{
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char map[][] = new char[N][N];
		dijk = new int[N][N];
		
		for(int i=0;i<N;i++) {
			map[i] = in.readLine().toCharArray();
			Arrays.fill(dijk[i], Integer.MAX_VALUE);
		}
		
		dijkstra(N, map);

		
		System.out.println(dijk[N-1][N-1]);
		
	}
	private static void dijkstra(int N, char[][] map) {
		
		int dy[] = { -1, 0, 1, 0 };
		int dx[] = { 0, 1, 0, -1 };
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,0));
		boolean check[][] = new boolean[N][N];
		check[0][0] =  true;
		dijk[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			for(int k=0;k<4;k++) {
				int di = cur.i+dy[k];
				int dj = cur.j+dx[k];
				if(di<0 || di>=N || dj<0 || dj>=N || check[di][dj]) continue;
				check[di][dj] = true;
				
				if(map[di][dj]=='1') {
					//흰방 (프리패스)
					if(dijk[di][dj] > cur.w) {
						dijk[di][dj] = cur.w;
						pq.offer(new Node(di,dj,cur.w));
					}
				}else {
					if(dijk[di][dj] > cur.w +1) {
						dijk[di][dj] = cur.w +1;
						pq.offer(new Node(di,dj,dijk[di][dj]));
					}
				}
				
			}
		}
	}

}
