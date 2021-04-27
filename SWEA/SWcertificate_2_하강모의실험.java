package 모의역량test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWcertificate_2_하강모의실험 {

	private static int N, map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//하강
			for(int j=0;j<N;j++) {
				int hcnt = 0;
				double w = 0;
				for(int i=0;i<N;i++) {
					if(i==0 && map[i][j]==0) break;
					if(w==0) {
						hcnt=1;
						w=1;
						continue;
					}
					//System.out.println("["+i+","+j+"]");
					if(map[i][j]==0) {
						w=w*1.9;
						//System.out.println(w);
						for(int a=i;a>i-hcnt;a--) {
							map[a][j]= 1;
						}
						for(int a=i-hcnt;a>=0;a--) {
							// 0이면 끝! 가지치기 가능할듯
							map[a][j]=0;
						}
					}else {
						int cnt = 0;
						cnt++;
						//현재 블록 크기 구하기
						for(int k=i+1;k<N;k++) {
							if(map[k][j]>0) cnt++;
							else break;
						}
						if(w<=cnt) {
							//System.out.println(w+"/"+cnt);
							break;
						}
						i+=cnt-1;
						w+=cnt;
						//System.out.println(w);
						hcnt += cnt;
						for(int a=i;a>i-hcnt;a--) {
							map[a][j]= 1;
						}
						for(int a=i-hcnt;a>=0;a--) {
							// 0이면 끝! 가지치기 가능할듯
							map[a][j]=0;
						}
					}
				}
				
			}
//			for(int a=0;a<N;a++) {
//				for(int b=0;b<N;b++) {
//					System.out.print(map[a][b]);
//				}
//				System.out.println();
//			}
//			System.out.println("================");
			
			//오른쪽 하강
			for(int i=0;i<N;i++) {
				int hcnt = 0;
				double w = 0;
				for(int j=0;j<N;j++) {
					if(j==0 && map[i][j]==0) break;
					if(w==0) {
						hcnt=1;
						w=1;
						continue;
					}
					//System.out.println("["+i+","+j+"]");
					if(map[i][j]==0) {
						w=w*1.9;
						for(int b=j;b>j-hcnt;b--) {
							map[i][b]= 1;
						}
						for(int b=j-hcnt;b>=0;b--) {
							// 0이면 끝! 가지치기 가능할듯
							map[i][b]=0;
						}
					}else {
						int cnt = 0;
						cnt++;
						//현재 블록 크기 구하기
						for(int k=j+1;k<N;k++) {
							if(map[i][k]>0) cnt++;
							else break;
						}
						if(w<=cnt)break;
						j+=cnt-1;
						w+=cnt;
						hcnt += cnt;
						for(int b=j;b>j-hcnt;b--) {
							map[i][b]= 1;
						}
						for(int b=j-hcnt;b>=0;b--) {
							// 0이면 끝! 가지치기 가능할듯
							map[i][b]=0;
						}
					}
				}
				
			}
//			for(int a=0;a<N;a++) {
//			for(int b=0;b<N;b++) {
//				System.out.print(map[a][b]);
//			}
//			System.out.println();
//		}
			int answer1 = 0;
			int answer2 = 0;
			for(int j=0;j<N;j++) {
				if(map[N-1][j]==1) answer1++;
			}
			for(int i=0;i<N;i++) {
				if(map[i][N-1]==1) answer2++;
			}
			
			sb.append("#").append(tc).append(" ").append(answer1).append(" ").append(answer2).append("\n");
			
		}
		System.out.print(sb);
	}

}
