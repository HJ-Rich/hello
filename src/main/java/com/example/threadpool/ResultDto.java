package com.example.threadpool;

import java.util.HashMap;
import java.util.Map;

public class ResultDto {
    private Map<String, Object> data;

    public ResultDto() {
        this.data = new HashMap<>();
    }

    public void addResult(final String key, final Object value) {
        data.put(key, value);
    }

    public Map<String, Object> getData() {
        return data;
    }
}
