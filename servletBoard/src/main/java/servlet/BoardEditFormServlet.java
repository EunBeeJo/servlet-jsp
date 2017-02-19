package servlet;

import manager.BoardManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BoardEditFormServlet extends HttpServlet {

    private BoardManager boardManager = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.boardManager = (BoardManager) config.getServletContext().getAttribute("boardManager");
    }

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 1. 데이터 추출
        String sindex = req.getParameter("index");

        // 2. 유효성 검사
        // 3. 처리
        Map<String, String> board = boardManager.getBoard(sindex);
        req.setAttribute("editBoard", board);
        req.getRequestDispatcher("/board/edit_form.jsp").forward(req, res);
    }
}
