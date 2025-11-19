package com.cambio.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCotacao {


    public void buscaCotacao(String moedaBaseRecebe, String moedaAlvoRecebe) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);

        String endereco = "https://economia.awesomeapi.com.br/json/last/"+ moedaBaseRecebe +"-"+moedaAlvoRecebe+"?token=25593f6c28bad82932f2eac92efd7d9bb68cde928643c3e0f0d250dba7431a75";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);


    }

}
