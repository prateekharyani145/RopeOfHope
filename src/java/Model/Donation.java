/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Mradul
 */
public class Donation 
{
    
    public int DonorId;

    /**
     * Get the value of DonorId
     *
     * @return the value of DonorId
     */
    public int getDonorId() {
        return DonorId;
    }

    /**
     * Set the value of DonorId
     *
     * @param DonorId new value of DonorId
     */
    public void setDonorId(int DonorId) {
        this.DonorId = DonorId;
    }

        public Date DonationDate;

    /**
     * Get the value of DonationDate
     *
     * @return the value of DonationDate
     */
    public Date getDonationDate() {
        return DonationDate;
    }

    /**
     * Set the value of DonationDate
     *
     * @param DonationDate new value of DonationDate
     */
    public void setDonationDate(Date DonationDate) {
        this.DonationDate = DonationDate;
    }

    
}
