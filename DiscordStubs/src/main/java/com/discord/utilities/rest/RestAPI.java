package com.discord.utilities.rest;

import android.content.Context;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.api.activity.ActivityActionConfirmation;
import com.discord.api.activity.ActivityMetadata;
import com.discord.api.application.Application;
import com.discord.api.auth.RegisterResponse;
import com.discord.api.auth.mfa.DisableMfaRequestBody;
import com.discord.api.auth.mfa.DisableMfaResponse;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.api.auth.mfa.GetBackupCodesRequestBody;
import com.discord.api.auth.mfa.GetBackupCodesResponse;
import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommand;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.fingerprint.FingerprintResponse;
import com.discord.api.friendsuggestions.BulkAddFriendsResponse;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.guild.Guild;
import com.discord.api.guild.PruneCountResponse;
import com.discord.api.guild.VanityUrlResponse;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.report.MenuAPIResponse;
import com.discord.api.report.ReportReason;
import com.discord.api.report.ReportSubmissionBody;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.thread.ThreadListing;
import com.discord.api.thread.ThreadMember;
import com.discord.api.user.UserSurveyFetchResponse;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.models.domain.Consents;
import com.discord.models.domain.Harvest;
import com.discord.models.domain.ModelApplicationStreamPreview;
import com.discord.models.domain.ModelAuditLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelBan;
import com.discord.models.domain.ModelCall;
import com.discord.models.domain.ModelChannelFollowerStatsDto;
import com.discord.models.domain.ModelConnectedAccount;
import com.discord.models.domain.ModelConnectionAccessToken;
import com.discord.models.domain.ModelConnectionState;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelLibraryApplication;
import com.discord.models.domain.ModelLocationMetadata;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.models.domain.ModelMessage;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.domain.ModelPremiumGuildSubscription;
import com.discord.models.domain.ModelPremiumGuildSubscriptionSlot;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelTypingResponse;
import com.discord.models.domain.ModelUrl;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserProfile;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.models.domain.PatchPaymentSourceRaw;
import com.discord.models.domain.PaymentSourceRaw;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.models.experiments.dto.UnauthenticatedUserExperimentsDto;
import com.discord.models.gifpicker.dto.GifDto;
import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import com.discord.models.sticker.dto.ModelUserStickerPack;
import com.discord.models.user.User;
import com.discord.restapi.BreadcrumbInterceptor;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RequiredHeadersInterceptor;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;

@SuppressWarnings("unused")
public final class RestAPI {
    public static final Companion Companion = null;
    public static RestAPI api;
    public static RestAPI apiSerializeNulls;
    public static RestAPI apiSpotify;

    public static final class AppHeadersProvider {
        public String getAuthToken() { return null; }
        public String getFingerprint() { return null; }
        public String getLocale() { return null; }
        public String getSpotifyToken() { return null; }
        public String getUserAgent() { return null; }
    }

    public static final class Companion {
        public final RestAPI getApi() { return null; }
        public final RestAPI getApiSerializeNulls() { return null; }
        public final RestAPI getApiSpotify() { return null; }
    }

    public static RestAPI getApi() { return null; }
    public static RestAPI getApiSerializeNulls() { return null; }
    public static RestAPI getApiSpotify() { return null; }

    public Observable<Void> acceptGift(String code) { return null; }

    public Observable<Void> addChannelPin(long j, long j2) {
        return null;
    }
    public Observable<Void> addChannelRecipient(long channelId, long userId) { return null; }
    public final Observable<Channel> addGroupRecipients(long groupId, List<? extends User> recipients) { return null; }

    /**
     * The emoji must be URL-Encoded (see {@link java.net.URLEncoder}) or the request will fail with 10014: Unknown Emoji.
     * To use a custom emoji, you must encode it in the format name:id with the emoji name and emoji id.
     */
    public Observable<Void> addReaction(long channelId, long messageId, String emoji) { return null; }

    public final Observable<Void> addRelationship(String location, long j, Integer num, String str2) { return null; }

    public Observable<Void> banGuildMember(long guildId, long userId, RestAPIParams.BanGuildMember banGuildMember) { return null; }

    public Observable<Void> batchUpdateRole(long guildId, List<RestAPIParams.Role> list) { return null; }

    public Observable<Void> changeGuildMember(long guildId, long userId, RestAPIParams.GuildMember guildMember) { return null; }

    public Observable<Void> changeGuildNickname(long guildId, RestAPIParams.Nick nick) { return null; }

    public Observable<Channel> convertDMToGroup(long channelId, long recipientId) { return null; }

    public final Observable<Channel> createGroupDM(List<Long> userIds) { return null; }

    public Observable<Guild> createGuild(RestAPIParams.CreateGuild createGuild) { return null; }

    public Observable<Channel> createGuildChannel(long guildId, RestAPIParams.CreateGuildChannel createGuildChannel) { return null; }

    public final Observable<Channel> createOrFetchDM(long userId) { return null; }

