package org.itrunner.openfeign.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Traffic {
    private int count;
    private int uniques;
    private List<View> views = new ArrayList<>();

    @Data
    public static class View {
        private String timestamp;
        private int count;
        private int uniques;
    }
}
