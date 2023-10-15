package fr.smoney.android.izly;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ABOUTACTIVITY = 1;
    private static final int LAYOUT_ACTIVITYACTUS = 2;
    private static final int LAYOUT_ACTIVITYACTUSDETAIL = 3;
    private static final int LAYOUT_ACTIVITYPREMYACCOUNTDETAILS = 4;
    private static final int LAYOUT_ACTIVITYPRESETTINGS = 5;
    private static final int LAYOUT_ACTIVITYPROFILEALLSTATEMENTS = 6;
    private static final int LAYOUT_ACTIVITYQRCODE = 7;
    private static final int LAYOUT_ACTIVITYSUPPORTINFORMATION = 8;
    private static final int LAYOUT_ACTUITEM = 9;
    private static final int LAYOUT_ADAPTERCAMPUSITEM = 10;
    private static final int LAYOUT_ADAPTERPLUSITEM = 11;
    private static final int LAYOUT_ADDFUNDSADATAPTERTYPECELL = 12;
    private static final int LAYOUT_ADDTRANSFERACCOUNT = 13;
    private static final int LAYOUT_ADDTRANSFERACCOUNTRESULT = 14;
    private static final int LAYOUT_ALLSTATEMENTSITEM = 15;
    private static final int LAYOUT_BLOCKACCOUNT = 16;
    private static final int LAYOUT_BLOCKACCOUNTRESULT = 17;
    private static final int LAYOUT_CANCELCONTRACTACTIVITY = 18;
    private static final int LAYOUT_CANCELCONTRACTCODEACTIVITY = 19;
    private static final int LAYOUT_CANCELCONTRACTCONFIRMATIONACTIVITY = 20;
    private static final int LAYOUT_CANCELCONTRACTRESULTACTIVITY = 21;
    private static final int LAYOUT_CBEDIT = 22;
    private static final int LAYOUT_CBLIST = 23;
    private static final int LAYOUT_CBLISTACTIVITYCONTAINER = 24;
    private static final int LAYOUT_CBLISTITEM = 25;
    private static final int LAYOUT_CHANGECONFIDENTIALITYSETTINGS = 26;
    private static final int LAYOUT_CHANGEPASSWORD = 27;
    private static final int LAYOUT_COMPONENTSAMOUNTTOGGLEBUTTONVIEW = 28;
    private static final int LAYOUT_COMPONENTSBORDERSIMPLEEDITTEXT = 29;
    private static final int LAYOUT_COMPONENTSBORDERSIMPLESPINNER = 30;
    private static final int LAYOUT_COMPONENTSDETAILBODYVIEW = 31;
    private static final int LAYOUT_COMPONENTSDETAILBODYVIEWLABELVALUE = 32;
    private static final int LAYOUT_COMPONENTSEMPTYVIEW = 33;
    private static final int LAYOUT_COMPONENTSICONTEXTVIEW = 34;
    private static final int LAYOUT_COUNTERBALANCELAYOUT = 35;
    private static final int LAYOUT_COUNTRYSPINNERITEM = 36;
    private static final int LAYOUT_CUSTOMHOMEPAGEBUTTONSLAYOUT = 37;
    private static final int LAYOUT_DETAILSUPPORTSACTIVITY = 38;
    private static final int LAYOUT_DIALOGINFORMATION = 39;
    private static final int LAYOUT_DIALOGPASSWORDENTRY = 40;
    private static final int LAYOUT_EMAILCONFIRMATION = 41;
    private static final int LAYOUT_EVENTLISTACTIVITY = 42;
    private static final int LAYOUT_EVENTLISTITEM = 43;
    private static final int LAYOUT_FAQ = 44;
    private static final int LAYOUT_FRAGMENTSELECTLISTITEMDIALOG = 45;
    private static final int LAYOUT_FRAGMENTSLIDINGMENU = 46;
    private static final int LAYOUT_GENERICWEBVIEW = 47;
    private static final int LAYOUT_GENERICWEBVIEWNOSCROLL = 48;
    private static final int LAYOUT_HISTORYACTIVITY = 49;
    private static final int LAYOUT_HOMEFRAGMENT = 50;
    private static final int LAYOUT_ITEMHOMEPAGEBUTTON = 51;
    private static final int LAYOUT_ITEMHOMEPAGESTATE = 52;
    private static final int LAYOUT_ITEMSUPPORTINFORMATION = 53;
    private static final int LAYOUT_IZLYSPINNER = 54;
    private static final int LAYOUT_LAYOUTACTIVITYFRAGMENT = 55;
    private static final int LAYOUT_LEGALMENTIONSACTIVITY = 56;
    private static final int LAYOUT_LISTITEMCOUNTERBALANCE = 58;
    private static final int LAYOUT_LISTITEMHOMEPAGEFEED = 59;
    private static final int LAYOUT_LISTITEMNEWSFEED = 60;
    private static final int LAYOUT_LISTSUPPORTSACTIVITY = 57;
    private static final int LAYOUT_LOGIN = 61;
    private static final int LAYOUT_MESSAGEVIEW = 62;
    private static final int LAYOUT_MONEYINCBSPINNERCARDDROPDOWNITEM = 63;
    private static final int LAYOUT_MYACCOUNTDETAILS = 64;
    private static final int LAYOUT_PAYEMENTINFOACTIVITY = 65;
    private static final int LAYOUT_PAYMENTLISTFRAGMENT = 66;
    private static final int LAYOUT_PHONENONVALIDATED = 67;
    private static final int LAYOUT_PLUSFRAGMENT = 68;
    private static final int LAYOUT_REGISTERCREDITCARDLAYOUT = 69;
    private static final int LAYOUT_RETRIEVEPASSWORDINITIATEPASSWORDRECOVERY = 70;
    private static final int LAYOUT_SECURETRANSACTIONVIEW = 71;
    private static final int LAYOUT_SEPABICIBANLAYOUT = 72;
    private static final int LAYOUT_SETTINGSFRAGMENT = 73;
    private static final int LAYOUT_SIMPLESPINNERITEM = 74;
    private static final int LAYOUT_STATEMENTDETAILSACTIVITY = 75;
    private static final int LAYOUT_SUPPORTCELL = 76;
    private static final int LAYOUT_TIERSINPUTVIEW = 77;
    private static final int LAYOUT_TRANSFERLAYOUT = 78;
    private static final int LAYOUT_TRXFUNDSALLSTEP1OPERATION = 79;
    private static final int LAYOUT_TRXGENERICSTEP2CONFIRM = 80;
    private static final int LAYOUT_TRXGENERICSTEP3RESULT = 81;
    private static final int LAYOUT_VIEWSUBMITBUTTON = 82;
    private static final int LAYOUT_WHOWEAREACTIVITY = 83;

    /* renamed from: fr.smoney.android.izly.DataBinderMapperImpl$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1689a {

        /* renamed from: a */
        public static final SparseArray<String> f4195a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f4195a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    /* renamed from: fr.smoney.android.izly.DataBinderMapperImpl$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1690b {

        /* renamed from: a */
        public static final HashMap<String, Integer> f4196a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(83);
            f4196a = hashMap;
            outline.m245z(2131492892, hashMap, "layout/about_activity_0", 2131492894, "layout/activity_actus_0", 2131492895, "layout/activity_actus_detail_0", 2131492896, "layout/activity_pre_my_account_details_0");
            outline.m245z(2131492897, hashMap, "layout/activity_pre_settings_0", 2131492898, "layout/activity_profile_all_statements_0", 2131492899, "layout/activity_qr_code_0", 2131492900, "layout/activity_support_information_0");
            outline.m245z(2131492901, hashMap, "layout/actu_item_0", 2131492902, "layout/adapter_campus_item_0", 2131492903, "layout/adapter_plus_item_0", 2131492904, "layout/add_funds_adatapter_type_cell_0");
            outline.m245z(2131492905, hashMap, "layout/add_transfer_account_0", 2131492906, "layout/add_transfer_account_result_0", 2131492907, "layout/all_statements_item_0", 2131492910, "layout/block_account_0");
            outline.m245z(2131492911, hashMap, "layout/block_account_result_0", 2131492912, "layout/cancel_contract_activity_0", 2131492913, "layout/cancel_contract_code_activity_0", 2131492914, "layout/cancel_contract_confirmation_activity_0");
            outline.m245z(2131492915, hashMap, "layout/cancel_contract_result_activity_0", 2131492916, "layout/cb_edit_0", 2131492917, "layout/cb_list_0", 2131492918, "layout/cb_list_activity_container_0");
            outline.m245z(2131492919, hashMap, "layout/cb_list_item_0", 2131492920, "layout/change_confidentiality_settings_0", 2131492921, "layout/change_password_0", 2131492922, "layout/components_amount_toggle_button_view_0");
            outline.m245z(2131492923, hashMap, "layout/components_border_simple_edittext_0", 2131492924, "layout/components_border_simple_spinner_0", 2131492925, "layout/components_detail_body_view_0", 2131492926, "layout/components_detail_body_view_label_value_0");
            outline.m245z(2131492927, hashMap, "layout/components_empty_view_0", 2131492928, "layout/components_icon_textview_0", 2131492931, "layout/counter_balance_layout_0", 2131492932, "layout/country_spinner_item_0");
            outline.m245z(2131492934, hashMap, "layout/custom_homepage_buttons_layout_0", 2131492950, "layout/detail_supports_activity_0", 2131492952, "layout/dialog_information_0", 2131492953, "layout/dialog_password_entry_0");
            outline.m245z(2131492956, hashMap, "layout/email_confirmation_0", 2131492957, "layout/event_list_activity_0", 2131492958, "layout/event_list_item_0", 2131492959, "layout/faq_0");
            outline.m245z(2131492960, hashMap, "layout/fragment_select_list_item_dialog_0", 2131492961, "layout/fragment_sliding_menu_0", 2131492966, "layout/generic_webview_0", 2131492967, "layout/generic_webview_no_scroll_0");
            outline.m245z(2131492968, hashMap, "layout/history_activity_0", 2131492969, "layout/home_fragment_0", 2131492971, "layout/item_homepage_button_0", 2131492972, "layout/item_homepage_state_0");
            outline.m245z(2131492973, hashMap, "layout/item_support_information_0", 2131492974, "layout/izly_spinner_0", 2131492975, "layout/layout_activity_fragment_0", 2131492977, "layout/legalmentions_activity_0");
            outline.m245z(2131492978, hashMap, "layout/list_supports_activity_0", 2131492979, "layout/listitem_counter_balance_0", 2131492980, "layout/listitem_homepage_feed_0", 2131492982, "layout/listitem_news_feed_0");
            outline.m245z(2131492983, hashMap, "layout/login_0", 2131492999, "layout/message_view_0", 2131493000, "layout/money_in_cb_spinner_card_dropdown_item_0", 2131493029, "layout/my_account_details_0");
            outline.m245z(2131493037, hashMap, "layout/payement_info_activity_0", 2131493038, "layout/payment_list_fragment_0", 2131493039, "layout/phone_non_validated_0", 2131493040, "layout/plus_fragment_0");
            outline.m245z(2131493041, hashMap, "layout/register_credit_card_layout_0", 2131493042, "layout/retrieve_password_initiate_password_recovery_0", 2131493043, "layout/secure_transaction_view_0", 2131493048, "layout/sepa_bic_iban_layout_0");
            outline.m245z(2131493049, hashMap, "layout/settings_fragment_0", 2131493050, "layout/simple_spinner_item_0", 2131493055, "layout/statement_details_activity_0", 2131493057, "layout/support_cell_0");
            outline.m245z(2131493073, hashMap, "layout/tiers_input_view_0", 2131493075, "layout/transfer_layout_0", 2131493076, "layout/trx_funds_all_step1_operation_0", 2131493077, "layout/trx_generic_step2_confirm_0");
            hashMap.put("layout/trx_generic_step3_result_0", 2131493078);
            hashMap.put("layout/view_submit_button_0", 2131493079);
            hashMap.put("layout/whoweare_activity_0", 2131493080);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(83);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(2131492892, 1);
        sparseIntArray.put(2131492894, 2);
        sparseIntArray.put(2131492895, 3);
        sparseIntArray.put(2131492896, 4);
        sparseIntArray.put(2131492897, 5);
        sparseIntArray.put(2131492898, 6);
        sparseIntArray.put(2131492899, 7);
        sparseIntArray.put(2131492900, 8);
        sparseIntArray.put(2131492901, 9);
        sparseIntArray.put(2131492902, 10);
        sparseIntArray.put(2131492903, 11);
        sparseIntArray.put(2131492904, 12);
        sparseIntArray.put(2131492905, 13);
        sparseIntArray.put(2131492906, 14);
        sparseIntArray.put(2131492907, 15);
        sparseIntArray.put(2131492910, 16);
        sparseIntArray.put(2131492911, 17);
        sparseIntArray.put(2131492912, 18);
        sparseIntArray.put(2131492913, 19);
        sparseIntArray.put(2131492914, 20);
        sparseIntArray.put(2131492915, 21);
        sparseIntArray.put(2131492916, 22);
        sparseIntArray.put(2131492917, 23);
        sparseIntArray.put(2131492918, 24);
        sparseIntArray.put(2131492919, 25);
        sparseIntArray.put(2131492920, 26);
        sparseIntArray.put(2131492921, 27);
        sparseIntArray.put(2131492922, 28);
        sparseIntArray.put(2131492923, 29);
        sparseIntArray.put(2131492924, 30);
        sparseIntArray.put(2131492925, 31);
        sparseIntArray.put(2131492926, 32);
        sparseIntArray.put(2131492927, 33);
        sparseIntArray.put(2131492928, 34);
        sparseIntArray.put(2131492931, 35);
        sparseIntArray.put(2131492932, 36);
        sparseIntArray.put(2131492934, 37);
        sparseIntArray.put(2131492950, 38);
        sparseIntArray.put(2131492952, 39);
        sparseIntArray.put(2131492953, 40);
        sparseIntArray.put(2131492956, 41);
        sparseIntArray.put(2131492957, 42);
        sparseIntArray.put(2131492958, 43);
        sparseIntArray.put(2131492959, 44);
        sparseIntArray.put(2131492960, 45);
        sparseIntArray.put(2131492961, 46);
        sparseIntArray.put(2131492966, 47);
        sparseIntArray.put(2131492967, 48);
        sparseIntArray.put(2131492968, 49);
        sparseIntArray.put(2131492969, 50);
        sparseIntArray.put(2131492971, 51);
        sparseIntArray.put(2131492972, 52);
        sparseIntArray.put(2131492973, 53);
        sparseIntArray.put(2131492974, 54);
        sparseIntArray.put(2131492975, 55);
        sparseIntArray.put(2131492977, 56);
        sparseIntArray.put(2131492978, 57);
        sparseIntArray.put(2131492979, 58);
        sparseIntArray.put(2131492980, 59);
        sparseIntArray.put(2131492982, 60);
        sparseIntArray.put(2131492983, 61);
        sparseIntArray.put(2131492999, 62);
        sparseIntArray.put(2131493000, 63);
        sparseIntArray.put(2131493029, 64);
        sparseIntArray.put(2131493037, 65);
        sparseIntArray.put(2131493038, 66);
        sparseIntArray.put(2131493039, 67);
        sparseIntArray.put(2131493040, 68);
        sparseIntArray.put(2131493041, 69);
        sparseIntArray.put(2131493042, 70);
        sparseIntArray.put(2131493043, 71);
        sparseIntArray.put(2131493048, 72);
        sparseIntArray.put(2131493049, 73);
        sparseIntArray.put(2131493050, 74);
        sparseIntArray.put(2131493055, 75);
        sparseIntArray.put(2131493057, 76);
        sparseIntArray.put(2131493073, 77);
        sparseIntArray.put(2131493075, 78);
        sparseIntArray.put(2131493076, 79);
        sparseIntArray.put(2131493077, 80);
        sparseIntArray.put(2131493078, 81);
        sparseIntArray.put(2131493079, 82);
        sparseIntArray.put(2131493080, 83);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/about_activity_0".equals(obj)) {
                    return new C2178p9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for about_activity is invalid. Received: ", obj));
            case 2:
                if ("layout/activity_actus_0".equals(obj)) {
                    return new C2215r9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for activity_actus is invalid. Received: ", obj));
            case 3:
                if ("layout/activity_actus_detail_0".equals(obj)) {
                    return new C2258t9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for activity_actus_detail is invalid. Received: ", obj));
            case 4:
                if ("layout/activity_pre_my_account_details_0".equals(obj)) {
                    return new C2294v9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for activity_pre_my_account_details is invalid. Received: ", obj));
            case 5:
                if ("layout/activity_pre_settings_0".equals(obj)) {
                    return new C2353x9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for activity_pre_settings is invalid. Received: ", obj));
            case 6:
                if ("layout/activity_profile_all_statements_0".equals(obj)) {
                    return new C2405z9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for activity_profile_all_statements is invalid. Received: ", obj));
            case 7:
                if ("layout/activity_qr_code_0".equals(obj)) {
                    return new C0045B9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for activity_qr_code is invalid. Received: ", obj));
            case 8:
                if ("layout/activity_support_information_0".equals(obj)) {
                    return new C0092D9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for activity_support_information is invalid. Received: ", obj));
            case 9:
                if ("layout/actu_item_0".equals(obj)) {
                    return new C0136F9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for actu_item is invalid. Received: ", obj));
            case 10:
                if ("layout/adapter_campus_item_0".equals(obj)) {
                    return new C0176H9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for adapter_campus_item is invalid. Received: ", obj));
            case 11:
                if ("layout/adapter_plus_item_0".equals(obj)) {
                    return new C0224J9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for adapter_plus_item is invalid. Received: ", obj));
            case 12:
                if ("layout/add_funds_adatapter_type_cell_0".equals(obj)) {
                    return new C0274L9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for add_funds_adatapter_type_cell is invalid. Received: ", obj));
            case 13:
                if ("layout/add_transfer_account_0".equals(obj)) {
                    return new C0315N9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for add_transfer_account is invalid. Received: ", obj));
            case 14:
                if ("layout/add_transfer_account_result_0".equals(obj)) {
                    return new C0357P9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for add_transfer_account_result is invalid. Received: ", obj));
            case 15:
                if ("layout/all_statements_item_0".equals(obj)) {
                    return new C0403R9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for all_statements_item is invalid. Received: ", obj));
            case 16:
                if ("layout/block_account_0".equals(obj)) {
                    return new C0459T9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for block_account is invalid. Received: ", obj));
            case 17:
                if ("layout/block_account_result_0".equals(obj)) {
                    return new C0522V9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for block_account_result is invalid. Received: ", obj));
            case 18:
                if ("layout/cancel_contract_activity_0".equals(obj)) {
                    return new C0561X9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cancel_contract_activity is invalid. Received: ", obj));
            case 19:
                if ("layout/cancel_contract_code_activity_0".equals(obj)) {
                    return new C0593Z9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cancel_contract_code_activity is invalid. Received: ", obj));
            case 20:
                if ("layout/cancel_contract_confirmation_activity_0".equals(obj)) {
                    return new C0974ba(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cancel_contract_confirmation_activity is invalid. Received: ", obj));
            case 21:
                if ("layout/cancel_contract_result_activity_0".equals(obj)) {
                    return new C1628da(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cancel_contract_result_activity is invalid. Received: ", obj));
            case 22:
                if ("layout/cb_edit_0".equals(obj)) {
                    return new C1684fa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cb_edit is invalid. Received: ", obj));
            case 23:
                if ("layout/cb_list_0".equals(obj)) {
                    return new C1925ja(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cb_list is invalid. Received: ", obj));
            case 24:
                if ("layout/cb_list_activity_container_0".equals(obj)) {
                    return new C1876ha(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cb_list_activity_container is invalid. Received: ", obj));
            case 25:
                if ("layout/cb_list_item_0".equals(obj)) {
                    return new C1962la(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for cb_list_item is invalid. Received: ", obj));
            case 26:
                if ("layout/change_confidentiality_settings_0".equals(obj)) {
                    return new C2007na(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for change_confidentiality_settings is invalid. Received: ", obj));
            case 27:
                if ("layout/change_password_0".equals(obj)) {
                    return new C2179pa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for change_password is invalid. Received: ", obj));
            case 28:
                if ("layout/components_amount_toggle_button_view_0".equals(obj)) {
                    return new C2216ra(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for components_amount_toggle_button_view is invalid. Received: ", obj));
            case 29:
                if ("layout/components_border_simple_edittext_0".equals(obj)) {
                    return new C2259ta(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for components_border_simple_edittext is invalid. Received: ", obj));
            case 30:
                if ("layout/components_border_simple_spinner_0".equals(obj)) {
                    return new C2295va(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for components_border_simple_spinner is invalid. Received: ", obj));
            case 31:
                if ("layout/components_detail_body_view_0".equals(obj)) {
                    return new C2354xa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for components_detail_body_view is invalid. Received: ", obj));
            case 32:
                if ("layout/components_detail_body_view_label_value_0".equals(obj)) {
                    return new C2406za(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for components_detail_body_view_label_value is invalid. Received: ", obj));
            case 33:
                if ("layout/components_empty_view_0".equals(obj)) {
                    return new C0046Ba(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for components_empty_view is invalid. Received: ", obj));
            case 34:
                if ("layout/components_icon_textview_0".equals(obj)) {
                    return new C0093Da(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for components_icon_textview is invalid. Received: ", obj));
            case 35:
                if ("layout/counter_balance_layout_0".equals(obj)) {
                    return new C0137Fa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for counter_balance_layout is invalid. Received: ", obj));
            case 36:
                if ("layout/country_spinner_item_0".equals(obj)) {
                    return new C0177Ha(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for country_spinner_item is invalid. Received: ", obj));
            case 37:
                if ("layout/custom_homepage_buttons_layout_0".equals(obj)) {
                    return new C0225Ja(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for custom_homepage_buttons_layout is invalid. Received: ", obj));
            case 38:
                if ("layout/detail_supports_activity_0".equals(obj)) {
                    return new C0275La(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for detail_supports_activity is invalid. Received: ", obj));
            case 39:
                if ("layout/dialog_information_0".equals(obj)) {
                    return new C0316Na(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for dialog_information is invalid. Received: ", obj));
            case 40:
                if ("layout/dialog_password_entry_0".equals(obj)) {
                    return new C0358Pa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for dialog_password_entry is invalid. Received: ", obj));
            case 41:
                if ("layout/email_confirmation_0".equals(obj)) {
                    return new C0404Ra(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for email_confirmation is invalid. Received: ", obj));
            case 42:
                if ("layout/event_list_activity_0".equals(obj)) {
                    return new C0460Ta(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for event_list_activity is invalid. Received: ", obj));
            case 43:
                if ("layout/event_list_item_0".equals(obj)) {
                    return new C0523Va(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for event_list_item is invalid. Received: ", obj));
            case 44:
                if ("layout/faq_0".equals(obj)) {
                    return new C0562Xa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for faq is invalid. Received: ", obj));
            case 45:
                if ("layout/fragment_select_list_item_dialog_0".equals(obj)) {
                    return new C0594Za(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for fragment_select_list_item_dialog is invalid. Received: ", obj));
            case 46:
                if ("layout/fragment_sliding_menu_0".equals(obj)) {
                    return new C0975bb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for fragment_sliding_menu is invalid. Received: ", obj));
            case 47:
                if ("layout/generic_webview_0".equals(obj)) {
                    return new C1629db(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for generic_webview is invalid. Received: ", obj));
            case 48:
                if ("layout/generic_webview_no_scroll_0".equals(obj)) {
                    return new C1685fb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for generic_webview_no_scroll is invalid. Received: ", obj));
            case 49:
                if ("layout/history_activity_0".equals(obj)) {
                    return new C1877hb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for history_activity is invalid. Received: ", obj));
            case 50:
                if ("layout/home_fragment_0".equals(obj)) {
                    return new C1926jb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for home_fragment is invalid. Received: ", obj));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/item_homepage_button_0".equals(obj)) {
                    return new C1963lb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for item_homepage_button is invalid. Received: ", obj));
            case 52:
                if ("layout/item_homepage_state_0".equals(obj)) {
                    return new C2008nb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for item_homepage_state is invalid. Received: ", obj));
            case 53:
                if ("layout/item_support_information_0".equals(obj)) {
                    return new C2180pb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for item_support_information is invalid. Received: ", obj));
            case 54:
                if ("layout/izly_spinner_0".equals(obj)) {
                    return new C2217rb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for izly_spinner is invalid. Received: ", obj));
            case 55:
                if ("layout/layout_activity_fragment_0".equals(obj)) {
                    return new C2260tb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for layout_activity_fragment is invalid. Received: ", obj));
            case 56:
                if ("layout/legalmentions_activity_0".equals(obj)) {
                    return new C2296vb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for legalmentions_activity is invalid. Received: ", obj));
            case 57:
                if ("layout/list_supports_activity_0".equals(obj)) {
                    return new C2355xb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for list_supports_activity is invalid. Received: ", obj));
            case 58:
                if ("layout/listitem_counter_balance_0".equals(obj)) {
                    return new C2407zb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for listitem_counter_balance is invalid. Received: ", obj));
            case 59:
                if ("layout/listitem_homepage_feed_0".equals(obj)) {
                    return new C0047Bb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for listitem_homepage_feed is invalid. Received: ", obj));
            case 60:
                if ("layout/listitem_news_feed_0".equals(obj)) {
                    return new C0094Db(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for listitem_news_feed is invalid. Received: ", obj));
            case 61:
                if ("layout/login_0".equals(obj)) {
                    return new C0138Fb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for login is invalid. Received: ", obj));
            case 62:
                if ("layout/message_view_0".equals(obj)) {
                    return new C0178Hb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for message_view is invalid. Received: ", obj));
            case 63:
                if ("layout/money_in_cb_spinner_card_dropdown_item_0".equals(obj)) {
                    return new C0226Jb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for money_in_cb_spinner_card_dropdown_item is invalid. Received: ", obj));
            case 64:
                if ("layout/my_account_details_0".equals(obj)) {
                    return new C0276Lb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for my_account_details is invalid. Received: ", obj));
            case 65:
                if ("layout/payement_info_activity_0".equals(obj)) {
                    return new C0317Nb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for payement_info_activity is invalid. Received: ", obj));
            case 66:
                if ("layout/payment_list_fragment_0".equals(obj)) {
                    return new C0359Pb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for payment_list_fragment is invalid. Received: ", obj));
            case 67:
                if ("layout/phone_non_validated_0".equals(obj)) {
                    return new C0405Rb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for phone_non_validated is invalid. Received: ", obj));
            case 68:
                if ("layout/plus_fragment_0".equals(obj)) {
                    return new C0461Tb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for plus_fragment is invalid. Received: ", obj));
            case 69:
                if ("layout/register_credit_card_layout_0".equals(obj)) {
                    return new C0524Vb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for register_credit_card_layout is invalid. Received: ", obj));
            case 70:
                if ("layout/retrieve_password_initiate_password_recovery_0".equals(obj)) {
                    return new C0563Xb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for retrieve_password_initiate_password_recovery is invalid. Received: ", obj));
            case 71:
                if ("layout/secure_transaction_view_0".equals(obj)) {
                    return new C0595Zb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for secure_transaction_view is invalid. Received: ", obj));
            case 72:
                if ("layout/sepa_bic_iban_layout_0".equals(obj)) {
                    return new C0976bc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for sepa_bic_iban_layout is invalid. Received: ", obj));
            case 73:
                if ("layout/settings_fragment_0".equals(obj)) {
                    return new C1630dc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for settings_fragment is invalid. Received: ", obj));
            case 74:
                if ("layout/simple_spinner_item_0".equals(obj)) {
                    return new C1686fc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for simple_spinner_item is invalid. Received: ", obj));
            case 75:
                if ("layout/statement_details_activity_0".equals(obj)) {
                    return new C1878hc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for statement_details_activity is invalid. Received: ", obj));
            case 76:
                if ("layout/support_cell_0".equals(obj)) {
                    return new C1927jc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for support_cell is invalid. Received: ", obj));
            case 77:
                if ("layout/tiers_input_view_0".equals(obj)) {
                    return new C1964lc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for tiers_input_view is invalid. Received: ", obj));
            case 78:
                if ("layout/transfer_layout_0".equals(obj)) {
                    return new C2009nc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for transfer_layout is invalid. Received: ", obj));
            case 79:
                if ("layout/trx_funds_all_step1_operation_0".equals(obj)) {
                    return new C2181pc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for trx_funds_all_step1_operation is invalid. Received: ", obj));
            case 80:
                if ("layout/trx_generic_step2_confirm_0".equals(obj)) {
                    return new C2218rc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for trx_generic_step2_confirm is invalid. Received: ", obj));
            case 81:
                if ("layout/trx_generic_step3_result_0".equals(obj)) {
                    return new C2261tc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for trx_generic_step3_result is invalid. Received: ", obj));
            case 82:
                if ("layout/view_submit_button_0".equals(obj)) {
                    return new C2297vc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for view_submit_button is invalid. Received: ", obj));
            case 83:
                if ("layout/whoweare_activity_0".equals(obj)) {
                    return new C2356xc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(outline.m267d("The tag for whoweare_activity is invalid. Received: ", obj));
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return C1689a.f4195a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                int i3 = (i2 - 1) / 50;
                if (i3 != 0) {
                    if (i3 != 1) {
                        return null;
                    }
                    return internalGetViewDataBinding1(dataBindingComponent, view, i2, tag);
                }
                return internalGetViewDataBinding0(dataBindingComponent, view, i2, tag);
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = C1690b.f4196a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
