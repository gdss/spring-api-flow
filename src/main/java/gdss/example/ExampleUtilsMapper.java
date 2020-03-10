package gdss.example;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class ExampleUtilsMapper {

    private final String DATE_PATTERN = "dd/MM/yyyy HH:mm";

    public String toString(LocalDateTime date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)) : null;
    }

    public LocalDateTime toDate(String date) {
        return date != null ? LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN)) : null;
    }

    public String toString(UUID id) {
        if (id == null) {
            return null;
        }

        return id.toString();
    }

    public UUID toUUID(String id) {
        if (id == null) {
            return null;
        }

        return UUID.fromString(id);
    }

}