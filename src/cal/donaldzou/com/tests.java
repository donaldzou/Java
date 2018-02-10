package cal.donaldzou.com;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

        import org.json.JSONArray;
        import org.json.JSONObject;
        import java.util.*;
public class tests {

    public static void main(String[] args) {

        try {
            tests.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void call_me() throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("User Name:");
        String username = keyboard.nextLine();
        String username_link = "username="+username+"";
        System.out.print("Password:");
        String password = keyboard.nextLine();
        String password_link = "password="+password+"";
        String base = "https://rns.myschoolapp.com/api";
        System.out.println("Loading...");
        System.out.println("");

        String auth_url = ""+base+"/authentication/login/?"+username_link+"&"+password_link+"";
        URL auth_obj = new URL(auth_url);
        HttpURLConnection auth_con = (HttpURLConnection) auth_obj.openConnection();
        // optional default is GET
        auth_con.setRequestMethod("GET");

        int responseCode = auth_con.getResponseCode();
        //System.out.println("Sending 'GET' request to URL : " + auth_url);
        //System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(auth_con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());

        //System.out.println("Token:"+myResponse.getString("Token")+"");
        String token = myResponse.getString("Token");
        String token_link = "t="+token+"";
        int userid = myResponse.getInt("UserId");










        //Get USer

        String get_user_url = ""+base+"/user/"+userid+"/?"+token_link+"";
        URL get_user_obj = new URL(get_user_url);
        HttpURLConnection get_user_con = (HttpURLConnection) get_user_obj.openConnection();
        // optional default is GET
        get_user_con.setRequestMethod("GET");

        //System.out.println("Sending 'GET' request to URL : " + get_user_url);
        System.out.println("");
        BufferedReader get_user_in = new BufferedReader(
                new InputStreamReader(get_user_con.getInputStream()));
        String get_user_inputLine;
        StringBuffer get_user_response = new StringBuffer();
        while ((get_user_inputLine = get_user_in.readLine()) != null) {
            get_user_response.append(get_user_inputLine);
        }
        get_user_in.close();
        //print in String
        //Read JSON response and print
        JSONObject get_user_myResponse = new JSONObject(get_user_response.toString());

        String name = "Name: "+get_user_myResponse.getString("FirstName")+" "+get_user_myResponse.getString("LastName")+"";
        System.out.println(name);
        System.out.println("");





        String get_class_url = ""+base+"/schedule/MyDayCalendarStudentList/?scheduleDate=&personaId=2&"+token_link+"";
        URL get_class_obj = new URL(get_class_url);
        HttpURLConnection get_class_con = (HttpURLConnection) get_class_obj.openConnection();
        // optional default is GET
        get_class_con.setRequestMethod("GET");

        //System.out.println("Sending 'GET' request to URL : " + get_user_url);
        System.out.println("");
        BufferedReader get_class_in = new BufferedReader(
                new InputStreamReader(get_class_con.getInputStream()));
        String get_class_inputLine;
        StringBuffer get_class_response = new StringBuffer();
        while ((get_class_inputLine = get_class_in.readLine()) != null) {
            get_class_response.append(get_class_inputLine);
        }
        get_class_in.close();
        //print in String
        //Read JSON response and print
        JSONArray get_class_myResponse = new JSONArray(get_class_response.toString());

        //String  = "Name: "+get_user_myResponse.getString("FirstName")+" "+get_user_myResponse.getString("LastName")+"";



        int course = get_class_myResponse.length();

        for (int i = 0; i < course; i++){
            String course_name = get_class_myResponse.getJSONObject(i).getString("CourseTitle");
            String course_location = ""+get_class_myResponse.getJSONObject(i).getString("RoomNumber")+" - "+get_class_myResponse.getJSONObject(i).getString("BuildingName")+"";
            String course_time = ""+get_class_myResponse.getJSONObject(i).getString("MyDayStartTime")+" - "+get_class_myResponse.getJSONObject(i).getString("MyDayEndTime")+"";
            int k = i+1;
            System.out.println(""+k+" - "+course_name+"");
            System.out.print("    Location: "+course_location+" | ");
            System.out.println("Time: "+course_time+"");
            System.out.println("");

        }







    }
}

