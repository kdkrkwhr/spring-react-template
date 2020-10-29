package com.kdk.service;

import java.util.List;
import com.kdk.domain.Member;

public interface MemberSerivice {

  List<Member> selectMemberList();

  Member selectMember(Long idx);

  int insertMember(Member member);

  int updateMember(Member member);

  int deleteMember(Long idx);
}
