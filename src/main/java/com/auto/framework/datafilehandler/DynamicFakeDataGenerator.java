package com.auto.framework.datafilehandler;

import com.auto.framework.interfaces.IDynamicFakeDataGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
@Component
public class DynamicFakeDataGenerator implements IDynamicFakeDataGenerator {

    private Faker faker;
    private Random random;
    private ObjectMapper mapper;

    @PostConstruct
    public void init() {
        faker = new Faker();
        random = new Random();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public <T> T generateFromTemplate(String jsonTemplatePath, Class<T> clazz) {
        try {
            Map<String, Object> templateData = readDataFromJsonFile(jsonTemplatePath, new TypeReference<>() {
            });
            Map<String, Object> resolvedData = new HashMap<>();
            for (Map.Entry<String, Object> entry : templateData.entrySet()) {
                resolvedData.put(entry.getKey(), processValue(entry.getValue()));
            }
            return mapper.convertValue(resolvedData, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Error reading template: " + e.getMessage(), e);
        }
    }

    private Object processValue(Object value) {
        if (value instanceof String str) {
            if (str.startsWith("#{faker.")) return resolveFakerValue(str);
            return str;
        }
        if (value instanceof List<?> list) {
            Object randomElement = list.get(random.nextInt(list.size()));
            return processValue(randomElement);
        }
        return value;
    }


    private Object resolveFakerValue(String placeholder) {
        String expression = StringUtils.substringBetween(placeholder, "#{faker.", "}");
        if (expression == null) return placeholder;

        try {
            String[] parts = expression.split("\\.");
            Object current = faker;

            for (String part : parts) {
                if (part.contains("(")) {
                    String methodName = StringUtils.substringBefore(part, "(");
                    String argsStr = StringUtils.substringBetween(part, "(", ")");
                    Object[] args = parseArguments(argsStr);

                    Class<?>[] paramTypes = Arrays.stream(args)
                            .map(Object::getClass)
                            .toArray(Class<?>[]::new);

                    Method method = findMethod(current.getClass(), methodName, paramTypes);
                    if (method == null) {
                        return "ERROR_FAKER_METHOD_NOT_FOUND_" + methodName;
                    }

                    current = method.invoke(current, args);
                } else {
                    Method method = current.getClass().getMethod(part);
                    current = method.invoke(current);
                }
            }

            return current.toString();
        } catch (Exception e) {
            return "ERROR_FAKER_" + e.getMessage();
        }
    }

    private Object[] parseArguments(String argsStr) {
        if (StringUtils.isBlank(argsStr)) return new Object[0];

        String[] rawArgs = argsStr.split(",");
        Object[] args = new Object[rawArgs.length];

        for (int i = 0; i < rawArgs.length; i++) {
            String arg = rawArgs[i].trim();
            if (arg.matches("-?\\d+")) {
                args[i] = Integer.parseInt(arg);
            } else if (arg.equalsIgnoreCase("true") || arg.equalsIgnoreCase("false")) {
                args[i] = Boolean.parseBoolean(arg);
            } else {
                args[i] = arg.replaceAll("^\"|\"$", "");
            }
        }

        return args;
    }

    private Method findMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
        for (Method m : clazz.getMethods()) {
            if (m.getName().equals(methodName) && m.getParameterCount() == paramTypes.length) {
                return m;
            }
        }
        return null;
    }


    private <K, V> Map<K, V> readDataFromJsonFile(String filePath, TypeReference<Map<K, V>> typeReference) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("Template file not found: " + filePath);
        }
        if (file.length() == 0) {
            return new HashMap<>();
        }
        return mapper.readValue(file, typeReference);
    }
}

