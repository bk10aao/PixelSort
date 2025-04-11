package visualizer.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Model.SortInput;
import visualizer.Controller.Algorithms.QuickSort;
import visualizer.Model.SortResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuickSortController {

    @PostMapping("/quick-sort")
    public SortResponse quickSort(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = new ArrayList<>();
        QuickSort.sort(values, results);
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        return new SortResponse(results);
    }
}
