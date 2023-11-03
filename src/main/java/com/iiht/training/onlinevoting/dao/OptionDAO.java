package com.iiht.training.onlinevoting.dao;

import com.iiht.training.onlinevoting.entity.Models;
import com.iiht.training.onlinevoting.entity.PollOption;
import com.iiht.training.onlinevoting.repository.PollOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class OptionDAO {
    @Autowired
    private PollOptionRepository pollOptionRepository;

    @Transactional
    public boolean save(Models models) {
        PollOption pollOption = (PollOption) models;
        this.pollOptionRepository.save(pollOption);
        return true;
    }

    public List<PollOption> getAll() {
        return this.pollOptionRepository.findAll();
    }

    public Object get(int id) {
        return this.pollOptionRepository.findById((long) id).get();
    }

    public List<PollOption> getOptionByPollId(int pollId) {
        return pollOptionRepository.findByPollId(pollId);
    }

    public boolean delete(int id) {
        this.pollOptionRepository.deleteById((long) id);
        return true;
    }

}
