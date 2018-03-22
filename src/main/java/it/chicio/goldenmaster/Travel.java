package it.chicio.goldenmaster;

public class Travel {
    private final long orderId;
    private final String flights;
    private final String flightId;
    private final String airline;
    private final String departureAirport;
    private final String arrivalAirport;

    Travel(long orderId,
           String flights,
           String flightId,
           String airline,
           String departureAirport,
           String arrivalAirport) {
        this.orderId = orderId;
        this.flights = flights;
        this.flightId = flightId;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public String toString() {
        return "Travel{" +
                    "orderId=" + orderId + ", " +
                    "flights='" + flights + '\'' + ", " +
                    "flightId='" + flightId + '\'' + ", " +
                    "airline='" + airline + '\'' + ", " +
                    "departureAirport='" + departureAirport + '\'' + ", " +
                    "arrivalAirport='" + arrivalAirport + '\'' +
                '}';
    }
}
