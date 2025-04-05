import model.FakePhone;
import model.RealPhone;
import service.PhoneInput;
import service.PhoneService;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.println("=======CHƯƠNG TRÌNH QUẢN LÍ ĐIỆN THOẠI=======");
            System.out.println("1.Thêm mới");
            System.out.println("1.Xóa");
            System.out.println("3.Xem danh sách điện thoại");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Thoát");
            System.out.println("Chọn chức năng: ");
            int choice;
            try {
                choice = sc.nextInt();
            }catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại");
                continue;
            }
            PhoneService phoneService = new PhoneService();

            switch (choice) {
                case 1:
                    while (true){
                        System.out.println("Bạn muốn thêm mới kiểu điện thoại nào: ");
                        System.out.println("1.Điện thoại chính hãng.");
                        System.out.println("2.Điện thoại xách tay.");
                        int choice2;
                        try{
                            choice2 = sc.nextInt();
                        }catch (NumberFormatException e) {
                            System.err.println("Nhập vào số nguyên!");
                            continue;
                        }

                        if (choice2 == 1){
                            RealPhone realPhone = PhoneInput.inputRealPhone();
                            phoneService.addRealPhone(realPhone);
                            System.out.println("Thêm điện thoại chính hãng thành công!");
                            break;
                        }else if (choice2 == 2){
                            FakePhone fakePhone = PhoneInput.inputFakePhone();
                            phoneService.addFakePhone(fakePhone);
                            System.out.println("Thêm điện thoại xách tay thành công!");
                            break;
                        }else{
                            System.out.println("Nhập sai lựa chọn");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Xóa điện thoại:");
                    System.out.println("Nhập vào id muốn xóa: ");
                    int id;
                    try{
                        id = sc.nextInt();
                    }catch (NumberFormatException e) {
                        System.out.println("Nhập vào số nguyên!");
                        continue;
                    }
                    phoneService.removePhone(id);
                    break;
                case 3:
                    System.out.println("In ra danh sách điện thoại: ");
                    phoneService.showPhoneList();
                    break;
                case 4:
                    System.out.println("Tìm tên điện thoại gần giống: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    phoneService.findPhoneByName(name);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Nhập lựa chọn từ 1 -> 5!");
            }
            if(choice == 5){
                break;
            }
        }

    }
}