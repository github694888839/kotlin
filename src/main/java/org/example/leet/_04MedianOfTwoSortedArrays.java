package org.example.leet;

class _04MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            int mid = totalLen / 2;
            return findValueByIndex(nums1, nums2, mid);
        } else {
            int mid1 = totalLen / 2;
            int mid2 = mid1 - 1;
            return (findValueByIndex(nums1, nums2, mid1) + findValueByIndex(nums1, nums2, mid2)) / 2.0;
        }
    }

    public static double findValueByIndex(int[] num1, int[] num2, int index) {
        int p1 = 0, p2 = 0;
        int cur = 0;
        for (int i = 0; i < num1.length + num2.length; i++) {
            if (p1 >= num1.length) {
                cur = num2[p2];
                p2++;
            } else if (p2 >= num2.length) {
                cur = num1[p1];
                p1++;
            } else {
                int va = num1[p1];
                int vb = num2[p2];
                if (va < vb) {
                    cur = va;
                    p1++;
                } else {
                    cur = vb;
                    p2++;
                }
            }
            if (i == index) {
                return cur;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}