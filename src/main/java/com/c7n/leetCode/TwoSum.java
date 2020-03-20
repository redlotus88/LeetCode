package com.c7n.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dragon on 2020/3/18.
 */
public class TwoSum {

    public static void main(String[] args) {
        twoSum(new int[]{3, 3}, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> origin = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            origin.put(nums[i], i);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{origin.get(nums[i]), origin.get(nums[j])};
                } else if (nums[i] + nums[j] > target) {
                    break;
                }
            }
        }
        return null;
    }

}
