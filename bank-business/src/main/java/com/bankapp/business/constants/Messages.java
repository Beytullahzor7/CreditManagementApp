package com.bankapp.business.constants;

public class Messages {
    
    private Messages() {
        // Private constructor to prevent instantiation
    }

    public enum Customer {
        NOT_FOUND("Müşteri bulunamadı"),
        CUSTOMER_NUMBER_EXISTS("Bu müşteri numarası zaten kullanılıyor"),
        NATIONAL_ID_EXISTS("Bu TC kimlik numarası ile kayıtlı müşteri bulunmaktadır"),
        INVALID_NATIONAL_ID("Geçersiz TC kimlik numarası"),
        TAX_NUMBER_EXISTS("Bu vergi numarası ile kayıtlı müşteri bulunmaktadır"),
        INVALID_TAX_NUMBER("Geçersiz vergi numarası"),
        ADDED("Müşteri başarıyla eklendi"),
        UPDATED("Müşteri başarıyla güncellendi"),
        DELETED("Müşteri başarıyla silindi");

        private final String message;

        Customer(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum Validation {
        NATIONAL_ID_REQUIRED("TC Kimlik No boş olamaz"),
        NATIONAL_ID_SIZE("TC Kimlik No 11 haneli olmalıdır"),
        FIRST_NAME_REQUIRED("Ad boş olamaz"),
        FIRST_NAME_SIZE("Ad 50 karakterden uzun olamaz"),
        LAST_NAME_REQUIRED("Soyad boş olamaz"),
        LAST_NAME_SIZE("Soyad 50 karakterden uzun olamaz"),
        BIRTH_DATE_REQUIRED("Doğum tarihi boş olamaz"),
        BIRTH_DATE_PAST("Doğum tarihi geçmiş bir tarih olmalıdır"),
        PHONE_REQUIRED("Telefon numarası boş olamaz"),
        PHONE_PATTERN("Telefon numarası 10 haneli olmalıdır"),
        EMAIL_PATTERN("Geçerli bir e-posta adresi giriniz"),
        ADDRESS_REQUIRED("Adres boş olamaz"),
        ADDRESS_SIZE("Adres 500 karakterden uzun olamaz"),
        MONTHLY_INCOME_REQUIRED("Aylık gelir boş olamaz"),
        MONTHLY_INCOME_POSITIVE("Aylık gelir pozitif bir değer olmalıdır"),
        COMPANY_NAME_REQUIRED("Şirket adı boş olamaz"),
        COMPANY_NAME_SIZE("Şirket adı 100 karakterden uzun olamaz"),
        TAX_NUMBER_REQUIRED("Vergi numarası boş olamaz"),
        TAX_NUMBER_SIZE("Vergi numarası 10 haneli olmalıdır"),
        ANNUAL_REVENUE_REQUIRED("Yıllık ciro boş olamaz"),
        ANNUAL_REVENUE_POSITIVE("Yıllık ciro pozitif bir değer olmalıdır"),
        EMPLOYEE_COUNT_REQUIRED("Çalışan sayısı boş olamaz"),
        EMPLOYEE_COUNT_POSITIVE("Çalışan sayısı pozitif bir değer olmalıdır"),
        SECTOR_REQUIRED("Sektör boş olamaz"),
        SECTOR_SIZE("Sektör 50 karakterden uzun olamaz");

        private final String message;

        Validation(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum Exception {
        BUSINESS_RULE_VIOLATION("Business Rule Violation"),
        VALIDATION_RULE_VIOLATION("Validation Rule Violation"),
        VALIDATION_ERROR("Validation error(s)"),
        AUTHORIZATION_ERROR("Authorization Error"),
        UNAUTHORIZED("You are not authorized to perform this operation"),
        INTERNAL_SERVER_ERROR("Internal Server Error"),
        UNEXPECTED_ERROR("An unexpected error occurred"),
        RESOURCE_NOT_FOUND("Resource Not Found");

        private final String message;

        Exception(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
} 