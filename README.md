# Friendly Eats

This is the source code that accompanies the Firestore Android Codelab:
https://codelabs.developers.google.com/codelabs/firestore-android

The purpose of this project is to demo the crash happening in Firebase Firestore SDK.

Snapshot of `app/build.gradle` file.

```
apply plugin: 'com.android.application'

android {

    //...other

    packagingOptions {
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/LICENSE-FIREBASE.txt'
        exclude 'META-INF/NOTICE'
    }

    configurations {
        implementation.exclude module: 'proto-google-common-protos'
        implementation.exclude module: 'protolite-well-known-types'
        implementation.exclude module: 'protobuf-lite'
    }
}

dependencies {
    //From Firebase FireEats Example
    implementation 'com.firebaseui:firebase-ui-auth:6.2.1'
    implementation 'androidx.vectordrawable:vectordrawable-animated:1.1.0'
    implementation 'androidx.browser:browser:1.0.0'
    implementation 'androidx.lifecycle:lifecycle-runtime:2.2.0'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    annotationProcessor 'androidx.lifecycle:lifecycle-compiler:2.2.0'
    implementation 'me.zhanghai.android.materialratingbar:library:1.4.0'
    implementation 'com.github.bumptech.glide:glide:4.11.0'


    //From My original project
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.google.android.material:material:1.3.0-alpha01'
    implementation 'com.android.support:multidex:1.0.3'
    implementation 'com.google.code.gson:gson:2.8.6'
    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'
    implementation 'de.hdodenhof:circleimageview:3.1.0' //Circular image view
    implementation 'com.astuetz:pagerslidingtabstrip:1.0.1' //Pager sliders
    implementation "android.helper:phonenumberedittext:1.0.4" //Phone numbers with country flags
    implementation 'com.synnapps:carouselview:0.1.5' //Image slider
    implementation 'com.poovam:pin-edittext-field:1.2.0' //input confirmation pin
    implementation 'com.stripe:stripe-android:10.2.1' //credit card form
    implementation 'devs.mulham.horizontalcalendar:horizontalcalendar:1.3.4' //horizontal calender
    implementation 'com.savvi.datepicker:rangepicker:1.3.0' // Date range picker
    implementation 'com.facebook.shimmer:shimmer:0.5.0' // Shimmer library
    implementation 'com.journeyapps:zxing-android-embedded:3.5.0'
    implementation 'com.google.zxing:core:3.3.3'
    implementation 'uk.co.chrisjenx:calligraphy:2.3.0'
    implementation 'com.squareup.picasso:picasso:2.71828'
    implementation 'org.apache.commons:commons-io:1.3.2'
    implementation 'com.google.firebase:firebase-config:19.2.0'
    implementation 'com.android.volley:volley:1.1.1' //network
    implementation "androidx.security:security-crypto:1.1.0-alpha01"
    implementation 'com.google.firebase:firebase-auth:19.3.2'
    implementation 'com.firebaseui:firebase-ui-database:6.2.1'
    implementation 'com.google.firebase:firebase-firestore:21.5.0'
    implementation 'com.google.android.gms:play-services-auth:18.1.0'
    implementation 'com.google.android.gms:play-services-maps:15.0.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}

apply plugin: 'com.google.gms.google-services'
```

