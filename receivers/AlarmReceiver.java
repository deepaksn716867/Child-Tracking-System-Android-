package mb.android.cps.receivers;

import mb.android.cps.services.BackgroundService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context arg0, Intent arg1) {
		arg0.getApplicationContext().startService(
				new Intent(arg0.getApplicationContext(),
						BackgroundService.class));
		Log.d("Background service", "Location update started");
	}

}
