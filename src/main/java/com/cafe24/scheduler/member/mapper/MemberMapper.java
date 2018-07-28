package com.cafe24.scheduler.member.mapper;

import com.cafe24.scheduler.member.vo.MembersVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberMapper {
    @Autowired
    private SqlSessionTemplate sqlSession;
    public List<MembersVO> selectMemberList(MembersVO vo) throws Exception {
        return sqlSession.selectList("selectMemberList", vo);
    }
}
