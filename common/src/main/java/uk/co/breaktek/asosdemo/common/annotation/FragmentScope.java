package uk.co.breaktek.asosdemo.common.annotation;

import javax.inject.Scope;

/**
 * Dependency scope annotation for single fragment instances. Note in cases this scope is used, dependencies should naturally be cleared as part of the Fragment lifecycle
 */
@Scope
public @interface FragmentScope {
}