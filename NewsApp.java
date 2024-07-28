import java.io.*;
import java.util.*;
import java.net.*;

public class NewsApp{
    private static final String apikey="Your Apikey"; // https://newsapi.org - get the your apikey usinng this websites
    private static final String baseurl="https://newsapi.org/v2/top-headlines?";

    public static void main(String[] args) {
        
        try {
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter your category : (ex:sports,technology)");
            String cat=scan.nextLine();
            String apiurl=baseurl+"category="+cat+"&language=en&apikey="+apikey;
            //req
            HttpURLConnection con=(HttpURLConnection) new URL(apiurl).openConnection();
            con.setRequestMethod("GET");

            //res
            BufferedReader r=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line,json="";
            while ((line =r.readLine())!=null)json+=line;
            r.close();

            int index=0;
            while((index=json.indexOf("\"title\":\"",index))!=-1){
                int endindex=json.indexOf("\"",index+9);
                System.out.println("Title : "+json.substring(index+9,endindex));
                index=endindex+1;
            }
            
        } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        }
    }
}