package mb.android.cps.common;

import mb.android.cps.CPS;
import mb.android.cps.R;
import mb.android.cps.util.CurDevInfo;
import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;

public class SharedValues {


	
   
	public static final String PARENT_MOB_NUM = PhoneNumberUtils
			.formatNumber("9940065845"); // 15555218135
	public static final String MY_URL = "http://192.168.2.2:8080/ChildProtect/"; // "http://174.143.148.125:8080/CPS-Monitor/"
	public static final int GPS_DATA_POLLING_INTERVAL_IN_MIN = 1;

	public static final int IC_MSG = 1;
	public static final int OG_MSG = 2;
	public static final int MISSED_CALL = 3;
	public static final int IC_CALL = 4;
	public static final int OG_CALL = 5;

	public static CurDevInfo curDevInfo;

	public static String ogCallNumber = "";

	public static long callStartTime = 0;
	public static long callEndTime = 0;
	public static long callDuration = 0;

	// 0 - CALL_STATE_IDLE, 1 - CALL_STATE_RINGING, 2 - CALL_STATE_OFFHOOK
	public static int previousCallState = 0;
	public static int msgListenerCount = 0;

	public static boolean isIcCall = false;
	public static boolean isOgCall = false;

	public static final class GpsData {
		public static String latitude="00.00000";
		public static String longitude="00.00000";
		public static String speed = "0";
	}
	

}
