/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PC1
 */
public class GanttChartBeanMaker {

    public ArrayList getGanttChartData() {
        ArrayList ganttChartDataList = new ArrayList();

        Calendar calendar = Calendar.getInstance();

        for (int i = 1; i < 8; i++) {
            calendar.set(Calendar.HOUR_OF_DAY, i * 1);

            Date startDate = calendar.getTime();

            calendar.set(Calendar.HOUR_OF_DAY, i * 3);

            Date endDate = calendar.getTime();

            String series = (i % 2 == 0) ? "High Priority" : "Normal";

            ganttChartDataList.add(create(series, "Meeting" + i, startDate, endDate));
        }

        return ganttChartDataList;
    }

    private GanttChartBean create(String series, String task, Date startDate, Date endDate) {
        GanttChartBean ganttChartBean = new GanttChartBean();

        ganttChartBean.setSeries(series);
        ganttChartBean.setTask(task);
        ganttChartBean.setStartDate(startDate);
        ganttChartBean.setEndDate(endDate);

        return ganttChartBean;
    }
}