Crash Log:
```
2020-08-03 11:29:26.611 7907-7907/com.google.firebase.example.fireeats E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.google.firebase.example.fireeats, PID: 7907
    java.lang.NoClassDefFoundError: Failed resolution of: Lcom/google/type/LatLng;
        at com.google.firestore.v1.Value.dynamicMethod(Value.java:1626)
        at com.google.protobuf.GeneratedMessageLite.dynamicMethod(GeneratedMessageLite.java:252)
        at com.google.protobuf.GeneratedMessageLite.buildMessageInfo(GeneratedMessageLite.java:280)
        at com.google.protobuf.GeneratedMessageInfoFactory.messageInfoFor(GeneratedMessageInfoFactory.java:60)
        at com.google.protobuf.ManifestSchemaFactory$CompositeMessageInfoFactory.messageInfoFor(ManifestSchemaFactory.java:143)
        at com.google.protobuf.ManifestSchemaFactory.createSchema(ManifestSchemaFactory.java:55)
        at com.google.protobuf.Protobuf.schemaFor(Protobuf.java:93)
        at com.google.protobuf.Protobuf.schemaFor(Protobuf.java:107)
        at com.google.protobuf.GeneratedMessageLite.makeImmutable(GeneratedMessageLite.java:171)
        at com.google.protobuf.GeneratedMessageLite$Builder.buildPartial(GeneratedMessageLite.java:391)
        at com.google.protobuf.GeneratedMessageLite$Builder.build(GeneratedMessageLite.java:399)
        at com.google.firebase.firestore.UserDataReader.parseScalarValue(UserDataReader.java:403)
        at com.google.firebase.firestore.UserDataReader.parseData(UserDataReader.java:278)
        at com.google.firebase.firestore.UserDataReader.parseMap(UserDataReader.java:297)
        at com.google.firebase.firestore.UserDataReader.parseData(UserDataReader.java:251)
        at com.google.firebase.firestore.UserDataReader.convertAndParseDocumentData(UserDataReader.java:232)
        at com.google.firebase.firestore.UserDataReader.parseSetData(UserDataReader.java:75)
        at com.google.firebase.firestore.DocumentReference.set(DocumentReference.java:166)
        at com.google.firebase.firestore.DocumentReference.set(DocumentReference.java:146)
        at com.google.firebase.example.fireeats.MainActivity.createChatter(MainActivity.java:35)
        at com.google.firebase.example.fireeats.MainActivity.onCreate(MainActivity.java:25)
        at android.app.Activity.performCreate(Activity.java:7136)
        at android.app.Activity.performCreate(Activity.java:7127)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2893)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3048)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1808)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:193)
        at android.app.ActivityThread.main(ActivityThread.java:6669)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:858)
     Caused by: java.lang.ClassNotFoundException: Didn't find class "com.google.type.LatLng" on path: DexPathList[[zip file "/data/app/com.google.firebase.example.fireeats-4tY_mtB6s-PkYsB35kC23w==/base.apk"],nativeLibraryDirectories=[/data/app/com.google.firebase.example.fireeats-4tY_mtB6s-PkYsB35kC23w==/lib/x86, /system/lib]]
        at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:134)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
        at com.google.firestore.v1.Value.dynamicMethod(Value.java:1626) 
        at com.google.protobuf.GeneratedMessageLite.dynamicMethod(GeneratedMessageLite.java:252) 
        at com.google.protobuf.GeneratedMessageLite.buildMessageInfo(GeneratedMessageLite.java:280) 
        at com.google.protobuf.GeneratedMessageInfoFactory.messageInfoFor(GeneratedMessageInfoFactory.java:60) 
        at com.google.protobuf.ManifestSchemaFactory$CompositeMessageInfoFactory.messageInfoFor(ManifestSchemaFactory.java:143) 
        at com.google.protobuf.ManifestSchemaFactory.createSchema(ManifestSchemaFactory.java:55) 
        at com.google.protobuf.Protobuf.schemaFor(Protobuf.java:93) 
        at com.google.protobuf.Protobuf.schemaFor(Protobuf.java:107) 
        at com.google.protobuf.GeneratedMessageLite.makeImmutable(GeneratedMessageLite.java:171) 
        at com.google.protobuf.GeneratedMessageLite$Builder.buildPartial(GeneratedMessageLite.java:391) 
        at com.google.protobuf.GeneratedMessageLite$Builder.build(GeneratedMessageLite.java:399) 
        at com.google.firebase.firestore.UserDataReader.parseScalarValue(UserDataReader.java:403) 
        at com.google.firebase.firestore.UserDataReader.parseData(UserDataReader.java:278) 
        at com.google.firebase.firestore.UserDataReader.parseMap(UserDataReader.java:297) 
        at com.google.firebase.firestore.UserDataReader.parseData(UserDataReader.java:251) 
        at com.google.firebase.firestore.UserDataReader.convertAndParseDocumentData(UserDataReader.java:232) 
        at com.google.firebase.firestore.UserDataReader.parseSetData(UserDataReader.java:75) 
        at com.google.firebase.firestore.DocumentReference.set(DocumentReference.java:166) 
        at com.google.firebase.firestore.DocumentReference.set(DocumentReference.java:146) 
        at com.google.firebase.example.fireeats.MainActivity.createChatter(MainActivity.java:35) 
        at com.google.firebase.example.fireeats.MainActivity.onCreate(MainActivity.java:25) 
        at android.app.Activity.performCreate(Activity.java:7136) 
        at android.app.Activity.performCreate(Activity.java:7127) 
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271) 
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2893) 
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3048) 
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78) 
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108) 
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68) 
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1808) 
        at android.os.Handler.dispatchMessage(Handler.java:106) 
        at android.os.Looper.loop(Looper.java:193) 
        at android.app.ActivityThread.main(ActivityThread.java:6669) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:858) 
2020-08-03 11:29:26.620 1647-1647/? E/lowmemorykiller: Error writing /proc/7907/oom_score_adj; errno=22
2020-08-03 11:29:34.470 4144-4157/? E/memtrack: Couldn't load memtrack module
```

## Github issue Link:

https://github.com/firebase/firebase-android-sdk/issues/1780

