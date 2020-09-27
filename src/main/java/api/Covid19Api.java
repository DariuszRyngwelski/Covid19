package api;

import java.time.LocalDateTime;
import java.util.List;

public interface Covid19Api<T> {

    String getUri();

    boolean refresh();

    List<T> getList();

    LocalDateTime getTime();

}
