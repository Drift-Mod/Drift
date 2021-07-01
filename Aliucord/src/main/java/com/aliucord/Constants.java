/*
 * Copyright (c) 2021 Juby210
 * Licensed under the Open Software License version 3.0
 */

package com.aliucord;

import android.os.Environment;

import com.aliucord.utils.ReflectUtils;
import com.discord.stores.StoreStream;

@SuppressWarnings("unused")
public final class Constants {
    // Font resource ids, they're not defined by any generated package but they seem to be constant so i made this class.
    public static final class Fonts {
        private static final int base = 0x7f090000;

        public static final int ginto_bold = base;
        public static final int ginto_medium = base + 1;
        public static final int ginto_regular = base + 2;
        public static final int roboto_medium_numbers = base + 3;
        public static final int sourcecodepro_semibold = base + 4;
        public static final int whitney_bold = base + 5;
        public static final int whitney_medium = base + 6;
        public static final int whitney_semibold = base + 7;
    }

    public static final String ALIUCORD_GITHUB_REPO = "https://github.com/Aliucord/Aliucord";
    public static final String ALIUCORD_SUPPORT = "EsNDvBaHVU";
    public static final long ALIUCORD_GUILD_ID = 811255666990907402L;
    public static final long SUPPORT_CHANNEL_ID = 811261298997460992L;
    public static final long PLUGIN_SUPPORT_CHANNEL_ID = 847566769258233926L;
    public static final long PLUGIN_LINKS_CHANNEL_ID = 811275162715553823L;
    public static final long PLUGIN_LINKS_UPDATES_CHANNEL_ID = 845784407846813696L;
    public static final long PLUGIN_REQUESTS_CHANNEL_ID = 811275334342541353L;
    public static final long THEMES_CHANNEL_ID = 824357609778708580L;

    public static final String BASE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Aliucord";
    public static final String PLUGINS_PATH = BASE_PATH + "/plugins";
    public static final String CRASHLOGS_PATH = BASE_PATH + "/crashlogs";

    public static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    public static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";

    public static final String RELEASE_SUFFIX = "app_productionBetaRelease";

    public static final int DISCORD_VERSION;

    static {
        int version = 0;
        try {
            //noinspection AccessStaticViaInstance
            version = (int) ReflectUtils.getField(
                    ReflectUtils.getField(StoreStream.Companion.access$getCollector$p(StoreStream.Companion), "clientVersion", true),
                    "clientVersion",
                    true
            );
        } catch (Throwable e) { Main.logger.error(e); }
        DISCORD_VERSION = version;
    }
}
