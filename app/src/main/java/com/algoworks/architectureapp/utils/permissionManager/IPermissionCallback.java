package com.algoworks.architectureapp.utils.permissionManager;

import java.util.ArrayList;

/**
 * Created by himanshu on 14/3/18.
 */

public interface IPermissionCallback {

    void PermissionGranted(int request_code);

    void PartialPermissionGranted(int request_code, ArrayList<String> denied_permissions, ArrayList<String> allowed_permissions);

    void PermissionDenied(int request_code);

    void NeverAskAgain(int request_code);

}
