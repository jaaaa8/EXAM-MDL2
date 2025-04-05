package model;

public class FakePhone extends Phone{
    private String countryName;
    private String status;

    public FakePhone(int id, String name, double price, int amount, String nxs,String countryName, String status) {
        super(id, name, price, amount, nxs);
        this.countryName = countryName;
        this.status = status;
    }


    public FakePhone(){}

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getData() {
        return super.getData() + ","+countryName+","+status;
    }
}
