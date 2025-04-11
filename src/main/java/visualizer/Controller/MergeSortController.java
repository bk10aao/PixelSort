package visualizer.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.MergeSort;
import visualizer.Controller.Algorithms.MergeSortTwo;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MergeSortController {

    @PostMapping("/merge-sort")
    public SortResponse mergeSort(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = new ArrayList<>();
        MergeSort.sort(values, results);
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        return new SortResponse(results);
    }

    @PostMapping("/merge-sort-two")
    public SortResponse mergeSortTwo(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = new ArrayList<>();
        MergeSortTwo.sort(values, results);
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        return new SortResponse(results);
    }
}
