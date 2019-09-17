package org.hzero.hand.hzeroorder;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
// 开启资源认证、 Spring Security 安全认证，开启了 Jwt_Token 的校验
@EnableChoerodonResourceServer
public class HzeroOrderApplication {

 /*   @Autowired
    private static CodeRuleBuilder codeRuleBuilder;*/

    public static void main(String[] args) {
/*
        String s = codeRuleBuilder.generateCode(Long.valueOf(0), "HPFM.ORDER_CODE", "GLOBAL","GLOBAL", null);
        System.out.println(s);*/
        SpringApplication.run(HzeroOrderApplication.class, args);
    }

}
