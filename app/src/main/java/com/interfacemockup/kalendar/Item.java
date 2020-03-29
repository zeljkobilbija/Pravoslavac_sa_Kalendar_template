package com.interfacemockup.kalendar;

public class Item {

    String svetac;
    int ikona;

    public Item(String svetacName, int svetacImage)
    {
        this.ikona = svetacImage;
        this.svetac = svetacName;
    }


    public String getSvetacName()
    {
        return svetac;
    }
    public int getSvetacImage()
    {
        return ikona;
    }
}
