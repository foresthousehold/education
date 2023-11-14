package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AccountDetails;
import com.example.demo.entity.Memo;
import com.example.demo.entity.User;
import com.example.demo.repository.MemoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/memo")
public class MemoController {
    @Autowired
    MemoRepository memoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    /** メモ管理画面を表示します。 */
    @GetMapping({ "/", "/{memoId}" })
    public String memo(
            @AuthenticationPrincipal AccountDetails accountDetails,
            @PathVariable(name = "memoId", required = false) Long memoId,
            Model model) throws Exception {
        final User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
        // ユーザIDに紐づくメモを全て取得する
        final List<Memo> memos = Optional.ofNullable(memoRepository.findByUserId(user.getId())).orElse(null);

        // パラメータからIdに紐づくメモを取得します
        final Memo memoDetail = memos.stream().filter(m -> m.getId().equals(memoId)).findFirst().orElse(null);

        model.addAttribute("memos", memos);
        model.addAttribute("memoDetail", memoDetail);
        model.addAttribute("profileForm", userService.createProfileForm(user));
        return "memo/memo";
    }

}
