package programmers;

import java.util.Stack;

public class Solution_크레인인형뽑기게임 {
	//https://programmers.co.kr/learn/courses/30/lessons/64061

	public static void main(String[] args) {
		int[][] board = {}; 
		int[] moves = {};
		
		System.out.println(solution(board, moves));

	}
	
	 public static int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> st = new Stack<>();
	        for(int j=0;j<moves.length;j++){
	            for(int i=0;i<board.length;i++){
	                if(board[i][moves[j]-1]>0){
	                    if(!st.isEmpty() && (st.peek()==board[i][moves[j]-1])){
	                        System.out.print(j);
	                        st.pop();
	                        answer+=2;
	                    }else{
	                        st.push(board[i][moves[j]-1]);
	                    }
	                    board[i][moves[j]-1] = 0;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
}
