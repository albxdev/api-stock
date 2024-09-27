package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class ArticleAlreadyExistsException extends RuntimeException {
    public ArticleAlreadyExistsException() {
        super(Constants.ARTICLE_ALREADY_EXISTS_MESSAGE);
    }
}
