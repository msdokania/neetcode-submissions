/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(Interval i : intervals) {
            tm.put(i.start, tm.getOrDefault(i.start,0)+1);
            tm.put(i.end, tm.getOrDefault(i.end,0)-1);
        }
        int active = 0, ans = 0;
        for(int start : tm.keySet()) {
            active += tm.get(start);
            ans = Math.max(ans, active);
        }
        return ans;
    }
}
