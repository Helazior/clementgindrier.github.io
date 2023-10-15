package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import fr.smoney.android.izly.data.model.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: fr.smoney.android.izly.ui.widget.ContactAutoCompleteTextView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ContactAutoCompleteTextView extends AutoCompleteTextView {

    /* renamed from: a */
    public C1814b f4940a;

    /* renamed from: b */
    public InterfaceC1817c f4941b;

    /* renamed from: c */
    public LayoutInflater f4942c;

    /* renamed from: fr.smoney.android.izly.ui.widget.ContactAutoCompleteTextView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1813a implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        public ContactAutoCompleteTextView f4943a;

        public C1813a(ContactAutoCompleteTextView contactAutoCompleteTextView) {
            this.f4943a = contactAutoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Contact contact = ContactAutoCompleteTextView.this.f4940a.f4945a.get(i);
            if (contact.f4245c.length() > 0) {
                SpannableString spannableString = new SpannableString(contact.f4245c);
                ContactAutoCompleteTextView contactAutoCompleteTextView = ContactAutoCompleteTextView.this;
                String str = contact.f4244b;
                if (contactAutoCompleteTextView.f4942c == null) {
                    contactAutoCompleteTextView.f4942c = (LayoutInflater) contactAutoCompleteTextView.getContext().getSystemService("layout_inflater");
                }
                TextView textView = (TextView) contactAutoCompleteTextView.f4942c.inflate(2131492909, (ViewGroup) null);
                textView.setText(str);
                textView.measure(View.MeasureSpec.makeMeasureSpec(contactAutoCompleteTextView.getWidth(), 0), View.MeasureSpec.makeMeasureSpec(contactAutoCompleteTextView.getHeight(), 0));
                textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
                textView.setDrawingCacheEnabled(true);
                textView.buildDrawingCache(true);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(contactAutoCompleteTextView.getResources(), Bitmap.createBitmap(textView.getDrawingCache()));
                textView.setDrawingCacheEnabled(false);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                spannableString.setSpan(new ImageSpan(bitmapDrawable, contact.f4245c), 0, contact.f4245c.length(), 33);
                this.f4943a.setText(spannableString);
            }
            InterfaceC1817c interfaceC1817c = ContactAutoCompleteTextView.this.f4941b;
            if (interfaceC1817c != null) {
                interfaceC1817c.m833a(contact);
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.widget.ContactAutoCompleteTextView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1814b extends BaseAdapter implements Filterable {

        /* renamed from: a */
        public List<Contact> f4945a;

        /* renamed from: b */
        public List<Contact> f4946b;

        /* renamed from: c */
        public LayoutInflater f4947c;

        /* renamed from: d */
        public Filter f4948d = new C1815a();

        /* renamed from: fr.smoney.android.izly.ui.widget.ContactAutoCompleteTextView$b$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C1815a extends Filter {
            public C1815a() {
            }

            @Override // android.widget.Filter
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (charSequence != null) {
                    String charSequence2 = charSequence.toString();
                    int length = charSequence2.length();
                    List<Contact> list = C1814b.this.f4946b;
                    if (list != null && list.size() > 0) {
                        for (Contact contact : C1814b.this.f4946b) {
                            if (contact.f4244b.regionMatches(true, 0, charSequence2, 0, length)) {
                                arrayList.add(contact);
                            } else {
                                String str = contact.f4245c;
                                if (str != null && str.regionMatches(true, 0, charSequence2, 0, length)) {
                                    arrayList.add(contact);
                                } else {
                                    String str2 = contact.f4243a;
                                    if (str2 != null && str2.regionMatches(true, 0, charSequence2, 0, length)) {
                                        arrayList.add(contact);
                                    }
                                }
                            }
                        }
                    }
                    Collections.sort(arrayList);
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }
                return filterResults;
            }

            @Override // android.widget.Filter
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                C1814b c1814b = C1814b.this;
                c1814b.f4945a = (List) filterResults.values;
                c1814b.notifyDataSetChanged();
            }
        }

        /* renamed from: fr.smoney.android.izly.ui.widget.ContactAutoCompleteTextView$b$b */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C1816b {

            /* renamed from: a */
            public TextView f4950a;

            /* renamed from: b */
            public TextView f4951b;

            /* renamed from: c */
            public View f4952c;

            public C1816b(C1814b c1814b, View view) {
                this.f4950a = (TextView) view.findViewById(2131296451);
                this.f4951b = (TextView) view.findViewById(2131296450);
                this.f4952c = view.findViewById(2131296452);
            }
        }

        public C1814b(ContactAutoCompleteTextView contactAutoCompleteTextView, List<Contact> list, LayoutInflater layoutInflater) {
            this.f4945a = list;
            this.f4946b = list;
            this.f4947c = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<Contact> list = this.f4945a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return this.f4948d;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f4945a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C1816b c1816b;
            Contact contact = this.f4945a.get(i);
            if (view == null) {
                view = this.f4947c.inflate(2131492908, (ViewGroup) null);
                c1816b = new C1816b(this, view);
                view.setTag(c1816b);
            } else {
                c1816b = (C1816b) view.getTag();
            }
            c1816b.f4950a.setText(contact.f4244b);
            c1816b.f4951b.setText(contact.f4245c);
            c1816b.f4952c.setVisibility(contact.f4249h == Contact.EnumC1705b.BOOKMARKED ? 0 : 8);
            return view;
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.widget.ContactAutoCompleteTextView$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1817c {
        /* renamed from: a */
        void m833a(Contact contact);
    }

    public ContactAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1814b c1814b = new C1814b(this, new ArrayList(), (LayoutInflater) context.getSystemService("layout_inflater"));
        this.f4940a = c1814b;
        setAdapter(c1814b);
        setOnItemClickListener(new C1813a(this));
    }

    public void setOnContactClickListener(InterfaceC1817c interfaceC1817c) {
        this.f4941b = interfaceC1817c;
    }
}
