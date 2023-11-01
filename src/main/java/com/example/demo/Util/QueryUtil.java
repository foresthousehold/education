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
     * NULLに対応した検索条件を作成します。
     * 
     * @param parameterName    パラメータ
     * @param compareStatement 比較文
     * @return
     */
    public static String optionalQuery(String parameterName, String compareStatement, Object value) {
        // (検索値 = NULL or 条件) の形式のクエリを追加
        StringBuilder query = new StringBuilder();
        Optional.ofNullable(value).ifPresentOrElse(
                (v) -> query.append(" (").append(compareStatement).append(")"),
                () -> query.append("(:").append(parameterName).append(" is null)"));
        return query.toString();
    }

    /**
     * NULLに対応した検索条件を作成します。
     * 
     * @param parameterName    パラメータ
     * @param compareStatement 比較文
     * @return
     */
    public static String createQuery(String parameterName, String compareStatement, Object value) {
        // (検索値 = NULL or 条件) の形式のクエリを追加
        StringBuilder query = new StringBuilder();
        Optional.ofNullable(value).ifPresentOrElse(
                (v) -> query.append(" and").append(" (").append(compareStatement).append(")"),
                () -> query.append(" and").append("(:").append(parameterName).append(" is null)"));
        return query.toString();
    }
}