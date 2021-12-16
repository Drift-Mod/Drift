/*
 * Copyright (c) 2021 Juby210 & Vendicated
 * Licensed under the Open Software License version 3.0
 */

package com.aliucord.entities;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aliucord.Logger;
import com.aliucord.annotations.AliucordPlugin;
import com.aliucord.api.CommandsAPI;
import com.aliucord.api.PatcherAPI;
import com.aliucord.api.SettingsAPI;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;

/** Base Plugin class all plugins must extend */
@SuppressWarnings("unused")
public abstract class Plugin {
    /** Name of this plugin. Defaults to the class name */
    @Deprecated
    public String name = getClass().getSimpleName();
    /** The {@link SettingsAPI} of your plugin. Use this to store persistent data */
    public final SettingsAPI settings = new SettingsAPI(name);
    /** The {@link CommandsAPI} of your plugin. You can register/unregister commands here */
    public final CommandsAPI commands = new CommandsAPI(name);
    /** The {@link PatcherAPI} of your plugin. You can add/remove patches here */
    public final PatcherAPI patcher = new PatcherAPI(this);
    /** Whether your plugin has resources that need to be loaded */
    public boolean needsResources = false;

    /** SettingsTab associated with this plugin. Set this to register a settings page */
    public SettingsTab settingsTab;
    /** The resources of your plugin. You need to set {@link #needsResources} to true to use this */
    public Resources resources;
    /** The filename of your plugin */
    public String __filename;
    /** The {@link Logger} of your plugin. Use this to log information */
    public Logger logger;

    private Manifest manifest;

    /** Method returning the {@link Manifest} of your Plugin */
    @NonNull
    public Manifest getManifest() {
        return manifest;
    }

    /**
     * Initializes the plugin with a manifest, you shouldn't be calling this manually
     * @throws IllegalStateException If the method was called more than once
     */
    public void initialize(Manifest manifest) {
        if (this.manifest != null) throw new IllegalStateException("This plugin was already initialized");

        this.manifest = manifest;
        this.logger = new Logger(manifest.name);
    }

    /**
     * Returns whether the user will be prompted to restart after enabling/disabling.
     * @return {@link AliucordPlugin#requiresRestart()}
     */
    public boolean requiresRestart() {
        var annotation = getAnnotation();
        return annotation != null && annotation.requiresRestart();
    }

    /**
     * Returns the @AliucordPlugin annotation if exists
     */
    @Nullable
    public AliucordPlugin getAnnotation() {
        return getClass().getAnnotation(AliucordPlugin.class);
    }

    public String getName() {
        return manifest.name;
    }

    /**
     * Called when your Plugin is loaded
     * @param context Context
     */
    public void load(Context context) throws Throwable {}

    /**
     * Called when your Plugin is unloaded
     * @param context Context
     */
    @SuppressWarnings("RedundantThrows")
    public void unload(Context context) throws Throwable {} // not used now

    /**
     * Called when your Plugin is started
     * @param context Context
     */
    public abstract void start(Context context) throws Throwable;

    /**
     * Called when your Plugin is stopped
     * @param context Context
     */
    public abstract void stop(Context context) throws Throwable;

    /** Plugin Manifest */
    public static class Manifest {
        public String name;
        public String pluginClassName;
        /** The authors of this plugin */
        public Author[] authors = new Author[]{};
        /** A short description of this plugin */
        public String description = "";
        /** The current version of this plugin */
        public String version = "1.0.0";
        // TODO: public String discord;
        /** The updater JSON url */
        public String updateUrl;
        /** Changelog featuring recent updates, written in markdown */
        public String changelog;
        /** Image or video link that will be displayed at the top of the changelog */
        public String changelogMedia;

        /** Plugin Author */
        public static class Author {
            /** The name of the plugin author */
            public String name;
            /** The id of the plugin author */
            public long id;

            /**
             * Constructs an Author with the specified name and an ID of 0
             *
             * @param name The name of the author
             */
            public Author(String name) {
                this(name, 0);
            }

            /**
             * Constructs an Author with the specified name and ID
             *
             * @param name The name of the author
             * @param id   The id of the author
             */
            public Author(String name, long id) {
                this.name = name;
                this.id = id;
            }

            @NonNull
            @Override
            public String toString() { return name; }
        }
    }

    /** Plugin SettingsTab */
    public static class SettingsTab {
        /** The {@link Type} of this SettingsTab */
        public Type type;
        /** The Page fragment */
        public Class<? extends AppFragment> page;
        /** The BottomSheet component */
        public Class<AppBottomSheet> bottomSheet;
        /** The arguments that will be passed to the constructor of the component */
        public Object[] args;

        /**
         * Creates a SettingsTab with a dedicated page
         *
         * @param settings The settings page fragment
         */
        public SettingsTab(Class<? extends AppFragment> settings) {
            type = Type.PAGE;
            page = settings;
        }

        /**
         * Creates a SettingsTab of the specified type
         *
         * @param settings The component to use for this SettingsTab
         * @param type     The {@link Type} of this SettingsTab
         */
        @SuppressWarnings("unchecked")
        public SettingsTab(Class<?> settings, Type type) {
            this.type = type;
            if (type == Type.PAGE) page = (Class<? extends AppFragment>) settings;
            else bottomSheet = (Class<AppBottomSheet>) settings;
        }

        // TODO: public boolean addTab = false;

        /**
         * Sets the constructor args that will be passed to this SettingsTab
         *
         * @param args The arguments that should be passed
         */
        public SettingsTab withArgs(Object... args) {
            this.args = args;
            return this;
        }

        /** The type of this SettingsTab. PAGE is a dedicated page, BOTTOM_SHEET is a popup at the bottom of the screen. */
        public enum Type {PAGE, BOTTOM_SHEET}

        public interface SettingsPage {
            void onViewBound(View view);
        }
    }
}
