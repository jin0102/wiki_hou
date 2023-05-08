package com.frank.wiki.service;

import com.frank.wiki.req.EbookQueryReq;
import com.frank.wiki.req.EbookSaveReq;
import com.frank.wiki.resp.EbookResp;
import com.frank.wiki.resp.PageResp;
import org.springframework.stereotype.Service;

@Service
public interface EbookService {
    public PageResp<EbookResp> getAll(EbookQueryReq ebookReq);

    public PageResp<EbookResp> getEbook(EbookQueryReq ebookReq);

    public void save(EbookSaveReq req);

    public void delete(Long id);
}
