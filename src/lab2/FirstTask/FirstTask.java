package lab2.FirstTask;

public class FirstTask {
    public static int getIndexInBrokenArray(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
