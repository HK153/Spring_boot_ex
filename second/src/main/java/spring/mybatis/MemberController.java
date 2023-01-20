package spring.mybatis;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	
	//http://ip:pport/spring/
	@RequestMapping("/")
	public String start() {
		return "mybatis/start";
	}
	@GetMapping("/login")
	public String login() {
		return "mybatis/loginform";
	}
	
	
	@PostMapping("/login")
	public String login2(String id, String pw, HttpSession session) {
		MemberDTO dto = service.onemember(id);
		String view = "";
		if(dto==null) {
			//회원가입화면 뷰
			view="mybatis/memberinsert";
		}
		else {
			if(pw.equals(dto.getPw())){
				//로그인
				session.setAttribute("loginid", id);
				view="mybatis/start";
			}
			else {
				//암호가 다름
				view="mybatis/loginform";
			}
		}
		return view;
	}
	
	
	
	@RequestMapping("/mybatismemberlist")
	public ModelAndView memberlist() {
		List<MemberDTO> memberlist = service.memberlist();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	@GetMapping("/memberinsert")
	public String memberinsert() {
		return "mybatis/memberinsert";
	}
	
	@PostMapping("/memberinsert")
	public ModelAndView memberinsert(@ModelAttribute("dto")MemberDTO dto ) throws IOException {
		//dto 객체 저장값 (폼 입력값) member테이블 저장
		//indate (가입일은 sql)
		//저장한 결과 "정상회원가입처리" 모델로 저장
		//mybatis/memberinsert2 뷰 
		
		
		//파일 업로드 c:/upload 저장처리
		//dto image변수에 c:upload 저장파일명 세팅 
		String savePath = "c:/upload/";
		MultipartFile imagefile = dto.getImagefile();
		String filename = imagefile.getOriginalFilename();
		String beforeext = filename.substring(0,filename.lastIndexOf("."));
		String ext = filename.substring(filename.lastIndexOf("."));
		String newfilename = beforeext + "(" + UUID.randomUUID().toString() + ")" + ext;
		File serverfile =new File(savePath + newfilename);
		imagefile.transferTo(serverfile);
		
		dto.setImage(newfilename);
		
		
		String result ;
		int row;
		MemberDTO db_dto = service.onemember(dto.getId());
		if (db_dto ==null) {
			row = service.insertmember(dto);
			if (row==1) {
			result ="정상 회원 가입 처리";
			}
			else {
				result = "다시 시도해 주세요. 회원가입처리 오류 발생";
			}
		}
		else {
			result =" 이미 사용중인 아이디입니다.";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("mybatis/memberinsert2");
		return mv;
	}
	
	@RequestMapping("/memberinform")
	public ModelAndView memberinform(HttpSession session) {
		/* 1. HttpSession 객체에 저장된 loginid 값을 가져와서 
		 * 2. service.onemember(loginid) 호출
		 * 3. 모델 저장
		 * 4. mybatis/memberinform 뷰
		 * 5. 뷰 - form 태그로 출력 submit-내정보 수정 
		 * */
		String id = (String) session.getAttribute("loginid");
		ModelAndView mv = new ModelAndView();
		if (id !=null) {
			MemberDTO dto = service.onemember(id);
			mv.addObject("dto", dto);
			mv.setViewName("mybatis/memberinform");
		}
		else {
			mv.setViewName("mybatis/loginform");
		}
		return mv;
	}
	
	/* 1. 내정보 수정시 입력정보 모두 가져온다
	 * 2. updatemember2 id sql 실행
	 * --service+serviceImpl + dao  메소드 추가
	 * 3. "회원정보 수정 완료" 모델로저장 
	 * 4. start.jsp 모델의 결과 출력 
	 * */
	@PostMapping("/memberupdate")
	public ModelAndView memberupdate(MemberDTO dto) {
		ModelAndView mv = new ModelAndView() ;
		String result ;
		int row = service.updatemember2(dto);
		if (row==1) {
			result ="회원정보 수정 완료";
		}
		else {
			result ="회원정보 수정 실패";
		}
		mv.addObject("result",result);
		mv.setViewName("mybatis/start");
		return mv;
	}
	
	/*로그아웃 
	 * 1.세션에서 loginid 속성값 읽는다
	 * 2.존재하면 세션에서 속성 없앤다
	 * 3.start.jsp이동
	 * */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("loginid") !=null) {
			session.removeAttribute("loginid");
		}
		return "mybatis/start";
	}
	
	
	/*회원탈퇴
	 * 1.세션에서 loginid 속성값 읽는다
	 * 2.service.deletemember(loginid)
	 * 3.2번 결과 1이면 "회원탈퇴 정상처리" 모델로 저장 
	 * 4. start.jsp 이동
	 * */ 
	@GetMapping("/memberdelete")
	public ModelAndView memberdelete(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String result = null;
		String id = (String) session.getAttribute("loginid");
		if(id!=null) {
			int row = service.deletemember(id);
			if (row==1) {
				result= "회원탈퇴 정상처리";
			}
			else {
				result="회원탈퇴 오류";
			}
			session.removeAttribute("loginid");
		}
		mv.addObject("result", result);
		mv.setViewName("mybatis/start");
		return mv;
	}
	@ResponseBody
	@GetMapping("/othermemberinform")
	public MemberDTO othermemberinform(String id, HttpSession session) {
		//id정보를 db에서 가져온다
		//모델 저장
		//mybatis/othermemberinform.jsp전달
		/*
		 * 1.로그인되었는지 확인
		 * 2.로그인안되었으면 start.jsp
		 * 2-2.로그인아이디가 "admin"인지 확인하여
		 * 	2-2-1.아래코드 수행
		 * 	2-2-2. alert("회원정보 볼 권한 없습니다")
		 */
		String model =null;
		MemberDTO dto= new MemberDTO();
		String loginid = (String) session.getAttribute("loginid");
		if(loginid ==null) {
			model ="로그인 이전입니다.";
			dto.setId(model);
		}
		else {
			if(! loginid.equalsIgnoreCase("admin")) {
				model ="회원정보 볼 권한 없습니다.";
				dto.setId(model);
			}
			else {
				dto = service.onemember(id);
				
			}
		}
		return dto;
		
	}
	
	
	
	
	
}
