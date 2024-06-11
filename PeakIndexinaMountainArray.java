/*You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
Return the index of the peak element.
Your task is to solve it in O(log(n)) time complexity.*/


class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid]<arr[mid+1]){
                left = mid + 1;
            }
            else{
                right = mid;
            } 
        }
        return left;
    }
}
