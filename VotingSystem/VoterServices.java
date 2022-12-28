package VotingSystem;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class VoterServices {
    public void viewAll() throws IOException {
        VoterDaoInterface dao = new VoterDaoDb();
        dao.viewAll();
    }

    /**
     * Search employee by id
     *
     * @param
     * @return
     * @throws IOException
     */


    public Voter votingProcess(String username, String password) throws IOException {
        VoterDaoInterface dao = new VoterDaoDb();
        return dao.searchByUsernameAndPassword(username, password);
    }

    public void doVoteNow(Integer voterId, Integer symbol) throws SQLException, ClassNotFoundException {
        try {
            VoteRecordDb dao = new VoteRecordDb(voterId, symbol);
            dao.doVote(voterId, symbol);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            System.out.println("Faild to registered you already vote");
        }
    }


    /**
     * Method to view current employee
     */

    public void candidatesList() {
        System.out.println("For Election 2023 Registered Party is given below ");
        VoterDaoInterface dao = new VoterDaoDb();
        try {
            dao.candidatesList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Edit employee profile
     *
     * @param voter
     * @throws IOException
     */

    public Voter voterRegistration(Voter voter) throws IOException, SQLException, ClassNotFoundException {
        VoterDaoInterface dao = new VoterDaoDb();

        dao.voterRegistration(voter);

        System.out.println("Voter Register successfully!");
        return voter;
    }

    public boolean checkIfUserNameExists(String username) {


        VoterDaoInterface dao = new VoterDaoDb();
        Voter voter = null;
        try {
            voter = dao.searchByUsername(username);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Some issue occurred");
            e.printStackTrace();
        }
        if (voter == null) {
            return false;
        } else {
            return true;
        }
    }

    public void finalResult() throws SQLException, ClassNotFoundException {
        VoteRecordDb result = new VoteRecordDb();
        {
            result.voteCount();

        }


    }
}