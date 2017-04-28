package com.glarimy.spring.batch;

import java.util.Properties;

import javax.batch.runtime.BatchRuntime;

public class JSR352Application {
	public static void main(String[] args) {
		BatchRuntime.getJobOperator().start("job", new Properties());
	}
}
