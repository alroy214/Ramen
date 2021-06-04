package com.hack.idc.ramen.ui.menu;

public class MenuItem {
    int m_Id;
    int m_Count;
    String m_Image;
    String m_Name;
    String m_Ingredients;
    int m_Price;

    public MenuItem(int id, String image, String name, String ingredients, int price) {
        m_Id = id;
        m_Ingredients = ingredients;
        m_Price = price;
        m_Image = image;
        m_Name = name;
        m_Count = 0;
    }

    public String getImage() {
        return m_Image;
    }

    public String getName() {
        return m_Name;
    }

    public String getIngredients() {
        return m_Ingredients;
    }

    public int getPrice() {
        return m_Price;
    }

    public int getCount() {
        return m_Count;
    }

    public int increaseCount() {
        return ++m_Count;
    }

    public int decreaseCount() {
        if(m_Count == 0) {
            return m_Count;
        }
        return --m_Count;
    }
}
