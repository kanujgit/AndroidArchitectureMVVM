/**
 * Steps to use:
 * <p>
 * 1) Call the constructor with context passed as an argument.
 * 2) Call the ic_success permission method with following arguments..
 * -> Array of permission list
 * -> String message to be shown on dialog that will appear if user rejects the permission.
 * -> Request code as "1".
 * 3) Call the onRequestPermissionResult method of this util class in onRequestPermissionResult
 * of respective activity or fragment..
 * 4) A callback from one of the methods written in IPermissionCallback will be recieved
 * according to the permissions granted or rejected
 */


package com.algoworks.architectureapp.utils.permissionManager;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.beno.activity.BaseActivity;
import com.beno.utils.AppConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermissionManager {

    private BaseActivity current_activity;

    private IPermissionCallback iPermissionCallback;

    private ArrayList<String> permission_list = new ArrayList<>();
    private ArrayList<String> listPermissionsNeeded = new ArrayList<>();
    private String dialog_content = "";
    private int req_code;

    public PermissionManager(BaseActivity context) {
        this.current_activity = context;
        iPermissionCallback = (IPermissionCallback) context;
    }

    /**
     * Check the API Level & Permission..
     * Will ic_success the permissions passed in an arrayList as an argument..
     * <p>
     * If permissions already granted:
     * -Will call the "PermissionGranted" callback of IPermissionManagerCallback
     * <p>
     * If permissions not granted:
     * -Will call "checkAndRequestPermissions" method to ask for permissions..
     *
     * @param permissions
     * @param dialog_content
     * @param request_code
     */

    public void check_permission(ArrayList<String> permissions, String dialog_content, int request_code) {

        this.permission_list = permissions;
        this.dialog_content = dialog_content;
        this.req_code = request_code;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkAndRequestPermissions(permissions, request_code)) {
                iPermissionCallback.PermissionGranted(request_code);
                Log.i("all permissions", "granted");
                Log.i("proceed", "to callback");
            }
        } else {
            iPermissionCallback.PermissionGranted(request_code);

            Log.i("all permissions", "granted");
            Log.i("proceed", "to callback");
        }

    }

    /**
     * Check and request the Permissions
     *
     * @param permissions
     * @param request_code
     * @return
     */

    public boolean checkAndRequestPermissions(ArrayList<String> permissions, int request_code) {
        listPermissionsNeeded = new ArrayList<>();

        for (int i = 0; i < permissions.size(); i++) {
            int hasPermission = ContextCompat.checkSelfPermission(current_activity, permissions.get(i));
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permissions.get(i));
            }
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(current_activity, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), request_code);
            return false;
        }
        return true;
    }

    /**
     * Will ic_success the permissions and their results as granted or denied..
     * -If result is denied, will display a dialog stating the requirement for permissions.
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case AppConstant.PERMISSION_CODES.CAMERA:
            case AppConstant.PERMISSION_CODES.STORAGE: {
                if (grantResults.length > 0) {
                    Map<String, Integer> perms = new HashMap<>();

                    for (int i = 0; i < permissions.length; i++) {
                        perms.put(permissions[i], grantResults[i]);
                    }

                    final ArrayList<String> pending_permissions = new ArrayList<>();
                    final ArrayList<String> allowed_permissions = new ArrayList<>();

                    for (int i = 0; i < listPermissionsNeeded.size(); i++) {
                        if (perms.get(listPermissionsNeeded.get(i)) != PackageManager.PERMISSION_GRANTED) {
                            if (ActivityCompat.shouldShowRequestPermissionRationale(current_activity, listPermissionsNeeded.get(i)))
                                pending_permissions.add(listPermissionsNeeded.get(i));
                            else {
                                Log.i("Go to settings", "and enable permissions");
                                iPermissionCallback.NeverAskAgain(req_code);
                                Toast.makeText(current_activity, "Go to settings and enable permissions", Toast.LENGTH_LONG).show();
                                return;
                            }
                        } else {
                            allowed_permissions.add(listPermissionsNeeded.get(i));
                        }

                    }

                    if (pending_permissions.size() > 0) {
                        // commented for direct callback
//                        showMessageOKCancel(dialog_content,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//
//                                        switch (which) {
//                                            case DialogInterface.BUTTON_POSITIVE:
//                                                check_permission(permission_list, dialog_content, req_code);
//                                                break;
//                                            case DialogInterface.BUTTON_NEGATIVE:
//                                                Log.i("permisson", "not fully given");
//                                                if (permission_list.size() == pending_permissions.size())
//                                                    iPermissionCallback.PermissionDenied(req_code);
//                                                else
//                                                    iPermissionCallback.PartialPermissionGranted(req_code, pending_permissions, allowed_permissions);
//                                                break;
//                                        }
//
//
//                                    }
//                                });

                        if (permission_list.size() == pending_permissions.size())
                            iPermissionCallback.PermissionDenied(req_code);
                        else
                            iPermissionCallback.PartialPermissionGranted(req_code, pending_permissions, allowed_permissions);

                    } else {
                        Log.i("all", "permissions granted");
                        Log.i("proceed", "to next step");
                        iPermissionCallback.PermissionGranted(req_code);

                    }


                }
                break;
            }
        }
    }


    /**
     * Explain why the app needs permissions
     *
     * @param message
     * @param okListener
     */
    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(current_activity)
                .setMessage(message)
                .setPositiveButton("Ok", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }
}
