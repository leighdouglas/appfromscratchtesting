package nyc.c4q.leighdouglas.appfromscratchtesting.backend;

import java.util.ArrayList;

/**
 * Created by leighdouglas on 4/5/17.
 */

public class Contacts {
    private ArrayList<ContactInfo> contacts;

    public Contacts(ArrayList<ContactInfo> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<ContactInfo> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ContactInfo> contacts) {
        this.contacts = contacts;
    }
}