package com.ke.adc.chief_experience_officer.web;

import com.ke.adc.chief_experience_officer.dao.model.Rank;
import com.ke.adc.chief_experience_officer.service.ranking.RankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rank")
public class RankController {
    private RankService rankService;
    @RequestMapping("/getRankings")
    @ResponseBody
    public List<Rank> getRankings() {
        return rankService.searchRanking();
    }

    @RequestMapping("/useScore")
    @ResponseBody
    public Integer useScore(@RequestParam Integer id, @RequestParam Integer score) {
        rankService.useScore(id,score);
        return 1;
    }
}
