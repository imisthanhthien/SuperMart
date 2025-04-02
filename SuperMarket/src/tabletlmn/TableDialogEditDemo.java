package tabletlmn;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;


public class TableDialogEditDemo extends JPanel {
    private boolean DEBUG = false;
 
    public TableDialogEditDemo() {
        super(new GridLayout(1,0));
        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);    
        add(scrollPane);
    }
 
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Số thứ tự",
                                        "Thời gian bắt đầu",
                                        "Người thắng",};
        private String[][] data = {
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"},
            {"Mary", "A","B","C","C"}
          
        };
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
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
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
    private static void createAndShowGUI() { 
        JFrame frame = new JFrame("TableDialogEditDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new TableDialogEditDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(200, 100);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

