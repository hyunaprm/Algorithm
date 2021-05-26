package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	static int N,M, map[][], plan[], parents[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		plan = new int[M];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) {
			plan[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		parents = new int[N];
		for(int i=0;i<N;i++) {
			parents[i] = i;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>0) {
					union(i,j);
				}
			}
		}
		
		boolean flag = true;
		int root = find(plan[0]);
		for(int i=1;i<M;i++) {
			int temp = find(plan[i]);
			if(root != temp) {
				flag = false;
				break;
			}
			root = temp;
		}
		
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	private static void union(int i, int j) {
		i = find(i);
		j = find(j);
		if(i!=j) {
			parents[j] = i;
		}
	}

	private static int find(int i) {
		if(parents[i]==i) return i;
		else return parents[i] = find(parents[i]);
	}

}
