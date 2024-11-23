import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Quản lý liên hệ");
            System.out.println("2. Quản lý nhóm liên hệ");
            System.out.println("3. Báo cáo thống kê");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("QUẢN LÝ LIÊN HỆ:");
                    System.out.println("1. Thêm liên hệ");
                    System.out.println("2. Sửa liên hệ");
                    System.out.println("3. Xóa liên hệ");
                    System.out.println("4. Hiển thị toàn bộ danh sách");
                    System.out.println("5. Tìm kiếm liên hệ theo tên");
                    System.out.println("6. Sắp xếp liên hệ theo tên");
                    System.out.println("7. Quay lại");
                    System.out.print("Chọn: ");
                    int contactChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (contactChoice) {
                        case 1:
                            System.out.print("Nhập ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Nhập tên: ");
                            String name = scanner.nextLine();
                            System.out.print("Nhập số điện thoại: ");
                            String phone = scanner.nextLine();
                            System.out.print("Nhập email: ");
                            String email = scanner.nextLine();
                            System.out.print("Nhập địa chỉ: ");
                            String address = scanner.nextLine();
                            System.out.print("Nhập ghi chú: ");
                            String note = scanner.nextLine();
                            manager.addContact(new Contact(id, name, phone, email, address, note));
                            break;
                        case 2:
                            System.out.print("Nhập ID liên hệ cần sửa: ");
                            String editId = scanner.nextLine();
                            System.out.print("Nhập tên mới: ");
                            String newName = scanner.nextLine();
                            System.out.print("Nhập số điện thoại mới: ");
                            String newPhone = scanner.nextLine();
                            System.out.print("Nhập email mới: ");
                            String newEmail = scanner.nextLine();
                            System.out.print("Nhập địa chỉ mới: ");
                            String newAddress = scanner.nextLine();
                            System.out.print("Nhập ghi chú mới: ");
                            String newNote = scanner.nextLine();
                            manager.editContact(editId, newName, newPhone, newEmail, newAddress, newNote);
                            break;
                        case 3:
                            System.out.print("Nhập ID liên hệ cần xóa: ");
                            String deleteId = scanner.nextLine();
                            manager.deleteContact(deleteId);
                            break;
                        case 4:
                            manager.displayAllContacts();
                            break;
                        case 5:
                            System.out.print("Nhập tên cần tìm: ");
                            String searchName = scanner.nextLine();
                            manager.searchContactsByName(searchName);
                            break;
                        case 6:
                            manager.sortContactsByName();
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 2:
                    System.out.println("QUẢN LÝ NHÓM LIÊN HỆ:");
                    System.out.println("1. Thêm nhóm");
                    System.out.println("2. Thêm liên hệ vào nhóm");
                    System.out.println("3. Sửa nhóm ");
                    System.out.println("4. Xóa nhóm");
                    System.out.println("5. Xóa liên hệ khỏi nhóm");
                    System.out.println("6. Hiển thị toàn bộ nhóm");
                    System.out.println("7. Quay lại");
                    System.out.print("Chọn: ");
                    int groupChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (groupChoice) {
                        case 1:
                            System.out.print("Nhập tên nhóm: ");
                            String groupName = scanner.nextLine();
                            System.out.print("Nhập mô tả nhóm: ");
                            String description = scanner.nextLine();
                            manager.addGroup(new ContactGroup(groupName, description));
                            break;
                        case 2:
                            System.out.print("Nhập tên nhóm: ");
                            String addToGroupName = scanner.nextLine();
                            System.out.print("Nhập ID liên hệ cần thêm vào nhóm: ");
                            String contactId = scanner.nextLine();
                            Contact contactToAdd = manager.getContactById(contactId);
                            if (contactToAdd != null) {
                                manager.addContactToGroup(addToGroupName, contactToAdd);
                            } else {
                                System.out.println("Không tìm thấy liên hệ với ID: " + contactId);
                            }
                            break;
                        case 3:
                            System.out.print("Nhập tên nhóm cần sửa: ");
                            String editGroupName = scanner.nextLine();
                            System.out.print("Nhập tên nhóm mới: ");
                            String newGroupName = scanner.nextLine();
                            System.out.print("Nhập mô tả mới: ");
                            String newDescription = scanner.nextLine();
                            manager.editGroup(editGroupName, newGroupName, newDescription);
                            break;
                        case 4:
                            System.out.print("Nhập tên nhóm cần xóa: ");
                            String deleteGroupName = scanner.nextLine();
                            manager.deleteGroup(deleteGroupName);
                            break;
                        case 5:
                            System.out.print("Nhập tên nhóm: ");
                            String removeFromGroupName = scanner.nextLine();
                            System.out.print("Nhập ID liên hệ cần xóa khỏi nhóm: ");
                            String removeContactId = scanner.nextLine();
                            manager.removeContactFromGroup(removeFromGroupName, removeContactId);
                            break;
                        case 6:
                            manager.displayContactsByGroup();
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 3:
                    manager.displayContactsByGroup();
                    break;

                case 4:
                    System.out.println("Chương trình kết thúc.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
