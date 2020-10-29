package com.kdk.domain;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class MemberPredicate {
  public static Predicate search(String memberId, String memberPwd) {
    QMember member = QMember.member;

    BooleanBuilder builder = new BooleanBuilder();

    if (memberId != null) {
      builder.and(member.memberId.eq(memberId));
    }

    if (memberPwd != null) {
      builder.and(member.memberPwd.eq(memberPwd));
    }

    return builder;
  }
}
