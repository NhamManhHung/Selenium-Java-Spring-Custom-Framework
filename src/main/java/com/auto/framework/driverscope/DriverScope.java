package com.auto.framework.driverscope;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class DriverScope implements Scope {

    private final ThreadLocal<Map<String, Object>> scopedObjects =
            ThreadLocal.withInitial(ConcurrentHashMap::new);

    private final ThreadLocal<Map<String, Runnable>> destructionCallbacks =
            ThreadLocal.withInitial(ConcurrentHashMap::new);

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        var map = scopedObjects.get();
        Object existing = map.get(name);

        if (existing == null) {
            Object created = objectFactory.getObject();
            map.put(name, created);

            if (created instanceof WebDriver driver) {
                log.info("Registering quit callback for '{}'", name);
                registerDestructionCallback(name, () -> {
                    try {
                        log.info("Auto-quit driver '{}'",name);
                        driver.quit();
                    } catch (Exception e) {
                        log.warn("Quit failed for '{}': {}", name, e.getMessage());
                    }
                });
            }

            log.info("Created new bean '{}': {}", name, created.hashCode());
            return created;
        }

        log.info("Using bean '{}': {}", name, existing.hashCode());
        return existing;
    }

    @Override
    public Object remove(String name) {
        log.info("remove('{}') called", name);
        var obj = scopedObjects.get().remove(name);
        var callback = destructionCallbacks.get().remove(name);
        if (callback != null) {
            log.info("Running destruction callback for '{}'", name);
            callback.run();
        } else {
            log.warn("No callback found for '{}'", name);
        }
        return obj;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        log.info("registerDestructionCallback('{}')", name);
        destructionCallbacks.get().put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }

    public void cleanupThread() {
        var callbacks = destructionCallbacks.get();

        log.info("cleanupThread() on {} | {} callbacks to run",
                Thread.currentThread().getName(), callbacks.size());

        callbacks.forEach((name, cb) -> {
            try {
                log.info("cleanupThread() running callback for '{}'", name);
                cb.run();
            } catch (Exception e) {
                log.error("Cleanup failed for '{}': {}", name, e.getMessage());
            }
        });

        scopedObjects.get().clear();
        destructionCallbacks.get().clear();
        scopedObjects.remove();
        destructionCallbacks.remove();

        log.info("Cleaned up ThreadLocal and quit all drivers");
    }

    private static final DriverScope INSTANCE = new DriverScope();

    public static DriverScope getInstance() {
        return INSTANCE;
    }
}
