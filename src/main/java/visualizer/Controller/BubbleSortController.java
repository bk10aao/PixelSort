package visualizer.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.BubbleSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

import java.util.List;

@RestController
public class BubbleSortController {
    @PostMapping("/bubble-sort")
    public SortResponse bubbleSort(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = BubbleSort.sort(values);
        return new SortResponse(results);
    }
}
