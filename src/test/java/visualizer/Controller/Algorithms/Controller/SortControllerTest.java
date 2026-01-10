package visualizer.Controller.Algorithms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import visualizer.Controller.Algorithms.Utilities.Utils;
import visualizer.Model.SortInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static visualizer.Controller.Algorithms.Utilities.Utils.ENDPOINTS;

@SpringBootTest
@AutoConfigureMockMvc
public class SortControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private SortInput sortInput;

    @BeforeEach
    void setUp() {
        sortInput = new SortInput();
    }

    public static Stream<Arguments> provideSortEndpointsAndTestCases() {
        List<Utils.TestCase> testCases = Utils.getTestCases();

        return ENDPOINTS.stream()
                .flatMap(endpoint -> testCases.stream()
                        .map(testCase -> Arguments.of(
                                endpoint,
                                testCase.input,
                                testCase.expected,
                                testCase.name
                        )));
    }

    private static Stream<Arguments> provideSortEndpoints() {
        return ENDPOINTS.stream().map(Arguments::of);
    }

    @ParameterizedTest(name = "{3} on {0}")
    @MethodSource("provideSortEndpointsAndTestCases")
    void testSort_validInput_returnsSortedResponse(String endpoint, int[] input, List<Integer> expected) throws Exception {
        sortInput.setValues(input);
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post(endpoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[-1]", is(expected)));
    }

    @ParameterizedTest(name = "empty array on {0}")
    @MethodSource("provideSortEndpoints")
    void testSort_emptyArray_returnsBadRequest(String endpoint) throws Exception {
        sortInput.setValues(new int[]{});
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post(endpoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest(name = "null input on {0}")
    @MethodSource("provideSortEndpoints")
    void testSort_nullInput_returnsBadRequest(String endpoint) throws Exception {
        sortInput.setValues(null);
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post(endpoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest(name = "single element on {0}")
    @MethodSource("provideSortEndpoints")
    void testSort_singleElement_returnsSortedResponse(String endpoint) throws Exception {
        sortInput.setValues(new int[]{1});
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post(endpoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[-1]", is(List.of(1))));
    }

    @ParameterizedTest(name = "already sorted on {0}")
    @MethodSource("provideSortEndpoints")
    void testSort_alreadySorted_returnsSortedResponse(String endpoint) throws Exception {
        sortInput.setValues(new int[]{1, 2, 3});
        String requestBody = objectMapper.writeValueAsString(sortInput);

        mockMvc.perform(post(endpoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[-1]", is(Arrays.asList(1, 2, 3))));
    }

    @ParameterizedTest(name = "invalid JSON on {0}")
    @MethodSource("provideSortEndpoints")
    void testSort_invalidJson_returnsBadRequest(String endpoint) throws Exception {
        String invalidJson = "{ \"values\": \"not_an_array\" }";

        mockMvc.perform(post(endpoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}