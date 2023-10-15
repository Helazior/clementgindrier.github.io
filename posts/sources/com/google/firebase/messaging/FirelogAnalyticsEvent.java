package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.Constants;

@KeepForSdk
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FirelogAnalyticsEvent {
    private final String eventType = Preconditions.checkNotEmpty(Constants.FirelogAnalytics.EventType.MESSAGE_DELIVERED, "evenType must be non-null");
    private final Intent intent;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class FirelogAnalyticsEventEncoder implements ObjectEncoder<FirelogAnalyticsEvent> {
        @Override // com.google.firebase.encoders.Encoder
        public void encode(FirelogAnalyticsEvent firelogAnalyticsEvent, ObjectEncoderContext objectEncoderContext) {
            Intent intent = firelogAnalyticsEvent.getIntent();
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_TTL, MessagingAnalytics.getTtl(intent));
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_EVENT, firelogAnalyticsEvent.getEventType());
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_INSTANCE_ID, MessagingAnalytics.getInstanceId(intent));
            objectEncoderContext.add("priority", MessagingAnalytics.getPriority(intent));
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, MessagingAnalytics.getPackageName());
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_SDK_PLATFORM, Constants.FirelogAnalytics.SDK_PLATFORM_ANDROID);
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, MessagingAnalytics.getMessageTypeForFirelog(intent));
            String messageId = MessagingAnalytics.getMessageId(intent);
            if (messageId != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, messageId);
            }
            String topic = MessagingAnalytics.getTopic(intent);
            if (topic != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_TOPIC, topic);
            }
            String collapseKey = MessagingAnalytics.getCollapseKey(intent);
            if (collapseKey != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_COLLAPSE_KEY, collapseKey);
            }
            if (MessagingAnalytics.getMessageLabel(intent) != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_ANALYTICS_LABEL, MessagingAnalytics.getMessageLabel(intent));
            }
            if (MessagingAnalytics.getComposerLabel(intent) != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_COMPOSER_LABEL, MessagingAnalytics.getComposerLabel(intent));
            }
            String projectNumber = MessagingAnalytics.getProjectNumber(intent);
            if (projectNumber != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_PROJECT_NUMBER, projectNumber);
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class FirelogAnalyticsEventWrapper {
        private final FirelogAnalyticsEvent firelogAnalyticsEvent;

        public FirelogAnalyticsEventWrapper(FirelogAnalyticsEvent firelogAnalyticsEvent) {
            this.firelogAnalyticsEvent = (FirelogAnalyticsEvent) Preconditions.checkNotNull(firelogAnalyticsEvent);
        }

        public FirelogAnalyticsEvent getFirelogAnalyticsEvent() {
            return this.firelogAnalyticsEvent;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class FirelogAnalyticsEventWrapperEncoder implements ObjectEncoder<FirelogAnalyticsEventWrapper> {
        @Override // com.google.firebase.encoders.Encoder
        public void encode(FirelogAnalyticsEventWrapper firelogAnalyticsEventWrapper, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add("messaging_client_event", firelogAnalyticsEventWrapper.getFirelogAnalyticsEvent());
        }
    }

    public FirelogAnalyticsEvent(String str, Intent intent) {
        this.intent = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    public String getEventType() {
        return this.eventType;
    }

    public Intent getIntent() {
        return this.intent;
    }
}
