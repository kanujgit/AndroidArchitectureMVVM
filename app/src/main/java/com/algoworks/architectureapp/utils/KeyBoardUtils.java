package com.algoworks.architectureapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Rahul on 10/30/2017.
 */

public class KeyBoardUtils {
    private static KeyBoardUtils mInstanceObj;

    public static KeyBoardUtils getInstance() {
        if (mInstanceObj == null) {
            mInstanceObj = new KeyBoardUtils();
        }
        return mInstanceObj;
    }

    public static void hideKeyboardOutsideTouch(final Activity activity, View view) {

        //Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {

            view.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(activity);
                    return false;
                }

            });
        }
    }

    public static void openSofKeyBoard(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view != null) {
            IBinder token = view.getWindowToken();
            if (token != null) {
                inputMethodManager.hideSoftInputFromWindow(token, 0);
            }
        }
    }

    public static void hideKeyboardUsingDialog(final Activity activity, final Dialog dialog, View view) {

        //Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {

            view.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    hideDialogSoftKeyboard(activity, dialog);
                    return false;
                }

            });
        }
    }

    public static void hideDialogSoftKeyboard(Activity activity, Dialog dialog) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = dialog.getCurrentFocus();
        if (view != null) {
            IBinder token = view.getWindowToken();
            if (token != null) {
                inputMethodManager.hideSoftInputFromWindow(token, 0);
            }
        }
    }
}
