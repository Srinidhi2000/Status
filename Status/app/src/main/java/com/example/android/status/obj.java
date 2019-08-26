package com.example.android.status;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class obj implements Serializable {
private String dept1,dept2,dept1_score,dept2_score,id,name;
@SerializedName("elimination_type")
private String type;
@SerializedName("score_timestamp")
private String score;
private String start_time,venue,winner,hint;
private String[] participating_teams;

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
