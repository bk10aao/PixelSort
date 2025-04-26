package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.LSDRadixSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

import java.util.Arrays;

@RestController
public class RadixSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/radix-sort")
    public SortResponse heapSort(@RequestBody SortInput sortInput) {
        return new SortResponse(LSDRadixSort.sort(Arrays.stream( sortInput.getValues() ).boxed().toArray( Integer[]::new )));
    }
}