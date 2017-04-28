package com.glarimy.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired

	private StepBuilderFactory steps;

	@Bean
	public Job job(Step copy) {
		return jobs.get("job").start(copy).build();
	}

	@Bean
	public Step copy(ItemReader<String> reader, ItemWriter<String> writer) {
		return steps.get("copy").<String, String> chunk(2).reader(reader).writer(writer).build();
	}
	
	@Bean
	public FlatFileItemReader<String> reader(){
		FlatFileItemReader<String> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("data/input"));
		reader.setLineMapper(new PassThroughLineMapper());
		return reader;
	}
	
	@Bean
	public FlatFileItemWriter<String> writer(){
		FlatFileItemWriter<String> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("data/output"));
		writer.setLineAggregator(new PassThroughLineAggregator<>());
		return writer;
	}
}