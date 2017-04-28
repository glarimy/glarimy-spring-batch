package com.glarimy.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class LineProcessor implements ItemProcessor<String, String> {
	@Override
	public String process(String item) throws Exception {
		return item.toUpperCase();
	}

}
