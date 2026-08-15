package org.mozilla.permissionhandler;

import android.os.Parcelable;
import com.google.android.material.snackbar.Snackbar;

public interface PermissionHandle {
    int TRIGGER_DIRECT = 0;
    int TRIGGER_GRANTED = 1;
    int TRIGGER_SETTING = 2;
    void doActionDirect(String permission, int actionId, Parcelable params);
    void doActionGranted(String permission, int actionId, Parcelable params);
    void doActionSetting(String permission, int actionId, Parcelable params);
    void doActionNoPermission(String permission, int actionId, Parcelable params);
    Snackbar makeAskAgainSnackBar(int actionId);
    void permissionDeniedToast(int actionId);
    void requestPermissions(int actionId);
}
