package visualizer.Controller.Algorithms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import visualizer.Controller.Algorithms.Commons;
import visualizer.Model.SortInput;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BubbleSortControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private SortInput sortInput;

    @BeforeEach
    void setUp() {
        sortInput = new SortInput();
    }

    @Test
    void testBubbleSort_with_testArrayOne_returns_sortedResponse() throws Exception {

        sortInput.setValues(Commons.testArrayOne);
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[-1]", is(Commons.expectedResultOne)));
    }


    @Test
    void testBubbleSort_with_testArrayTwo_returns_sortedResponse() throws Exception {

        sortInput.setValues(Commons.testArrayTwo);
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[-1]", is(Commons.expectedResultTwo)));
    }

    @Test
    void testBubbleSort_with_testArrayThree_returns_sortedResponse() throws Exception {

        sortInput.setValues(Commons.testArrayThree);
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[-1]", is(Commons.expectedResultThree)));
    }

    @Test
    void testBubbleSortEmptyArray() throws Exception {
        sortInput.setValues(new int[]{});
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testBubbleSortNullInput() throws Exception {
        sortInput.setValues(null);
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testBubbleSortSingleElement() throws Exception {
        sortInput.setValues(new int[]{1});
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results", hasSize(1)))
                .andExpect(jsonPath("$.results[0]", is(Arrays.asList(1))));
    }

    @Test
    void testBubbleSortAlreadySorted() throws Exception {
        sortInput.setValues(new int[]{1, 2, 3});
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results", hasSize(1)))
                .andExpect(jsonPath("$.results[0]", is(Arrays.asList(1, 2, 3))));
    }

    @Test
    void testBubbleSortInvalidJson() throws Exception {
        String invalidJson = "{ \"values\": \"not_an_array\" }";

        mockMvc.perform(post("/bubble-sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}