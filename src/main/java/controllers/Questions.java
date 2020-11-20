package controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Path("question")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)

public class Questions {
    @GET
    @Path("list")
    public String questionList() {
        System.out.println("Invoked question.questionList()");
        JSONArray response = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM Questions");
            ResultSet results = ps.executeQuery();
            while (((ResultSet) results).next()==true) {
                JSONObject row = new JSONObject();
                row.put("QuestionID", results.getInt(1));
                row.put("Question", results.getString(2));
                row.put("Answer", results.getString(3));
                row.put("SubjectID", results.getInt(4));
                response.add(row);
            }
            return response.toString();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"Error\": \"Unable to list items.  Error code 1.\"}";
        }
    }
    @GET
    @Path("getQ")
    public String getQ() {
        System.out.println("Invoked question.questiongetQ()");
        JSONArray response = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT * FROM Questions WHERE QuestionID == ?");
            ResultSet results = ps.executeQuery();
            JSONObject row = new JSONObject();
            row.put("Question", results.getString(1));
            row.put("Answer", results.getString(2));
            return results.toString();
        } catch (Exception exception){
            System.out.println("Database error: " + exception.getMessage());
            return "{\"Error\": \"Unable to list items.  Error code 1.\"}";
        }
    }
}