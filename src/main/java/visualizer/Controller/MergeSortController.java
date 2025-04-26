package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.MergeSort;
import visualizer.Controller.Algorithms.MergeSortTwo;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

@RestController
public class MergeSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/merge-sort")
    public SortResponse mergeSort(@RequestBody SortInput sortInput) {
        return new SortResponse(MergeSort.sort(sortInput.getValues()));
    }

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/merge-sort-two")
    public SortResponse mergeSortTwo(@RequestBody SortInput sortInput) {;
        return new SortResponse(MergeSortTwo.sort(sortInput.getValues()));
    }
}
