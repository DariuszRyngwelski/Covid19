package thread;

import api.entity.api.GetApi;
import api.entity.api.GetListCountry;

public class RefreshApi {

    public static void countryList(){
        Thread thread = new Thread(() -> {
            GetApi<?> listCountry = new GetListCountry();
            if(!listCountry.addBase()){
                System.out.println("Get not api or error added element to base!!!");
            }
        });
        thread.start();
    }
}
