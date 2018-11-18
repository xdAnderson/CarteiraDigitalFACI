package com.example.lpa.carteiradigitalfaci_pt.controller;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaAES {
    public static byte[] encrypt(String PIN, String dado) {
        try {
            SecretKey key = new SecretKeySpec(PIN.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(dado.getBytes());
            return encrypted;
        } catch (Exception e) {
            return null;
        }
    }

    public static String decrypt(String PIN, byte [] dado) {
        try {
            SecretKey key = new SecretKeySpec(PIN.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            String dadoDecriptado = new String(cipher.doFinal(dado));
            return dadoDecriptado;
        } catch (Exception e) {
            return null;
        }
    }
}