package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*这个注解非常的关键，这个对应了项目中mapper（dao）所对应的包路径*/
//@MapperScan("com.example.demo1.dao")
@ComponentScan(basePackages = {"com.example.demo1"})
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
/**
 * 配置session 超时时间
 *
 * */
   /* @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setSessionTimeout(1800);// 单位为S
            }
        };
    }*/

}
