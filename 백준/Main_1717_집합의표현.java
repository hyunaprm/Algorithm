package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1717_집합의표현 {
	private static int n,m, parents[];

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		for(int i=0;i<=n;i++) {
			parents[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			if(Integer.parseInt(st.nextToken())==0) {
				//합집합
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
				
			}else {
				// 확인
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// parents[a] == parents[b] 로 비교하면 안 됨. find로 거치기 전 까지는 현재 parents가 루트가 아닐 수 있음.
				if(find(a)==find(b)) {
					sb.append("YES");
				}else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parents[a] = b;
		}
	}

	private static int find(int a) {
		if(parents[a]==a) return a;
		else return parents[a] = find(parents[a]);
	}

}
