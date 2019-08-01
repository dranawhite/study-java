package com.dranawhite.study.springboot.converter;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.common.text.JsonUtil;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * @author dranawhite
 * @version : SensitiveDataEncryptConverter.java, v 0.1 2019-07-31 18:28 dranawhite Exp $$
 */
public class SensitiveDataEncryptConverter extends MappingJackson2HttpMessageConverter {

    @Override
    protected void writeInternal(@NonNull Object object, @Nullable Type type, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        DranaResponse response = (DranaResponse) object;
        Object body = response.getBody();
        if (body == null) {
            return;
        }
        if (!UserVO.class.isAssignableFrom(body.getClass())) {
            return;
        }
        UserVO user = (UserVO) body;
        String phone = user.getPhone();
        if (StringUtils.isEmpty(phone)) {
            return;
        }
        String encryptedPhone = phone.substring(0, 3).concat("****").concat(phone.substring(7));
        user.setPhone(encryptedPhone);
        String json = JsonUtil.toJsonString(user);
        outputMessage.getBody().write(json.getBytes(StandardCharsets.UTF_8));
    }
}
