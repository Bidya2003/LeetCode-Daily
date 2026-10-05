class Solution { 
    public int diagonalPrime(int[][] nums) { 
        int largest = 0; 
 
        for(int i = 0; i < nums.length; i++){ 

            // Main diagonal
            int j = 1; 
            int val = nums[i][i];

            for(j = 2; j * j <= val; j++){ 
                if(val % j == 0) 
                    break; 
            } 

            if(val > 1 && j * j > val){ 
                largest = Math.max(largest, val); 
            } 
 
            // Secondary diagonal
            j = 1; 
            val = nums[i][nums.length - i - 1];

            for(j = 2; j * j <= val; j++){ 
                if(val % j == 0) 
                    break; 
            } 

            if(val > 1 && j * j > val){ 
                largest = Math.max(largest, val); 
            } 
        } 
 
        return largest; 
    } 
}