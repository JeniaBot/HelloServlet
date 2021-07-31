package kaluzny.example.jee.uuid;

import java.util.UUID;

public class UuidGenerator {

    public String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
