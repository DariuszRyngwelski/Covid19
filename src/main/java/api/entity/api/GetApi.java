package api.entity.api;

import java.time.LocalDateTime;
import java.util.List;

public interface GetApi<T> {

    List<T> getList();

    String getUri();

    LocalDateTime getTime();

    boolean addBase();
}
