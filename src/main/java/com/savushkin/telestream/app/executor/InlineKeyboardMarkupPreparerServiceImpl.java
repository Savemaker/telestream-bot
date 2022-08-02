package com.savushkin.telestream.app.executor;

import com.savushkin.telestream.domain.telegram.InlineKeyboardButton;
import com.savushkin.telestream.domain.telegram.InlineKeyboardMarkup;
import com.savushkin.telestream.domain.telegram.WebAppInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InlineKeyboardMarkupPreparerServiceImpl implements InlineKeyboardMarkupPreparerService {
    @Override
    public InlineKeyboardMarkup prepareInlineKeyboardMarkup(String url) {
        List<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButtons.add(new InlineKeyboardButton("Open player", new WebAppInfo(url)));
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        list.add(inlineKeyboardButtons);
        return new InlineKeyboardMarkup(list);
    }
}
