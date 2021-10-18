/*
 * Copyright (c) 2021 Juby210 & Vendicated
 * Licensed under the Open Software License version 3.0
 */

package com.aliucord.api;

import com.aliucord.SettingsUtils;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class SettingsAPI {
    /** Prefix for all settings keys: AC_{PLUGIN_NAME}_ */
    public final String keyPrefix;

    /** Creates a SettingsAPI for the specified plugin */
    public SettingsAPI(String plugin) {
        keyPrefix = "AC_" + plugin + "_";
    }

    /**
     * Reads a {@link boolean} from the settings.
     * @param key Key of the setting.
     * @param defValue Default value of the setting.
     * @return Stored value, or default value if it doesn't exist.
     */
    public boolean getBool(String key, boolean defValue) {
        return SettingsUtils.getBool(keyPrefix + key, defValue);
    }

    /**
     * Toggle a boolean item in the preferences
     * @param key Key of the item
     * @param defValue Value to set if not found. This is not flipped
     * @return Flipped value if found, else the defValue
     */
    public boolean toggleBool(String key, boolean defValue) { return SettingsUtils.toggleBool(key, defValue); }

    /**
     * Writes a {@link boolean} to the settings.
     * @param key Key of the setting.
     * @param val Value of the setting.
     */
    public void setBool(String key, boolean val) {
        SettingsUtils.setBool(keyPrefix + key, val);
    }

    /**
     * Gets an {@link int} stored in the settings.
     * @param key Key of the setting.
     * @param defValue Default value of the setting.
     * @return Stored value, or default value if it doesn't exist.
     */
    public int getInt(String key, int defValue) {
        return SettingsUtils.getInt(keyPrefix + key, defValue);
    }

    /**
     * Writes an {@link int} to the settings.
     * @param key Key of the setting.
     * @param val Value of the setting.
     */
    public void setInt(String key, int val) {
        SettingsUtils.setInt(keyPrefix + key, val);
    }

    /**
     * Gets a {@link float} stored in the settings.
     * @param key Key of the setting.
     * @param defValue Default value of the setting.
     * @return Stored value, or default value if it doesn't exist.
     */
    public float getFloat(String key, float defValue) {
        return SettingsUtils.getFloat(keyPrefix + key, defValue);
    }

    /**
     * Writes a {@link float} to the settings.
     * @param key Key of the setting.
     * @param val Value of the setting.
     */
    public void setFloat(String key, float val) {
        SettingsUtils.setFloat(keyPrefix + key, val);
    }

    /**
     * Gets a {@link long} stored in the settings.
     * @param key Key of the setting.
     * @param defValue Default value of the setting.
     * @return Stored value, or default value if it doesn't exist.
     */
    public long getLong(String key, long defValue) {
        return SettingsUtils.getLong(keyPrefix + key, defValue);
    }

    /**
     * Writes a {@link long} to the settings.
     * @param key Key of the setting.
     * @param val Value of the setting.
     */
    public void setLong(String key, long val) {
        SettingsUtils.setLong(keyPrefix + key, val);
    }

    /**
     * Gets a {@link String} stored in the settings.
     * @param key Key of the setting.
     * @param defValue Default value of the setting.
     * @return Stored value, or default value if it doesn't exist.
     */
    public String getString(String key, String defValue) {
        return SettingsUtils.getString(keyPrefix + key, defValue);
    }

    /**
     * Writes a {@link String} to the settings.
     * @param key Key of the setting.
     * @param val Value of the setting.
     */
    public void setString(String key, String val) {
        SettingsUtils.setString(keyPrefix + key, val);
    }

    /**
     * Gets an {@link Object} stored in the settings.
     * @param key Key of the setting.
     * @param defValue Default value of the setting.
     * @return Stored value, or default value if it doesn't exist.
     */
    public <T> T getObject(String key, T defValue) {
        return SettingsUtils.getObject(keyPrefix + key, defValue);
    }

    /**
     * Gets an {@link Object} stored in the settings.
     * @param key Key of the setting.
     * @param defValue Default value of the setting.
     * @param type {@link Object} representing the data type.
     * @return Stored value, or default value if it doesn't exist.
     */
    public <T> T getObject(String key, T defValue, Type type) {
        return SettingsUtils.getObject(keyPrefix + key, defValue, type);
    }

    /**
     * Writes an {@link Object} to the settings.
     * @param key Key of the setting.
     * @param val Value of the setting.
     */
    public void setObject(String key, Object val) {
        SettingsUtils.setObject(keyPrefix + key, val);
    }

    /**
     * Checks if a setting exists
     * @param key Key of the item
     * @return If setting present
     */
    public boolean exists(String key) { return SettingsUtils.exists(keyPrefix + key); }

    /**
     * Deletes a setting
     * @param key Key of the item
     * @return Whether the item existed
     */
    public boolean delete(String key) { return SettingsUtils.delete(keyPrefix + key); }

    /**
     * Gets all settings
     * @return Key-value map of all settings
     */
    public Map<String, ?> getAll() {
        return SettingsUtils.getAll()
                .entrySet().stream()
                .filter(setting -> setting.getKey().startsWith(keyPrefix))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Deletes all the plugin's settings
     */
    public void reset() {
        SettingsUtils.getAll()
                .keySet().stream()
                .filter(key -> key.startsWith(keyPrefix))
                .forEach(SettingsUtils::delete);
    }
}
