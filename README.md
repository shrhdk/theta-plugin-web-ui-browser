# THETA Plug-in Web UI Browser

Android 9 Pie でも THETA プラグインの Web UI にアクセスできる超簡易ブラウザ

Android 9 では、セルラー回線が有効になっているとブラウザが THETA プラグインの Web UI に接続できなくて面倒くさいので作った。

## 使い方

THETA と接続できていて、プラグインが起動している状態で、画面右下の REFRESH ボタンをタップしてください。下の画面は [Meow Shot!](https://pluginstore.theta360.com/plugins/be.shiro.meowshot/) の Web UI を表示している例です。

![スクリーンショット](screenshot.png)

## 制限事項

* THETA がクライアントモードの場合は接続できません。 (THETAのIPアドレスを解決できないため)
* 戻る/進むボタンはありません。

## 技術的な話

こちらの記事を参考にしました。 → [THETA用の非公式写真転送・シャッターアプリを作ってる | muo notes](https://notes.muo.jp/1810_theta-app.html)

やっていることは2つだけ

* bindProcessToNetwork で Wi-Fi ネットワークにバインドする。
* Cleartext Traffiic を許可 (HTTP を許可)
