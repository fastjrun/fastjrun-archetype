#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.codeg.generator.processor;

import com.fastjrun.codeg.processor.BaseRequestProcessor;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;

public class ApiWorldRequestProcessor extends BaseRequestProcessor {

    @Override
    public String processHTTPRequest(JMethod method, JInvocation jInvocation, MockModel mockModel,
      JCodeModel cm) {
        return "";
    }

    @Override
    public void parseRequestClass(JCodeModel cm) {
        this.requestClass = this.requestBodyClass;
    }
}
