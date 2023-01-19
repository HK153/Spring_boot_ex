package spring.mybatis;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringMain {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");
		String [] names =factory.getBeanDefinitionNames();
		System.out.println("==============================");
		for (String n: names) {
			System.out.println(n);
		}
		System.out.println("==============================");
		
		MemberService service = (MemberService) factory.getBean("service");
		
	/*	//mybatis/mybatis-config.xml 
		//1.mybatis 설정파일 읽을 객체 준비
		SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
		//2. maybatis-config.xml 설정대로 연결
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		//3. db connection= jdbc는 자동 commit// mybatis는 수동 commit  -->변경해야 바로 반영
		SqlSession session = factory.openSession(true); 
//		//4. sql-mapping.xml id = memberlist resultType="mybatis.MemberDTO" 정의 sql 호출
//		List<MemberDTO> memberlist = session.selectList("member.memberlist");
//		//5. 조회 
//		for (MemberDTO m : memberlist) {
//			System.out.println(m.getId() + ":"+ m.getPw()+ " : " +m.getName());
//		}
		///
		MemberDAO dao = new MemberDAO();
		dao.setSession(session);
		
		MemberService service = new MemberServiceImpl();
		((MemberServiceImpl)service).setDao(dao);
		
		*/
		///////////////////////////////////////////////////////////// sql 실행준비 완료
		//test1 - 리스트 조회
		/*List<MemberDTO> list = service.memberlist();
		for (MemberDTO m : list) {
			System.out.println(m.getId() + ":"+ m.getPw()+ " : " +m.getName());
	
		}*/
		//test2 -조회 int
//		System.out.println("전체 회원수 =  " + service.membercount());
		
		//test3 - 조회 (입력파라미터 존재, 결과 MemeberDTO)
		/*MemberDTO m = service.onemember("pp");
		if (m!=null) {
			System.out.println(m.getId() + ":"+ m.getPw()+ " : " +m.getName());
		}*/
		//test4 - 페이징처리 리스트 조회
		/*int[] limit = {0, 3};
		List<MemberDTO> list = service.paginglist(limit);
		for(MemberDTO m : list) {
			System.out.println(m.getId() + " : "+ m.getPw()+ " : " +m.getName());
		}*/
		//test5 -
		/*MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mybatis");
		insertdto.setPw("my");
		insertdto.setName("바티스");
		insertdto.setPhone("0108724728");
		insertdto.setEmail("batis@my.com");
		insertdto.setAddress("서울시 용산구");
		
		service.insertmember(insertdto);
		*/
		
		//test6
		// id= mybatis, name="박한국" phone=0108444998 이메일 mybatis@bdsa.con 수정
		// updatemember sql 실행 
		/*MemberDTO updatedto = new MemberDTO();
		updatedto.setId("mybatis");
		updatedto.setName("박한국");
		updatedto.setPhone("0108444998");
		updatedto.setEmail("mybatis@sba.com");
		
		service.updatemember(updatedto);
		*/
		//test7
		//id mybatis 삭제
//		service.deletemember("mybatis");
		
		/*
		 * 1. id 회원이 작성한 글이 있는지 검사
		 * 2. 글이 있으면 사용자 탈퇴전에 글도 삭제하시겠습니다 y/n
		 * 3-1. 사용자 탈퇴 처리 
		 * 3-2. 사용자 탈퇴 취소 
		 */
		
		/*
		List<HashMap <String ,String>> boardlist = service.memberboard("db");
		if (boardlist!=null) {
			Scanner sc = new Scanner(System.in);
			System.out.print("사용자 탈퇴전에 글도 삭제하시겠습니까 Y/N : ");
			String answer = sc.next();
			if (answer.equals("y") || answer.equals("Y")) {
				service.deletemember("db");
			}
			else if (answer.equals("n") || answer.equals("N")) {
				System.out.print("사용자 탈퇴 취소되었습니다"); 
			}
		}
		else {
			System.out.print("작성한 글이 없습니다."); 
		}
		*/
		
		
		//test8 - map
		/*HashMap<String, String> map = new HashMap();
		map.put("colname", "indate");
		map.put("colvalue", "2023%");
		//select *from member where ${celname} like #{colvalue}
		List<MemberDTO> searchlist = service.searchmember(map);
		for (MemberDTO m: searchlist) {
			System.out.println(m.getId() + ": \t"+ m.getPw()+ " : \t" +m.getName() + ":\t" + m.getEmail() + "\t" + m.getIndate());
		}*/
		
		//test9
		// select from member where address in ('서울시 용산구', '서울시 강남구', '경기도 XXX');
		/*ArrayList<String> addresslist =new ArrayList();
		addresslist.add("서울시 용산구");
		addresslist.add("서울시 강남구");
		addresslist.add("경기도 하남시");
		List<MemberDTO> list = service.addresssearch(addresslist);
		for (MemberDTO m: list) {
			System.out.println(m.getId() + " \t"+ m.getAddress()+ " \t" +m.getName() + "\t" + m.getEmail() + "\t" + m.getIndate());
		}*/
		
		//test10 - 조합 + 동적조건절
		/*MemberDTO dto = new MemberDTO();
		dto.setName("이름");
		dto.setEmail("ds@ds.com");
		List<MemberDTO> resultlist = service.combination(dto);
		for (MemberDTO m: resultlist) {
			System.out.println(m.getId() + " \t"+ m.getAddress()+ " \t" +m.getName() + "\t" + m.getEmail() + "\t" + m.getIndate());
		}*/
		
		//test11 - join시 reaultmap도 이용할 수 있다
		/*List<HashMap <String ,String>> boardlist = service.memberboard("db");
		for(HashMap map : boardlist) {
			Set<String> keys = map.keySet();
			for (String s:keys) {
				System.out.println(s + " : " + map.get(s));
			}
		}*/
		
		
		
		
	}

}
