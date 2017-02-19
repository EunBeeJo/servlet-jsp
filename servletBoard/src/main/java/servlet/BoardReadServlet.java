package servlet;

import manager.BoardManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Map;

public class BoardReadServlet extends HttpServlet{

    private BoardManager boardManager;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.boardManager = (BoardManager) config.getServletContext().getAttribute("boardManager");
    }

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 1. 데이터 추출
        String sindex = req.getParameter("index");
        int index = Integer.parseInt(sindex);

        // 2. 유효성 검사
        if (index < 0) {

        }

        // 3. 처리
        Map<String, String> returnBoard = boardManager.readBoard(sindex);

        // 4. 결과 출력
        req.setAttribute("returnBoard", returnBoard);
        req.getRequestDispatcher("/board/read.jsp").forward(req, res);
    }
}
