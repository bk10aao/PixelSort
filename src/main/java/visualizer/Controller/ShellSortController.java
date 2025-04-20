package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Controller.Algorithms.ShellSort;
import visualizer.Model.SortInput;
import visualizer.Model.SortResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShellSortController {

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/shell-sort")
    public SortResponse shellSort(@RequestBody SortInput sortInput) {
        int[] values = sortInput.getValues();
        List<List<Integer>> results = new ArrayList<>();
        ShellSort.sort(values, results);
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        System.out.println("quick sort");

        for(List<Integer> val: results) {
            System.out.println(val);
        }
        return new SortResponse(results);
    }
}
