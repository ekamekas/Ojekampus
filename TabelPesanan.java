import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class TabelPesanan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TabelPesanan extends JFrame
{
    // instance variables - replace the example below with your own
    JTable pesananTable;
    DefaultTableModel tableModel;
    String[] headerName = {"Pelanggan", "LokasiAwal", "PenggunaAwal", "LokasiAkhir", "PenggunaAkhir", "Ojek", "Status", "Action"};
    /**
     * Constructor for objects of class TabelPesanan
     */
    
    public class CustomTableModel extends DefaultTableModel{
        public boolean isCellEditable(int row, int column){  
          return false;  
      }

    }
    
    public TabelPesanan()
    {
        // initialise instance variables
        super("Customer GUI");
        setSize(300,300);
        //GroupLayout layout = new GroupLayout(getContentPane());
        //setLayout(layout);
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        tableModel = new CustomTableModel();
        tableModel.setColumnIdentifiers(headerName);
        pesananTable = new JTable(tableModel);
        pesananTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        pesananTable.setPreferredScrollableViewportSize(pesananTable.getPreferredSize());
        pesananTable.setFillsViewportHeight(true);
        pesananTable.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e) {
                int firstRow = e.getFirstRow();
                int lastRow = e.getLastRow();
                int index = e.getColumn();
            
                switch (e.getType()) {
                case TableModelEvent.INSERT:
                  for (int i = firstRow; i <= lastRow; i++) {
                  }
                  break;
                case TableModelEvent.UPDATE:
                  if (firstRow == TableModelEvent.HEADER_ROW) {
                    if (index == TableModelEvent.ALL_COLUMNS) {
                      System.out.println("A column was added");
                    } else {
                      System.out.println(index + "in header changed");
                    }
                  } else {
                    for (int i = firstRow; i <= lastRow; i++) {
                      if (index == TableModelEvent.ALL_COLUMNS) {
                        System.out.println("All columns have changed");
                      } else {
                        System.out.println(index);
                      }
                    }
                  }
                  break;
                case TableModelEvent.DELETE:
                  for (int i = firstRow; i <= lastRow; i++) {
                    System.out.println(i);
                  }
                  break;
                }
              }
        });
        add(new JScrollPane(pesananTable));
        addData();
        setVisible(true);
    }
    
    public void addData(){
        ArrayList<Pesanan> listPesanan = DatabasePesanan.getDatabase();
        String[] temp = headerName;
        for(Pesanan pesan : listPesanan){
            temp[0] = pesan.getPelanggan().getNama();
            temp[1] = pesan.getLokasiAwal().getNama();
            temp[2] = pesan.getPenggunaAwal();
            temp[3] = pesan.getLokasiAkhir().getNama();
            temp[4] = pesan.getPenggunaAkhir();
            temp[5] = pesan.getPelayan().getNama();
            temp[6] = pesan.getFinalStatus();
            temp[7] = "";
            tableModel.addRow(temp);
            Arrays.fill(temp, null);
        }
        
    }
}
