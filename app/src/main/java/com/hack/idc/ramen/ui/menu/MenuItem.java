package com.hack.idc.ramen.ui.menu;

public class MenuItem {
    int m_Id;
    String m_Image;
    String m_Name;
    String m_Ingredients;
    String m_Price;

    public MenuItem(int id, String image, String name, String ingredients, String price) {
        m_Id = id;
        m_Ingredients = ingredients;
        m_Price = price;
        m_Image = image;
        m_Name = name;
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

    public String getPrice() {
        return m_Price;
    }
}
