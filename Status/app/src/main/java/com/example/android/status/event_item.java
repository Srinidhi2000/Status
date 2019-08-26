package com.example.android.status;

import com.google.gson.annotations.SerializedName;

public class event_item {
    private String dept1,dept2,dept1_score,dept2_score,id,name;
    private String type;
    private String score;
    private String start_time,venue,winner,hint;
    private String[] participating_teams;

    public event_item( String id, String name/*,
                       String dept1, String dept2, String dept1_score, String dept2_score,String type, String score, String start_time, String venue, String winner, String hint, String[] participating_teams*/) {
        this.id = id;
        this.name = name;
        /*this.dept1 = dept1;
        this.dept2 = dept2;
        this.dept1_score = dept1_score;
        this.dept2_score = dept2_score;
        this.type = type;
        this.score = score;
        this.start_time = start_time;
        this.venue = venue;
        this.winner = winner;
        this.hint = hint;
        this.participating_teams = participating_teams;*/
    }

    public String getDept1() {
        return dept1;
    }

    public String getDept2() {
        return dept2;
    }

    public String getDept1_score() {
        return dept1_score;
    }

    public String getDept2_score() {
        return dept2_score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getScore() {
        return score;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getVenue() {
        return venue;
    }

    public String getWinner() {
        return winner;
    }

    public String getHint() {
        return hint;
    }

    public String[] getParticipating_teams() {
        return participating_teams;
    }
}
