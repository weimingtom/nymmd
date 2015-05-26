NyMmdは、[ARTK\_MMD](http://ppyy.if.land.to/artk_mmd.html)を元にした、MikuMikuDanceのVMD/PMDファイル再生クラスライブラリです。

PMDモデルファイルの読み込みと、VMDモーションの再生ができます。


<img src='http://img.f.hatena.ne.jp/images/fotolife/n/nyatla/20090624/20090624223537.png' width='50%' />

## ARTK\_MMDとの差分 ##

  * ARToolKit由来のコードを削除してあります。
  * 行列計算を高速化してあります。
  * 物理演算には対応していません。


## バージョン毎の違い ##
1.0.xは再生系のAPIの時間管理に不良があります。2.0.xは再生系APIの不具合が修正され、計算速度が大きく向上しています。

C#版の2.0系は希望があれば実装しますので、お知らせください。


## ライセンス ##

ライセンスはMITライセンスです。
ARTK\_MMDからARToolKit依存部を除外し、ARTK\_MMDのオリジナルコード部分については、ARTK\_MMDの開発者様から許可を頂いています。

Java版は2.0.1、C#版は1.1.1からMITライセンスで配布しています。以前のバージョンについては、ARToolKitとの分離が完全では無い可能性がありますので、各自してください。（多分大丈夫と思いますが、保障できません。）