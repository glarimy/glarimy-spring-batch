package com.glarimy.spring.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class LineReader implements ItemReader<String> {
	private String[] lines = new String[] { "first", "second", "third", "fourth", "fifth" };
	private int index = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (index < 5)
			return lines[index++];
		return null;
	}

}
