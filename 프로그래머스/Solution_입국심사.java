package programmers;

import java.util.Arrays;

public class Solution_�Ա��ɻ� {
	//https://programmers.co.kr/learn/courses/30/lessons/43238
	
	public static void main(String[] args) {
		int n = 6;
		int times[] = {7,10};
		solution(n, times);
	}
	
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long start = 0;
        long end = Long.MAX_VALUE;
        Arrays.sort(times);
        
        long mid = 0;
        long sum = 0;
        while(start <= end) {
        	//System.out.println(sum);
        	mid = (start+end)/2;
        	sum = 0;
        	for(int i=0;i<times.length;i++) {
        		sum += mid/times[i];
        		if(sum>= n) {
        			//n���� �Ա��˻��� �� �ִ� �ּ� �ð� ����
        			break;
        		}
        	}
        	if(sum<n) {
        		start = mid+1;
        	}else {
        		end = mid-1;
        		answer = mid;
        	}
        }
        
        System.out.println(answer);
        
        
        
        return answer;
    }

}
