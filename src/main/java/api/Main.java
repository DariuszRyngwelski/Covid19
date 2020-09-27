package api;

import api.entity.Covid19_CountryApiEntity;

public class Main {
    public static void main(String[] args) {
        Covid19Api<?> c = new CountryList<Covid19_CountryApiEntity>();
        System.out.println(c.getList());
        System.out.println(c.getUri());
    }
}
