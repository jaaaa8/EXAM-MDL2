package service;

import model.FakePhone;
import model.Phone;
import model.RealPhone;
import util.ReadAndWriteData;

import java.util.ArrayList;
import java.util.List;

public class PhoneService implements IPhoneService {
    private static final String filePath = "E:\\EXAM MDL2\\untitled\\src\\data\\mobiles.csv";

    @Override
    public void addRealPhone(RealPhone realPhone) {
        realPhone.setId(getNextId());
        List<String> data = new ArrayList<>();
        data.add(realPhone.getData());
        ReadAndWriteData.writeToFile(filePath, data, true);
    }


    @Override
    public void removePhone(int id) {
        List<Phone> phonesData = getPhoneList();
        boolean isRemoved = false;
        for (int i = phonesData.size() - 1; i >= 0; i--) {
            if (id == (phonesData.get(i).getId())) {
                phonesData.remove(i);
                isRemoved = true;
            }
        }
        if (!isRemoved) {
            System.out.println("Không tìm thấy điện thoại với ID: " + id);
        } else {
            List<String> data = new ArrayList<>();
            for (Phone phone : phonesData) {
                data.add(phone.getData());
            }
            ReadAndWriteData.writeToFile(filePath, data, false);
            System.out.println("Đã xóa điện thoại có ID: " + id);
        }
    }

    @Override
    public void addFakePhone(FakePhone fakePhone) {
        fakePhone.setId(getNextId()); // Gán ID tự động
        List<String> data = new ArrayList<>();
        data.add(fakePhone.getData());
        ReadAndWriteData.writeToFile(filePath, data, true);
    }


    @Override
    public void showPhoneList() {
        List<Phone> phonesData = getPhoneList();
        if(phonesData.isEmpty()){
            System.out.println("DS rong!");
            return;
        }
        System.out.println("DS dt : ");
        for (Phone phone : phonesData) {
            System.out.println(phone.getData());
        }
    }

    @Override
    public List<Phone> getPhoneList() {
        List<Phone> phoneList = new ArrayList<>();
        List<String> lines = ReadAndWriteData.readFile(filePath);

        for (String line : lines) {
            String[] split = line.split(",");
            if (split.length < 7) {
                System.err.println("Dữ liệu không đúng định dạng ở dòng: " + line);
                continue;
            }

            try {
                int id = Integer.parseInt(split[0]);
                String name = split[1];
                double price = Double.parseDouble(split[2]);
                int amount = Integer.parseInt(split[3]);
                String nxs = split[4];
                String fifth = split[5];
                String sixth = split[6];

                // Kiểm tra nếu split[5] là số (bảo hành), split[6] là vùng bảo hành
                if (isInteger(fifth) && (sixth.equals("Toan quoc") || sixth.equals("Quoc te"))) {
                    int warranty = Integer.parseInt(fifth);
                    String phamViBH = sixth;
                    phoneList.add(new RealPhone(id, name, price, amount, nxs, warranty, phamViBH));
                }
                // Ngược lại, nếu split[5] là lý do, split[6] là tình trạng sửa chữa
                else if (!isInteger(fifth) && (sixth.equals("Da sua chua") || sixth.equals("Chua sua chua"))) {
                    String countryName = fifth;
                    String status = sixth;
                    phoneList.add(new FakePhone(id, name, price, amount, nxs, countryName, status));
                } else {
                    System.err.println("Không nhận dạng được loại điện thoại ở dòng: " + line);
                }

            } catch (NumberFormatException e) {
                System.err.println("Lỗi định dạng số ở dòng: " + line);
            }
        }

        return phoneList;
    }

    @Override
    public void findPhoneByName(String name) {
        List<Phone> matchingPhones = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Vui lòng nhập một tên điện thoại hợp lệ.");
            return;
        }
        List<Phone> phones = getPhoneList();
        System.out.println("Những điện thoại có tên gần giống với "+name+" là:");
        for (Phone phone : phones) {
            if (phone.getName().toLowerCase().contains(name.toLowerCase())) {
                matchingPhones.add(phone);
            }
        }

    }


    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int getNextId() {
        List<Phone> phones = getPhoneList();
        int maxId = 0;
        for (Phone phone : phones) {
            if (phone.getId() > maxId) {
                maxId = phone.getId();
            }
        }
        return maxId + 1;
    }


}
