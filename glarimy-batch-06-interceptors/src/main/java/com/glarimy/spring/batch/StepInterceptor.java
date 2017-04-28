package com.glarimy.spring.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepInterceptor implements StepExecutionListener {
	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("step interceptor: before step");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("step interceptor: after step");
		return stepExecution.getExitStatus();
	}
}
