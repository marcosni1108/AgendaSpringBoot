package com.springproject.error;

public class ResourcesNotFoundDetails extends ErrorDetails {

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourcesNotFoundDetails build() {
            ResourcesNotFoundDetails resourcesNotFoundDetails = new ResourcesNotFoundDetails();
            resourcesNotFoundDetails.setTitle(title);
            resourcesNotFoundDetails.setStatus(status);
            resourcesNotFoundDetails.setDetail(detail);
            resourcesNotFoundDetails.setTimestamp(timestamp);
            resourcesNotFoundDetails.setDeveloperMessage(developerMessage);
            return resourcesNotFoundDetails;
        }
    }
}
