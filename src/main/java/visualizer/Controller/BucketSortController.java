package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.BucketSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

@RestController
public class BucketSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
    @PostMapping("/bucket-sort")
    public SortResponse bucketSort(@RequestBody SortInput sortInput) {
        return new SortResponse(BucketSort.sort(sortInput.getValues()));
    }
}
