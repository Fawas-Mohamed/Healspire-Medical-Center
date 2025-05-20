/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.util;

/**
 *
 * @author 
 */
import com.hospital.model.Invoice;
import java.awt.Color;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
public class InvoicePDFGenerator {
    public static byte[] generateInvoicePDF(Invoice inv) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);

            // define our colors
            Color backgroundBlue = new Color(224, 242, 254);
            Color headerGreen   = new Color(200, 230, 201);
            Color borderBlue    = new Color(30, 100, 170);

            float pageW = page.getMediaBox().getWidth();
            float pageH = page.getMediaBox().getHeight();

            PDPageContentStream cs = new PDPageContentStream(document, page);

            // fill background
            cs.setNonStrokingColor(backgroundBlue);
            cs.addRect(0, 0, pageW, pageH);
            cs.fill();

            // draw header bar
            float headerH = 60;
            cs.setNonStrokingColor(headerGreen);
            cs.addRect(0, pageH - headerH, pageW, headerH);
            cs.fill();

            // draw circular logo at top‑right
            PDImageXObject img = PDImageXObject.createFromFile("D:/2nd year 1sem/java severlet/Group_Project/web/image/logo9.jpg", document);
            float r = 25;                  // radius
            float cx = pageW - r - 15;     // center x
            float cy = pageH - headerH/2;  // center y inside header
            // approximate circle with 4 Béziers
            cs.saveGraphicsState();
            cs.moveTo(cx + r, cy);
            float c = r * 0.552284749831f;
            cs.curveTo(cx + r, cy + c, cx + c, cy + r, cx, cy + r);
            cs.curveTo(cx - c, cy + r, cx - r, cy + c, cx - r, cy);
            cs.curveTo(cx - r, cy - c, cx - c, cy - r, cx, cy - r);
            cs.curveTo(cx + c, cy - r, cx + r, cy - c, cx + r, cy);
            cs.clip();
            cs.drawImage(img, cx - r, cy - r, 2*r, 2*r);
            cs.restoreGraphicsState();

            // header text (moved down into green)
            cs.beginText();
            cs.setNonStrokingColor(Color.DARK_GRAY);
            cs.setFont(PDType1Font.HELVETICA_BOLD, 18);
            cs.newLineAtOffset(15, pageH - headerH/2 + 6);
            cs.showText("Healspire Medical Center");
            cs.endText();

            // detail‑box (lowered so it clears the header)
            float boxX = 15;
            float boxY = pageH - headerH - 150;
            float boxW = pageW - 30;
            float boxH = 120;
            cs.setStrokingColor(borderBlue);
            cs.setLineWidth(1.5f);
            drawRoundedRectangle(cs, boxX, boxY, boxW, boxH, 8);
            cs.stroke();

            // fields inside box
            float tx = boxX + 10;
            float ty = boxY + boxH - 20;
            cs.beginText();
            cs.setNonStrokingColor(Color.DARK_GRAY);
            cs.setFont(PDType1Font.HELVETICA, 12);
            cs.newLineAtOffset(tx, ty);
            cs.showText("Invoice ID: "  + inv.getId());
            cs.newLineAtOffset(0, -15);
            cs.showText("Patient ID: "  + inv.getPatientId());
            cs.newLineAtOffset(0, -15);
            cs.showText("Doctor: "      + inv.getdoctorName());
            cs.newLineAtOffset(0, -15);
            cs.showText("Date: "        + inv.getCreatedAt());
            cs.newLineAtOffset(0, -15);
            cs.showText("Amount: $"    + String.format("%.2f", inv.getAmount()));
            cs.endText();

            // footer
            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA_OBLIQUE, 10);
            cs.newLineAtOffset(15, 30);
            cs.showText("Thank you for choosing Healspire Medical Center.");
            cs.endText();

            cs.close();

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            document.save(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate invoice PDF", e);
        }
    }

    private static void drawRoundedRectangle(PDPageContentStream cs,
                                             float x, float y, float w, float h, float r)
            throws IOException {
        float c = r * 0.552284749831f;
        cs.moveTo(x + r, y);
        cs.lineTo(x + w - r, y);
        cs.curveTo(x + w - r + c, y, x + w, y + r - c, x + w, y + r);
        cs.lineTo(x + w, y + h - r);
        cs.curveTo(x + w, y + h - r + c, x + w - r + c, y + h, x + w - r, y + h);
        cs.lineTo(x + r, y + h);
        cs.curveTo(x + r - c, y + h, x, y + h - r + c, x, y + h - r);
        cs.lineTo(x, y + r);
        cs.curveTo(x, y + r - c, x + r - c, y, x + r, y);
        cs.closePath();
    }
}
