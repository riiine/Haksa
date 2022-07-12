import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.ui.ApplicationFrame;

public class BookRentNow extends JPanel {
	DefaultTableModel model=null;
	JTable table=null;
	Connection conn=null;
	
	Statement stmt;  
	String query; //sql문
	
	public BookRentNow() {

		query = "select s.dept, sum(br.bookea) "
				+ "from student s, bookrent br "
				+ "where s.id=br.id "
				+ "group by s.dept";
		JDBCPieDataset dataset = null;
		try {
			dataset = new JDBCPieDataset(
					"jdbc:oracle:thin:@localhost:1521:xe", "oracle.jdbc.driver.OracleDriver",
					"ora_user", "hong");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			dataset.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setLayout(null);//레이아웃설정. 레이아웃 사용 안함.
		
		JFreeChart chart = ChartFactory.createPieChart("학과별 대출횟수", dataset, true,
				true, false);
		chart.getTitle().setFont(new Font("돋움", Font.BOLD, 20));
		chart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 10));

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("돋움", Font.PLAIN, 12));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		add(chartPanel);
		
		
		ApplicationFrame f = new ApplicationFrame("학과별 대출횟수");
		f.setContentPane(chartPanel);
		f.pack();
		f.setVisible(true);
		

	}
}