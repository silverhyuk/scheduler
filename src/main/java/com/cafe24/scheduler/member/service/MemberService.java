package com.cafe24.scheduler.member.service;

import com.cafe24.scheduler.member.mapper.MemberMapper;
import com.cafe24.scheduler.member.vo.MembersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<MembersVO> selectMemberList() throws Exception {
        MembersVO membersVO = new MembersVO();
        List<MembersVO> memberList = memberMapper.selectMemberList(membersVO);

        for(MembersVO vo : memberList) {
            System.out.println("name : " + vo.getName() +  " / team : " + vo.getTeam());
        }
        return memberList;
    }
}
