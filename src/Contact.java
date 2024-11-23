public class Contact {
    private String contactId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String note;

    public Contact(String contactId, String name, String phoneNumber, String email, String address, String note) {
        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.note = note;
    }

    public String getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ID: " + contactId + ", Tên: " + name + ", Số điện thoại: " + phoneNumber +
                ", Email: " + email + ", Địa chỉ: " + address + ", Ghi chú: " + note;
    }
}
