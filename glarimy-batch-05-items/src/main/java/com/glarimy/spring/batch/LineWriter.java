package com.glarimy.spring.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class LineWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println(items);
	}

}
