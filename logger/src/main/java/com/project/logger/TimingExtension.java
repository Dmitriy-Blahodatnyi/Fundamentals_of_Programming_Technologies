package com.project.logger;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.logging.Logger;

public class TimingExtension
        implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static final Logger logger =
            Logger.getLogger(TimingExtension.class.getName());
    private static final String START_TIME = "start time";

    public void beforeTestExecution(ExtensionContext context) {
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    public void afterTestExecution(ExtensionContext context) {
        long startTime = getStore(context).remove(START_TIME, long.class);
        logger.info(
                () -> String.format(
                        "Method [%s] took %s ms.",
                        context.getRequiredTestMethod().getName(),
                        System.currentTimeMillis() - startTime
                )
        );
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context
                .getStore(
                        ExtensionContext.Namespace
                                .create(getClass(), context.getRequiredTestMethod())
                );
    }
}