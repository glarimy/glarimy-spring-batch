package com.glarimy.spring.batch;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.AssertFile;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/context.xml" })
public class BasicTestCase {
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void test() {
		try {
			JobExecution jobExecution = jobLauncherTestUtils.launchJob();
			assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus().getExitCode());
			AssertFile.assertFileEquals(new FileSystemResource("src/test/resources/data/input"),
					new FileSystemResource("data/output"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}