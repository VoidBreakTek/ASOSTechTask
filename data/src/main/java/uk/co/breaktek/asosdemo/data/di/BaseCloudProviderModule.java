package uk.co.breaktek.asosdemo.data.di;

import uk.co.breaktek.asosdemo.data.net.CloudProvider;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface BaseCloudProviderModule {
    CloudProvider provideCloudProvider();
}
