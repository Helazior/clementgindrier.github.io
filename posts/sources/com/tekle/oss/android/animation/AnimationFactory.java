package com.tekle.oss.android.animation;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ViewAnimator;
import com.tekle.oss.android.animation.FlipAnimation;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AnimationFactory {

    /* renamed from: com.tekle.oss.android.animation.AnimationFactory$6 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C15936 {

        /* renamed from: $SwitchMap$com$tekle$oss$android$animation$AnimationFactory$FlipDirection */
        public static final /* synthetic */ int[] f3937x44447fd2;

        static {
            FlipDirection.values();
            int[] iArr = new int[2];
            f3937x44447fd2 = iArr;
            try {
                FlipDirection flipDirection = FlipDirection.LEFT_RIGHT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3937x44447fd2;
                FlipDirection flipDirection2 = FlipDirection.RIGHT_LEFT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum FlipDirection {
        LEFT_RIGHT,
        RIGHT_LEFT;

        public float getEndDegreeForFirstView() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                return ordinal != 1 ? 0.0f : -90.0f;
            }
            return 90.0f;
        }

        public float getEndDegreeForSecondView() {
            return 0.0f;
        }

        public float getStartDegreeForFirstView() {
            return 0.0f;
        }

        public float getStartDegreeForSecondView() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                return ordinal != 1 ? 0.0f : 90.0f;
            }
            return -90.0f;
        }

        public FlipDirection theOtherDirection() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    return null;
                }
                return LEFT_RIGHT;
            }
            return RIGHT_LEFT;
        }
    }

    public static void fadeIn(View view) {
        if (view == null) {
            return;
        }
        view.startAnimation(fadeInAnimation(500L, view));
    }

    public static Animation fadeInAnimation(long j, long j2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(j);
        alphaAnimation.setStartOffset(j2);
        return alphaAnimation;
    }

    public static void fadeInThenOut(final View view, long j) {
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        Animation[] fadeInThenOutAnimation = fadeInThenOutAnimation(500L, j);
        animationSet.addAnimation(fadeInThenOutAnimation[0]);
        animationSet.addAnimation(fadeInThenOutAnimation[1]);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tekle.oss.android.animation.AnimationFactory.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(animationSet);
    }

    public static Animation[] fadeInThenOutAnimation(long j, long j2) {
        return new Animation[]{fadeInAnimation(j, 0L), fadeOutAnimation(j, j2 + j)};
    }

    public static void fadeOut(View view) {
        if (view == null) {
            return;
        }
        view.startAnimation(fadeOutAnimation(500L, view));
    }

    public static Animation fadeOutAnimation(long j, long j2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setStartOffset(j2);
        alphaAnimation.setDuration(j);
        return alphaAnimation;
    }

    public static Animation[] flipAnimation(View view, View view2, FlipDirection flipDirection, long j, Interpolator interpolator) {
        Animation[] animationArr = new Animation[2];
        float width = view.getWidth() / 2.0f;
        float height = view.getHeight() / 2.0f;
        FlipAnimation flipAnimation = new FlipAnimation(flipDirection.getStartDegreeForFirstView(), flipDirection.getEndDegreeForFirstView(), width, height, 0.75f, FlipAnimation.ScaleUpDownEnum.SCALE_DOWN);
        flipAnimation.setDuration(j);
        flipAnimation.setFillAfter(true);
        flipAnimation.setInterpolator(interpolator == null ? new AccelerateInterpolator() : interpolator);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(flipAnimation);
        animationArr[0] = animationSet;
        FlipAnimation flipAnimation2 = new FlipAnimation(flipDirection.getStartDegreeForSecondView(), flipDirection.getEndDegreeForSecondView(), width, height, 0.75f, FlipAnimation.ScaleUpDownEnum.SCALE_UP);
        flipAnimation2.setDuration(j);
        flipAnimation2.setFillAfter(true);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        flipAnimation2.setInterpolator(interpolator);
        flipAnimation2.setStartOffset(j);
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(flipAnimation2);
        animationArr[1] = animationSet2;
        return animationArr;
    }

    public static void flipTransition(ViewAnimator viewAnimator, FlipDirection flipDirection) {
        View currentView = viewAnimator.getCurrentView();
        int displayedChild = viewAnimator.getDisplayedChild();
        int childCount = (displayedChild + 1) % viewAnimator.getChildCount();
        View childAt = viewAnimator.getChildAt(childCount);
        if (childCount < displayedChild) {
            flipDirection = flipDirection.theOtherDirection();
        }
        Animation[] flipAnimation = flipAnimation(currentView, childAt, flipDirection, 500L, null);
        viewAnimator.setOutAnimation(flipAnimation[0]);
        viewAnimator.setInAnimation(flipAnimation[1]);
        viewAnimator.showNext();
    }

    public static Animation inFromLeftAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation inFromRightAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation inFromTopAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation outToLeftAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation outToRightAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation outToTopAnimation(long j, Interpolator interpolator) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        translateAnimation.setDuration(j);
        if (interpolator == null) {
            interpolator = new AccelerateInterpolator();
        }
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation fadeInAnimation(long j, final View view) {
        Animation fadeInAnimation = fadeInAnimation(500L, 0L);
        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tekle.oss.android.animation.AnimationFactory.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(8);
            }
        });
        return fadeInAnimation;
    }

    public static Animation fadeOutAnimation(long j, final View view) {
        Animation fadeOutAnimation = fadeOutAnimation(500L, 0L);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tekle.oss.android.animation.AnimationFactory.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return fadeOutAnimation;
    }

    public static void flipTransition(ViewAnimator viewAnimator, FlipDirection flipDirection, long j, final Animation.AnimationListener animationListener) {
        View currentView = viewAnimator.getCurrentView();
        int displayedChild = viewAnimator.getDisplayedChild();
        int childCount = (displayedChild + 1) % viewAnimator.getChildCount();
        View childAt = viewAnimator.getChildAt(childCount);
        if (childCount < displayedChild) {
            flipDirection = flipDirection.theOtherDirection();
        }
        Animation[] flipAnimation = flipAnimation(currentView, childAt, flipDirection, j, null);
        viewAnimator.setOutAnimation(flipAnimation[0]);
        viewAnimator.setInAnimation(flipAnimation[1]);
        flipAnimation[0].setAnimationListener(new Animation.AnimationListener() { // from class: com.tekle.oss.android.animation.AnimationFactory.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationStart(animation);
                }
            }
        });
        flipAnimation[1].setAnimationListener(new Animation.AnimationListener() { // from class: com.tekle.oss.android.animation.AnimationFactory.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationEnd(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        viewAnimator.showNext();
    }
}
