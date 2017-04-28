package com.glarimy.spring.batch;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class ChunkInterceptor implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext context) {
		System.out.println("chunk interceptor: before chunk ");
	}

	@Override
	public void afterChunk(ChunkContext context) {
		System.out.println("chunk interceptor: after chunk ");
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		System.out.println("chunk interceptor: after chunk error ");
	}

}
