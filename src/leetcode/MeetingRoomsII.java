package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MeetingRoomsII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 253. Meeting Rooms II
 */
public class MeetingRoomsII {
    /**


     |___| |____|
       |_____| |___|

     start:
     | |   |   |
               i
     end :
         |   |  |  |
               end

     time : O(nlogn) space : O(n)

     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(starts[i] < ends[end]) {
                res++;
            } else end++;
        }
        return res;
    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
        heap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = heap.poll();
            if(intervals[i][0] >= interval[1]) {
                interval[1] = intervals[i][1];
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}
