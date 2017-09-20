package org.smart4j.chapter2.model;

/**
 * @author Archibald
 * @version:
 * @time: 6/3/2017.
 *
 * 客户类
 */
public class Customer {
    /**
     * ID
     */
    private long id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    //getter方法
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getRemark() {
        return remark;
    }

    //setter方法
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
