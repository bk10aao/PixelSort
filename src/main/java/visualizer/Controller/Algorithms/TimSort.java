package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.insertionSort;
import static visualizer.Commons.Commons.toList;

public class TimSort {

    private static final int MIN_MERGE = 32;

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if (values == null || values.length == 0)
            return sortingStates;

        sortingStates.add(toList(values));

        if(values.length < MIN_MERGE) {
            insertionSort(values, 0, values.length - 1, sortingStates);
            sortingStates.add(toList(values));
            return sortingStates;
        }

        int minRun = minRunLength(values.length);

        List<Run> runStack = new ArrayList<>();
        int i = 0;
        while(i < values.length) {
            int runStart = i;
            int runLength = countRunAndMakeAscending(values, i, sortingStates);
            if(runLength < minRun) {
                int runEnd = Math.min(i + minRun - 1, values.length - 1);
                runLength = runEnd - i + 1;
                insertionSort(values, i, runEnd, sortingStates);
            }
            runStack.add(new Run(runStart, runLength));
            i += runLength;

            while(runStack.size() > 1) {
                if(runStack.size() >= 3 && runStack.get(runStack.size() - 3).len > runStack.get(runStack.size() - 2).len + runStack.getLast().len)
                    break;
                if(runStack.get(runStack.size() - 2).len <= runStack.getLast().len) {
                    Run runY = runStack.get(runStack.size() - 2);
                    Run runZ = runStack.getLast();
                    merge(values, runY.start, runY.start + runY.len - 1, runZ.start + runZ.len - 1, sortingStates);
                    runY.len += runZ.len;
                    runStack.removeLast();
                } else
                    break;
            }
        }
        while(runStack.size() > 1) {
            Run runY = runStack.get(runStack.size() - 2);
            Run runZ = runStack.getLast();
            merge(values, runY.start, runY.start + runY.len - 1, runZ.start + runZ.len - 1, sortingStates);
            runY.len += runZ.len;
            runStack.removeLast();
        }
        sortingStates.add(toList(values));
        return sortingStates;
    }

    private static int countRunAndMakeAscending(int[] values, int start, List<List<Integer>> sortingStates) {
        if(start >= values.length - 1)
            return 1;

        int runLength = 2;
        if(values[start] <= values[start + 1]) {
            while(runLength < values.length - start && values[start + runLength - 1] <= values[start + runLength])
                runLength++;
        } else {
            while (runLength < values.length - start && values[start + runLength - 1] > values[start + runLength])
                runLength++;

            for(int i = 0; i < runLength / 2; i++) {
                int temp = values[start + i];
                values[start + i] = values[start + (runLength - 1 - i)];
                values[start + (runLength - 1 - i)] = temp;
            }
            sortingStates.add(toList(values));

        }
        return runLength;
    }

    private static int minRunLength(int x) {
        if (x < MIN_MERGE)
            return x;
        int r = 0;
        while (x >= MIN_MERGE) {
            r |= (x & 1);
            x >>= 1;
        }
        return Math.max(MIN_MERGE, x + r);
    }

    private static void merge(int[] values, int left, int mid, int right, List<List<Integer>> sortingStates) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];
        System.arraycopy(values, left, leftArray, 0, len1);
        for (int j = 0; j < len2; j++)
            rightArray[j] = values[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;
        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j])
                values[k++] = leftArray[i++];
            else
                values[k++] = rightArray[j++];
            sortingStates.add(toList(values));
        }

        while (i < len1) {
            values[k++] = leftArray[i++];
            sortingStates.add(toList(values));
        }

        while (j < len2) {
            values[k++] = rightArray[j++];
            sortingStates.add(toList(values));
        }
    }

    private static class Run {
        int start, len;

        Run(int start, int len) {
            this.start = start;
            this.len = len;
        }
    }
}