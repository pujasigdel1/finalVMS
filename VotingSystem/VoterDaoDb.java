package VotingSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class VoterDaoDb implements VoterDaoInterface {

	private final static String USERNAME = "root";

    private final static String PASSWORD = "Brishpooja123$";

    private final static String URL = "jdbc:mysql://localhost:3306/voter";
    
    @Override
    public Voter viewAll() throws IOException {
    	Connection con = null;
		Statement statement = null;
		Voter voter = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "SELECT * from voter.voterlist";
			
			//		System.out.println(query);
			
			statement = con.createStatement();
			
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				voter=new Voter();
                voter.setVoterId(results.getInt(1));
                voter.setFirstName(results.getString(2));
                voter.setLastName(results.getString(3));  
                voter.setGender(Gender.getByValue(results.getString(4)));
                LocalDate dob = LocalDate.parse(results.getString(5));
                voter.setDateOfBirth(dob);
                voter.setUsername(results.getString(6));
                voter.setPassword(results.getString(7));
             
                       System.out.println(voter);    
                      
            }

        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                 statement.close();
                con.close();
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
		return voter;
		//return null;

    }
public void addTable() {
    	
	Connection con = null;
    Statement statement = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    //	String query = "Create table if not exists emp1 (id int not null, fistname varchar(20) not null)";

        StringBuilder query1 = new StringBuilder();
//   query1.append("Create table if not exists emp1 (id int not null, fistname varchar(20) not null)");

        statement = con.createStatement();
        statement.execute(query1.toString());

    }
    catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        try {
            statement.close();
            con.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

@Override
public Voter searchById(Integer id) throws IOException {
	
	
    return null;
}

@Override
public void editVoterlist(Voter voter) throws IOException {

}

@Override
public Voter voterRegistration(Voter voter) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String insertQuery = "INSERT INTO voterlist (first_name, last_name,gender,dateofbirth,username,password)"
                + "value ( '" + voter.getFirstName() + "', '" + voter.getLastName() + "','" + voter.getGender() + "'," +
                "'" + voter.getDateOfBirth() + "','" + voter.getUsername() + "','" + voter.getPassword() + "')";

        System.out.println(insertQuery);

        Statement statement = con.createStatement();
        int resultValue = statement.executeUpdate(insertQuery);



        if (resultValue == 2) {
            System.out.println("Failed to insert/update data. Check your data and try again.");
        }

        statement.close();
        con.close();

        return voter;

    }



@Override
public Voter searchByUsernameAndPassword(String username, String password) throws IOException {
    Connection con = null;
    Statement statement = null;
   Voter voter = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String query = "select * from voterlist where username ='" +username +"' and password='"+password+"'";
        System.out.println(query);


        statement = con.createStatement();
        ResultSet results = statement.executeQuery(query);



        while (results.next()) {
            voter = new Voter();
            voter.setVoterId(results.getInt(1));
            voter.setFirstName(results.getString(2));
            voter.setLastName(results.getString(3));
            voter.setUsername(results.getString(4));
            voter.setPassword(results.getString(5));
        }
    }
    catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        try {
            statement.close();
            con.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    return voter;

}

@Override
public Voter searchByUsername(String username) throws IOException {
    return null;
}

@Override
public void candidatesList() throws IOException {
    Connection con = null;
    Statement statement = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String query = "SELECT * from candidatelist" ;

       			System.out.println(query);

        statement = con.createStatement();

        ResultSet results = statement.executeQuery(query);

        while (results.next()) {

            System.out.println(results.getInt(1));
            System.out.println(results.getString(2));
            System.out.println(results.getString(3));

        }

    }
    catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    finally {
        try {
            statement.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

    }
