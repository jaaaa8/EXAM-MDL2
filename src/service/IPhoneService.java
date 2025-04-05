package service;

import model.FakePhone;
import model.Phone;
import model.RealPhone;

import java.util.List;

public interface IPhoneService {
    void addRealPhone(RealPhone phone);
    void addFakePhone(FakePhone phone);
    void removePhone(int id);
    void showPhoneList();
    List<Phone> getPhoneList();
    void findPhoneByName(String name);
}
