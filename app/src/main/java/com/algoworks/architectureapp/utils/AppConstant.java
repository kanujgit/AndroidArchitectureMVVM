package com.algoworks.architectureapp.utils;

import android.Manifest;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

public class AppConstant {


    public static final String HOCKEY_APPID = "c5e2062e550b430bb8fea1a31738f82c";
    public static final String FIREBASEHOST = "https://test-c0301.firebaseio.com/";
    public static final String GPLUS_ID = "901679639956-kqhq4q7rdrcruscn71cd8pbt95psbdpt.apps.googleusercontent.com";
    public static final int PASSWARD_LENGTH = 5;
    public static final String TYPE = "tab_host_frag_type";
    public static final int INBOX = 1;
    public static final int FRIENDS = 0;
    private static String deviceId;
    public static final String BID = "bid";
    public static final String STATUS = "true";
    public static final String DEVICE_OS = "1";
    public static final int TAKE_PICTURE = 0;
    public static final int CHOOSE_PICTURE = 1;
    public static final String PHOTO_VIDEO_TITLE = "frag_name";
    public static final String GROUP = "group";
    public static final int JOIN_GROUP = 1;
    public static final int LEAVE_GROUP = 2;
    public static final int PHOTOS = 1;
    public static final int VIDEOS = 2;
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String LIST = "list";
    public static final String GROUP_ID = "group_id";
    public static final String ISHOME = "ishome";
    public static final String POSITION = "position";
    public static final String EXTRA_IN_API_KEY_SECRET = "aviary_secret_key";

    public final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static final int LOCATION_UPDATE_INTERVAL = 30 * 60 * 1000;
    public static final int LOCATION_FASTEST_UPDATE_INTERVAL = 60 * 1000;

    public static final String USER = "user";
    public static final String FRIEND_STATUS = "friend_status";
    public static final String MEMBER_COUNT = "member_count";
    public static final String NOTIFICATION = "notification";
    public static final String NOTIF_DATA = "notif_data";
    public static final String PRIV_DATA = "priv_data";
    public static final String CHAT_SCREEN_TYPE = "chat_screen_type";
    public static final String HOT_TOPICS = "hot_topics";
    public static final int HOT_TOPIC = 9;
    public static final String HOT_TOPIC_LIST = "hotTopicList";
    public static final String NOTIFICATION_ICON = "notificationIcon";
    public static final String NOTIFICATION_BROADCAST = "notofication_broadcast";
    public static final int REQUSET_FEED_FILTER = 5;

    public static final String NOTIFICATION_PUSH = "notificationIcon_PUSH";
    public static final String NOTIFICATION_MESSAGE = "notofication_MESSAGE";
    public static final String TOUCH_ID = "touch_id";
    public static final String CARS_PREFRENCES = "cars_prefrences";


    public static int LIST_COUNT = 20;
    public static String MEDIA_TYPE = "media_type";


    public static final String FragmentVal = "fragmentVal";
    public static int CHAT_JOIN = 1;
    public static int REQUEST_CODE_FILTER = 1;
    public static int REQUEST_CODE_MAP = 2;
    public static int REQUEST_REFRESH = 3;
    public static String COACHMARK;
    public static String Beno_Vendor = "0";
    // public static final String FIREBASE_URL = "https://can-i-just-say-it.firebaseio.com";  // alreday used for project


    public static int LOGIN_VIA_EMAIL = 0;
    public static int LOGIN_VIA_FB = 1;
    public static int LOGIN_VIA_GOOGLE_SIGN = 2;
    public static final String LOGIN_TYPE = "login_type";
    public static final String SOCIAL_TOKEN = "social_ids";

    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";


    public static final String WEB_URLS = "";



    //prod
    private static String BaseUrl = "https://www.google.com";

    public static String ABOUT_US_URL = BaseUrl + "/";
    public static String CANCELLATION_URL = BaseUrl + "/";
    public static String REFUND_URL = BaseUrl + "/";
    public static String TERMS_CONDITION_URL = BaseUrl + "/";

    public static String ABOUT_US = "About Us";
    public static String CANCELLATION_POLICY = "Cancellation Policy";
    public static String REFUND_POLICY = "Refund Policy";
    public static String TERM_CONDITION = "Terms & Conditions";

    public static String CAR_ID = "car_id";
    public final static int PAGE_SIZE_LIMIT = 20;


