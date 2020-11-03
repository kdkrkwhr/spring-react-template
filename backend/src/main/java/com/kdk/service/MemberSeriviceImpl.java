package com.kdk.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kdk.domain.Member;
import com.kdk.domain.QMember;
import com.kdk.repository.MemberRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class MemberSeriviceImpl implements MemberSerivice {

  static final Logger logger = LoggerFactory.getLogger(MemberSeriviceImpl.class);

  @Autowired
  private MemberRepository repository;

  @Override
  public List<Member> selectMemberList() {
    return repository.findAll();
  }

  @Override
  public Member selectMember(Long idx) {
    return repository.findById(idx).get();
  }

  @Override
  @Transactional
  public int insertMember(Member member) {
    int result;

    try {

      repository.save(member);
      result = 1;

    } catch (Exception e) {
      result = 0;
      logger.error("ERROR :: {}", e.getMessage());
    }

    return result;
  }

  @Override
  @Transactional
  public int updateMember(Member member) {
    int result;

    try {

      
      result = 1;

    } catch (Exception e) {
      result = 0;
      logger.error("ERROR :: {}", e.getMessage());
    }

    return result;
  }

  @Override
  @Transactional
  public int deleteMember(Long idx) {
    int result;

    try {

      repository.deleteById(idx);
      result = 1;

    } catch (Exception e) {
      result = 0;
      logger.error("ERROR :: {}", e.getMessage());
    }

    return result;
  }
}
