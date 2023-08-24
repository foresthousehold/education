package com.example.demo.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccountDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
public class QuestRestController {

    @Autowired
    UserRepository userRepository;

    /*
     * 利用者の合計経験値を更新します
     */
    @GetMapping("/update")
    public void upDateExperience(
        @AuthenticationPrincipal AccountDetails accountDetails,
        @RequestParam Long userExperience) {

            User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);

            user.setTotalExperience(userExperience);
            userRepository.save(user);
    }
}
