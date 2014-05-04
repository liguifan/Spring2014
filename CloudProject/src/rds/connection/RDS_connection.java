package rds.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RDS_connection {
	Connection conn;
	Statement statement = null;
	ResultSet resultSet = null;
	String DB_END_POINT = "mydbinstance.crowgjuaiaiz.us-east-1.rds.amazonaws.com";
	final String DB_USER_NAME = "liguifan";
	final String DB_PWD = "liguifan";
	final String DB_NAME = "mydb";
	final int DB_PORT = 3306;
	String insql;
	String upsql;
	String delsql;


	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getInsql() {
		return insql;
	}

	public void setInsql(String insql) {
		this.insql = insql;
	}

	public String getUpsql() {
		return upsql;
	}

	public void setUpsql(String upsql) {
		this.upsql = upsql;
	}

	public String getDelsql() {
		return delsql;
	}

	public void setDelsql(String delsql) {
		this.delsql = delsql;
	}


	public Connection createConnectionAndStatement()
	{

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://"+DB_END_POINT+":"+DB_PORT+"/"+DB_NAME,DB_USER_NAME,DB_PWD);
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			else {
				System.out.println("Failing connecting to the Database!");
			}
			//			statement = connect.createStatement();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void CutConnection(Connection conn) throws SQLException{
		try{
			if(resultSet!=null);
			if(conn!=null);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			resultSet.close();
			conn.close();
			System.out.println("Connection is close");
		}
	}



	public void insertTable(String Tablename,String name, String link) throws SQLException{
		String insert="insert into "+Tablename+" values(\""+name+"\",\""+link+"\")";
		System.out.println(insert);
		createConnectionAndStatement();
		statement.executeUpdate(insert);
	}

	public class user{
		String userid="";
		String username="";
		String facebook_url="";
		String age="";
		String photo="";
		String movies="";
		String athelete="";
		String teams="";
		String musician="";
		String personality="";
		String stage="";
		String url1="";
		String url2="";
		String url3="";
		String online="";
		String last_online="";
		String last_update="";
		String device_token="";

		public String getDevice_token() {
			return device_token;
		}

		public void setDevice_token(String device_token) {
			this.device_token = device_token;
		}
		
		public String getFacebook_url() {
			return facebook_url;
		}

		public void setFacebook_url(String facebook_url) {
			this.facebook_url = facebook_url;
		}
		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}


		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public String getMovies() {
			return movies;
		}

		public void setMovies(String movies) {
			this.movies = movies;
		}

		public String getAthelete() {
			return athelete;
		}

		public void setAthelete(String athelete) {
			this.athelete = athelete;
		}

		public String getTeams() {
			return teams;
		}

		public void setTeams(String teams) {
			this.teams = teams;
		}

		public String getMusician() {
			return musician;
		}

		public void setMusician(String musician) {
			this.musician = musician;
		}

		public String getPersonality() {
			return personality;
		}

		public void setPersonality(String personality) {
			this.personality = personality;
		}

		//??test=
		public boolean register_ID(user user){
			try{

				String insql="insert into REGISTER(userid,facebook_url,name,age,photo,movies,athelete,teams,musician,personality,device_token) values(?,?,?,?,?,?,?,?,?,?,?)";
				//上面的方法比下面的方法有优势，一方面是安全性，另一方面我忘记了……
				//insql="insert into user(userid,username,password,email) values(user.getId,user.getName,user.getPassword,user.getEmail)";
				PreparedStatement ps=conn.prepareStatement(insql);
				//.preparedStatement(insql);
				//PreparedStatement  ps=(PreparedStatement) conn.prepareStatement(insql);
				ps.setString(1, user.getUserid());
				ps.setString(2, user.getFacebook_url());
				ps.setString(3, user.getUsername());
				ps.setString(4, user.getAge());
				ps.setString(5, user.getPhoto());
				ps.setString(6, user.getMovies());
				ps.setString(7, user.getAthelete());
				ps.setString(8, user.getTeams());
				ps.setString(9, user.getMusician());
				ps.setString(10, user.getPersonality());
				ps.setString(11, user.getDevice_token());
				int result=ps.executeUpdate();
				//ps.executeUpdate();无法判断是否已经插入
				if(result>0)
					return true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}


		public boolean UpdateUser(String ID, user user){
			upsql="update REGISTER set password=?,name=?,age=?,photo=?,movies=?,athelete=?,teams=?,musician=?,personality=?,device_token=? where userid=?";
			try {
				PreparedStatement ps = conn.prepareStatement(upsql);
				ps.setString(10, ID);
				ps.setString(1, user.getFacebook_url());
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getAge());
				ps.setString(4, user.getPhoto());
				ps.setString(5, user.getMovies());
				ps.setString(6, user.getAthelete());
				ps.setString(7, user.getTeams());
				ps.setString(8, user.getMusician());
				ps.setString(9, user.getPersonality());
				ps.setString(10, user.getDevice_token());
				int result=ps.executeUpdate();//返回行数或者0
				if(result>0)
					return true;
			} catch (SQLException ex) {
				Logger.getLogger(RDS_connection.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
		}

		public boolean DeletUser(String ID){
			String delsql="delete from REGISTER where userid=?";
			try {
				PreparedStatement ps = conn.prepareStatement(delsql);
				ps.setString(1, ID);
				int result=ps.executeUpdate();
				if(result>0)
					return true;
			} catch (SQLException ex) {
				Logger.getLogger(RDS_connection.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
		}




		public boolean update_DynamicStatus(user user){
			String insql="insert into DYNAMIC_TABLE(userid,stage,url1,url2,url3,online,last_online,last_update) values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps=conn.prepareStatement(insql);
				ps.setString(1, user.getUserid());
				ps.setString(2, user.getStage());
				ps.setString(3, user.getUrl1());
				ps.setString(4, user.getUrl1());
				ps.setString(5, user.getUrl1());
				ps.setString(6, user.getOnline());
				ps.setString(7, user.getLast_online());
				ps.setString(8, user.getLast_update());
				int result=ps.executeUpdate();
				if(result>0)
					return true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}



		public String getStage() {
			return stage;
		}

		public void setStage(String stage) {
			this.stage = stage;
		}

		public String getUrl1() {
			return url1;
		}

		public void setUrl1(String url1) {
			this.url1 = url1;
		}

		public String getUrl2() {
			return url2;
		}

		public void setUrl2(String url2) {
			this.url2 = url2;
		}

		public String getUrl3() {
			return url3;
		}

		public void setUrl3(String url3) {
			this.url3 = url3;
		}

		public String getOnline() {
			return online;
		}

		public void setOnline(String online) {
			this.online = online;
		}

		public String getLast_online() {
			return last_online;
		}

		public void setLast_online(String last_online) {
			this.last_online = last_online;
		}

		public String getLast_update() {
			return last_update;
		}

		public void setLast_update(String last_update) {
			this.last_update = last_update;
		}

		public boolean check_containID(String ID) throws SQLException{
			String select="SELECT * FROM "+"REGISTER"+" WHERE userid=\""+ID+"\"";
			ResultSet rs=statement.executeQuery(select);
			if(rs==null){
				return false;
			}else
				return true;
		}


		public void Get_DYtable(String ID) {
			ArrayList<String> friends=new ArrayList<String>();
			String select="SELECT * FROM DYNAMIC_TABLE where userid=?";
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				while(resultSet.next()){ 
					System.out.print(resultSet.getString("stage") + " "); 
					System.out.print(resultSet.getString("url1") + " "); 
					System.out.print(resultSet.getString("url2") + " "); 
					System.out.print(resultSet.getString("online") + " "); 
					System.out.println(resultSet.getString("last_update") + " "); 
				} 
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		public ArrayList<String> Get_friends(String ID) {
			ArrayList<String> friends=new ArrayList<String>();
			String select="SELECT * FROM DYNAMIC_TABLE where userid=?";
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				while(resultSet.next()){ 
					friends.add(resultSet.getString("matching_userid"));
				} 
			}catch(Exception e){
				e.printStackTrace();
			}
			return friends;
		}
		//get movies athelete , team and musician.
		public String[] Get_MATM(String ID) {
			String select="SELECT * FROM REGISTER where userid=?";
			String[] matm={"","","",""};
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				while(resultSet.next()){ 
					matm[0]=resultSet.getString("movies");
					matm[1]=resultSet.getString("athelete");
					matm[2]=resultSet.getString("teams");
					matm[3]=resultSet.getString("musician");
				} 
			}catch(Exception e){
				e.printStackTrace();
			}
			return matm;
		}

		//get the user ID's stage
		public String Get_Status(String ID){

			String select="SELECT * FROM DYNAMIC_TABLE where userid=?";
			String status="";
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				if (resultSet.next() ){
					status=resultSet.getString("stage");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return status;
		}

		public String Get_Online(String ID){
			String select="SELECT * FROM DYNAMIC_TABLE where userid=?";
			String status="";
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				if (resultSet.next() ){
					status=resultSet.getString("online");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return status;
		}
		//update the user:ID 's stage 
		public boolean Updata_Stage(String ID,String stage){
			upsql="update DYNAMIC_TABLE set stage=? where userid=?";
			try {
				PreparedStatement ps = conn.prepareStatement(upsql);
				ps.setString(1, stage);
				ps.setString(2, ID);
				int result=ps.executeUpdate();//返回行数或者0
				if(result>0)
					return true;
			} catch (SQLException ex) {
				Logger.getLogger(RDS_connection.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
		}

		public boolean Updata_Online(String ID, String online){
			upsql="update DYNAMIC_TABLE set online=? where userid=?";
			System.out.println("owner ID is "+ID);
			try {
				PreparedStatement ps = conn.prepareStatement(upsql);
				ps.setString(1, online);
				ps.setString(2, ID);
				int result=ps.executeUpdate();//返回行数或者0
				if(result>0)
					return true;
			} catch (SQLException ex) {
				Logger.getLogger(RDS_connection.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
		}
		// this is to get the ID's matching according to the matching list.
		public String Get_Matching_FL(String ID){
//			String select="SELECT * FROM MATCHING_LIST where userid=?";// and matching score is max 
			String select="select * from MATCHING_LIST M where M.userid= ? and M.matching_score= (select MAX(M2.matching_score) from MATCHING_LIST M2 where M2.userid=M.userid)";
			String F_ID="";
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				if (resultSet.next() ){
					F_ID=resultSet.getString("matching_userid");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return F_ID;

		}

		public boolean FL_Insert(String ID,String M_ID, String score){
			String insql="insert into MATCHING_LIST(userid,matching_userid,matching_score) values(?,?,?)";
			if(!ID.equals(M_ID)){
				try {
					PreparedStatement ps=conn.prepareStatement(insql);
					ps.setString(1, ID);
					ps.setString(2, M_ID);
					ps.setString(3, score);
					int result=ps.executeUpdate();
					ps.setString(2, ID);
					ps.setString(1, M_ID);
					ps.setString(3, score);
					result=ps.executeUpdate();
					if(result>0)
						return true;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return false;

		}
		 


		public boolean Update_TimeStamp(String ID,String time){
			upsql="update DYNAMIC_TABLE set time_stamp=? where userid=?";
			try {
				PreparedStatement ps = conn.prepareStatement(upsql);
//				ps.setString(10, ID);
				ps.setString(1, time);
				ps.setString(2, ID);
				int result=ps.executeUpdate();
				if(result>0)
					return true;
			} catch (SQLException ex) {
				Logger.getLogger(RDS_connection.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
		}

		
		//this is to retrieve the device token from REGISTER table by ID
		public String Read_devicetoken(String ID){
			String select="SELECT * FROM REGISTER where userid=?";
			String status="";
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				if (resultSet.next() ){
					//get the device_token field
					status=resultSet.getString("device_token");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return status;
			
		}
		
		//update the device token by ID
		public boolean Update_devicetoken(String ID, String devicetoken){
			upsql="update REGISTER set device_token=? where userid=?";
			try {
				PreparedStatement ps = conn.prepareStatement(upsql);
				ps.setString(1, devicetoken);
				ps.setString(2, ID);
				int result=ps.executeUpdate();
				if(result>0)
					return true;
			} catch (SQLException ex) {
				Logger.getLogger(RDS_connection.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
		}
		
		//this is to read facebook url from table REGISTER according to ID
		public String Read_facebookURL(String ID){
			String select="SELECT * FROM REGISTER where userid=?";
			String url="";
			try {
				PreparedStatement ps=conn.prepareStatement(select);
				ps.setString(1, ID);
				resultSet=ps.executeQuery();
				if (resultSet.next() ){
					//get the device_token field
					url=resultSet.getString("facebook_url");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return url;
		}
		
		//this is to get the matching mate list from the database
		public String match_result(String UserID) throws SQLException{
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String s="";
			try {
				pstmt = conn.prepareStatement(
						"SELECT matching_userid from FRIEND_LIST WHERE userid = ? ");
				pstmt.setString(1, UserID);
				rs=pstmt.executeQuery();
			}
			finally {
				while (rs.next()) {
					s = rs.getString("matching_userid");
				}
				if (pstmt != null) pstmt.close();
			}
			return s;
		}

		public void deleteTable(String tableName) throws SQLException{
			createConnectionAndStatement();
			String delete="drop table "+tableName;
			System.out.println(delete);
			statement.executeUpdate(delete);
		}

		public void create_UserTable(String Tablename)
		{
			try {
				createConnectionAndStatement();
				String createTableSql = "CREATE TABLE "
						+Tablename+" (userid VARCHAR(255) not NULL, gender VARCHAR(255), "
						+ "name VARCHAR(255), age int, password int, url VARCHAR(255) ) ";
				statement.executeUpdate(createTableSql);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//close();
			}

		}

		public void create_PhotoTable(String Tablename)
		{
			try {
				createConnectionAndStatement();
				String createTableSql = "CREATE TABLE "+Tablename+" (userid VARCHAR(255) not NULL, photo_name VARCHAR(255), photo_url VARCHAR(255)) ";
				statement.executeUpdate(createTableSql);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//close();
			}

		}

		public void create_Blur_PhoteTable(String Tablename)
		{
			try {
				createConnectionAndStatement();
				String createTableSql = "CREATE TABLE "+Tablename+" (photo_name VARCHAR(255) not NULL, blur_photo_name VARCHAR(255), blur_photo_url VARCHAR(255)) ";
				statement.executeUpdate(createTableSql);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//close();
			}

		}

		public void create_HearbeatTable(String Tablename)
		{

		}

		public void create_FriendlistTable(String Tablename)
		{

		}

		public void create_GameStageTable(String Tablename)
		{

		}
	}
	public static void main(String args[]) throws SQLException{
		RDS_connection cd=new RDS_connection();
		user user1=cd.new user();
		Connection conn = cd.createConnectionAndStatement();
		//				user1.setUserid("155888");
		//		user1.register_ID(user1);
		//		user user2=cd.new user();
		//				user1.setAge("12");
		//		user1.UpdateUser("155", user2);
		String m=user1.Get_Online("527167503");
		String mm=user1.Get_Matching_FL("527167503");
		
//		user1.FL_Insert("527167503", "599813130", "55");
		//		user1.Updata_Online("599813130", "off");
		//		user1.Updata_Stage("599813130", "mm:");
		System.out.println(mm);
//		user1.FL_Insert("8881", "9991");
		//		user1.register_ID(user1);
		
		user1.Update_devicetoken("599813130", "dd3");
		String mm1= user1.Read_devicetoken("599813130");
		System.out.println(mm1);
		cd.CutConnection(conn);
		//user1.Get_DYtable("599813130");
		//	         user1.DeletUser("155");
		//	         cd.CutConnection(cd.conn);
	}
}


