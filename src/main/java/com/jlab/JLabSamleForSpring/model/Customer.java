package com.jlab.JLabSamleForSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIREST_NAME")
    private String firstName;
    private String gender;
    private String phone;
    private String address;
    @Column(name = "MODIFY_DT")
    private String modifyDt;
    @Column(name = "MODIFY_BY")
    private String modifyBy;
    @Column(name = "CREATE_DT")
    private String createDt;
    @Column(name = "CREATE_BY")
    private String createBy;
    
	//(省略 for brevity)

    // Default constructor
    public Customer() {
    }

    // Constructor with fields
    public Customer(int id, String lastName, String firstName, String gender, String phone, String address, String modifyDt, String modifyBy, String createDt, String createBy) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.modifyDt = modifyDt;
        this.modifyBy = modifyBy;
        this.createDt = createDt;
        this.createBy = createBy;
    }

    // Getters and Setters for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModifyDt() {
        return modifyDt;
    }

    public void setModifyDt(String modifyDt) {
        this.modifyDt = modifyDt;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", modifyDt='" + modifyDt + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                ", createDt='" + createDt + '\'' +
                ", createBy='" + createBy + '\'' +
                '}';
    }
    
}
