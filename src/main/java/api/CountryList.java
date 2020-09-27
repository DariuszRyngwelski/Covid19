package api;

import java.time.LocalDateTime;
import java.util.List;

public class CountryList<T> implements Covid19Api<T> {
    private final String uri = "https://api.covid19api.com/countries";
    private LocalDateTime time;
    private GetWebApi<T> list;

    public CountryList() {
        if (!refresh()) System.out.println("No get Api CoinList");
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public boolean refresh() {
        list = new GetWebApi<>(uri);
        if (list.getListCoin() != null) {
            time = LocalDateTime.now();
            return true;
        } else {
            time = null;
            return false;
        }
    }

    @Override
    public List<T> getList() {
        return list.getListCoin();
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }
}
