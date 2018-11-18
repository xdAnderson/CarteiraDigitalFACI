package com.example.lpa.carteiradigitalfaci_pt.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaHash {

    private static MessageDigest md = null;

    public static String criptografar(String texto, String tipoHash) {
        try {
            md = MessageDigest.getInstance(tipoHash);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        byte[] digest = md.digest(texto.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }

        if (md != null) {
            return sb.toString();
        }
        return null;
    }
}
