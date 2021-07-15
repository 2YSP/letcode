package cn.sp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Ship
 * @Description: 合并区间 https://leetcode-cn.com/problems/merge-intervals/
 * @Date: Created in 2021/7/15
 */
public class Merge {


    /**
     * 以数组intervals表示若干个区间的集合，其中单个区间为intervals[i] = [starti,endi]。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * <p>
     * 解法：排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 根据区间的左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                // 如果merged为空，或者当前区间的左端点大于merged最后一个区间的右端点，则不会重合，加入merged
                merged.add(new int[]{L, R});
            } else {
                // 合并
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
