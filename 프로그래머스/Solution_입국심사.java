package programmers;

import java.util.Arrays;

public class Solution_입국심사 {
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
        			//n명이 입국검사할 수 있는 최소 시간 구함
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
