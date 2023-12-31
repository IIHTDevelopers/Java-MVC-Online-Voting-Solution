package com.iiht.training.onlinevoting.controller;

import com.iiht.training.onlinevoting.dao.OptionDAO;
import com.iiht.training.onlinevoting.dao.PollDAO;
import com.iiht.training.onlinevoting.entity.Poll;
import com.iiht.training.onlinevoting.entity.PollOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/pollOption")
public class OptionController {
    @Autowired
    OptionDAO optionDAO;
    @Autowired
    PollDAO pollDAO;
    @RequestMapping("/add/{id}")
    public String addOptionPage(@PathVariable("id") int id,Model model) {
        Poll poll = pollDAO.get(id);
        List<PollOption> pollOptions = optionDAO.getOptionByPollId(id);
        model.addAttribute("poll",poll);
        model.addAttribute("options",pollOptions);
        return "addOption";
    }
    @RequestMapping("/handleForm")
    public String addOptionHandleForm(@Valid @ModelAttribute PollOption pollOption, @RequestParam("pollId") int id) {
        pollOption.setPollId(id);
        optionDAO.save(pollOption);
        return "redirect:add/"+id;
    }
    @RequestMapping("/toVote/{id}")
    public String displayOptionsToVoter(@PathVariable("id") int pollId,Model model) {
        Poll poll = pollDAO.get(pollId);
        List<PollOption> pollOptions = optionDAO.getOptionByPollId(pollId);
        model.addAttribute("poll",poll);
        model.addAttribute("options",pollOptions);
        return "optionsToVote";
    }
}
