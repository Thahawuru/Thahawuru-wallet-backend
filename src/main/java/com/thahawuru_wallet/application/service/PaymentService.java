package com.thahawuru_wallet.application.service;
import com.thahawuru_wallet.application.dto.response.PaymentDTO;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

@Service
public class PaymentService {


    private String merchantSecret ="Mjg2MjQ5MjA3NDQ2MTM0ODAzNjMwOTg4MTU1NjYyMzg4NDUwNDYw";
    public PaymentDTO makePayment(double amount) {

        String merahantID     = "1227840";
        String orderID = Long.toString(System.currentTimeMillis());
        double amounts         = amount;
        String currency       = "LKR";
        DecimalFormat df       = new DecimalFormat("0.00");
        String amountFormatted = df.format(amounts);
        String hash    = getMd5(merahantID + orderID + amountFormatted + currency + getMd5(merchantSecret));

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setOrderId(orderID);
        paymentDTO.setHash(hash);
        paymentDTO.setAmount(String.format("%.2f", amounts));

    return new PaymentDTO("ssss","3dfdkfkdfkdhfkdkd","3000");
}

    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
