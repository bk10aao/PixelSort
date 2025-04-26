package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Model.SortInput;
import visualizer.Controller.Algorithms.SelectionSort;
import visualizer.Model.SortResponse;

@RestController
public class SelectionSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/selection-sort")
    public SortResponse selectionSort(@RequestBody SortInput sortInput) {
        return new SortResponse(SelectionSort.sort(sortInput.getValues()));
    }
}
