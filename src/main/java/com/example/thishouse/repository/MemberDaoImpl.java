package com.example.thishouse.repository;

import com.example.thishouse.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//"MemberDaoImpl"이라는 이름의 클래스로, "MemberDao" 인터페이스를 구현하는 역할을 합니다.
//이 클래스에서는 MyBatis를 사용하여 데이터베이스와의 상호작용을 수행하며, "SqlSessionTemplate"을 사용하여 데이터베이스 연결을 관리 ,
//실제로 데이터베이스와의 상호작용을 담당
@Repository
//@Repository 어노테이션을 사용하면, 해당 클래스가 데이터 액세스 계층에서 사용되는 Repository 역할을 수행하는 클래스임을 나타낼 수 있음.
//클래스에 @Repository 어노테이션을 붙이면, 해당 클래스가 컴포넌트 스캔(Component Scan)에 의해 자동으로 빈(Bean)으로 등록되어, 스프링 컨테이너에서 사용할 수 있음.
public class MemberDaoImpl implements MemberDao{
    private final SqlSessionTemplate sqlSession; //"sqlSession" 필드는 "SqlSessionTemplate" 객체를 주입받습니다.

    private static final String Namespace = "com.example.thishouse.mapper.MemberMapper"; //"Namespace" 상수에는 해당 매퍼 파일의 네임스페이스를 저장

    @Autowired // @Autowired 어노테이션을 사용하면, 해당 필드나 생성자, 메서드 등에 알맞은 빈(Bean) 객체를 자동으로 주입하여 사용
    MemberDaoImpl(SqlSessionTemplate sqlSession){
        this.sqlSession = sqlSession;
    }

    //중복확인
    @Override
    public int idCk(String user_id) { // "idCk" 메서드에서는 매개변수로 받은 "id" 값을 MyBatis를 사용하여 데이터베이스에서 조회한 후, 조회 결과를 "int" 타입으로 반환
        System.out.println(user_id + " DAO");
        int result = sqlSession.selectOne(Namespace+".idCk",user_id);
        System.out.println(result);
        return result;
    }
    //회원가입
    @Override
    public void signupMember(Member member) {
        sqlSession.insert(Namespace + ".signupMember", member);
    }

    @Override
    public Long loginMember(String user_id, String user_pw, String user_name) {
        System.out.println(user_id + user_pw + user_name + " DAO");
        Long result = sqlSession.selectOne(Namespace+".loginMember",user_id);
        System.out.println(result);
        return result;
    }

}
