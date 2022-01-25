class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1, idx1=m-1, idx2=n-1;
        int[] temp = nums1;
        while(idx1 >= 0 && idx2 >= 0){
            nums1[idx--] = (temp[idx1] > nums2[idx2])? temp[idx1--] : nums2[idx2--];
        }
        while(idx2 >= 0){
            nums1[idx--] = nums2[idx2--];
        }
        
    }
}