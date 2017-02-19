package servlet;

import manager.BoardManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteServlet extends HttpServlet {

    private BoardManager boardManager;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.boardManager = (BoardManager) config.getServletContext().getAttribute("boardManager");
    }

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 1. 데이터 추출
        String sindex = req.getParameter("index");

        // 2. 유효성 검사
        // 3. 처리
        boardManager.deleteBoard(sindex);

        // 4. 결과 출력
        req.setAttribute("deleteNum", sindex);
        req.getRequestDispatcher("/board/delete.jsp").forward(req, res);
    }
}
