package com.example.thishouse.service;

import com.example.thishouse.repository.MemberDao;
import com.example.thishouse.repository.MemberDaoImpl;
import com.example.thishouse.repository.TestDao;
import com.example.thishouse.repository.TestDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
    static MemberDao dao;
    @Autowired
    public MemberService(MemberDaoImpl dao) {this.dao = dao;}
    public int idCk(String id) {
        System.out.println(id+"SER INPUT");
        int result = dao.idCk(id);
        System.out.println(result + "SER");
        return result;
    }
}
