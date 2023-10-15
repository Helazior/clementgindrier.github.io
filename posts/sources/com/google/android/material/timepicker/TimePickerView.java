package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.C1103R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0445T2;
import p000.C0492V4;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TimePickerView extends ConstraintLayout implements TimePickerControls {
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private OnDoubleTapListener onDoubleTapListener;
    private OnPeriodChangeListener onPeriodChangeListener;
    private OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface OnPeriodChangeListener {
        void onPeriodChange(int i);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface OnSelectionChange {
        void onSelectionChanged(int i);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    private void setUpDisplay() {
        Chip chip = this.minuteView;
        int i = C1103R.C1106id.selection_type;
        chip.setTag(i, 12);
        this.hourView.setTag(i, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.timepicker.TimePickerView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                if (TimePickerView.this.onDoubleTapListener != null) {
                    TimePickerView.this.onDoubleTapListener.onDoubleTap();
                }
                return onDoubleTap;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.timepicker.TimePickerView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.minuteView.setOnTouchListener(onTouchListener);
        this.hourView.setOnTouchListener(onTouchListener);
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() == 0) {
            C0445T2 c0445t2 = new C0445T2();
            c0445t2.m2029d(this);
            AtomicInteger atomicInteger = C0492V4.f1798a;
            char c = C0492V4.C0496d.m1921d(this) == 0 ? (char) 2 : (char) 1;
            int i = C1103R.C1106id.material_clock_display;
            if (c0445t2.f1455c.containsKey(Integer.valueOf(i))) {
                C0445T2.C0446a c0446a = c0445t2.f1455c.get(Integer.valueOf(i));
                switch (c) {
                    case 1:
                        C0445T2.C0447b c0447b = c0446a.f1459d;
                        c0447b.f1505i = -1;
                        c0447b.f1503h = -1;
                        c0447b.f1466D = -1;
                        c0447b.f1472J = -1;
                        break;
                    case 2:
                        C0445T2.C0447b c0447b2 = c0446a.f1459d;
                        c0447b2.f1509k = -1;
                        c0447b2.f1507j = -1;
                        c0447b2.f1467E = -1;
                        c0447b2.f1474L = -1;
                        break;
                    case 3:
                        C0445T2.C0447b c0447b3 = c0446a.f1459d;
                        c0447b3.f1511m = -1;
                        c0447b3.f1510l = -1;
                        c0447b3.f1468F = -1;
                        c0447b3.f1473K = -1;
                        break;
                    case 4:
                        C0445T2.C0447b c0447b4 = c0446a.f1459d;
                        c0447b4.f1512n = -1;
                        c0447b4.f1513o = -1;
                        c0447b4.f1469G = -1;
                        c0447b4.f1475M = -1;
                        break;
                    case 5:
                        c0446a.f1459d.f1514p = -1;
                        break;
                    case 6:
                        C0445T2.C0447b c0447b5 = c0446a.f1459d;
                        c0447b5.f1515q = -1;
                        c0447b5.f1516r = -1;
                        c0447b5.f1471I = -1;
                        c0447b5.f1477O = -1;
                        break;
                    case 7:
                        C0445T2.C0447b c0447b6 = c0446a.f1459d;
                        c0447b6.f1517s = -1;
                        c0447b6.f1518t = -1;
                        c0447b6.f1470H = -1;
                        c0447b6.f1476N = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            c0445t2.m2030c(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            updateToggleConstraints();
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setActiveSelection(int i) {
        this.minuteView.setChecked(i == 12);
        this.hourView.setChecked(i == 10);
    }

    public void setAnimateOnTouchUp(boolean z) {
        this.clockHandView.setAnimateOnTouchUp(z);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setHandRotation(float f) {
        this.clockHandView.setHandRotation(f);
    }

    public void setHourClickDelegate(C0130F4 c0130f4) {
        C0492V4.m1950u(this.minuteView, c0130f4);
    }

    public void setMinuteHourDelegate(C0130F4 c0130f4) {
        C0492V4.m1950u(this.hourView, c0130f4);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.onDoubleTapListener = onDoubleTapListener;
    }

    public void setOnPeriodChangeListener(OnPeriodChangeListener onPeriodChangeListener) {
        this.onPeriodChangeListener = onPeriodChangeListener;
    }

    public void setOnSelectionChangeListener(OnSelectionChange onSelectionChange) {
        this.onSelectionChangeListener = onSelectionChange;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setValues(String[] strArr, int i) {
        this.clockFace.setValues(strArr, i);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    @SuppressLint({"DefaultLocale"})
    public void updateTime(int i, int i2, int i3) {
        this.toggle.check(i == 1 ? C1103R.C1106id.material_clock_period_pm_button : C1103R.C1106id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2));
        this.minuteView.setText(format);
        this.hourView.setText(format2);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHandRotation(float f, boolean z) {
        this.clockHandView.setHandRotation(f, z);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectionListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TimePickerView.this.onSelectionChangeListener != null) {
                    TimePickerView.this.onSelectionChangeListener.onSelectionChanged(((Integer) view.getTag(C1103R.C1106id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(C1103R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(C1103R.C1106id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(C1103R.C1106id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.TimePickerView.2
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i2, boolean z) {
                int i3 = i2 == C1103R.C1106id.material_clock_period_pm_button ? 1 : 0;
                if (TimePickerView.this.onPeriodChangeListener == null || !z) {
                    return;
                }
                TimePickerView.this.onPeriodChangeListener.onPeriodChange(i3);
            }
        });
        this.minuteView = (Chip) findViewById(C1103R.C1106id.material_minute_tv);
        this.hourView = (Chip) findViewById(C1103R.C1106id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(C1103R.C1106id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }
}
