package com.chasexi.controller;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/6/24 10:58
 * @Description:
 */
@RestController
@RequestMapping("/2fa")
public class VerifyTwoFactorAuthController {
//    @GetMapping("/generate")
//    public String generateQRCode() {
//        GoogleAuthenticator gAuth = new GoogleAuthenticator();
//        final GoogleAuthenticatorKey key = gAuth.createCredentials();
//
//        String otpAuthURL = GoogleAuthenticatorQRGenerator.getOtpAuthURL("YourAppName", "user@example.com", key);
//
//        try {
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            BufferedImage image = createQRCode(otpAuthURL, 200, 200);
//            ImageIO.write(image, "png", stream);
//            String base64Image = Base64.getEncoder().encodeToString(stream.toByteArray());
//            return "<img src='data:image/png;base64," + base64Image + "' />";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error generating QR code";
//        }
//    }

    @PostMapping("/verify")
    public String verifyCode(@RequestBody VerifyRequest request, HttpSession session) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        boolean isCodeValid = gAuth.authorize("nZxjvLkqWbHtYcGpRzFvBdNxTqLmQrTy", request.getCode());
        if (isCodeValid) {
            session.setAttribute("checkKey","true");
            session.setAttribute("checkKey_error", "密钥验证通过，已允许数据访问");
            return "200";
        } else {
            return "404";
        }
    }

    @Getter
    public static class VerifyRequest {
        // getters and setters
        private String secret;
        private int code;
    }

//    private BufferedImage createQRCode(String qrCodeText, int width, int height) throws Exception {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, width, height);
//
//        return MatrixToImageWriter.toBufferedImage(bitMatrix);
//    }
}
