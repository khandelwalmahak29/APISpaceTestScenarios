import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest 
{
	private static final String USER_AGENT = "Mozilla/5.0";  
	private static final String GET_URL = "https://api.spacexdata.com/v4/launches/latest";
	
	
	//Can validate the response from DB or can convert into json and check for any key value.
	/*
	 *1. Validate the response Status is 200
      2. Verify all the keys and values in json response(response payload from postman)
      3. Verify the mandatory fields are not null 
	 */
	
	//The below functions checks the status 200 and takes the response in  String
	
	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
            
			// print result
			System.out.println(response.toString());
		} else 
		{
			System.out.println("GET request not worked");
		}
  
	}

	public static void main (String args[]) throws IOException
	{
		sendGET();
		
	}
	
}
