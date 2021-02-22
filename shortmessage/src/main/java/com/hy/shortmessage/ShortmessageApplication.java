package com.hy.shortmessage;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.*.**.dao")
@EnableMethodCache(basePackages="com.hy.shortmessage") //开启 Cache注解
@EnableCreateCacheAnnotation   //启用createCache注解
@SpringBootApplication
public class ShortmessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortmessageApplication.class, args);
	}

}
