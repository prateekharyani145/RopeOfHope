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

public class PreviousDonation 
{

    public int arraySize;

    /**
     * Get the value of arraySize
     *
     * @return the value of arraySize
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * Set the value of arraySize
     *
     * @param arraySize new value of arraySize
     */
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int[] QTY;
    public String[] item_Name;
    public String[] item_Type;
    
    public String donation_date;
    
    public String getDonation_date() {
        return donation_date;
    }

    public int donation_id;

    /**
     * Get the value of donation_id
     *
     * @return the value of donation_id
     */
    public int getDonation_id() {
        return donation_id;
    }

    /**
     * Set the value of donation_id
     *
     * @param donation_id new value of donation_id
     */
    public void setDonation_id(int donation_id) {
        this.donation_id = donation_id;
    }

    public void setDonation_date(String donation_date) {
        this.donation_date = donation_date;
    }

    public int[] getQTY() {
        return QTY;
    }

    public void setQTY(int[] QTY) {
        this.QTY = QTY;
    }

    public String[] getItem_Name() {
        return item_Name;
    }

    public void setItem_Name(String[] item_Name) {
        this.item_Name = item_Name;
    }

    public String[] getItem_Type() {
        return item_Type;
    }

    public void setItem_Type(String[] item_Type) {
        this.item_Type = item_Type;
    }

    
}
