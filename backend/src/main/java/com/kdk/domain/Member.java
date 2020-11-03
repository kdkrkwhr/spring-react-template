package com.kdk.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="TB_MEMBER")
public class Member implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long idx;

  @Column(name = "member_id", nullable = true)
  private String memberId;
  @Column
  private String memberPwd;

  public Member(String memberId, String memberPwd) {
    this.memberId = memberId;
    this.memberPwd = memberPwd;
  }
}
