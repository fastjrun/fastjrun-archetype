#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.client.exchange;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastjrun.client.exchange.BaseHTTPExchange;
import com.fastjrun.common.util.FastJsonObjectMapper;

public class DefaultHTTPExchange extends BaseHTTPExchange<DefaultHTTPRequestEncoder, ApiWorldHTTPResponseDecoder> {

    public DefaultHTTPExchange() {
        ObjectMapper objectMapper = new FastJsonObjectMapper();
        this.requestEncoder = new DefaultHTTPRequestEncoder();
        this.requestEncoder.setObjectMapper(objectMapper);
        this.responseDecoder = new ApiWorldHTTPResponseDecoder();
        this.responseDecoder.setObjectMapper(objectMapper);
    }
}
