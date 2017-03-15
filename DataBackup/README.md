# Android Data Backup

Android allows you to backup your application to remote "cloud" storage in
order to provide a restore point for the application data and settings. You can
only backup your application data. In order to access teh other applications
data, you need to root your phone. 

In order to make a data backup application, you need to register your
application with [google backup
service][https://developer.android.com/google/backup/signup.html].

After registering you have to specify this key in the AndroidManifest XML.

```xml
<application
    android:allowBackup="true"
    android:backupAgent="MyBackupPlace">
    
    <meta-data
        android:name="com.google.android.backup.api_key"
        android:value="AEdPqrEAAAAIErlxFByGgNz2ywBeQb6TsmLpp5Ksh1PW-ZSexg"/>
</application>
```

Android provides **BackupAgentHelper** class to handle all the operations of
data backup. In order to use this class, you have to extends your class with
it. Its syntax is given below.

```java
public class MyBackupPlace" extends BackupAgentHelper{
    
}
```

The persistent data you want to backup is in either of the two forms. Either it
could be SharedPreferences or it could be File. Android supports both types of
backup in the respective classes of **SharedPreferencesBackupHelper** and
**FileBackupHelper**.

In order to use **SharedPreferenceBackupHelper**, you need to instantiate its
object with the name of your sharedPreferences file. Its syntax is given below.

```java
static final String fileNameOfPreferences = "myPreferences";

SharedPreferencesBackupHelper sharedPreferencesBackupHelper = new
SharedPreferencesBackupHelper(this, fileNameOfPreferences);
```

The last thing you need to do is to call addHelper method by specifying the
backup key string and the helper object. Its syntax is given below.

```java
addHelper(PREFS_BACKUP_KEY, helper);
```
# Test your BackupAgent

Once you have implemented your backup agent, you can test the backup and
restore functionality with the following procedure using `bmgr`.

### INSTALL YOUR APPLICATION ON A SUITABLE ANDROID SYSTEM IMAGE
If using the emulator, create and use an AVD with Android 2.2 (API level 8)
If using a device, the device must be running Android 2.2. or greater and have
Google Play built in.

#### ENSURE DATA BACKUP IS ENABLED
If using the emulator you can enable backup with the following command from
your SDK tools/ path.

```
adb shell bmgr enable true 
```

If using a device, open the system Settings, select Privacy, then enable Backup
of my data and Automatic restore.

#### PERFORMING BACKUP
For testing purposes, you can also make a request with the following bmgr
command.
```
adb shell bmgr backup your.package.name
```

Initialize a backup operation by typing the following command.

```
adb shell bmgr run
```

This forces the Backup Manager to perform all backup requests that are in its
queue.

#### UNINSTALL AND REINSTALL YOUR APPLICATION

Uninstall the application with the following command

```
adb uninstall your.package.name
```

Then reinstall application and verify the results.
