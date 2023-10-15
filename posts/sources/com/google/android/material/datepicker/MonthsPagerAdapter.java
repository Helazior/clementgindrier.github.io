package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.C1103R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MonthsPagerAdapter extends RecyclerView.AbstractC0832g<ViewHolder> {
    private final CalendarConstraints calendarConstraints;
    private final Context context;
    private final DateSelector<?> dateSelector;
    private final int itemHeight;
    private final MaterialCalendar.OnDayClickListener onDayClickListener;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ViewHolder extends RecyclerView.AbstractC0824B {
        public final MaterialCalendarGridView monthGrid;
        public final TextView monthTitle;

        public ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(C1103R.C1106id.month_title);
            this.monthTitle = textView;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0470U4 c0470u4 = new C0470U4(C1675f3.tag_accessibility_heading, Boolean.class, 28);
            Boolean bool = Boolean.TRUE;
            if (Build.VERSION.SDK_INT >= 28) {
                c0470u4.m2000d(textView, bool);
            } else if (c0470u4.m1999e(c0470u4.m1945c(textView), bool)) {
                C0130F4 m1964g = C0492V4.m1964g(textView);
                C0492V4.m1950u(textView, m1964g == null ? new C0130F4() : m1964g);
                textView.setTag(c0470u4.f1804a, bool);
                C0492V4.m1958m(textView, c0470u4.f1807d);
            }
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(C1103R.C1106id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public MonthsPagerAdapter(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, MaterialCalendar.OnDayClickListener onDayClickListener) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) <= 0) {
            if (openAt.compareTo(end) <= 0) {
                int dayHeight = MaterialCalendar.getDayHeight(context) * MonthAdapter.MAXIMUM_WEEKS;
                int dayHeight2 = MaterialDatePicker.isFullscreen(context) ? MaterialCalendar.getDayHeight(context) : 0;
                this.context = context;
                this.itemHeight = dayHeight + dayHeight2;
                this.calendarConstraints = calendarConstraints;
                this.dateSelector = dateSelector;
                this.onDayClickListener = onDayClickListener;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public long getItemId(int i) {
        return this.calendarConstraints.getStart().monthsLater(i).getStableId();
    }

    public Month getPageMonth(int i) {
        return this.calendarConstraints.getStart().monthsLater(i);
    }

    public CharSequence getPageTitle(int i) {
        return getPageMonth(i).getLongName(this.context);
    }

    public int getPosition(Month month) {
        return this.calendarConstraints.getStart().monthsUntil(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Month monthsLater = this.calendarConstraints.getStart().monthsLater(i);
        viewHolder.monthTitle.setText(monthsLater.getLongName(viewHolder.itemView.getContext()));
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(C1103R.C1106id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && monthsLater.equals(materialCalendarGridView.getAdapter2().month)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().updateSelectedStates(materialCalendarGridView);
        } else {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (materialCalendarGridView.getAdapter2().withinMonth(i2)) {
                    MonthsPagerAdapter.this.onDayClickListener.onDayClick(materialCalendarGridView.getAdapter2().getItem(i2).longValue());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C1103R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
            return new ViewHolder(linearLayout, true);
        }
        return new ViewHolder(linearLayout, false);
    }
}
