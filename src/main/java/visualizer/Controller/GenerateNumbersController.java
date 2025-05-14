package visualizer.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visualizer.Model.GenerateNumbersRequest;
import visualizer.Model.GeneratorNumbersResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class GenerateNumbersController {

    @PostMapping("/generate-numbers")
    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    public GeneratorNumbersResponse generateNumbers(@RequestBody GenerateNumbersRequest generateNumberRequest) {
        Integer value = generateNumberRequest.getValue();

        if(value == null || value > 100 || value < 0)
            value = 100;

        Integer maxRange = generateNumberRequest.getMaxRange();
        if(maxRange == null || maxRange < 1 || maxRange > 100)
            maxRange = 100;
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < value; i++)
            randomNumbers.add(random.nextInt(maxRange + 1));

        return new GeneratorNumbersResponse(randomNumbers);
    }
}
