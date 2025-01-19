package mainMethod;

public class Query {

	 	private static String insert = "INSERT INTO Task (Title) VALUES (?)";
	    
	    
	    private static String updateT = "UPDATE Task SET title = ? WHERE Tno = ?";
	    private static String updateS = "UPDATE Task SET Status = ? WHERE Tno = ?";
	    private static String updateTS = "UPDATE Task SET title = ?,T-Status = ? WHERE Tno = ?";
	    
	        
	    private static String delete = "DELETE FROM Task WHERE Tno = ?";
	    
	    
	    private static String select = "SELECT * FROM Task";
	    private static String selectTitle = "SELECT Title FROM Task where Tno = ?";
	    private static String selectStatus = "SELECT Title,Status FROM Task where Tno = ?";
	    
		public static String getInsert() {
			return insert;
		}
		
		public static String getUpdateT() {
			return updateT;
		}
		
		public static String getUpdateS() {
			return updateS;
		}
		
		public static String getDelete() {
			return delete;
		}
		

		public static String getSelect() {
			return select;
		}
		
		public static String getSelectTitle() {
			return selectTitle;
		}
		
		public static String getSelectStatus() {
			return selectStatus;
		}

		public static String getUpdateTS() {
			return updateTS;
		}
		
	    
	    
		

	
}