    public static void setDeviceId(Context context) {
        deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getDeviceId() {
        if (TextUtils.isEmpty(deviceId)) {
            return "0";
        } else {
            return deviceId;
        }
    }


    public interface PreferenceKeeperNames {
        String LOGIN = "login";
        String FIRST_LOGIN = "first_login";
        String ACCESS_TOKEN = "access_token";
        String USER = "user";
        String FCM_TOKEN = "fcm_token";
        String PROFILE_IMAGE = "profile_image";
        String RADIUS = "radius";
        String GROUPRADIUS = "groupradius";
        String HOMEFILTER = "homefilter";
        String GROUPFILTER = "groupfilter";
        String IS_GROUP_ACCESS = "group_access";
        String SCREEN_HEIGHT = "screen_height";
        String PHONE_NUMBER = "phone_number";
        String VENDOR_PHONE_NUMBER = "phone";
    }

    public interface PERMISSION_REQ_CODE {
        int WRITE_EXTERNAL = 0;
        int GET_ACCOUNT = 2;
        int READ_CONTACTS = 1;
    }

    public interface BUNDLE_KEY {
        String PRIVACY_URL = "privacy_url";
        String VIDEO_URI = "video_uri";
        String FEED_UPDATE = "feed_update";
        String POST_ID = "post_id";
        String MEDIAS = "medias";
        String IS_HOT_TOPIC = "hot_topic";
        String POST = "post";
        String FROMNOTIFY = "notification";
        String CHATID = "chatId";
        String IS_Group_Access = "isGroupAccess";
    }

    public interface FOOTER_INDEX {
        int FEED = 0;
        int GROUPS = 1;
        int INBOX = 2;
        int FRIENDS = 3;
        int NOTIFICATION = 4;
    }


    public interface PERMISSION {
        String CAMERA = Manifest.permission.CAMERA;
        String WRITE_EXTERNAL = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        String READ_EXTERNAL = Manifest.permission.READ_EXTERNAL_STORAGE;
    }

    public interface REQUEST_CODE {
        int CAPTURE_IMAGE = 0;
        int GALLARY_IMAGE = 1;
        int CAMERA_PERMISSION = 2;
        int WRITE_EXTERNAL_PERMISSION = 3;
        int GALLARY_VIDEO = 4;
        int CAPTURE_VIDEO = 5;
        int MULTIPLE_GALLERY_IMAGE = 6;
        int IMAGE_EDITING_DATA = 7;
        int CAPTURE_IMAGE_PROFILE = 8;
        int GALLARY_IMAGE_PROFILE = 9;

    }

    public interface MEDIA_STATE {
        int CAPTURE_IMAGE = 0;
        int GALLARY_IMAGE = 1;
        int GALLARY_VIDEO = 2;
        int CAPTURE_VIDEO = 3;
        int GALLARY_IMAGE_MULTIPLE = 4;
        int CAPTURE_IMAGE_PROFILE = 8;
        int GALLARY_IMAGE_PROFILE = 9;
    }

    public interface MEDIA_API {
        String IMAGE = "1";
        String VIDEO = "2";

    }

    public interface BroadcastReceiver {
        String UPDATE_PROFILE_PIC = "update_pic";
        String VALIDATE_POSR = "validate_post";
        String FEED_UPDATE = "feed_update";
    }

    public interface FriendRequestStatus {

        int REQUEST_SENT = 1;
        int PENDING = 2;
        int FRIEND = 3;
        int NOT_FRIEND = 4;
        int MY_SELF = 5;
    }

    public interface FriendListType {
        int REQUEST_SENT_LIST = 1;
        int PENDING_REQUEST_LIST = 2;
        int ALL_FRIENDS = 3;
    }

    public interface RequsetResponse {
        int ACCEPTED = 3;
        int REJECTED = 6;
    }


    public interface MediaType {
        int GROUP_MEDIA = 0;
        int PROFILE_MEDIA = 1;
    }

    /*
    from where the user performing block,hide, share,edit, delete,report post action
     */
    public interface MENU_NAVIGATION {
        int FEED_SCREEN = 0;
        int PROFILE_SCREEN = 1;
        int DETAIL_SCREEN = 2;
    }

    public interface FIREBASE_CONSTANT {

        String ROOT_NODE = "GROUPS";
        String ROOM_ID = "roomId";
        String MESSAGE = "message";
        String CHAT_ROOM = "chat_romm";
        String SHOW_CHAT_MEMBER = "show";
    }

    public interface CHAT_TYPE {

        int ONE_TO_ONE_CHAT = 0;
        int GROUP_CHAT = 1;

    }


    public interface NOTIFICATION_TYPE {
        int VENDOR_BOOKING_ACCEPTED = 1;
        int TRANSFER_BALANCE = 2;
        int BOOKING_REQUEST = 3;
        int VENDOR_BOOKING_EXTENSION_REQUEST = 4;
        int VENDOR_BOOKING_EXTENSION_ACCEPTANCE = 5;
        int BOOKING_ACTIVE_VENDOR = 6;
        int LIKE_POST = 7;
        int COMMENT_ADD = 8;
        int HOT_TOPICS = 9;
    }


    public interface CHAT_MSG_TYPE {
        String TXT_MSG = "text_msg";
        String DELETE_USER = "removed_user";
        String LEAVE_CHAT = "left_room";
        String LEAVE_OWNER = "owner_left_room";
        String ADD_USER = "added_user";
    }


    public interface CHAT_MEMBER_SCREEN_TYPE {
        int CREATE_NEW_CHAT_ROOM = 1;
        int ADD_CHAT_MEMEBR = 2;
        int DELETE_CHAT_USER = 3;
        int SHOW_CHAT_USER = 4;
    }

    public interface SETTING_KEY {
        String ABOUT_US = "About Us";
        String CANCELLATION_POLICY = "Cancellation Policy";
        String REFUND_POLICY = "Refund Policy";
        String TERM_CONDITION = "Terms & Conditions";


    }

    public interface PERMISSION_CODES {
        int CAMERA = 100;
        int STORAGE = 101;
    }

    public interface REQUEST_CODES {
        int FROM_GALLERY = 100;
        int FROM_CAMERA = 200;
    }

    public interface USER_PROFILE {
        String IMAGE = "img";
        String F_NAME = "f_name";
        String L_NAME = "l_name";
        String P_No = "p_no";
        String ADDRESS = "address";
        String LANGUAGE = "language";
        String ABOUT = "about";
        String EMAIL = "email";
        String ID = "id";
    }
}

