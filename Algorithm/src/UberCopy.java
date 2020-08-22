import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class UberCopy {
    public static void main(String[] args) {

        int [] first = {3, 2, 0, 4};
        int last[] = {6, 4, 2, 7};
        System.out.println(new UberCopy().smallestSetCoveringIntervals(first, last));
    }
    int smallestSetCoveringIntervals(int[] first, int[] last) {
        List<Range> rangeList = new ArrayList<>();
        for(int i=0; i<first.length; i++) {
            rangeList.add(new Range(first[i], last[i]));
        }

        return this.Solve(rangeList);
    }

    static class Range {

        int start;
        int end;
        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int Solve(List<Range> ranges) {
        ranges.sort((a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });
        int[] fillSet = IntStream.generate(() -> 2).limit(ranges.size()).toArray();

        int ans = 0;
        for(int j=ranges.size()-1; j>=0; j--) {
            int start = ranges.get(j).start;
            int m = fillSet[j];
            for (int p = start; p < start+m; ++p) {
                for (int i = 0; i <= j; ++i)
                    if (fillSet[i] > 0 && p <= ranges.get(i).end)
                        fillSet[i]--;
                ans++;
            }
        }

        return ans;
    }
}