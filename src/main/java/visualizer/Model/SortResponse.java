package visualizer.Model;

import java.util.List;

public class SortResponse {
    private final List<List<Integer>> results;

    public SortResponse(final List<List<Integer>> results) {
        this.results = results;
    }

    public List<List<Integer>> getResults() {
        return this.results;
    }
}
