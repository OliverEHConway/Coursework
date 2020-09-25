package controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Main;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

@Path("user")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)

public class Login {
    @GET
    @Path("get/{UserID}")
    public String userList(@PathParam("UserID") Integer UserID) {
        System.out.println("Invoked user.getUser()");
        JSONArray response = new JSONArray();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        boolean e = true;
        while (e == true) {
            try {
                int ID = input.nextInt();
                e = false;
            } catch (Exception exception) {
                System.out.println("Input error");
            }
        }
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT Username, Password FROM Users WHERE UserID = ID");
            ResultSet results = ps.executeQuery();
            while (((ResultSet) results).next()==true) {
                JSONObject row = new JSONObject();
                row.put("UserID", results.getInt(1));
                row.put("Username", results.getString(2));
                row.put("Email", results.getString(3));
                row.put("Teacher", results.getBoolean(4 ));
                row.put("Password", results.getString(5));
                response.add(row);
            }
            return response.toString();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"Error\": \"Unable to list items.  Error code 1.\"}";
        }
    }
}

