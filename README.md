# Android-App-GoogleMaps
Google Maps en Android Studio (Tu ubicación).

# Google Maps
Para poder utilizar **Google Places API for Android** tienes que crear una API en el sitio web [Google Developers Console](https://console.developers.google.com/) 
una vez creada te generara una clave la cual utilizaras dentro de tu aplicacion en Android Studio.

# Google Play Services and Runtime Permissions
Como se ha mencionado anteriormente esta aplicación te mostrara tu ubicación actual utilizando el **GPS** de tu dispositivo movil y para ello se necesitan una serie de permisos los cuales ml**# Add Google Play Services to Your Project
Para poder visualizar Mapas dentro de nuestra aplicacion, tenemos que integrar la librería [Google Play Services](https://developers.google.com/android/guides/setup), dentro de nuestro proyecto el en archivo build.gradle. Para mas información te dejo la documentación Oficial [Setting Up Google Play Services](https://developers.google.com/android/guides/setup)

**build.gradle**

    dependencies {
        compile 'com.google.android.gms:play-services:8.1.0'
    }

Una vez integrada la librería en nuestro proyecto, solo falta sincronizar nuestra app para que reconozca cierta librería. Para ello tenemos que ir a **Tools->Android->Sync Project with Gradle Files** y listo! ya tenemos sincronizada nuestra librería para poder ser utilizada.
