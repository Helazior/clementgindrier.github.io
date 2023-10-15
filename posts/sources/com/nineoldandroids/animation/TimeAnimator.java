package com.nineoldandroids.animation;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TimeAnimator extends ValueAnimator {
    private TimeListener mListener;
    private long mPreviousTime = -1;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2);
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void animateValue(float f) {
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public boolean animationFrame(long j) {
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            long j2 = this.mSeekTime;
            if (j2 < 0) {
                this.mStartTime = j;
            } else {
                this.mStartTime = j - j2;
                this.mSeekTime = -1L;
            }
        }
        TimeListener timeListener = this.mListener;
        if (timeListener != null) {
            long j3 = j - this.mStartTime;
            long j4 = this.mPreviousTime;
            long j5 = j4 >= 0 ? j - j4 : 0L;
            this.mPreviousTime = j;
            timeListener.onTimeUpdate(this, j3, j5);
            return false;
        }
        return false;
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void initAnimation() {
    }

    public void setTimeListener(TimeListener timeListener) {
        this.mListener = timeListener;
    }
}
