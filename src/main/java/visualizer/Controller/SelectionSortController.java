package visualizer.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Model.SortInput;
import visualizer.Controller.Algorithms.SelectionSort;
import visualizer.Model.SortResponse;

import java.util.List;

@RestController
public class SelectionSortController {

    @PostMapping("/selection-sort")
    public SortResponse selectionSort(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = SelectionSort.sort(values);
        System.out.println("selection sort");
        for(List<Integer> val: results) {
            System.out.println(val);
        }
        return new SortResponse(results);
    }
}
