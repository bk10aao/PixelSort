package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.ShellSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

@RestController
public class ShellSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/shell-sort")
    public SortResponse shellSort(@RequestBody SortInput sortInput) {;
        return new SortResponse(ShellSort.sort(sortInput.getValues()));
    }
}
