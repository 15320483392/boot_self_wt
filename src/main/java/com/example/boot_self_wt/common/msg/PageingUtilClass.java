package com.example.boot_self_wt.common.msg;

import java.util.List;

/**
 * @author WTar
 * @date 2018/7/4 11:35
 */
public class PageingUtilClass<T>{
    private int draw; // 请求次数页数
    private long recordsTotal; // 数据量
    private long recordsFiltered;
    private List<T> data; // 分页数据

    public PageingUtilClass() {
    }

    public PageingUtilClass(int draw, long recordsTotal, long recordsFiltered, List<T> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder model = new StringBuilder("{");
        model.append("\"draw\":").append(draw);
        model.append(",\"recordsTotal\":").append(recordsTotal);
        model.append(",\"recordsFiltered\":").append(recordsFiltered);
        model.append(",\"data\":").append(data);
        model.append('}');
        return model.toString();
    }
}
