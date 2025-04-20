package visualizer.Model;

import java.util.List;

public class GeneratorNumbersResponse {

    private List<Integer> numbers;

    public GeneratorNumbersResponse(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getResults() {
        return this.numbers;
    }

    public void setResults(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
