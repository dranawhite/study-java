package com.dranawhite.study.springboot.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dranawhite
 * @version : CsvJobListener.java, v 0.1 2019-07-27 18:23 dranawhite Exp $$
 */
@Slf4j
public class CsvJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Batch Job Begin!");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Batch Job End!");
    }
}
