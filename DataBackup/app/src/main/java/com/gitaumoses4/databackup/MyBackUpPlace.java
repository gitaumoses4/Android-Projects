package com.gitaumoses4.databackup;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;

/**
 * Created by root on 3/15/17.
 */

public class MyBackUpPlace extends BackupAgentHelper {

    static final String fileNameOfPreferences = "myPreferences";
    static final String PREFS_BACKUP_KEY = "backup";

    public void onCreate() {
        SharedPreferencesBackupHelper sharedPreferencesBackupHelper = new
                SharedPreferencesBackupHelper(this, fileNameOfPreferences);
        addHelper(PREFS_BACKUP_KEY, sharedPreferencesBackupHelper);
    }
}
