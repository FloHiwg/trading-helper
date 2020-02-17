package com.heiwig.tradinghelper.tasks;

import com.heiwig.tradinghelper.services.YFinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FetchCourseTask {

    private static final Logger log = LoggerFactory.getLogger(FetchCourseTask.class);

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        log.info("The time is now {}", YFinanceService.getStockTimestamp("MSFT"));
    }
}
