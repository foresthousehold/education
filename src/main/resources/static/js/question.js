//テキストのカウントアップ+バーの設定
$(() => {
  const bar = new ProgressBar.Line(container, {//id名を指定
    easing: 'easeInOut',//アニメーション効果linear、easeIn、easeOut、easeInOutが指定可能
    duration: 1000,//時間指定(1000＝1秒)
    strokeWidth: 4,//進捗ゲージの太さ
    color: '#555',//進捗ゲージのカラー
    trailWidth: 1,//ゲージベースの線の太さ
    svgStyle: { width: '100%', height: '100%' },
    trailColor: '#bbb',//ゲージベースの線のカラー
    text: {//テキストの形状を直接指定       
      style: {//天地中央に配置
        position: 'absolute',
        left: '50%',
        top: '50%',
        padding: '0',
        margin: '-32px 0 0 0',//バーより上に配置
        transform: 'translate(-50%,-50%)',
        'font-size': '2rem',
        color: '#000',
      },
      autoStyleContainer: false //自動付与のスタイルを切る
    },
    step: (_, bar) => {
      //   // const step = Number($('#step').val()); // 1レベルに必要な経験値
      //   // const barnum = bar.value(); // 現在の進捗バーの値に基づいて経験値を計算(※bar.valueは相対値を返す -> 0~1)
      //   // // バーのテキストに表示させるための値: 獲得した経験値 + バーの最大値
      //   // const exp = Number($('#addexp').attr('data-added')) + barnum;
      //   // const totalExperience = Number($('#totalExperience').val()); // ユーザが持つ経験値を取得(初回画面表示時)
      //   // bar.setText(exp + totalExperience + 'exp'); //テキストの数値
      const updateTotalExperience = Number($('#updateTotalExperience').val()); // ユーザが持つ経験値を取得(初回画面表示時)

      bar.setText(updateTotalExperience + 'exp'); //テキストの数値
    }
  });

  /**
   * プログレスバーの進捗率を取得します。(初期表示用)
   * @param {} totalExperience 利用者が持つ合計経験値
   * @param {*} step レベルアップに必要な経験値
   */
  function getProgressRate(totalExperience, gainExperience, step) {
    // ((ユーザの総合経験値+獲得経験値) % 1レベルに必要な経験値)* 100=> 進捗率
    const progressRate = (totalExperience % step) / 100;

    return progressRate;
  }

  /**
    * 解答終了ボタン押下時にプログレスバーのイベントを発火します。
    */
  $('#end-answer').on('click', async () => {

    const step = Number($('#step').val());　// 1レベルに必要な経験値
    let totalExperience = Number($('#totalExperience').val()); // ユーザが持つ経験値を取得(初回画面表示時)
    let gainExperience = Number($('#addexp').val()); // 獲得経験値を取得
    const userLevelElement = $("#level");
    let userLevel = parseInt(userLevelElement.val());

    // gainExperience: 獲得経験値、 step: 1レベルに必要な経験値
    async function progress1(gainExperience, step, currentProgressValue) {
      // 100 - 現在の進捗数 => 進めた進捗数
      // 獲得経験値 - 進めた進捗数 => 残獲得経験値
      // return 残獲得経験値
      let progressValue = step - currentProgressValue;
      let restGainExperience = gainExperience - progressValue;
      return await new Promise((resolve) => {
        bar.animate(1, () => resolve(restGainExperience));
      });
      // return restProgressValue;
    }

    // gainExperience: 獲得経験値、 step: 1レベルに必要な経験値
    async function progress2() {
      return await new Promise(() => {
        bar.animate(1, () => resolve(0));
      });
      // return 0;
    }

    // gainExperience: 獲得経験値、 step: 1レベルに必要な経験値
    async function progress3(test1) {
      await new Promise((resolve) => {
        bar.animate(test1 / 100, () => resolve()); //バーを描画する割合を指定します
      });
    }

    // gainExperience: 獲得経験値
    async function progress4(test) {
      await new Promise((resolve) => {
        bar.animate(test / 100, () => resolve()); //バーを描画する割合を指定します
      });
    }

    // モーダル画面表示時の進捗率を取得
    const progressRate = getProgressRate(totalExperience, gainExperience, step);

    // 進捗率 * 1レベルに必要な経験で現在の進捗数を取得(②)
    let currentProgressValue = progressRate * 100;

    let flg = false;

    // 獲得経験値が0になるまで繰り返す
    //  (② + 獲得経験値) / 1レベルに必要な経験値 で 1以上か確かめる
    //   もし　1以上なら(バーの末端に達するかつ獲得経験値がまだ残っている) -> プログレスバーを0にして、ユーザのレベルup, 獲得経験値 - (1レベルに必要な経験値 - ②), 進捗率を保存, 繰り返す
    //   もし  0 なら(バーのちょうど末端に達する)　-> プログレスバーを0にして ユーザのレベルup, 進捗率を保存
    //   それ以外なら(バーの末端に達しない) -> 進捗率を保存のみ

    while (gainExperience > 0) {

      // 現状の進捗具合と獲得経験値の総和が、バーの末端(100)に達しているか確認するための変数
      let confirmValue = (currentProgressValue + gainExperience) / step;

      if (confirmValue >= 1) {
        // バーを進めて残りを受け取る
        gainExperience = await progress1(gainExperience, step, currentProgressValue);
        // バーが端っこまで到達した
        $('#levelup').addClass('fadein-out');
        $('#levelup').removeClass('not-display');
        setTimeout(() => {
          $('#levelup').removeClass('fadein-out');
        }, 1000);

        // 進めた分を保存しておく
        $('#addexp').attr('data-added', Number($('#addexp').attr('data-added')) + step);

        // ユーザのレベルを+1する
        userLevelElement.text('Lv.' + ++userLevel);

        // バーを0に戻す
        bar.set(0);
        flg = true;
        currentProgressValue = 0;
      } else if (confirmValue == 0) {
        gainExperience = await progress2();
        // バーが端っこまで到達した
        $('#levelup').addClass('fadein-out');
        $('#levelup').removeClass('not-display');
        setTimeout(() => {
          $('#levelup').removeClass('fadein-out');
        }, 1000);

        // 進めた分を保存しておく
        $('#addexp').attr('data-added', Number($('#addexp').attr('data-added')) + step);

        // ユーザのレベルを+1する
        userLevelElement.text('Lv.' + ++userLevel);

        // バーを0に戻す
        bar.set(0);
        flg = true;
      } else {
        if (flg == false) {
          await progress3(gainExperience + currentProgressValue);
        } else {
          await progress4(gainExperience);
        }
        // 進めた分を保存しておく
        $('#addexp').attr('data-added', Number($('#addexp').attr('data-added')) + gainExperience);
        return;
      }
    }
  });
});

$(() => {
  $(".explain-japanese").show();
  $(".explain-english").hide();
  $("#toggleButton").on("click", (() => {
    $('#app').toggleClass('show');
    //#appがshowのclassを持っていれば
    if ($('#app').hasClass('show')) {
      //要素の表示を切り替える
      $('.explain-japanese').hide();
      $('.explain-english').show();
      // 日本語 -> 英語
      $('#toggleButton').text("ENGLISH -> JAPANESE");
    } else {
      //要素の表示を切り替える
      $('.explain-japanese').show();
      $('.explain-english').hide();
      // 英語 -> 日本語
      $('#toggleButton').text("日本語 -> 英語");
    }
  }
  ))
});