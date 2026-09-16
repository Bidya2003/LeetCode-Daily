// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         if(n==0)
//             return;
        
//         int i =0;
//         int j = 0;

//         while(i<nums1.length){
//             if(i>=m){
//                 nums1[i] = nums2[j];
//                 j++;
//                 i++;
//             }
//             else{
//                 if(nums1[i] < nums2[j]){
//                     i++;
//                 }
//                 else{
//                     int temp = nums1[i];
//                     nums1[i] = nums2[j];
//                     nums2[j] = temp;
//                     i++;
//                 }
//             }
//         }
        
//     }
// }



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = 0;

        while(i<nums1.length){
            nums1[i] = nums2[j];
            i++;
            j++;
        }

        Arrays.sort(nums1);
    }
}