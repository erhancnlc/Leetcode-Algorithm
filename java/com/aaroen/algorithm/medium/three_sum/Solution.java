package com.aaroen.algorithm.medium.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    response.add((Arrays.asList(nums[i], nums[left++], nums[right--])));
                    while ((left < right) && (nums[left] == nums[left - 1])) left++;
                    while ((left < right) && (nums[right] == nums[right + 1])) right--;
                }
            }
        }
        return response;
    }
}
