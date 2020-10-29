package com.kdk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kdk.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
