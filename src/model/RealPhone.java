package model;

public class RealPhone extends Phone {
    private int thoiGianBH;
    private String isDomestic;

    public RealPhone() {}

    public RealPhone(int id, String name, double price, int amount, String nxs, int thoiGianBH, String isDomestic) {
        super(id, name, price, amount, nxs);
        this.thoiGianBH = thoiGianBH;
        this.isDomestic = isDomestic;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public String getIsDomestic() {
        return isDomestic;
    }

    public void setIsDomestic(String isDomestic) {
        this.isDomestic = isDomestic;
    }

    @Override
    public String getData() {
        return super.getData() +","+thoiGianBH+","+isDomestic;
    }
}
