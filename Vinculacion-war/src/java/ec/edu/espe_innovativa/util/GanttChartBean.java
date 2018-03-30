/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.util;

import java.util.Date;

/**
 *
 * @author PC1
 */
public class GanttChartBean {

    private String series;
    private String task;
    private Date startDate;
    private Date endDate;

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSeries() {
        return series;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
