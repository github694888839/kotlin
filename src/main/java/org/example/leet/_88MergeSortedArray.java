package org.example.leet;

import java.util.Arrays;

class _88MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);*/
        /*if (nums1 == null || nums1.length == 0) {
            nums1 = nums2;
            return;
        }
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int p1 = 0, p2 = 0;
        int cur = 0;
        int[] sorted = new int[m + n];
        while ((p1 < m || p2 < n) && cur < m + n) {
            if (p1 >= m) {
                sorted[cur] = nums2[p2];
                p2++;
            } else if (p2 >= n) {
                sorted[cur] = nums1[p1];
                p1++;
            } else {
                int na = nums1[p1];
                int nb = nums2[p2];
                if (na < nb) {
                    sorted[cur] = na;
                    p1++;
                } else if (na > nb) {
                    sorted[cur] = nb;
                    p2++;
                } else {
                    sorted[cur] = na;
                    p1++;
                }
            }
            cur++;
        }
        //System.out.println(Arrays.toString(sorted));

        System.arraycopy(sorted, 0, nums1, 0, m + n);
        //System.out.println(Arrays.toString(nums1));

         */

        /*
        双指针，逆向，尾插法。
         */
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2];
                p2--;
            } else if (p2 == -1) {
                cur = nums1[p1];
                p1--;
            } else {
                int n1 = nums1[p1];
                int n2 = nums2[p2];
                if (n1 > n2) {
                    cur = n1;
                    p1--;
                } else {
                    cur = n2;
                    p2--;
                }
            }
            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}