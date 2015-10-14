# Android-App-GoogleMaps
Te recomiendo que visualices esta aplicacion en un dispositivo fisico y que tengas actualizado o instalado los servicios  de google play (**Google Play Services**) ya que son requeridos para visualizar mapas dentro de tu dispositivo android. 

# Screenshot
![](https://raw.githubusercontent.com/jorgefrac/Android-App-GoogleMaps/master/Screenshot/1.png)

# Google Maps
Para poder utilizar **Google Places API for Android** tienes que crear una API en el sitio web [Google Developers Console](https://console.developers.google.com/) 
una vez creada te generara una clave la cual utilizaras dentro de tu aplicacion en Android Studio.

# Google Play Services and Runtime Permissions
Como se ha mencionado anteriormente esta aplicación te mostrara tu ubicación actual utilizando el **GPS** de tu dispositivo movil y para ello se necesitan una serie de permisos los cuales son necesarios para poder visualizar mapas dentro de nuestra aplicacion. Para ello tenemos que integrar la librería [Google Play Services](https://developers.google.com/android/guides/setup), dentro de nuestro proyecto el en archivo build.gradle. Para mas información te dejo la documentación Oficial [Setting Up Google Play Services](https://developers.google.com/android/guides/setup)

**build.gradle**

    dependencies {
        compile 'com.google.android.gms:play-services:8.1.0'
    }

Una vez integrada la librería en nuestro proyecto, solo falta sincronizar nuestra app para que reconozca cierta librería. Para ello tenemos que ir a **Tools->Android->Sync Project with Gradle Files** y listo! ya tenemos sincronizada nuestra librería para poder ser utilizada.

#Project Configuration

Como se ha mencionado anteriormente esta aplicación te mostrara tu ubicación actual utilizando el **GPS** de nuestro dispositivo móvil y para ello se necesitan una serie de permisos los cuales tenemos que declarar dentro de nuestro archivo **AndroidManifest.xml** todo esto para poder visualizar nuestro mapa de Google Maps.

Permisos requeridos

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="com.example.jorge.androidappmaps.permission.MAPS_RECEIVE" />
    <uses-permission android:name="com.google.android.providers.gsf.permission.READ_GSERVICES" />

Una vez que ya asignamos nuestros permisos que necesitaremos para nuestra aplicación tenemos que configurar nuestro proyecto dentro del mismo archivo ya mencionado **AndroidManifest.xml** dentro de este archivo agregaremos las siguientes etiquetas **<meta-data>** las cuales son muy importantes ya que en en ellas se integrara la clave que nos genero nuestra API de Google Maps, para mas información te dejo la documentación oficial Google Maps Android API -> [Project Configuration](https://developers.google.com/maps/documentation/android-api/config).

        <meta-data
            android:name="com.google.android.maps.v2.API_KEY"
            android:value="@string/api_key" />

        <meta-data
            android:name="com.google.android.gms.version"
            android:value="@integer/google_play_services_version" />