    public Observable<GuildRole> createRole(long guildId) { }

    public Observable<Channel> createThread(long channelId, RestAPIParams.ThreadCreationSettings threadCreationSettings) { return null; }

    public Observable<Channel> createThreadFromMessage(long channelId, long messageId, RestAPIParams.ThreadCreationSettings threadCreationSettings) { return null; }

    public Observable<Void> crosspostMessage(long channelId, Long messageId) { return null; }

    public Observable<Channel> deleteChannel(long channelId) { return null; }

    public Observable<Void> deleteChannelPin(long channelId, long messageId) { return null; }

    public Observable<Void> deleteGuild(long guildId, RestAPIParams.DeleteGuild deleteGuild) { return null; }

    public Observable<Void> deleteGuildEmoji(long guildId, long emojiId) { return null; }

    public Observable<Void> deleteGuildIntegration(long guildId, long integrationId) { return null; }

    public Observable<Void> deleteMessage(long channelId, long messageId) { return null; }

    public Observable<Void> deletePermissionOverwrites(long channelId, long targetId) { return null; }

    public Observable<Void> deleteRole(long guildId, long roleId) { return null; }

    public Observable<Void> disconnectGuildMember(long guildId, long userId, RestAPIParams.GuildMemberDisconnect guildMemberDisconnect) { return null; }

    public Observable<Channel> editGroupDM(long channelId, RestAPIParams.GroupDM groupDM) { return null; }

    public Observable<ModelMessage> editMessage(long channelId, long messageId, RestAPIParams.Message message) { return null; }

    public Observable<Channel> editTextChannel(long channelId, RestAPIParams.TextChannel textChannel) { return null; }

    public final Observable<Channel> editTextChannel(long j, String str, Integer num, String str2, Boolean bool, Integer num2) { return null; }

    public Observable<Channel> editThread(long j, RestAPIParams.ThreadSettings threadSettings) { return null; }

    public Observable<Channel> editTopicalChannel(long channelId, RestAPIParams.TopicalChannel topicalChannel) { return null; }

    public Observable<Channel> editVoiceChannel(long channelId, RestAPIParams.VoiceChannel voiceChannel) { return null; }

    public final Observable<Channel> editVoiceChannel(long j, String str, String str2, Integer num, Integer num2, Integer num3, String str3) { return null; }

    public Observable<Unit> endStageInstance(long channelId) { return null; }

    public Observable<ActivityMetadata> getActivityMetadata(long userId, String sessionId, long applicationId) { return null; }

    public Observable<ThreadListing> getAllPrivateArchivedThreads(long channelId, String before) { return null; }

    public Observable<ThreadListing> getAllPublicArchivedThreads(long channelId, String before) { return null; }

    public Observable<List<ApplicationCommand>> getApplicationCommands(long botId) { return null; }

    public Observable<List<Application>> getApplications(long applicationIds) { return null; }

    public Observable<ModelAuditLog> getAuditLogs(long guildId, int limit, Long before, Long userId, Integer actionType) { return null; }

    public final Observable<ModelAuditLog> getAuditLogs(long j, Long l, Long l2, Integer num) { return null; }

    public Observable<List<ModelBan>> getBans(long guildId) { return null; }

    public Observable<List<ModelMessage>> getChannelMessages(long channelId, Long before, Long after, Integer limit) { return null; }

    public Observable<List<ModelMessage>> getChannelMessagesAround(long channelId, int limit, long around) { return null; }

    public Observable<List<ModelMessage>> getChannelPins(long channelId) { return null; }

    public final Observable<Integer> getClientVersion() { return null; }

    public Observable<ModelConnectionState> getConnectionState(String connection, String pinNumber) { return null; }

    public Observable<List<ModelConnectedAccount>> getConnections() { return null; }

    public Observable<Guild> getEmojiGuild(long emojiId) { return null; }

    public Observable<List<ModelEmojiGuild>> getGuildEmojis(long guilId) { return null; }

    public Observable<List<ModelInvite>> getGuildInvites(long guildId) { return null; }

    public Observable<ApplicationCommandData> getInteractionData(long channelId, long messageId) { return null; }

    public Observable<ModelInvite> getInviteCode(String code, boolean withCounts) { return null; }

    public Observable<List<ModelMessage>> getMentions(int limit, boolean includeRoleMentions, boolean includeAtEveryone, Long guildId, Long before) { return null; }

    /**
     * The emoji must be URL-Encoded (see {@link java.net.URLEncoder}) or the request will fail with 10014: Unknown Emoji.
     * To use a custom emoji, you must encode it in the format name:id with the emoji name and emoji id.
     */
    public Observable<List<com.discord.api.user.User>> getReactionUsers(long channelId, long messageId, String emoji, Integer limit) { return null; }

    public Observable<List<ModelUserRelationship>> getRelationships(long userId) { return null; }

    public Observable<List<Guild>> getUserJoinRequestGuilds() { return null; }

    public Observable<Void> ignoreFriendSuggestion(long userId) { return null; }

