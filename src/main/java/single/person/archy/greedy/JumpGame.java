package single.person.archy.greedy;

public class JumpGame {

	/*
	https://leetcode.cn/problems/jump-game/
	给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
	判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
	 */
	public boolean jumpGame1(int[] nums) {
		int length = nums.length;
		for (int i = 0, j = nums[0]; i < length; i++) {
			if (i > j) return false;
			j = Math.max(i + nums[i], j);
			if (j >= length - 1) return true;
		}
		return false;
	}

	/*
	https://leetcode.cn/problems/jump-game-ii/
	给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
	每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
	0 <= j <= nums[i]
	i + j < n
	返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
	 */
	public int jumpGame2(int[] nums) {
		int length = nums.length;
		if (length == 1) return 0;

		int step = 1;
		for (int i = 0, currRange = nums[0], maxRange = 0; i <= currRange; i++) {
			if (i == length - 1) return step;

			maxRange = Math.max(maxRange, i + nums[i]);
			if (i == currRange) {
				if (maxRange <= currRange) return 0;
				step++;
				currRange = maxRange;
			}
		}
		return 0;
	}
}
