
package bd;
import java.sql.*;

public class Main {
	static Connection connt;
	static String url = "jdbc:mysql://localhost:3306/mysql";
	static String name_user = "root";
	static String passw_user = "";
	
	public static Connection conn()
	{
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Драйвер подключен");
		}
		catch (Exception e){
			System.out.println("Ошибка соединения");
			return null;
		}
		try{
			connt = DriverManager.getConnection(url, name_user,passw_user);
			System.out.println("Соединение установлено");
		}
		catch(SQLException e){
			System.out.println("Ошибка соединения");
			return null;
		}
		
		
		
		return connt;
	}
	public static void crTable(Connection cn){
		ResultSet res = null;
		Statement statm;
		 try {
				cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
			System.out.println("Успешно создано");
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		/*
		try{
			
			statm.execute("CREATE DATABASE mars");
			statm.execute("SET NAMES `CP1251`");
		}
		catch(SQLException e){
			System.out.println("Ошибка создания БД. БД уже существует.");
			return;
		}
		*/
		try{
			statm.execute("USE mars");
			
			
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		
try{
			/*
			statm.execute("CREATE TABLE `goods` (`id_code` INT(11) NOT NULL, `type` VARCHAR(85) NOT NULL, "
					+ "`name` VARCHAR(85) NOT NULL, `manufacturer` VARCHAR(85) NOT NULL, `provider` VARCHAR(85) NOT NULL, `quantity` INT(11) NOT NULL,"
					+ " PRIMARY KEY(id_code))");
				*/	
					
//	statm.execute("drop TABLE `goods`");
	res = statm.executeQuery("SELECT id_code, type, name, manufacturer, provider, quantity FROM goods");
	
	while(res.next()){
		System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4)
		+ "\t" + res.getString(5) + "\t" + res.getString(6) + "\n");
	}
			statm.executeUpdate("INSERT INTO `goods` (`id_code`, "
					+ "`type`, `name`, `manufacturer`, `provider`,"
					+ "`quantity`) VALUES ('"+Signed.tbAdd.getValueAt(0,0)+"', '"+Signed.tbAdd.getValueAt(0,1)+"', '"+Signed.tbAdd.getValueAt(0,2)+"', '"+Signed.tbAdd.getValueAt(0,3)+"', "
					+ "'"+Signed.tbAdd.getValueAt(0,4)+"', '"+Signed.tbAdd.getValueAt(0,5)+"')");
//			Signed.
			
		}
		catch (SQLException e){
			System.out.println("Ошибка create table goods");
			System.err.println(e);
			return;
		}
	}
	
	
	
	public static void crTable2(Connection cn){
		ResultSet res = null;
		Statement statm;
		 try {
				cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
			System.out.println("Успешно создано");
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		/*
		try{
			
			statm.execute("CREATE DATABASE mars");
			statm.execute("SET NAMES `CP1251`");
		}
		catch(SQLException e){
			System.out.println("Ошибка SETCP");
			System.err.println(e);
			return;
		}
		*/
		try{
			statm.execute("USE mars");
			
			
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		
try{
			/*
			statm.execute("CREATE TABLE `requests` (`Request_id` INT(11) NOT NULL, `Name` VARCHAR(85) NOT NULL, "
					+ "`Manufacturer` VARCHAR(85) NOT NULL, `Quantity` INT(11) NOT NULL,"
					+ " PRIMARY KEY(Request_id))");
				*/	
					
//	statm.execute("drop TABLE `requests`");
	res = statm.executeQuery("SELECT Request_id, name, manufacturer, quantity FROM requests");
	
	while(res.next()){
		System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
	}
			statm.executeUpdate("INSERT INTO `requests` (`Request_id`, "
					+ " `Name`, `Manufacturer`, "
					+ "`Quantity`) VALUES ('"+Signed.tbAdd2.getValueAt(0,0)+"', '"+Signed.tbAdd2.getValueAt(0,1)+"', '"+Signed.tbAdd2.getValueAt(0,2)+"', '"+Signed.tbAdd2.getValueAt(0,3)+"')");
//			Signed.
			
		}
		catch (SQLException e){
			System.out.println("Ошибка create table requests");
			System.err.println(e);
			return;
		}
	}
	
	public static void crTable3(Connection cn){
		ResultSet res = null;
		Statement statm;
		 try {
				cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
//			System.out.println("Успешно создано");
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		try{
			statm.execute("USE mars");
			
			
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		
try{
			/*
			statm.execute("CREATE TABLE `requestProv` (`Request_id` INT(11) NOT NULL, `Name` VARCHAR(85) NOT NULL, "
					+ "`Manufacturer` VARCHAR(85) NOT NULL, `Quantity` INT(11) NOT NULL,"
					+ " PRIMARY KEY(Request_id))");
				*/
					
//	statm.execute("drop TABLE `requestProv`");
	res = statm.executeQuery("SELECT Request_id, name, manufacturer, quantity FROM requestProv");
	
	while(res.next()){
		System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
	}
			statm.executeUpdate("INSERT INTO `requestProv` (`Request_id`, "
					+ " `Name`, `Manufacturer`, "
					+ "`Quantity`) VALUES ('"+Signed.tbAdd3.getValueAt(0,0)+"', '"+Signed.tbAdd3.getValueAt(0,1)+"', '"+Signed.tbAdd3.getValueAt(0,2)+"', '"+Signed.tbAdd3.getValueAt(0,3)+"')");
//			Signed.
			
		}
		catch (SQLException e){
			System.out.println("Ошибка create table requestProv");
			System.err.println(e);
			return;
		}
	}
	
	public static void crTableEmp(Connection cn){
		ResultSet res = null;
		Statement statm;
		 try {
				cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
//			System.out.println("Успешно создано");
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
try{
			/*
			statm.execute("CREATE TABLE `empl` (`Employer_id` INT(11) NOT NULL, `SNP` VARCHAR(85) NOT NULL, "
					+ "`Position` VARCHAR(85) NOT NULL, `Department` VARCHAR(85) NOT NULL, `Passport` VARCHAR(85) NOT NULL,"
					+ " PRIMARY KEY(Employer_id))");
				*/
					
//	statm.execute("drop TABLE `empl`");
	res = statm.executeQuery("SELECT Employer_id, SNP, Position, Department, Passport FROM empl");
	
	while(res.next()){
		System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
	}
			statm.executeUpdate("INSERT INTO `empl` (`Employer_id`, `SNP`,"
					+ " `Position`, `Department`, "
					+ "`Passport`) VALUES ('"+Signed.tbAdd4.getValueAt(0,0)+"', '"+Signed.tbAdd4.getValueAt(0,1)+"', "
					+ "'"+Signed.tbAdd4.getValueAt(0,2)+"', '"+Signed.tbAdd4.getValueAt(0,3)+"', '" + Signed.tbAdd4.getValueAt(0,4) +"')");
//			Signed.
			
		}
		catch (SQLException e){
			System.out.println("Ошибка create table empl");
			System.err.println(e);
			return;
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public static void crTableProviders(Connection cn){
		ResultSet res = null;
		Statement statm;
		 try {
				cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
try{
	/*
			statm.execute("CREATE TABLE `providers` (`Provider_id` INT(11) NOT NULL, `Name` VARCHAR(85) NOT NULL, `Good_type` VARCHAR(85) NOT NULL, "
					+ "`Adress` VARCHAR(85) NOT NULL, `Telephone` VARCHAR(85) NOT NULL,"
					+ " PRIMARY KEY(Provider_id))");
					*/
//	statm.execute("drop TABLE `providers`");
	res = statm.executeQuery("SELECT Provider_id, Name, Good_type, Adress, Telephone FROM providers");
	
	while(res.next()){
		System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\t" + res.getString(4) + "\n");
	}
			statm.executeUpdate("INSERT INTO `providers` (`Provider_id`, `Name`, `Good_type`,"
					+ " `Adress`, `Telephone`)"
					+ " VALUES ('"+Signed.tbAdd5.getValueAt(0,0)+"', '"+Signed.tbAdd5.getValueAt(0,1)+"', "
					+ "'"+Signed.tbAdd5.getValueAt(0,2)+"', '"+Signed.tbAdd5.getValueAt(0,3)+"', '" + Signed.tbAdd5.getValueAt(0,4) +"')");
		}
		catch (SQLException e){
			System.out.println("Ошибка create table providers");
			System.err.println(e);
			return;
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////
	public static void crTableBuyers(Connection cn){
		ResultSet res = null;
		Statement statm;
		 try {
				cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
try{
	/*
			statm.execute("CREATE TABLE `buyers` (`Buyer_id` INT(11) NOT NULL, `Name` VARCHAR(85) NOT NULL, "
					+ "`Adress` VARCHAR(85) NOT NULL, `Telephone` VARCHAR(85) NOT NULL,"
					+ " PRIMARY KEY(Buyer_id))");
					*/
//	statm.execute("drop TABLE `providers`");
	res = statm.executeQuery("SELECT Buyer_id, Name, Adress, Telephone FROM buyers");
	
	while(res.next()){
		System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
	}
			statm.executeUpdate("INSERT INTO `buyers` (`Buyer_id`, `Name`,"
					+ " `Adress`, `Telephone`)"
					+ " VALUES ('"+Signed.tbAdd6.getValueAt(0,0)+"', '"+Signed.tbAdd6.getValueAt(0,1)+"', "
					+ "'"+Signed.tbAdd6.getValueAt(0,2)+"', '"+Signed.tbAdd6.getValueAt(0,3)+"')");
		}
		catch (SQLException e){
			System.out.println("Ошибка create table buyers");
			System.err.println(e);
			return;
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void crTableDepartments(Connection cn){
		ResultSet res = null;
		Statement statm;
		 try {
				cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
try{
	/*
			statm.execute("CREATE TABLE `departments` (`Department_id` INT(11) NOT NULL, `Name` VARCHAR(85) NOT NULL, "
					+ "`Telephone` VARCHAR(85) NOT NULL,"
					+ " PRIMARY KEY(Department_id))");
					*/
//	statm.execute("drop TABLE `departments`");
	res = statm.executeQuery("SELECT Department_id, Name, Telephone FROM departments");
	while(res.next()){
		System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\n");
	}
			statm.executeUpdate("INSERT INTO `departments` (`Department_id`, `Name`,"
					+ "`Telephone`)"
					+ " VALUES ('"+Signed.tbAdd7.getValueAt(0,0)+"', '"+Signed.tbAdd7.getValueAt(0,1)+"', "
					+ "'"+Signed.tbAdd7.getValueAt(0,2)+"')");
		}
		catch (SQLException e){
			System.out.println("Ошибка create table departments");
			System.err.println(e);
			return;
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public static void delRow(Connection cn){
		ResultSet res = null;
		Statement statm;
		try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try{
			statm.execute("DELETE FROM goods WHERE id_code =" + Signed.te1.getText());
			res = statm.executeQuery("SELECT id_code, name, type, manufacturer, provider, quantity FROM goods");
			
			while(res.next()){
				System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
			}
		}
		catch(SQLException e){
			System.out.println("Ошибка delete");
			return;
		}
	}
	public static void delRow2(Connection cn){
		ResultSet res = null;
		Statement statm;
		try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try{
			statm.execute("DELETE FROM requests WHERE Request_id =" + Signed.te2.getText());
			res = statm.executeQuery("SELECT Request_id, Name, Manufacturer, Quantity FROM requests");
			
			while(res.next()){
				System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
			}
		}
		catch(SQLException e){
			System.out.println("Ошибка delete");
			return;
		}
	}
	
	public static void delRow3(Connection cn){
		ResultSet res = null;
		Statement statm;
		try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try{
			statm.execute("DELETE FROM requestProv WHERE Request_id =" + Signed.te3.getText());
			res = statm.executeQuery("SELECT Request_id, Name, Manufacturer, Quantity FROM requestProv");
			
			while(res.next()){
				System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
			}
		}
		catch(SQLException e){
			System.out.println("Ошибка delete");
			return;
		}
	}
	/////////////////////////////////////////////////////////////////////////////
	public static void delRowEmp(Connection cn){
		ResultSet res = null;
		Statement statm;
		try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try{
			statm.execute("DELETE FROM empl WHERE Employer_id =" + Signed.te4.getText());
			res = statm.executeQuery("SELECT Employer_id, SNP, Position, Department, Passport FROM empl");
			
			while(res.next()){
				System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
			}
		}
		catch(SQLException e){
			System.out.println("Ошибка delete");
			return;
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void delRowProviders(Connection cn){
		ResultSet res = null;
		Statement statm;
		try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try{
			statm.execute("DELETE FROM providers WHERE Provider_id =" + Signed.te5.getText());
			res = statm.executeQuery("SELECT Provider_id, Name, Good_type, Adress, Telephone FROM providers");
			
			while(res.next()){
				System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4) + "\n");
			}
		}
		catch(SQLException e){
			System.out.println("Ошибка delete");
			return;
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void delRowBuyers(Connection cn){
		ResultSet res = null;
		Statement statm;
		try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try{
			statm.execute("DELETE FROM providers WHERE Provider_id =" + Signed.te6.getText());
			res = statm.executeQuery("SELECT Provider_id, Name, Adress, Telephone FROM providers");
			
			while(res.next()){
				System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\n");
			}
		}
		catch(SQLException e){
			System.out.println("Ошибка delete");
			System.err.println(e);
			return;
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void delRowDepartments(Connection cn){
		ResultSet res = null;
		Statement statm;
		try {
			cn = DriverManager.getConnection(Main.url, Main.name_user,Main.passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			statm = cn.createStatement();
		}
		catch(SQLException e){
			System.out.println("Ошибка createStatement");
			return;
		}
		
		try{
			statm.execute("USE mars");
		}
		catch(SQLException e){
			System.out.println("Ошибка use");
			return;
		}
		try{
			statm.execute("DELETE FROM departments WHERE Department_id =" + Signed.te7.getText());
			res = statm.executeQuery("SELECT Department_id, Name, Telephone FROM departments");
			
			while(res.next()){
				System.out.print(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\n");
			}
		}
		catch(SQLException e){
			System.out.println("Ошибка delete");
			return;
		}
	}
	
	/*
	public static void printTable(Connection cn){
		PreparedStatement   pstmt = null;
		Statement stm = null;
        ResultSet            rs    = null;
        
        DefaultTableModel   dtm   = null;
        try {
			cn = DriverManager.getConnection(url, name_user,passw_user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try{
        	stm = cn.createStatement();
			System.out.println("Успешно удалено");
			
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
            for(int col = 1; col <= rsmd.getColumnCount(); col++) {                        
                
                int type = rsmd.getColumnType(col);
                
                switch(type) {
                
                    case Types.INTEGER :
                        row.add(new Integer(rs.getInt(col)).toString());
                        break;
                        
                    case Types.VARCHAR :
                        row.add(rs.getString(col));
                        break;
                        
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
JTable      grid = new JTable();
        
        grid.setModel(dtm);
JScrollPane jsp  = new JScrollPane(grid);
*/
/*
JFrame jf = new JFrame("Эти фламинго - поклонники свинга(c)Не мой :) ");
jf.setSize(640, 480);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

jf.add(jsp);        
jf.setVisible(true);      
	}
	*/ 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}