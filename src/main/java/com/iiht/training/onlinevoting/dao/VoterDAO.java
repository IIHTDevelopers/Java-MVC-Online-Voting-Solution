package com.iiht.training.onlinevoting.dao;

import com.iiht.training.onlinevoting.entity.Models;
import com.iiht.training.onlinevoting.entity.Voter;
import com.iiht.training.onlinevoting.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class VoterDAO {
    @Autowired
    private VoterRepository voterRepository;

    public boolean save(Models models) {
        Voter voter = (Voter) models;
        this.voterRepository.save(voter);
        return true;
    }

    public List<Voter> getAll() {
        return this.voterRepository.findAll();
    }

    public Voter get(int id) {
        return (Voter) this.voterRepository.findById((long) id).get();
    }

    public boolean delete(int id) {
        this.voterRepository.deleteById((long) id);
        return true;
    }

    public Long getVoterId(String name, String password) {
        List<Voter> voterList = getAll();
        for (Voter voter : voterList) {
            if (voter.getVoterName().equals(name) && voter.getVoterPassword().equals(password)) {
                return voter.getVoterId();
            }
        }
        return -1L;
    }
}
