package com.study.excel.poi;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {


    private List<List<Object>> data = new ArrayList<>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        data.add((List<Object>) object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

    public List<List<Object>> getData() {
        return this.data;
    }
}
