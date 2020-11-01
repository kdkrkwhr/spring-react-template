package com.kdk.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DefaultScheduler {

  static final Logger logger = LoggerFactory.getLogger(DefaultScheduler.class);

  @Scheduled(fixedDelay = 1000 * 60)
  public void minuteScheduled() throws Exception {
    logger.debug("=== START :: minuteScheduled ===");
  }

  @Scheduled(cron = "0 0 01 * * ?")
  public void amOneClockScheduled() throws Exception {
    logger.debug("=== START :: amOneClockScheduled ===");
  }
}
