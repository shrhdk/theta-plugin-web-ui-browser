# THETA Plug-in Web UI Browser

Android 9 でも THETA プラグインの Web UI にアクセスできる超簡易ブラウザ ([English version is here](https://github.com/shrhdk/theta-plugin-web-ui-browser))

Android 9 では、セルラー回線が有効になっているとブラウザが THETA プラグインの Web UI に接続できなくて面倒くさいので作りました。

Google Play で配布中です。

<a href='https://play.google.com/store/apps/details?id=be.shiro.theta.webui'><img alt='Google Play で手に入れよう' src='https://play.google.com/intl/ja/badges/images/generic/ja_badge_web_generic.png' width='180px'/></a>

## 使い方

THETA と接続して、プラグインを起動して、本アプリを起動してください。

読み込みに失敗した場合は画面を下方向に引っ張ってリロードできます。

下の画面は [Meow Shot!](https://pluginstore.theta360.com/plugins/be.shiro.meowshot/) の Web UI を表示している例です。

![スクリーンショット](image/screenshot.png)

## 制限事項

* THETA がクライアントモードの場合は接続できません。 (THETAのIPアドレスを解決できないため)

## 技術的な話

こちらの記事を参考にしました。Kei Nakazawa さん、ありがとうございます。

[THETA用の非公式写真転送・シャッターアプリを作ってる | muo notes](https://notes.muo.jp/1810_theta-app.html)

やっていることは2つだけ

* [bindProcessToNetwork](https://developer.android.com/reference/android/net/ConnectivityManager.html#bindProcessToNetwork(android.net.Network)) で Wi-Fi ネットワークにバインドする。
* Cleartext Traffiic を許可、詳細は [Google Developers Japan: Android P で TLS のデフォルト化によるユーザー保護](https://developers-jp.googleblog.com/2018/05/protecting-users-with-tls-by-default-in.html)
