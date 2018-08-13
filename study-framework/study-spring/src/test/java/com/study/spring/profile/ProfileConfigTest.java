package com.study.spring.profile;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liangyq 2018/3/19
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles({"prod"})
public class ProfileConfigTest {

	@Autowired
	private DeviceInfo deviceInfo;

	@Test
	public void testDevInfo() {
		Assert.assertEquals(deviceInfo.getInfo(), "PROD");
	}

}
