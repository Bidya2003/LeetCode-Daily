class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for(int i : nums1){
            min = Math.min(min,i);
        }

        boolean even = false;
        if(min%2 == 0){
            even = true;
        }
        
        int countOdds = 0;
        if(even==true){
            for(int i: nums1){
                if(i%2!=0){
                    countOdds++;
                    if(countOdds>0){
                        return false;
                    }
                }
            }
        }

        // else if(even==false){
        //     for(int i: nums1){
        //         if(i%2!=0){
        //             countOdds++;
        //             if(countOdds>=2){
        //                 return true;
        //             }
        //         }
        //     }            
        //     if(countOdds<2)
        //         return false;
        // }

        // int[] nums2 = new int[nums1.length];


        // if(even==true){
        //     for(int i=0;i<nums1.length;i++){
        //         boolean possible = false;
        //         if(nums1[i]==min || nums1[i]%2==0){
        //             nums2[i] = nums1[i];
        //             possible = true;
        //             continue;
        //         }
        //         for(int j=i+1;j<nums1.length;j++){
        //             if(nums1[j]>nums1[i]){
        //                 int diff = nums1[j]-nums1[i];
        //                 if(diff % 2 == 0){
        //                     nums2[i] = diff;
        //                     possible = true;
        //                 }
        //                 else
        //                     continue;
        //             }
        //             else
        //                 continue;
        //         }
        //         if(possible==false)
        //             return false;
        //     }
        // }


        // else if(even==false){
        //     for(int i=0;i<nums1.length;i++){
        //         boolean possible = false;
        //         if(nums1[i]==min || nums1[i]%2!=0){
        //             nums2[i] = nums1[i];
        //             possible = true;
        //             continue;
        //         }
        //         for(int j=i+1;j<nums1.length;j++){
        //             if(nums1[j]>nums1[i]){
        //                 int diff = nums1[j]-nums1[i];
        //                 if(diff % 2 != 0){
        //                     nums2[i] = diff;
        //                     possible = true;
        //                     break;
        //                 }
        //                 else
        //                     continue;
        //             }
        //             else
        //                 continue;
        //         }
        //         if(possible = false)
        //             return false;
        //     }
        // }

        return true;
    }
}