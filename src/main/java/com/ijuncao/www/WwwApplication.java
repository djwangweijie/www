package com.ijuncao.www;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.hutool.cron.CronUtil;
/*
 * 这个是springboot启动文件
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ijuncao.www.mapper")
public class WwwApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwwApplication.class, args);
//		CronUtil.setMatchSecond(true);
//		CronUtil.start(true);
	}

}
