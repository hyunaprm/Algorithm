package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_14502_연구소 {
	static class Point{
		int i,j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	static int N,M,map[][], count, min;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		min = N*M;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp>0) count++;
			}
		}
		
		combination(0,new Point[3], 0 );
		
		System.out.println(N*M-min);

	}
	private static void combination(int index, Point[] sel, int k) {
		if(k==3) {
			min = Math.min(min,bfs(sel));
			return;
		}
		if(index==N*M) return;
		
		int i = index/M;
		int j = index%M;
		if(map[i][j]==0) {
			sel[k] = new Point(i, j);
			combination(index+1, sel, k+1);
		}
		combination(index+1, sel, k);
	}
	
	static int dy[] = {0,-1,0,1};
	static int dx[] = {-1,0,1,0};
	private static int bfs(Point[] sel) {
		int cnt = count+3;
		int copy[][] = new int[N][M];
		for(int i=0;i<N;i++) {
			copy[i] = Arrays.copyOf(map[i],M);
		}
		for(int i=0;i<3;i++) {
			copy[sel[i].i][sel[i].j] = 1;
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copy[i][j]==2) {
					queue.offer(new Point(i,j));
				}
			}
		}
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for(int d=0;d<4;d++) {
				int di = cur.i+dy[d];
				int dj = cur.j+dx[d];
				if(di<0 || di>=N || dj<0 || dj>=M || copy[di][dj]!=0) continue;
				cnt++;
				copy[di][dj] = 2;
				queue.offer(new Point(di,dj));
			}
			
		}
		return cnt;
	}
}
