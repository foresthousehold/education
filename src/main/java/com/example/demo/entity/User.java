package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entity.base.BaseEntity;

/**
 * ユーザ
 */
@Entity
@Table(name="user")
public class User extends BaseEntity{

  /** ユーザネーム */
  @Column(name = "name", nullable = false)
  private String name;

  /** レベル */
  @Column(name = "level", nullable = false)
  private Long level;

  /** 累積経験値 */
  @Column(name = "all_exp", nullable = false)
  private Long allEXP;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getLevel() {
    return level;
  }

  public void setLevel(Long level) {
    this.level = level;
  }
  
  public Long getAllEXP() {
    return allEXP;
  }

  public void setAllEXP(Long allEXP) {
    this.allEXP = allEXP;
  }
}