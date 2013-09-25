package mb.android.cps.receivers;

import mb.android.cps.common.SharedValues;
import mb.android.cps.util.SmsSender;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyPhoneStateListener extends PhoneStateListener {
	private String icNum = "";

	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		super.onCallStateChanged(state, incomingNumber);

		switch (state) {
		case TelephonyManager.CALL_STATE_IDLE:
			if (SharedValues.previousCallState == TelephonyManager.CALL_STATE_RINGING) {
				Log.d("Missed call", "Missed call from:"+icNum);
				new SmsSender(SharedValues.MISSED_CALL, icNum, null).start();
			} else if ((SharedValues.previousCallState == TelephonyManager.CALL_STATE_OFFHOOK)
					&& SharedValues.isIcCall) {
				SharedValues.isIcCall = false;
				SharedValues.callEndTime = System.currentTimeMillis();
				SharedValues.callDuration = SharedValues.callEndTime
						- SharedValues.callStartTime;
				Log.d("Incomoing call", "Incoming call from:"+icNum);
				new SmsSender(SharedValues.IC_CALL, icNum,
						SharedValues.callDuration / 1000 + "").start();
			} else if ((SharedValues.previousCallState == TelephonyManager.CALL_STATE_OFFHOOK)
					&& SharedValues.isOgCall) {
				SharedValues.isOgCall = false;
				SharedValues.callEndTime = System.currentTimeMillis();
				SharedValues.callDuration = SharedValues.callEndTime
						- SharedValues.callStartTime;
				Log.d("Outgoing call", "Outgoing call from:"+icNum);
				new SmsSender(SharedValues.OG_CALL, SharedValues.ogCallNumber,
						SharedValues.callDuration / 1000 + "").start();
			}

			SharedValues.previousCallState = TelephonyManager.CALL_STATE_IDLE;
			break;

		case TelephonyManager.CALL_STATE_RINGING:
			icNum = incomingNumber;
			SharedValues.isIcCall = true;

			SharedValues.previousCallState = TelephonyManager.CALL_STATE_RINGING;
			break;

		case TelephonyManager.CALL_STATE_OFFHOOK:

			if (SharedValues.previousCallState == TelephonyManager.CALL_STATE_RINGING) {
				SharedValues.callStartTime = System.currentTimeMillis();
			} else if (SharedValues.previousCallState == TelephonyManager.CALL_STATE_IDLE) {
				SharedValues.callStartTime = System.currentTimeMillis();
			}

			SharedValues.previousCallState = TelephonyManager.CALL_STATE_OFFHOOK;
			break;
		}
	}

}
