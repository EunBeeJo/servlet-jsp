package servlet;

import manager.BoardManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BoardEditProcessServlet extends HttpServlet {

    private BoardManager boardManager = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.boardManager = (BoardManager) config.getServletContext().getAttribute("boardManager");
    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // POST 방식
        req.setCharacterEncoding("EUC-KR");


        // 1. 데이터 추출
        String content = req.getParameter("content");
        String sindex = req.getParameter("index");
        System.out.println("INDEX : " + sindex);

        Map<String, String> board = boardManager.getBoard(sindex);

        // 2. 유효성 검사
        if ("".equals(content)) {
            content = "no content";
        }

        // 3. 처리
        board.put("content", content);
        boardManager.editBoard(board);

        req.setAttribute("editNum", sindex);
        req.getRequestDispatcher("/board/edit_process.jsp").forward(req, res);
    }
}
