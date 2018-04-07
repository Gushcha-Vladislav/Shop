package com.tsystems.javaschoolshop.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.tsystems.javaschoolshop.model.User;
import com.tsystems.javaschoolshop.model.dto.ProductSendDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Util which provide us a method for building document in pdf format.
 * It uses our custom PdfAbstractView class {@link #PdfAbstractView}
 */
public class PdfBuilderUtil extends PdfAbstractView {

    /**
     * path to the folder where image will be saved
     */
    private static final String IMAGES = "webapps\\ROOT\\resources\\fonts\\forPdf.ttf";

    /**
     * Path to the images folder inside the tomcat root catalog
     */
    private static final String IMAGES_PATH = System.getProperty("catalina.home") + File.separator + IMAGES;

    /**
     * Directly, method where we put some instructions for creating document
     * @param model where our data is storing
     * @param doc - document we received at the output
     * @param writer - our pdfWriter
     * @param request handled by our controller
     * @param response response which will be sent for user with our document
     * @throws Exception in cases when something going wrong during the method processing
     */
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws DocumentException, IOException {
        // get data model which is passed by the Spring container
        List<ProductSendDto> productDtoList = (List<ProductSendDto>) model.get("topProducts");
        List<User> userDtoList = (List<User>) model.get("topUsers");
        Integer incomePerWeek = (Integer) model.get("incomePerWeek");
        Integer incomePerMonth = (Integer) model.get("incomePerMonth");

        // define font for table header row
        Font font = FontFactory.getFont(IMAGES_PATH, "cp1251", true);
        doc.addTitle("Shop Statistics");
        doc.addHeader("Header", "Shop Statistics");
        doc.addAuthor("SchoolShop (c)");
        doc.addCreationDate();
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
                new Phrase("Shop Statistics", font),
                (doc.right() - doc.left()) / 2 + doc.leftMargin(),
                doc.top() + 10, 0);

        doc.add(new Paragraph(new Phrase("Income for the last week: \u20BD " + incomePerWeek + ".",font)));
        doc.add(new Paragraph(new Phrase("Income for the last month: \u20BD " + incomePerMonth + ".",font)));

        doc.add(new Paragraph(new Phrase("Top 10 User for the last time:",font)));

        PdfPTable tableTopUsers = new PdfPTable(5);
        tableTopUsers.setWidthPercentage(100.0f);
        tableTopUsers.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
        tableTopUsers.setSpacingBefore(10);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Email", font));
        tableTopUsers.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        tableTopUsers.addCell(cell);

        cell.setPhrase(new Phrase("Last Name", font));
        tableTopUsers.addCell(cell);

        cell.setPhrase(new Phrase("Phone", font));
        tableTopUsers.addCell(cell);

        cell.setPhrase(new Phrase("Total Cash", font));
        tableTopUsers.addCell(cell);

        // write table row data
        for (User user : userDtoList) {
            tableTopUsers.addCell(new Phrase(user.getEmail(),font));
            tableTopUsers.addCell(new Phrase(user.getNameUser(),font));
            tableTopUsers.addCell(new Phrase(user.getLastNameUser(),font));
            tableTopUsers.addCell(new Phrase(user.getPhone()==null ? "Not specified" : user.getPhone(),font));
            tableTopUsers.addCell(new Phrase("\u20BD " + user.getStatisticTopUser().getPrice(),font));
        }
        doc.add(tableTopUsers);

        doc.add(new Paragraph(new Phrase("Top 10 Products for the last time:",font)));

        PdfPTable tableTopProducts = new PdfPTable(4);
        tableTopProducts.setWidthPercentage(100.0f);
        tableTopProducts.setWidths(new float[] {2.5f, 2.5f, 2.5f, 2.5f});
        tableTopProducts.setSpacingBefore(10);

        // define table header cell
        PdfPCell topProductsCell = new PdfPCell();
        topProductsCell.setPadding(5);

        // write table header
        topProductsCell.setPhrase(new Phrase("Name", font));
        tableTopProducts.addCell(topProductsCell);

        topProductsCell.setPhrase(new Phrase("Image", font));
        tableTopProducts.addCell(topProductsCell);

        topProductsCell.setPhrase(new Phrase("Price", font));
        tableTopProducts.addCell(topProductsCell);

        topProductsCell.setPhrase(new Phrase("Number of Sales", font));
        tableTopProducts.addCell(topProductsCell);

        //Images of the top products
        Map<Integer, Byte[]> images = (HashMap<Integer, Byte[]>) model.get("imagesMap");
        // write table row data
        for (ProductSendDto product : productDtoList) {
            tableTopProducts.addCell(new Phrase(product.getNameProduct(), font));
            tableTopProducts.addCell(Image.getInstance(ByteArrayConverterUtil.convertBytes(images.get(product.getId()))));
            tableTopProducts.addCell(new Phrase(String.valueOf(product.getPrice()), font));
            tableTopProducts.addCell(new Phrase(String.valueOf(product.getNumberOfSales()),font));
        }
        doc.add(tableTopProducts);
    }
}
