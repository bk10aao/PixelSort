package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.InsertionSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InsertionSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/insertion-sort")
    public SortResponse insertionSort(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = new ArrayList<>();
        InsertionSort.sort(values, results);
        return new SortResponse(results);
    }
}
