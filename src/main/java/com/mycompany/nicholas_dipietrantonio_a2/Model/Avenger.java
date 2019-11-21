
package com.mycompany.nicholas_dipietrantonio_a2.Model;

import java.io.Serializable;

/**
 * Class represents the data an avenger would have
 * @author Nicholas Di Pietrantonio
 */
public class Avenger implements Serializable{
    
    //datafields
    private int Id;
    private String avengerName;
    private String description;
    private PowerSource powerSource;

    /**
     * Empty constructor for Serializable
     */
    public Avenger() {}

    /**
     * 4 argument avenger constructor
     * @param Id avenger id
     * @param avengerName name of the avenger
     * @param description avenger description
     * @param powerSource power source id
     */
    public Avenger(int Id, String avengerName, String description, PowerSource powerSource) {
        this.Id = Id;
        this.avengerName = avengerName;
        this.description = description;
        this.powerSource = powerSource;
    }

    //basic getters and setters for each data field below
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAvengerName() {
        return avengerName;
    }

    public void setAvengerName(String avengerName) {
        this.avengerName = avengerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    
    
}
