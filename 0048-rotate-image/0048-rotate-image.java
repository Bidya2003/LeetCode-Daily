class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        int half = 0;
        if(size%2!=0){
            half = size/2;
        }
        else{
            half = (size/2);
        }

        int[][] index = {{size-1,0}, {0,0}, {0,size-1}, {size-1,size-1}, {size-1,0}};
        int[][] outer = {{-1,0}, {0,1}, {1,0}, {0,-1}, {-1,0}};
        int[][] inner = {{-1,1}, {1,1}, {1,-1}, {-1,-1}, {-1,1}};

        int in = 1;
        while(in<=half){
            int out = 0;
            while(out<size-1){
                int temp = 0;
                for(int i=0;i<index.length;i++){
                    int row = index[i][0] + (outer[i][0] * out); 
                    int col = index[i][1] + (outer[i][1] * out);
                    int x = temp;
                    temp = matrix[row][col];
                    matrix[row][col] = x;
                }
                out++;
            }
            for(int i=0; i<index.length;i++){
                index[i][0] = index[i][0] + inner[i][0];
                index[i][1] = index[i][1] + inner[i][1];
            } 
            in++;
            size = size-2;          
        }
    }
}