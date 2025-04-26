package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.PancakeSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PancakeSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/pancake-sort")
    public SortResponse pancakeSort(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = new ArrayList<>();
        PancakeSort.sort(values, results);
        return new SortResponse(results);
    }
}
