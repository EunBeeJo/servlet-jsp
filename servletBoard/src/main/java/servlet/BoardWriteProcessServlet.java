package servlet;

import manager.BoardManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardWriteProcessServlet extends HttpServlet {

    private BoardManager boardManager = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.boardManager = (BoardManager) config.getServletContext().getAttribute("boardManager");
    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // POST 방식
        req.setCharacterEncoding("EUC-KR");
        Map<String, String> board = new HashMap<String, String>();

        // 1. 데이터 추출
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String content = req.getParameter("content");

        // 2. 유효성 검사
        if ("".equals(title)) {
            title = "no title";
        }
        if ("".equals(writer)) {
            writer = "no writer";
        }
        if ("".equals(content)) {
            content = "no content";
        }

        // 3. 처리
        board.put("title", title);
        board.put("writer", writer);
        board.put("content", content);
        boardManager.addBoard(board);

        req.getRequestDispatcher("/board/write_process.jsp").forward(req, res);
    }
}
