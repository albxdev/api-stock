package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class ArticleInvalidArticleDataException extends RuntimeException {
    public ArticleInvalidArticleDataException() {
        super(Constants.ARTICLE_INVALID_DATA_MESSAGE);
    }
}
