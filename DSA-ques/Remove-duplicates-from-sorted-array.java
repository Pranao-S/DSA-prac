// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
// Return k.
// Custom Judge:

// The judge will test your solution with the following code:

// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length

// int k = removeDuplicates(nums); // Calls your implementation

// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//     assert nums[i] == expectedNums[i];
// }

class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1; //pointer
        if(nums.length == 0) return 0; //as no elements in array

        for(int i=1; i< nums.length; i++){
            if(nums[i]!=nums[i-1]){ 
                //start from second element in array as first is always unique
                //if 1st and 2nd element are not equal, then assign 2nd element as 2nd element
                // in 3rd iteration, if 2nd & 3rd element is not equal, 3rd element as 3rd element
                // but in case 4th element and 5th element are equal, the iteration will be skipped
                // and next element from array will be picked up
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
}
}