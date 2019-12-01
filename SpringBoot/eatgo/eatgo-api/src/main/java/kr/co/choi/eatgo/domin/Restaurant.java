package kr.co.choi.eatgo.domin;

public class Restaurant {

    private  final String name;
    private final String address;


    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return name+address;
    }

    public String getAddress() {
        return address;
    }
}
