package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_13549_숨바꼭질3 {
	
	public static class Node implements Comparable<Node>{
		int d, time;

		public Node(int d, int time) {
			super();
			this.d = d;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		System.out.println(dijkstra(N,M));
	}

	private static int dijkstra(int start, int end) {
		int dist[] = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			//System.out.println(cur.d +"/"+cur.time);
			
			if(cur.d==end) return dist[cur.d];
			//System.out.println("출력:"+Arrays.toString(dist));
			
			if(cur.d+1<=100000 && dist[cur.d+1]> dist[cur.d]+ 1) {
				dist[cur.d+1] = dist[cur.d]+ 1;
				pq.offer(new Node(cur.d+1, dist[cur.d+1]));
			}
			
			if(cur.d-1>=0 && dist[cur.d-1]> dist[cur.d]+ 1) {
				dist[cur.d-1] = dist[cur.d]+ 1;
				pq.offer(new Node(cur.d-1, dist[cur.d-1]));
			}
			
			if(cur.d*2 <=100000 && dist[cur.d*2] > dist[cur.d]) {
				dist[cur.d*2] = dist[cur.d];
				pq.offer(new Node(cur.d*2, dist[cur.d*2]));
			}
			
		}
		
		return -1;
	}

}
