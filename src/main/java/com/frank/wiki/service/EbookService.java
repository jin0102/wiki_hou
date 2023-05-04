package com.frank.wiki.service;

import com.frank.wiki.domain.Ebook;
import com.frank.wiki.req.EbookReq;
import com.frank.wiki.resp.EbookResp;
import com.frank.wiki.resp.PageResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EbookService {
    public PageResp<EbookResp> getAll(EbookReq ebookReq);

    public List<EbookResp> getEbook(EbookReq ebookReq);
}
