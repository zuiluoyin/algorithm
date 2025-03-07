package single.person.archy.dp;

public class JumpGrid {

	/*
	小明和朋友玩跳格子游戏，有 n 个连续格子组成的圆圈，每个格子有不同的分数，小明可以从任意格子开始起跳，但是不能跳连续的格子，不能回头跳，也不能超过一圈。
	给定一个代表每个格子分数的非负整数数组，计算能够得到的最高分数
	 */
	public int jumpGrid2(int[] nums) {
		int length = nums.length;
		if (length == 1) return nums[0];

		int[] includeFirst = new int[length - 1];
		System.arraycopy(nums, 0, includeFirst, 0, length - 1);

		int[] excludeFirst = new int[length - 1];
		System.arraycopy(nums, 1, excludeFirst, 0, length - 1);

		return Math.max(computeMaxScore(includeFirst), computeMaxScore(excludeFirst));
	}

	private int computeMaxScore(int[] nums) {
		int maxScore = nums[0];
		for (int i = 1, prev = 0; i < nums.length; i++) {
			int temp = maxScore;
			maxScore = Math.max(maxScore, prev + nums[i]);
			prev = temp;
		}
		return maxScore;
	}
}
