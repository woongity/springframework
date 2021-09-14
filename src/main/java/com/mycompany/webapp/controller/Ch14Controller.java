package com.mycompany.webapp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.Ch14BoardService;
import com.mycompany.webapp.service.Ch14MemberService;
import com.mycompany.webapp.service.Ch14MemberService.JoinResult;
import com.mycompany.webapp.service.Ch14MemberService.LoginResult;

@Controller
@RequestMapping("/ch14")
public class Ch14Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Controller.class);
	@Resource
	private DataSource dataSource;
	
	@RequestMapping("/content")
	public String content() {		
		return "ch14/content";
	}
	
	@GetMapping("/testConnectToDB")
	public String testConnectToDB() throws Exception{
		logger.info("실행");
		Connection conn = dataSource.getConnection();
		logger.info("연결성공");
		
		conn.close();
		return "redirect:/ch14/content";
	}	
	@GetMapping("/testInsert")
	public String testInsert() throws Exception{
		logger.info("실행");
		Connection conn= dataSource.getConnection();
		try {
			String sql = "INSERT INTO board VALUES(SEQ_BNO.NEXTVAL,?,?,SYSDATE, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "오늘은 월요일");
			pstmt.setString(2, "스트레스가 이빠이 올라갔어요");
			pstmt.setString(3, "user");
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn.close();
		}
		return "redirect:/ch14/content";
	}
	@GetMapping("/testSelect")
	public String testSelect() throws Exception{
		Connection conn= dataSource.getConnection();
		try {
			String sql = "SELECT bno,btitle,bcontent,bdate,mid FROM board";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				String mid = rs.getString("mid");
				logger.info("bno : " + bno);
				logger.info("bcontent : " + bcontent);
				logger.info("bdate : " + bdate);
				logger.info("bmid : " + mid);
			}
			pstmt.close();
			rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			conn.close();
		}
		return "redirect:/ch14/content";
	}
	@GetMapping("/testUpdate")
	public String testUpdate() throws Exception {
		Connection conn = dataSource.getConnection();
		try {
			String sql = "UPDATE board SET btitle=?,bcontent=? where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "배고파요");
			pstmt.setString(2, "점심먹으러 언제감 ?");
			pstmt.setInt(3, 1);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		conn.close();
		return "redirect:/ch14/content";
	}

	@GetMapping("/testDelete")
	public String testDelete() throws Exception {
		logger.info("실행");
		Connection conn = dataSource.getConnection();
		try {
			String sql = "DELETE FROM board where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		conn.close();
		return "redirect:/ch14/content";
	}

	@Resource
	private Ch14MemberService memberService;
	
	@GetMapping("/join")
	public String joinForm() {
		return "ch14/joinForm";
	}
	@PostMapping("/join")
	public String join(Ch14Member member, Model model) {
		member.setMrole("ROLE_USER");
		member.setMenabled(1);
		JoinResult jr = memberService.join(member);
		if(jr==JoinResult.SUCCESS){
			return "redirect:/ch14/content";
		}else if(jr == JoinResult.FAIL) {
			model.addAttribute("reason","회원 가입 실패");
			return "ch14/joinForm";
		}else {
			model.addAttribute("reason", "중복된 회원입니다");
			return "ch14/joinForm";
		}
	}
	@GetMapping("/login")
	public String loginForm() {
		return "ch14/loginForm";
	}

	@PostMapping("/login")
	public String login(Ch14Member member, Model model) {
		logger.info("실행");
		member.setMrole("ROLE_USER");
		member.setMenabled(1);
		LoginResult lr = memberService.login(member);
		if(lr == LoginResult.EMPTYSET) {
			model.addAttribute("error","로그인에 실패했습니다. 항목을 채워주세요");
			logger.info("empty set");
			return "ch14/loginForm";
		}else if(lr==LoginResult.NOTREGISTERED) {
			model.addAttribute("error","등록되지 않은 회원입니다 ");
			logger.info("not registered");
			return "ch14/loginForm";
		}else if(lr == LoginResult.WRONGPASSWORD) {
			model.addAttribute("error","잘못된 비밀번호 입니다 ");
			logger.info("wrong password");
			return "ch14/loginForm";
		}else if(lr==LoginResult.FAIL) {
			model.addAttribute("error","모종의 이유로 로그인 실패 ");
			logger.info("unidentified error");
			return "ch14/loginForm";
		}
		else {
			logger.info("log in success");
			return "redirect:/ch14/content";
		}
	}
	@Resource Ch14BoardService boardService;
	@GetMapping("/boardList")
	public String boardList(@RequestParam(defaultValue = "1") int pageNo, Model model) {
		int totalRows = boardService.getTotalBoardNum();
		Pager pager = new Pager(10, 5, totalRows, pageNo);
		List<Ch14Board> boards = boardService.getBoards(pager);
		model.addAttribute("boards", boards);
		model.addAttribute("pager", pager);
		return "ch14/boardList";
	}
	@GetMapping("/boardWriteForm")
	public String boardWriteForm() {
		return "ch14/boardWriteForm";
	}
	@PostMapping("/boardWrite")
	public String boardWrite(Ch14Board board) {
		boardService.writeBoard(board);
		return "redirect:/ch14/boardList";
	}
	@GetMapping("/boardDetail")
	public String boardDetail(int bno, Model model) {
		Ch14Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardDetail";
	}
	@GetMapping("/boardUpdateForm")
	public String boardUpdateForm(int bno, Model model) {
		Ch14Board board= boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardUpdateForm";
	}
	@PostMapping("/boardUpdate")
	public String boardUpdate(Ch14Board board) {
		boardService.updateBoard(board);
		return "redirect:/boardDetail?bno="+board.getBno();
	}
	@GetMapping("/boardDelete")
	public String boardDelete(int bno) {
		boardService.removeBoard(bno);
		return "redirect:/ch14/boardList";
	}
}
