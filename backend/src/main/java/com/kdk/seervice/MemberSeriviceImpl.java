package com.kdk.seervice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.domain.Member;
import com.kdk.repository.MemberRepository;

@Service
public class MemberSeriviceImpl implements MemberSerivice {

  @Autowired
  private MemberRepository repository;

  @Override
  public List<Member> selectMemberList() {
    return repository.findAll();
  }
}
