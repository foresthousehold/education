package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AccountDetails;
import com.example.demo.entity.Memo;
import com.example.demo.entity.User;
import com.example.demo.model.form.MemoForm;
import com.example.demo.model.form.ModalMemoForm;
import com.example.demo.repository.MemoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MemoService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/memo")
public class MemoController {
    @Autowired
    MemoRepository memoRepository;

    @Autowired
    MemoService memoService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    /**
     * メモ管理画面を表示します。
     */
    @GetMapping({ "/", "/{memoId}" })
    public String memo(
            @AuthenticationPrincipal AccountDetails accountDetails,
            @PathVariable(name = "memoId", required = false) Long memoId,
            Model model) throws Exception {
        final User user = userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new);
        // ユーザIDに紐づくメモを全て取得する
        final List<Memo> memos = Optional.ofNullable(memoRepository.findByUserId(user.getId())).orElse(null);

        // パラメータからIdに紐づくメモを取得します
        final Memo memo = memos.stream().filter(m -> m.getId().equals(memoId)).findFirst().orElse(null);

        // メモフォームの作成
        final MemoForm memoForm = memoService.createMemoForm(memo);

        model.addAttribute("memos", memos);
        model.addAttribute("memoForm", memoForm);
        model.addAttribute("profileForm", userService.createProfileForm(user));
        model.addAttribute("modalMemoForm", new ModalMemoForm());
        return "memo/memo";
    }

    /**
     * メモの登録をします
     */
    @PostMapping("/create")
    @Transactional
    public String createMemo(
            @AuthenticationPrincipal AccountDetails accountDetails,
            MemoForm memoForm,
            Model model) {
        Memo memo = new Memo();
        memo.setTitle(memoForm.getTitle());
        memo.setContent(memoForm.getContent());
        memo.setCreatedDate(LocalDate.now());
        memo.setEditedDate(null);
        memo.setUser(userRepository.findById(accountDetails.getId()).orElseThrow(EntityNotFoundException::new));
        memo.setDeleteFlg(false);
        memoRepository.save(memo);

        return "redirect:/memo/";
    }

    /**
     * メモを削除します
     */
    @GetMapping("/delete/{memoId}")
    @Transactional
    public String deleteMemo(@PathVariable(name = "memoId", required = false) Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(EntityNotFoundException::new);
        memo.setDeleteFlg(true);
        memoRepository.save(memo);

        return "redirect:/memo/";
    }

    /**
     * メモの編集をします。
     */
    @GetMapping("/edit/{memoId}")
    @Transactional
    public String editMemo(@PathVariable(name = "memoId", required = false) Long memoId, MemoForm memoForm) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(EntityNotFoundException::new);
        // メモの更新をします。
        memoService.updateMemo(memo, memoForm);
        return "redirect:/memo/";
    }
}
