package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5052_전화번호목록 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		String list[];
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(in.readLine());
			list = new String[n];
			for(int i=0;i<n;i++) {
				list[i] = in.readLine();
			}
			Arrays.sort(list);
			boolean flag = true;
			for(int i=1;i<n;i++) {
				if(list[i].startsWith(list[i-1])) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");

		}
		System.out.print(sb);
	}

}
