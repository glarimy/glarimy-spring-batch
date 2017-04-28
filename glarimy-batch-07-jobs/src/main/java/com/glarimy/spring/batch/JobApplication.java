package com.glarimy.spring.batch;

import java.util.Set;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.ReferenceJobFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobApplication {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/context.xml");
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		JobOperator jobOperator = (JobOperator) context.getBean("jobOperator");
		JobRegistry jobRegistry = (JobRegistry) context.getBean("jobRegistry");
		Job job = (Job) context.getBean("job");
		try {
			jobRegistry.register(new ReferenceJobFactory(job));
			System.out.println(jobLauncher.run(job, new JobParameters()).getExitStatus().getExitCode());
			Set<Long> executions = jobOperator.getRunningExecutions("job");
			long jobId = executions.iterator().next();
			System.out.println("Job Parameters: " + jobOperator.getParameters(jobId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
