# Android Google Maps

Android allows us to integrate google maps in our application. You can show any
location on the map, or you can show different routes on the map e.t.c. You can
also customize the map according to your choices.

### Adding Google Map

Google provides this facility using google play services library which you have
to download externally. After downloading, you have to integrate it with your
project. In the end you will have to integrate your application with google via
google console.

#### GOOGLE MAP - ACTIVITY FILE

Google provides GoogleMap and MapFragment api to integrate map in your
applicatoin. In order to use GoogleMap, you have to create an object of
GoogleMap and get the reference of map from the xml layout file. Its syntax is
given below:

```java
GoogleMap googleMap;
googleMap = (MapFragment)
getFragmentManager().findFragmentById(R.id.map).getMap();
```

#### GOOGLE MAP - LAYOUT FILE

Now you have to add the map fragment into xml layout file. Its syntax is given
below:

```xml
<fragment
    android:id = "@+id/map"
    android:name = "com.google.android.gms.maps.MapFragment"
    android:layout_width = "match_parent"
    android:layout_height = "match_parent"/>
```

#### GOOGLE MAP - ANDROID MANIFEST FILE
The next thing you need to do is to add some permissions along with the Gogle
Map API key in the AndroidManifest.xml file. Its syntax is given below:

```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.INTERNET"/>

<uses-permission
android:name="com.google.android.providers.gsf.permission.READ_GSERVICES" />
<uses-permission android:name="com.permission.WRITE_EXTERNAL_STORAGE"/>

<!--Google MAP API Key-->
<meta-data
    android:name="com.google.android.maps.v2.API_KEY"
    android:value="AIzaSyDKymeBXNeiFWY5jRUejv6zItpmr2MVyQ0"/>
```

### Customizing Google Map

You can easily customize google map from its default view and change it
according to your demand.

#### ADDING MARKER
You can place a marker with some text over it displaying your location on the
map. It can be done by `addMarker()` method. Its syntax is given below.

```java
final LatLng location = new LatLng(21,57);
Marker marker = googleMap.addMarker(new
MarkerOptions().position(location).title("My Location"));
```

### CHANGING MAP TYPE

You can also change the type of the map. There are four different types of map
and each give different view of the map. These types are:
* Normal
* Hybrid
* Satellite
* Terrain

You can name them as below:

```java
googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
```

### ENABLE / DISABLE ZOOM

You can also enable or disable the zoom gestures in the map by calling the
`setZoomControlEnabled(boolean)` method. Its syntax is given below:

```java
googleMap.getUiSettings().setZoomGesturesEnabled(true);
```
### DETAILS
**Key Store password**  - password
**Key Store alias**     - GoogleMaps
**Alias password**      - password
