package com.cambio.service;

import com.cambio.api.MoedaRecord;
import com.cambio.models.Atributos;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaCotacao {


    public void buscaCotacao(String moedaBaseRecebe, String moedaAlvoRecebe) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
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


        Type tipoCotacao = new TypeToken<Map<String, MoedaRecord>>(){}.getType();

        Map<String, MoedaRecord> cotacoesMap = gson.fromJson(json, tipoCotacao);

        MoedaRecord moeda = null;
        if (cotacoesMap != null && !cotacoesMap.isEmpty()) {
            moeda = cotacoesMap.values().iterator().next();
        } else {
            System.err.println("Erro: Não foi possível obter dados da cotação.");
            return;
        }

        System.out.println(moeda);

        Atributos atributos = new Atributos(moeda);
        System.out.println(atributos);


    }

}
