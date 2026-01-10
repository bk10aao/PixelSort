package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Model.SortInput;
import visualizer.Controller.Algorithms.QuickSort;
import visualizer.Model.SortResponse;

@RestController
public class QuickSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
    @PostMapping("/quick-sort")
    public SortResponse quickSort(@RequestBody SortInput sortInput) {
        return new SortResponse(QuickSort.sort(sortInput.getValues()));
    }
}
