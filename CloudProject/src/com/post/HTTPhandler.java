package com.post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matching.Interest;
import matching.Users;
import rds.connection.RDS_connection;
import rds.connection.RDS_connection.user;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.amazonaws.util.json.JSONTokener;
//Network interface: The word in the () is the key or key:value.
//
//1. register: (ID, name, gender, photourl, age, movies[], favorites[]) ——> respond:(OK);
//
//2. update:(ID, pushrecv[]: pushID) ——>respond:(OK, missedmatch[]: (ID, name, gender,  age, blurphoto, common, rate,piechart[] ) ); Send after the first heartbeat when come back and get pushID
//
//3. friendlist:(ID) ——> respond:userself, friendlist[](ID, name gender, photourl, age, movies[], favorites[], rate, piechart[])  first one is for the user himself; Send when game finished.
//
//4. heartbeat:(ID, status{ online, offline, playing, pushrecv: pushID}) Send every 4s in normal mode——>respond:(OK, matchrequest(optional): (ID, name, gender,  age, blurphoto, common, rate,piechart[] ) );
//
//5. match:(ID, answer:ID, fliter); ——> respond:(ID, blurphoto, commoninterest, rate,piechart[] ); if it is responing to a match, then Answer is not "", for server, if an request expired, then send a respond with empty ID back to the user.
//
//6. gamemode:(ID, command, detail) Commandlist: {submit:answer, start:ID(mate’s), quit, nothing}  Send every second——> respond:(status, ID, blurphoto, gamepic, stage) status:{ continue, success, fail, quit})
//Upon success, the document of the new connection’s info is append in the respond

