import java.util.ArrayList;

public class ContactGroup {
    private String groupName;
    private String description;
    private ArrayList<Contact> contacts;

    public ContactGroup(String groupName, String description) {
        this.groupName = groupName;
        this.description = description;
        this.contacts = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public void removeContactById(String contactId) {
        contacts.removeIf(contact -> contact.getContactId().equals(contactId));
    }

    @Override
    public String toString() {
        return "Tên nhóm: " + groupName + ", Mô tả: " + description +
                ", Liên hệ: " + contacts.size();
    }
}
