package com.mbh.numberrise;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;


/**
 * Created By MBH on 2016-10-27.
 */

public class NumberRiseTextView extends TextView {
    OnNumberRiseFinishedListener mOnNumberRiseFinishedListener;
    ValueAnimator newValueAnimator;
    com.nineoldandroids.animation.ValueAnimator oldValueAnimator;
    private Interpolator mInterpolator;
    private int duration = 1000; // milliseconds
    private boolean isRunning = false;

    public NumberRiseTextView(Context context) {
        super(context);
        init();
    }

    public NumberRiseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumberRiseTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initAttributes(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NumberRiseTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initAttributes(attrs);
    }

    public NumberRiseTextView setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        return this;
    }

    public NumberRiseTextView setOnNumberRiseFinishedListener(OnNumberRiseFinishedListener onNumberRiseFinishedListener) {
        mOnNumberRiseFinishedListener = onNumberRiseFinishedListener;
        return this;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getDuration() {
        return duration;
    }

    public NumberRiseTextView setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    private void init() {
        mInterpolator = new AccelerateDecelerateInterpolator();
    }

    private void initAttributes(AttributeSet attrs) {

    }

    public void animate(int from, int to) {
        animateInt(from, to);
    }

    public void animate(long from, long to) {
        animateInt((int) from, (int) to);
    }

    public void animate(float from, float to) {
        animateFloat(from, to);
    }

    public void animate(double from, double to) {
        animateFloat((float) from, (float) to);
    }

    private boolean isHoneycomb(){
//        return false;
        return android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void animateInt(int from, int to) {
        isRunning = true;
        if (isHoneycomb()) {
            newValueAnimator = ValueAnimator.ofInt(from, to);
            newValueAnimator.setDuration(duration);
            newValueAnimator.addListener(getNewListener(mOnNumberRiseFinishedListener));
            newValueAnimator.setInterpolator(mInterpolator);
            newValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @TargetApi(Build.VERSION_CODES.HONEYCOMB)
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    setText(animation.getAnimatedValue().toString());
                }
            });
            newValueAnimator.start();
        } else {
            oldValueAnimator =
                    com.nineoldandroids.animation.ValueAnimator.ofInt(from, to);
            oldValueAnimator.setDuration(duration);
            oldValueAnimator.setInterpolator(mInterpolator);
            oldValueAnimator.addListener(getOldListeners(mOnNumberRiseFinishedListener));
            oldValueAnimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(com.nineoldandroids.animation.ValueAnimator animation) {
                    setText(animation.getAnimatedValue().toString());
                }
            });
            oldValueAnimator.start();
        }
    }

    private void animateFloat(float from, float to) {
        isRunning = true;
        if (isHoneycomb()) {
            newValueAnimator = ValueAnimator.ofFloat(from, to);
            newValueAnimator.setDuration(duration);
            newValueAnimator.addListener(getNewListener(mOnNumberRiseFinishedListener));
            newValueAnimator.setInterpolator(mInterpolator);
            newValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @TargetApi(Build.VERSION_CODES.HONEYCOMB)
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    setText(animation.getAnimatedValue().toString());
                }
            });
            newValueAnimator.start();
        } else {
            oldValueAnimator =
                    com.nineoldandroids.animation.ValueAnimator.ofFloat(from, to);
            oldValueAnimator.setDuration(duration);
            oldValueAnimator.setInterpolator(mInterpolator);
            oldValueAnimator.addListener(getOldListeners(mOnNumberRiseFinishedListener));
            oldValueAnimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(com.nineoldandroids.animation.ValueAnimator animation) {
                    setText(animation.getAnimatedValue().toString());
                }
            });
            oldValueAnimator.start();
        }
    }

    public void stopAnimation() {
        clearAnimation();
    }

    @Override
    public void clearAnimation() {
        super.clearAnimation();
        stopAnimators();
    }

    private void stopAnimators() {
        if (isHoneycomb()) {
            if (newValueAnimator != null) {
                newValueAnimator.cancel();
            }
        } else {
            if (oldValueAnimator != null) {
                oldValueAnimator.cancel();
            }
        }
        newValueAnimator = null;
        oldValueAnimator = null;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private Animator.AnimatorListener getNewListener(final OnNumberRiseFinishedListener listener) {
        return new android.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(android.animation.Animator animation) {

            }

            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                isRunning = false;
                if (listener != null)
                    listener.onNumberRiseFinishedListener();
            }

            @Override
            public void onAnimationCancel(android.animation.Animator animation) {
                isRunning = false;
                if (listener != null)
                    listener.onNumberRiseFinishedListener();
            }

            @Override
            public void onAnimationRepeat(android.animation.Animator animation) {

            }
        };
    }

    private com.nineoldandroids.animation.Animator.AnimatorListener getOldListeners(final OnNumberRiseFinishedListener listener) {
        return new com.nineoldandroids.animation.Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(com.nineoldandroids.animation.Animator animation) {

            }

            @Override
            public void onAnimationEnd(com.nineoldandroids.animation.Animator animation) {
                isRunning = false;
                if (listener != null)
                    listener.onNumberRiseFinishedListener();
            }

            @Override
            public void onAnimationCancel(com.nineoldandroids.animation.Animator animation) {
                isRunning = false;
                if (listener != null)
                    listener.onNumberRiseFinishedListener();
            }

            @Override
            public void onAnimationRepeat(com.nineoldandroids.animation.Animator animation) {

            }
        };
    }

    public interface OnNumberRiseFinishedListener {
        void onNumberRiseFinishedListener();
    }

}
