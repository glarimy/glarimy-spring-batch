package com.glarimy.spring.batch;

import org.springframework.batch.core.ItemReadListener;

public class ItemReadInterceptor implements ItemReadListener<String> {
	@Override
	public void beforeRead() {
		System.out.println("read interceptor: before read");
	}

	@Override
	public void afterRead(String item) {
		System.out.println("read interceptor: after read");

	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("read interceptor: on read error");
	}
}
