package service;

import model.FakePhone;
import model.RealPhone;

import java.util.Scanner;

public class PhoneInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static RealPhone inputRealPhone() {
        System.out.println("=== Nhập thông tin RealPhone ===");

        String name = inputName();
        double price = inputPrice();
        int amount = inputAmount();
        String manufacturer = inputManufacturer();
        int warranty = inputWarranty();
        String scope = inputScope();
        return new RealPhone(0, name, price, amount, manufacturer, warranty, scope);
    }

    private static String inputName() {
        System.out.print("Tên điện thoại: ");
        return scanner.nextLine();
    }

    private static double inputPrice() {
        double price = 0;
        while (true) {
            try {
                System.out.print("Giá: ");
                String priceInput = scanner.nextLine();
                if (!priceInput.matches("\\d+(\\.\\d{1,2})?")) {
                    throw new IllegalArgumentException("Giá phải là số hợp lệ, ví dụ: 2500000 hoặc 2500000.99");
                }
                price = Double.parseDouble(priceInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" Lỗi: " + e.getMessage());
            }
        }
        return price;
    }

    private static int inputAmount() {
        int amount = 0;
        while (true) {
            try {
                System.out.print("Số lượng: ");
                String amountInput = scanner.nextLine();
                if (!amountInput.matches("\\d+")) {
                    throw new IllegalArgumentException("Số lượng phải là số nguyên.");
                }
                amount = Integer.parseInt(amountInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        return amount;
    }

    private static String inputManufacturer() {
        System.out.print("Nhà sản xuất: ");
        return scanner.nextLine();
    }

    private static int inputWarranty() {
        int warranty = 0;
        while (true) {
            try {
                System.out.print("Thời gian bảo hành (tháng): ");
                String warrantyInput = scanner.nextLine();
                if (!warrantyInput.matches("\\d+")) {
                    throw new IllegalArgumentException("Bảo hành phải là số nguyên.");
                }
                warranty = Integer.parseInt(warrantyInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        return warranty;
    }

    private static String inputScope() {
        String scope = "";
        while (true) {
            System.out.print("Phạm vi bảo hành (Toan quoc / Quoc te): ");
            scope = scanner.nextLine();
            if (scope.matches("Toan quoc|Quoc te")) {
                break;
            } else {
                System.out.println("Phạm vi bảo hành chỉ có thể là 'Toan quoc' hoặc 'Quoc te'.");
            }
        }
        return scope;
    }

    public static FakePhone inputFakePhone() {
        System.out.println("=== Nhập thông tin FakePhone ===");

        String name = inputName();
        double price = inputPrice();
        int amount = inputAmount();
        String manufacturer = inputManufacturer();
        String countryName = inputCountryName();
        String status = inputStatus();

        return new FakePhone(0, name, price, amount, manufacturer, countryName, status);
    }

    private static String inputCountryName() {
        System.out.print("Quốc gia sản xuất (ví dụ: Trung Quốc): ");
        return scanner.nextLine();
    }

    private static String inputStatus() {
        String status = "";
        while (true) {
            System.out.print("Tình trạng sửa chữa (Da sua chua / Chua sua chua): ");
            status = scanner.nextLine();
            if (status.matches("Da sua chua|Chua sua chua")) {
                break;
            } else {
                System.out.println("Tình trạng sửa chữa chỉ có thể là 'Da sua chua' hoặc 'Chua sua chua'.");
            }
        }
        return status;
    }
}
