package com.cambio.models;

import com.cambio.api.MoedaRecord;

public class Atributos {
    private String codein;
    private String code;
    private double bid;


    public Atributos (MoedaRecord moedaRecord ){
        this.codein = moedaRecord.codein();
        this.code = moedaRecord.code();

        String bidString = moedaRecord.bid();

        if (bidString != null && !bidString.trim().isEmpty()) {
            this.bid = Double.parseDouble(bidString.replace(',', '.'));
        } else {
            this.bid = 0.0;
        }
    }


    @Override
    public String toString() {
        return "ConsultaCotacao: " + "\ncode -> " + code + "\ncodein -> " + codein + "\nbid -> " + bid ;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
}
