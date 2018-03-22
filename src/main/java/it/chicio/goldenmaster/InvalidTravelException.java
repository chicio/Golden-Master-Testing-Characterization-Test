package it.chicio.goldenmaster;

public class InvalidTravelException extends Throwable {
    InvalidTravelException(String message) {
        System.out.println(message);
    }
}
