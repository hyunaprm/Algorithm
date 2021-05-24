package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_1753_최단경로 {
	private static int V,E;
	private static List<Node>[] list;
	private static int dist[];
	
	public static class Node implements Comparable<Node>{
		int end, weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st=  new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
		StringBuilder sb = new StringBuilder();
		
	
		dijkstra(K);
		for(int i=1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}else {
				sb.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if(check[curNode.end]) continue;
			check[curNode.end] = true;
			
			for(Node node : list[curNode.end]) {
				if(dist[node.end]>dist[curNode.end] + node.weight) {
					dist[node.end] = dist[curNode.end] + node.weight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}

}
