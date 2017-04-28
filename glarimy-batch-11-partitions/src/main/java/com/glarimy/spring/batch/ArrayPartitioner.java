package com.glarimy.spring.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class ArrayPartitioner implements Partitioner {

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> partitions = new HashMap<>();
		
		ExecutionContext even = new ExecutionContext();
		even.put("index", "even");
		partitions.put("even", even);
		
		ExecutionContext odd = new ExecutionContext();
		odd.put("index", "odd");
		partitions.put("odd", odd);

		return partitions;
	}

}
