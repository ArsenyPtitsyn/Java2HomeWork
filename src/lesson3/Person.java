package lesson3;

public class Person {

    private String surName;
    private String name;
    private String middleName;
    private String PhoneNumber;
    private String mail;

    Person(String surName,
           String name,
           String middleName,
           String PhoneNumber,
           String mail) {
        this.surName = surName;
        this.name = name;
        this.middleName = middleName;
        this.PhoneNumber = PhoneNumber;
        this.mail = mail;
    }

    public String getSurname() {
        return surName;
    }
    public String getName() {
        return name;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getMail() {
        return mail;
    }
}