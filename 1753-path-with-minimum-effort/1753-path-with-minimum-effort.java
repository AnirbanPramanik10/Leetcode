class Solution {
    public int minimumEffortPath(int[][] heights) {
      int m = heights.length;
      int n = heights[0].length;

      int[][] result = new int[m][n];
      for(int[] res : result) Arrays.fill(res,Integer.MAX_VALUE);

      int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

      PriorityQueue<Triplet> pq = new PriorityQueue<>((x1,x2)-> Integer.compare(x1.w, x2.w)); 
      pq.add(new Triplet(0,0,0));
      result[0][0]=0;

      while(!pq.isEmpty()){
          Triplet curr = pq.poll();
          int w = curr.w;
          int x = curr.x;
          int y = curr.y;

          for(int k=0;k<directions.length;k++){
              int nextX = directions[k][0] + x;
              int nextY = directions[k][1] + y;

              if(nextX>=0 && nextY>=0 && nextX<m && nextY<n){
                  int nodeX = nextX;
                  int nodeY = nextY;
                  int diff = Math.max(w,Math.abs(heights[nextX][nextY]-heights[x][y]));

                  if(diff<result[nextX][nextY]){
                      result[nextX][nextY]=diff;
                      pq.add(new Triplet(diff,nextX,nextY));
                  }
              }
          }
      } 
      for(int[] res : result)
      System.out.println(Arrays.toString(res));
      
      return result[m-1][n-1];
    }
    
    class Triplet{
        int w;
        int x;
        int y; 

        Triplet(int w, int x, int y){
            this.w=w;
            this.x=x;
            this.y=y;
        }
    }

}