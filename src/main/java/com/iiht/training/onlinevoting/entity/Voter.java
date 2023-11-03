package com.iiht.training.onlinevoting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Voter implements Models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voterId;
    @NotBlank
    @Size(min = 3, max = 50)
    private String voterName;

    @NotBlank
    @Size(min = 8, max = 20)
    private String voterPassword;

    public Long getVoterId() {
        return voterId;
    }

    public void setVoterId(Long voterId) {
        this.voterId = voterId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterPassword() {
        return voterPassword;
    }

    public void setVoterPassword(String voterPassword) {
        this.voterPassword = voterPassword;
    }
}
