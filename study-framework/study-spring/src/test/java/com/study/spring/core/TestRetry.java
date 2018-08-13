package com.study.spring.core;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.BackOffExecution;
import org.springframework.util.backoff.ExponentialBackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * @author liangyq
 * @version [1.0, 2018/4/10 18:57]
 */
public class TestRetry {

	@Test
	public void testExponentialBackOff() {
		long initialInterval = 100;//初始间隔
		long maxInterval = 5 * 1000L;//最大间隔
		long maxElapsedTime = 10 * 1000L;//最大时间间隔
		double multiplier = 1.5;//递增倍数（即下次间隔是上次的多少倍）
		ExponentialBackOff backOff = new ExponentialBackOff(initialInterval, multiplier);
		backOff.setMaxInterval(maxInterval);
		//currentElapsedTime = interval1 + interval2 + ... + intervalN;
		backOff.setMaxElapsedTime(maxElapsedTime);

		BackOffExecution execution = backOff.start();

		for (int i = 1; i <= 18; i++) {
			System.out.println("COUNT=" + i + "; " + execution.nextBackOff());
		}
		Assert.assertEquals(BackOffExecution.STOP, execution.nextBackOff());
	}

	@Test
	public void testFixedBackOff() {
		long interval = 100;
		long maxAttempts = 10;
		BackOff backOff = new FixedBackOff(interval, maxAttempts);
		BackOffExecution execution = backOff.start();

		for(int i = 1; i <= 10; i++) {
			//每次重试时间是100毫秒
			System.out.println(execution.nextBackOff());
		}
		Assert.assertEquals(BackOffExecution.STOP, execution.nextBackOff());
	}
}
