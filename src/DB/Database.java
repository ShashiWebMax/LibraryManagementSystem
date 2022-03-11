package DB;
//java class to connect to sql and build quaries
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
        
        /**
         * Database Configuration variables
         */
        private String dbName = "LibraryDB";
        private String dbUsername = "root";
        private String dbPassword = ""; 
        
                
        public String getTableName(){
            return null;
        }
        
	
	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, dbUsername, dbPassword);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        /**
         * Get the database connection
         * @return 
         */
        public Connection getConnection() {		
		return connection;
		
	}
        /**
         * Run the provided query and get resultSet object
         * @param queary
         * @return 
         */
        public ResultSet runQueary(String queary) {
		try {
			resultSet = statement.executeQuery(queary);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
        
        /**
         * Run the provided query and provide results as an array 
         * @param query
         * @return 
         */
        public List getData(String query) {
		List data = new ArrayList();
		try {
			resultSet = statement.executeQuery(query);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int cols = rsmd.getColumnCount();
			while (resultSet.next()) {
				HashMap row = new HashMap(cols);
                                for(int i=1; i<=cols; ++i){           
                                   row.put(rsmd.getColumnName(i),resultSet.getObject(i));
                                }
				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
        /**
         * Run provided insert query 
         * @param query 
         */
        public void insertData(String query) {
		try {
			statement.executeUpdate(query);
			System.out.println("Data Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        /**
         * Insert data
         * @param data Map variable containing column and value
         */
        public void insert(Map<String,String> data){
            String cols = "";
            String values = "";
            for(String col : data.keySet()){
                 cols += "`"+col+"`,";
                 String val = data.get(col);
                 val = val.replace("'", "''");
                 val = val.replace("\\", "");
                 values += "'"+val+"',";                
            }
            cols = cols.substring(0, cols.length() - 1);
            values = values.substring(0, values.length() - 1);
            String qu = "INSERT INTO `"+this.getTableName()+"` ( "+cols+" ) VALUES ( "+values+" )";
            
            this.insertData(qu);
        }
        
        /**
         * Update data
         * @param data Map variable containing column and value
         */
        public void update(Map<String,String> data, int id){
            String cols = "";
            for(String col : data.keySet()){
                String val = data.get(col);
                val = val.replace("'", "''");
                val = val.replace("\\", ""); 
                cols += "`"+col+"` = '"+val+"',";
                              
            }
            cols = cols.substring(0, cols.length() - 1);
            String qu = "UPDATE `"+this.getTableName()+"` SET "+cols+"  WHERE `id` =  "+id+";";
            
            this.insertData(qu);
        }
        /**
         * delete data
         * 
         */
        public void delete(int id){
            
            String qu = "DELETE FROM `"+this.getTableName()+"` WHERE `id` =  "+id+";";            
            this.insertData(qu);
        }
        
        /**
         * Select and get data
         * @param query 
         */
        public List get(String query ){
            query = "Select * FROM `"+this.getTableName()+"` WHERE "+query+";";
            return this.getData(query);
        }       
        /**
         * Select and get data
         * @param query 
         */
        public ResultSet getResultSet(String query ){
            query = "Select * FROM `"+this.getTableName()+"` WHERE "+query+";";
            
            return this.runQueary(query);
        }       
        
	
        /**
         * Close database connection
         */
	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
