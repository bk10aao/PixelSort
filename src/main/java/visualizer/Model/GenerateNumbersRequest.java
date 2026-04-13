package visualizer.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class GenerateNumbersRequest {

    @NotNull
    @Min(1)
    @Max(100)
    private int value;

    @NotNull
    @Min(1)
    @Max(100)
    private int maxRange;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
    }
}
