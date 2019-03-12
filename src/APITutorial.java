import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class APITutorial {
	
	static int count=0;
	static File file = new File("PhabFilterList.csv");
	static FileWriter fw;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws JSONException, IOException {
		// TODO api to find top trends and list 
		String con = makeURL(args);
		JsonObject json = getJson(con);
		printObj(json);
		// TODO find trends related to one keyword input
		// TODO make window pop up
		System.out.println("Hellow World!");
	}
	
	public static String makeURL (String[] args) {
		String url="";
		return url;
	}
	public static void setConnection(String args, String initLink, Boolean j) throws IOException, JSONException{
		String link = initLink;
		if (j)
			link = link + "&constraints[projects][1]=" + args.replace("(", " ").replace(" ", "_").replace(")","").toLowerCase();
	}
	public static JsonObject getJson(String initLink) throws JSONException, IOException{
		URL url;
		HttpURLConnection con;
		JsonReader in;
		JsonObject json;
		String link = initLink;
		// make connection
		url = new URL(link);
		con = (HttpURLConnection) url.openConnection();
		int responseCode = con.getResponseCode();

		// printing response of connection status
//		System.out.println("Sent 'GET' request to URL: \n" + link);
		System.out.println("Received response code: " + responseCode + "\n");
			
		// read requested json
		in = new JsonReader(new InputStreamReader(con.getInputStream()));
		
		// return json
		json = new Gson().fromJson(in, JsonObject.class);
		json = json.getAsJsonObject("result");
		return json;
	}
	public static void printObj (JsonObject obj) {
		
	}
}