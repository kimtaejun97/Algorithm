package hackerrank.api;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TotalGoals {
    public static void main(String[] args) throws IOException, ScriptException {
        String year = "2011";
        String team = "Barcelona";

        StringBuilder baseURL = new StringBuilder();
        baseURL.append("https://jsonmock.hackerrank.com/api/football_matches?");
        baseURL.append("year=").append(year).append("&");


        int team1TotalGoals = getTotalGoals(baseURL.toString(), "team1", URLEncoder.encode(team), 1);
        int team2TotalGoals = getTotalGoals(baseURL.toString(), "team2", URLEncoder.encode(team), 1);

        System.out.println(year + " " + team + " Total Golas: " + (team1TotalGoals + team2TotalGoals));
    }

    private static int getTotalGoals(String baseURL, String team, String teamName, int page) throws IOException, ScriptException {
        StringBuilder urlBuilder = new StringBuilder();

        urlBuilder.append(baseURL)
                .append(team).append("=").append(teamName);

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content_Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        int status = con.getResponseCode();
        if(status == HttpURLConnection.HTTP_MOVED_PERM
                || status == HttpURLConnection.HTTP_MOVED_TEMP){
            String location = con.getHeaderField("Location");
            URL newURL = new URL(location);
            con = (HttpURLConnection) newURL.openConnection();
        }

        InputStream is;
        if(status < 200 || status > 299) is = con.getErrorStream();
        else is = con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer res = new StringBuffer();
        String line;
        while((line = br.readLine()) != null){
            res.append(line);
        }

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("javascript");

        StringBuilder script = new StringBuilder();
        script.append("var res = JSON.parse('").append(res.toString()).append("');");
        script.append("var totalPages = res.total_pages;");
        script.append("var totalGoals = res.data.reduce(function(acc, curr){return acc + parseInt(curr.")
                .append(team).append("goals);}, 0);");

        engine.eval(script.toString());

        int totalPage = (int)engine.get("totalPages");
        int totalGoals = (int)engine.get("totalGoals");

        if(page < totalPage) return totalGoals + getTotalGoals(baseURL, team, teamName, page+1);
        return totalGoals;
    }
}
