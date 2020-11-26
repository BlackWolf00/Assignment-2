////////////////////////////////////////////////////////////////////
// [Matteo] [Tossuto] [1193493]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    public enum itemType {Gelato, Budino, Bevanda};
    private String name;
    private double price;
    private itemType itemType;
    public MenuItem(String name, double price, itemType itemType){

        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }
    public String GetName() {
        return name;
    }

    public double GetPrice() {
        return price;
    }

    public itemType GetItemType() {
        return itemType;
    }
}