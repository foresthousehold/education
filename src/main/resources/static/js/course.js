// script.js
$(document).ready(function () {
    var calendarContainer = $("#calendar-container");

    // 現在の年と月を取得
    var currentDate = new Date();
    var currentYear = currentDate.getFullYear();
    var currentMonth = currentDate.getMonth();

    // ログイン日付（仮の日付として設定）
    var loginYear = currentYear;
    var loginMonth = currentMonth;
    var loginDay = 15; // 例として15日をログイン日とします

    // カレンダーを生成する関数
    function generateCalendar(year, month) {
        var daysInMonth = new Date(year, month + 1, 0).getDate();
        var firstDayOfMonth = new Date(year, month, 1).getDay();

        var calendar = $("<div id='calendar'></div>");

        // カレンダーの日付を生成
        for (var i = 0; i < daysInMonth + firstDayOfMonth; i++) {
            var day = $("<div class='calendar-day'></div>");

            if (i >= firstDayOfMonth) {
                var dayNumber = i - firstDayOfMonth + 1;
                day.text(dayNumber);

                if (year === currentYear && month === currentMonth && dayNumber === loginDay) {
                    day.addClass("login-day");
                } else if (year === loginYear && month === loginMonth && dayNumber === loginDay) {
                    day.addClass("login-day");
                }

                if (year === currentYear && month === currentMonth) {
                    day.addClass("current-month");
                }
            } else {
                day.addClass("empty-day");
            }

            calendar.append(day);
        }

        return calendar;
    }

    // 現在の年と月に基づいてカレンダーを生成
    calendarContainer.append(generateCalendar(currentYear, currentMonth));
});
