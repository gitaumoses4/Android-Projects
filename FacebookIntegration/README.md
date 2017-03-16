# Android Facebook Integration

Android allows your application to connect to facebook and share data or any
other kind of updates on facebook. This project is about integrating facebook
in your application.
There are two ways through which you can integrate facebok and share something
from your application. These are listed below.

1. Facebook SDK
2. Intent Share

## Integrating Facebook SDK
This is the first way of connecting with facebook. You have to register your
application and then receive some Application Id, and ehn you have to download
the facebook SDK and add it to your project. These steps are listed below:

### GENERATING APPLICATION SIGNATURE

You have to generate a key signature, but before you generate it, make sure you
have SSL installed, otherwise you have to download SSL. It can be downloaded
[here](https://code.google.com/p/openssl-for-windows/downloads/detail?name=openssl-0.9.8k_WIN32.zip&can=2&q=)

Now open command prompt and redirect your java jre folder. Once you reach
there, type this command exactly. You have to replace the path in the inverted
commas with your keystore path which you can find in eclipse by selecting the
window tab and selecting the preferences tab and then selecting the build
option under android from the left side.

```
keytool -exportcert -alias androiddebugkey -keystore "your path" | openssl shal
-binary | openssl base64
```

Once you enter it, you will be prompted for password. Give android as the
password and then copy the key that is given to you.

### REGISTERING YOUR APPLICATION

Now create a new facebook application at https://developers.facebook.com/apps
and fill all the information. It is shown below:

Now move to the native android app section and fill in your project and class
name and paste the hash that you copied in step 1.

If everyting works fine, you will receive and application Id with the secret.
Just copy the application ID and save it somewhere.

### DOWNLOADING SDK AND INTEGRATING IT
Download facebook sdk [here](https://github.com/facebook/facebook-android-sdk).
Import this into eclipse. Once imported, right click on your facebook project
and click on the properties. Click on android, click on add button and select
facebook sdk as the project. Click Ok.

### CREATING FACEBOOK LOGIN APPLICATION
Once everything is complete, you run the samples, that comes with SDK or create
your own application. In order to log in, you need to call `openActiveSession`
method and implements its callback. Its syntax is given below:

```java
//start Facebook login
Session.openActiveSession(this, true, new Session.StatusCallback(){
    
    // callback when session changes state
    public void call( Session session, SessionState state, Exception exception)
    {
        if(session.isOpened()){
        //make request to;2 the /me API
            Request.executeMeRequestAsync(session, new
            Request.GraphUserCallback()){
                // callback after Graph API response with user object
                @Override
                public void onCompleted(GraphUser user, Response response){
                if(user != null){
                    TextView welcome = (TextView) findViewById(R.id.welcome);
                    welcome.setText("Hello "+ user.getName() +"!");
                    }
                }
            });
        }
    }
```
## Intent Share

Intent share is used to share data between applications. In this strategy, we
will not handle the SDK stuff, but let the facebook application handles it. We
will simply call the facebook application and pass the data to share. This way,
we can share something on Facebook.

Android provides intent library to share data between activities and
applications. In order to use it as a share intent, we have to specify the type
of the share intent to ACTION_SEND. Its syntax is given below.

```java
Intent shareIntent = new Intent();
shareIntent.setAction(Intent.ACTION_SEND);
```

Next thing you need is  to define the type of data to pass, and then pass the
data. its syntax is given below:

```java
shareIntent.setType("text/plain");
shareIntent.putExtra(Intent.EXTRA_TEXT,"Hello from the other side");
startActivity(Intent.createChooser(shareIntent,"Share your thoughts"));
```

