// script.js
$(document).ready(function () {
    // 曜日の定義
    const week = ["日", "月", "火", "水", "木", "金", "土"];

    // 今日の日付を取得
    const currentDate = new Date();

    // 表示用の日付を取得
    const displayDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);

    // 画面が表示されたらカレンダー表示
    showCalender(displayDate);

    function showCalender(date) {
        //年の取得
        year = date.getFullYear();

        //月の取得
        month = date.getMonth() + 1;

        // 表示用の日付を渡す
        document.querySelector('#year-month-label').innerHTML = year + '年' + month + '月';

        // カレンダーテーブルを作成する(HTMLが返却される)
        const calenderTable = createCalenderTable(year, month);

        // カレンダー表示部分に埋め込み
        document.querySelector('#calender-body').innerHTML = calenderTable;
    }

    /**
     * カレンダーテーブルの作成
     */
    function createCalenderTable(year, month) {
        // HTML用の変数
        var _html = '';

        // tableタグ
        _html += '<table class="table table-bordered calender-tbl">';

        // テーブルのヘッダー(曜日)
        _html += '<tr class="table-week">';
        for (var i = 0; i < week.length; i++) {
            _html += '<th>' + week[i] + '</th>';
        }
        _html += '</tr>';

        // ########################################

        // テーブルボディ部分の作成

        // 表示するカレンダーの年月の1日の曜日を取得
        var startDayOfWeek = new Date(year, month - 1, 1).getDay();

        // 日付変数
        let countDay = 0;

        // 月の末日
        var monthOfEndDay = new Date(year, month, 0).getDate();

        // 6行分繰り返し
        for (var i = 0; i < 6; i++) {
            _html += '<tr>';
            // 7列分繰り返し
            for (var j = 0; j < 7; j++) {
                // 1行目で開始曜日が同じ場合
                // 例)10/1が日曜かどうか
                if (i == 0 && j == startDayOfWeek) {
                    countDay++;
                    _html += '<td class="table-date">' + countDay + '</td>';
                } else if (countDay != 0 && countDay < monthOfEndDay) {
                    // 日付が一日以外かつ、その月の末日以外の場合
                    countDay++;
                    _html += '<td class="table-date">' + countDay + '</td>';
                } else {
                    // それ以外の場合
                    _html += '<td class="no-date">' + '</td>';
                }
            }
            _html += '</tr>';
        }
        _html += '</table>';
        return _html;
    }

    // 「<<」が押された時のアクション
    $('.back-year').on('click', () => {
        displayDate.setFullYear(displayDate.getFullYear() - 1);
        showCalender(displayDate);
    });

    // 「<」が押された時のアクション
    $('.back-month').on('click', () => {
        displayDate.setMonth(displayDate.getMonth() - 1);
        showCalender(displayDate);
    });

    // 「●」が押された時のアクション
    $('.current-date').on('click', () => {
        showCalender(currentDate);
    });

    // 「>>」が押された時のアクション
    $('.proceed-month').on('click', () => {
        displayDate.setMonth(displayDate.getMonth() + 1);
        showCalender(displayDate);
    });

    // 「>」が押された時のアクション
    $('.proceed-year').on('click', () => {
        displayDate.setFullYear(displayDate.getFullYear() + 1);
        showCalender(displayDate);
    });

});
