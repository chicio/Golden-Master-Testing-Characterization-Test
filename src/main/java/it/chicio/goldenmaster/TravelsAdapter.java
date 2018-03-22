package it.chicio.goldenmaster;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TravelsAdapter {
    public List<Travel> adapt(JsonNode jsonNode) throws InvalidTravelException {
        List<Travel> travels = new ArrayList<>();
        JsonNode payloadNode = jsonNode.with("data");
        if (payloadNode.findValue("orderId") == null || StringUtils.isBlank(payloadNode.findValue("orderId").textValue())) {
            throw new InvalidTravelException("Invalid order id");
        }
        long orderId = payloadNode.findValue("orderId").asLong();
        JsonNode flights = payloadNode.withArray("flights");
        if (flights.size() == 0) {
            throw new InvalidTravelException("Invalid json (no flights)");
        }
        flights.iterator().forEachRemaining(flight -> {
            ObjectNode nodeFlight = (ObjectNode) flight;
            if (nodeFlight.get("flightId") == null || StringUtils.isBlank(nodeFlight.get("flightId").textValue())) {
                try {
                    throw new InvalidTravelException("Invalid flightNumber value");
                } catch (InvalidTravelException e) {
                    e.printStackTrace();
                }
            }
            String flightNumber = nodeFlight.get("flightId").textValue();
            String arrivalAirport = nodeFlight.get("to").textValue();
            String departureAirport = nodeFlight.get("departure").textValue();
            String airline = nodeFlight.get("airline").textValue();
            travels.add(new Travel(
                            orderId,
                            flight.toString(),
                            flightNumber,
                            airline,
                            departureAirport,
                            arrivalAirport));
        });
        return travels;
    }
}
