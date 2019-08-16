package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MergeIntervals
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 56. Merge Intervals
 */
public class MergeIntervals {
    /**
     * For example,
     Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].

                sta     end
     |___|       |____|
       |_____|       |___|

     time : O(nlogn) space : O(n)

     * @param intervals
     * @return
     */
        public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals) {
            if(interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][2]);
    }
}
