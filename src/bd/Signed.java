package bd;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Signed {
	//global variables
	static Connection cnctn;
	static JFrame frame_main;
	static Font font = new Font("Verdana", Font.PLAIN, 10);
	static JTable table;
	JTable table2;
	private Workbook workbook = new HSSFWorkbook();
	private Sheet sheet = workbook.createSheet("Smth");
	private Row row = sheet.createRow(0);
	private Cell cell;
	static JTable tbDel;
	static JTextField te1;
	static JTextField te2;
	static JTextField te3;
	static JTextField te4;
	static JTextField te5;
	static JTextField te6;
	static JTextField te7;
	DefaultTableModel   dtm;
	DefaultTableModel   dtm2;
	DefaultTableModel   dtm3;
	DefaultTableModel   dtm4;
	DefaultTableModel   dtm5;
	DefaultTableModel   dtm6;
	DefaultTableModel   dtm7;
	DefaultTableModel   dtma;
	static JTable tbAdd;
	static JTable tbAdd2;
	static JTable tbAdd3;
	static JTable tbAdd4;
	static JTable tbAdd5;
	static JTable tbAdd6;
	static JTable tbAdd7;
	static JMenuItem fromB;

private JTextField jtfFilter = new JTextField();
private JButton jbtFilter = new JButton("Filter");
	public static void main(String[] args) {
//		cnctn = Main.conn();
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					Signed window_reg = new Signed();
					Signed.frame_main.setVisible(true);
				}
				catch (Exception e2){
					e2.printStackTrace();
				}
			}
});
	}
	//////////////////////////////////////////////
	public Signed(){
		
		/**
		 * Printing sql-table
		 */
		PreparedStatement   pstmt = null;
		Statement stm = null;
		Connection cn = null;
        ResultSet rs    = null;
        dtm   = null;
        try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try{
        	stm = cn.createStatement();
//			System.out.println("Успешно удалено");
			
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
        try{
        	
        	stm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try {
			pstmt = cn.prepareStatement("SELECT id_code, type, name, manufacturer, provider, quantity FROM goods");
		
        dtm   = new DefaultTableModel();
        
        if(pstmt.execute()) {
            rs = pstmt.getResultSet(); 
            ResultSetMetaData rsmd = rs.getMetaData(); 
            for(int col = 1; col <= rsmd.getColumnCount(); col++)
                dtm.addColumn(rsmd.getColumnName(col)); 
            while (rs.next()) {
            Vector<String>  row = new Vector<String>(); //Строка таблицы
            for(int col = 1; col <= rsmd.getColumnCount(); col++) {                        
                
                int type = rsmd.getColumnType(col);
                
                switch(type) {
                
                    case Types.INTEGER :
                        row.add(new Integer(rs.getInt(col)).toString());
                        break;
                        
                    case Types.VARCHAR :
                        row.add(rs.getString(col));
                        break;
                        
                    default :
                        throw new Exception("Неподдерживаемый тип");
                }
                
            }                                    
            
            dtm.addRow(row);
        }
    }   
		}

catch (SQLException ex) {            
    System.out.println(ex.toString());
    
                
} catch (Exception e) {            
    e.printStackTrace();
}
		JTable grid = new JTable();
        
        grid.setModel(dtm);
JScrollPane jsp  = new JScrollPane(grid);



PreparedStatement   pstmt2 = null;
Statement stm2 = null;
Connection cn2 = null;
ResultSet rs2    = null;
dtm2 = null;
try {
	cn2 = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
try{
	stm2 = cn2.createStatement();
//	System.out.println("Успешно удалено");
	
}
catch(SQLException e){
	System.out.println("Ошибка createStatement");
	return;
}
try{
	
	stm2.execute("USE mars");
}
catch(SQLException e){
	System.out.println("Ошибка use");
	return;
}
try {
	pstmt2 = cn2.prepareStatement("SELECT Request_id, Name, Manufacturer, Quantity FROM requests");

dtm2   = new DefaultTableModel();

if(pstmt2.execute()) {
    rs2 = pstmt2.getResultSet(); 
    ResultSetMetaData rsmd2 = rs2.getMetaData(); 
    for(int col = 1; col <= rsmd2.getColumnCount(); col++)
        dtm2.addColumn(rsmd2.getColumnName(col)); 
    while (rs2.next()) {
    Vector<String>  row2 = new Vector<String>(); //Строка таблицы
    for(int col = 1; col <= rsmd2.getColumnCount(); col++) {                        
        
        int type = rsmd2.getColumnType(col);
        
        switch(type) {
        
            case Types.INTEGER :
                row2.add(new Integer(rs2.getInt(col)).toString());
                break;
                
            case Types.VARCHAR :
                row2.add(rs2.getString(col));
                break;
                
            default :
                throw new Exception("Неподдерживаемый тип");
        }
        
    }                                    
    
    dtm2.addRow(row2);
}
}   
}

catch (SQLException ex) {            
System.out.println(ex.toString());

        
} catch (Exception e) {            
e.printStackTrace();
}
JTable      grid2 = new JTable();

grid2.setModel(dtm2);
JScrollPane jsp2  = new JScrollPane(grid2);



PreparedStatement   pstmt3 = null;
Statement stm3 = null;
Connection cn3 = null;
ResultSet rs3   = null;
dtm3 = null;
try {
	cn3 = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
try{
	stm3 = cn3.createStatement();
//	System.out.println("Успешно удалено");
	
}
catch(SQLException e){
	System.out.println("Ошибка createStatement");
	return;
}
try{
	
	stm3.execute("USE mars");
}
catch(SQLException e){
	System.out.println("Ошибка use");
	return;
}
try {
	pstmt3 = cn3.prepareStatement("SELECT Request_id, Name, Manufacturer, Quantity FROM requestProv");

dtm3   = new DefaultTableModel();

if(pstmt3.execute()) {
    rs3 = pstmt3.getResultSet(); 
    ResultSetMetaData rsmd3 = rs3.getMetaData(); 
    for(int col = 1; col <= rsmd3.getColumnCount(); col++)
        dtm3.addColumn(rsmd3.getColumnName(col)); 
    while (rs3.next()) {
    Vector<String>  row3 = new Vector<String>(); //Строка таблицы
    for(int col = 1; col <= rsmd3.getColumnCount(); col++) {                        
        
        int type = rsmd3.getColumnType(col);
        
        switch(type) {
        
            case Types.INTEGER :
            	row3.add(new Integer(rs3.getInt(col)).toString());
                break;
                
            case Types.VARCHAR :
            	row3.add(rs3.getString(col));
                break;
                
            default :
                throw new Exception("Неподдерживаемый тип");
        }
        
    }                                    
    
    dtm3.addRow(row3);
}
}   
}

catch (SQLException ex) {            
System.out.println(ex.toString());

        
} catch (Exception e) {            
e.printStackTrace();
}
JTable      grid3 = new JTable();

grid3.setModel(dtm3);
JScrollPane jsp3  = new JScrollPane(grid3);
////////////////////////////////////////////////////////////////////////////////////////
PreparedStatement   pstmt4 = null;
Statement stm4 = null;
Connection cn4 = null;
ResultSet rs4   = null;
dtm4 = null;
try {
	cn4 = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
try{
	stm4 = cn4.createStatement();
//	System.out.println("Успешно удалено");
	
}
catch(SQLException e){
	System.out.println("Ошибка createStatement");
	return;
}
try{
	
	stm4.execute("USE mars");
}
catch(SQLException e){
	System.out.println("Ошибка use");
	return;
}
try {
	pstmt4 = cn4.prepareStatement("SELECT Employer_id, SNP, Position, Department, Passport FROM empl");

dtm4   = new DefaultTableModel();

if(pstmt4.execute()) {
    rs4 = pstmt4.getResultSet(); 
    ResultSetMetaData rsmd4 = rs4.getMetaData(); 
    for(int col = 1; col <= rsmd4.getColumnCount(); col++)
        dtm4.addColumn(rsmd4.getColumnName(col)); 
    while (rs4.next()) {
    Vector<String>  row4 = new Vector<String>(); //Строка таблицы
    for(int col = 1; col <= rsmd4.getColumnCount(); col++) {                        
        
        int type = rsmd4.getColumnType(col);
        
        switch(type) {
        
            case Types.INTEGER :
            	row4.add(new Integer(rs4.getInt(col)).toString());
                break;
                
            case Types.VARCHAR :
            	row4.add(rs4.getString(col));
                break;
                
            default :
                throw new Exception("Неподдерживаемый тип");
        }
        
    }                                    
    
    dtm4.addRow(row4);
}
}   
}

catch (SQLException ex) {            
System.out.println(ex.toString());

        
} catch (Exception e) {            
e.printStackTrace();
}
JTable      grid4 = new JTable();

grid4.setModel(dtm4);
JScrollPane jsp4  = new JScrollPane(grid4);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
PreparedStatement   pstmt5 = null;
Statement stm5 = null;
Connection cn5 = null;
ResultSet rs5 = null;
dtm5 = null;
try {
	cn5 = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
try{
	stm5 = cn5.createStatement();
}
catch(SQLException e){
	System.out.println("Ошибка createStatement");
	return;
}
try{
	
	stm5.execute("USE mars");
}
catch(SQLException e){
	System.out.println("Ошибка use");
	return;
}
try {
	pstmt5 = cn5.prepareStatement("SELECT Provider_id, Name, Good_type, Adress, Telephone FROM providers");
dtm5   = new DefaultTableModel();

if(pstmt5.execute()) {
    rs5 = pstmt5.getResultSet(); 
    ResultSetMetaData rsmd5 = rs5.getMetaData(); 
    for(int col = 1; col <= rsmd5.getColumnCount(); col++)
        dtm5.addColumn(rsmd5.getColumnName(col)); 
    while (rs5.next()) {
    Vector<String>  row5 = new Vector<String>(); //Строка таблицы
    for(int col = 1; col <= rsmd5.getColumnCount(); col++) {                        
        
        int type = rsmd5.getColumnType(col);
        
        switch(type) {
        
            case Types.INTEGER :
            	row5.add(new Integer(rs5.getInt(col)).toString());
                break;
                
            case Types.VARCHAR :
            	row5.add(rs5.getString(col));
                break;
                
            default :
                throw new Exception("Неподдерживаемый тип");
        }
        
    }                                    
    
    dtm5.addRow(row5);
}
}   
}

catch (SQLException ex) {            
System.out.println(ex.toString());

        
} catch (Exception e) {            
e.printStackTrace();
}
JTable      grid5 = new JTable();

grid5.setModel(dtm5);
JScrollPane jsp5 = new JScrollPane(grid5);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
PreparedStatement   pstmt6 = null;
Statement stm6 = null;
Connection cn6 = null;
ResultSet rs6 = null;
dtm6 = null;
try {
cn6 = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
try{
stm6 = cn6.createStatement();
}
catch(SQLException e){
System.out.println("Ошибка createStatement");
return;
}
try{

stm6.execute("USE mars");
}
catch(SQLException e){
System.out.println("Ошибка use");
return;
}
try {
pstmt6 = cn6.prepareStatement("SELECT Buyer_id, Name, Adress, Telephone FROM buyers");
dtm6   = new DefaultTableModel();

if(pstmt6.execute()) {
rs6 = pstmt6.getResultSet(); 
ResultSetMetaData rsmd6 = rs6.getMetaData(); 
for(int col = 1; col <= rsmd6.getColumnCount(); col++)
dtm6.addColumn(rsmd6.getColumnName(col)); 
while (rs6.next()) {
Vector<String>  row6 = new Vector<String>(); //Строка таблицы
for(int col = 1; col <= rsmd6.getColumnCount(); col++) {                        

int type = rsmd6.getColumnType(col);

switch(type) {

case Types.INTEGER :
row6.add(new Integer(rs6.getInt(col)).toString());
break;

case Types.VARCHAR :
row6.add(rs6.getString(col));
break;

default :
throw new Exception("Неподдерживаемый тип");
}

}                                    

dtm6.addRow(row6);
}
}   
}

catch (SQLException ex) {            
System.out.println(ex.toString());


} catch (Exception e) {            
e.printStackTrace();
}
JTable      grid6 = new JTable();

grid6.setModel(dtm6);
JScrollPane jsp6 = new JScrollPane(grid6);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
PreparedStatement   pstmt7 = null;
Statement stm7 = null;
Connection cn7 = null;
ResultSet rs7 = null;
dtm7 = null;
try {
cn7 = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
try{
stm7 = cn7.createStatement();
}
catch(SQLException e){
System.out.println("Ошибка createStatement");
return;
}
try{

stm7.execute("USE mars");
}
catch(SQLException e){
System.out.println("Ошибка use");
return;
}
try {
pstmt7 = cn7.prepareStatement("SELECT Department_id, Name, Telephone FROM departments");
dtm7 = new DefaultTableModel();

if(pstmt7.execute()) {
rs7 = pstmt7.getResultSet(); 
ResultSetMetaData rsmd7 = rs7.getMetaData(); 
for(int col = 1; col <= rsmd7.getColumnCount(); col++)
dtm7.addColumn(rsmd7.getColumnName(col)); 
while (rs7.next()) {
Vector<String>  row7 = new Vector<String>(); //Строка таблицы
for(int col = 1; col <= rsmd7.getColumnCount(); col++) {                        

int type = rsmd7.getColumnType(col);

switch(type) {

case Types.INTEGER :
row7.add(new Integer(rs7.getInt(col)).toString());
break;

case Types.VARCHAR :
row7.add(rs7.getString(col));
break;

default :
throw new Exception("Неподдерживаемый тип");
}

}                                    

dtm7.addRow(row7);
}
}   
}

catch (SQLException ex) {            
System.out.println(ex.toString());


} catch (Exception e) {            
e.printStackTrace();
}
JTable      grid7 = new JTable();

grid7.setModel(dtm7);
JScrollPane jsp7 = new JScrollPane(grid7);




//	    table2 = new JTable(Tables.data2, Tables.columnNames2);
		frame_main = new JFrame("MARS");
		frame_main.setBounds(500, 200, 750, 436);
		frame_main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame_main.setVisible(true);
		//////////////////////////////////////////////
		////////		Menu
		//////////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Меню");
        JMenuItem newMenu = new JMenuItem("Экспорт в Excel", new ImageIcon("images/excel.png"));
        fileMenu.add(newMenu);
        newMenu.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
            	writeIntoExcel();
            }
        });
        
        
        fileMenu.addSeparator();
        JMenuItem change_user = new JMenuItem("Сменить пользователя", new ImageIcon("images/relogin.png"));
        fileMenu.add(change_user);
        change_user.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                frame_main.setVisible(false);  
                Start.main(null);
            }           
        });
        JMenuItem exit = new JMenuItem("Выход", new ImageIcon("images/exit.png"));
        fileMenu.add(exit);        
        exit.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                System.exit(0);             
            }           
        });
        JMenu managing = new JMenu("Управление");
        JMenuItem editing_goods = new JMenuItem("Редактирование списка товаров");
        managing.add(editing_goods);
        
        editing_goods.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                JFrame newFr = new JFrame("Товары");
                newFr.setBounds(550, 250, 700, 500);
                newFr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                tbAdd = new JTable(Tables.dataEmp, Tables.columnNames);		//table for adding rows
                JScrollPane scrollPaneAdd = new JScrollPane(tbAdd);
                scrollPaneAdd.setBounds(0, 0, 638, 39);

                JButton butcr = new JButton("Добавить");
                butcr.setBounds(280, 50, 100, 25);
        
                butcr.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.crTable(cnctn);
        				Vector newRow = new Vector();
        				
        				newRow.add(tbAdd.getValueAt(0,0));
        				newRow.add(tbAdd.getValueAt(0,1));
        				newRow.add(tbAdd.getValueAt(0,2));
        				newRow.add(tbAdd.getValueAt(0,3));
        				newRow.add(tbAdd.getValueAt(0,4));
        				newRow.add(tbAdd.getValueAt(0,5));
        				butcr.requestFocus();
        				dtm.getDataVector().add(newRow); 
        				// Метод выравнивает добавленную строку по ширине таблицы и оповещает всех
        				// слушателей о том что таблица изменилась.
        				dtm.newRowsAdded(new TableModelEvent(dtm));
        			}
        			});
                newFr.setVisible(true);
                
                JLabel label1 = new JLabel("Введите артикул: ");
                label1.setBounds(230, 150, 140, 25);
                
                //////////////////////Deleting row
                
                te1 = new JTextField();
                te1.setBounds(350, 150, 100, 25);
                newFr.getContentPane().add(label1);
                newFr.getContentPane().add(te1);
                JButton butdel = new JButton("Удалить");
                butdel.setBounds(285, 185, 100, 25);
                butdel.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.delRow(cnctn);
        				 for (int i = 0; i < grid.getRowCount(); i++)
        				    {
        				      if (grid.getValueAt(i, 0).equals(te1.getText()))
        				      	{
        				    	  dtm.removeRow(i);
        				      }
        				    }
        			}
        				
        		});
                
                newFr.getContentPane().add(scrollPaneAdd);
                newFr.getContentPane().add(butcr);
                newFr.getContentPane().add(butdel);
                tbAdd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tbAdd.getColumnModel().getColumn(0).setPreferredWidth(55);
                tbAdd.getColumnModel().getColumn(1).setPreferredWidth(115);
                tbAdd.getColumnModel().getColumn(2).setPreferredWidth(150);
                tbAdd.getColumnModel().getColumn(3).setPreferredWidth(110);
                tbAdd.getColumnModel().getColumn(4).setPreferredWidth(120);
                tbAdd.getColumnModel().getColumn(5).setPreferredWidth(85);
                newFr.getContentPane().setLayout(null);
            }     
            
        });
        
        
        JMenuItem add_good_to_list = new JMenuItem("Редактировать заказы от покупателя");
        managing.add(add_good_to_list);
        
        
        add_good_to_list.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                JFrame newFr2 = new JFrame("Заказы от покупателя");
                newFr2.setBounds(550, 250, 600, 500);
                newFr2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                tbAdd2 = new JTable(Tables.dataEmp2, Tables.columnNames2);		//table for adding rows
                JScrollPane scrollPaneAdd2 = new JScrollPane(tbAdd2);
                scrollPaneAdd2.setBounds(0, 0, 433, 39);

                JButton butcr2 = new JButton("Добавить");
                butcr2.setBounds(220, 50, 100, 25);
        
                butcr2.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.crTable2(cnctn);
        				Vector newRow2 = new Vector();
        				
        				newRow2.add(tbAdd2.getValueAt(0,0));
        				newRow2.add(tbAdd2.getValueAt(0,1));
        				newRow2.add(tbAdd2.getValueAt(0,2));
        				newRow2.add(tbAdd2.getValueAt(0,3));
        				butcr2.requestFocus();
        				dtm2.getDataVector().add(newRow2); 
        				// Метод выравнивает добавленную строку по ширине таблицы и оповещает всех
        				// слушателей о том что таблица изменилась.
        				dtm2.newRowsAdded(new TableModelEvent(dtm2));
        			}
        			});
                newFr2.setVisible(true);
                
                JLabel label2 = new JLabel("Введите номер заявки: ");
                label2.setBounds(170, 150, 200, 25);
                
                //////////////////////Deleting row
                
                te2 = new JTextField();
                te2.setBounds(320, 150, 100, 25);
                newFr2.getContentPane().add(label2);
                newFr2.getContentPane().add(te2);
                JButton butdel2 = new JButton("Удалить");
                butdel2.setBounds(225, 185, 100, 25);
                butdel2.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.delRow2(cnctn);
        				 for (int i = 0; i < grid2.getRowCount(); i++)
        				    {
        				      if (grid2.getValueAt(i, 0).equals(te2.getText()))
        				      	{
        				    	  dtm2.removeRow(i);
        				      }
        				    }
        			}
        				
        		});
                
                newFr2.getContentPane().add(scrollPaneAdd2);
                newFr2.getContentPane().add(butcr2);
                newFr2.getContentPane().add(butdel2);
                tbAdd2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tbAdd2.getColumnModel().getColumn(0).setPreferredWidth(55);
                tbAdd2.getColumnModel().getColumn(1).setPreferredWidth(115);
                tbAdd2.getColumnModel().getColumn(2).setPreferredWidth(150);
                tbAdd2.getColumnModel().getColumn(3).setPreferredWidth(110);
                newFr2.getContentPane().setLayout(null);
            }     
            
        });
        
        
        fromB = new JMenuItem("Редактировать заказы поставщику");
        
        managing.add(fromB);
        fromB.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                JFrame newFr3 = new JFrame("Заказы поставщику");
                newFr3.setBounds(550, 250, 600, 500);
                newFr3.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                tbAdd3 = new JTable(Tables.dataEmp2, Tables.columnNames2);		//table for adding rows
                JScrollPane scrollPaneAdd3 = new JScrollPane(tbAdd3);
                scrollPaneAdd3.setBounds(0, 0, 433, 39);

                JButton butcr3 = new JButton("Добавить");
                butcr3.setBounds(220, 50, 100, 25);
        
                butcr3.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.crTable3(cnctn);
        				Vector newRow3 = new Vector();
        				
        				newRow3.add(tbAdd3.getValueAt(0,0));
        				newRow3.add(tbAdd3.getValueAt(0,1));
        				newRow3.add(tbAdd3.getValueAt(0,2));
        				newRow3.add(tbAdd3.getValueAt(0,3));
        				butcr3.requestFocus();
        				dtm3.getDataVector().add(newRow3); 
        				// Метод выравнивает добавленную строку по ширине таблицы и оповещает всех
        				// слушателей о том что таблица изменилась.
        				dtm3.newRowsAdded(new TableModelEvent(dtm3));
        			}
        			});
                newFr3.setVisible(true);
                
                JLabel label3 = new JLabel("Введите номер заявки: ");
                label3.setBounds(170, 150, 170, 25);
                
                //////////////////////Deleting row
                
                te3 = new JTextField();
                te3.setBounds(320, 150, 100, 25);
                newFr3.getContentPane().add(label3);
                newFr3.getContentPane().add(te3);
                JButton butdel3 = new JButton("Удалить");
                butdel3.setBounds(225, 185, 100, 25);
                butdel3.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.delRow3(cnctn);
        				 for (int i = 0; i < grid3.getRowCount(); i++)
        				    {
        				      if (grid3.getValueAt(i, 0).equals(te3.getText()))
        				      	{
        				    	  dtm3.removeRow(i);
        				      }
        				    }
        			}
        				
        		});
                
                newFr3.getContentPane().add(scrollPaneAdd3);
                newFr3.getContentPane().add(butcr3);
                newFr3.getContentPane().add(butdel3);
                tbAdd3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tbAdd3.getColumnModel().getColumn(0).setPreferredWidth(55);
                tbAdd3.getColumnModel().getColumn(1).setPreferredWidth(115);
                tbAdd3.getColumnModel().getColumn(2).setPreferredWidth(150);
                tbAdd3.getColumnModel().getColumn(3).setPreferredWidth(110);
                newFr3.getContentPane().setLayout(null);
            }     
            
        });
        managing.addSeparator();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JMenuItem emp = new JMenuItem("Сотрудники");
        managing.add(emp);
        
        emp.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                JFrame newFr4 = new JFrame("Сотрудники");
                newFr4.setBounds(550, 250, 600, 500);
                newFr4.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                tbAdd4 = new JTable(Tables.dataForEmp, Tables.columnNamesEmp);		//table for adding rows
                JScrollPane scrollPaneAdd4 = new JScrollPane(tbAdd4);
                scrollPaneAdd4.setBounds(0, 0, 508, 39);

                JButton butcr4 = new JButton("Добавить");
                butcr4.setBounds(220, 50, 100, 25);
        
                butcr4.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.crTableEmp(cnctn);
        				Vector newRow4 = new Vector();
        				
        				newRow4.add(tbAdd4.getValueAt(0,0));
        				newRow4.add(tbAdd4.getValueAt(0,1));
        				newRow4.add(tbAdd4.getValueAt(0,2));
        				newRow4.add(tbAdd4.getValueAt(0,3));
        				newRow4.add(tbAdd4.getValueAt(0,4));
        				butcr4.requestFocus();
        				dtm4.getDataVector().add(newRow4); 
        				// Метод выравнивает добавленную строку по ширине таблицы и оповещает всех
        				// слушателей о том что таблица изменилась.
        				dtm4.newRowsAdded(new TableModelEvent(dtm4));
        			}
        			});
                newFr4.setVisible(true);
                
                JLabel label4 = new JLabel("Введите id сотрудника: ");
                label4.setBounds(170, 150, 170, 25);
                
                //////////////////////Deleting row
                
                te4 = new JTextField();
                te4.setBounds(320, 150, 100, 25);
                newFr4.getContentPane().add(label4);
                newFr4.getContentPane().add(te4);
                JButton butdel4= new JButton("Удалить");
                butdel4.setBounds(225, 185, 100, 25);
                butdel4.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.delRowEmp(cnctn);
        				 for (int i = 0; i < grid4.getRowCount(); i++)
        				    {
        				      if (grid4.getValueAt(i, 0).equals(te4.getText()))
        				      	{
        				    	  dtm4.removeRow(i);
        				      }
        				    }
        			}
        				
        		});
                
                newFr4.getContentPane().add(scrollPaneAdd4);
                newFr4.getContentPane().add(butcr4);
                newFr4.getContentPane().add(butdel4);
                tbAdd4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tbAdd4.getColumnModel().getColumn(0).setPreferredWidth(55);
                tbAdd4.getColumnModel().getColumn(1).setPreferredWidth(115);
                tbAdd4.getColumnModel().getColumn(2).setPreferredWidth(150);
                tbAdd4.getColumnModel().getColumn(3).setPreferredWidth(110);
                newFr4.getContentPane().setLayout(null);
            }     
            
        });

        ///////////////////////////////////////////////////////////////////////////
        JMenuItem providers = new JMenuItem("Поставщики");
        managing.add(providers);
        
        providers.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                JFrame newFr5 = new JFrame("Поставщики");
                newFr5.setBounds(550, 250, 600, 500);
                newFr5.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                tbAdd5 = new JTable(Tables.dataForProv, Tables.columnNamesProv);		//table for adding rows
                JScrollPane scrollPaneAdd5 = new JScrollPane(tbAdd5);
                scrollPaneAdd5.setBounds(0, 0, 508, 39);

                JButton butcr5 = new JButton("Добавить");
                butcr5.setBounds(220, 50, 100, 25);
        
                butcr5.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.crTableProviders(cnctn);
        				Vector newRow5 = new Vector();
        				
        				newRow5.add(tbAdd5.getValueAt(0,0));
        				newRow5.add(tbAdd5.getValueAt(0,1));
        				newRow5.add(tbAdd5.getValueAt(0,2));
        				newRow5.add(tbAdd5.getValueAt(0,3));
        				newRow5.add(tbAdd5.getValueAt(0,4));
        				butcr5.requestFocus();
        				dtm5.getDataVector().add(newRow5); 
        				// Метод выравнивает добавленную строку по ширине таблицы и оповещает всех
        				// слушателей о том что таблица изменилась.
        				dtm5.newRowsAdded(new TableModelEvent(dtm5));
        			}
        			});
                newFr5.setVisible(true);
                
                JLabel label5 = new JLabel("Введите id поставщика: ");
                label5.setBounds(170, 150, 170, 25);
                
                //////////////////////Deleting row
                
                te5 = new JTextField();
                te5.setBounds(320, 150, 100, 25);
                newFr5.getContentPane().add(label5);
                newFr5.getContentPane().add(te5);
                JButton butdel5 = new JButton("Удалить");
                butdel5.setBounds(225, 185, 100, 25);
                butdel5.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.delRowProviders(cnctn);
        				 for (int i = 0; i < grid5.getRowCount(); i++)
        				    {
        				      if (grid5.getValueAt(i, 0).equals(te5.getText()))
        				      	{
        				    	  dtm5.removeRow(i);
        				      }
        				    }
        			}
        				
        		});
                
                newFr5.getContentPane().add(scrollPaneAdd5);
                newFr5.getContentPane().add(butcr5);
                newFr5.getContentPane().add(butdel5);
                tbAdd5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tbAdd5.getColumnModel().getColumn(0).setPreferredWidth(55);
                tbAdd5.getColumnModel().getColumn(1).setPreferredWidth(115);
                tbAdd5.getColumnModel().getColumn(2).setPreferredWidth(150);
                tbAdd5.getColumnModel().getColumn(3).setPreferredWidth(110);
                newFr5.getContentPane().setLayout(null);
            }     
            
        });
        ///////////////////////////////////////////////////////////////////////////////
        
        JMenuItem b = new JMenuItem("Покупатели");
        managing.add(b);
        b.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                JFrame newFr6 = new JFrame("Покупатели");
                newFr6.setBounds(550, 250, 500, 500);
                newFr6.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                tbAdd6 = new JTable(Tables.dataForBuy, Tables.columnNamesBuy);		//table for adding rows
                JScrollPane scrollPaneAdd6 = new JScrollPane(tbAdd6);
                scrollPaneAdd6.setBounds(0, 0, 398, 39);

                JButton butcr6 = new JButton("Добавить");
                butcr6.setBounds(150, 50, 100, 25);
        
                butcr6.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.crTableBuyers(cnctn);
        				Vector newRow6 = new Vector();
        				
        				newRow6.add(tbAdd6.getValueAt(0,0));
        				newRow6.add(tbAdd6.getValueAt(0,1));
        				newRow6.add(tbAdd6.getValueAt(0,2));
        				newRow6.add(tbAdd6.getValueAt(0,3));
        				butcr6.requestFocus();
        				dtm6.getDataVector().add(newRow6); 
        				// Метод выравнивает добавленную строку по ширине таблицы и оповещает всех
        				// слушателей о том что таблица изменилась.
        				dtm6.newRowsAdded(new TableModelEvent(dtm6));
        			}
        			});
                newFr6.setVisible(true);
                
                JLabel label6 = new JLabel("Введите id покупателя: ");
                label6.setBounds(75, 150, 140, 25);
                
                //////////////////////Deleting row
                
                te6 = new JTextField();
                te6.setBounds(230, 150, 100, 25);
                newFr6.getContentPane().add(label6);
                newFr6.getContentPane().add(te6);
                JButton butdel6 = new JButton("Удалить");
                butdel6.setBounds(150, 185, 100, 25);
                butdel6.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.delRowBuyers(cnctn);
        				 for (int i = 0; i < grid6.getRowCount(); i++)
        				    {
        				      if (grid6.getValueAt(i, 0).equals(te6.getText()))
        				      	{
        				    	  dtm6.removeRow(i);
        				      }
        				    }
        			}
        				
        		});
                
                newFr6.getContentPane().add(scrollPaneAdd6);
                newFr6.getContentPane().add(butcr6);
                newFr6.getContentPane().add(butdel6);
                tbAdd6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tbAdd6.getColumnModel().getColumn(0).setPreferredWidth(55);
                tbAdd6.getColumnModel().getColumn(1).setPreferredWidth(115);
                tbAdd6.getColumnModel().getColumn(2).setPreferredWidth(150);

                newFr6.getContentPane().setLayout(null);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JMenuItem departments = new JMenuItem("Отделы");
        managing.add(departments);
        
        departments.addActionListener(new ActionListener() {           
            @Override
			public void actionPerformed(ActionEvent e) {
                JFrame newFr7 = new JFrame("Отделы");
                newFr7.setBounds(550, 250, 430, 500);
                newFr7.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                tbAdd7 = new JTable(Tables.dataForDep, Tables.columnNamesDep);		//table for adding rows
                JScrollPane scrollPaneAdd7 = new JScrollPane(tbAdd7);
                scrollPaneAdd7.setBounds(0, 0, 323, 39);

                JButton butcr7 = new JButton("Добавить");
                butcr7.setBounds(140, 50, 100, 25);
        
                butcr7.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.crTableDepartments(cnctn);
        				Vector newRow7 = new Vector();
        				
        				newRow7.add(tbAdd7.getValueAt(0,0));
        				newRow7.add(tbAdd7.getValueAt(0,1));
        				newRow7.add(tbAdd7.getValueAt(0,2));
        				butcr7.requestFocus();
        				dtm7.getDataVector().add(newRow7);
        				dtm7.newRowsAdded(new TableModelEvent(dtm7));
        			}
        			});
                newFr7.setVisible(true);
                
                JLabel label7 = new JLabel("Введите номер отдела: ");
                label7.setBounds(85, 150, 140, 25);
                
                //////////////////////Deleting row
                
                te7 = new JTextField();
                te7.setBounds(250, 150, 100, 25);
                newFr7.getContentPane().add(label7);
                newFr7.getContentPane().add(te7);
                JButton butdel7 = new JButton("Удалить");
                butdel7.setBounds(140, 185, 100, 25);
                butdel7.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e){
        				Main.delRowDepartments(cnctn);
        				 for (int i = 0; i < grid7.getRowCount(); i++)
        				    {
        				      if (grid7.getValueAt(i, 0).equals(te7.getText()))
        				      	{
        				    	  dtm7.removeRow(i);
        				      }
        				    }
        			}
        				
        		});
                
                newFr7.getContentPane().add(scrollPaneAdd7);
                newFr7.getContentPane().add(butcr7);
                newFr7.getContentPane().add(butdel7);
                tbAdd7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tbAdd7.getColumnModel().getColumn(0).setPreferredWidth(55);
                tbAdd7.getColumnModel().getColumn(1).setPreferredWidth(115);
                tbAdd7.getColumnModel().getColumn(2).setPreferredWidth(150);
                newFr7.getContentPane().setLayout(null);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(Start.get_login.equals(Users.seller_login) && Start.get_pass.equals(Users.seller_password)){
			fromB.setEnabled(false);
			newMenu.setEnabled(false);
			emp.setEnabled(false);
			departments.setEnabled(false);
        }
        if(Start.get_login.equals(Users.stockman_login) && Start.get_pass.equals(Users.stockman_password)){
        	fromB.setEnabled(false);
			newMenu.setEnabled(false);
			emp.setEnabled(false);
			providers.setEnabled(false);
			departments.setEnabled(false);
			b.setEnabled(false);
			add_good_to_list.setEnabled(false);
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        JMenu search = new JMenu("Поиск");
        managing.add(search);
        menuBar.add(fileMenu);
        menuBar.add(managing);
        menuBar.add(search);
        frame_main.setJMenuBar(menuBar);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);
        frame_main.getContentPane().add(tabbedPane);
        
        JScrollPane scrollPane = new JScrollPane(grid);
        JScrollPane scrollPane2 = new JScrollPane(grid2);
        JScrollPane scrollPane3 = new JScrollPane(grid3);
        JScrollPane scrollPane4 = new JScrollPane(grid4);
        JScrollPane scrollPane5 = new JScrollPane(grid5);
        JScrollPane scrollPane6 = new JScrollPane(grid6);
        JScrollPane scrollPane7 = new JScrollPane(grid7);
        
        tabbedPane.addTab("Товар", scrollPane);
        tabbedPane.addTab("Заказы покупателей", scrollPane2);
        tabbedPane.addTab("Заказы поставщикам", scrollPane3);
        tabbedPane.addTab("Сотрудники", scrollPane4);
        tabbedPane.addTab("Поставщики", scrollPane5);
        tabbedPane.addTab("Покупатели", scrollPane6);
        tabbedPane.addTab("Отделы", scrollPane7);
        
        search.addMenuListener(new MenuListener() {
            @Override
			public void menuSelected(MenuEvent e) {
            	PreparedStatement   pstmt = null;
        		Statement stm = null;
        		Connection cn = null;
                ResultSet rs    = null;
                dtm   = null;
                try {
        			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
        		} catch (SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                try{
                	stm = cn.createStatement();
//        			System.out.println("Успешно удалено");
        			
        		}
        		catch(SQLException eex){
        			System.out.println("Ошибка createStatement");
        			return;
        		}
                try{
                	
                	stm.execute("USE mars");
        		}
        		catch(SQLException ex){
        			System.out.println("Ошибка use");
        			return;
        		}
        		try {
        			pstmt = cn.prepareStatement("SELECT id_code, type, name, manufacturer, provider, quantity FROM goods");
        		
                dtm   = new DefaultTableModel();
                
                if(pstmt.execute()) {
                    rs = pstmt.getResultSet(); 
                    ResultSetMetaData rsmd = rs.getMetaData(); 
                    for(int col = 1; col <= rsmd.getColumnCount(); col++)
                        dtm.addColumn(rsmd.getColumnName(col)); 
                    while (rs.next()) {
                    Vector<String>  row = new Vector<String>(); //Строка таблицы
                    for(int col = 1; col <= rsmd.getColumnCount(); col++) {                        
                        
                        int type = rsmd.getColumnType(col);
                        
                        switch(type) {
                        
                            case Types.INTEGER :
                                row.add(new Integer(rs.getInt(col)).toString());
                                break;
                                
                            case Types.VARCHAR :
                                row.add(rs.getString(col));
                                break;
                                
                            default :
                                throw new Exception("Неподдерживаемый тип");
                        }
                        
                    }                                    
                    
                    dtm.addRow(row);
                }
            }   
        		}

        catch (SQLException ex) {            
            System.out.println(ex.toString());
            
                        
        } catch (Exception ex) {            
        	ex.printStackTrace();
        }
        		JTable grid = new JTable();
                
                grid.setModel(dtm);
        JScrollPane jsp  = new JScrollPane(grid);
            	JFrame frameSearch = new JFrame("Поиск");
        		frameSearch.setBounds(550, 205, 650, 400);
        		frameSearch.setAlwaysOnTop(true);
        		JTable gridClone = grid;
        		DefaultTableModel model = new DefaultTableModel(Tables.dataEmp, Tables.columnNames);
        		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(gridClone.getModel());
        		gridClone.setRowSorter(rowSorter);

		        JPanel panel = new JPanel(new BorderLayout());
		        panel.add(new JLabel("Введите текст:"),
		                BorderLayout.WEST);
		        panel.add(jtfFilter, BorderLayout.CENTER);

		        frameSearch.getContentPane().setLayout(new BorderLayout());
		        frameSearch.getContentPane().add(panel, BorderLayout.SOUTH);
		        frameSearch.getContentPane().add(new JScrollPane(gridClone), BorderLayout.CENTER);

		        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

		            @Override
		            public void insertUpdate(DocumentEvent e) {
		                String text = jtfFilter.getText();

		                if (text.trim().length() == 0) {
		                    rowSorter.setRowFilter(null);
		                } else {
		                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		                }
		            }

		            @Override
		            public void removeUpdate(DocumentEvent e) {
		                String text = jtfFilter.getText();

		                if (text.trim().length() == 0) {
		                    rowSorter.setRowFilter(null);
		                } else {
		                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		                }
		            }

		            @Override
		            public void changedUpdate(DocumentEvent e) {
		                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		            }

		        });
		        /*
		        frameSearch.addWindowListener(new WindowAdapter() {
		        	public void windowClosing(WindowEvent e) {
		        	System.exit(0);
		        	}
		        	});
		        	*/
                
 //               frameSearch.getContentPane().setLayout(null);
        		frameSearch.setVisible(true);
        		
        		
        		
             }
            @Override
			public void menuDeselected(MenuEvent e) {
            }
            @Override
			public void menuCanceled(MenuEvent e) {
            }
        		
        	
        });
	}
    public static void writeIntoExcel(){
    	JFrame frameExcel = new JFrame("Экспорт в Excel");
    	frameExcel.setBounds(600, 250, 450, 250);
    	frameExcel.getContentPane().setLayout(null);
    	frameExcel.setVisible(true);
    	JLabel labelHint = new JLabel("Выберите таблицы, которые хотите экспортировать: ");
    	labelHint.setBounds(60, 20, 330, 15);
    	frameExcel.getContentPane().add(labelHint);
    	JButton goods = new JButton("Товары");
    	goods.setBounds(30, 45, 110, 25);
    	frameExcel.getContentPane().add(goods);
    	goods.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection connection = DriverManager.getConnection(
		                            "jdbc:mysql://localhost:3306/mars", "root", "");
		            PreparedStatement psmnt = null;
		            Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery("SELECT id_code, type, name, manufacturer, provider, quantity FROM goods");

		            HSSFWorkbook wb = new HSSFWorkbook();
		            HSSFSheet sheet = wb.createSheet("Excel Sheet");
		            HSSFRow rowhead = sheet.createRow((short) 0);
		            rowhead.createCell((short) 0).setCellValue("№");
		            rowhead.createCell((short) 1).setCellValue("Тип");
		            rowhead.createCell((short) 2).setCellValue("Наименование");
		            rowhead.createCell((short) 3).setCellValue("Производитель");
		            rowhead.createCell((short) 4).setCellValue("Поставщик");
		            rowhead.createCell((short) 5).setCellValue("Количество");

		            int index = 1;
		            while (rs.next()) {

		                    HSSFRow row = sheet.createRow((short) index);
		                    row.createCell((short) 0).setCellValue(rs.getInt(1));
		                    row.createCell((short) 1).setCellValue(rs.getString(2));
		                    row.createCell((short) 2).setCellValue(rs.getString(3));
		                    row.createCell((short) 3).setCellValue(rs.getString(4));
		                    row.createCell((short) 4).setCellValue(rs.getString(5));
		                    row.createCell((short) 5).setCellValue(rs.getInt(6));
		                    index++;
		            }
		            FileOutputStream fileOut = new FileOutputStream("Товары.xls");
		            wb.write(fileOut);
		            fileOut.close();
		            System.out.println("Data is saved in excel file.");
		            rs.close();
		            connection.close();
		    } catch (Exception exception) {
		    }
			}
				
		});
    	JButton empls = new JButton("Сотрудники");
    	empls.setBounds(155, 45, 110, 25);
    	frameExcel.getContentPane().add(empls);
    	empls.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection connection = DriverManager.getConnection(
		                            "jdbc:mysql://localhost:3306/mars", "root", "");
		            PreparedStatement psmnt = null;
		            Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery("SELECT Employer_id, SNP, Position, Department, Passport FROM empl");

		            HSSFWorkbook wb = new HSSFWorkbook();
		            HSSFSheet sheet = wb.createSheet("Excel Sheet");
		            HSSFRow rowhead = sheet.createRow((short) 0);
		            rowhead.createCell((short) 0).setCellValue("№");
		            rowhead.createCell((short) 1).setCellValue("ФИО");
		            rowhead.createCell((short) 2).setCellValue("Должность");
		            rowhead.createCell((short) 3).setCellValue("Отдел");
		            rowhead.createCell((short) 4).setCellValue("Пасспортные данные");

		            int index = 1;
		            while (rs.next()) {

		                    HSSFRow row = sheet.createRow((short) index);
		                    row.createCell((short) 0).setCellValue(rs.getInt(1));
		                    row.createCell((short) 1).setCellValue(rs.getString(2));
		                    row.createCell((short) 2).setCellValue(rs.getString(3));
		                    row.createCell((short) 3).setCellValue(rs.getString(4));
		                    row.createCell((short) 4).setCellValue(rs.getString(5));
		                    index++;
		            }
		            FileOutputStream fileOut = new FileOutputStream("Сотрудники.xls");
		            wb.write(fileOut);
		            fileOut.close();
		            System.out.println("Data is saved in excel file.");
		            rs.close();
		            connection.close();
		    } catch (Exception exception) {
		    }
			}
				
		});
    	JButton departments = new JButton("Отделы");
    	departments.setBounds(280, 45, 110, 25);
    	frameExcel.getContentPane().add(departments);
    	departments.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection connection = DriverManager.getConnection(
		                            "jdbc:mysql://localhost:3306/mars", "root", "");
		            PreparedStatement psmnt = null;
		            Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery("SELECT Department_id, Name, Telephone FROM departments");

		            HSSFWorkbook wb = new HSSFWorkbook();
		            HSSFSheet sheet = wb.createSheet("Excel Sheet");
		            HSSFRow rowhead = sheet.createRow((short) 0);
		            rowhead.createCell((short) 0).setCellValue("№");
		            rowhead.createCell((short) 1).setCellValue("Наименование");
		            rowhead.createCell((short) 2).setCellValue("Телефон");

		            int index = 1;
		            while (rs.next()) {

		                    HSSFRow row = sheet.createRow((short) index);
		                    row.createCell((short) 0).setCellValue(rs.getInt(1));
		                    row.createCell((short) 1).setCellValue(rs.getString(2));
		                    row.createCell((short) 2).setCellValue(rs.getString(3));
		                    index++;
		            }
		            FileOutputStream fileOut = new FileOutputStream("Отделы.xls");
		            wb.write(fileOut);
		            fileOut.close();
		            System.out.println("Data is saved in excel file.");
		            rs.close();
		            connection.close();
		    } catch (Exception exception) {
		    }
			}
				
		});
    	JButton list1 = new JButton("Заявки покупателей");
    	list1.setBounds(30, 80, 171, 25);
    	frameExcel.getContentPane().add(list1);
    	list1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection connection = DriverManager.getConnection(
		                            "jdbc:mysql://localhost:3306/mars", "root", "");
		            PreparedStatement psmnt = null;
		            Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery("SELECT Request_id, name, manufacturer, quantity FROM requests");

		            HSSFWorkbook wb = new HSSFWorkbook();
		            HSSFSheet sheet = wb.createSheet("Excel Sheet");
		            HSSFRow rowhead = sheet.createRow((short) 0);
		            rowhead.createCell((short) 0).setCellValue("№");
		            rowhead.createCell((short) 1).setCellValue("Наименование");
		            rowhead.createCell((short) 2).setCellValue("Производитель");
		            rowhead.createCell((short) 3).setCellValue("Количество");

		            int index = 1;
		            while (rs.next()) {

		                    HSSFRow row = sheet.createRow((short) index);
		                    row.createCell((short) 0).setCellValue(rs.getInt(1));
		                    row.createCell((short) 1).setCellValue(rs.getString(2));
		                    row.createCell((short) 2).setCellValue(rs.getString(3));
		                    row.createCell((short) 3).setCellValue(rs.getInt(4));
		                    index++;
		            }
		            FileOutputStream fileOut = new FileOutputStream("Заявки покупателей.xls");
		            wb.write(fileOut);
		            fileOut.close();
		            System.out.println("Data is saved in excel file.");
		            rs.close();
		            connection.close();
		    } catch (Exception exception) {
		    }
			}
				
		});
    	JButton list2 = new JButton("Заявки поставщикам");
    	list2.setBounds(220, 80, 171, 25);
    	frameExcel.getContentPane().add(list2);
    	list2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection connection = DriverManager.getConnection(
		                            "jdbc:mysql://localhost:3306/mars", "root", "");
		            PreparedStatement psmnt = null;
		            Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery("SELECT Request_id, name, manufacturer, quantity FROM requestProv");

		            HSSFWorkbook wb = new HSSFWorkbook();
		            HSSFSheet sheet = wb.createSheet("Excel Sheet");
		            HSSFRow rowhead = sheet.createRow((short) 0);
		            rowhead.createCell((short) 0).setCellValue("№");
		            rowhead.createCell((short) 1).setCellValue("Наименование");
		            rowhead.createCell((short) 2).setCellValue("Производитель");
		            rowhead.createCell((short) 3).setCellValue("Количество");

		            int index = 1;
		            while (rs.next()) {

		                    HSSFRow row = sheet.createRow((short) index);
		                    row.createCell((short) 0).setCellValue(rs.getInt(1));
		                    row.createCell((short) 1).setCellValue(rs.getString(2));
		                    row.createCell((short) 2).setCellValue(rs.getString(3));
		                    row.createCell((short) 3).setCellValue(rs.getInt(4));
		                    index++;
		            }
		            FileOutputStream fileOut = new FileOutputStream("Заявки поставщикам.xls");
		            wb.write(fileOut);
		            fileOut.close();
		            System.out.println("Data is saved in excel file.");
		            rs.close();
		            connection.close();
		    } catch (Exception exception) {
		    }
			}
				
		});
    	JButton buyers = new JButton("Покупатели");
    	buyers.setBounds(91, 115, 110, 25);
    	frameExcel.getContentPane().add(buyers);
    	buyers.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection connection = DriverManager.getConnection(
		                            "jdbc:mysql://localhost:3306/mars", "root", "");
		            PreparedStatement psmnt = null;
		            Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery("SELECT Buyer_id, Name, Adress, Telephone FROM buyers");

		            HSSFWorkbook wb = new HSSFWorkbook();
		            HSSFSheet sheet = wb.createSheet("Excel Sheet");
		            HSSFRow rowhead = sheet.createRow((short) 0);
		            rowhead.createCell((short) 0).setCellValue("№");
		            rowhead.createCell((short) 1).setCellValue("Наименование");
		            rowhead.createCell((short) 2).setCellValue("Адресс");
		            rowhead.createCell((short) 3).setCellValue("Телефон");

		            int index = 1;
		            while (rs.next()) {

		                    HSSFRow row = sheet.createRow((short) index);
		                    row.createCell((short) 0).setCellValue(rs.getInt(1));
		                    row.createCell((short) 1).setCellValue(rs.getString(2));
		                    row.createCell((short) 2).setCellValue(rs.getString(3));
		                    row.createCell((short) 3).setCellValue(rs.getString(4));
		                    index++;
		            }
		            FileOutputStream fileOut = new FileOutputStream("Покупатели.xls");
		            wb.write(fileOut);
		            fileOut.close();
		            System.out.println("Data is saved in excel file.");
		            rs.close();
		            connection.close();
		    } catch (Exception exception) {
		    }
			}
				
		});
    	JButton prvdrs = new JButton("Поставщики");
    	prvdrs.setBounds(220, 115, 110, 25);
    	frameExcel.getContentPane().add(prvdrs);
    	buyers.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection connection = DriverManager.getConnection(
		                            "jdbc:mysql://localhost:3306/mars", "root", "");
		            PreparedStatement psmnt = null;
		            Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery("SELECT Buyer_id, Name, Adress, Telephone FROM buyers");

		            HSSFWorkbook wb = new HSSFWorkbook();
		            HSSFSheet sheet = wb.createSheet("Excel Sheet");
		            HSSFRow rowhead = sheet.createRow((short) 0);
		            rowhead.createCell((short) 0).setCellValue("№");
		            rowhead.createCell((short) 1).setCellValue("Наименование");
		            rowhead.createCell((short) 2).setCellValue("Адресс");
		            rowhead.createCell((short) 3).setCellValue("Телефон");

		            int index = 1;
		            while (rs.next()) {

		                    HSSFRow row = sheet.createRow((short) index);
		                    row.createCell((short) 0).setCellValue(rs.getInt(1));
		                    row.createCell((short) 1).setCellValue(rs.getString(2));
		                    row.createCell((short) 2).setCellValue(rs.getString(3));
		                    row.createCell((short) 3).setCellValue(rs.getString(4));
		                    index++;
		            }
		            FileOutputStream fileOut = new FileOutputStream("Поставщики.xls");
		            wb.write(fileOut);
		            fileOut.close();
		            System.out.println("Data is saved in excel file.");
		            rs.close();
		            connection.close();
		    } catch (Exception exception) {
		    }
			}
				
		});
    		
}
	
}