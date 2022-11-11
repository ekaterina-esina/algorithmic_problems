## Median of two sorted arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

#### Example 1:
 ```
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
 ```


#### Example 2:
 ```
 Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 ```

#### Constraints:
- nums1.length == m
- nums2.length == n
- 0 <= m <= 1000
- 0 <= n <= 1000
- 1 <= m + n <= 2000
- -10^6 <= nums1[i], nums2[i] <= 10^6


## Solution
We have two sorted arrays, to find the median we need to sort all the values in both arrays.
To do this, you need to get the number of all elements of the array and divide by 2.

To move elements, we use binary search, which gives algorithmic complexity **O(log(max(m, n))**

Now the first array will contain all numbers less than the second one. Further, if the number of elements is odd, then the result will be the element with the index number of elements / 2.
If even, then add the largest number of the first array with the smallest number of the second array and divide by 2.

## Performance
Run on JDK 11

| **nums1 [ ]** | **nums2 [ ]** | **result** | **excecution time** |
|:----------------:|:-------------:|:----------:|:-------------------:|
|        [1,5,7,15]       |      [ ]      |    5.0     |      0.00031s       |
|        [1,5,7,15]       |  [2,4,14,17]  |    6.0     |      0.00034s       |
|       [1,2,4,5]        |     [2,3,7]      |    3.0     |      0.00034s       |
|       [1,10,23,45,78,95, 101, 112,114,115,118,121,136,187,189,190,211]       |     [21,36,57,78,81,100, 111, 122,124,125,138,141,146,157,159,195,220]      |   116.5    |      0.00035s       |




## How to start
Install JDK 11

Run in directory for compilation and start
```
javac MedianOfTwoSortedArrays.java
java Main {first array} {second array}

Params example: 1,5,7,15 2,4,14,17
```