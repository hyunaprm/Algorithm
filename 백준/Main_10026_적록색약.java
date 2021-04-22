package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main_10026_적록색약 {

	private static int N;
	private static char[][] map;
	private static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			String input = in.readLine();
			map[i] = input.toCharArray();
		}
		visited = new boolean[N][N][2];
		
		int cnt=0, cnt_rg = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j][0]) {
					cnt++;
					bfs(i,j,map[i][j]);
				}
				if(!visited[i][j][1]) {
					cnt_rg++;
					bfs_rg(i,j,map[i][j]);
				}
			}
		}
		System.out.println(cnt+" "+cnt_rg);
	}
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	private static void bfs(int i, int j, char c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int k=0;k<4;k++) {
				int di = current[0]+dy[k];
				int dj = current[1]+dx[k];
				if(di<0 || di>=N || dj<0 || dj>=N || map[di][dj]!=c || visited[di][dj][0]) continue;
				visited[di][dj][0]=true;
				queue.offer(new int[] {di,dj});
			}
			
		}
	}

	private static void bfs_rg(int i, int j, char c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int k=0;k<4;k++) {
				int di = current[0]+dy[k];
				int dj = current[1]+dx[k];
				if(di<0 || di>=N || dj<0 || dj>=N || visited[di][dj][1]) continue;
				if(((c=='R'||c=='G')&&(map[di][dj]=='R'||map[di][dj]=='G'))|| c==map[di][dj]){
					visited[di][dj][1]=true;
					queue.offer(new int[] {di,dj});
				}
			}
		}
	}


}
