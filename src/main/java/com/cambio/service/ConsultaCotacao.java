package com.cambio.service;

import com.cambio.api.MoedaRecord;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotacao {

    private String code;
    private String codein;
    private String bid;

    public void buscaCotacao(String moedaBaseRecebe, String moedaAlvoRecebe) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String endereco = "https://economia.awesomeapi.com.br/json/last/"+ moedaBaseRecebe +"-"+moedaAlvoRecebe+"?token=25593f6c28bad82932f2eac92efd7d9bb68cde928643c3e0f0d250dba7431a75";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        MoedaRecord moeda = gson.fromJson(json,MoedaRecord.class);
        System.out.println(moeda);


    }

    @Override
    public String toString() {
        return "ConsultaCotacao: " + "\ncode -> " + code + "\ncodein -> " + codein + "\nbid -> " + bid ;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
