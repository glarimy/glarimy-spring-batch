package com.glarimy.spring.batch;

import org.springframework.batch.core.ItemProcessListener;

public class ProcessorInterceptor implements ItemProcessListener<String, String> {

	@Override
	public void beforeProcess(String item) {
		System.out.println("process interceptor: before process");
	}

	@Override
	public void afterProcess(String item, String result) {
		System.out.println("process interceptor: after process");
	}

	@Override
	public void onProcessError(String item, Exception e) {
		System.out.println("process interceptor: on process error");
	}

}
