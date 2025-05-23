package ed.lab;
import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    private final Map<String, Integer> mensajeTimestamp;

    public E02Logger() {
        mensajeTimestamp = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!mensajeTimestamp.containsKey(message) || timestamp >= mensajeTimestamp.get(message)) {
        mensajeTimestamp.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}