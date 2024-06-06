package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;

@WebServlet("/images/*")
public class ImageController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("imgcontroller");
    	
    	String productId = request.getPathInfo().substring(1);
        if (productId == null || productId.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Image path is missing");
            return;
        }
        System.out.println("productId : "+ productId);
        
        ProductDAO dao = new ProductDAO();
        
        String filePath = dao.getFilePath(productId);
        System.out.println("filePath : "+ filePath);

        // Define the directory where images are stored
        String imagePath = "C:\\Users\\whwog\\OneDrive\\바탕 화면\\js\\jsp_Project\\img\\product";
//        String imagePath = "C:\\img\\product";
        File imageFile = new File(filePath);

        if (!imageFile.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found");
            return;
        }

        try (FileInputStream fis = new FileInputStream(imageFile);
             OutputStream os = response.getOutputStream()) {

            response.setContentType(getServletContext().getMimeType(imageFile.getName()));
            response.setContentLength((int) imageFile.length());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }
}
