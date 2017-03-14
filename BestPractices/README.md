#Android Best Practices
There are some practices that you can follow while developing android
application. These are suggested by android itself and they keep on improving
with respect to time.

These best practices include interaction design features, performance, security
and privacy, compatibility, testing, distributing and monetizing tips. They are
narrowed down and listed as below.

#Best Practices - User Input
Every text field is entited for a different job. For example, some text fields
are for text and some are for numbers. If it is for numbers, then it is better
to display the numeric keypad when that textfield is focused. 

#Best Practices - Background Jobs
There are certain jobs in an application that are running in an application
background. Their job might be to fetch some thing from the internet, playing
music etc. It is recommeded that the long awaiting tasks should not be done in
the UI thread and rather in the background by services or AsyncTask.

#Best Practices - Performance
Your application performance should be upto the mark. But it should perform
differently not on the front end, but on the backend when the device is
connected to a power source or chargin. Charging could be from USB and from
wire cable.

When your device is charging itself, it is recommended to update you
application settings if any such as maximizing your refresh rate whenever the
device is connected.

#Best Practices - Security and Privacy
It is very important that your application should be secure and not only the
application, but the user data and the application data should also be secured.
They security can be increased by the following factos:
1. Use of internal storage rather than the external storage for storing
   application files.
2. Use content providers wherever possible.
3. Use SSI when connecting to the web.
4. Use appropriate permissions for accessing different functionalities of
   device.


