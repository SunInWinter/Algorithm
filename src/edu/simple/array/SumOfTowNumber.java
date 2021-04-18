package edu.simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和:
 * 
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 你可以按任意顺序返回答案。
 * 
 * 示例 1： 
 * 输入：nums = [2,7,11,15], target = 9 
 * 输出：[0,1] 解释：因为 nums[0] + nums[1] == 9，返回 [0, 1] 。
 * 
 * 示例 2：
 *  输入：nums = [3,2,4], target = 6 输出：[1,2]
 * 
 * 示例 3： 
 * 输入：nums = [3,3], target = 6 输出：[0,1]   
 * 
 * 提示： 
 * 2 <= nums.length <= 10^3 
 * -10^9 <= nums[i] <= 10^9 
 * -10^9 <= target <= 10^9 
 * 只会存在一个有效答案
 * 
 * @author xxw
 *
 */

public class SumOfTowNumber {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 2, 4, 5, 15 };
		int target = 5;

		int[] index = new int[2];
		index = getIndex_2(nums, target);
		
		System.out.println(Arrays.toString(index));
	}

	private static int[] getIndex_2(int[] nums, int target) {
		int[] index = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				index[0] = map.get(target - nums[i]);
				index[1] = i;
			}
			map.put(nums[i], i);
		}
		return index;
	}

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int[] getIndex_1(int[] nums, int target) {
		int[] index = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}
		return index;
	}
}