public class HTTPhandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean run=true;
	public HTTPhandler() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObject = new JSONObject();
		StringBuffer jsonbuffer = new StringBuffer();
		String line = null;

		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jsonbuffer.append(line);
		} catch (Exception e) { /* report an error */
		}

		try {
			jsonObject = new JSONObject(new JSONTokener(jsonbuffer.toString()));
			JSONObject JSONrespon = parseRequest(jsonObject);// handle
			// jsonobject
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(JSONrespon);
			out.flush();

		} catch (JSONException e1) {
			// TODO Auto-generated catch block

			PrintWriter out = response.getWriter();
			out.println("Format error");
			out.flush();
			e1.printStackTrace();
		} catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.println("SQL exception");
			out.println(e);
			out.flush();
			e.printStackTrace();
		}
		response.getWriter().close();
	}

	public static JSONObject register(JSONObject json)throws JSONException, SQLException, IOException {
		JSONObject obj = json.getJSONObject("register");
		String ID = obj.getString("ID");
		String name = obj.getString("name");
		String age = obj.getString("age");
		String photo = obj.getString("photourl");
		String movies = obj.getString("movies");
		JSONObject favorites = obj.getJSONObject("favorites");
		String athelete="";
		String team="";
		String musician="";
		String personality="nice person";
		if(favorites.has("athlete")){
			athelete=favorites.getString("athlete");
		}
		if(favorites.has("team")){
			team=favorites.getString("team");
		}
		if(favorites.has("musician")){
			musician=favorites.getString("musician");
		}
		System.out.println("register 1");
		RDS_connection rds=new RDS_connection();
		user user1=rds.new user();
		rds.createConnectionAndStatement();
		Image_process image=new Image_process();
		System.out.println("register 2");

		String stage="-1";
		String url1="";
		String url2="";
		String url3="";
		String online_status="online";
		String last_online="";
		String last_update="";


		user1.setUserid(ID);
		user1.setUsername(name);
		user1.setAge(age);

		user1.setPhoto(photo);
		user1.setMovies(movies);
		user1.setAthelete(athelete);
		user1.setTeams(team);
		user1.setMusician(musician);
		user1.setPersonality(personality);
		user1.setUrl1(url1);
		user1.setUrl1(url2);
		user1.setUrl1(url3);
		user1.setOnline(online_status);
		user1.setLast_online(last_online);
		user1.setLast_update(last_update);
		user1.setStage(stage);

		long current_time=System.currentTimeMillis();
		String time=""+current_time;

		System.out.println("time is liguifan"+time);
		URL url = new java.net.URL(photo);
		HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
		httpURLConnection.setInstanceFollowRedirects( false );
		httpURLConnection.connect();
		String header = httpURLConnection.getHeaderField("Location");
		httpURLConnection.disconnect();

		System.out.println("the redirected path is "+header);


		try{
			System.out.println("start register");
			user1.register_ID(user1);
			System.out.println("finish register1");
			user1.update_DynamicStatus(user1);
			System.out.println("finish register2");
			image.RetrieveImage2S3(header, ID);
			System.out.println("finish register3");
			image.upload_Gaussian(header);
			System.out.println("finish register4");
		}
		catch(NullPointerException e2){
			System.out.println("register error liguifan");
			JSONObject respon = new JSONObject();
			JSONObject temp = new JSONObject();
			temp.put("OK", "Success");
			respon.put("respond", temp);
			return respon;


		}
		rds.CutConnection(rds.getConn());
		System.out.println("register error rds conn");
		JSONObject respon = new JSONObject();
		JSONObject temp = new JSONObject();
		temp.put("OK", "Success");
		respon.put("respond", temp);
		return respon;
	}





	public static JSONObject update(JSONObject json)throws JSONException {
		JSONObject obj = json.getJSONObject("update");
		String ID = obj.getString("ID");
		JSONArray pushrecv = obj.getJSONArray("pushrecv");

		JSONObject respon = new JSONObject();
		JSONObject temp = new JSONObject();
		JSONArray missedmatch =new JSONArray();
		temp.put("OK", pushrecv.length());
		temp.put("missedmatch", missedmatch);
		respon.put("respond", temp);
		return respon;
	}


	public static JSONObject friendlist(JSONObject json)throws JSONException {
		JSONObject obj = json.getJSONObject("friendlist");
		String ID = obj.getString("ID");

		JSONObject respon = new JSONObject();
		JSONObject temp = new JSONObject();
		JSONArray friendlist =new JSONArray();
		JSONObject self = new JSONObject();
		self.put("ID", "123123123");
		temp.put("userself", self);
		temp.put("friendlist", friendlist);
		respon.put("respond", temp);
		return respon;
	}

	public static JSONObject heartbeat(JSONObject json)throws JSONException {
		JSONObject obj = json.getJSONObject("heartbeat");
		String ID = obj.getString("ID");
		String status = obj.getString("status");
		//		if(status.equals("online")){}
		//		else if(status.equals("offline")){}
		//		else if(status.equals("playing")){}
		//		else {   }// the string is pushID

		JSONObject respon = new JSONObject();
		JSONObject temp = new JSONObject();
		JSONObject self = new JSONObject();
		String common_interests="";
		String rate="";
		RDS_connection rds=new RDS_connection();
		rds.createConnectionAndStatement();
		user user_t=rds.new user();

		if(status.equals("online")){
			System.out.println("in the status online loop 1");
			String mate="";
			boolean m=user_t.Updata_Online(ID, "online");
			System.out.println("check update re "+m);
			String stage=user_t.Get_Status(ID);
			System.out.println("stage is "+stage);
			mate=user_t.Get_Matching_FL(ID);


			if(stage.equals("quit")){
				temp.put("OK", "quit");
				user_t.Updata_Stage(ID, "-1");
			}else if(stage.equals("-1") || stage.equals("ready") || stage.equals("wait")){
				String mate_stage=user_t.Get_Status(mate);


				if(stage.equals("ready") && mate_stage.equals("0") ){
					System.out.println("in pregame model");
					temp.put("OK", "enter");
					user_t.Updata_Stage(ID, "0");
				}else
				{
					temp.put("OK", "ID is "+ID+"stage is "+stage+"mate is"+mate+" mate stage is "+mate_stage);
				}
			}else if(stage.equals("respond")){


				System.out.println("respond liguifan 1");
				user_t.Updata_Stage(ID, "wait");
				//mate=user_t.Get_Matching_FL(ID);
				System.out.println("mate is respond"+mate);
				temp.put("OK", mate);

				String[] M1=user_t.Get_MATM(ID);
				String[] M2=user_t.Get_MATM(mate);
				common_interests=Interest.match_interest(M1,M2);
				System.out.println("respond liguifan 2");

				System.out.println("common interest is "+common_interests);
				JSONObject matchrequest = new JSONObject();
				matchrequest.put("ID", mate);
				matchrequest.put("commoninterest", common_interests);
				System.out.println("respond liguifan 3");
				//				rate=""+Interest.match_score(common_interests);
				if(rate.length()==0){
					rate="eeeeeeeeee";
				}
				matchrequest.put("rate", rate);
				temp.put("matchrequest", matchrequest);
				//temp.put("blurphoto", blurphoto);
				//temp.put("piechart[]", piechart);
			}
			else if(stage.equals("wait")) {
				temp.put("OK", "nothing+s2");
			}
			//			else 
			//			{
			//				
			//                boolean mm = user_t.Updata_Stage(ID, "-1");
			//                temp.put("OK", ID+"quit"+mm);
			//			}
		}

		try {
			rds.CutConnection(rds.getConn());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp.put("OK", ID);
		respon.put("respond", temp);
		return respon;
	}


	//answer can be "quit","new"
	public static JSONObject match(JSONObject json)throws JSONException {
		JSONObject obj = json.getJSONObject("match");
		String ID = obj.getString("ID");
		String answer = obj.getString("answer");
		String stage="";
		String common_interests="";
		JSONObject respon = new JSONObject();
		JSONObject temp = new JSONObject();

		Interest interest=new Interest();
		RDS_connection rds=new RDS_connection();
		rds.createConnectionAndStatement();
		user user_t=rds.new user();

		//		if(!answer.equals("quit")){
		//			String ID_matching=answer;
		//			String[] M1=user_t.Get_MATM(ID);
		//			String[] M2=user_t.Get_MATM(ID_matching);
		//			common_interests=Interest.match_interest(M1,M2);
		//			temp.put("commoninterest", "common_interests");
		//		}else {
		//
		//		}


		String mate="";
		stage=user_t.Get_Status(ID);
		System.out.println("ID stage is "+stage+ID);
		if(answer.equals("new")){// user request a new match
			temp.put("OK", "inside whole:");
			//call ML algorithm
			System.out.println("answer is in"+ID);
			mate= interest.ML_matching(ID);

			//we should get mathing score according to ID and mate.

			String[] M1=user_t.Get_MATM(ID);
			String[] M2=user_t.Get_MATM(mate);
			common_interests=Interest.match_interest(M1,M2);
			String score = ""+Interest.match_score(common_interests);
			if(score.length()>0){
				user_t.FL_Insert(ID, mate,score);}
			else{
				user_t.FL_Insert(ID, mate,"0");
			}
			if(stage.equals("-1")){
				System.out.println("answer new, ID status=-1");
				user_t.Updata_Online(ID, "online");
				user_t.Updata_Stage(ID, "wait");
				stage="wait";
				user_t.Updata_Stage(mate, "respond");
				String time =""+ System.currentTimeMillis();
				user_t.Update_TimeStamp(ID, time);
				user_t.Update_TimeStamp(mate, time);
				temp.put("ID",ID);
				temp.put("OK", "wait");
			}else{
				System.out.println("wrong");
			}
		}else if(answer.equals("quit")) {
			mate=user_t.Get_Matching_FL(ID);
			user_t.Updata_Stage(ID, "-1");
			user_t.Updata_Stage(mate, "quit");
			temp.put("OK","OK+liguifan");
		}else{
			mate=user_t.Get_Matching_FL(ID);
			if(stage.equals("quit")){
				user_t.Updata_Stage(ID, "-1");
				temp.put("OK", "quit");
			}else if (stage.equals("wait")) {
				temp.put("OK", "sdddd");
				String mate_stage=user_t.Get_Status(mate);

				if(!mate_stage.equals("ready")){
					user_t.Updata_Stage(ID, "ready");
					temp.put("OK", "mate 's status "+user_t.Get_Status(mate)+"mate is "+mate);
				}else{
					System.out.println("enter mate_ready stage "+mate);
					temp.put("OK", "enter");
					user_t.Updata_Stage(ID, "0");
				}
			}
		}

		respon.put("respond", temp);
		return respon;
	}

	public static JSONObject gamemode(JSONObject json)throws JSONException {
		JSONObject obj = json.getJSONObject("gamemode");
		String ID = obj.getString("ID");
		String command = obj.getString("command");
		String detail = obj.getString("detail");

		JSONObject respon = new JSONObject();
		JSONObject temp = new JSONObject();
		if(command.equals("submit")){  String answer = detail;}
		else if(command.equals("start")){String matchID = detail;}
		else if(command.equals("quit")){ }//quit
		else {   }// nothing
		temp.put("stage", "2");
		temp.put("status", "continue");
		respon.put("respond", temp);
		return respon;
	}

	public static JSONObject parseRequest(JSONObject json) throws JSONException, SQLException, IOException {
		if (json.has("register")) {
			JSONObject respon = register(json);
			return respon;
		}
		else if (json.has("register")) {
			JSONObject respon = register(json);
			return respon;
		}
		else if (json.has("update")) {
			JSONObject respon = update(json);
			return respon;
		}
		else if (json.has("friendlist")) {
			JSONObject respon = friendlist(json);
			return respon;
		}
		else if (json.has("heartbeat")) {
			JSONObject respon = heartbeat(json);
			return respon;
		}
		else if (json.has("match")) {
			JSONObject respon = match(json);
			return respon;
		}
		else if (json.has("gamemode")) {
			JSONObject respon = gamemode(json);
			return respon;
		}
		else{
			JSONObject respon = new JSONObject();
			JSONObject temp = new JSONObject();
			temp.put("OK", "no");
			respon.put("respond", temp);
			return respon;
		}
	}
}