package com.springproject.error;

import lombok.Getter;

public class ResourcesNotFoundDetails {
    @Getter
    private String title;
    @Getter
    private int status;
    @Getter
    private String detail;
    @Getter
    private Long timestamp;
    @Getter
    private String developerMessage;

    private ResourcesNotFoundDetails() {
    }

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
            resourcesNotFoundDetails.title = this.title;
            resourcesNotFoundDetails.status = this.status;
            resourcesNotFoundDetails.detail = this.detail;
            resourcesNotFoundDetails.timestamp = this.timestamp;
            resourcesNotFoundDetails.developerMessage = this.developerMessage;
            return resourcesNotFoundDetails;
        }
    }
}
