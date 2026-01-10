package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.InPlaceMergeSort;
import visualizer.Controller.Algorithms.MergeSortTopDown;
import visualizer.Controller.Algorithms.MergeSortBottomUp;
import visualizer.Controller.Algorithms.ParallelMergeSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

@RestController
public class MergeSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
    @PostMapping("/in-place-merge-sort")
    public SortResponse inPlaceMergeSort(@RequestBody SortInput sortInput) {
        return new SortResponse(InPlaceMergeSort.sort(sortInput.getValues()));
    }

    @CrossOrigin(origins = "http://localhost:5173", methods =  { RequestMethod.POST, RequestMethod.OPTIONS })
    @PostMapping("/merge-sort-top-down")
    public SortResponse mergeSort(@RequestBody SortInput sortInput) {
        return new SortResponse(MergeSortTopDown.sort(sortInput.getValues()));
    }

    @CrossOrigin(origins = "http://localhost:5173", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
    @PostMapping("/merge-sort-bottom-up")
    public SortResponse mergeSortTwo(@RequestBody SortInput sortInput) {
        return new SortResponse(MergeSortBottomUp.sort(sortInput.getValues()));
    }

    @CrossOrigin(origins = "http://localhost:5173", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
    @PostMapping("/parallel-merge-sort")
    public SortResponse parallelMergeSort(@RequestBody SortInput sortInput) {
        return new SortResponse(ParallelMergeSort.sort(sortInput.getValues()));
    }
}
