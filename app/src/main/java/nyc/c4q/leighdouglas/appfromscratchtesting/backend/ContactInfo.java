package nyc.c4q.leighdouglas.appfromscratchtesting.backend;

/**
 * Created by leighdouglas on 4/5/17.
 */

public class ContactInfo {
    private String id;
    private String name;
    private String email;
    private Phone phone;

    public ContactInfo(String id, String name, String email, Phone phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
