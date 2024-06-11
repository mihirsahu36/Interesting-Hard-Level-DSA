/*You have a long flowerbed in which some of the plots are planted, and some are not. 
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.*/


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int [] newflowerbed = new int[flowerbed.length + 2];
        newflowerbed[0] = 0;
        newflowerbed[newflowerbed.length - 1] = 0;
        for(int i=0;i<flowerbed.length;i++){
            newflowerbed[i+1] = flowerbed[i];
        }
        for(int i=1;i<newflowerbed.length-1;i++){
            if(newflowerbed[i-1] == 0 && newflowerbed[i] == 0 && newflowerbed[i+1] == 0){
                newflowerbed[i] = 1;
                n -= 1;
            }
        }
        return n <= 0;
    }
}
