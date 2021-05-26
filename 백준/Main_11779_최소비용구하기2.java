package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_11779_최소비용구하기2 {
	
	private static List<Node> list[];
	private static int n,m;
	private static StringBuilder sb;
	
	public static class Node implements Comparable<Node>{
		int end, cost;
		ArrayList<Integer> cityList;

		
		public Node(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}

		public Node(int end, int cost, ArrayList<Integer> cityList) {
			super();
			this.end = end;
			this.cost = cost;
			this.cityList = cityList;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		list = new ArrayList [n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, cost));
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start, end);
		System.out.print(sb.toString());
	}

	private static void dijkstra(int start, int end) {

		int dist[] = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<Integer> cl = new ArrayList<>();
		cl.add(start);
		pq.offer(new Node(start, 0, cl));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.end==end) {
				sb = new StringBuilder();
				sb.append(cur.cost).append("\n");
				sb.append(cur.cityList.size()).append("\n");
				for(int i=0;i<cur.cityList.size();i++) {
					sb.append(cur.cityList.get(i)).append(" ");
				}
				return;
			}
			
			for(Node node : list[cur.end]) {
				if(dist[node.end] > dist[cur.end]+node.cost) {
					dist[node.end] = dist[cur.end]+node.cost;
					ArrayList<Integer> al = new ArrayList<>();
					al.addAll(cur.cityList);
					al.add(node.end);
					pq.offer(new Node(node.end, dist[node.end], al));
				}
			}
		}
	}

}
