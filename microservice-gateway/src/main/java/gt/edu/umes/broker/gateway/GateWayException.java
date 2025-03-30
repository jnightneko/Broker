package gt.edu.umes.broker.gateway;

public class GateWayException extends RuntimeException {
    public GateWayException() {
    }

    public GateWayException(String message) {
        super(message);
    }

    public GateWayException(String message, Throwable cause) {
        super(message, cause);
    }
}
