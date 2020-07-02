package com.anuragkapur.ib.arrays;

import java.util.*;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> answer = new ArrayList<>();
        boolean isMerged = false;
        newInterval = sort(newInterval);

        for (int i=0; i<intervals.size(); i++) {
            int last = answer.size()-1;
            if (!isMerged) {
                if (overlap(intervals.get(i), newInterval)) {
                    Interval merged = merge(intervals.get(i), newInterval);
                    answer.add(merged);
                    isMerged = true;
                } else {
                    answer.add(getCopy(intervals.get(i)));
                }
            } else {
                if (overlap(answer.get(last), intervals.get(i))) {
                    Interval merged = merge(answer.get(last), intervals.get(i));
                    answer.remove(last);
                    answer.add(merged);
                } else {
                    answer.add(getCopy(intervals.get(i)));
                }
            }
        }

        if (!isMerged) {
            if (answer.size() == 0) {
                answer.add(newInterval);
                isMerged = true;
            }

            if (answer.get(0).start > newInterval.end) {
                answer.add(0, newInterval);
                isMerged = true;
            } else {
                for (int i=1; i<answer.size(); i++) {
                    if (answer.get(i-1).end < newInterval.start && newInterval.end < answer.get(i).start) {
                        answer.add(i, newInterval);
                        isMerged = true;
                    }
                }
            }
        }

        if (!isMerged) {
            answer.add(newInterval);
        }

        return answer;
    }

    private boolean overlap(Interval int1, Interval int2) {

        if (int1.start <= int2.start && int2.start <= int1.end) {
            return true;
        }

        if (int2.start <= int1.start && int1.start <= int2.end) {
            return true;
        }

        return false;
    }

    private Interval merge(Interval int1, Interval int2) {
        Interval interval = new Interval();
        interval.start = Math.min(int1.start, int2.start);
        interval.end = Math.max(int1.end, int2.end);
        return interval;
    }

    private Interval getCopy(Interval int1) {
        return new Interval(int1.start, int1.end);
    }

    private Interval sort(Interval int1) {
        Interval interval = new Interval();
        interval.start = Math.min(int1.start, int1.end);
        interval.end = Math.max(int1.start, int1.end);
        return interval;
    }
}

