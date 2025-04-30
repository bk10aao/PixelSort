package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.ParallelMergeSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

@RestController
public class ParallelMergeSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/parallel-merge-sort")
    public SortResponse parallelMergeSort(@RequestBody SortInput sortInput) {
        return new SortResponse(ParallelMergeSort.sort(sortInput.getValues()));
    }
}
