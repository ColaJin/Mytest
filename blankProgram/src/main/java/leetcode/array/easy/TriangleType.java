package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3024. 三角形类型
 * @Date:2024/8/7
 */
public class TriangleType {
    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] > nums[2] && nums[1] + nums[2] > nums[0] && nums[0] + nums[2] > nums[1]) {
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            } else {
                if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]){
                    return "isosceles";
                }else {
                    return "scalene";
                }
            }
        }
        return "none";
    }
}
