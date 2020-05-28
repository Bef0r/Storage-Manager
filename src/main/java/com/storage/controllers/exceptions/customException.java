/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Dell
 */
public class customException {
    @JsonProperty("ERROR_CODE")
    private int ERROR_CODE;
    @JsonProperty("EN")
    private String EN;
    @JsonProperty("HU")
    String HU;
    @JsonProperty("DE")
    String DE;

    public customException() {
    }
    
    public String getHU() {
        return HU;
    }

    public void setHU(String HU) {
        this.HU = HU;
    }

    public String getDE() {
        return DE;
    }

    public void setDE(String DE) {
        this.DE = DE;
    }

    public int getERROR_CODE() {
        return ERROR_CODE;
    }

    public void setERROR_CODE(int ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    public String getEN() {
        return EN;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }

    @Override
    public String toString() {
        return "test{" + "ERROR_CODE=" + ERROR_CODE + ", EN=" + EN + ", HU=" + HU + ", DE=" + DE + '}';
    }
    
}
