package com.invano.galaxys5quicksettingsicons;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;
import android.content.res.Resources.NotFoundException;
import android.content.res.XModuleResources;

public class ReplaceQuickSettingsIcons implements IXposedHookZygoteInit, IXposedHookInitPackageResources {

	private static String MODULE_PATH = null;
	private final static String mIcons[] = {
		"tw_quick_panel_icon_air_gesture_off",
        "tw_quick_panel_icon_air_gesture_on",
        "tw_quick_panel_icon_air_view_dim",
        "tw_quick_panel_icon_air_view_off",
        "tw_quick_panel_icon_air_view_on",
        "tw_quick_panel_icon_air_view_pen_off",
        "tw_quick_panel_icon_airplane_dim",
        "tw_quick_panel_icon_airplane_off",
        "tw_quick_panel_icon_airplane_on",
        "tw_quick_panel_icon_allshre_cast_dim",
        "tw_quick_panel_icon_allshre_cast_off",
        "tw_quick_panel_icon_allshre_cast_on",
        "tw_quick_panel_icon_bluetooth_dim",
        "tw_quick_panel_icon_bluetooth_off",
        "tw_quick_panel_icon_bluetooth_on",
        "tw_quick_panel_icon_data_connection_dim",
        "tw_quick_panel_icon_data_connection_off",
        "tw_quick_panel_icon_data_connection_on",
        "tw_quick_panel_icon_dormant_mode_dim",
        "tw_quick_panel_icon_dormant_mode_off",
        "tw_quick_panel_icon_dormant_mode_on",
        "tw_quick_panel_icon_driving_dim",
        "tw_quick_panel_icon_driving_off",
        "tw_quick_panel_icon_driving_on",
        "tw_quick_panel_icon_gps_dim",
        "tw_quick_panel_icon_gps_off",
        "tw_quick_panel_icon_gps_on",
        "tw_quick_panel_icon_multiwindow_dim",
        "tw_quick_panel_icon_multiwindow_off",
        "tw_quick_panel_icon_multiwindow_on",
        "tw_quick_panel_icon_nfc_card_dim",
        "tw_quick_panel_icon_nfc_card_off",
        "tw_quick_panel_icon_nfc_card_on",
        "tw_quick_panel_icon_nfcc_dim",
        "tw_quick_panel_icon_nfcc_off",
        "tw_quick_panel_icon_nfcc_on",
        "tw_quick_panel_icon_nfcc_on_att",
        "tw_quick_panel_icon_powersave_dim",
        "tw_quick_panel_icon_powersave_off",
        "tw_quick_panel_icon_powersave_on",
        "tw_quick_panel_icon_reading_mode_dim",
        "tw_quick_panel_icon_reading_mode_off",
        "tw_quick_panel_icon_reading_mode_on",
        "tw_quick_panel_icon_rotation_off",
        "tw_quick_panel_icon_rotation_on",
        "tw_quick_panel_icon_sbeam_dim",
        "tw_quick_panel_icon_sbeam_off",
        "tw_quick_panel_icon_sbeam_on",
        "tw_quick_panel_icon_silent_mode_on_on",
        "tw_quick_panel_icon_silent_off",
        "tw_quick_panel_icon_silent_off_dim",
        "tw_quick_panel_icon_silent_on",
        "tw_quick_panel_icon_smartpause_dim",
        "tw_quick_panel_icon_smartpause_off",
        "tw_quick_panel_icon_smartpause_on",
        "tw_quick_panel_icon_smartscroll_dim",
        "tw_quick_panel_icon_smartscroll_motion_dim",
        "tw_quick_panel_icon_smartscroll_motion_off",
        "tw_quick_panel_icon_smartscroll_motion_on",
        "tw_quick_panel_icon_smartscroll_off",
        "tw_quick_panel_icon_smartscroll_on",
        "tw_quick_panel_icon_smartstay_dim",
        "tw_quick_panel_icon_smartstay_off",
        "tw_quick_panel_icon_smartstay_on",
        "tw_quick_panel_icon_sync_dim",
        "tw_quick_panel_icon_sync_off",
        "tw_quick_panel_icon_sync_on",
        "tw_quick_panel_icon_wifi_dim",
        "tw_quick_panel_icon_wifi_off",
        "tw_quick_panel_icon_wifi_on",
        "tw_quick_panel_icon_wifihotspot_dim",
        "tw_quick_panel_icon_wifihotspot_off",
        "tw_quick_panel_icon_wifihotspot_on",
        "tw_quick_panel_quick_setting_button_round_bg_on",
        "tw_quick_panel_dim",
        "tw_quick_panel_off",
        "tw_quick_panel_on"
	};
	
