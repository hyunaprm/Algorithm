package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261_¾Ë°í½ºÆÌ {

	static int N,M;
	//static int brokenCnt[][];
	static char map[][];
	
	public static class Spot implements Comparable<Spot>{
		int i, j, cost;

		public Spot(int i, int j, int cost) {
			super();
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		@Override
		public int compareTo(Spot o) {
			return this.cost - o.cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		

		
		for(int i=0;i<N;i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		System.out.println(dijkstra());
		
	}
	private static int dijkstra() {
		int dy[] = {-1,0,1,0};
		int dx[] = {0,1,0,-1};
		
		int brokenCnt[][] = new int[N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(brokenCnt[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Spot> queue = new PriorityQueue();
		queue.offer(new Spot(0, 0, 0));
		brokenCnt[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Spot cur = queue.poll();
			
			if(cur.i==N-1 && cur.j ==M-1) {
				return cur.cost;
			}
			
			for(int k=0;k<4;k++) {
				int di = cur.i+dy[k];
				int dj = cur.j+dx[k];
				if(di<0 || dj<0 || di>=N || dj>=M) continue;
				//System.out.println(cur.i +"/"+cur.i +"/");
				
				if(brokenCnt[di][dj] > brokenCnt[cur.i][cur.j] + (map[di][dj]-'0')) {
					brokenCnt[di][dj] = brokenCnt[cur.i][cur.j] + (map[di][dj]-'0');
					queue.offer(new Spot(di,dj,brokenCnt[di][dj]));
				}
			}
		}
		
		return -1;
	}

}
