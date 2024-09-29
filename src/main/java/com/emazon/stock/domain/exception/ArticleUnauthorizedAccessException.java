package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class ArticleUnauthorizedAccessException extends RuntimeException {
  public ArticleUnauthorizedAccessException() {
    super(Constants.ARTICLE_UNAUTHORIZED_ACCESS_MESSAGE);
  }
}