package programmers;

public class Solution_키패드누르기 {
	
	public static void main(String[] args) {
		int[] numbers= {};
		String hand = "";
		System.out.println(solution(numbers, hand));
	}
	
	 public static String solution(int[] numbers, String hand) {
	        String answer = "";
	        int[] leftPos = {3,0};//왼손 위치
	        int[] rightPos = {3,2};//오른손 위치
	        StringBuilder sb = new StringBuilder();
	        
	        for(int n=0;n<numbers.length;n++){
	            int temp = numbers[n];
	            if(temp==1 || temp==4 || temp==7){
	                sb.append("L");
	                leftPos[0] = (temp-1)/3;
	                leftPos[1] = (temp-1)%3;
	            }else if(temp==3 || temp==6 || temp==9){
	                sb.append("R");
	                rightPos[0] = (temp-1)/3;
	                rightPos[1] = (temp-1)%3;
	            }else{
	                int numPos[] = new int[2];
	                if(temp>0){
	                    numPos[0] = (temp-1)/3;
	                    numPos[1] = (temp-1)%3;
	                }else{
	                    numPos[0] = 3;
	                    numPos[1] = 1;
	                }
	                
	                if(Math.abs(leftPos[0]-numPos[0])+Math.abs(leftPos[1]-numPos[1])>
	                  Math.abs(rightPos[0]-numPos[0])+Math.abs(rightPos[1]-numPos[1])){
	                    sb.append("R");
	                    rightPos = numPos;
	                }else if(Math.abs(leftPos[0]-numPos[0])+Math.abs(leftPos[1]-numPos[1])<
	                  Math.abs(rightPos[0]-numPos[0])+Math.abs(rightPos[1]-numPos[1])){
	                    sb.append("L");
	                    leftPos = numPos;
	                }else{
	                    if(hand.equals("right")){
	                        sb.append("R");
	                        rightPos = numPos;
	                    }else{
	                        sb.append("L");
	                        leftPos = numPos;
	                    }
	                }
	            }
	        }
	        
	        return sb.toString();
	    }

}
