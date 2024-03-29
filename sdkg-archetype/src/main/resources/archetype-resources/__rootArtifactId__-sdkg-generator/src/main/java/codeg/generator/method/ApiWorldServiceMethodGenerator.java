#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.codeg.generator.method;

import com.fastjrun.codeg.common.PacketObject;
import com.fastjrun.codeg.generator.method.BaseServiceMethodGenerator;

public class ApiWorldServiceMethodGenerator extends BaseServiceMethodGenerator {

    public void doParse() {
        PacketObject request = this.commonMethod.getRequest();
        if (request != null) {
            if (request.is_new()) {
                this.requestBodyClass = cm.ref(this.packageNamePrefix + request.get_class());
            } else {
                this.requestBodyClass = cm.ref(request.get_class());
            }
            if (this.commonMethod.isRequestIsArray()) {
                this.requestBodyClass = requestBodyClass.array();
            }
            if (this.commonMethod.isRequestIsList()) {
                this.requestBodyClass = cm.ref("java.util.List").narrow(requestBodyClass);
            }
        }
        PacketObject response = this.commonMethod.getResponse();
        if (response == null) {
            this.responseBodyClass = cm.VOID;
        } else {
            String responseClassP = response.get_class();
            if (response.is_new()) {
                this.elementClass = cm.ref(this.packageNamePrefix + responseClassP);
            } else {
                this.elementClass = cm.ref(responseClassP);
            }
            if (this.commonMethod.isResponseIsArray()) {
                this.responseBodyClass = cm.ref("java.util.List").narrow(elementClass);
            } else if (this.commonMethod.isResponseIsPage()) {
                this.responseBodyClass = cm.ref(this.serviceGenerator.getPageResultName()).narrow(elementClass);
            } else {
                this.responseBodyClass = elementClass;
            }
        }
    }
}
