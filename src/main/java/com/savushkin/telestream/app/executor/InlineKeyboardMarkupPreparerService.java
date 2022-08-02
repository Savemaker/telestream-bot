package com.savushkin.telestream.app.executor;

import com.savushkin.telestream.domain.telegram.InlineKeyboardMarkup;

public interface InlineKeyboardMarkupPreparerService {
    InlineKeyboardMarkup prepareInlineKeyboardMarkup(String url);
}
