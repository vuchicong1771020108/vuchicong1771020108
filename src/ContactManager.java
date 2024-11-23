import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContactManager {
    ArrayList<Contact> contacts;
    ArrayList<ContactGroup> groups;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    // Quản lý liên hệ
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Đã thêm liên hệ: " + contact);
    }

    public void editContact(String contactId, String name, String phoneNumber, String email, String address, String note) {
        Contact contact = getContactById(contactId);
        if (contact != null) {
            contact.setName(name);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            contact.setAddress(address);
            contact.setNote(note);
            System.out.println("Đã sửa liên hệ: " + contact);
        } else {
            System.out.println("Không tìm thấy liên hệ với ID: " + contactId);
        }
    }

    public void deleteContact(String contactId) {
        Contact contact = getContactById(contactId);
        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Đã xóa liên hệ: " + contact);
        } else {
            System.out.println("Không tìm thấy liên hệ với ID: " + contactId);
        }
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh sách liên hệ trống.");
        } else {
            System.out.println("Danh sách liên hệ:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchContactsByName(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy liên hệ với tên: " + name);
        }
    }

    public void sortContactsByName() {
        Collections.sort(contacts, Comparator.comparing(Contact::getName));
        System.out.println("Danh sách liên hệ đã được sắp xếp theo tên.");
    }

    // Quản lý nhóm liên hệ
    public void addGroup(ContactGroup group) {
        groups.add(group);
        System.out.println("Đã thêm nhóm: " + group);
    }

    public void editGroup(String groupName, String newGroupName, String description) {
        ContactGroup group = getGroupByName(groupName);
        if (group != null) {
            group.setGroupName(newGroupName);
            group.setDescription(description);
            System.out.println("Đã sửa nhóm: " + group);
        } else {
            System.out.println("Không tìm thấy nhóm với tên: " + groupName);
        }
    }


    public void deleteGroup(String groupName) {
        ContactGroup group = getGroupByName(groupName);
        if (group != null) {
            groups.remove(group);
            System.out.println("Đã xóa nhóm: " + group);
        } else {
            System.out.println("Không tìm thấy nhóm với tên: " + groupName);
        }
    }

    public void addContactToGroup(String groupName, Contact contact) {
        ContactGroup group = getGroupByName(groupName);
        if (group != null) {
            group.addContact(contact);
            System.out.println("Đã thêm liên hệ vào nhóm: " + group.getGroupName());
        } else {
            System.out.println("Không tìm thấy nhóm với tên: " + groupName);
        }
    }

    public void removeContactFromGroup(String groupName, String contactId) {
        ContactGroup group = getGroupByName(groupName);
        if (group != null) {
            group.removeContactById(contactId);
            System.out.println("Đã xóa liên hệ khỏi nhóm: " + groupName);
        } else {
            System.out.println("Không tìm thấy nhóm với tên: " + groupName);
        }
    }


    public void displayAllGroups() {
        if (groups.isEmpty()) {
            System.out.println("Danh sách nhóm trống.");
        } else {
            System.out.println("Danh sách nhóm:");
            for (ContactGroup group : groups) {
                System.out.println(group);
            }
        }
    }

    public void displayContactsByGroup() {
        for (ContactGroup group : groups) {
            System.out.println(group);
            for (Contact contact : group.getContacts()) {
                System.out.println("  " + contact);
            }
        }
    }

    // Helper methods
    public Contact getContactById(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    public ContactGroup getGroupByName(String groupName) {
        for (ContactGroup group : groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                return group;
            }
        }
        return null;
    }
}
