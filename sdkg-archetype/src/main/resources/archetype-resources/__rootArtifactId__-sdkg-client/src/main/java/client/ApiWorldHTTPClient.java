#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.client;

import ${package}.client.exchange.DefaultHTTPExchange;
import com.fastjrun.client.BaseHTTPClient;
import com.fastjrun.client.util.DefaultHTTPUtilClient;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ApiWorldHTTPClient extends BaseHTTPClient<DefaultHTTPUtilClient, DefaultHTTPExchange> {

    public ApiWorldHTTPClient() {
        this.baseClient = new DefaultHTTPUtilClient();
        this.baseExchange = new DefaultHTTPExchange();
    }

    @Override
    protected void initUtilClient(String baseUrl) {
        baseClient.setBaseUrl(baseUrl);
        Map<String, String> requestHeaderDefault = new HashMap<>();
        requestHeaderDefault.put("Content-Type", "application/json;charset=UTF-8");
        baseClient.setRequestHeaderDefault(requestHeaderDefault);
    }

    @Override
    public void initSDKConfig() {
        ResourceBundle rb = ResourceBundle.getBundle("${rootArtifactId}-sdk");
        String baseUrl = rb.getString("${rootArtifactId}.baseUrl");
        this.initUtilClient(baseUrl);
    }

    @Override
    protected String generateUrlSuffix() {
        return "";
    }
}
