package com.horizonbooks.domain.detalhe;

import java.util.List;

public class VolumeInfo {
        private String title;
        private List<String> authors;
        private String publisher;
        private String publishedDate;
        private String description;
        private List<IndustryIdentifier> industryIdentifiers;
        private int pageCount;
        private String mainCategory;
        private List<String> categories;
        private double averageRating;
        private int ratingsCount;
        private String contentVersion;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public List<String> getAuthors() {
                return authors;
        }

        public void setAuthors(List<String> authors) {
                this.authors = authors;
        }

        public String getPublisher() {
                return publisher;
        }

        public void setPublisher(String publisher) {
                this.publisher = publisher;
        }

        public String getPublishedDate() {
                return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
                this.publishedDate = publishedDate;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public List<IndustryIdentifier> getIndustryIdentifiers() {
                return industryIdentifiers;
        }

        public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
                this.industryIdentifiers = industryIdentifiers;
        }

        public int getPageCount() {
                return pageCount;
        }

        public void setPageCount(int pageCount) {
                this.pageCount = pageCount;
        }

        public String getMainCategory() {
                return mainCategory;
        }

        public void setMainCategory(String mainCategory) {
                this.mainCategory = mainCategory;
        }

        public List<String> getCategories() {
                return categories;
        }

        public void setCategories(List<String> categories) {
                this.categories = categories;
        }

        public double getAverageRating() {
                return averageRating;
        }

        public void setAverageRating(double averageRating) {
                this.averageRating = averageRating;
        }

        public int getRatingsCount() {
                return ratingsCount;
        }

        public void setRatingsCount(int ratingsCount) {
                this.ratingsCount = ratingsCount;
        }

        public String getContentVersion() {
                return contentVersion;
        }

        public void setContentVersion(String contentVersion) {
                this.contentVersion = contentVersion;
        }
}