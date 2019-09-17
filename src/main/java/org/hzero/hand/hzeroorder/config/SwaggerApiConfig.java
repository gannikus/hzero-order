package org.hzero.hand.hzeroorder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * description
 * Swagger描述
 *
 * @author gzm 2019/08/09 11:21
 */
@Configuration
public class SwaggerApiConfig {
    public static final String PURHEADER = "PurHeader";
    public static final String PURLINE = "PurLine";
    public static final String DLYNOTEHEAD = "DlyNoteHeader";
    public static final String DLYNOTELINE = "DlyNoteLine";



    @Autowired
    public SwaggerApiConfig(Docket docket) {
        docket.tags(
                new Tag(PURHEADER, "采购订单头信息"),
                new Tag(PURLINE, "采购订单行信息"),
                new Tag(DLYNOTEHEAD, "送货单头信息"),
                new Tag(DLYNOTELINE, "送货单行信息")

        );
    }
}