	private final static int mIconsRes[] = {
		R.drawable.tw_quick_panel_icon_air_gesture_off,
		R.drawable.tw_quick_panel_icon_air_gesture_on,
		R.drawable.tw_quick_panel_icon_air_view_dim,
		R.drawable.tw_quick_panel_icon_air_view_off,
		R.drawable.tw_quick_panel_icon_air_view_on,
		R.drawable.tw_quick_panel_icon_air_view_pen_off,
		R.drawable.tw_quick_panel_icon_airplane_dim,
		R.drawable.tw_quick_panel_icon_airplane_off,
		R.drawable.tw_quick_panel_icon_airplane_on,
		R.drawable.tw_quick_panel_icon_allshre_cast_dim,
		R.drawable.tw_quick_panel_icon_allshre_cast_off,
		R.drawable.tw_quick_panel_icon_allshre_cast_on,
		R.drawable.tw_quick_panel_icon_bluetooth_dim,
		R.drawable.tw_quick_panel_icon_bluetooth_off,
		R.drawable.tw_quick_panel_icon_bluetooth_on,
		R.drawable.tw_quick_panel_icon_data_connection_dim,
		R.drawable.tw_quick_panel_icon_data_connection_off,
		R.drawable.tw_quick_panel_icon_data_connection_on,
		R.drawable.tw_quick_panel_icon_dormant_mode_dim,
		R.drawable.tw_quick_panel_icon_dormant_mode_off,
		R.drawable.tw_quick_panel_icon_dormant_mode_on,
		R.drawable.tw_quick_panel_icon_driving_dim,
		R.drawable.tw_quick_panel_icon_driving_off,
		R.drawable.tw_quick_panel_icon_driving_on,
		R.drawable.tw_quick_panel_icon_gps_dim,
		R.drawable.tw_quick_panel_icon_gps_off,
		R.drawable.tw_quick_panel_icon_gps_on,
		R.drawable.tw_quick_panel_icon_multiwindow_dim,
		R.drawable.tw_quick_panel_icon_multiwindow_off,
		R.drawable.tw_quick_panel_icon_multiwindow_on,
		R.drawable.tw_quick_panel_icon_nfc_card_dim,
		R.drawable.tw_quick_panel_icon_nfc_card_off,
		R.drawable.tw_quick_panel_icon_nfc_card_on,
		R.drawable.tw_quick_panel_icon_nfcc_dim,
		R.drawable.tw_quick_panel_icon_nfcc_off,
		R.drawable.tw_quick_panel_icon_nfcc_on,
		R.drawable.tw_quick_panel_icon_nfcc_on_att,
		R.drawable.tw_quick_panel_icon_powersave_dim,
		R.drawable.tw_quick_panel_icon_powersave_off,
		R.drawable.tw_quick_panel_icon_powersave_on,
		R.drawable.tw_quick_panel_icon_reading_mode_dim,
		R.drawable.tw_quick_panel_icon_reading_mode_off,
		R.drawable.tw_quick_panel_icon_reading_mode_on,
		R.drawable.tw_quick_panel_icon_rotation_off,
		R.drawable.tw_quick_panel_icon_rotation_on,
		R.drawable.tw_quick_panel_icon_sbeam_dim,
		R.drawable.tw_quick_panel_icon_sbeam_off,
		R.drawable.tw_quick_panel_icon_sbeam_on,
		R.drawable.tw_quick_panel_icon_silent_mode_on_on,
		R.drawable.tw_quick_panel_icon_silent_off,
		R.drawable.tw_quick_panel_icon_silent_off_dim,
		R.drawable.tw_quick_panel_icon_silent_on,
		R.drawable.tw_quick_panel_icon_smartpause_dim,
		R.drawable.tw_quick_panel_icon_smartpause_off,
		R.drawable.tw_quick_panel_icon_smartpause_on,
		R.drawable.tw_quick_panel_icon_smartscroll_dim,
		R.drawable.tw_quick_panel_icon_smartscroll_motion_dim,
		R.drawable.tw_quick_panel_icon_smartscroll_motion_off,
		R.drawable.tw_quick_panel_icon_smartscroll_motion_on,
		R.drawable.tw_quick_panel_icon_smartscroll_off,
		R.drawable.tw_quick_panel_icon_smartscroll_on,
		R.drawable.tw_quick_panel_icon_smartstay_dim,
		R.drawable.tw_quick_panel_icon_smartstay_off,
		R.drawable.tw_quick_panel_icon_smartstay_on,
		R.drawable.tw_quick_panel_icon_sync_dim,
		R.drawable.tw_quick_panel_icon_sync_off,
		R.drawable.tw_quick_panel_icon_sync_on,
		R.drawable.tw_quick_panel_icon_wifi_dim,
		R.drawable.tw_quick_panel_icon_wifi_off,
		R.drawable.tw_quick_panel_icon_wifi_on,
		R.drawable.tw_quick_panel_icon_wifihotspot_dim,
		R.drawable.tw_quick_panel_icon_wifihotspot_off,
		R.drawable.tw_quick_panel_icon_wifihotspot_on,
		R.drawable.tw_quick_panel_quick_setting_button_round_bg_on,
		R.drawable.tw_quick_panel_dim,
		R.drawable.tw_quick_panel_off,
		R.drawable.tw_quick_panel_on
	};
	
	@Override
	public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable {
		MODULE_PATH = startupParam.modulePath;
	}
	
	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
		
		if (!resparam.packageName.equals("com.android.systemui"))
			return;

		XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);
		for (int i = 0; i < mIcons.length; i++) {
			try {
				resparam.res.setReplacement("com.android.systemui", "drawable", mIcons[i], modRes.fwd(mIconsRes[i]));
			} catch (NotFoundException e) {
				XposedBridge.log("Resource " + mIcons[i] + " NotFound" );
			}
		}
	}

}
