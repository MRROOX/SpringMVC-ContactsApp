package in.ezeon.domain;

/**
 *
 * @author unknown
 */
public class Contacto {
    //Constructor

    public Contacto() {
    }

    private Integer contacId; //PK
    private Integer userId; //FK
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String remark;

    public Integer getContacId() {
        return contacId;
    }

    public void setContacId(Integer contacId) {
        this.contacId = contacId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
