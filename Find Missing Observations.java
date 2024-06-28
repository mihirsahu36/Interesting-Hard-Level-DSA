/*You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. 
Fortunately, you have also calculated the average value of the n + m rolls.
You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.
Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean.
If there are multiple valid answers, return any of them. If no such array exists, return an empty array.
The average value of a set of k numbers is the sum of the numbers divided by k.
Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.*/

/*Example 1:

Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
Example 2:

Input: rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.*/

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] arr = new int[n];
        int sum = 0;
        int m = rolls.length;

        for (int roll : rolls) {
            sum += roll;
        }

        int totalLength = m + n;
        int targetSum = mean * totalLength;
        int rem = targetSum - sum;

        if (rem < n || rem > 6 * n) {
            return new int[0];
        }

        int miss = rem / n;
        int remainder = rem % n;

        for (int i = 0; i < n; i++) {
            arr[i] = miss;
            if (remainder > 0) {
                arr[i]++;
                remainder--;
            }
        }

        return arr;
    }
}
