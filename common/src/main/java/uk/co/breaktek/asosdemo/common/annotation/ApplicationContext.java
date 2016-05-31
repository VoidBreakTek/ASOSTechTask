package uk.co.breaktek.asosdemo.common.annotation;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation for context injection to explicitly request Application Context
 */
@Qualifier
@Retention(RUNTIME)
public @interface ApplicationContext {
}