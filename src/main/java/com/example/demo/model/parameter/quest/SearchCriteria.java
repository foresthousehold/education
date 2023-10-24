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
    
    /** 料理Id */
    // 検索条件から受けとったIDに該当する
    private long dishId;

    /** bindParamsを作成します. */
    public Map<String, Object> createBindParams() {
        final Map<String, Object> bindParams = new HashMap<String, Object>();
        bindParams.put(DISH_ID_KEY, getDishId());

        return bindParams;
    }

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }   
}
