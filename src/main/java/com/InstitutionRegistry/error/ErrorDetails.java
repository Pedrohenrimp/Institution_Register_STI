package com.InstitutionRegistry.error;

public class ErrorDetails {
    private String title;
    private String detail;
    private String developerMessage;
    private int status;
    private long timestamp;


    public static final class ErrorDetailsBuilder {
        private String title;
        private String detail;
        private String developerMessage;
        private int status;
        private long timestamp;

        private ErrorDetailsBuilder() {
        }

        public static ErrorDetailsBuilder anErrorDetails() {
            return new ErrorDetailsBuilder();
        }

        public ErrorDetailsBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ErrorDetailsBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ErrorDetailsBuilder withDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ErrorDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public ErrorDetailsBuilder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.title = this.title;
            errorDetails.detail = this.detail;
            errorDetails.status = this.status;
            errorDetails.developerMessage = this.developerMessage;
            errorDetails.timestamp = this.timestamp;
            return errorDetails;
        }
    }
}
