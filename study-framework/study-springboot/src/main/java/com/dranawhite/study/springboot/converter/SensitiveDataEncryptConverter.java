package com.dranawhite.study.springboot.converter;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.common.text.JsonUtil;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * <pre>
 *     参照AbstractMessageConverterMethodProcessor的275行
 * </pre>
 *
 * @author dranawhite
 * @version : SensitiveDataEncryptConverter.java, v 0.1 2019-07-31 18:28 dranawhite Exp $$
 */
public class SensitiveDataEncryptConverter extends MappingJackson2HttpMessageConverter implements GenericHttpMessageConverter<Object> {

    @Override
    public boolean canRead(@NonNull Type type, @Nullable Class contextClass, @Nullable MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canRead(@NonNull Class clazz, @Nullable MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(@Nullable Type type, @NonNull Class clazz, @Nullable MediaType mediaType) {
        if (type == null) {
            return canWrite(clazz, mediaType);
        }
        if (!DranaResponse.class.isAssignableFrom(clazz)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] bodyTypeArr = parameterizedType.getActualTypeArguments();
        if (bodyTypeArr == null || bodyTypeArr.length == 0) {
            return false;
        }
        Class bodyClz = bodyTypeArr[0].getClass();
        return UserVO.class.isAssignableFrom(bodyClz);
    }

    @Override
    public boolean canWrite(@NonNull Class clazz, @Nullable MediaType mediaType) {
        return DranaResponse.class.isAssignableFrom(clazz);
    }

    @Override
    protected void writeInternal(@NonNull Object object, @Nullable Type type, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        DranaResponse response = (DranaResponse) object;
        Object body = response.getBody();
        if (body == null) {
            super.writeInternal(object, type, outputMessage);
            return;
        }
        if (!UserVO.class.isAssignableFrom(body.getClass())) {
            super.writeInternal(object, type, outputMessage);
            return;
        }
        UserVO user = (UserVO) body;
        String phone = user.getPhone();
        if (StringUtils.isEmpty(phone)) {
            super.writeInternal(object, type, outputMessage);
            return;
        }
        String encryptedPhone = phone.substring(0, 3).concat("****").concat(phone.substring(7));
        user.setPhone(encryptedPhone);
        String json = JsonUtil.toJsonString(user);
        outputMessage.getBody().write(json.getBytes(StandardCharsets.UTF_8));
    }
}
