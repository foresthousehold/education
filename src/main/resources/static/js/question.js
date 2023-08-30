//テキストのカウントアップ+バーの設定
$(() => {
  const bar = new ProgressBar.Line(container, {//id名を指定
    easing: 'easeInOut',//アニメーション効果linear、easeIn、easeOut、easeInOutが指定可能
    duration: 1000,//時間指定(1000＝1秒)
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
        margin: '-32px 0 0 0',//バーより上に配置
        transform:'translate(-50%,-50%)',
        'font-size':'2rem',
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
 * 初回表示時に利用者が持つ経験値をプログレスバーに反映させます。
 * @param {} totalExperience 利用者が持つ合計経験値
 * @param {*} step レベルアップに必要な経験値
 */
async function initialProgress(totalExperience, step) {
  if ((totalExperience / step) >= 1) {
    const displayExp = totalExperience % step; // 120 % 100 = 20, 20 % 100 = 20
      bar.set(displayExp / step);
  } else {
      bar.set(totalExperience / step);
    }
  }

/**
  * 解答終了ボタン押下時にプログレスバーのイベントを発火します。
  */
$('#end-answer').on('click', async() => {

  const step = Number($('#step').val());　// 1レベルに必要な経験値
  let remind = Number($('#addexp').val()); // 獲得経験値
  let totalExperience = Number($('#totalExperience').val()); // ユーザが持つ経験値を取得(初回画面表示時)
  let userExperience = Number($('#totalExperience').val()) + remind; // ユーザが持つ経験値を取得(初回画面表示時)
  const userLevelElement = $("#level");
  let userLevel = parseInt(userLevelElement.text().slice(3));

  initialProgress(totalExperience, step);

  async function progress(value, step, totalExperience) {
    if (((value + totalExperience) / step) >= 1) { 
      // 獲得経験値がレベルアップに必要な経験値より多かった場合
      test = totalExperience % step;
      rest = step - test;
      await new Promise((resolve) => {
        bar.animate(1, () => resolve());
      });
      return value - rest; // 獲得経験値 - レベルアップに必要な経験値 = 残経験値
    } 
    console.log(`value % step: ${totalExperience + value % step}`);
    await new Promise((resolve) => {
      bar.animate(((totalExperience + value) % step) / step, () => resolve()); //バーを描画する割合を指定します 1.0 なら100%まで描画します
    });
    return 0;
  }

  while(remind > 0) {

    // バーを進めて残りを受け取る
    remind = await progress(remind, step, totalExperience);

    // 初回経験値を0にする
    totalExperience = 0;
  
    if (remind > 0) {
      // バーが端っこまで到達した
      $('#levelup').addClass('fadein-out');
      $('#levelup').removeClass('not-display');
      setTimeout(() => {
        $('#levelup').removeClass('fadein-out');
      }, 1000);

      // 進めた分を保存しておく
      $('#addexp').attr('data-added', Number($('#addexp').attr('data-added')) + step);

      // バーを0に戻す
      bar.set(0);

      // ユーザのレベルを+1する
      userLevelElement.text('Lv.' + ++userLevel);

    } else {
      
      // 進めた分を保存しておく
      $('#addexp').attr('data-added', Number($('#addexp').attr('data-added')) + userExperience);
      
      // 経験値反映終わり
      return ;
    }
  }
});

});