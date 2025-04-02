package game;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class LichSuDau extends JPanel {
  
    public LichSuDau() throws SQLException{
        super(new GridLayout(1,0));
        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);  
       
   
       
        
        add(scrollPane);
    }
 
    class MyTableModel extends AbstractTableModel{
       String[][] x=new String[999999][6];
        
        public MyTableModel() throws SQLException
        {   
            //
        int count=0;
            ConnectDataBaseTLMN_NetBeans kn=new ConnectDataBaseTLMN_NetBeans();
        Connection cn=kn.getConnectdatabase();
         Statement stm=cn.createStatement(); 
        ResultSet rs=stm.executeQuery("select * from tablelichsudau");

        while(rs.next())
          {
               
             for(int i=0;i<5;i++)
             {
          x[count][i]=rs.getString(i+1).trim(); 
        
             }
            count++;
         }
       
        }
        
                
private String[] columnNames = {"STT","Thời gian bắt đầu","Số Người Chơi","May mắn tới trắng nè","Winner"};

        private String[][] data=x;
           
        public int getColumnCount() {
            return columnNames.length;
        }
        public int getRowCount() {
            return data.length;
        }
        public String getColumnName(int col) {
            return columnNames[col];
        }
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }    
      
        public boolean isCellEditable(int row, int col) {      
            return false;
        }
        private void printDebugData() {
            
            int numRows = getRowCount();
            int numCols = getColumnCount();
            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
  
  
    
}

