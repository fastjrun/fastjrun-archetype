#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.codeg.generator;

import com.fastjrun.codeg.generator.BaseServiceGenerator;

public class ApiWorldServiceGenerator extends BaseServiceGenerator {

    @Override
    protected void init() {
        this.mockHelperName=Constants.MOCK_HELPER_CLASS_NAME;
        this.pageResultName=Constants.PAGE_RESULT_CLASS_NAME;
    }
}