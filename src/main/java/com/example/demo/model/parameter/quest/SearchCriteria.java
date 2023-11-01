package com.example.demo.model.parameter.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * クエスト検索条件クラス
 */
public class SearchCriteria {

    /** 料理ID 検索キー */
    // 名前付きパラメータに該当する
    public static final String DISH_ID_KEY = "dishId";

    /** 分類ID1 検索キー */
    public static final String CATEGORY_ID_1_KEY = "categoryId1";

    /** 分類ID2 検索キー */
    public static final String CATEGORY_ID_2_KEY = "categoryId2";

    /** 料理Id */
    // 検索条件から受けとったIDに該当する
    private Long dishId;

    /** 分類ID1 */
    private Long categoryId1;

    /** 分類ID2 */
    private Long categoryId2;

    /** bindParamsを作成します. */
    public Map<String, Object> createBindParams() {
        final Map<String, Object> bindParams = new HashMap<String, Object>();
        bindParams.put(DISH_ID_KEY, getDishId());
        bindParams.put(CATEGORY_ID_1_KEY, getCategoryId1());
        // bindParams.put(CATEGORY_ID_2_KEY, getCategoryId2());
        return bindParams;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }   

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }
}
