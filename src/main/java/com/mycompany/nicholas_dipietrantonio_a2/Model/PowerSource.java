
package com.mycompany.nicholas_dipietrantonio_a2.Model;

import java.io.Serializable;

/**
 * class that represents the power source table in the database
 * @author Nicholas Di Pietrantonio
 */
public class PowerSource implements Serializable{
    
    //data fields
    private int id;
    private String description;
    
    /**
     * empty constructor for Serializable
     */
    public PowerSource() {}

    /**
     * 2 argument PowerSource constructor
     * @param id power source id
     * @param description  power source description
     */
    public PowerSource(int id, String description) {
        this.id = id;
        this.description = description;
    }

    //basic getters and setters below
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

}
