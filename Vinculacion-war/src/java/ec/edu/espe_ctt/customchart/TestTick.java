/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.customchart;

import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;

/**
 *
 * @author PC1
 */
public class TestTick implements JRChartCustomizer {

    @Override
    public void customize(org.jfree.chart.JFreeChart jfc, JRChart jrc) {

        DateAxis xAxis = new DateAxis();
        DateTickUnit unit = null;
        try {
            /*DateFormat chartFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            xAxis.setDateFormatOverride(chartFormatter);
            unit = new DateTickUnit(DateTickUnit.DAY, 15);
            System.out.println("::::::unit:::::" + unit);
            xAxis.setTickUnit(unit);
            xAxis.setVerticalTickLabels(true);
            ((XYPlot) jfc.getPlot()).setDomainAxis(xAxis);*/

            
            DateAxis axis= (DateAxis)jfc.getCategoryPlot().getRangeAxis();
            //axis.setTickUnit(new DateTickUnit(0, 0));
            axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
            axis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH, 1));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
