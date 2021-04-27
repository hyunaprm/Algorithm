package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main_1647_도시분할계획 {
	
	static class Pos implements Comparable<Pos>{
		int start, end, cost;

		public Pos(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost-o.cost;
		}
		
	}

	private static int N;
	private static int M;
	private static PriorityQueue<Pos> pq;
	private static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pq.offer(new Pos(A,B,C));
		}
		
		int ans = 0;
		int size = 0;
		while(size <N-2) {
			Pos tmp = pq.poll();
			if(!isSame(tmp.start, tmp.end)) {
				union(tmp.start, tmp.end);
				ans += tmp.cost;
				size++;
			}
		}
		System.out.println(ans);
	}

	private static void union(int start, int end) {
		start = find(start);
		end = find(end);
		
		if(start==end) return;
		
		if(start>end) parents[end] = start;
		else parents[start] = end;
	}

	private static boolean isSame(int start, int end) {
		if(find(start)==find(end))
			return true;
		else 
			return false;
	}

	private static int find(int x) {
		if (x == parents[x])
			return x;
		else 
			return parents[x] = find(parents[x]);
	}

}