    public final Observable<Void> inviteUserToSpeak(Channel channel, long j, Clock clock) { return null; }

    public Observable<Guild> joinGuild(long guildId, boolean lurker, String sessionId) { return null; }

    public Observable<Void> joinGuildFromIntegration(String integrationId) { return null; }

    public Observable<Void> kickGuildMember(long guildId, long userId, String reason) { return null; }

    public Observable<Void> leaveGuild(long guildId) { return null; }

    public Observable<Void> leaveThread(long channelId, String location) { return null; }

    public Observable<ModelEmojiGuild> patchGuildEmoji(long guildId, long emojiId, RestAPIParams.PatchGuildEmoji patchGuildEmoji) { return null; }

    public Observable<com.discord.api.user.User> patchUser(RestAPIParams.UserInfo userInfo) { return null; }

    public Observable<ModelInvite> postChannelInvite(long channelId, RestAPIParams.Invite invite) { return null; }

    public Observable<Void> postChannelMessagesAck(long channelId, Long messageId, RestAPIParams.ChannelMessagesAck channelMessagesAck) { return null; }

    public Observable<ModelEmojiGuild> postGuildEmoji(long guildId, RestAPIParams.PostGuildEmoji postGuildEmoji) { return null; }

    public final Observable<ModelInvite> postInviteCode(ModelInvite modelInvite, String str) { return null; }

    public Observable<ModelInvite> postInviteCode(String code, RestAPIParams.EmptyBody emptyBody, String xContextProperties) { return null; }

    public Observable<Void> pruneMembers(long guildId, RestAPIParams.PruneGuild pruneGuild) { return null; }

    public Observable<Void> removeAllReactions(long channelId, long messageId) { return null; }

    public Observable<Void> removeChannelRecipient(long channelId, long recipientId) { return null; }

    /**
     * The emoji must be URL-Encoded (see {@link java.net.URLEncoder}) or the request will fail with 10014: Unknown Emoji.
     * To use a custom emoji, you must encode it in the format name:id with the emoji name and emoji id.
     */
    public Observable<Void> removeReaction(long channelId, long messageId, String reaction, long userId) { return null; }

    public final Observable<Void> removeRelationship(String location, long userId) { return null; }

    /**
     * The emoji must be URL-Encoded (see {@link java.net.URLEncoder}) or the request will fail with 10014: Unknown Emoji.
     * To use a custom emoji, you must encode it in the format name:id with the emoji name and emoji id.
     */
    public Observable<Void> removeSelfReaction(long channelId, long messageId, String emoji) { return null; }

    public final Observable<Void> requestToSpeak(Channel channel, Clock clock) { return null; }

    public Observable<ModelInvite> revokeInvite(String inviteCode) { return null; }

    public Observable<ModelSearchResponse> searchChannelMessages(long channelId, Long maxId, List<String> authorId, List<String> mentions, List<String> has, List<String> content, Integer attempts, Boolean includeNsfw) { return null; }

    public Observable<ModelSearchResponse> searchGuildMessages(long guildId, Long maxId, List<String> authorIds, List<String> mentions, List<String> channelIds, List<String> has, List<String> content, Integer attempts, Boolean includeNsfw) { return null; }

    public Observable<ModelMessage> sendMessage(long channelId, PayloadJSON<RestAPIParams.Message> payloadJSON, MultipartBody.Part[] files) { return null; }

    public Observable<ModelMessage> sendMessage(long channelId, RestAPIParams.Message message) { return null; }

    /** Location is something like ContextMenu telling discord via which menu you added the user */
    public final Observable<Void> sendRelationshipRequest(String location, String username, int discriminator) { return null; }

    public final Observable<Void> setMeSuppressed(Channel channel, boolean z2) { return null; }

    public final Observable<Void> setUserSuppressed(Channel channel, long userId, boolean z2) { return null; }

    public Observable<ModelTypingResponse> setUserTyping(long channelId, RestAPIParams.EmptyBody emptyBody) { return null; }

    public final Observable<Void> stopRinging(long j, long j2, List<Long> list) { return null; }

    public Observable<Void> syncIntegration(long guildId, long integrationId) { return null; }

    public Observable<Void> unbanUser(long guildId, long userId) { return null; }

    public Observable<Guild> updateGuild(long guildId, RestAPIParams.UpdateGuild updateGuild) { return null; }

    public Observable<Void> updatePermissionOverwrites(long channelId, long targetId, RestAPIParams.ChannelPermissionOverwrites channelPermissionOverwrites) { return null; }

    public Observable<ModelNotificationSettings> updatePrivateChannelSettings(RestAPIParams.UserGuildSettings userGuildSettings) {
    }

    public Observable<Void> updateRole(long guildId, long roleId, RestAPIParams.Role role) { return null; }

    public Observable<com.discord.api.user.User> userGet(long userId) { return null; }

    public Observable<ModelUserProfile> userProfileGet(long id) { return null; }
}
