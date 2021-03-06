package entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
    //总记录数量
    private long total;
    //当前页面结果集
    private List rows;

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
