package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Memo;
import com.example.demo.model.form.MemoForm;
import com.example.demo.repository.MemoRepository;

@Service
public class MemoService {

	@Autowired
	MemoRepository memoRepository;

	/**
	 * メモフォームを作成します
	 * 
	 * @return メモフォーム
	 */
	public MemoForm createMemoForm(Memo memo) {
		MemoForm memoForm = new MemoForm();
		if (!Optional.ofNullable(memo).isEmpty()) {
			memoForm.setId(memo.getId());
			memoForm.setTitle(memo.getTitle());
			memoForm.setContent(memo.getContent());
		}
		return memoForm;
	}

	/** メモの更新をします */
	@Transactional
	public void updateMemo(Memo memo, MemoForm memoForm) {
		memo.setTitle(memoForm.getTitle());
		memo.setContent(memoForm.getContent());
		memoRepository.save(memo);
	}
}
