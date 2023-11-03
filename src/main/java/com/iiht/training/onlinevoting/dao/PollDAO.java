package com.iiht.training.onlinevoting.dao;

import com.iiht.training.onlinevoting.entity.Models;
import com.iiht.training.onlinevoting.entity.Poll;
import com.iiht.training.onlinevoting.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
public class PollDAO{
    @Autowired
    private PollRepository pollRepository;

    @Transactional
    public boolean save(Models models) {
        Poll poll = (Poll) models;
        this.pollRepository.save(poll);
        return true;
    }

    public Poll get(int id) {
        return (Poll) this.pollRepository.findById((long)id).get();
    }

    public List<Poll> getAll() {
        return this.pollRepository.findAll();
    }

    @Transactional
    public boolean delete(int id) {
        this.pollRepository.deleteById((long)id);
        return true;
    }
    @Transactional
    public boolean update(Models models) {
        Poll poll = (Poll) models;
        this.pollRepository.save(poll);
        return true;
    }

}
