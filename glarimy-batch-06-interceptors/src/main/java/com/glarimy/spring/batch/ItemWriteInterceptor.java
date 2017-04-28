package com.glarimy.spring.batch;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

public class ItemWriteInterceptor implements ItemWriteListener<String> {
	@Override
	public void beforeWrite(List<? extends String> items) {
		System.out.println("write interceptor: before write");
	}

	@Override
	public void afterWrite(List<? extends String> items) {
		System.out.println("write interceptor: after write");

	}

	@Override
	public void onWriteError(Exception exception, List<? extends String> items) {
		System.out.println("write interceptor: on write error");

	}
}
