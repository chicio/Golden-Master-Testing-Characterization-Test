import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.chicio.goldenmaster.TravelsAdapter;
import it.chicio.goldenmaster.Travel;
import it.chicio.goldenmaster.InvalidTravelException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TravelsAdapterTest {

    @Test
    public void goldenMaster() throws IOException, InvalidTravelException {
        TravelsAdapter travelsAdapter = new TravelsAdapter();

        List<Travel> travels = travelsAdapter.adapt(generateRequest());

        StringBuilder builder = new StringBuilder();
        travels.forEach(bp -> {
            builder.append(bp.toString());
            builder.append("\n");
        });
        assertThat(
                builder.toString(),
                is("Travel{" +
                            "orderId=0, " +
                            "flights='{" +
                                "\"from\":\"MXP\"," +
                                "\"to\":\"FCO\"," +
                                "\"flightId\":\"1111\"," +
                                "\"direction\":\"OUTBOUND\"," +
                                "\"airline\":\"U2\"," +
                                "\"departure\":\"2018-04-20T12:00:00\"," +
                                "\"boardingCard\":{" +
                                    "\"id\":\"485\"," +
                                    "\"firstName\":\"Fabrizio\"," +
                                    "\"lastName\":\" Duroni\"," +
                                    "\"seat\":\"V23\"," +
                                    "\"urls\":[" +
                                        "\"http://aboardingcard/resource1\"," +
                                        "\"http://aboardingcard/resource2\"," +
                                        "\"http://aboardingcard/resource3\"" +
                                "]}}', " +
                                "flightId='1111', " +
                                "airline='U2', " +
                                "departureAirport='MXP', " +
                                "arrivalAirport='FCO'" +
                          "}\n" +
                        "Travel{" +
                            "orderId=0, " +
                            "flights='{" +
                                "\"from\":\"FCO\"," +
                                "\"to\":\"MXP\"," +
                                "\"flightId\":\"1112\"," +
                                "\"direction\":\"RETURN\"," +
                                "\"airline\":\"AA\"," +
                                "\"departure\":\"2018-05-01T10:00:00\"," +
                                "\"boardingCard\":{" +
                                    "\"id\":\"486\"," +
                                    "\"firstName\":\"Chiara\"," +
                                    "\"lastName\":\"Polito\"," +
                                    "\"seat\":\"A15\"," +
                                    "\"urls\":[" +
                                        "\"http://aboardingcard/resource1\"," +
                                        "\"http://aboardingcard/resource2\"," +
                                        "\"http://aboardingcard/resource3\"" +
                                    "]}}', " +
                                    "flightId='1112', " +
                                    "airline='AA', " +
                                    "departureAirport='FCO', " +
                                    "arrivalAirport='MXP'" +
                        "}\n"
                )
        );
    }

    private JsonNode generateRequest() throws IOException {
        return new ObjectMapper().readTree(
                "{\n" +
                "  \"data\": {\n" +
                "    \"orderId\": \"73hb6yh3be6ebe63bdy6\",\n" +
                "    \"flights\": [\n" +
                "      {\n" +
                "        \"from\": \"MXP\",\n" +
                "        \"to\": \"FCO\",\n" +
                "        \"flightId\": \"1111\",\n" +
                "        \"direction\": \"OUTBOUND\",\n" +
                "        \"airline\": \"U2\",\n" +
                "        \"departure\": \"2018-04-20T12:00:00\",\n" +
                "        \"boardingCard\": {\n" +
                "            \"id\": \"485\",\n" +
                "            \"firstName\": \"Fabrizio\",\n" +
                "            \"lastName\": \" Duroni\",\n" +
                "            \"seat\": \"V23\",\n" +
                "            \"urls\": [\n" +
                "              \"http://aboardingcard/resource1\",\n" +
                "              \"http://aboardingcard/resource2\",\n" +
                "              \"http://aboardingcard/resource3\"\n" +
                "            ]\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"from\": \"FCO\",\n" +
                "        \"to\": \"MXP\",\n" +
                "        \"flightId\": \"1112\",\n" +
                "        \"direction\": \"RETURN\",\n" +
                "        \"airline\": \"AA\",\n" +
                "        \"departure\": \"2018-05-01T10:00:00\",\n" +
                "        \"boardingCard\": {\n" +
                "            \"id\": \"486\",\n" +
                "            \"firstName\": \"Chiara\",\n" +
                "            \"lastName\": \"Polito\",\n" +
                "            \"seat\": \"A15\",\n" +
                "            \"urls\": [\n" +
                "              \"http://aboardingcard/resource1\",\n" +
                "              \"http://aboardingcard/resource2\",\n" +
                "              \"http://aboardingcard/resource3\"\n" +
                "            ]\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}"
        );
    }
}
