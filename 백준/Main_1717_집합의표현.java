package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1717_������ǥ�� {
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
				//������
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
				
			}else {
				// Ȯ��
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// parents[a] == parents[b] �� ���ϸ� �� ��. find�� ��ġ�� �� ������ ���� parents�� ��Ʈ�� �ƴ� �� ����.
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
