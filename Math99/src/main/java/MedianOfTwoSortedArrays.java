/**
 * @author Hanz
 * @date 2020/4/29
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{7, 8, 11, 19, 20}, new int[]{1, 9, 10});
        System.out.println(result);
    }

    public static double medianOfTwoSortedArrays(int[] a, int[] b) {
        // 首先要确保 a的长度大于b
        int al = a.length;
        int bl = b.length;
        if (al < bl) {
            medianOfTwoSortedArrays(b, a);
        }
        int allL = al + bl;
        int halfAll = (allL - 1) / 2;
        int i = (al - 1) / 2;
        int j = halfAll - i - 1;
        int iMin = 0;
        int iMax = al;
        // 比较左边最大值和右边最小值
        while (iMin <= iMax) {
            if (a[i] > b[j + 1] && i != al && j != 0) {
                iMin = ++i;
            } else if (b[j] > a[i + 1] && j != bl && i != 0) {
                iMax = --i;
            } else {
                if (allL / 2 == 1) {
                    // 奇数
                    return a[iMin];
                } else {
                    return (a[iMin] + a[iMin + 1]) / 2.0;
                }
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    //i: nums1的起始位置 j: nums2的起始位置
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];//nums1为空数组
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];//nums2为空数组
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
