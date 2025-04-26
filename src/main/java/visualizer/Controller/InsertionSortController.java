package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.InsertionSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

@RestController
public class InsertionSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/insertion-sort")
    public SortResponse insertionSort(@RequestBody SortInput sortInput) {
        return new SortResponse(InsertionSort.sort( sortInput.getValues()));
    }
}
