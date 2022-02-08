#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.client.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ${package}.client.common.ClientException;
import ${package}.client.common.ApiWorldCodeMsgConstants;
import com.fastjrun.client.exchange.BaseHTTPRequestEncoder;


public class DefaultHTTPRequestEncoder extends BaseHTTPRequestEncoder {

    @Override
    public String generateRequestBody(Object body) {
        String bodyData;
        try {
            bodyData = this.objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            throw new ClientException(ApiWorldCodeMsgConstants.SWCodeEnum.ClIENT_REQUEST_COMPOSE_FAIL);
        }
        return bodyData;
    }
}
