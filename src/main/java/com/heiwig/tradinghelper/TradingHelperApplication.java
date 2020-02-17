package com.heiwig.tradinghelper;

import com.heiwig.tradinghelper.services.YFinanceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TradingHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingHelperApplication.class, args);
	}

}