# THETA Plug-in Web UI Browser

A simple web browser that can access the web UI of THETA plug-in even on Android 9. ([日本語版はこちら](README.ja.md))

On Android 9, if cellular network is enabled, the browser can not connect to the THETA plug-in's web UI.

It is available on Google Play.

<a href='https://play.google.com/store/apps/details?id=be.shiro.theta.webui'><img alt='Get it on Google Play' src='https://play.google.com/intl/ja/badges/images/generic/en_badge_web_generic.png' width='180px'/></a>

## Usage

Connect with THETA and start up the plug-in and start up this application.

You can reload by swiping down the screen.

The following screen example displays the Web UI of [Meow Shot!](https://pluginstore.theta360.com/plugins/be.shiro.meowshot/).

![Screenshot](image/screenshot.png)

## Known Issues

* It can not connect if THETA is in Wi-Fi client mode.

## Technical Information

I referred to this article. Thanks Kei Nakazawa-san.

[THETA用の非公式写真転送・シャッターアプリを作ってる | muo notes](https://notes.muo.jp/1810_theta-app.html)

There are only two things I do

* Call [bindProcessToNetwork](https://developer.android.com/reference/android/net/ConnectivityManager.html#bindProcessToNetwork(android.net.Network)) to bind process to Wi-Fi network.
* Allow Cleartext Traffic. See [Android Developers Blog: Protecting users with TLS by default in Android P](https://android-developers.googleblog.com/2018/04/protecting-users-with-tls-by-default-in.html).
