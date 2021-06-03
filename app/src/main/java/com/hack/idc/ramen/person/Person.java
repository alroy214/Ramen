package com.hack.idc.ramen.person;

public class Person {
    int m_Image;
    String m_Name;
    String m_Des;

    public Person(int image, String name, String des){
        m_Des = des;
        m_Image = image;
        m_Name = name;
    }

    public int getImage() {
        return m_Image;
    }

    public void setImage(int m_Image) {
        this.m_Image = m_Image;
    }

    public String getName() {
        return m_Name;
    }

    public void setName(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getDes() {
        return m_Des;
    }

    public void setDes(String m_Des) {
        this.m_Des = m_Des;
    }
}
