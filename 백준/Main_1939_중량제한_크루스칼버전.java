package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1939_�߷�����_ũ�罺Į���� {
	
	/**
	 * BFS+�̺�Ž������ �ð� ���� ���!
	 *
	 */
	
	public static class Node implements Comparable<Node>{
		int start, end, weight;
		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return o.weight - this.weight;
		}
	}
	static int N,M, parents[];
	static PriorityQueue<Node> pq;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i] = i;
		}
		pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Node(a,b,w));
		}
		
		st = new StringTokenizer(in.readLine());
		int p1 = Integer.parseInt(st.nextToken()); //����
		int p2 = Integer.parseInt(st.nextToken()); //����
		int answer = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int a = node.start;
			int b = node.end;
			int w = node.weight;
			// ���� ū �ٸ����� �ϳ��� union ���Ѱ��鼭 �� ������(p1, p2)�� ����ȴٸ�, break ������ ���� weight �� ����
			union(a,b);
			if(find(p1)==find(p2)) {
				//System.out.println(Arrays.toString(parents));
				answer = w;
				break;
			}
		}
		
		System.out.println(answer);
	}


	private static int find(int a) {
		if(parents[a]==a) return a;
		else return parents[a] = find(parents[a]);
	}


	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b){
			parents[b] = a;
		}
			
	}
	


}
