package api.utils;

import api.entity.api.GetApi;
import api.entity.api.GetListCountry;

public class Main {
    // Test hibernate

    public static void main(String[] args) {
        GetApi<?> g = new GetListCountry();
        System.out.println(g.getList());
        System.out.println("AddBase: " + g.addBase());
    }

}
