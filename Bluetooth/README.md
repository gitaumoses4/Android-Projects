#Android Bluetooth

Among many ways, Bluetooth is a way to send or receive data between two
different devices. Android platform includes support for the Bluetooth
framework that allows a device to wirelessly exchange data with other bluetooth
devices.

Android provides Bluetooth API to perform these different operations:
* Scan for other Bluetooth devices
* Get a list of paired devices
* Connect to other devices through service discovery.

Android provides BluetoothAdapter class to communicate with Bluetooth. Create
an object of this calling by calling the static method `getDefaultAdapter()`.
Its syntax is given below.

```java
private BluetoothAdapter ba;
ba = BluetoothAdapter.getDefaultAdapter();
```

In order to enable the Bluetooth of you device, call the intent with the
following Bluetooth constant. `ACTION_REQUEST_ENABLE`. Its syntax is:

```java
Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
startActivityForResult(turnOn,0);
```
