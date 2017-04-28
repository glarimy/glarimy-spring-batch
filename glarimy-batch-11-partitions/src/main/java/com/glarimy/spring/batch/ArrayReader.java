package com.glarimy.spring.batch;

import java.util.stream.Stream;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ArrayReader implements ItemReader<Integer> {
	private Object[] numbers;
	private String index;
	private int evenIndex = -2;
	private int oddIndex = -1;

	public ArrayReader() {
		System.out.println("Reader cons");
		numbers = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toArray();
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		evenIndex += 2;
		oddIndex += 2;
		if (evenIndex > 10 || oddIndex > 10)
			return null;
		if (index.equalsIgnoreCase("even"))
			return (Integer) numbers[evenIndex];
		else
			return (Integer) numbers[oddIndex];
	}

}
