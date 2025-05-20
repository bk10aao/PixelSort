package visualizer.Model;

import java.util.List;

public class SortResponse {

    private List<List<Integer>> results;

    public SortResponse(final List<List<Integer>> results) {
        this.results = results;
    }

    public List<List<Integer>> getResults() {
        return this.results;
    }

    public void setResults(List<List<Integer>> results) {
        this.results = results;
    }
}
