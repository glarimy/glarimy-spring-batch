package com.glarimy.spring.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobInterceptor implements JobExecutionListener {
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("job listener: before job");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("job listener: before job");
	}
}
