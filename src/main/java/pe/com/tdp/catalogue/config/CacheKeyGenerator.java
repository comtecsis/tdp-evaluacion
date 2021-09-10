package pe.com.tdp.catalogue.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component("customKeyGenerator")
public class CacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(final Object target, final Method method,
                           final Object... params) {
        return target.getClass().getSimpleName() + "_"
                + method.getName() + "_"
                + StringUtils.arrayToDelimitedString(params, "_");
    }

}
