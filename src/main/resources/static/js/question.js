//テキストのカウントアップ+バーの設定
$(() => {
  const bar = new ProgressBar.Line(container, {//id名を指定
    easing: 'easeInOut',//アニメーション効果linear、easeIn、easeOut、easeInOutが指定可能
    duration: 2000,//時間指定(1000＝1秒)
    strokeWidth: 4,//進捗ゲージの太さ
    color: '#555',//進捗ゲージのカラー
    trailWidth: 1,//ゲージベースの線の太さ
    svgStyle: {width: '100%', height: '100%'},
    trailColor: '#bbb',//ゲージベースの線のカラー
    text: {//テキストの形状を直接指定       
      style: {//天地中央に配置
        position: 'absolute',
        left: '50%',
        top: '50%',
        padding: '0',
        margin: '-40px 0 0 0',//バーより上に配置
        transform:'translate(-50%,-50%)',
        'font-size':'1rem',
        color: '#000',
      },
      autoStyleContainer: false //自動付与のスタイルを切る
    },
    step: (_, bar) => {
      const step = Number($('#step').val()); // 1レベルに必要な経験値
      const barnum = Math.round(bar.value()*step); // 現在の進捗バーの値に基づいて経験値を計算(※bar.valueは相対値を返す -> 0~1)
      const exp = Number($('#addexp').attr('data-added')) + barnum; 
      bar.setText(exp + 'exp'); //テキストの数値
    }
});

/**
  * 解答終了ボタン押下時にプログレスバーのイベントを発火します。
  */
$('#end-answer').on('click', async() => {

  async function progress(value, step) {
    if ((value / step) >= 1) {
      await new Promise((resolve) => {
        bar.animate(1, () => resolve());
      });
      return value - step; // 獲得経験値 - レベルアップに必要な経験値
    }
    console.log(`value % step: ${value % step}`);
    await new Promise((resolve) => {
      bar.animate((value % step) / step, () => resolve()); //バーを描画する割合を指定します 1.0 なら100%まで描画します
    });
    return 0;
  }

  const step = Number($('#step').val());
  let remind = Number($('#addexp').val());
  while(remind > 0) {

    // バーを進めて残りを受け取る
    remind = await progress(remind, step);

    // 進めた分を保存しておく
    $('#addexp').attr('data-added', Number($('#addexp').attr('data-added')) + step);
  
    if (remind > 0) {
      // バーが端っこまで到達した
      $('#levelup').addClass('fadein-out');
      setTimeout(() => {
        $('#levelup').removeClass('fadein-out');
      }, 1000);

      // バーを0に戻す
      bar.set(0);
    } else {
      // 経験値反映終わり
      return ;
    }
  }
});

});