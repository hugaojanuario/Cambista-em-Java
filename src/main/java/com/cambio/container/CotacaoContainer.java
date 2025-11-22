package com.cambio.container;


import com.cambio.api.MoedaRecord;

import java.util.Map;

public class CotacaoContainer {
    private Map<String, MoedaRecord> dados;

    public Map<String, MoedaRecord> getDados() {
        return dados;
    }
}