package com.example.demo.Util;

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
     * @param parameterName パラメータ
     * @param compareStatement 比較文
     * @return
     */
    public static String optionalQuery(String parameterName, String compareStatement) {
        // (検索値 = NULL or 条件) の形式のクエリを追加
        StringBuilder query = new StringBuilder();
        return query.append(":").append(parameterName).append(" is null or ").append(compareStatement).append("").toString();
    }

    /**
     * NULLに対応した検索条件を作成します。
     * @param parameterName パラメータ
     * @param compareStatement 比較文
     * @return
     */
    public static String createQuery(String parameterName, String compareStatement) {
        // (検索値 = NULL or 条件) の形式のクエリを追加
        StringBuilder query = new StringBuilder();
        return query.append(" and (:").append(parameterName).append(" is null or ").append(compareStatement).append(")").toString();
    }
}