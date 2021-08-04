/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Mradul
 */
public class ItemInfo 
{
    
    public String ItemName;
    public String ItemType;

    public int quantity;

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the value of ItemName
     *
     * @return the value of ItemName
     */
    public String getItemName() {
        return ItemName;
    }

    /**
     * Set the value of ItemName
     *
     * @param ItemName new value of ItemName
     */
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

        

    /**
     * Get the value of ItemType
     *
     * @return the value of ItemType
     */
    public String getItemType() {
        return ItemType;
    }

    /**
     * Set the value of ItemType
     *
     * @param ItemType new value of ItemType
     */
    public void setItemType(String ItemType) {
        this.ItemType = ItemType;
    }

    
}
