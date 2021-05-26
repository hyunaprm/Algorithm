package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1939_중량제한 {
	
	public static class Node{
		int end;
		long weight;

		public Node(int end, long weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}
	
	static List<Node> list[];
	static int N,M;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		long start = 1000000001;
		long end = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,w));
			list[b].add(new Node(a,w));
			start = Math.min(start, w);
			end = Math.max(end, w);
		}
		
		st = new StringTokenizer(in.readLine());
		int p1 = Integer.parseInt(st.nextToken()); //공장
		int p2 = Integer.parseInt(st.nextToken()); //공장
		long answer = 0;
		while(start<=end) {
			long mid = (start+end)/2;

			if(BFS(p1,p2,mid)) {
				answer = Math.max(mid, answer);
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		System.out.println(end);
	}

	private static boolean BFS(int p1, int p2, long mid) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean check[] = new boolean[N+1];
		queue.offer(p1);
		check[p1] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur==p2) return true;
			for(Node node : list[cur]) {
				if(check[node.end]) continue;
				if(node.weight >= mid) {
					queue.offer(node.end);
					check[node.end] = true;
				}
			}
		}
		
		return false;
		
	}

}
