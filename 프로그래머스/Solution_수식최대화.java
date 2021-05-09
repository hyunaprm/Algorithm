package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_수식최대화 {
	
	static List<Long> num;
	static List<Character> oper;
	
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		long answer = solution(expression);
		System.out.println(answer);
	}

	private static long solution(String expression) {
		long answer = 0;
		num = new ArrayList<>();
		oper = new ArrayList<>();
		StringTokenizer nst = new StringTokenizer(expression, "-*+");
		StringTokenizer ost = new StringTokenizer(expression, "1234567890");
		
		while(nst.hasMoreTokens()) {
			num.add(Long.parseLong(nst.nextToken()));
		}
		while(ost.hasMoreTokens()) {
			oper.add(ost.nextToken().charAt(0));
		}
		// 100, 200, 300, 500, 20
		// -, *, -, +
		DFS(0,new boolean[3], new int[3]);
		answer = max;
		return answer;
	}

	static long max = 0;
	static char[] op = {'+','-','*'};
	private static void DFS(int k, boolean visited[], int selected[]) {
		
		if(k==3) {
			System.out.println(Arrays.toString(selected));
			long temp = Math.abs(calc(selected));
			max = Math.max(max, temp);
			return;
		}
		
		for(int i=0;i<3;i++) {
			if(!visited[i]) {
				visited[i] =true;
				selected[k] = i;
				DFS(k+1, visited, selected);
				visited[i] = false;
			}
		}

	}
	

	private static long calc(int selected[]) {
		List<Long> copyNum = new ArrayList<>();
		List<Character> copyOper = new ArrayList<>();
		copyNum.addAll(num);
		copyOper.addAll(oper);

		
		
		for(int i=0;i<3;i++) {
			
			char tempCh = op[selected[i]];
			System.out.println(tempCh);
			for(int j=0;j<copyOper.size();j++) {
				long temp = 0;
				if(copyOper.get(j)==tempCh) {
					if(tempCh=='+') {
						temp = copyNum.get(j) + copyNum.get(j+1);
					}else if(tempCh=='-') {
						temp = copyNum.get(j) - copyNum.get(j+1);
					}else if(tempCh=='*'){
						temp = copyNum.get(j) * copyNum.get(j+1);
					}
					copyNum.remove(j);
					copyNum.remove(j);
					copyNum.add(j,temp);
					copyOper.remove(j);
					j--;
					for(int m=0;m<copyNum.size();m++) {
						System.out.print(copyNum.get(m)+" ");
					}
					System.out.println();
				}		
			}

		}
		System.out.println("answer:"+copyNum.get(0));
		
		return copyNum.get(0);
	}

}
