import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean visited[][] = new boolean[n][m]; 
        int dy[] = {-1,0,1,0};
        int dx[] = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,1});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==n-1 && cur[1]==m-1){
                answer = cur[2];
                break;
            }
            for(int k=0;k<4;k++){
                int di = cur[0]+dy[k];
                int dj = cur[1]+dx[k];
                if(di<0 || di>=n || dj<0 || dj>=m || maps[di][dj]==0 || visited[di][dj]) continue;
                visited[di][dj] = true;
                queue.offer(new int[] {di,dj,cur[2]+1});
            }
        }
        
        return answer;
    }
}
