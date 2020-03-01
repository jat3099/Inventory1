public class Manufacturer {

    private  String CompanyName;
    private Address CompanyAddress;

    public Manufacturer(String c, Address a) {
        CompanyName = c;
        CompanyAddress = a;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public Address getCompanyAddress() {
        return CompanyAddress;
    }



}

