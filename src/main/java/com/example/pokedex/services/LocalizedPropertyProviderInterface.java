/*
Interface Segregation Principle: instead of having a single PropertyProviderInterface that all
services must implement, even if they are not localizable, the interface has been split into two:
one interface defining the base provider properties, and another one dedicated to localization.
*/

package com.example.pokedex.services;


public interface LocalizedPropertyProviderInterface {

    /**
     * Sets the locale to use for all String properties provided by the service.
     *
     * @param localeCode the locale code (2 letters code) representing the desired locale to use
     *                   (e.g., "en", "fr", "de").
     */
    void setStringPropertyLocale(String localeCode);

    /**
     * Gets the locale that is currently used by the service
     *
     * @return the locale code (2 letters code) representing the locale (e.g., "en", "fr", "de").
     */
    String getStringPropertyLocale();
}
