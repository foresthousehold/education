package com.example.demo.Util;

import java.util.Optional;

/*
 * SQL関連Utilクラス
 */
public final class QueryUtil {

    /**
     * コンストラクタ
     */
    public QueryUtil() {
    }

    /**
     * nullに対応したクエリを返します。
     * @param value 値
     * @param paramName パラメータ名
     * @return クエリ
     */
    public static String nullSafeQuery(long value, String paramName) {
        StringBuilder str = new StringBuilder();

        Optional.ofNullable(value).ifPresentOrElse(
            (v) -> str.append(":").append(paramName).append(""),
            () -> str.append(" (:").append(paramName).append(" is null)"));
        return str.toString();
    }
    
}
