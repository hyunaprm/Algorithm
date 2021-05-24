package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main_1504_특정한최단경로 {
	
	private static int N,E;
	private static List<Node> list[];
	
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
		N = Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		
		
			list = new ArrayList[N+1];
			for(int i=1;i<=N;i++) {
				list[i] = new ArrayList<>();
			}
			
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b,w));
				list[b].add(new Node(a,w));
			}
			
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			if(E>0) {
			//start -> v1 -> v2 ->end
			int ans1 = dijkstra(1, v1) + dijkstra(v1,v2) + dijkstra(v2,N);
			
			//start -> v2 -> v1 ->end
			int ans2 = dijkstra(1, v2) + dijkstra(v2,v1) + dijkstra(v1,N);
			if(Math.min(ans1, ans2)>=Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			System.out.println(Math.min(ans1, ans2));
			
		}else {
			System.out.println(-1);
		}
		
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if(dist[curNode.end]<curNode.weight) continue;
			
			for(Node node : list[curNode.end]) {
				if(dist[node.end] > dist[curNode.end] + node.weight) {
					dist[node.end] = dist[curNode.end] + node.weight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		
		return dist[end];
	}

}
