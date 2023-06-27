package tech.example.service.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExceptionErrorCode {
    LOAN_ALREADY_GIVEN_EXCEPTION("loan-already-given", Category.BUSINESS),
    SOMETHING_WENT_WRONG("something-went-wrong", Category.TECHNICAL);


    private final String shortName;
    private final Category category;


    public String getShortName() {
        return shortName;
    }

    public Category getCategory() {
        return category;
    }

    @RequiredArgsConstructor
    public enum Category {
        BUSINESS("business"),
        TECHNICAL("technical");

        private final String shortName;

        public String getShortName() {
            return shortName;
        }
    }
}
