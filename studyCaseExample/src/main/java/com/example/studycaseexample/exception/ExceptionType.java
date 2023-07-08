package com.example.studycaseexample.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    GENERIC_EXCEPTION(1, "Bilinmeyen bir sorun oluştu"),

    USER_DATA_NOT_FOUND(1001, "Kullanıcı Bulunamadı"),
    EXPENSE_DATA_NOT_FOUND(1002, "Masraf Bilgileri Bulunamadı"),
    ORDER_DATA_NOT_FOUND(1003, "Kullanıcı Bulunamadı"),
    PRODUCT_DATA_NOT_FOUND(1004, "Kullanıcı Bulunamadı"),
    CARD_DATA_NOT_FOUND(1005, "Kullanıcı Bulunamadı"),
    PRODUCT_SOLD_OUT(1006, "Yeterli miktarda ürün yoktur"),
    COLLECTION_SIZE_EXCEPTION(2001, "Liste boyutları uyuşmuyor");



    private final Integer code;
    private final String message;
}
